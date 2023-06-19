import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.Monster;
import cn.edu.whut.sept.zuul.Player;
import cn.edu.whut.sept.zuul.Room;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerTest {
    private Room outside;
    private Room hallway;
    private Room livingRoom;
    private Item sword;
    private Item armor;
    private Item magicCookie;
    private Player player;

    @BeforeEach
    public void setup() {
        outside = new Room("外面");
        hallway = new Room("走廊");
        livingRoom = new Room("客厅");

        outside.setExit("east", hallway);
        hallway.setExit("west", outside);
        hallway.setExit("east", livingRoom);
        livingRoom.setExit("west", hallway);

        sword = new Item("长剑", "一把锋利的剑", 5, false);
        armor = new Item("铠甲", "一套坚固的盔甲", 10, false);
        magicCookie = new Item("魔法饼干", "一块神奇的饼干", 1, true);

        livingRoom.addItem(sword);
        livingRoom.addItem(armor);
        livingRoom.addItem(magicCookie);

        player = Player.getPlayer();
        player.setCurrentRoom(outside);
    }

    @Test
    public void testEnterRoomAndGetDescription() {
        player.enterRoom(outside);
        String expectedDescription = "你正在外面.\n出口: east";
        Assertions.assertEquals(expectedDescription, player.getCurrentRoom().getDescription());
    }

    @Test
    public void testGetRoomItems() {
        player.enterRoom(livingRoom);
        List<Item> roomItems = player.getCurrentRoom().getRoomItems();
        Assertions.assertTrue(roomItems.contains(sword));
        Assertions.assertTrue(roomItems.contains(armor));
        Assertions.assertTrue(roomItems.contains(magicCookie));
    }

    @Test
    public void testAddItemAndRemoveItem() {
        player.addItem(sword);
        player.addItem(armor);
        List<Item> playerItems = player.getPlayerItems();
        Assertions.assertTrue(playerItems.contains(sword));
        Assertions.assertTrue(playerItems.contains(armor));

        player.removeItem(armor);
        playerItems = player.getPlayerItems();
        Assertions.assertFalse(playerItems.contains(armor));
    }

    @Test
    public void testEatItemAndGetLoad() {
        player.addItem(magicCookie);
        player.eatItem(magicCookie);
        int expectedLoad = 11;
        Assertions.assertEquals(expectedLoad, player.getCarryingCapacity());
    }
}
