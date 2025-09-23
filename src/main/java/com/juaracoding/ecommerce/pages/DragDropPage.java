package com.juaracoding.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
    private WebDriver driver;
    private By sourceElement = By.id("draggable");
    private By targetElement = By.id("droppable");
    private Actions actions;
    private JavascriptExecutor jse;

    public DragDropPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void performDragAndDrop() {
        WebElement source = driver.findElement(sourceElement);
        WebElement target = driver.findElement(targetElement);
        actions.dragAndDrop(source, target).perform();
    }

    public String getBgColor() {
        WebElement target = driver.findElement(targetElement);
        return target.getCssValue("background-color");
    }

    public String getTextColor() {
        WebElement target = driver.findElement(targetElement);
        return target.getCssValue("color");
    }

    public String getLabel() {
        WebElement target = driver.findElement(targetElement);
        return target.getText();
    }

    public void scrollDown(int push) {
        jse.executeScript("scroll({top: " + push + ", behavior: 'smooth'})");
    }
}
