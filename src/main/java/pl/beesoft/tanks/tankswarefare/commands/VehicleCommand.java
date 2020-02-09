package pl.beesoft.tanks.tankswarefare.commands;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import pl.beesoft.tanks.tankswarefare.core.GameContext;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;
import pl.beesoft.tanks.tankswarefare.tanks.TankFactory;
import pl.beesoft.tanks.tankswarefare.tanks.TankType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.logging.Logger;

@ShellComponent
public class VehicleCommand {

    private static final Logger log = Logger.getLogger(GameContextCommand.class.getName());

    @ShellMethod("List vehicles")
    public void listVehicles() {
        StringBuilder b = new StringBuilder();
        b.append("\n");
        for (TankType type : TankType.values()) {
            b.append("Type:" + type.name() + " number:" + type.ordinal()).append("\n");
        }

        log.info(b.toString());
    }

    @ShellMethod("Choose vehicle.")
    @ShellMethodAvailability({"checkPerson"})
    public void buyVehicle(@Min(0) @Max(3) int number) {
        TankType tankType = TankType.from(number);
        log.info(String.format("You have bought tank:%s", tankType.name()));
        GameContext.current().state().apply(TankFactory.of(tankType));
    }

    @ShellMethod("Show my tank.")
    @ShellMethodAvailability({"checkTank"})
    public void myVehicle() {
        Tank vehicle = GameContext.current().state().vehicle();
        log.info(String.format("Your Tank:%s maxSpeed:%d armor:%d destroyed:%s", vehicle.getName(), vehicle.getMaxSpeed(), vehicle.getArmor(), vehicle.isDestroyed()));
    }

    public Availability checkTank() {
        return GameContext.current().isLoaded() && GameContext.current().state().vehicle() != null
                ? Availability.available()
                : Availability.unavailable("No vehicle available or game not started yet");
    }

    public Availability checkPerson() {
        return GameContext.current().isLoaded() && GameContext.current().state().person() != null
                ? Availability.available()
                : Availability.unavailable("No character created or context");
    }
}
