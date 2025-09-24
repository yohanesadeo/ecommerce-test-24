package com.juaracoding.ecommerce.providers;

import org.testng.annotations.DataProvider;

import com.juaracoding.ecommerce.utils.ExcelUtility;

public class ResizableProvider {

    @DataProvider(name = "resizeData")
    public Object[][] getAttributes() {
        return new Object[][] {
                { 100, 150 },
                { 200, 250 },
                { 300, 350 }
        };
    }

    @DataProvider(name = "externalResizeData")
    public Object[][] getExternalAttributes() {
        String filePath = "src/test/resources/DataProvider.xlsx";
        ExcelUtility excel = new ExcelUtility(filePath, "Sheet1");

        int rowCount = excel.getRowCount();
        int colCount = excel.getColumnCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        return data;
    }

    @DataProvider(name = "externalNegativeResizeData")
    public Object[][] getExternalNegativeAttributes() {
        String filePath = "src/test/resources/DataProvider.xlsx";
        ExcelUtility excel = new ExcelUtility(filePath, "Sheet2");

        int rowCount = excel.getRowCount();
        int colCount = excel.getColumnCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }

        return data;
    }
}
