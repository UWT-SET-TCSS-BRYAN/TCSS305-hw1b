package edu.uw.tcss.model;

import java.math.BigDecimal;

public interface Cart {

    void add(StoreItemOrder theOrder);

    void setMembership(boolean theMembership);

    BigDecimal calculateTotal();

    void clear();

    CartSize getCartSize();

    record CartSize(int itemOrderCount, int itemCount) { }
    // https://docs.oracle.com/en/java/javase/17/language/records.html
}
