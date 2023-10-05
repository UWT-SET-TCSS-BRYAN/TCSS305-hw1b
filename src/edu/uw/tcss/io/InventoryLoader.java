/*
 * TCSS 305 Assignment 1 - UW Bookstore
 */

package edu.uw.tcss.io;

import static edu.uw.tcss.app.BookstoreMain.LOGGER;
import static edu.uw.tcss.res.R.ItemsFile.ITEM_BULK_PRICE;
import static edu.uw.tcss.res.R.ItemsFile.ITEM_PRICE;
import static edu.uw.tcss.res.R.ItemsFile.ITEM_BULK_QUANITIY;
import static edu.uw.tcss.res.R.ItemsFile.ITEM_NAME;

import edu.uw.tcss.model.Item;
import edu.uw.tcss.model.StoreItem;
import edu.uw.tcss.res.R;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * A utility class for The shopping cart application. 
 * 
 * @author Charles Bryan
 * @version Autumn 2015
 */
public final class InventoryLoader {
    
    /**
     * A private constructor, to prevent external instantiation.
     */
    private InventoryLoader() {
        super();

    }
    
    /**
     * Reads item information from a file and returns a List of Item objects.
     * @param theFile the name of the file to load into a List of Items
     * @return a List of Item objects created from data in an input file
     */
    @SuppressWarnings("LocalCanBeFinal")
    public static List<Item> readItemsFromFile(final String theFile) {
        final List<Item> items = new LinkedList<>();
        
        try (Scanner input = new Scanner(Paths.get(theFile))) {
            while (input.hasNextLine()) {
                final String[] parts = input.nextLine().split(R.Strings.IO_FILE_DELIMITER);
                final String itemName = parts[ITEM_NAME.ordinal()];
                final BigDecimal itemPrice = new BigDecimal(parts[ITEM_PRICE.ordinal()]);
                if (parts.length > 2) {
                    final int bulkQuantity = 
                                    Integer.parseInt(parts[ITEM_BULK_QUANITIY.ordinal()]);
                    final BigDecimal bulkPrice = 
                                    new BigDecimal(parts[ITEM_BULK_PRICE.ordinal()]);
                    items.add(new StoreItem(itemName, itemPrice, bulkQuantity, bulkPrice));
                } else {
                    items.add(new StoreItem(itemName, itemPrice));
                }
            }
        } catch (final IOException e) {
            LOGGER.severe(e.toString());
        } 
        return items;
    }
    
    /**
     * Reads item information from a file and returns a List of Item objects.
     * @param theFile the name of the file to load into a List of Items
     * @return a List of Item objects created from data in an input file
     */
    @SuppressWarnings("LocalCanBeFinal")
    public static List<String> readConfigurationFromFile(final String theFile) {
        final List<String> results = new LinkedList<>();
        
        try (Scanner input = new Scanner(Paths.get(theFile))) {
            while (input.hasNextLine()) {
                final String line = input.nextLine();
                
                if (!line.startsWith(R.Strings.IO_FILE_COMMENT)) {
                    results.add(line);
                }
                
            }
        } catch (final IOException e) {
            LOGGER.severe(e.toString());
        } 
    
        return results;
    }    
}
