package com.singlife.collection.batchengine.controller;

import com.singlife.collection.batchengine.service.GenerateReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sg/v1/report")
public class GenerateReportController {

    private final GenerateReportService generateReportService;

    public GenerateReportController(GenerateReportService generateReportService) {
        this.generateReportService = generateReportService;
    }

    @GetMapping
    public String generateReport(@RequestParam String requestBody) {
        generateReportService.generateReport();

        return "";
    }
}
