/*
 * TCSS 305 Assignment 1 - UW Bookstore
 */

package edu.uw.tcss.app;

import edu.uw.tcss.io.InventoryLoader;
import edu.uw.tcss.res.R;
import edu.uw.tcss.view.LoginFrame;
import java.awt.EventQueue;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BookstoreMain provides the main method for a simple shopping cart GUI
 * displayer and calculator.
 * 
 * @author Marty Stepp
 * @author Daniel M. Zimmerman (Formatting and Comments)
 * @author Alan Fowler (Numerous changes including use of BigDecimal and file input)
 * @author Charles Bryan (Added multiple file loading options/changed name)
 * @author Charles Bryan (Added credentialling sytseM0
 * @version January 2020
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
        
        final List<String> campusNames =
                        InventoryLoader.readConfigurationFromFile(R.Strings.IO_FILE_LOCATION
                                                             + R.Strings.IO_CONFIG_FILE);
        
        EventQueue.invokeLater(() -> new LoginFrame(campusNames).setVisible(true));

    } // end main()

} // end class BookstoreMain
