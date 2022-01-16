package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class P31_Window_and_Tab_Test extends TestBase {
    @Test
    public void testWindows() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/windows");

        String currentHandle = driver.getWindowHandle();
        System.out.println("currentHandle = " + currentHandle);

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);

        WebElement clickHereElm = driver.findElement(By.linkText("Click Here"));
        clickHereElm.click();

        System.out.println("after clicking once driver.getWindowHandle() = " + driver.getWindowHandle());
        System.out.println("after clicking once driver.getWindowHandles() = " + driver.getWindowHandles());

        allHandles = driver.getWindowHandles() ;
        for (String eachHandle : allHandles) {

            System.out.println("eachHandle = " + eachHandle);
//            Thread.sleep(2);
            driver.switchTo().window(eachHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        Thread.sleep(3000);

    }

}
