package com.it_academy.onliner.framework;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setDriver() {
        if(driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
        } else {
            System.out.println("Driver has been set: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        }
    }
    public static WebDriver getDriver() {
       return driver.get();
    }
    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
