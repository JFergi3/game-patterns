package game.factories;

import game.assets.*;

public class AssetFactory {

    public Asset createAsset(String type) {
        return switch (type.toLowerCase()){
          case "key" -> new Key();
          case "coin" -> new Coin();
          case "lantern" -> new Lantern();
            default -> throw new IllegalArgumentException("Unknown asset type: " + type);
        };
    }
}
