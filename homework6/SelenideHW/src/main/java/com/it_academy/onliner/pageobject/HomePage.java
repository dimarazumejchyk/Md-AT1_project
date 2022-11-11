package com.it_academy.onliner.pageobject;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage {
    private static final String CATALOG_LINK = "//span[@class='b-main-navigation__text' and contains(text(), '%s')]";

    public CatalogPage  openCatalogOnliner(String link) {
       $x(format(CATALOG_LINK, link))
               .shouldBe(visible, ofSeconds(10)).click();
       return new CatalogPage();
    }

    public HomePage openOnliner(String url){
        Selenide.open(url);
        return this;
    }
}
