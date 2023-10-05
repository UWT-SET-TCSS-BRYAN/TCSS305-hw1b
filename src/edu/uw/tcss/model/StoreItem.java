package edu.uw.tcss.model;

import java.math.BigDecimal;

public class StoreItem implements Item {

    public StoreItem(final String name, final BigDecimal price) {


    }

    public StoreItem(final String name, final BigDecimal price, final int bq,
                     final BigDecimal bp) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public int getBulkQuantity() {
        return 0;
    }

    @Override
    public BigDecimal getBulkPrice() {
        return null;
    }

    @Override
    public boolean isBulk() {
        return false;
    }
}
