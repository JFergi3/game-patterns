package test.game;

import game.GameManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameManagerTest {

    @Test
    public void gameManagerReturnsSameInstance() {
        GameManager first = GameManager.getInstance();
        GameManager second = GameManager.getInstance();

        assertSame(first, second);
    }
}