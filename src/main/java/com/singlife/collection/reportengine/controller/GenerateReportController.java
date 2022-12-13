package com.singlife.collection.reportengine.controller;

import com.singlife.collection.reportengine.service.GenerateReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sg/v1/report-engine")
public class GenerateReportController {

    private final GenerateReportService generateReportService;

    public GenerateReportController(GenerateReportService generateReportService) {
        this.generateReportService = generateReportService;
    }

    @GetMapping("/customer/report")
    public String generateReport() {
        generateReportService.generateReport();

        return "{\"status\":\"200\",\"message\":\"report generated successfully.\"}";
    }
}
