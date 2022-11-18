package com.arthur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @Test
    @DisplayName("곱셈 테스트")
    public void testMultiiplication() {
      Dollar five = new Dollar(5);
      Dollar product = five.times(2);
      assertEquals(10, product.amount);
      product = five.times(3);
      assertEquals(15, product.amount);
    }

    @Test
    @DisplayName("동치성 테스트")
    public void testEquality() {
      assertTrue(new Dollar(5).equals(new Dollar(5)));
      assertFalse(new Dollar(5).equals(new Dollar(6)));
    }
}

