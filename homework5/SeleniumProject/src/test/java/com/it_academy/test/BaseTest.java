package com.it_academy.test;
import com.it_academy.onliner.framework.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void webDriverInit() {
        DriverManager.setDriver();
    }
    @AfterClass
    public void webDriverClose() {
        DriverManager.closeDriver();
    }
}
