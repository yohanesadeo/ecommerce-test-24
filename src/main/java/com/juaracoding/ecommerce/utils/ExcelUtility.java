package com.juaracoding.ecommerce.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public ExcelUtility(String excelPath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("Error initializing Excel file: " + e.getMessage());
        }
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public int getCellData(int rowNum, int colNum) {
        DataFormatter formatter = new DataFormatter();
        return Integer.parseInt(formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum)));
    }
}
