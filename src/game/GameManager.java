package game;

public class GameManager {
    private static GameManager instance;

    private Player player;
    private boolean gameRunning;

    private GameManager() {
        gameRunning = true;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void stopGame() {
        gameRunning = false;
    }
}
