package com.it_academy.onliner.pageobject;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage {
    private static final String CATALOG_SECTION = "//ul[@class='catalog-navigation-classifier ']//span[contains(text(), '%s')]";
    private static final String ELEMENT_FROM_CATALOG_ASIDE_LIST = "//div[@class='catalog-navigation-list__aside-title' and text()= '%s']";
    private static final String ELEMENTS_FROM_CATALOG_CLASSIFIER = "//ul[@class='catalog-navigation-classifier ']"
            +"//li[@class='catalog-navigation-classifier__item ']";
    private static final String ELEMENTS_FROM_CATALOG_ASIDE_LIST = "//div[@class='catalog-navigation-list__aside catalog-navigation-list__aside_active']"
            + "//div[@class='catalog-navigation-list__aside-title']";
    private static final String ELEMENTS_FROM_CATALOG_DROPDOWN_LIST = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
            "//span[@class='catalog-navigation-list__dropdown-title']";
    private static final String ELEMENTS_PRICE_AND_QUANTITY = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']"
            + "//span[@class='catalog-navigation-list__dropdown-description']";

    public CatalogPage navigateToCatalogElements(String asideElement) {
        $x(format(ELEMENT_FROM_CATALOG_ASIDE_LIST, asideElement))
                .shouldBe(visible, ofSeconds(10)).hover();
        return this;
    }

    public CatalogPage clickOnCatalogNavigationClassifierLink(String catalogElement) {
        $x(format(CATALOG_SECTION, catalogElement))
                .shouldBe(visible, ofSeconds(10)).click();
        return this;
    }

    public List<String> checkElementsFromCatalogClassifier() {
        List<String> elementsFromCatalogClassifier = $$x(ELEMENTS_FROM_CATALOG_CLASSIFIER)
                .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
        return elementsFromCatalogClassifier;
    }

    public List<String> checkElementsFromCatalogAsideList() {
        List<String> elementsFromCatalogAsideList =
                $$x(ELEMENTS_FROM_CATALOG_ASIDE_LIST)
                        .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
        return elementsFromCatalogAsideList;
    }

    public List<String> checkElementsFromCatalogDropdownList() {
        List<String> elementsNamesDropdownList =
                $$x(ELEMENTS_FROM_CATALOG_DROPDOWN_LIST)
                        .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
        return elementsNamesDropdownList;
    }

    public List<String> checkPriceQuantityDropdownList() {
        List<String> elementsPriceQuantityDropdownList =
                $$x(ELEMENTS_PRICE_AND_QUANTITY)
                        .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
        return elementsPriceQuantityDropdownList;
    }

}
