package test.game;

import game.assets.Asset;
import game.factories.AssetFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssetFactoryTest {

    @Test
    public void createAssetReturnsKeyWhenTypeIsKey() {
        AssetFactory factory = new AssetFactory();

        Asset asset = factory.createAsset("key");

        assertEquals("Key", asset.getName());
    }

    @Test
    public void createAssetThrowsErrorForUnknownType() {
        AssetFactory factory = new AssetFactory();

        assertThrows(IllegalArgumentException.class, () -> {
            factory.createAsset("banana");
        });
    }
}