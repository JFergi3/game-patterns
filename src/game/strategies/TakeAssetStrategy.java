package game.strategies;

import game.GameManager;
import game.Player;
import game.Room;
import game.assets.Asset;

public class TakeAssetStrategy implements ActionStrategy {
    private String assetName;

    public TakeAssetStrategy(String assetName) {
        this.assetName = assetName;
    }

    @Override
    public void execute(Player player) {
        Room room = player.getCurrentRoom();

        for (Asset asset : room.getAssets()) {
            if (asset.getName().equalsIgnoreCase(assetName)) {
                player.addAsset(asset);
                room.removeAsset(asset);
                System.out.println("You picked up: " + asset.getName());
                GameManager.getInstance().notifyListeners("Player picked up " + asset.getName());
                return;
            }
        }

        System.out.println("That item is not in this room.");
    }
}