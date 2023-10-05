package edu.uw.tcss.model;

import java.math.BigDecimal;

/**
 * Represents a single item for sale. An Item is an immutable object.
 * <p>
 * Constructors and methods of this class throw NullPointerException if required
 * parameters are null.
 *
 * @author Charles Bryan
 * @version Autumn 2023
 */
public interface Item {
    /**
     * Returns the name for this Item.
     *
     * @return the name for this Item
     */
    String getName();

    /**
     * Returns the price for this Item.
     *
     * @return the price for this Item
     */
    BigDecimal getPrice();

    /**
     * Returns the bulk quantity for this Item.
     *
     * @return the bulk quantity for this Item
     */
    int getBulkQuantity();

    /**
     * Returns the bulk price for this Item.
     *
     * @return the bulk price for this Item
     */
    BigDecimal getBulkPrice();

    /**
     * Returns True if this Item has bulk pricing.
     *
     * @return True if this Item has bulk pricing; false otherwise
     */
    boolean isBulk();

}
