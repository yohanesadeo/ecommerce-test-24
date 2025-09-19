package com.juaracoding.ecommerce;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver driverManager(String driverType) {
        if (driver == null) {
            DriverService driverService = new DriverService();
            driver = driverService.driverManager(driverType);
        }
        return driver;
    }

    public static void closeObjectInstance() {
        driver.quit();
        driver = null;
    }

}
