// Finish and comment me!

package edu.uw.tcss.model;

import java.math.BigDecimal;  

public class StoreCart implements Cart {

    public StoreCart() { }

    public void add(final StoreItemOrder theOrder) { }

    public void setMembership(final boolean theMembership) { }

    public BigDecimal calculateTotal() {
        return null;
    }

    public void clear() { }

    public CartSize getCartSize() {
        return new CartSize(10, 20);
    }


    public String toString() {
        return null;
    }

}
