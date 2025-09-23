package com.juaracoding.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TimeClockPage {
    private WebDriver driver;
    private By dragHourLocatorBefore = By.xpath("//span[@aria-label='12 hours']");
    private By dragHourLocatorAfter = By.xpath("//span[@aria-label='3 hours']");
    // Locator untuk jarum penunjuk menit. Biasanya elemen div setelah pin tengah.
    private By minutePointer = By.xpath("//div[contains(@class,'MuiClock-pin')]/following-sibling::div[1]");

    private Actions actions;
    private JavascriptExecutor jse;

    public TimeClockPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void dragHour() {
        actions.moveToElement(driver.findElement(dragHourLocatorBefore))
                .clickAndHold()
                .moveToElement(driver.findElement(dragHourLocatorAfter))
                .release()
                .perform();
    }

    public void dragMinute() {
        // Setiap menit = 6 derajat (360/60).
        // Untuk mengatur ke 42 menit, rotasinya adalah 42 * 6 = 252 derajat.
        int minuteToSet = 42;
        int rotationDegrees = minuteToSet * 6;

        String script = "arguments[0].style.transform='rotateZ(" + rotationDegrees + "deg)';";
        jse.executeScript(script, driver.findElement(minutePointer));
    }
}
