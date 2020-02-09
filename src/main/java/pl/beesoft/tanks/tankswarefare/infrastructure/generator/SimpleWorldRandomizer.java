package pl.beesoft.tanks.tankswarefare.infrastructure.generator;

import pl.beesoft.tanks.tankswarefare.infrastructure.world.Square;
import pl.beesoft.tanks.tankswarefare.infrastructure.world.WorldMap;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;
import pl.beesoft.tanks.tankswarefare.tanks.TankFactory;
import pl.beesoft.tanks.tankswarefare.tanks.TankType;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

class SimpleWorldRandomizer implements WorldRandomizer {
    private static final Logger log = Logger.getLogger(SimpleWorldRandomizer.class.getName());


    private Random random = new Random(System.currentTimeMillis());
    private Random randomVehicle = new Random(System.currentTimeMillis());

    @Override
    public Optional<Tank> enemy() {
        if (isPrime()) {
            TankType enemy = TankType.from(randomVehicle.nextInt(4));
            log.fine(String.format("Randomize prime number assigning vehicle %s", enemy.name()));
            return Optional.of(TankFactory.of(enemy));
        }
        return Optional.empty();
    }

    @Override
    public void apply(WorldMap map) {
        log.info("Apply enemies to map");
        int enemies = 0;
        Square[][] randomMap = new Square[map.getSize()][map.getSize()];
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                Square square = new Square();
                Optional<Tank> enemy = enemy();
                if (enemy.isPresent()) {
                    square.apply(enemy.get());
                    enemies++;
                }
                randomMap[i][j] = square;
            }
        }
        map.apply(randomMap);
        log.info(String.format("Enemies assigned %d", enemies));
    }

    private boolean isPrime() {
        BigInteger b = new BigInteger(String.valueOf(random.nextInt()));
        return b.isProbablePrime(1);
    }
}
