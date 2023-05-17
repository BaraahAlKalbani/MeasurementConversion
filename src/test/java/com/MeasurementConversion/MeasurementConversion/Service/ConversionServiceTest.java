package com.MeasurementConversion.MeasurementConversion.Service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the ConversionService class.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ConversionServiceTest {

    @Mock
    private Logger logger;

    /**
     * Tests the decodeString method with a valid input.
     * The expected output is an ArrayList containing a single element, 26.
     */
    @Test
    void testDecodeString_ValidInput() {
        String input = "abcdabcdab_";
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(7);
        expected.add(7);
        expected.add(0);
        ArrayList<Integer> actual = ConversionService.decodeString(input);

        assertEquals(expected, actual);
        verify(logger, never()).info(anyString()); // Verify that logger.info() is not called
    }

    /**
     * Tests the getNumberFromChar method with a valid character input.
     * The expected output is the corresponding number value, which is 26 for 'z'.
     */
    @Test
    void testGetNumberFromChar() {
        char ch = 'z';
        int expected = 26;

        int actual = ConversionService.getNumberFromChar(ch);

        assertEquals(expected, actual);
        verify(logger, never()).info(anyString()); // Verify that logger.info() is not called
    }
}