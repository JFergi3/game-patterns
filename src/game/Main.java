package game;

import game.assets.Asset;
import game.factories.AssetFactory;
import game.observers.ConsoleNotifier;
import game.observers.AchievementTracker;

public class Main {
    public static void main(String[] args) {

        AssetFactory factory = new AssetFactory();

        Room entrance = new Room("Entrance", "You are standing at the entrance.");
        Room hallway = new Room("Hallway", "A long dark hallway.");

        entrance.addExit("north", hallway);
        hallway.addExit("south", entrance);

        Asset key = factory.createAsset("key");
        entrance.addAsset(key);

        Player player = new Player("Player One");
        player.setCurrentRoom(entrance);

        GameManager.getInstance().setPlayer(player);
        GameManager.getInstance().addListener(new ConsoleNotifier());
        GameManager.getInstance().addListener(new AchievementTracker());

        Game game = new Game();
        game.start();
    }
}