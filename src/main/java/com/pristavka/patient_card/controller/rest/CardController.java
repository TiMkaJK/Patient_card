package com.pristavka.patient_card.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/card")
public class CardController {

    @PostMapping(path = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String importXlsx(@RequestParam(name = "file") MultipartFile files) throws IOException {

        var workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        String line = null;

        for (var index = 1; index < worksheet.getPhysicalNumberOfRows(); index++) {

            XSSFRow row = worksheet.getRow(index);

            line = row.getCell(0).getNumericCellValue() + " " +
                    row.getCell(1).getStringCellValue() + " " +
                    row.getCell(2).getStringCellValue() + " " +
                    row.getCell(3).getNumericCellValue() + " " +
                    row.getCell(4).getNumericCellValue();
        }

        return line;
    }
}
