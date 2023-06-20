import cn.edu.whut.sept.zuul.Item;
import cn.edu.whut.sept.zuul.Monster;
import cn.edu.whut.sept.zuul.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room("测试房间");
    }

    @Test
    void getDescription() {
        String expectedDescription = "你正在测试房间.\n出口:";
        String actualDescription = room.getDescription();
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void setExit() {
        Room neighbor = new Room("相邻房间");
        room.setExit("east", neighbor);
        Room actualNeighbor = room.getExit("east");
        assertEquals(neighbor, actualNeighbor);
    }

    @Test
    void addItem() {
        Item item = new Item("测试物品", "这是一个测试物品", 1, false);
        room.addItem(item);
        List<Item> roomItems = room.getRoomItems();
        assertTrue(roomItems.contains(item));
    }

    @Test
    void removeItem() {
        Item item = new Item("测试物品", "这是一个测试物品", 1, false);
        room.addItem(item);
        room.removeItem(item);
        List<Item> roomItems = room.getRoomItems();
        assertFalse(roomItems.contains(item));
    }

    @Test
    void addMonster() {
        Monster monster = new Monster("测试怪物", 10, 5, 0);
        room.addMonster("north", monster);
        assertTrue(room.getMonsters().containsKey("north"));
        assertEquals(monster, room.getMonsters().get("north"));
    }

    @Test
    void removeMonster() {
        Monster monster = new Monster("测试怪物", 10, 5, 0);
        room.addMonster("north", monster);
        room.removeMonster("north");
        assertFalse(room.getMonsters().containsKey("north"));
        assertNull(room.getMonsters().get("north"));
    }
}
