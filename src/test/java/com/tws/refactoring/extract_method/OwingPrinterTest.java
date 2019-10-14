package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_return_receipt_output_when_given_orderList_and_product_name() {
        OwingPrinter owingPrinter = new OwingPrinter();
        List<Order> orderList = new ArrayList<>();

        String expectedOutputReceipt = "*****************************\n" +
                "****** Customer totals ******\n" +
                "*****************************\n" +
                "name: Coke\n" +
                "amount: 10.0\n" +
                "total: 11.0";


        Order order = new Order(10.0);
        orderList.add(order);

        owingPrinter.setOrderList(orderList);
        owingPrinter.setProductName("Coke");

        owingPrinter.printOwing();

        assertEquals(expectedOutputReceipt, outContent.toString());
    }
}