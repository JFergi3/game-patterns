package game.strategies;

import game.Player;
import game.Room;

public class MoveStrategy implements ActionStrategy{
    private String direction;

    public MoveStrategy(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player player) {
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if(nextRoom == null) {
            System.out.println("You cannot go that way.");
        } else {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved " + direction + " to " + nextRoom.getName());
        }
    }
}
