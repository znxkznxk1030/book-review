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
      assertEquals(new Dollar(10), five.times(2));
      assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    @DisplayName("곱셈 테스트 (Franc)")
    public void testFrancMultiplication() {
      Franc five = new Franc(5);
      assertEquals(new Franc(10), five.times(2));
      assertEquals(new Franc(15), five.times(3));
    }

    @Test
    @DisplayName("동치성 테스트")
    public void testEquality() {
      assertTrue(new Dollar(5).equals(new Dollar(5)));
      assertFalse(new Dollar(5).equals(new Dollar(6)));
      assertTrue(new Franc(5).equals(new Franc(5)));
      assertFalse(new Franc(5).equals(new Franc(6)));
    }
}
