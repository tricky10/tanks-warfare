package pl.beesoft.tanks.tankswarefare.storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.beesoft.tanks.tankswarefare.core.GameState;
import pl.beesoft.tanks.tankswarefare.core.State;

import java.util.Optional;
import java.util.UUID;


public class StorageTest {


    @Test
    public void shouldLoadFailLoadWhenNoFileExists() {
        Storage storage = new FileStorage(UUID.randomUUID().toString());
        Optional<State> load = storage.load();
        Assertions.assertFalse(load.isPresent());
    }

    @Test
    public void shouldLoadLoadWhenFileExists() {
        Storage storage = new FileStorage(FileStorage.SIMPLE_STORAGE_FILE);
        storage.save(GameState.empty());
        Optional<State> load = storage.load();
        Assertions.assertTrue(load.isPresent());
    }

    @Test
    public void shouldSaveFile() {
        Storage storage = new FileStorage(FileStorage.SIMPLE_STORAGE_FILE);
        boolean saved = storage.save(GameState.empty());
        Assertions.assertTrue(saved);
    }


}
