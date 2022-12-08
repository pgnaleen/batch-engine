package com.singlife.collection.batchengine.util;

import com.singlife.collection.batchengine.config.Constants;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelFileWriter {

    private static Logger logger = LoggerFactory.getLogger(ExcelFileWriter.class);
    private static final SimpleDateFormat reportDateFormat = new SimpleDateFormat(Constants.REPORT_DATE_FORMAT);

    public static void writeExcelFile(Workbook workbook, String folderPath) {
        File currDir = new File(folderPath);
        Date date = new Date();
        String fileLocation = currDir.getAbsolutePath() + "/" + Constants.REPORT_PREFIX +
                reportDateFormat.format(new Timestamp(date.getTime())) +".xlsx";

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException ex) {
            logger.info(ex.toString());
            throw new RuntimeException(Constants.FILE_WRITING_ERROR);
        }
    }
}
