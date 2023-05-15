package Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConversionService {
    private static final Logger logger = LoggerFactory.getLogger(ConversionService.class);

    public static ArrayList<Integer> decodeString(String input) {
        char[] charArray = input.toCharArray();
        ArrayList<Integer> decodedValues = new ArrayList<>();

        int index = 0;
        while (index < charArray.length) {
            char ch = charArray[index];
            int number = getNumberFromChar(ch);
            int value = 0;

            if (ch == 'z') {
                while (ch == 'z' && index + 1 < charArray.length) {
                    index++;
                    ch = charArray[index];
                    number += getNumberFromChar(ch);
                }
            }

            if (index + number > charArray.length) {
                break;
            }

            if (ch == '_') {
                if (index < charArray.length - 1) {
                    decodedValues.add(0);
                    number = getNumberFromChar(ch);
                }
                break;
            } else {
                value = calculateValue(charArray, index, number);
                decodedValues.add(value);
                index += number + 1;
            }
        }

        return decodedValues;
    }

    private static int getNumberFromChar(char ch) {
        if (ch == '_') {
            return 0;
        } else {
            return ch - 'a' + 1;
        }
    }

    private static int calculateValue(char[] charArray, int startIndex, int length) {
        int value = 0;
        for (int i = 1; i <= length && startIndex + i < charArray.length; i++) {
            char ch = charArray[startIndex + i];
            value += getNumberFromChar(ch);
        }
        return value;
    }
}
