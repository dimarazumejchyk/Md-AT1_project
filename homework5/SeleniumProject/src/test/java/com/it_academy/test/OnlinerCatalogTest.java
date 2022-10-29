package com.it_academy.test;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.it_academy.onliner.framework.DriverManager.getDriver;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class OnlinerCatalogTest extends BaseTest {
    private HomePage homePage;
    private CatalogPage catalogPage;
    @BeforeClass
    public void webDriverInit() {
        homePage = new HomePage();
        catalogPage = new CatalogPage();
        getDriver().get("https://www.onliner.by/");
    }
    @Test
    public void test1() {
        homePage.clickOnCatalogLink();
        assertEquals("Elements don't match", true, catalogPage.checkElementsFromCatalogClassifier());
    }
    @Test
    public void test2() {
        homePage.clickOnCatalogLink();
        catalogPage.clickOnCatalogNavigationClassifierLink("Компьютеры ");
        catalogPage.navigateToCatalogElements("Комплектующие");
        assertEquals("Elements don't match", true, catalogPage.checkElementsFromCatalogAsideList());
    }
    @Test
    public void test3() {
        homePage.clickOnCatalogLink();
        catalogPage.clickOnCatalogNavigationClassifierLink("Компьютеры ");
        catalogPage.navigateToCatalogElements("Комплектующие");
        assertEquals("Elements don't match", true, catalogPage.checkElementsFromCatalogDropdownList());
        assertEquals("Elements do not contain quantity or price", true, catalogPage.checkPriceQuantityDropdownList());
    }
}
