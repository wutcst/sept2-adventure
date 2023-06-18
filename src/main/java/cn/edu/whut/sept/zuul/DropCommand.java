package cn.edu.whut.sept.zuul;

import java.util.List;
public class DropCommand extends Command {

    @Override
    public boolean execute(Game game) {
        if (game.getPlayer() != null) {
            Player player = game.getPlayer();
            Room currentRoom = player.getCurrentRoom();

            if (!hasSecondWord()) {
                System.out.println("丢弃什么物品？");
                return false;
            }

            String itemToDrop = getSecondWord();
            List<Item> playerItems = player.getInventory();
            Item item = null;

            for (Item playerItem : playerItems) {
                if (playerItem.getName().equalsIgnoreCase(itemToDrop)) {
                    item = playerItem;
                    break;
                }
            }

            if (item == null) {
                System.out.println("你没有该物品。");
                return false;
            }

            // 从玩家的物品列表中移除物品，加入当前房间的物品列表
            player.removeItem(item);
            currentRoom.addItem(item);
            int totalWeight = player.getCurrentLoad() - item.getWeight();
            player.setCurrentLoad(totalWeight);
            System.out.println("你丢弃了物品：" + item.getName());
        }

        return false;
    }
}
