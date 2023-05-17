package com.MeasurementConversion.MeasurementConversion.Model;

import java.util.ArrayList;

/**
 * Represents the result of a measurement conversion operation.
 */
public class Result {
    private ArrayList<Integer> converted_value;
    private char[] input;
    private String status;

    /**
     * Constructs a Result object with the specified converted value, input characters, and status.
     *
     * @param converted_value The converted value as an ArrayList of integers.
     * @param char_list       The input characters as an array of characters.
     * @param status          The status of the conversion operation.
     */
    public Result(ArrayList<Integer> converted_value, char[] char_list, String status) {
        this.converted_value = converted_value;
        this.input = char_list;
        this.status = status;
    }

    /**
     * Gets the converted value.
     *
     * @return The converted value as an ArrayList of integers.
     */
    public ArrayList<Integer> getConverted_value() {
        return converted_value;
    }

    /**
     * Sets the converted value.
     *
     * @param converted_value The converted value as an ArrayList of integers.
     */
    public void setConverted_value(ArrayList<Integer> converted_value) {
        this.converted_value = converted_value;
    }

    /**
     * Gets the status of the conversion operation.
     *
     * @return The status of the conversion operation.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the conversion operation.
     *
     * @param status The status of the conversion operation.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the input characters.
     *
     * @return The input characters as an array of characters.
     */
    public char[] getInput() {
        return input;
    }

    /**
     * Sets the input characters.
     *
     * @param input The input characters as an array of characters.
     */
    public void setInput(char[] input) {
        this.input = input;
    }
}
