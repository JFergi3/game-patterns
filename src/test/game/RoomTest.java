package test.game;

import game.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    @Test
    public void roomCanConnectToAnotherRoom() {
        Room entrance = new Room("Entrance", "Starting room");
        Room hallway = new Room("Hallway", "Dark hallway");

        entrance.addExit("north", hallway);

        assertEquals(hallway, entrance.getExit("north"));
    }
}
