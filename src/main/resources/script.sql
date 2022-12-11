CREATE DATABASE collection_SIT;
use collection_SIT;

-- collection_SIT.collection_transaction definition

CREATE TABLE `collection_transaction` (
                                          `id` int(11) NOT NULL auto_increment,
                                          `requester_ref_no` varchar(35) NOT NULL,
                                          `transaction_mode` varchar(20) NOT NULL,
                                          `collection_trn_ref_no` varchar(35) NOT NULL,
                                          `expiry_dt` date NOT NULL,
                                          `trn_amt` decimal(15,0) NOT NULL,
                                          `requester_id` varchar(35) NOT NULL,
                                          `collection_status` varchar(15) DEFAULT NULL,
                                          `vendor_trn_status` varchar(15) DEFAULT NULL,
                                          `pas_system_status` varchar(15) DEFAULT NULL,
                                          `receipt_no` varchar(15) DEFAULT NULL,
                                          `receipt_amt` varchar(15) DEFAULT NULL,
                                          `merchant_acnt_no` varchar(15) DEFAULT NULL,
                                          `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                          `created_by` varchar(20) NOT NULL,
                                          `updated_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                          `updated_by` varchar(20) NOT NULL,
                                          `version` decimal(10,0) NOT NULL,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='master table for the collection';

-- collection_SIT.vendor_inward_credit_notification definition

CREATE TABLE `vendor_inward_credit_notification` (
                                                     `id` int(11) NOT NULL auto_increment,
                                                     `collection_trn_id` int(11) NOT NULL,
                                                     `msg_id` varchar(35) NOT NULL,
                                                     `org_id` varchar(12) NOT NULL,
                                                     `time_stamp` timestamp NOT NULL,
                                                     `country` varchar(2) NOT NULL,
                                                     `trn_type` varchar(50) NOT NULL,
                                                     `customer_Ref` varchar(15) NOT NULL,
                                                     `trn_refid` varchar(35) NOT NULL,
                                                     `trn_dt` datetime NOT NULL,
                                                     `value_dt` datetime NOT NULL,
                                                     `receiver_nm` varchar(140) DEFAULT NULL,
                                                     `receiver_account_no` varchar(34) NOT NULL,
                                                     `receiver_virtual_account_no` varchar(34) DEFAULT NULL,
                                                     `receiver_virtual_account_nm` varchar(140) DEFAULT NULL,
                                                     `receiver_proxy_type` varchar(1) DEFAULT NULL,
                                                     `receiver_proxy_value` varchar(34) DEFAULT NULL,
                                                     `trn_ccy` varchar(3) NOT NULL,
                                                     `trn_amt` decimal(10,0) NOT NULL,
                                                     `sender_nm` varchar(140) DEFAULT NULL,
                                                     `sender_account_no` varchar(34) DEFAULT NULL,
                                                     `sender_bank_id` varchar(34) DEFAULT NULL,
                                                     `sender_bank_nm` varchar(70) DEFAULT NULL,
                                                     `sender_bank_cd` varchar(34) DEFAULT NULL,
                                                     `sender_branch_cd` varchar(34) DEFAULT NULL,
                                                     `payment_details` varchar(210) DEFAULT NULL,
                                                     `addtl_info` varchar(520) DEFAULT NULL,
                                                     `purpose_cd` varchar(20) DEFAULT NULL,
                                                     `bill_no` varchar(25) DEFAULT NULL,
                                                     `mobile_no` varchar(25) DEFAULT NULL,
                                                     `store_lbl` varchar(25) DEFAULT NULL,
                                                     `loyalty_no` varchar(25) DEFAULT NULL,
                                                     `ref_lbl` varchar(25) DEFAULT NULL,
                                                     `cust_lbl` varchar(25) DEFAULT NULL,
                                                     `teriminal_lbl` varchar(25) DEFAULT NULL,
                                                     `purp_trn` bigint(25) DEFAULT NULL,
                                                     `addtl_con_data` varchar(3) DEFAULT NULL,
                                                     `proprietary_data` varchar(81) NOT NULL,
                                                     `merchant_pan` decimal(19,0) NOT NULL,
                                                     `convenience_fee` decimal(12,0) NOT NULL,
                                                     `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                     `created_by` varchar(20) NOT NULL,
                                                     `updated_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                     `updated_by` varchar(20) NOT NULL,
                                                     `version` decimal(10,0) NOT NULL,
                                                     PRIMARY KEY (`id`),
                                                     KEY `collection_trn_id` (`collection_trn_id`),
                                                     CONSTRAINT `vendor_inward_credit_notification_ibfk_1` FOREIGN KEY (`collection_trn_id`) REFERENCES `collection_transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='master table for the collection';

-- collection_SIT.product_transaction definition

CREATE TABLE `product_transaction` (
                                       `id` int(11) NOT NULL auto_increment,
                                       `collection_trn_id` int(11) NOT NULL,
                                       `prod_id` varchar(20) NOT NULL COMMENT 'Ex: policy_no',
                                       `prod_cd` varchar(20) NOT NULL COMMENT 'Ex:',
                                       `prod_type` varchar(35) NOT NULL COMMENT 'Ex: Policies and Applications',
                                       `prod_nm` varchar(35) NOT NULL COMMENT 'Ex: Singlife simple Term, Singlife Whole Life',
                                       `pas_sys_id` varchar(35) NOT NULL COMMENT 'Ex: Life 400,PolicyAsia',
                                       `prod_category` decimal(15,0) NOT NULL COMMENT 'Health,Life..etc',
                                       `prod_desc` varchar(15) DEFAULT NULL,
                                       `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       `created_by` varchar(20) NOT NULL,
                                       `updated_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       `updated_by` varchar(20) NOT NULL,
                                       `version` decimal(10,0) NOT NULL,
                                       `prod_amt` varchar(20) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       KEY `collection_trn_id` (`collection_trn_id`),
                                       CONSTRAINT `product_transaction_ibfk_1` FOREIGN KEY (`collection_trn_id`) REFERENCES `collection_transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table for the products like policies/applications';

-- collection_SIT.cust_info definition

CREATE TABLE `cust_info` (
                             `id` int(11) NOT NULL auto_increment,
                             `doc_id` varchar(20) NOT NULL,
                             `doc_type` varchar(20) NOT NULL,
                             `doc_no` varchar(20) NOT NULL,
                             `cust_id` varchar(20) NOT NULL,
                             `cust_cd` varchar(20) NOT NULL,
                             `cust_nm` varchar(10) NOT NULL,
                             `payer_nm` varchar(10) NOT NULL,
                             `first_nm` varchar(10) NOT NULL,
                             `last_nm` varchar(10) NOT NULL,
                             `address` varchar(10) NOT NULL,
                             `mobile_no` varchar(10) NOT NULL,
                             `email_id` varchar(10) NOT NULL,
                             `mobile_device_type` varchar(10) NOT NULL,
                             `org_nm` varchar(10) NOT NULL,
                             `city` varchar(10) NOT NULL,
                             `state_provience_cd` varchar(10) NOT NULL,
                             `postal_cd` varchar(10) NOT NULL,
                             `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `created_by` varchar(20) NOT NULL,
                             `updated_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `updated_by` varchar(20) NOT NULL,
                             `version` decimal(10,0) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table for the cust_info details';

-- collection_SIT.notification_template definition

CREATE TABLE `notification_template` (
                                         `id` int(11) NOT NULL auto_increment,
                                         `notification_id` int(20) NOT NULL,
                                         `template_id` varchar(10) NOT NULL,
                                         `template_nm` varchar(10) NOT NULL,
                                         `template_type` varchar(10) NOT NULL,
                                         `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                         `created_by` varchar(20) NOT NULL,
                                         `updated_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                         `updated_by` varchar(20) NOT NULL,
                                         `version` decimal(10,0) NOT NULL,
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table for the notification templates like Email,SMS,Push Notifications';

-- collection_SIT.notification definition

CREATE TABLE `notification` (
                                `id` int(11) NOT NULL auto_increment,
                                `collection_trn_id` int(11) NOT NULL,
                                `vendor_inward_credit_notification_id` int(11) NOT NULL,
                                `cust_info_id` int(11) NOT NULL,
                                `notification_template_id` int(11) NOT NULL,
                                `status_cd` varchar(10) NOT NULL,
                                `status_cd_val` varchar(10) NOT NULL,
                                `created_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `created_by` varchar(20) NOT NULL,
                                `updated_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `updated_by` varchar(20) NOT NULL,
                                `version` decimal(10,0) NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `collection_trn_id` (`collection_trn_id`),
                                KEY `vendor_inward_credit_notification_id` (`vendor_inward_credit_notification_id`),
                                KEY `cust_info_id` (`cust_info_id`),
                                KEY `notification_template_id` (`notification_template_id`),
                                CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`collection_trn_id`) REFERENCES `collection_transaction` (`id`),
                                CONSTRAINT `notification_ibfk_2` FOREIGN KEY (`vendor_inward_credit_notification_id`) REFERENCES `vendor_inward_credit_notification` (`id`),
                                CONSTRAINT `notification_ibfk_3` FOREIGN KEY (`cust_info_id`) REFERENCES `cust_info` (`id`),
                                CONSTRAINT `notification_ibfk_4` FOREIGN KEY (`notification_template_id`) REFERENCES `notification_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='table for the notifications like Email,SMS,Push Notifications';