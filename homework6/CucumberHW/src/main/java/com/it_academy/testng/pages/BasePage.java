package com.it_academy.testng.pages;

import com.it_academy.testng.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }
}
