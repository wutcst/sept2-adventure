package cn.edu.whut.sept.zuul;

import java.util.List;

public class TakeCommand extends Command {

    @Override
    public boolean execute(Game game) {
        if (game.getPlayer() != null) {
            Player player = game.getPlayer();
            Room currentRoom = game.getCurrentRoom();

            if (!hasSecondWord()) {
                System.out.println("拾取什么物品？");
                return false;
            }

            String itemToTake = getSecondWord();
            List<Item> roomItems = currentRoom.getItems();
            Item item = null;

            for (Item roomItem : roomItems) {
                if (roomItem.getName().equalsIgnoreCase(itemToTake)) {
                    item = roomItem;
                    break;
                }
            }

            if (item == null) {
                System.out.println("房间内没有该物品。");
                return false;
            }

            int totalWeight = player.getCurrentLoad() + item.getWeight();
            if (totalWeight > player.getCarryingCapacity()) {
                System.out.println("物品太重，无法携带。");
                return false;
            }

            // 从房间中移除物品，加入玩家的物品列表
            currentRoom.removeItem(item);
            player.addItem(item);
            player.setCurrentLoad(totalWeight);
            System.out.println("你拾取了物品：" + item.getName());
        }

        return false;
    }
}