package pageClass;

import listeners.MyListener;
import objectRepo.repoAmazon;
import objectRepo.repoDaraz;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import tests.base;
import datafromExcel.Data;




public class Ecom extends MyListener {
    WebDriver driver;
    Data data = new Data();
    public void searchAmazon() {
        driver = base.setupApplication();
        driver.get(data.getUrl("amazon"));
        repoAmazon test = new repoAmazon(driver);
        test.SearchBox(data.excel("amazon"));
        test.clickSearchButton();
        test.allProducts();


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

