package com.it_academy.onliner.pageobject;
import com.it_academy.onliner.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
public abstract class BasePage {
    public BasePage() {
        DriverManager.setDriver();
    }
    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 5);
        return wait.until(visibilityOfElementLocated(by));
    }
    public WebElement waitForElementClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), 5);
        return wait.until(elementToBeClickable(by));
    }

}
