package cn.edu.whut.sept.zuul;

import java.util.List;

public class ItemsCommand extends Command {
    @Override
    public boolean execute(Game game) {
        // 获取当前房间和玩家对象
        Room currentRoom = game.getPlayer().getCurrentRoom();
        Player player = game.getPlayer();

        // 打印当前房间内的物品及总重量
        System.out.println("当前房间拥有物品:");
        printItems(currentRoom.getItems());
        System.out.println("物品总重量为: " + getTotalWeight(currentRoom.getItems()));

        // 打印玩家随身携带的物品及总重量
        System.out.println("玩家携带物品:");
        printItems(player.getInventory());
        System.out.println("总重量为： " + getTotalWeight(player.getInventory()));

        return false;
    }

    private void printItems(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.getName() + " - " + item.getDescription());
        }
    }

    private int getTotalWeight(List<Item> items) {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}