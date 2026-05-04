package game;

import game.assets.Asset;
import game.factories.AssetFactory;
import game.observers.AchievementTracker;
import game.observers.ConsoleNotifier;

public class RunGame {
    public Game createGame() {
        AssetFactory factory = new AssetFactory();

        Room entrance = new Room("Entrance", "You are standing at the entrance.");
        Room hallway = new Room("Hallway", "A long dark hallway.");
        Room exit = new Room("Exit", "A locked exit door stands in front of you.");

        entrance.addExit("north", hallway);
        hallway.addExit("south", entrance);
        hallway.addExit("east", exit);
        exit.addExit("west", hallway);

        Asset key = factory.createAsset("key");
        entrance.addAsset(key);

        Player player = new Player("Player One");
        player.setCurrentRoom(entrance);

        GameManager gameManager = GameManager.getInstance();
        gameManager.setPlayer(player);
        gameManager.addListener(new ConsoleNotifier());
        gameManager.addListener(new AchievementTracker());

        return new Game();
    }
}
