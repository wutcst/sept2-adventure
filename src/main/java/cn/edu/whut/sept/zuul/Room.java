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
    private String description;     // 房间描述
    private HashMap<String, Room> exits;        // 出口信息.

    private List<Item> items;       // 物件列表

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

    private String getExitString()
    {
        String returnString = "出口:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
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
    public List<Item> getItems() {
        return items;
    }


}


