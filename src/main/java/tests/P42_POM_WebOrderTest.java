package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.Browser;
import pages.WAllOrdersPage;
import pages.WAllProductsPage;
import pages.WCommonArea;
import pages.WLoginPage;
import utility.BrowserUtil;
import utility.Driver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P42_POM_WebOrderTest extends TestBase {

    @Test
    public void testValidLogin(){
        //Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");

        WLoginPage loginPage = new WLoginPage();
        loginPage.goTo();
        assertTrue(loginPage.isAt());

        loginPage.login("Tester","test");

        WAllOrdersPage allOrdersPage = new WAllOrdersPage();
        assertTrue(allOrdersPage.headerElementPresent(),"you are not on all order page");






        //loginPage.usernamebox.sendKeys("Tester");
        //loginPage.passwordbox.sendKeys("test");
        //loginPage.loginButton.click();
        //because inside test we need to add loginPage object




    }


    @Test
    public void testInvalidLogin(){

        WLoginPage loginPage = new WLoginPage();
        loginPage.goTo();
        assertTrue(loginPage.isAt());

        loginPage.login("Tester","jgjgf");
        assertTrue(loginPage.isLoginErrorPresent(),"Login error message was not present");//from WLoginPAge like weborder new

    }


    @Test
    public void testCheckAllUncheckAllBtn(){

        WLoginPage loginPage=new WLoginPage();
        loginPage.goTo();
        loginPage.login("Tester","test");

        WAllOrdersPage allOrdersPage = new WAllOrdersPage();
        assertTrue(allOrdersPage.checkAll_and_verify());
        assertTrue(allOrdersPage.uncheckAll_and_verify());

        //instantiate
        WCommonArea commonArea=new WCommonArea();

        commonArea.clickViewAllProductsLink();
        //BrowserUtil.wait(5);
        commonArea.verifyUsername("Tester1");

    }

    @Test
    public void testAllProductPage(){
        WLoginPage loginPage = new WLoginPage();

        loginPage.goTo();
        loginPage.login("Tester","test");

       // WCommonArea commonArea=new WCommonArea();
        //commonArea.clickViewAllProductsLink();
        //we created instance variable so wedn thave to create new object each time

        WAllProductsPage allProductsPage=new WAllProductsPage();
        allProductsPage.commonArea.clickViewAllProductsLink();


        assertTrue(allProductsPage.isAt());

        //BrowserUtil.wait(2);

        //for collection types iterableequals better
        List<String> expectedList= Arrays.asList("MyMoney","FamilyAlbum","ScreenSaver");
        assertIterableEquals(expectedList, allProductsPage.getAllProductNames());

}


}
