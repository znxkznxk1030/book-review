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
      Dollar five = Money.dollar(5);
      assertEquals(Money.dollar(10), five.times(2));
      assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    @DisplayName("곱셈 테스트 (Franc)")
    public void testFrancMultiplication() {
      Franc five = Money.franc(5);
      assertEquals(Money.franc(10), five.times(2));
      assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    @DisplayName("동치성 테스트")
    public void testEquality() {
      assertTrue(Money.dollar(5).equals(Money.dollar(5)));
      assertFalse(Money.dollar(5).equals(Money.dollar(6)));
      assertTrue(Money.franc(5).equals(Money.franc(5)));
      assertFalse(Money.franc(5).equals(Money.franc(6)));

      assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
}

