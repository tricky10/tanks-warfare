package pl.beesoft.tanks.tankswarefare.storage;

import pl.beesoft.tanks.tankswarefare.core.State;

import java.io.*;
import java.util.Optional;
import java.util.logging.Logger;

public class FileStorage implements Storage {
    public static final String SIMPLE_STORAGE_FILE = "game.db";

    private static final Logger log = Logger.getLogger(FileStorage.class.getName());

    private String path;

    public FileStorage(String path) {
        this.path = path;
    }

    public FileStorage() {
        this.path = SIMPLE_STORAGE_FILE;
    }

    @Override
    public boolean save(State o) {
        log.fine(String.format("Saving state using file store %s", path));
        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream(path))) {
            fout.writeObject(o);
            log.info("Game has been saved");
            return true;
        } catch (IOException e) {
            log.severe(String.format("Cannot load file:%s", path));
        }

        log.warning(String.format("Game could not be saved %s", path));
        return false;
    }

    @Override
    public Optional<State> load() {
        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream(path))) {
            State o = (State) fin.readObject();
            return Optional.ofNullable(o);
        } catch (Exception e) {
            log.severe(String.format("Cannot load file:%s", path));
        }
        return Optional.empty();
    }
}
