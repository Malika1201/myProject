package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class P31_javaScriptExecutor extends TestBase {
    @Test
    public void test_Scroll_whole_window() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(2000);
        // Get JavaScriptExecutor reference from driver variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");

        for (int i = 0; i < 10; i++) {

            jse.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(1000);
        }

        Thread.sleep(3000);
    }


    @Test
    public void test_ScrollElementInto_the_View() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/large");
        Thread.sleep(2000);

        WebElement schoolLnk = driver.findElement(By.linkText("Cybertek School"));
        WebElement homeLnk = driver.findElement(By.linkText("Home"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", schoolLnk);
        Thread.sleep(1000);
        jse.executeScript("arguments[0].scrollIntoView(true)", homeLnk);
        Thread.sleep(2000);

    }

    @Test
    public void test_OpenNewTab_withURL() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);
        // get JavascriptExecutor reference
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(" window.open('https://google.com','_blank')");
        Thread.sleep(1000);
        jse.executeScript(" window.open('https://cybertekschool.com','_blank')");
        Thread.sleep(1000);
        jse.executeScript(" window.open('https://search.yahoo.com','_blank')");
        Thread.sleep(3000);

        // get all windows handles and print it out
        // switch to each window and print the title

        // get all windows handles and print it out
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);
        // switch to each window and print the title
        allHandles = driver.getWindowHandles();
        for (String eachHandle : allHandles) {

            System.out.println("eachHandle = " + eachHandle);
//            Thread.sleep(2);
            driver.switchTo().window(eachHandle);
            System.out.println("driver.getTitle() = " + driver.getTitle());


        }

    }
}
