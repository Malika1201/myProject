package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebOrderUtility {
    //navigate to weborder app cant
    //extend testbase in utility


    public static void openWebOrderApp(WebDriver driverParam) {//IMPORTANT

        driverParam.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

    }

    public static void login(WebDriver driverParam) {
        driverParam.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driverParam.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driverParam.findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    //login by proving any username
    //@param driverparam
    //@param username
    //@param password



    public static void login(WebDriver driverParam, String username, String password) {
        driverParam.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driverParam.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        driverParam.findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    public static void logout(WebDriver driverParam) {

        driverParam.findElement(By.id("ctl00_logout")).click();
    }
}
