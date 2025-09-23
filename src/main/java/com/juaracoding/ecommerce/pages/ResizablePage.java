package com.juaracoding.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizablePage {
    private WebDriver driver;
    private By resizableHandle = By.xpath("//*[@id='resizable']//div[contains(@class, 'ui-resizable-se')]");
    private Actions actions;
    private JavascriptExecutor jse;

    public ResizablePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void resize(int xOffset, int yOffset) {
        actions.moveToElement(driver.findElement(resizableHandle))
                .pause(Duration.ofSeconds(2))
                .clickAndHold()
                .moveByOffset(xOffset, yOffset)
                .release();
        actions.perform();
    }

    public void resize() {
        resize(200, 100);
    }

    public String getHeight() {
        return (String) jse.executeScript("return document.getElementById('resizable').style.height;");
    }

    public String getWidth() {
        return (String) jse.executeScript("return document.getElementById('resizable').style.width;");
    }
}
