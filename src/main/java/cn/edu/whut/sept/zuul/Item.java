/**
 * 表示游戏中的物品类
 *
 * @author zhj
 * @version 1.1
 */

package cn.edu.whut.sept.zuul;

public class Item {
    private final String name; // 物品名称
    private final String description; // 物品描述
    private final int weight; // 物品重量

    private final boolean canEat; // 物品是否可食用

    /**
     * 构造函数
     *
     * @param name        物品名称
     * @param description 物品描述
     * @param weight      物品重量
     */
    public Item(String name, String description, int weight,boolean canEat) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.canEat = canEat;
    }

    /**
     * 获取物品名称
     *
     * @return 物品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 获取物品描述
     *
     * @return 物品描述
     */
    public String getDescription() {
        return description;
    }


    /**
     * 获取物品重量
     *
     * @return 物品重量
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 获取物品是否可食用
     *
     * @return 是否可食用
     */
    public boolean getcanEat() {
        return canEat;
    }

}
