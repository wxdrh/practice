package Main;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import listeners.MyListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base;

import java.util.concurrent.TimeUnit;


public class Utilities {
    public static WebDriver driver;


    public static WebDriver getDriver() {
        driver = base.setupApplication();
        return driver;
    }

    public static void click(WebElement element) {

        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jsClick(WebElement element) {
        try{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void enterText(WebElement element, String data) {
        try {
            element.sendKeys(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jsenterText(WebElement element, String data) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document." + element + ".value='" + data + "';");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scroll(int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitImplicit() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void navigateToURL(String URL) {

        try {
            driver.get(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void currentURL() {
        System.out.println(driver.getCurrentUrl());
    }

    public static void waitExplicit(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

    public static void getText(WebElement element) {
        driver.findElement((By) element).getText();
    }

    public static WebElement getWebElement(String xPath){
       WebElement element = driver.findElement(By.xpath(xPath));
        return element;
    }
}