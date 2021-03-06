package objectRepo;

import com.relevantcodes.extentreports.LogStatus;
import com.sun.jdi.event.ExceptionEvent;
import listeners.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import datafromExcel.Data;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import Main.Utilities;

public class repoDaraz extends Utilities{
    WebDriver driver;
    Data data;
    MyListener l=new MyListener();

    public repoDaraz(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        data=new Data();
    }

    @FindBy(css = ".search-box__button--1oH7")
    WebElement searchButton;
    @FindBy(name = "q")
    WebElement searchBox;
    @FindBy(xpath = "//*[@data-tracking='product-card']")
    WebElement products;



    public void clickSearchButton() {
        try {
            click(searchButton);
            l.test.log(LogStatus.PASS, "Clicking on seacrh button");
        }
        catch (Exception e)
        {
            l.test.log(LogStatus.FAIL, "Unable to click on seacrh button");
            e.printStackTrace();
        }
    }

    public void SearchBox(String Website){
        enterText(searchBox,Website);

        MyListener.test.log(LogStatus.PASS,"Enter data in search box");
    }

    public void allProducts() {
        List<WebElement> allLinks = products.findElements(By.xpath("//*[@data-tracking='product-card']"));
        Iterator<WebElement> itr = allLinks.iterator();
        System.out.println(itr.next().getText());
        MyListener.test.log(LogStatus.PASS,"Get text of first product");
    }


}
