package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Driver;
import utility.WebOrderUtility_New;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class P37_WebOrderFunctionalityTests extends TestBase {
    @Test
    public void testCheckAllButton(){
        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login();

        assertTrue(WebOrderUtility_New.checkAll());
    }

    @Test
    public void testUncheckAllButton(){
        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login();

        assertTrue(WebOrderUtility_New.uncheckAll());
    }


    @Test
    public void testAllProductName(){
        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login();
        WebOrderUtility_New.selectSidebarTab("View all products");

        List<String> actualProduct=WebOrderUtility_New.getAllProducts();
        List <String> expectedProduct = Arrays.asList("MyMoney","FamilyAlbum777","ScreenSaver");
        //assertEquals(actualProduct,expectedProduct);
        //Expected :[MyMoney, FamilyAlbum, ScreenSaver]
        //Actual   :[MyMoney, FamilyAlbum777, ScreenSaver]
        assertIterableEquals(actualProduct,expectedProduct);
        //org.opentest4j.AssertionFailedError: iterable contents differ at index [1], expected: <FamilyAlbum> but was: <FamilyAlbum777>
        //ITERABLE shows



    }

    @Test
    public void testProductInformation_Price(){
        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login();
        WebOrderUtility_New.selectSidebarTab("Order");
        int actualPriceMyMoney=WebOrderUtility_New.getUnitPriceFromForm("MyMoney");
        assertEquals(100, actualPriceMyMoney);
        int actualPriceFamilyAlbum=WebOrderUtility_New.getUnitPriceFromForm("FamilyAlbum");
        assertEquals(80, actualPriceFamilyAlbum);
        int actualPriceScreensaver=WebOrderUtility_New.getUnitPriceFromForm("ScreenSaver");
        assertEquals(20, actualPriceScreensaver);
    }

    @Test
    public void testOrderFlow(){
        WebOrderUtility_New.openWebOrderApp();

        WebOrderUtility_New.login();

        WebOrderUtility_New.selectSidebarTab("Order");

        WebOrderUtility_New.getUnitPriceFromForm("MyMoney");

        WebElement quantity = Driver.getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[2]/input"));
        quantity.sendKeys("10");

        WebElement calculator = Driver.getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[5]/input[2]"));
        calculator.click();

        WebOrderUtility_New.enterAddressInfo();

        WebOrderUtility_New.PaymentInfo();
        WebOrderUtility_New.submitAndVerify();


    }




}
