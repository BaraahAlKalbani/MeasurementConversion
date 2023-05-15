package com.MeasurementConversion.MeasurementConversion.Model;

import java.util.ArrayList;

public class Result {
    private ArrayList<Integer> converted_value;
    private char[] input;
    private String status ;

    public Result(ArrayList<Integer> converted_value, char[] char_list, String status) {
        this.converted_value = converted_value;
        this.input = char_list;
        this.status = status;
    }

    public ArrayList<Integer> getConverted_value() {
        return converted_value;
    }

    public void setConverted_value(ArrayList<Integer> converted_value) {
        this.converted_value = converted_value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char[] getInput() {
        return input;
    }

    public void setInput(char[] input) {
        this.input = input;
    }
}
