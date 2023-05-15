package com.MeasurementConversion.MeasurementConversion.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionService.class);

    public static ArrayList<Integer> decodeString(String input) {
        validateInput(input);
        return decodeValues(input);
    }

    private static void validateInput(String input) {
        if (!input.matches("[a-z_A-Z]+")) {
            logger.info("Invalid Input!");
            throw new IllegalArgumentException("Invalid input. Input should only contain characters from 'a' to 'z' and '_'.");
        }
    }

    private static ArrayList<Integer> decodeValues(String input) {
        char[] charArray = input.toCharArray();
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
            if (index + numberOfGroupIncrement > charArray.length) {
                logger.info("Invalid Input!");
                throw new IllegalArgumentException("Invalid input. Input calculation is not adding up!");
            }
            if (currChar == '_') {
                if (index < charArray.length - 1) {
                    decodedValues.add(0);
                }
                break;
            } else {
                for (int iterator  = 1; iterator  <= numberOfGroupIncrement && index + iterator  < charArray.length; iterator ++) {
                    currChar = charArray[index + iterator ];
                    if (currChar == 'z') {
                        while (currChar == 'z' && index + iterator  < charArray.length) {
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

    private static int getNumberFromChar(char currChar) {
        if (currChar == '_') {
            return 0;
        } else {
            return currChar - 'a' + 1;
        }
    }
}
