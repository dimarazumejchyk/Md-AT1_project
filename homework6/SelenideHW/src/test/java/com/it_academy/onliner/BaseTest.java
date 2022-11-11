package com.it_academy.onliner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.it_academy.onliner.pageobject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    private final static String ONLINER_URL = "https://www.onliner.by/";

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @BeforeEach
    public void init(){
        setUp();
        HomePage homePage = new HomePage();
        homePage.openOnliner(ONLINER_URL);
        homePage.openCatalogOnliner("Каталог");
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }

}
