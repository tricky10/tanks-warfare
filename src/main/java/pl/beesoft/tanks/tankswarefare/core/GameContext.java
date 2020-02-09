package pl.beesoft.tanks.tankswarefare.core;

import pl.beesoft.tanks.tankswarefare.storage.Storage;

import java.util.Optional;
import java.util.logging.Logger;

public class GameContext {
    private static final Logger log = Logger.getLogger(GameContext.class.getName());

    private static GameContext context;
    private State gameState;

    private GameContext() {
    }

    public static synchronized GameContext current() {
        if (context == null) {
            context = new GameContext();
        }
        return context;
    }

    public static synchronized GameContext create() {
        context = new GameContext();
        context.applyState(GameState.empty());
        return context;
    }

    public static synchronized GameContext reset() {
        context = new GameContext();
        return context;
    }


    public void applyState(State state) {
        this.gameState = state;
    }

    public State state() {
        return gameState;
    }

    public boolean isLoaded() {
        return this.gameState != null;
    }

    public void save(Storage storage) {
        storage.save(this.state());
    }

    public void load(Storage storage) {
        Optional<State> load = storage.load();
        if (load.isPresent()) {
            this.applyState(load.get());
        } else {
            log.warning("Could not load game state using storage provider");
        }
    }
}
