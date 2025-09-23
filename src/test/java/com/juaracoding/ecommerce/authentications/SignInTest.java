package com.juaracoding.ecommerce.authentications;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.LoginPage;
import com.juaracoding.ecommerce.pages.SignInPage;

public class SignInTest extends BaseTest {

    @Test
    public void withoutCredentialsTest() {
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.clickLoginButton();

        String expectedErrorMessage = "Epic sadface: Username is required";

        Assert.assertEquals(signInPage.getErrorMessage(), expectedErrorMessage);

        getDriver().quit();
    }

    @Test
    public void EmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername("standard_user");
        loginPage.clickLoginButton();

        String expectedErrorMessage = "Epic sadface: Password is required";

        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
        getDriver().quit();
    }

    @Test
    public void EmptyUsernameTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();

        String expectedErrorMessage = "Epic sadface: Username is required";

        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
        getDriver().quit();
    }

    @Test
    public void validUsernameAndPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();

        String actualURL = getDriver().getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/v1/inventory.html";

        Assert.assertEquals(actualURL, expectedURL);
        getDriver().quit();
    }
}
