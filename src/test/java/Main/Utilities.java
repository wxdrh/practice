package Main;


import org.openqa.selenium.WebElement;


public class Utilities {




    public void click(WebElement element) {

        try {
            if (element != null)
            {
                element.click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
