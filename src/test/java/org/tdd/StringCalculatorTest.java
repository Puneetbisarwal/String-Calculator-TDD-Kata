package org.tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }

    @Test
    @DisplayName("String is null")
    public void testNullString() {
        Exception exception =assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(null));
        assertEquals("String is null", exception.getMessage());
    }

    @Test
    @DisplayName("String is empty")
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @DisplayName("String is blank")
    public void testBlankString() {
        assertEquals(0, stringCalculator.add(" "));
    }
}