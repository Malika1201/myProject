package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.BrowserUtil;
import utility.WebOrderUtility;
import utility.WebOrderUtility_New;

import static org.junit.jupiter.api.Assertions.*;
import static utility.WebOrderUtility_New.openWebOrderApp;
import static utility.WebOrderUtility_New.selectSidebarTab;

public class P34_WebOrderTest extends TestBase {


    @Test
    public void testLogin(){


        //driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        WebOrderUtility.openWebOrderApp(driver);


        //driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        //driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(("test"));
        //driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        WebOrderUtility.login(driver);
        WebOrderUtility.logout(driver);
        WebOrderUtility.login(driver,"Tester","test");

        BrowserUtil.wait(3);
        driver.quit();





    }


    @Test
    public void testDriverUtilityLoginLogout() throws InterruptedException {

        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login();
        WebOrderUtility_New.isAtAllOrderPage();

        System.out.println("WebOrderUtility_New.getUserNameFromWelcomeMessage() = " + WebOrderUtility_New.getUserNameFromWelcomeMessage());//Tester
        assertTrue(WebOrderUtility_New.verifyUserName("Tester"));//loginInfoArea.getText()).contais("Tester") = Welcome, Tester! | Logout
        assertEquals("Tester", WebOrderUtility_New.getUserNameFromWelcomeMessage());//if true nothing, if false error message


        /*WebOrderUtility_New.selectSidebarTab("View all orders");
        BrowserUtil.wait(2);
        WebOrderUtility_New.selectSidebarTab("View all products");
        BrowserUtil.wait(2);
        WebOrderUtility_New.selectSidebarTab("Order");
        BrowserUtil.wait(2);
        WebOrderUtility_New.selectSidebarTab("BLA BLA ");
        */

        WebOrderUtility_New.checkAll();
        WebOrderUtility_New.uncheckAll();

        //System.out.println("WebOrderUtility_New.getAllProducts()=" + WebOrderUtility_New.getAllProducts());
        //selectSidebarTab("Order");
        //System.out.println("WebOrderUtility_New.getUnitPriceFromForm(\"MyMoney\")"+WebOrderUtility_New.getUnitPriceFromForm("FamilyAlbum"));

        selectSidebarTab("Order");
        WebOrderUtility_New.enterAddressInfo();

        Thread.sleep(3000);
        WebOrderUtility_New.PaymentInfo();

        WebOrderUtility_New.submitAndVerify();






        //WebOrderUtility_New.logout();
        //WebOrderUtility_New.login("Tester","test");
        //WebOrderUtility_New.logout();
        //BrowserUtil.wait(3);



    }


    @Test
    public void verifyUserName(){
        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login();

        BrowserUtil.wait(3);

        WebElement welcome= driver.findElement(By.xpath("//html/body/form/table/tbody/tr/td[2]/div[1]"));
        System.out.println("welcome.getText() = " + welcome.getText());

        assertEquals( "Welcome, Tester! | Logout", welcome.getText());

    }

}
