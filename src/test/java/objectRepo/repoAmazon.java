package objectRepo;

import Main.Utilities;
import com.relevantcodes.extentreports.LogStatus;
import listeners.MyListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Enum.AmazonPageVariables;



import java.util.Iterator;
import java.util.List;
import datafromExcel.Data;

public class repoAmazon extends Utilities{
    WebDriver driver;
Data data;
String Website = "Amazon";



    public repoAmazon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        data = new Data();
    }

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    @FindBy(xpath = "//*[@data-component-type='s-search-result']")
    WebElement products;



    public void clickSearchButton() {
        WebElement a = getWebElement(AmazonPageVariables.XPATH_AMAZON_SEARCH_BUTTON.getResponse());
        System.out.println(a);
        jsClick(a);

        MyListener.test.log(LogStatus.PASS,"Clicking on seacrh button");
    }

    public void SearchBox(String Website){
        searchBox.sendKeys(Website);
MyListener.test.log(LogStatus.PASS,"Enter data in search box");
    }

public void allProducts() {
      List<WebElement> allLinks= products.findElements(By.xpath("//*[@data-component-type='s-search-result']"));
    Iterator<WebElement> itr = allLinks.iterator();
    System.out.println(itr.next().getText());
    MyListener.test.log(LogStatus.PASS,"Get text of first product");
}

}
