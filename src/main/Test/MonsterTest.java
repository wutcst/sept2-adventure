import cn.edu.whut.sept.zuul.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterTest {

    private Monster monster;

    @BeforeEach
    public void setUp() {
        monster = new Monster("Dragon", 100, 20, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Dragon", monster.getName());
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, monster.getHealth());
    }

    @Test
    public void testGetAttack() {
        assertEquals(20, monster.getAttack());
    }

    @Test
    public void testGetDefense() {
        assertEquals(10, monster.getDefense());
    }

    @Test
    public void testSetName() {
        monster.setName("Goblin");
        assertEquals("Goblin", monster.getName());
    }

    @Test
    public void testSetHealth() {
        monster.setHealth(200);
        assertEquals(200, monster.getHealth());
    }
}
