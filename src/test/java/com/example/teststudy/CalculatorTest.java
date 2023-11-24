package com.example.teststudy;

import com.example.teststudy.calculator.BasicCalculator;
import com.example.teststudy.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void add() {
        // given - 준비
        Calculator calculator = new BasicCalculator();

        // when - 테스트하려는 로직 수행
        int result = calculator.add(1, 2);

        // then - 검증
        assertEquals(3, result);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtract() {
        Calculator calculator = new BasicCalculator();
        int result = calculator.subtract(3, 2);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiply() {
        Calculator calculator = new BasicCalculator();
        int result = calculator.multiply(3, 2);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divide() {
        Calculator calculator = new BasicCalculator();
        double result = calculator.divide(6, 2);
        assertEquals(3, result);
    }

}