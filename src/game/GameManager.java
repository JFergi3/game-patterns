package game;

import game.observers.GameEventListener;
import java.util.ArrayList;
import java.util.List;

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

    private List<GameEventListener> listeners = new ArrayList<>();

    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(String message) {
        for (GameEventListener listener : listeners) {
            listener.onEvent(message);
        }
    }
}
