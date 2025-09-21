package com.juaracoding.ecommerce.commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
    private WebDriver driver;
    private int limit = 20;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @Test
    public void testSelectByVisibleText() {
        Select countrySelect = new Select(driver.findElement(By.name("country")));
        countrySelect.selectByVisibleText("INDONESIA");
        WebElement selectedOption =  countrySelect.getFirstSelectedOption();
        assert selectedOption.getText().equals("INDONESIA");
    }

    @Test
    public void testSelectAllOptions() {
        int count = 0;
        Select countrySelect = new Select(driver.findElement(By.name("country")));
        List<WebElement> options = countrySelect.getOptions();
        for (WebElement option : options) {
            if (count >= limit) break;
            count++;
            String expectedOption = option.getText();
            countrySelect.selectByVisibleText(option.getText());
            Assert.assertEquals(countrySelect.getFirstSelectedOption().getText(), 
                expectedOption, "Selected option should match");
        }
    }

    @Test
    public void testSelectBySample() {
        List<String> sampleOptions = List.of("INDONESIA", 
        "CHINA", "FRANCE", "GERMANY", "JAPAN", "MALAYSIA");
        Select countrySelect = new Select(driver.findElement(By.name("country")));
        for (String sample : sampleOptions) {
            countrySelect.selectByVisibleText(sample);
            Assert.assertEquals(countrySelect.getFirstSelectedOption().getText(), 
                sample, "Selected option should match sample");
        } 
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
