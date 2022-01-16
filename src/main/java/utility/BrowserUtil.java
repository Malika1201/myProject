package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BrowserUtil {

    static public void wait (int second){
        try{Thread.sleep(second*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //check for visibility of element by locator within given time
    //@param locator any locator by xpath, id etc
    //@param time towait until timeout
    //@return true if element visible by locator in given timeframe

    public static boolean checkVisibilityOfElement(By locator, int timToWait){
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);

        try {
            //try assert same URL//wait.until(ExpectedConditions.urlToBe("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx"));
            //now try assert element name "List of All Orders"
            wait.until(visibilityOfElementLocated(locator));
            result = true;
            System.out.println("element was visible within the time frame");
        } catch (TimeoutException e) {
            System.out.println("element was not visible within the time frame"+e.getMessage());
        }

        return result;

    }

    public static boolean checkVisibilityOfElement(WebElement element, int timeToWait) {
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWait);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result=true;


        } catch (TimeoutException e) {
            System.out.println("element was not visible within the time frame" + e.getMessage());
        }

        return result;

    }
}
