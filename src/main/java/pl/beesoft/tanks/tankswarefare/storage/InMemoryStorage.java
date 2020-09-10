package pl.beesoft.tanks.tankswarefare.storage;

import pl.beesoft.tanks.tankswarefare.core.State;

import java.util.Optional;

public class InMemoryStorage implements Storage {
    private static State state;

    @Override
    public boolean save(State o) {
        state = o;
        return true;
    }

    @Override
    public Optional<State> load() {
        return Optional.ofNullable(state);
    }
}
