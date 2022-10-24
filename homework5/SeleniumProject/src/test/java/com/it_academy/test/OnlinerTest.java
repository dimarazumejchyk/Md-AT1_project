package com.it_academy.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Test
public class OnlinerTest {

    @Test (enabled = false)
    public static void checkPresence(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        System.out.println(element.getText() + " - element is displayed: " + element.isDisplayed());
    }
    @Test (enabled = false)
    public static void checkElement (List<WebElement> list) {
        for (WebElement tempElement : list) {
            System.out.println(tempElement.getText() + " - is displayed: " + tempElement.isDisplayed());
        }
    }

    @Test
    public void test1 () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://catalog.onliner.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<By> xpath1 = new ArrayList<>();
        xpath1.add(By.xpath("//span[contains(text(), 'Электроника')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Компьютеры')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Бытовая техника')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Стройка и')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Дом и')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Авто и')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Красота и')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Детям и')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Работа')]"));
        xpath1.add(By.xpath("//span[contains(text(), 'Еда')]"));

        for (By tempXpath : xpath1) {
            try {
                checkPresence(driver, tempXpath);
            } catch (NoSuchElementException e) {
                System.out.println("element not found: " + tempXpath);
                continue;
            }
        }
        driver.close();
    }

    @Test
    public void test2 () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://catalog.onliner.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement webElement = driver.findElement(By.xpath("//span[contains(text(), 'Компьютеры и')]"));
        webElement.click();
        WebElement verticalList = driver.findElement(By.xpath("//div[text()=' Комплектующие ']/.."));
        System.out.println("vertical list is displayed: " + verticalList.isDisplayed());

        List<By> xpath2 = new ArrayList<>();
        xpath2.add(By.xpath("//div[text()=' Ноутбуки, компьютеры, мониторы ' ]"));
        xpath2.add(By.xpath("//div[text()=' Комплектующие ']"));
        xpath2.add(By.xpath("//div[contains(text(), 'Хранение данных')]"));
        xpath2.add(By.xpath("//div[contains(text(), 'Сетевое оборудование')]"));

        for (By tempXpath : xpath2) {
            checkPresence(driver, tempXpath);
        }
        driver.close();
    }

    @Test
    public void test3 () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://catalog.onliner.by/");
        driver.manage().window().maximize();
        WebElement webElement = driver.findElement(By.xpath("//span[contains(text(), 'Компьютеры и')]"));
        webElement.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement webElement1 = driver.findElement(By.xpath("//div[text()=' Комплектующие ']"));
        Actions action = new Actions(driver);
        action.moveToElement(webElement1).build().perform();

        List<WebElement> names = driver.findElements(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//span[@class='catalog-navigation-list__dropdown-title']"));
        System.out.println("names size: " + names.size());
        checkElement(names);

        List<WebElement> numberOfProductsAndMinimumPrice = driver.findElements(By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//span[@class='catalog-navigation-list__dropdown-description']"));
        System.out.println("numberOfProductsAndMinimumPrice size: " + numberOfProductsAndMinimumPrice.size());
        checkElement(numberOfProductsAndMinimumPrice);
        driver.close();
    }

}
