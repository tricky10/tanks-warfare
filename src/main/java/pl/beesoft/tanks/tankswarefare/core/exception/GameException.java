package pl.beesoft.tanks.tankswarefare.core.exception;

import java.util.logging.Logger;

public class GameException {
    private static final Logger log = Logger.getLogger(GameException.class.getName());

    public static void runtime(String message) {

        throw new RuntimeException(message);
    }

    public static void runtime(String message, Exception e) {
        e.printStackTrace();
        throw new RuntimeException(message);
    }
}
