package edu.uw.tcss.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ItemTest {

    /**
     * The name of the item used in testing.
     */
    private static final String ITEM_NAME = "Item";

    /**
     * The name of the bulk item used in testing.
     */
    private static final String BULK_ITEM_NAME = "Bulk Item";

    /**
     * The price of the item used in testing.
     */
    private static final String ITEM_PRICE = ".50";

    /**
     * The bulk price of the item used in testing.
     */
    private static final String BULK_PRICE = "4.00";

    /**
     * The negative price of the item used in testing.
     */
    private static final String NEGATIVE_PRICE = "-0.01";

    /**
     * The bulk quantity of the item used in testing.
     */
    private static final int BULK_QUANTITY = 10;

    /**
     * An object of class Item to use in testing.
     */
    private static final Item TEST_ITEM = new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE));

    /**
     * An object of class Item to use in testing.
     */
    private static final Item TEST_BULK_ITEM =
            new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                    BULK_QUANTITY, new BigDecimal(BULK_PRICE));

    @Test
    public final void testConstructorEmptyItemName() {
        assertAll("Item name as empty string to constructors.",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem("", new BigDecimal(ITEM_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle empty string as an "
                                + "argument to theName properly."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem("", new BigDecimal(ITEM_PRICE)),
                        "Two arg constructor does not handle empty string as an "
                                + "argument to theName properly."));

    }

    @Test
    public final void testConstructorNullItemName() {
        assertAll("Item name as null to constructors.",
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(null, new BigDecimal(ITEM_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle null as an "
                                + "argument to theName properly."),
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(null, new BigDecimal(ITEM_PRICE)),
                        "Two arg constructor does not handle null as an "
                                + "argument to theName properly."));

    }

    @Test
    public final void testConstructorNegativeItemPrice() {
        assertAll("Item price as negative value to constructors.",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(NEGATIVE_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle negative value as an "
                                + "argument to thePrice properly."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem(ITEM_NAME, new BigDecimal(NEGATIVE_PRICE)),
                        "Two arg constructor does not handle negative value as an "
                                + "argument to thePrice properly."));

    }

    @Test
    public final void testConstructorNullItemPrice() {
        assertAll("Item price as null value to constructors.",
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(BULK_ITEM_NAME, null,
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle null as an "
                                + "argument to thePrice properly."),
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(ITEM_NAME, null),
                        "Two arg constructor does not handle null as an "
                                + "argument to thePrice properly."));

    }

    @Test
    public final void testConstructorNegativeBulkItemQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                        -1, new BigDecimal(BULK_PRICE)),
                "Four arg constructor does not handle negative value as an "
                        + "argument to theBulkQuantity properly.");
    }

    @Test
    public final void testConstructorNullBulkItemPrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                        BULK_QUANTITY, new BigDecimal(NEGATIVE_PRICE)),
                "Four arg constructor does not handle negative value as an "
                        + "argument to theBulkPrice properly.");
    }

    @Test
    public final void testConstructorNegativeBulkItemPrice() {
        assertThrows(NullPointerException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                        BULK_QUANTITY, null),
                "Four arg constructor does not handle null as an "
                        + "argument to thePrice properly.");
    }

    @Test
    public final void testTwoArguemntConstructor() {
        assertAll("Two argument constructor test.",
                () -> assertEquals(
                        ITEM_NAME,
                        TEST_ITEM.getName(),
                        "Item name should be: " + ITEM_NAME),
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE),
                        TEST_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE),
                () -> assertEquals(
                        0,
                        TEST_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: 0"),
                () -> assertEquals(
                        BigDecimal.ZERO,
                        TEST_ITEM.getBulkPrice(),
                        "Bulk Price should be: 0"));
    }

    @Test
    public final void testFourArgumentConstructor() {
        assertAll("Four argument constructor test.",
                () -> assertEquals(
                        BULK_ITEM_NAME,
                        TEST_BULK_ITEM.getName(),
                        "Item name should be: " + BULK_ITEM_NAME),
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE),
                        TEST_BULK_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE),
                () -> assertEquals(
                        BULK_QUANTITY,
                        TEST_BULK_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: " + BULK_QUANTITY),
                () -> assertEquals(
                        new BigDecimal(BULK_PRICE),
                        TEST_BULK_ITEM.getBulkPrice(),
                        "Bulk Price should be: " + BULK_PRICE));
    }

    @Test
    void testGetName() {
        assertAll("getName test.",
                () -> assertEquals(
                        ITEM_NAME,
                        TEST_ITEM.getName(),
                        "Item name should be: " + ITEM_NAME),
                () -> assertEquals(
                        BULK_ITEM_NAME,
                        TEST_BULK_ITEM.getName(),
                        "Item name should be: " + BULK_ITEM_NAME));
    }

    @Test
    void testGetPrice() {
        assertAll("getPrice test.",
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE),
                        TEST_BULK_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE),
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE),
                        TEST_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE));
    }

    @Test
    void testGetBulkQuantity() {
        assertAll("getBulkQuantity test.",
                () -> assertEquals(
                        0,
                        TEST_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: 0"),
                () -> assertEquals(
                        BULK_QUANTITY,
                        TEST_BULK_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: " + BULK_QUANTITY));
    }

    @Test
    void testGetBulkPrice() {
        assertAll("getBulkPrice test.",
                () -> assertEquals(
                        BigDecimal.ZERO,
                        TEST_ITEM.getBulkPrice(),
                        "Bulk Price should be: 0"),
                () -> assertEquals(
                        new BigDecimal(BULK_PRICE),
                        TEST_BULK_ITEM.getBulkPrice(),
                        "Bulk Price should be: " + BULK_PRICE));
    }

    @Test
    void testIsBulk() {
        assertAll("isBulk test.",
                () -> assertFalse(
                        TEST_ITEM.isBulk(),
                        "Item should NOT be bulk"),
                () -> assertTrue(
                        TEST_BULK_ITEM.isBulk(),
                        "Item should be bulk"));
    }

    @Test
    void testToString() {
        assertAll("toString test.",
                () -> assertEquals(
                        "Item, $0.50",
                        TEST_ITEM.toString(),
                        "toString should be: \"Item, $0.50\""),
                () -> assertEquals(
                        "Bulk Item, $0.50 (10 for $4.00)",
                        TEST_BULK_ITEM.toString(),
                        "toString should be: \"Bulk Item, $0.50 (10 for $4.00)\""));
    }

    @Test
    void testEquals() {
        assertAll("equals test.",
                () -> assertAll("equals test same object.",
                        () -> assertEquals(
                                TEST_ITEM,
                                TEST_ITEM,
                                "2 argument Same object should be equals() true"),
                        () -> assertEquals(
                                TEST_BULK_ITEM,
                                TEST_BULK_ITEM,
                                "4 argument Same object should be equals() true")),
                () -> assertAll("equals test different object same sate.",
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE));
                            assertEquals(
                                    TEST_ITEM,
                                    twoArgument,
                                    "2 argument different objects with the same "
                                            + "state should be equals() true");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE),
                                            BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument different objects with the same "
                                            + "state should be equals() true");
                        }));
    }

    @Test
    void testNotEquals() {
        assertAll("NOT equals test.",
                () -> assertAll("NOT equals test two argument.",
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(
                                            ITEM_NAME + "wrong",
                                            new BigDecimal(ITEM_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    twoArgument,
                                    "2 argument Different name should be false");
                        },
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(
                                            ITEM_NAME,
                                            new BigDecimal("10" + ITEM_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    twoArgument,
                                    "2 argument Different price should be false");
                        },
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(
                                            ITEM_NAME + "wrong",
                                            new BigDecimal("10" + ITEM_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    twoArgument,
                                    "2 argument Different name and price should be false");
                        }
                ),
                () -> assertAll("NOT equals test four argument.",
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            ITEM_NAME + "wrong",
                                            new BigDecimal(ITEM_PRICE),
                                            BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    fourArgument,
                                    "4 argument Different name should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            ITEM_NAME,
                                            new BigDecimal("10" + ITEM_PRICE),
                                            BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    fourArgument,
                                    "4 argument Different price should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE),
                                            10 + BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    fourArgument,
                                    "4 argument Different bulk quantity should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE),
                                            BULK_QUANTITY,
                                            new BigDecimal("10" + BULK_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    fourArgument,
                                    "4 argument Different bulk price should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            ITEM_NAME + "wrong",
                                            new BigDecimal("10" + ITEM_PRICE),
                                            10 + BULK_QUANTITY,
                                            new BigDecimal("10" + BULK_PRICE));
                            assertNotEquals(
                                    TEST_ITEM,
                                    fourArgument,
                                    "4 argument Different name, price, bulk quantity, "
                                            + "bulk price should be false");
                        }
                ));
    }


    @Test
    void testHashCode() {
        assertAll("hashCode test.",
                () -> {
                    assertEquals(
                            TEST_ITEM,
                            TEST_ITEM,
                            "2 argument different objects with the same state "
                                    + "should be equals() true");
                    assertEquals(
                            TEST_ITEM.hashCode(),
                            TEST_ITEM.hashCode(),
                            "2 argument objects equal by equals must have the same hashCode");
                },
                () -> {
                    final Item twoArgument =
                            new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE));
                    assertEquals(
                            TEST_ITEM,
                            twoArgument,
                            "2 argument different objects with the same state "
                                    + "should be equals() true");
                    assertEquals(
                            TEST_ITEM.hashCode(),
                            twoArgument.hashCode(),
                            "2 argument objects equal by equals must have the same hashCode");
                },
                () -> {
                    assertEquals(
                            TEST_BULK_ITEM,
                            TEST_BULK_ITEM,
                            "4 argument Same object should be equals() true");
                    assertEquals(
                            TEST_BULK_ITEM.hashCode(),
                            TEST_BULK_ITEM.hashCode(),
                            "4 argument objects equal by equals must have the same hashCode");
                },
                () -> {
                    final Item fourArgument =
                            new StoreItem(
                                    BULK_ITEM_NAME,
                                    new BigDecimal(ITEM_PRICE),
                                    BULK_QUANTITY,
                                    new BigDecimal(BULK_PRICE));
                    assertEquals(
                            TEST_BULK_ITEM,
                            fourArgument,
                            "4 argument different objects with the same state "
                                    + "should be equals() true");
                    assertEquals(
                            TEST_BULK_ITEM.hashCode(),
                            fourArgument.hashCode(),
                            "4 argument objects equal by equals must have the same hashCode");

                });
    }
}