package game.strategies;

import game.Player;
import game.Room;
import game.assets.Asset;

public class SearchStrategy implements ActionStrategy {

    @Override
    public void execute(Player player) {
        Room room = player.getCurrentRoom();

        System.out.println("You search the room...");

        if (room.getAssets().isEmpty()) {
            System.out.println("There is nothing useful here.");
        } else {
            for (Asset asset : room.getAssets()) {
                System.out.println("You found: " + asset.getName());
            }
        }
    }
}