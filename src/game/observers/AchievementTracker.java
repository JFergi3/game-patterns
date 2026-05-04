package game.observers;

public class AchievementTracker implements GameEventListener {

    @Override
    public void onEvent(String message) {
        if (message.toLowerCase().contains("piacked up")){
            System.out.println("[Achievement] First item collected!");
        }
    }
}
