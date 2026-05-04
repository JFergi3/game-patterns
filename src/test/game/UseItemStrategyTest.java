package test.game;

import game.GameManager;
import game.Player;
import game.Room;
import game.assets.Key;
import game.strategies.UseItemStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseItemStrategyTest {

    @Test
    public void playerWinsWhenUsingKeyInExitRoom() {
        GameManager manager = GameManager.getInstance();

        Player player = new Player("Player One");
        Room exit = new Room("Exit", "A locked exit door.");
        player.setCurrentRoom(exit);
        player.addAsset(new Key());

        manager.setPlayer(player);

        UseItemStrategy strategy = new UseItemStrategy("key");
        strategy.execute(player);

        assertFalse(manager.isGameRunning());
    }
}