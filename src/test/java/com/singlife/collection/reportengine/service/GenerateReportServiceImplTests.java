package com.singlife.collection.reportengine.service;

import com.singlife.collection.reportengine.entity.*;
import com.singlife.collection.reportengine.repository.*;
import com.singlife.collection.reportengine.service.impl.GenerateReportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
class GenerateReportServiceImplTests {
	@Mock
	NotificationRepository notificationRepository;
	@Mock
	ProductTransactionRepository productTransactionRepository;
	@Mock
	CollectionTransactionRepository collectionTransactionRepository;
	@Mock
	VendorInwardCreditNotificationRepository vendorInwardCreditNotificationRepository;
	@Mock
	CustInfoRepository custInfoRepository;
	@Mock
	NotificationTemplateRepository notificationTemplateRepository;
	private GenerateReportServiceImpl generateReportService;

	@BeforeEach
	void init() {
		CollectionTransaction collectionTransaction = getCollectionTransaction();
		ProductTransaction productTransaction = getProductionTransaction(collectionTransaction);
		Notification notification = getNotification(collectionTransaction);
		when(notificationRepository.findAll()).thenReturn(List.of(notification));
		when(productTransactionRepository.findAll()).thenReturn(List.of(productTransaction));

		this.generateReportService = new GenerateReportServiceImpl(
				collectionTransactionRepository,
				productTransactionRepository,
				vendorInwardCreditNotificationRepository,
				custInfoRepository,
				notificationTemplateRepository,
				notificationRepository);
		this.generateReportService.setFolderPath(".");
	}

	private CollectionTransaction getCollectionTransaction() {
		return new CollectionTransaction(
				1,
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
	}

	private ProductTransaction getProductionTransaction(CollectionTransaction collectionTransaction) {

		return new ProductTransaction(
				1,
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
	}

	private Notification getNotification(CollectionTransaction collectionTransaction) {
		VendorInwardCreditNotification vendorInwardCreditNotification = new VendorInwardCreditNotification(
				1,
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

		CustInfo custInfo = new CustInfo(
				1,
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

		NotificationTemplate notificationTemplate = new NotificationTemplate(
				1,
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

		return new Notification(
				1,
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
	}

	@Test
	void generateReport_methodTest() {
		this.generateReportService.generateReport();
	}
}
