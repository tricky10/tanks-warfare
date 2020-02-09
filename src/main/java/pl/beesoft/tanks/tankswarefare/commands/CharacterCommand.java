package pl.beesoft.tanks.tankswarefare.commands;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import pl.beesoft.tanks.tankswarefare.core.GameContext;
import pl.beesoft.tanks.tankswarefare.person.PersonBuilder;

import java.util.logging.Logger;

@ShellComponent
public class CharacterCommand {
    private static final Logger log = Logger.getLogger(CharacterCommand.class.getName());

    @ShellMethodAvailability("createPersonAvailability")
    @ShellMethod("Create new character in active context")
    public void createCharacter(String name) {
        log.info(String.format("Creating character with name %s", name));
        GameContext.current().state().apply(PersonBuilder.builder().withName(name).build());
    }

    @ShellMethodAvailability("createPersonAvailability")
    @ShellMethod("Create new character in active context")
    public void showCharacter() {
        log.info(String.format("Your current character details are name %s experience:%d",
                GameContext.current().state().person().getName(), GameContext.current().state().person().getExperience()));

    }

    public Availability createPersonAvailability() {
        return GameContext.current().isLoaded()
                ? Availability.available()
                : Availability.unavailable("Game context not yet created or loaded");
    }
}
