import cn.edu.whut.sept.zuul.Game;
import cn.edu.whut.sept.zuul.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void getPlayer() {
        Player player = Player.getPlayer();
        assertNotNull(player);
    }

    @Test
    void setWin() {
        game.setWin();
        assertTrue(game.getIsWin());
    }

    @Test
    void setFail() {
        game.setFail();
        assertTrue(game.getIsFail());
    }
}
