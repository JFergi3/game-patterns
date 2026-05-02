package game;

import game.assets.Asset;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Room currentRoom;
    private List<Asset> inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addAsset(Asset asset) {
        inventory.add(asset);
    }

    public List<Asset> getInventory() {
        return inventory;
    }

    public boolean hasAsset(String assetName) {
        for (Asset asset : inventory) {
            if (asset.getName().equalsIgnoreCase(assetName)) {
                return true;
            }
        }
        return false;
    }
}

