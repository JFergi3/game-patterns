package game.observers;

public class ConsoleNotifier implements GameEventListener{

    @Override
    public void onEvent(String message) {
        System.out.println("[Event] " + message);
    }
}
