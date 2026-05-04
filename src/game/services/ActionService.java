package game.services;

import game.Player;
import game.strategies.ActionStrategy;

public class ActionService {
    private ActionStrategy actionStrategy;

    public ActionService(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    public void performAction(Player player) {
        actionStrategy.execute(player);
    }
}

