package com.it_academy.testng.hooks;

import com.it_academy.testng.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static com.it_academy.testng.driver.DriverManager.getDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverHooks {

    private static final int IMPLICIT_WAIT_TIMEOUT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 10;

    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}


