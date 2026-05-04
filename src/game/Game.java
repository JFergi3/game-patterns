package game;

import game.strategies.*;
import java.util.Scanner;

public class Game {

    private GameManager gameManager;

    public Game() {
        gameManager = GameManager.getInstance();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game!");

        while (gameManager.isGameRunning()) {
            Player player = gameManager.getPlayer();

            System.out.println("\nYou are in: " + player.getCurrentRoom().getName());
            System.out.println(player.getCurrentRoom().getDescription());

            System.out.print("Enter command (search, take, move, quit): ");
            String input = scanner.nextLine().toLowerCase();

            ActionStrategy action = null;

            if (input.equals("search")) {
                action = new SearchStrategy();
            }
            else if (input.startsWith("use")) {
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    action = new UseItemStrategy(parts[1]);
                }
            }
            else if (input.startsWith("take")) {
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    action = new TakeAssetStrategy(parts[1]);
                }
            }
            else if (input.startsWith("move")) {
                String[] parts = input.split(" ");
                if (parts.length > 1) {
                    action = new MoveStrategy(parts[1]);
                }
            }
            else if (input.equals("quit")) {
                gameManager.stopGame();
                System.out.println("Game over.");
                continue;
            }

            if (action != null) {
                action.execute(player);
            } else {
                System.out.println("Invalid command.");
            }
        }

        scanner.close();
    }
}