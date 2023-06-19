package cn.edu.whut.sept.zuul;

import java.util.ArrayList;
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

            if(itemToDrop.equals("all")){
                if (playerItems.isEmpty()) {
                    System.out.println("你身上没有任何物品。");
                    return false;
                }
                ArrayList<Item> itemsToDrop = new ArrayList<>(playerItems);
                for (Item playerItem : itemsToDrop) {
                    currentRoom.addItem(playerItem);
                    player.removeItem(playerItem);
                    System.out.println("你丢弃了物品：" + playerItem.getName());
                }
                System.out.println("你当前负重："+player.getCurrentLoad());
            }
            else{
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
                System.out.println("你丢弃了物品：" + item.getName());
                System.out.println("你当前负重："+player.getCurrentLoad());
            }

        }

        return false;
    }
}