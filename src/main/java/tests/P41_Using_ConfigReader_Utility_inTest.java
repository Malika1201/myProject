package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import utility.ConfigReader;
import utility.Driver;
import utility.WebOrderUtility_New;

public class P41_Using_ConfigReader_Utility_inTest extends TestBase {


    @Test
    public void testWebOrderLogin() {

        String url= ConfigReader.read("weborder_url");
        String username= ConfigReader.read("weborder_username");
        String password= ConfigReader.read("weborder_password");



        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = "+password);

        //Driver.getDriver().navigate().to(url);
        WebOrderUtility_New.openWebOrderApp();

        WebOrderUtility_New.login(username, password);



    }
}
