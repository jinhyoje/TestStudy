package com.example.teststudy.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilityTest {
    private final StringUtility stringUtility = new StringUtility();

    @ParameterizedTest
    @ValueSource(strings = {"hello", "world", "parameterized"})
    void convertToUpperWithValidInput(String input) {

        String result = stringUtility.convertToUpper(input);

        assertEquals(input.toUpperCase(), result);
    }


}