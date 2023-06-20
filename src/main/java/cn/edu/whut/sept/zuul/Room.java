/**
 *房间类维护了房间描述字段以及房间出口信息
 *该类提供了访问、修改这两个字段的接口
 * 拓展思路：
 * 为Room类添加一个items字段，用于存储房间内的物品。每个物品可以定义为一个Item类，其中包括描述和重量属性。
 * 在Room类中添加方法来管理物品，例如addItem和removeItem，用于在房间中添加和移除物品。
 * 在Room类中添加方法来获取房间内的所有物品和总重量。
 * 在Room类中添加方法来生成房间的详细描述时包括物品信息。
 * Room类中随机生成一个魔法饼干物品，并在Game类的processCommand方法中处理eat cookie命令，增加玩家的负重能力。
 *
 * @author zhj
 * @version 1.0
 */

package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.HashMap;




public class Room
{
    private final String description;     // 房间描述
    private final HashMap<String, Room> exits;        // 出口信息.
    private final List<Item> items;       // 物件列表
    private final HashMap<String, Monster> monsters;     // 怪物列表
    private boolean isTeleportRooms;    //是否为随机传送房间标识符

    /**
     * 拷贝复制函数
     *
     * @param other 使用另一个房间类来创建房间副本
     */
    public Room(Room other) {
        this.description = other.description;
        this.exits = new HashMap<>(other.exits);
        this.items = new ArrayList<>(other.items);
        this.monsters = new HashMap<>(other.monsters);
        this.isTeleportRooms = other.isTeleportRooms;
    }

    /**
     * 创建一个新房间
     *
     * @param description 房间描述
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
        monsters = new HashMap<>();
        isTeleportRooms=false;
    }

    /**
     * 设置房间的出口
     *
     * @param direction 出口的方向
     * @param neighbor  相邻房间的引用
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * 获取房间的描述
     *
     * @return 房间的描述
     */
    public String getDescription()
    {
        return "你正在" + description + ".\n" + getExitString();
    }

    /**
     * 获取房间的出口
     *
     * @return 房间的出口
     */
    private String getExitString()
    {
        String returnString;
        Set<String> keys = exits.keySet();
        StringBuilder sb = new StringBuilder();
        sb.append("出口:");
        for (String exit : keys) {
            sb.append(" ").append(exit);
        }
        returnString = sb.toString();
        return returnString;
    }

    /**
     * 获取指定方向上的出口
     *
     * @param direction 出口的方向
     * @return 相邻房间的引用，如果没有出口则返回null
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * 向房间添加物件
     *
     * @param item 要添加的物件
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * 从房间移除物件
     *
     * @param item 要移除的物件
     */
    public void removeItem(Item item) {
        items.remove(item);
    }


    /**
     * 获取房间的物品列表
     *
     * @return items 返回物品列表
     */

    public List<Item> getRoomItems() {
        return new ArrayList<>(items);
    }

    /**
     * 房间内添加怪物，并设置怪物位置
     *
     * @param direction 怪物所在位置
     * @param monster  怪物
     */
    public void addMonster(String direction, Monster monster)
    {
        monsters.put(direction, monster);
    }

    /**
     * 房间内移除怪物
     *
     * @param direction 怪物所在位置
     */
    public void removeMonster(String direction)
    {
        monsters.remove(direction);
    }

    /**
     * 获取房间的怪物列表
     *
     * @return monsters 返回怪物列表
     */
    public HashMap<String, Monster> getMonsters() {
        return new HashMap<>(monsters);
    }

    /**
     * 设置房间是否为随机传送房间
     *
     * @param isTeleportRooms 随机传送标识
     */
    public void setTeleportRooms(boolean isTeleportRooms)
    {
        this.isTeleportRooms = isTeleportRooms;
        System.out.println("设置成功！");
    }

    /**
     * 获取房间的随机传送标识符
     *
     * @return  isTeleportRooms 随机传送标识
     */
    public boolean getTeleportRooms()
    {
        return isTeleportRooms;
    }


}


