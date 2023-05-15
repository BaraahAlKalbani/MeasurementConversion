package Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionService.class);

    public static ArrayList<Integer> decodeString(String input) {
        if (!input.matches("[a-z_A-Z]+")) {
            logger.info("Invalid Input!");
            throw new IllegalArgumentException("Invalid input. Input should only contain characters from 'a' to 'z' and '_'.");
        }
        char[] charArray = input.toCharArray();
        ArrayList<Integer> decodedValues = new ArrayList<>();

        int index = 0;
        while (index < charArray.length) {
            char currChar = charArray[index];
            int numberOfCharGroup = getNumberFromChar(currChar);
            int value = 0;

            if (currChar == 'z') {
                while (currChar == 'z' && index + 1 < charArray.length) {
                    index++;
                    currChar = charArray[index];
                    numberOfCharGroup += getNumberFromChar(currChar);
                }
            }

            if (index + numberOfCharGroup > charArray.length) {
                break;
            }

            if (currChar == '_') {
                if (index < charArray.length - 1) {
                    decodedValues.add(0);
                    numberOfCharGroup = getNumberFromChar(currChar);
                }
                break;
            } else {
                value = calculateValue(charArray, index, numberOfCharGroup);
                decodedValues.add(value);
                index += numberOfCharGroup + 1;
            }
        }
        logger.info("Input: "+input);
        logger.info("Result:"+decodedValues);
        return decodedValues;
    }

    private static int getNumberFromChar(char currChar) {
        if (currChar == '_') {
            return 0;
        } else {
            return currChar - 'a' + 1;
        }
    }

    private static int calculateValue(char[] charArray, int startIndex, int length) {
        int value = 0;
        for (int iterator = 1; iterator <= length && startIndex + iterator < charArray.length; iterator++) {
            char currChar = charArray[startIndex + iterator];
            value += getNumberFromChar(currChar);
        }
        return value;
    }
}
