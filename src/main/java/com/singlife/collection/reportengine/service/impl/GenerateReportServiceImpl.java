package com.singlife.collection.reportengine.service.impl;

import com.singlife.collection.reportengine.config.Constants;
import com.singlife.collection.reportengine.entity.*;
import com.singlife.collection.reportengine.repository.*;
import com.singlife.collection.reportengine.service.GenerateReportService;
import com.singlife.collection.reportengine.util.ExcelFileWriter;
import lombok.Setter;
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
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Setter
public class GenerateReportServiceImpl implements GenerateReportService {

    @Value("${report.store-path}")
    private String folderPath;

    private final CollectionTransactionRepository collectionTransactionRepository;
    private final ProductTransactionRepository productTransactionRepository;
    private final VendorInwardCreditNotificationRepository vendorInwardCreditNotificationRepository;
    private final CustInfoRepository custInfoRepository;
    private final NotificationTemplateRepository notificationTemplateRepository;
    private final NotificationRepository notificationRepository;

    public GenerateReportServiceImpl(CollectionTransactionRepository collectionTransactionRepository, ProductTransactionRepository productTransactionRepository, VendorInwardCreditNotificationRepository vendorInwardCreditNotificationRepository, CustInfoRepository custInfoRepository, NotificationTemplateRepository notificationTemplateRepository,
                                     NotificationRepository notificationRepository) {
        this.collectionTransactionRepository = collectionTransactionRepository;
        this.productTransactionRepository = productTransactionRepository;
        this.vendorInwardCreditNotificationRepository = vendorInwardCreditNotificationRepository;
        this.custInfoRepository = custInfoRepository;
        this.notificationTemplateRepository = notificationTemplateRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    @Scheduled(cron = "0 0 * * * *")
    @Async
    public void generateReport() {
        saveData();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = initWorkbook(workbook);
        populateWorkbook(workbook, sheet);

        ExcelFileWriter.writeExcelFile(workbook, folderPath);
    }

    private void populateWorkbook(Workbook workbook, Sheet sheet) {
        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setWrapText(true);// show whole text in the cell

        Map<Integer, ProductTransaction> collectionTransactionProductTransactionMap = new HashMap<>();
        productTransactionRepository.findAll().forEach(productTransaction -> {
            collectionTransactionProductTransactionMap.put(productTransaction.getCollectionTrn().getId(), productTransaction);
        });

        List<Notification> notificationList = notificationRepository.findAll();
        for (int index = 0; index < notificationList.size(); index++) {
            ProductTransaction productTransaction = collectionTransactionProductTransactionMap.get(notificationList.get(index).getCollectionTrn().getId());
            Row dataRow = sheet.createRow(index+1);

            Cell cell = dataRow.createCell(0);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getCollectionTrn().getReceiptNo());

            cell = dataRow.createCell(1);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(productTransaction.getProdId());

            cell = dataRow.createCell(2);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getCollectionTrn().getReceiptAmt());

            cell = dataRow.createCell(3);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getCustInfo().getCustNm());

            cell = dataRow.createCell(4);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getCollectionTrn().getMerchantAcntNo());

            cell = dataRow.createCell(5);
            cell.setCellStyle(dataCellStyle);
            Optional<Timestamp> createdAt = Optional.ofNullable(notificationList.get(index).getCollectionTrn().getCreatedDt());
            if ( createdAt.isPresent() ) {
                String transactionDateFormat = Constants.TRANSACTION_DATE_FORMAT;
                DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(transactionDateFormat);
                cell.setCellValue(createdAt.get().toLocalDateTime().format(europeanDateFormatter));
            }

            cell = dataRow.createCell(6);
            cell.setCellStyle(dataCellStyle);
            if ( createdAt.isPresent() ) {
                String transactionTimeFormat = Constants.TRANSACTION_TIME_FORMAT;
                DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(transactionTimeFormat);
                cell.setCellValue(createdAt.get().toLocalDateTime().format(europeanDateFormatter));
            }

            cell = dataRow.createCell(7);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getCustInfo().getPayerNm());

            cell = dataRow.createCell(8);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getVendorInwardCreditNotification().getTrnAmt());

            cell = dataRow.createCell(9);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getCollectionTrn().getCollectionTrnRefNo());

            cell = dataRow.createCell(10);
            cell.setCellStyle(dataCellStyle);
            cell.setCellValue(notificationList.get(index).getVendorInwardCreditNotification().getTrnRefid());
        }
    }

    private void saveData() {
        CollectionTransaction collectionTransaction = new CollectionTransaction(
                0,
                "1",
                "2",
                "3",
                new Date(90, 7, 28),
                4,
                "5",
                "cts",
                "vts",
                "pss",
                "rcn",
                "rca",
                "ma",
                null,
                "nalin",
                null,
                "nalin",
                1
        );
        collectionTransactionRepository.save(collectionTransaction);

        ProductTransaction productTransaction = new ProductTransaction(
                0,
                collectionTransaction,
                "policy_no",
                "policy_cd",
                "policy_type",
                "policy_nm",
                "pas_sys_id",
                1,
                "policy desc",
                null,
                "nalin",
                null,
                "nalin",
                1,
                "amount"
        );
        productTransactionRepository.save(productTransaction);

        VendorInwardCreditNotification vendorInwardCreditNotification = new VendorInwardCreditNotification(
                0,
                1,
                "msgId",
                "orgId",
                new Timestamp(90, 8, 28, 1,1,1,1),
                "SG",
                "trnType",
                "customerRef",
                "trnRefId",
                new Timestamp(90, 8, 28, 1,1,1,1),
                new Timestamp(90, 8, 28, 1,1,1,1),
                "receiverNm",
                "receiverAccountNo",
                "receiverVirtualAccountNo",
                "receiverVirtualAccountNm",
                "R",
                "receiverProxyValue",
                "tcy",
                5,
                "senderNm",
                "senderAccountNo",
                "senderBankId",
                "senderBankNm",
                "senderBankCd",
                "senderBranchCd",
                "paymentDetails",
                "addtlInfo",
                "purposeCd",
                "billNo",
                "mobileNo",
                "storeLbl",
                "loyaltyNo",
                "refLbl",
                "custLbl",
                "teriminalLbl",
                2L,
                "acd",
                "proprietaryData",
                2,
                2,
                null,
                "nalin",
                null,
                "nalin",
                1
        );
        vendorInwardCreditNotificationRepository.save(vendorInwardCreditNotification);

        CustInfo custInfo = new CustInfo(
                0,
                "docId",
                "docType",
                "docNo",
                "custId",
                "custCd",
                "custNm",
                "payerNm",
                "firstNm",
                "lastNm",
                "address",
                "mobileNo",
                "emailId",
                "mobdty",
                "orgNm",
                "city",
                "statepcd",
                "postalCd",
                new Timestamp(90, 1, 1, 1, 1, 1, 1),
                "createdBy",
                new Timestamp(90, 1, 1, 1, 1, 1, 1),
                "updatedBy",
                1
        );
        custInfoRepository.save(custInfo);

        NotificationTemplate notificationTemplate = new NotificationTemplate(
                0,
                1,
                "templateId",
                "templateNm",
                "temTy",
                null,
                "nalin",
                null,
                "nalin",
                1
        );
        notificationTemplateRepository.save(notificationTemplate);

        Notification notification = new Notification(
                0,
                collectionTransaction,
                vendorInwardCreditNotification,
                custInfo,
                notificationTemplate,
                "statusCd",
                "statsCdV",
                null,
                "nalin",
                null,
                "nalin",
                1
        );
        notificationRepository.save(notification);
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
