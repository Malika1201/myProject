package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utility.WebDriverFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPassword extends TestBase {

    @Test
    public void testForgetPassword(){

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("a@a.com"+ Keys.ENTER);//no need to save new variable
        String currentURL = driver.getCurrentUrl();

        //assertion
        assertTrue(currentURL.endsWith(("email_sent")));//when click forget pass and give email it show message email sent

    }

}
