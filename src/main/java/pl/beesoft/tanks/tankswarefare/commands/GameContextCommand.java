package pl.beesoft.tanks.tankswarefare.commands;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import pl.beesoft.tanks.tankswarefare.core.GameContext;
import pl.beesoft.tanks.tankswarefare.infrastructure.generator.WorldBuilder;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.EasyMap;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.VeryHardMap;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;
import pl.beesoft.tanks.tankswarefare.storage.FileStorage;

import java.util.logging.Logger;

@ShellComponent
public class GameContextCommand {

    private static final Logger log = Logger.getLogger(GameContextCommand.class.getName());

    @ShellMethod("Exist without saving game.")
    public void shutdown() {
        log.info("Exiting game bye bye and keep calm ...");
        System.exit(1);
    }

    @ShellMethod("Start new game context.")
    public void start(boolean hard) {
        log.info(String.format("Start new game ... hard:%s", hard));
        WorldMap map = hard ? new VeryHardMap() : new EasyMap();
        GameContext.create().state().apply(WorldBuilder.randomize(map));

    }

    @ShellMethod("Save current context.")
    @ShellMethodAvailability("checkSave")
    public void save(@ShellOption(defaultValue = FileStorage.SIMPLE_STORAGE_FILE) String file) {
        log.info(String.format("Saving game %s", file));
        GameContext.current().save(new FileStorage(file));
    }

    @ShellMethod("Load game from file.")
    public void load(@ShellOption(defaultValue = FileStorage.SIMPLE_STORAGE_FILE) String file) {
        log.info(String.format("Loading game %s", file));
        GameContext.current().load(new FileStorage(file));
    }

    public Availability checkSave() {
        return GameContext.current().isLoaded()
                ? Availability.available()
                : Availability.unavailable("Cannot save game when no context provided");
    }
}

