package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P25_JavaScriptAlert extends TestBase {

    @Test
    public void testAlert() {
    driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement jsalert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]"));
        jsalert.click();

        driver.switchTo().alert().accept();//special method to acept alert in Java Script


        WebElement jsconfirm=driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[2]"));
        jsconfirm.click();

        driver.switchTo().alert().dismiss();

        WebElement jsPromt = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/button[3]"));
        jsPromt.click();
        driver.switchTo().alert().sendKeys("HI");
        driver.switchTo().alert().accept();


    }
}
