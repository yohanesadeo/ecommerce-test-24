package com.juaracoding.ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest  {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Setup Test Class");
        driver = new ChromeDriver();
    }
    
    @Test
    public void testBrowser() {
        driver.get("https://www.saucedemo.com/v1/"); 
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle, "Title should be Swag Labs");  
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/v1/"); 
        WebElement usernameField = driver.findElement( 
            org.openqa.selenium.By.id("user-name"));
        WebElement passwordField = driver.findElement(
            org.openqa.selenium.By.id("password"));
        WebElement loginButton = driver.findElement(
            org.openqa.selenium.By.id("login-button"));
            
        usernameField.sendKeys("standard_user");
        Thread.sleep(2000);
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/v1/inventory.html";
        Assert.assertEquals(actualURL, expectedURL, "URL should be inventory page");
    }
            

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
