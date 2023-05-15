package Controller;

import Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", allowedHeaders = {"*", "Authorization", "Content-Type"})

public class MeasurementController {
    @Autowired
    private MeasurementController measurementController;
    @GetMapping("/convert-measurements")

    public Result convertMeasurements(@RequestParam("input") String input) {
        // Your conversion logic here
        return null;
    }
}
