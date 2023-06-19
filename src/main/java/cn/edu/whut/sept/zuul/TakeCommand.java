package cn.edu.whut.sept.zuul;

import java.util.List;
import java.util.ArrayList;

public class TakeCommand extends Command {

    @Override
    public boolean execute(Game game) {
        if (game.getPlayer() != null) {
            Player player = game.getPlayer();
            Room currentRoom = player.getCurrentRoom();

            if (!hasSecondWord()) {
                System.out.println("拾取什么物品？");
                return false;
            }

            String itemToTake = getSecondWord();
            List<Item> roomItems = currentRoom.getRoomItems();

            if(itemToTake.equals("all")){
                if (roomItems.isEmpty()) {
                    System.out.println("房间内没有该物品。");
                    return false;
                }
                ArrayList<Item> itemsToTake = new ArrayList<>(roomItems);
                for (Item roomItem : itemsToTake) {
                    if(player.getCurrentLoad()+roomItem.getWeight()> player.getCarryingCapacity()){
                        System.out.println(roomItem.getName()+"过重，已超出负重上限。");
                    }
                    else{
                        currentRoom.removeItem(roomItem);
                        player.addItem(roomItem);
                        System.out.println("你拾取了物品：" + roomItem.getName());
                    }
                }
                System.out.println("你当前负重："+player.getCurrentLoad());
            }
            else{
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

                if (player.getCurrentLoad()+item.getWeight() > player.getCarryingCapacity()) {
                    System.out.println("物品太重，无法携带。");
                    return false;
                }

                // 从房间中移除物品，加入玩家的物品列表
                currentRoom.removeItem(item);
                player.addItem(item);
                System.out.println("你拾取了物品：" + item.getName());
                System.out.println("你当前负重："+player.getCurrentLoad());
            }

        }

        return false;
    }
}