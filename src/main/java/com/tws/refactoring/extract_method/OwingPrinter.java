package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.PriceCalculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OwingPrinter {
    private PriceCalculator priceCalculator = new PriceCalculator();
    private List<Order> orderList = new ArrayList<>();
    private String productName;

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    void printOwing() {
        double totalAmount = 0.0;

        for(Order order : orderList){
            totalAmount += order.getAmount();

        }

        System.out.print(printBanner(productName, totalAmount, orderList.size()));
    }

    private String printBanner(String productName, double totalAmount, Integer quantity) {

        priceCalculator.setItemPrice((int) totalAmount);
        priceCalculator.setQuantity(quantity);
        String lineSeparator = "*****************************\n";
        String title = "****** Customer totals ******\n";
        String buildName = "name: " + productName + "\n";
        String buildAmount = "amount: " + totalAmount + "\n";
        String buildPrice = "total: " + priceCalculator.getPrice();

        return lineSeparator + title + lineSeparator + buildName + buildAmount + buildPrice;

    }
}

class Order {

    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    double getAmount() {
        return amount;
    }
}
