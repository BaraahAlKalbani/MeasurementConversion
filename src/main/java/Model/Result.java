package Model;

import java.util.ArrayList;

public class Result {
    private ArrayList<Integer> converted_value;
    private char[] char_list;
    private String status ;

    public Result(ArrayList<Integer> converted_value, char[] char_list, String status) {
        this.converted_value = converted_value;
        this.char_list = char_list;
        this.status = status;
    }

    public ArrayList<Integer> getConverted_value() {
        return converted_value;
    }

    public void setConverted_value(ArrayList<Integer> converted_value) {
        this.converted_value = converted_value;
    }

    public char[] getChar_list() {
        return char_list;
    }

    public void setChar_list(char[] char_list) {
        this.char_list = char_list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
