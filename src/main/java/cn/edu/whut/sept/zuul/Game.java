/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */
package cn.edu.whut.sept.zuul;
/**
 * 表示游戏的主类
 */
public class Game
{
    private Parser parser;// 命令解析器
    private Room currentRoom;// 当前所在房间
    /**
     * 创建游戏对象并初始化房间和解析器
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
    }
    /**
     * 创建游戏中的房间
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;

        // 创建房间对象
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // 初始化房间的出口
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        // 设置初始房间
        currentRoom = outside;  // start game outside
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
                System.out.println("I don't understand...");
            } else {
                finished = command.execute(this);
            }
        }

        System.out.println("Thank you for playing.  Good bye.");
    }
    /**
     * 打印欢迎信息
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * 切换到指定房间
     *
     * @param room 指定房间
     */
    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
}