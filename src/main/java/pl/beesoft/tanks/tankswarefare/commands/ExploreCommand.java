package pl.beesoft.tanks.tankswarefare.commands;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import pl.beesoft.tanks.tankswarefare.battle.BattleFactory;
import pl.beesoft.tanks.tankswarefare.core.GameContext;
import pl.beesoft.tanks.tankswarefare.infrastructure.exploration.Explore;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.util.Optional;
import java.util.logging.Logger;

@ShellComponent
public class ExploreCommand {
    private static final Logger log = Logger.getLogger(ExploreCommand.class.getName());


    @ShellMethod("Show current position")
    public void exploreCurrentPosition() {
        GameContext.current().state().worldMap().currentPosition();
    }

    @ShellMethod("Explore by moving to specified position")
    @ShellMethodAvailability("isNotDestroyed")
    public void exploreTo(int column, int row) {
        new Explore().using(GameContext.current().state().worldMap()).toPosition(column, row);
    }

    @ShellMethod("This option will show all enemies in the map")
    public void exploreDebug(String password) {
        if("bozek".equals(password) && GameContext.current().isLoaded()){
            GameContext.current().state().worldMap().logAllEnemies();
        }
    }

    @ShellMethod("Check if enemy exists on current position")
    public void exploreEnemy() {
        Optional<Tank> enemy = GameContext.current().state().worldMap().currentPositionEnemy();
        if (enemy.isPresent()) {
            log.warning(String.format("You have got enemy in current square escape fight or die ... %s", enemy.get().getName()));
        } else {
            log.info(String.format("You don't have enemy in square move on..."));
        }
    }

    @ShellMethod("If enemy exists fight to gain more experience")
    @ShellMethodAvailability("battlePossible")
    public void exploreBattle() {
        BattleFactory.simple().battleBetween(GameContext.current().state().vehicle(),
                GameContext.current().state().worldMap().currentPositionEnemy().get(),o -> {
                    GameContext.current().state().person().improveExperienceBy(o);
                });
    }

    public Availability battlePossible() {
        return isNotDestroyed().isAvailable() && GameContext.current().state().worldMap().currentPositionEnemy().isPresent() &&
                !GameContext.current().state().worldMap().currentPositionEnemy().get().isDestroyed()
                ? Availability.available()
                : Availability.unavailable("Cannot save game when no context provided");
    }

    public Availability isNotDestroyed() {
        return GameContext.current().isLoaded() && hasBoughtVehicle() && !GameContext.current().state().vehicle().isDestroyed()
                ? Availability.available()
                : Availability.unavailable("Cannot explore check vehicle or status");
    }

    public boolean hasBoughtVehicle() {
        return GameContext.current().isLoaded() && GameContext.current().state().vehicle()!=null;
    }
}
