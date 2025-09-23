package com.juaracoding.ecommerce.commons;

import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.DragDropPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {
        DragDropPage dragDropPage = new DragDropPage(getDriver());

        Assert.assertEquals(dragDropPage.getLabel(), "Drop Here");

        String bgColorBefore = dragDropPage.getBgColor();
        System.out.println(bgColorBefore);
        Assert.assertEquals(bgColorBefore, "rgba(233, 233, 233, 1)");

        String textColorBefore = dragDropPage.getTextColor();
        System.out.println(textColorBefore);
        Assert.assertEquals(textColorBefore, "rgba(51, 51, 51, 1)");

        dragDropPage.performDragAndDrop();

        String textColorAfter = dragDropPage.getTextColor();
        System.out.println(textColorAfter);
        Assert.assertEquals(textColorAfter, "rgba(119, 118, 32, 1)");

        Assert.assertEquals(dragDropPage.getLabel(), "Dropped!");

        String bgColorAfter = dragDropPage.getBgColor();
        System.out.println(bgColorAfter);
        Assert.assertEquals(bgColorAfter, "rgba(255, 250, 144, 1)");

        getDriver().quit();
    }

    @Test
    public void scrollTest() throws InterruptedException {
        DragDropPage dragDropPage = new DragDropPage(getDriver());
        dragDropPage.scrollDown(600);
        Thread.sleep(4000);
    }

}
