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

    @Test
    @DisplayName("Display One Number")
    public void testOneNumber() {
        assertEquals(4, stringCalculator.add("4"));
    }

    @Test
    @DisplayName("Add Two Numbers")
    public void testTwoNumber() {
        assertEquals(6, stringCalculator.add("1,5"));
    }

    @Test
    @DisplayName("Add Multiple Numbers")
    public void testMultipleNumber() {
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    @Test
    @DisplayName("Test with One Negative Number")
    public void testOneNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-5"));
        assertEquals("negative numbers not allowed -5", exception.getMessage());
    }

    @Test
    @DisplayName("Test with Two Negative Numbers")
    public void testTwoNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("-2,-6"));
        assertEquals("negative numbers not allowed -2,-6", exception.getMessage());
    }

    @Test
    @DisplayName("Test with Multiple Negative Numbers")
    public void testMultipleNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-2,3,-4,5,-6"));
        assertEquals("negative numbers not allowed -2,-4,-6", exception.getMessage());
    }
}