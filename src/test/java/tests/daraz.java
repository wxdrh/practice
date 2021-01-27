/*
package tests;

import objectRepo.repoDaraz;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

@Test
public class daraz extends base{

    @Test
    public void test() {

        driver = setupApplication();
        driver.get("https://www.daraz.pk/");
        repoDaraz test = new repoDaraz(driver);
        test.getSearchBox().sendKeys("IphoneX");
        test.getSearchButton().click();
        List<WebElement> alllinks;
        alllinks = driver.findElements(By.xpath("//*[@data-tracking='product-card']"));
        Iterator<WebElement> itr = alllinks.iterator();
        System.out.println(itr.next().getText());
    }
    @AfterClass
    public void quit() {
        driver.quit();

    }

}
*/
