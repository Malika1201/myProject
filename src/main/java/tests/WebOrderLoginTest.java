package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import utility.Driver;
import utility.WebOrderUtility;
import utility.WebOrderUtility_New;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebOrderLoginTest extends TestBase {

    @Test
    public void testLoginWithCorrectCredentials(){
        WebOrderUtility_New.openWebOrderApp();

        WebOrderUtility_New.login();

        assertTrue(WebOrderUtility_New.isAtAllOrderPage());

        assertTrue(WebOrderUtility_New.verifyUserName("Tester"));
       assertEquals("Tester", WebOrderUtility_New.getUserNameFromWelcomeMessage());


    }
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
