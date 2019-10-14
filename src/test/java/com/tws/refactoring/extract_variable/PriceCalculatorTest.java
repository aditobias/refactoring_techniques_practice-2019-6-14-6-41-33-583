package com.tws.refactoring.extract_variable;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Test
    public void should_compute_price(){
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.setItemPrice(10);
        priceCalculator.setQuantity(5);

        Double expectedPrice = priceCalculator.getPrice();

        assertThat(expectedPrice, is(55.0));
    }
}