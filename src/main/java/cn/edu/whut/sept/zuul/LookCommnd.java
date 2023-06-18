package cn.edu.whut.sept.zuul;

import java.util.List;

public class LookCommnd extends Command {
        public boolean execute(Game game) {
            Room currentRoom = game.getPlayer().getCurrentRoom();

            // 显示当前房间的描述
            System.out.println(currentRoom.getDescription());

            // 显示房间内的物品信息
            List<Item> items = currentRoom.getItems();
            if (items.isEmpty()) {
                System.out.println("房间里没有物品。");
            } else {
                System.out.println("房间里的物品有:");
                for (Item item : items) {
                    System.out.println(item.getName() + "- " + item.getDescription() + "，重量：" + item.getWeight());
                }
            }

            return false;
    }
}
