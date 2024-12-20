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

    @Test
    @DisplayName("Test with New Line between numbers.")
    public void testNewLine() {
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("Test with Custom Delimiter")
    public void testCustomDelimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
        assertEquals(6, stringCalculator.add("//|\n1|2|3"));
        assertEquals(6, stringCalculator.add("//$\n1$2$3"));
        assertEquals(8, stringCalculator.add("//@\n1@2@5"));
    }

    @Test
    @DisplayName("Test with Custom Delimiter Negative Numbers")
    public void testCustomDelimiterNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//;\n-1;-2"));
        assertEquals("negative numbers not allowed -1,-2", exception.getMessage());
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//|\n-1|-2|-3"));
        assertEquals("negative numbers not allowed -1,-2,-3", exception1.getMessage());
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//$\n-1$-2$-3$-4"));
        assertEquals("negative numbers not allowed -1,-2,-3,-4", exception2.getMessage());
        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//@\n-3@-7@-9"));
        assertEquals("negative numbers not allowed -3,-7,-9", exception3.getMessage());
    }

    @Test
    @DisplayName("Test with Custom Delimiter Positive Negative Numbers")
    public void testCustomDelimiterPositiveNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//;\n1;-2"));
        assertEquals("negative numbers not allowed -2", exception.getMessage());
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//|\n-1|2|-3"));
        assertEquals("negative numbers not allowed -1,-3", exception1.getMessage());
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//$\n-1$-2$3$4"));
        assertEquals("negative numbers not allowed -1,-2", exception2.getMessage());
        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("//@\n3@5@-7@-9"));
        assertEquals("negative numbers not allowed -7,-9", exception3.getMessage());
    }
}