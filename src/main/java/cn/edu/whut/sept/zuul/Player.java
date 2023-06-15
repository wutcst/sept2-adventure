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
    private Room currentRoom; // 玩家当前所在的房间
    private Stack<Room> roomStack;  // 玩家经过的房间
    private int carryingCapacity; // 玩家负重能力
    private int currentLoad; // 玩家当前负重
    private List<Item> inventory; // 玩家携带的物品列表

    /**
     * 获取Player类的单例实例
     *
     * @return Player类的单例实例
     */
    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
            player.setName("link");
            player.setCarryingCapacity(10);
            player.setCurrentLoad(0);
            player.roomStack = new Stack<>();
            player.inventory = new ArrayList<>();

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
            System.out.println(currentRoom.getLongDescription());
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
    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * 添加物品到玩家的携带物品列表
     * @param item 要添加的物品
     */
    public void addItem(Item item) {
        inventory.add(item);
        currentLoad += item.getWeight();
    }

    /**
     * 从玩家的携带物品列表中移除物品
     * @param item 要移除的物品
     */
    public void removeItem(Item item) {
        inventory.remove(item);
        currentLoad -= item.getWeight();
    }
}