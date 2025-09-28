package com.juaracoding.ecommerce.providers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.juaracoding.ecommerce.utils.DBConnectionUtility;
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

    @DataProvider(name = "externalResizeDataFromDB")
    public Object[][] getExternalAttributesFromDB() {
        String sql = "SELECT * FROM dimensions";
        List<Object[]> rows = new ArrayList<>();

        try (Connection conn = DBConnectionUtility.connect();
                Statement statement = conn.createStatement();) {
                    
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                rows.add(new Object[] { x, y });
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching data from database", e);
        }

        Object[][] data = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
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
