package com.juaracoding.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Locator
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By btnLogin = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method
    public void fillUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }
    
    public void fillPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }
    
    public String getErrorMessage() {
        return driver.findElement(this.errorMessage).getText();
    }
    
    public void clickLoginButton() {
        driver.findElement(this.btnLogin).click();
    }

}
