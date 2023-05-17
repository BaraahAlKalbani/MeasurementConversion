package com.MeasurementConversion.MeasurementConversion.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * Service class for measurement conversion operations.
 */
@Service
public class ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionService.class);
    /**
     * Decodes the input string and returns the corresponding measurement values.
     *
     * @param input The input string to be decoded.
     * @return The decoded measurement values as an ArrayList of integers.
     * @throws IllegalArgumentException If the input is invalid.
     */
    public static ArrayList<Integer> decodeString(String input) {
        validateInput(input);
        return decodeValues(input);
    }
    /**
     * Validates the input string.
     *
     * @param input The input string to be validated.
     * @throws IllegalArgumentException If the input is invalid.
     */
    private static void validateInput(String input) {
        if (!input.matches("[a-z_A-Z]+")) {
            logger.info("Invalid Input!: check Input Length ");
            throw new IllegalArgumentException("Invalid input. Input should only contain characters from 'a' to 'z' and '_'.");
        }
    }
    /**
     * Decodes the measurement values from the input string.
     *
     * @param input The input string to be decoded.
     * @return The decoded measurement values as an ArrayList of integers.
     * @throws IllegalArgumentException If the input calculation is not adding up.
     */
    public static ArrayList<Integer> decodeValues(String input) {
        char[] charArray = input.toLowerCase().toCharArray();
        ArrayList<Integer> decodedValues = new ArrayList<>();

        int index = 0;
        while (index < charArray.length) {
            char currChar = charArray[index];
            int numberOfGroupIncrement = getNumberFromChar(currChar);
            int value = 0;
            if (currChar == 'z') {
                while (currChar == 'z' && index + 1 < charArray.length) {
                    index++;
                    currChar = charArray[index];
                    numberOfGroupIncrement += getNumberFromChar(currChar);
                }
            }
            if (index + numberOfGroupIncrement > charArray.length-1) {
                logger.info("Invalid Input!");
                throw new IllegalArgumentException("Invalid input. Input calculation is not adding up!");
            }
            if (currChar == '_') {
                decodedValues.add(0);
                break;
            } else {
                for (int iterator  = 1; iterator  <= numberOfGroupIncrement && index + iterator  < charArray.length; iterator ++) {
                    currChar = charArray[index + iterator ];
                    if (currChar == 'z') {
                        while (currChar == 'z' && index + iterator  < charArray.length) {
                            logger.info("converting character:"+ currChar);
                            value += getNumberFromChar(currChar);
                            iterator ++;
                            numberOfGroupIncrement++;
                            currChar = charArray[index + iterator ];
                        }
                    }
                    value += getNumberFromChar(currChar);
                }

                decodedValues.add(value);
                index += numberOfGroupIncrement + 1;
            }
        }
        logger.info("Input: " + input);
        logger.info("Output: " + decodedValues);
        return decodedValues;
    }
/**
 * Converts a character to its corresponding number value.
 *
 * @param currChar The character to be converted.
 * @return The corresponding number value of the character.
 */
    public static int getNumberFromChar(char currChar) {
        logger.info("converting character:"+ currChar);
        if (currChar == '_') {
            return 0;
        } else {
            return currChar - 'a' + 1;
        }
    }
}
