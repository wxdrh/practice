package pageClass;

import Main.Utilities;
import listeners.MyListener;
import objectRepo.repoAmazon;
import objectRepo.repoDaraz;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;
import tests.base;
import datafromExcel.Data;

import static Main.Utilities.*;


public class Ecom extends MyListener {
   static WebDriver driver;

    Data data = new Data();
    public void searchAmazon() {
        driver=Utilities.getDriver();
        waitImplicit();
        navigateToURL(data.getUrl("amazon"));
        repoAmazon test = new repoAmazon(driver);
        test.SearchBox(data.excel("amazon"));
        test.clickSearchButton();
        test.allProducts();
        currentURL();


    }

    public void searchDaraz() {
        driver = base.setupApplication();
       driver.get(data.getUrl("daraz"));
        repoDaraz test = new repoDaraz(driver);
        test.SearchBox(data.excel("daraz"));
        test.clickSearchButton();
        test.allProducts();
    }
@AfterMethod
    public void quit() {
        driver.quit();
    }
}

