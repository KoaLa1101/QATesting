package ru.itlab.qa.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    public WebDriver driver;
    public WebDriverWait webDriverWait;


    public void waitForPageLoaded(int seconds) {
        new WebDriverWait(driver, seconds).until(
                webDriver -> ((JavascriptExecutor) ((ChromeDriver) webDriver)).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageLoaded() {
        waitForPageLoaded(10);
    }

    public void waitSeconds(int sleep) {
        try {
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
