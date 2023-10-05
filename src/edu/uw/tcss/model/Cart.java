package edu.uw.tcss.model;

import java.math.BigDecimal;

public interface Cart {
    void add(StoreItemOrder theOrder);

    void setMembership(boolean theMembership);

    BigDecimal calculateTotal();

    void clear();

    int getCartSize();

}
