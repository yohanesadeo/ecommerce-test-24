package com.juaracoding.ecommerce.authentications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInNegativeTest {
    
    public WebDriver getDriver(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        return driver;
    }

    @Test
    public void withoutCredentialsTest() {

        WebDriver driver = getDriver("https://www.saucedemo.com/v1/");
        WebElement loginButton = driver.findElement(
            org.openqa.selenium.By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(
            org.openqa.selenium.By.cssSelector("h3[data-test='error']"));
        String actualString = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username is required";

        Assert.assertEquals(actualString, expectedErrorMessage);

        driver.quit();
    }

    @Test 
    public void EmptyPasswordTest() {
        WebDriver driver = getDriver("https://www.saucedemo.com/v1/");

        WebElement usernameField = driver.findElement( 
            org.openqa.selenium.By.id("user-name"));
        WebElement loginButton = driver.findElement(
            org.openqa.selenium.By.id("login-button"));

        usernameField.sendKeys("standard_user");
        loginButton.click();

        WebElement errorMessage = driver.findElement(
            org.openqa.selenium.By.cssSelector("h3[data-test='error']"));
        String actualString = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualString, expectedErrorMessage);
        driver.quit();
    }

    @Test
    public void EmptyUsernameTest() {
        WebDriver driver = getDriver("https://www.saucedemo.com/v1/");

        WebElement passwordField = driver.findElement(
            org.openqa.selenium.By.id("password"));
        WebElement loginButton = driver.findElement(
            org.openqa.selenium.By.id("login-button"));

        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        WebElement errorMessage = driver.findElement(
            org.openqa.selenium.By.cssSelector("h3[data-test='error']"));
        String actualString = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username is required";

        Assert.assertEquals(actualString, expectedErrorMessage);
        driver.quit();
    }
}
