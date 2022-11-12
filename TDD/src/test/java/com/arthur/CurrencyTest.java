package com.arthur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @Test
    public void testMultiiplication() {
      Dollar five = new Dollar(5);
      five.times(2);
      assertEquals(10, five.amount);
    }
}

