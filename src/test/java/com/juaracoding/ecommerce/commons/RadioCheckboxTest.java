package com.juaracoding.ecommerce.commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioCheckboxTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
    }


    @Test
    public void testRadioButton() {
        WebElement option2 = driver.findElement(By.id("vfb-7-2"));
        option2.click();
        
        Assert.assertTrue(option2.isSelected(), "Option 2 should be selected");
    }

    @Test
    public void testRadioButtons() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        Assert.assertEquals(radioButtons.size(), 3, "There should be 3 radio buttons");

        for (WebElement radioButton : radioButtons) {
            radioButton.click();
            Assert.assertTrue(radioButton.isSelected(), "Radio button should be selected");
        }
    }

    @Test
    public void testCheckbox() {
        WebElement checkbox = driver.findElement(By.id("vfb-6-2"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected(), "Checkbox should be selected");
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected(), "Checkbox should not be selected");
    }

    @Test
    public void testCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        Assert.assertEquals(checkboxes.size(), 3, "There should be 3 checkboxes");

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected(), "Checkbox should be selected");
            checkbox.click();
            Assert.assertFalse(checkbox.isSelected(), "Checkbox should not be selected");
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
