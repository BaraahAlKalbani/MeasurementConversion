package com.MeasurementConversion.MeasurementConversion.Controller;

import com.MeasurementConversion.MeasurementConversion.Model.Result;
import com.MeasurementConversion.MeasurementConversion.Service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = {"*", "Authorization", "Content-Type"})
public class MeasurementController {
    @Autowired
    private ConversionService conversionService;
    @GetMapping("/convert-measurements")
    public Result convertMeasurements(@RequestParam("input") String input) {
        try {
            input = input.replaceAll("\\n", "");
            ArrayList<Integer> convertedValues = ConversionService.decodeString(input);
            return new Result(convertedValues, input.toCharArray(), "Success");
        } catch (IllegalArgumentException e) {
            return new Result(null, input.toCharArray(), "Invalid input: " + e.getMessage());
        }
    }
}
