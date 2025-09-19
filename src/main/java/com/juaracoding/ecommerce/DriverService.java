package com.juaracoding.ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverService {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private WebDriver driver;

    public WebDriver getDriverChrome() {
        return driver = new ChromeDriver();
    }

    public WebDriver getDriverFirefox() {
        return driver = new FirefoxDriver();
    }
  
    public static WebDriver driverManager(String driverType) {
        DriverService ds = new DriverService();

        if (driverType.equalsIgnoreCase(CHROME)) {
            return ds.getDriverChrome();
        } else {
            return ds.getDriverFirefox();
        }

    }
}
