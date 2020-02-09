package pl.beesoft.tanks.tankswarefare.storage;

import pl.beesoft.tanks.tankswarefare.core.State;

import java.util.Optional;

public interface Storage {

    /**
     * Save game state into file false when failed
     *
     * @param o
     * @return
     */
    boolean save(State o);

    /**
     * Load gmae state from file
     *
     * @return
     */
    Optional<State> load();
}
