package com.it_academy.onliner.pageobject;
import com.it_academy.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import static com.it_academy.onliner.utils.ExpectedResults.expectedElementsFromCatalogAsideList;
import static com.it_academy.onliner.utils.ExpectedResults.expectedElementsFromCatalogClassifier;
import static com.it_academy.onliner.utils.ExpectedResults.expectedElementsFromCatalogDropdownList;
import static com.it_academy.onliner.utils.ExpectedResults.getStringValues;
import static java.lang.String.format;
public class CatalogPage extends BasePage {
    private static final String CATALOG_NAVIGATION_ASIDE_LINKS_XPATH_PATTERN =
            "//div[contains(text(), '%s')]";
    private static final String CATALOG_NAVIGATION_CLASSIFIER_LINKS_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']//span[contains(text(), '%s')]";

    public void clickOnCatalogNavigationClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_NAVIGATION_CLASSIFIER_LINKS_XPATH_PATTERN, link))).click();
    }
    public void navigateToCatalogElements(String link) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(waitForElementVisible((By.xpath(format(CATALOG_NAVIGATION_ASIDE_LINKS_XPATH_PATTERN, link))))).build().perform();
    }
    public boolean checkElementsFromCatalogClassifier() {
        List<WebElement> elementsFromCatalogClassifier =
                waitForElementVisible(By.xpath("//ul[@class='catalog-navigation-classifier ']"))
                        .findElements(By.xpath("//ul[@class='catalog-navigation-classifier ']" +
                                "//li[@class='catalog-navigation-classifier__item ']"));
        List<String> actualElementsFromCatalogClassifier = getStringValues(elementsFromCatalogClassifier);
        return actualElementsFromCatalogClassifier.containsAll(expectedElementsFromCatalogClassifier());
    }
    public boolean checkElementsFromCatalogAsideList() {
        List<WebElement> elementsAsideList =
                waitForElementVisible(By.xpath("//div[@class='catalog-navigation-list__aside catalog-navigation-list__aside_active']"))
                        .findElements(By.xpath("//div[@class='catalog-navigation-list__aside catalog-navigation-list__aside_active']"
                                + "//div[@class='catalog-navigation-list__aside-title']"));
        List<String> actualAsideList = getStringValues(elementsAsideList);
        return actualAsideList.containsAll(expectedElementsFromCatalogAsideList());
    }
    public boolean checkElementsFromCatalogDropdownList() {
        List<WebElement> elementsNamesDropdownList =
                waitForElementVisible(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']"))
                        .findElements(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                                "//span[@class='catalog-navigation-list__dropdown-title']"));
        List<String> actualNamesDropdownList = getStringValues(elementsNamesDropdownList);
        return actualNamesDropdownList.containsAll(expectedElementsFromCatalogDropdownList());
    }
    public boolean checkPriceQuantityDropdownList() {
        String priceCheck = "р.";
        String quantityCheck = "товар";
        List<WebElement> elementsPriceQuantityDropdownList =
                waitForElementVisible(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']"))
                        .findElements(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                                "//span[@class='catalog-navigation-list__dropdown-description']"));
        List<String> actualPriceQuantityDropdownList = getStringValues(elementsPriceQuantityDropdownList);
        boolean boo = true;
        for (String temp : actualPriceQuantityDropdownList) {
            boolean result = temp.contains(priceCheck) & temp.contains(quantityCheck);
            if (!result) {
                boo = false;
            }
        }
        return boo;
    }
}
