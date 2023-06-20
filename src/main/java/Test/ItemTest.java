package Test;
import cn.edu.whut.sept.zuul.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("测试物品", "这是一个测试物品", 1, false);
    }

    @Test
    void getName() {
        String expectedName = "测试物品";
        String actualName = item.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    void getDescription() {
        String expectedDescription = "这是一个测试物品";
        String actualDescription = item.getDescription();
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void getWeight() {
        int expectedWeight = 1;
        int actualWeight = item.getWeight();
        assertEquals(expectedWeight, actualWeight);
    }

    @Test
    void getCanEat() {
        boolean expectedCanEat = false;
        boolean actualCanEat = item.getcanEat();
        assertEquals(expectedCanEat, actualCanEat);
    }
}


