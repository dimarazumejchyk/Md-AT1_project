package com.it_academy.onliner.pageobject;
import org.openqa.selenium.By;
public class HomePage extends BasePage {
    private final By CATALOG_LINK =
            By.xpath("//*[@class='b-main-navigation__text' and contains(text(), 'Каталог')]");
    public void  clickOnCatalogLink() {
        waitForElementClickable(CATALOG_LINK).click();
    }
}
