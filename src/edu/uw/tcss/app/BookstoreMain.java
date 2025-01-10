/*
 * TCSS 305 Assignment 1 - UW Bookstore
 */

package edu.uw.tcss.app;


import edu.uw.tcss.io.InventoryLoader;
import edu.uw.tcss.model.Item;
import edu.uw.tcss.res.R;
import edu.uw.tcss.view.BookstoreFrame;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 * BookstoreMain provides the main method for a simple shopping cart GUI
 * displayer and calculator.
 *
 * @author Marty Stepp
 * @author Daniel M. Zimmerman (Formatting and Comments)
 * @author Alan Fowler (Numerous changes including use of BigDecimal and file input)
 * @author Charles Bryan (Added multiple file loading options/changed name)
 * @author Charles Bryan (Removed credentialling sytsem)
 * @version January 2025
 */

public final class BookstoreMain {

    /**
     * A Logger object for all your logging needs.
     * You should move away from using System.out.println as your logging/debugging method.
     */
    public static final Logger LOGGER = Logger.getLogger(BookstoreMain.class.getName());

    static {
        // Level.ALL - Display ALL logging messages
        // Level.OFF - Display NO logging messages
        LOGGER.setLevel(Level.ALL);
    }

    /**
     * A private constructor, to prevent external instantiation.
     */
    private BookstoreMain() {
        super();
    }

    /**
     * The main() method - displays and runs the bookstore GUI.
     *
     * @param theArgs Command line arguments, ignored by this program.
     */
    public static void main(final String... theArgs) {

        EventQueue.invokeLater(new LoadInventoryWorker());

    } // end main()

    /**
     * A worker thread to load the inventory files.
     * NOTE: THERE ARE NO ERRORS/BUGS IN THIS INNER CLASS
     * Operations that may take a long time to complete (like file I/O or network connections)
     * should be performed in a thread separate from the user interface thread. This will keep
     * your graphical user interface responsive to user interactions.
     * This inner class starts a background thread to perform the file I/O operations found in
     * io.InventoryLoader.java
     *
     * @author Charles Bryan
     */
    public static class LoadInventoryWorker
            extends SwingWorker<Map<String, List<Item>>, Integer> {

        /** The campus of the user logging in. */
        private static final String CAMPUS = "Tacoma";

        /**
         * Creates a worked to load the inventory file with the default campus, Tacoma.
         */
        LoadInventoryWorker() {
            super();
        }

        @Override
        public Map<String, List<Item>> doInBackground() {
            final Map<String, List<Item>> inventories = new HashMap<>();
            final List<String> campusNames =
                    InventoryLoader.readConfigurationFromFile(R.Strings.IO_FILE_LOCATION
                            + R.Strings.IO_CONFIG_FILE);
            for (final String campusName : campusNames) {
                inventories.put(campusName, InventoryLoader.
                        readItemsFromFile(R.Strings.IO_FILE_LOCATION
                                + campusName.toLowerCase(Locale.ENGLISH)
                                + R.Strings.IO_FILE_EXTENSION));
            }
            return inventories;
        }

        @Override
        public void done() {
            EventQueue.invokeLater(this::startBookstore);
        }

        private void startBookstore() {
            try {
                new BookstoreFrame(get(), CAMPUS);
            } catch (final InterruptedException | ExecutionException ex1) {
                LOGGER.severe(ex1.toString());
            }
        }
    }




} // end class BookstoreMain
