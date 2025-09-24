package com.juaracoding.ecommerce.commons;

import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.Test;

import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.ResizablePage;
import com.juaracoding.ecommerce.providers.ResizableProvider;

public class ResizableTest extends BaseTest {

    @Test(dataProvider = "externalResizeData", dataProviderClass = com.juaracoding.ecommerce.providers.ResizableProvider.class)
    public void resizableTest(int xOffset, int yOffset) {
        ResizablePage resizablePage = new ResizablePage(getDriver());
        resizablePage.resize(xOffset, yOffset);

        String expectedHeight = 150 + yOffset + "px";
        String expectedWidth = 150 + xOffset + "px";

        String actualHeight = resizablePage.getHeight();
        String actualWidth = resizablePage.getWidth();

        assert expectedHeight.equals(actualHeight);
        assert expectedWidth.equals(actualWidth);

        getDriver().quit();
    }

    @Test(dataProvider = "externalNegativeResizeData", dataProviderClass = ResizableProvider.class, expectedExceptions = {
            MoveTargetOutOfBoundsException.class })
    public void resizableNegativeTest(int xOffset, int yOffset) {
        ResizablePage resizablePage = new ResizablePage(getDriver());
        resizablePage.resize(xOffset, yOffset);
        getDriver().quit();
    }

}
