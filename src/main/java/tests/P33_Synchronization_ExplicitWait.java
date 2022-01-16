package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

public class P33_Synchronization_ExplicitWait extends TestBase {

    @Test
    public void test_WaitForExpectedTitle() {


        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement page = driver.findElement(By.cssSelector("a[href='/dynamic_loading/7']"));
        page.click();

        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        WebElement successMsg = driver.findElement(By.id("alert"));//если done загрузилось
        assertTrue(successMsg.isDisplayed());
        //WebElement spongebob= driver.findElement(By.cssSelector("img[src='/img/a-few-moments.jpg']"));
        // assertTrue(spongebob.isDisplayed());---если спанчбоб загрузился


    }


    @Test
    public void test_WaitForElementClickable() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input[type='text']"));
        driver.findElement(By.xpath("//button[.='Enable']")).click();//click on enable button

        WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until( elementToBeClickable(inputBox) );
        //wait.until(presenceOfElementLocated(By.id("message")) );
        wait.until(textToBe(By.id("message"), "It's enabled!"));
        inputBox.sendKeys("Hello there");

        Thread.sleep(3000);
    }


    @Test
    public void test_WaitForElementVisible(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.partialLinkText("Example 1")).click();


        driver.findElement(By.cssSelector("div#start > button")).click();
        //wait for 5 sec maximum until H$ with text Hello World is visible
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //WebElement hello=driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));

        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("tomsmith");
        WebElement pass=driver.findElement(By.xpath("//*[@id=\"pwd\"]"));
        pass.sendKeys("SuperSecretPassword");
        WebElement submit=driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();

        BrowserUtil.wait(3);


    }
}
