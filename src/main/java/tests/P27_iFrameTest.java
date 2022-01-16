package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P27_iFrameTest extends TestBase {

    @Test
    public void test_iFrame() {

        driver.get("http://practice.cybertekschool.com/iframe");

        //driver.switchTo().frame(0);by index int or by id String

        //driver.switchTo().frame("mce_0_ifr");

        WebElement iFrameElm = driver.findElement(By.cssSelector("iframe[title^='Rich Text Area']"));

        driver.switchTo().frame(iFrameElm);

        WebElement pTagElmINFrame =driver.findElement(By.tagName("p"));

        System.out.println(pTagElmINFrame.getText());//your content goes here


    }
}

