package com.it_academy.testng.pages;

import com.it_academy.testng.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String ONLINER_URL = "https://onliner.by/";
    private static final String MENU_SECTION =
            "//li[@class='b-main-navigation__item b-main-navigation__item_arrow']//span[contains(text(), '%s')]";

    private static final String DROP_DOWN_MENU =
            "//div[@class='b-main-navigation__dropdown b-main-navigation__dropdown_visible']";
    private static final String ELEMENTS_DROP_DOWN_MENU = "//span[@class='b-main-navigation__dropdown-advert-sign']";

    public void openOnlinerWebsite() {
        DriverManager.getDriver().get(ONLINER_URL);
    }

    public void navigateTo(String linkText) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(waitForElementVisible(By.xpath(format(MENU_SECTION, linkText)))).build().perform();
    }

    public boolean isDropDownMenuIsDisplayed() {
        return isElementDisplayed(By.xpath(DROP_DOWN_MENU));
    }

    public List<String> isElementsFromDropDownDisplayed() {
        List<WebElement> webElements = findElements(By.xpath(DROP_DOWN_MENU + ELEMENTS_DROP_DOWN_MENU));
        List<String> elements = new ArrayList<>();
        webElements.stream().forEach((i) -> {
            elements.add(i.getText());
            System.out.println(i.getText());
        });
        return elements;
    }

}
