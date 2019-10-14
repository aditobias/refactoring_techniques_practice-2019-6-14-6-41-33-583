package com.tws.refactoring.extract_variable;

public class PriceCalculator {

    public static final double DISCOUNT_PERCENTAGE = 0.05;
    public static final int MAX_PRODUCT = 500;
    public static final double SHIPPING_RATE = 0.1;
    public static final double FULL_PERCENTAGE = 100.0;

    private int quantity;
    private int itemPrice;

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getPrice() {
        return calculateBasePrice() -
                calculateDiscount() +
                calculateShippingCost();
    }

    private int calculateBasePrice() {
        return quantity * itemPrice;
    }

    private double calculateDiscount() {
        return Math.max(0, quantity - MAX_PRODUCT) * itemPrice * DISCOUNT_PERCENTAGE;
    }

    private double calculateShippingCost() {
        return Math.min(quantity * itemPrice * SHIPPING_RATE, FULL_PERCENTAGE);
    }
}
