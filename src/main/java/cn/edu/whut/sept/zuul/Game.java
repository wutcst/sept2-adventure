/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 * 拓展思路：
 * 新建一个Player类
 * 在Player类中添加方法来管理携带的物品，例如carryItem和dropItem，用于添加和丢弃物品。
 * 在Player类中添加方法来获取玩家携带的所有物品和总重量。
 * Game类中，添加一个Player对象来表示玩家。Player类可以包含姓名、当前所在房间和携带物品等属性。
 * 在Game类的processCommand方法中，根据用户输入的命令调用相应的方法来处理take和drop命令。
 * 在Game类的printHelp方法中，显示新添加的命令（例如take，drop和items）。
 *
 * @author  zhj
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;
/**
 * 表示游戏的主类
 */
public class Game
{
    private Parser parser;// 命令解析器
    private Player link; //游戏玩家
    private boolean isWin;//游戏胜利标识符
    private boolean isFail;//游戏失败标识符
    /**
     * 创建游戏对象并初始化房间和解析器
     */
    public Game()
    {
        createGame();
        parser = new Parser();
        isWin=false;
        isFail=false;
    }

    /**
     * 获取玩家
     * @return Player
     */
     public Player getPlayer()
     {
         return link;
     }
    /**
     * 创建游戏中的房间
     */
    private void createGame()
    {
        Room outside, theater, pub, lab, office,exit;

        // 创建怪物
        Monster monsterCommonA=new Monster("普通怪物",6,3,0);
        Monster monsterCommonB=new Monster("普通怪物",6,3,0);
        Monster monsterBOOS=new Monster("精英怪物",20,5,0);

        // 创建物品
        Item Sword=new Item("长剑","一般的文字冒险游戏可用不上这个...",3,false);
        Item armor=new Item("铠甲","你无坚不摧啦！",4,false);
        Item key=new Item("钥匙","一把钥匙，猜猜它能打开哪儿？",1,false);
        Item stone=new Item("石头","这只是一块普通的石头。",1,false);
        Item apple=new Item("苹果","这苹果看上去味道不错。",1,true);
        Item magicCookie=new Item("魔法饼干","这块饼干似乎能改善你的体质。",1,true);



        // 创建房间对象
        outside = new Room("大学正门外");
        theater = new Room("在演讲厅");
        pub = new Room("在校园酒吧");
        lab = new Room("在计算实验室");
        office = new Room("在计算管理办公室");
        exit=new Room("在一个有传送门的房间！");

        // 初始化房间的出口
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        office.setExit("east",exit);

        //初始化房间的物品
        outside.addItem(Sword);
        outside.addItem(key);
        outside.addItem(apple);
        outside.addItem(magicCookie);

        theater.addItem(armor);
        theater.addItem(key);

        pub.addItem(stone);

        lab.addItem(armor);

        office.addItem(Sword);
        office.addItem(stone);

        //初始化怪物位置
        outside.addMonster("west",monsterCommonA);
        lab.addMonster("east",monsterCommonB);
        office.addMonster("east",monsterBOOS);

        // 创建玩家
        link=Player.getPlayer();

        //设置初始房间
        link.setCurrentRoom(outside);
    }
    /**
     * 游戏的主循环，不断读取用户输入并执行命令
     */
    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        // 游戏循环
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            if(command == null) {
                System.out.println("我不理解...");
            } else {
                finished = command.execute(this);
            }
            if(isWin){
                System.out.println("游戏胜利！");
            }
            if(isFail){
                System.out.println("游戏失败！");
            }
        }

        System.out.println("感谢游玩，再见！");
    }
    /**
     * 打印欢迎信息
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("欢迎来到 World of Zuul!");
        System.out.println("World of Zuul 是一款全新的、令人难以置信的无聊冒险游戏。");
        System.out.println("如果需要帮助，请键入“help”。");
        System.out.println();
        System.out.println(getPlayer().getCurrentRoom().getDescription());
    }

    /**
     * 设置游戏胜利
     *
     */
    public void setWin(){
        this.isWin = true;
    }

    /**
     * 设置游戏失败
     *
     */
    public void setFail(){
        this.isFail = true;
    }

}