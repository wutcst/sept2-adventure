package cn.edu.whut.sept.zuul;

import java.util.List;

public class EatCommand extends Command {
    @Override
    public boolean execute(Game game) {
        Player player = Player.getPlayer();
        String secondWord = getSecondWord();

        if (secondWord == null) {
            System.out.println("吃什么?");
        } else {
            List<Item> playerItems = player.getPlayerItems();
            Item item = null;
            for (Item playerItem : playerItems) {
                if (playerItem.getName().equalsIgnoreCase(secondWord)) {
                    item = playerItem;
                    break;
                }
            }

            if (item != null) {
                player.eatItem(item);
            } else {
                System.out.println("你没有 " + secondWord + ".");
            }
        }

        return false;
    }

}
