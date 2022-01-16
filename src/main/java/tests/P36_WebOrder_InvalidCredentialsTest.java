package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utility.BrowserUtil;
import utility.Driver;
import utility.WebOrderUtility_New;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class P36_WebOrder_InvalidCredentialsTest extends TestBase {
    @Test
    public void testLoginWithInvalidCredentials(){

        WebOrderUtility_New.openWebOrderApp();
        WebOrderUtility_New.login("wrong","credentials");
        assertEquals("Web Orders Login", Driver.getDriver().getTitle());

        //String errorMsgXpath = "//span[.='Invalid Login or Password.']";
        //boolean ErrElmFound = BrowserUtil.checkVisibilityOfElement(By.xpath(errorMsgXpath),1);THIS MOVED TO UTLITY NEW


        assertTrue(WebOrderUtility_New.loginErrorMessageVisible());







    }


}
