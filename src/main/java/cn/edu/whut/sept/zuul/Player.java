/**
 * 表表示游戏中的玩家类（单例模式）
 *
 * @author zhj
 * @version 1.1
 */
package cn.edu.whut.sept.zuul;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Player {
    private static Player player; // 单例实例
    private String name; // 玩家姓名
    private int health;  // 血量
    private int attack;  // 攻击力
    private int defense; // 防御力
    private Room currentRoom; // 玩家当前所在的房间
    private Stack<Room> roomStack;  // 玩家经过的房间
    private int carryingCapacity; // 玩家负重能力
    private int currentLoad; // 玩家当前负重
    private List<Item> items; // 玩家携带的物品列表

    /**
     * 获取Player类的单例实例
     *
     * @return Player类的单例实例
     */
    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
            player.setName("link");
            player.health=10;
            player.attack=2;
            player.defense=0;
            player.setCarryingCapacity(10);
            player.setCurrentLoad(0);
            player.roomStack = new Stack<>();
            player.items = new ArrayList<>();

        }
        return player;
    }

    /**
     * 私有构造函数，确保只能通过getInstance()方法获取实例
     */
    private Player() {
    }

    /**
     * 获取玩家姓名
     * @return 玩家姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置玩家姓名
     * @param name 玩家姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取玩家当前所在的房间
     * @return 玩家当前所在的房间
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * 设置玩家当前所在的房间
     * @param currentRoom 玩家当前所在的房间
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * 进入新的房间
     * @param room 玩家将要进入的房间
     */
    public void enterRoom(Room room) {
        roomStack.push(currentRoom);
        currentRoom = room;
    }

    /**
     * 回到上一个房间
     */
    // 回到上一个房间
    public boolean goBack() {
        if(roomStack.empty()){
            System.out.println("你已经回到了起点！");
        }
        else{
            currentRoom = roomStack.pop();
            System.out.println(currentRoom.getDescription());
        }
        return false;
    }

    /**
     * 获取玩家的负重能力
     * @return 玩家的负重能力
     */
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * 设置玩家的负重能力
     * @param carryingCapacity 玩家的负重能力
     */
    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    /**
     * 获取玩家当前负重
     * @return 玩家当前负重
     */
    public int getCurrentLoad() {
        return currentLoad;
    }

    /**
     * 设置玩家当前负重
     * @param currentLoad 玩家当前负重
     */
    public void setCurrentLoad(int currentLoad) {
        this.currentLoad = currentLoad;
    }

    /**
     * 获取玩家携带的物品列表
     * @return 玩家携带的物品列表
     */
    public List<Item> getPlayerItems() {
        return items;
    }

    /**
     * 添加物品到玩家的携带物品列表
     * @param item 要添加的物品
     */
    public void addItem(Item item) {
        items.add(item);
        currentLoad += item.getWeight();
        if(item.getName().equals("长剑")){
            this.attack+=3;
        }
        else if(item.getName().equals("铠甲")){
            this.defense+=3;
        }
    }

    /**
     * 从玩家的携带物品列表中移除物品
     * @param item 要移除的物品
     */
    public void removeItem(Item item) {
        items.remove(item);
        currentLoad -= item.getWeight();
        if(item.getName().equals("长剑")){
            this.attack-=3;
        }
        else if(item.getName().equals("铠甲")){
            this.defense-=3;
        }
    }

    /**
     * 玩家与怪物交战逻辑判断
     * @return 玩家血量
     */
    public boolean fight(Monster monster){
        System.out.println("你与怪物发生了交战！！！");
        display();
        monster.display();
        while(player.health>0 && monster.getHealth()>0){
            player.health-= monster.getAttack()-player.defense;
            monster.setHealth(getHealth()-player.attack+ monster.getDefense());
            player.displayHealth();
            monster.displayHealth();
            System.out.println();
        }
        return player.health>0;
    }

    /**
     * 获取玩家血量
     * @return 玩家血量
     */
    public int getHealth() {
        return health;
    }

    /**
     * 获取玩家攻击力
     * @return 玩家攻击力
     */
    public int getAttack() {
        return attack;
    }

    /**
     * 获取玩家防御力
     * @return 玩家防御力
     */
    public int getDefense() {
        return defense;
    }

    public void display(){
        System.out.println("link属性——当前血量："+this.health+" 攻击力："+this.attack+" 防御力："+this.defense);
    }

    public void displayHealth(){
        System.out.print("link-当前血量："+health+"         ");
    }

    public void displayLoad(){
        System.out.println("link——当前负重上限："+carryingCapacity);
    }
    /**
     * 获取玩家的物品列表
     *
     * @return items 返回物品列表
     */
    public List<Item> getItems() {return items;}

    /**
     * 玩家食用物品
     *
     * @param  item 要食用的物品
     */
    public void eatItem(Item item) {
        if (item.getcanEat()) {
            items.remove(item);
            currentLoad -= item.getWeight();
            System.out.println("你吃掉了 " + item.getName() + ".");
            if(item.getName().equals("魔法饼干")){
                this.carryingCapacity+=1;
                System.out.println("你的负重上限+1 ！");
            }
            if(item.getName().equals("苹果")){
                this.health=this.health+5>10?10:this.health+5;     //生命上限为10
                System.out.println("你的血量+5 ！");
            }
        } else {
            System.out.println("你无法食用 " + item.getName() + ".");
        }
    }

}