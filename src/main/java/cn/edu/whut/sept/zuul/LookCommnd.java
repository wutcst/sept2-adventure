package cn.edu.whut.sept.zuul;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LookCommnd extends Command {
        public boolean execute(Game game) {
            Room currentRoom = game.getPlayer().getCurrentRoom();

            // 显示当前房间的描述
            System.out.println(currentRoom.getDescription());

            // 显示房间内的物品信息
            List<Item> items = currentRoom.getRoomItems();
            if (items.isEmpty()) {
                System.out.println("房间里没有物品。");
            } else {
                System.out.println("房间里的物品有:");
                for (Item item : items) {
                    System.out.println(item.getName() + "- " + item.getDescription() + "  重量：" + item.getWeight());
                }
            }
            System.out.println("");
            //显示怪物信息
            HashMap<String, Monster> monsters=currentRoom.getMonsters();
            if (monsters.isEmpty()) {
                System.out.println("房间里没有怪物。");
            } else {
                for (Map.Entry<String, Monster> entry : monsters.entrySet()) {
                    String direction=entry.getKey();
                    Monster monster=entry.getValue();
                    System.out.println("小心了！房间"+direction+"方向有只"+monster.getName()+"正对你虎视眈眈！");
                    monster.display();
                }
            }

            System.out.println("");
            game.getPlayer().display();

            return false;
    }
}