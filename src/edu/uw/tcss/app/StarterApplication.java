package edu.uw.tcss.app;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A driver class for this application.
 *
 * @author Charles Bryan
 * @version Autumn 2023
 */
public final class StarterApplication {

    /**
     * A Logger object for all your logging needs.
     * You should move away from using System.out.println as your logging/debugging method.
     */
    public static final Logger LOGGER = Logger.getLogger(StarterApplication.class.getName());

    static {
        // Level.ALL - Display ALL logging messages
        // Level.OFF - Display NO logging messages
        LOGGER.setLevel(Level.ALL);
    }

    private StarterApplication() {
        super();
    }

    /**
     * The entry point into this application.
     *
     * @param theArgs the command-line arguments for this program.
     */
    public static void main(final String[] theArgs) {
        LOGGER.info(() -> "Should you need String concatenation,  "
                + "use a lambda for lazy evaluation. What's that you ask?");
        LOGGER.info(() -> "What is a magic number you ask?,  "
                + 1977);
        LOGGER.severe("This is really bad");
        LOGGER.warning("I've got a bad feeling about this");
        LOGGER.info(() -> "Primative typs must be wrapped the Logger class "
                + "methods only accept objects.");
        LOGGER.info(String.valueOf(42));
        final int aNumber = 42;
        LOGGER.info(String.valueOf(aNumber));

        // System.out.println should not be used unless this is an actual console application!
        // Maybe not even then.
    }
}
