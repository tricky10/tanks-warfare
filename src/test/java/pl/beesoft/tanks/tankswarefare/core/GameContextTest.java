package pl.beesoft.tanks.tankswarefare.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.EasyMap;
import pl.beesoft.tanks.tankswarefare.person.PersonBuilder;
import pl.beesoft.tanks.tankswarefare.storage.InMemoryStorage;
import pl.beesoft.tanks.tankswarefare.storage.Storage;
import pl.beesoft.tanks.tankswarefare.tanks.TankFactory;
import pl.beesoft.tanks.tankswarefare.tanks.TankType;

public class GameContextTest {

    @Test
    public void shouldHaveStateAssigned() {
        Storage storage = new InMemoryStorage();
        storage.save(GameState.empty());
        GameContext.current().applyState(storage.load().get());
        Assertions.assertTrue(GameContext.current().isLoaded());
    }

    @Test
    public void shouldHaveNotStateAssigned() {
        GameContext.reset();
        Assertions.assertFalse(GameContext.current().isLoaded());
    }

    @Test
    public void shouldCreateNewGameContext() {
        GameContext.reset();
        GameContext.current().applyState(GameState.newState(PersonBuilder.builder().withName("MyName").build(),
                TankFactory.of(TankType.USA),
                new EasyMap()));

        Assertions.assertNotNull(GameContext.current().state().person());
        Assertions.assertNotNull(GameContext.current().state().vehicle());
        Assertions.assertNotNull(GameContext.current().state().worldMap());

    }
}
