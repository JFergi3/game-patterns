package test.game;

import game.Player;
import game.assets.Key;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void playerCanAddAssetToInventory() {
        Player player = new Player("Player One");

        player.addAsset(new Key());

        assertTrue(player.hasAsset("key"));
    }
}
