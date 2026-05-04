package game.strategies;

import game.GameManager;
import game.Player;

public class UseItemStrategy implements ActionStrategy {
    private String itemName;

    public UseItemStrategy(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public void execute(Player player) {
        if (itemName.equalsIgnoreCase("key") &&
                player.hasAsset("key") &&
                player.getCurrentRoom().getName().equalsIgnoreCase("Exit")) {

            System.out.println("You unlocked the exit and won the game!");
            GameManager.getInstance().notifyListeners("Player won the game");
            GameManager.getInstance().stopGame();
        } else {
            System.out.println("You cannot use that here.");
        }
    }
}