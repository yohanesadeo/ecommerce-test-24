package com.juaracoding.ecommerce.commons;

import org.testng.annotations.Test;

import com.juaracoding.ecommerce.BaseTest;
import com.juaracoding.ecommerce.pages.TimeClockPage;

public class TimeClockTest extends BaseTest {

    @Test
    public void timeClockTest() throws InterruptedException {
        TimeClockPage timeClockPage = new TimeClockPage(getDriver());
        timeClockPage.dragHour();
        timeClockPage.dragMinute();
        Thread.sleep(4000);
        getDriver().quit();
    }

}
