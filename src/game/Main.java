package game;

import game.assets.Asset;
import game.factories.AssetFactory;

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

        System.out.println(player.getName() + " is in " + player.getCurrentRoom().getName());
        System.out.println(player.getCurrentRoom().getDescription());
        System.out.println("Room has: " + key.getName());
        System.out.println("North leads to: " + entrance.getExit("north").getName());
    }
}