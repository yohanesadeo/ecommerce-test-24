package com.juaracoding.ecommerce.authentications;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.juaracoding.ecommerce.BaseTest;

public class SignInTest extends BaseTest {

    @Test
    public void withoutCredentialsTest() {

        WebElement loginButton = getDriver().findElement(
                org.openqa.selenium.By.id("login-button"));
        loginButton.click();

        WebElement errorMessage = getDriver().findElement(
                org.openqa.selenium.By.cssSelector("h3[data-test='error']"));
        String actualString = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username is required";

        Assert.assertEquals(actualString, expectedErrorMessage);

        getDriver().quit();
    }

    @Test
    public void EmptyPasswordTest() {

        WebElement usernameField = getDriver().findElement(
                org.openqa.selenium.By.id("user-name"));
        WebElement loginButton = getDriver().findElement(
                org.openqa.selenium.By.id("login-button"));

        usernameField.sendKeys("standard_user");
        loginButton.click();

        WebElement errorMessage = getDriver().findElement(
                org.openqa.selenium.By.cssSelector("h3[data-test='error']"));
        String actualString = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(actualString, expectedErrorMessage);
        getDriver().quit();
    }

    @Test
    public void EmptyUsernameTest() {
        WebElement passwordField = getDriver().findElement(
                org.openqa.selenium.By.id("password"));
        WebElement loginButton = getDriver().findElement(
                org.openqa.selenium.By.id("login-button"));

        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        WebElement errorMessage = getDriver().findElement(
                org.openqa.selenium.By.cssSelector("h3[data-test='error']"));
        String actualString = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username is required";

        Assert.assertEquals(actualString, expectedErrorMessage);
        getDriver().quit();
    }
}
