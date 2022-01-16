package tests;

import TestUtil.TestBase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P29_ImplicitExplicitWaits extends TestBase {

    @Test
    public void testSlowElement(){


        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        //click on remove button
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        //Thread.sleep(5000);
        //identify the "its gone" element by id message
        WebElement itsGone=driver.findElement(By.id("message"));
        System.out.println("itsGone.getText()= " + itsGone.getText());


        assertEquals("It's gone!", itsGone.getText());




    }
}
