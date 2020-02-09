package pl.beesoft.tanks.tankswarefare.infrastructure.world;

import pl.beesoft.tanks.tankswarefare.core.exception.GameException;
import pl.beesoft.tanks.tankswarefare.infrastructure.generator.WorldRandomizer;
import pl.beesoft.tanks.tankswarefare.tanks.Tank;

import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * World map interaction contains fields and enemies
 */
public abstract class WorldMap implements Serializable {
    private static final Logger log = Logger.getLogger(WorldMap.class.getName());

    private int column;
    private int row;

    private Square[][] map;

    protected WorldMap() {
        this.map = new Square[getSize()][getSize()];
    }

    public abstract int getSize();


    public void moveTo(int column, int row) {
        if (column > getSize() - 1 || row > getSize() - 1) {
            GameException.runtime(String.format("Your map size is not accepting this position max size is %d x %d", getSize(), getSize()));
        } else {
            log.info(String.format("Moving from position %d x %d", this.column, this.row));
            this.column = column;
            this.row = row;
            log.info(String.format("Moving to position %d x %d", this.column, this.row));
        }
    }

    public Optional<Tank> currentPositionEnemy() {
        Square square = this.map[column][row];
        return Optional.ofNullable(square.getEnemy());
    }

    public void apply(Square [][] map){
        this.map = map;
    }

    public void currentPosition() {
        log.info(String.format("Current position %d x %d", column, row));
    }

    public void logAllEnemies(){
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if(map[i][j].getEnemy()!=null) {
                    log.info(String.format("Enemy at position %d x %d", i, j));
                }
            }
        }
    }
}
