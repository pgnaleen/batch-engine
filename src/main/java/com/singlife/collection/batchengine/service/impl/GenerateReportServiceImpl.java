package com.singlife.collection.batchengine.service.impl;

//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.IndexedColors;

import com.singlife.collection.batchengine.service.GenerateReportService;
import com.singlife.collection.batchengine.util.ExcelFileWriter;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateReportServiceImpl implements GenerateReportService {

    @Value("${report.store-path}")
    private String folderPath;
    
    @Override
//    @Scheduled(cron = "20 * * * *")
//    @Scheduled(fixedRate = 1000)
    public void generateReport() {
        System.out.println("test");

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = initWorkbook(workbook);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);// show whole text in the cell

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(0);
        cell.setCellValue("John Smith");

        cell = row.createCell(1);
        cell.setCellValue(20);

        ExcelFileWriter.writeExcelFile(workbook, folderPath);
    }

    private Sheet initWorkbook(Workbook workbook) {
        Sheet sheet = workbook.createSheet("Successful Reciting Data Report");
        for (int column = 0; column < 14; ++column) {
            sheet.setColumnWidth(column, 8000);
        }

        Row header = sheet.createRow(0);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        headerStyle.setFont(font);

        List<String> headerNames = new ArrayList<>(List.of("Receipt No", "Policy No", "Receipt Amount",
                "Policyowner Name", "Merchant A/C No.", "Transaction Date", "Transaction Time", "Payer Name",
                "Transaction Amount", "QR Reference Number", "Bank Transaction ID", "Original Transaction ID", "Batch ID", "Billing No."));

        for (int columnIndex = 0; columnIndex < headerNames.size(); columnIndex++) {
            Cell headerCell = header.createCell(columnIndex);
            headerCell.setCellValue(headerNames.get(columnIndex));
            headerCell.setCellStyle(headerStyle);
        }

        return sheet;
    }
}
