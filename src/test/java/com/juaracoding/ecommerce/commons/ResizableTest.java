package com.juaracoding.ecommerce.commons;

import org.testng.annotations.Test;

import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.ResizablePage;

public class ResizableTest extends BaseTest{
    
    @Test
    public void resizableTest() throws InterruptedException {
        ResizablePage resizablePage = new ResizablePage(getDriver());
        resizablePage.resize(200,300);

        String expectedHeight = 150 + 300 +"px";
        String expectedWidth = 150 + 200 + "px";

        String actualHeight = resizablePage.getHeight();
        String actualWidth = resizablePage.getWidth();

        assert expectedHeight.equals(actualHeight);
        assert expectedWidth.equals(actualWidth);

        Thread.sleep(4000);
        getDriver().quit();
    }
}
