package tests;

import TestUtil.TestBase;
import org.checkerframework.checker.units.qual.A;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P30_actionClassTest extends TestBase {

    @Test
    public void testPerformHoverAction(){

        driver.get("http://practice.cybertekschool.com/hovers");

        //hover over to the first image
        //identify first element
        //(//div[@class='figure']/img)[1]
        //(//[@class='figure']/img)[2]
        //(//div[@class='figure']/img)[3]

        //CSS
        //h5[.='name: user1']

        WebElement firstImage = driver.findElement(By.xpath("(//div[@class='figure']/img)[1]"));
        WebElement firstImageText = driver.findElement(By.xpath("//h5[.='name: user1']"));
        System.out.println("firstImageText.isDisplayed()" + firstImageText.isDisplayed());//boolean
        //create Actions class object
        //pass webdriver
        Actions actions = new Actions(driver);
        actions.moveToElement(firstImage).perform();
        System.out.println("firstImageText.isDisplayed()" + firstImageText.isDisplayed());//boolean

        System.out.println("END");





    }

    @Test
    public void testDragAndDrop() throws InterruptedException{

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement small=driver.findElement(By.id("draggable"));
        WebElement big=driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        actions. moveToElement(small).pause(1000)
                .clickAndHold().pause(1000)
                .moveToElement(big).pause(1000)
                .release()
                .perform();
        System.out.println("big.getText()="+big.getText());


    }


    @Test
    public void testKeyboardAction() throws InterruptedException{
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));

        //click on the element
        //hold down to the shift and enter text
        //release shift and enter text
        //hold down to ctrl on windows and enter A to select all
        //send eys backspace
        //pause 1 sec between actions


        Actions actions = new Actions(driver);

        actions.click(searchBox).pause(1000)
                .keyDown(Keys.SHIFT)//press shift
                .sendKeys("typing by holding shift down").pause(1000)
                .keyUp(Keys.SHIFT)//this is release shift
                .sendKeys("typing after shift released").pause(1000)
                .keyDown(Keys.CONTROL).sendKeys("A")
                .keyUp(Keys.CONTROL)//release control
                .sendKeys(Keys.BACK_SPACE)
                .perform();





    }

    @Test
    public void testRightClick() throws InterruptedException{

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

        //locate the div element element inside IFRAME
        //with css selector and right click on it
        driver.switchTo().frame("iframeResult");//choose right frame
        WebElement area=driver.findElement(By.cssSelector("div[contextmenu='mymenu']"));//choose that says Right-click inside this box to see the context menu!

        //right click = context click
        Actions actions = new Actions(driver);
        actions.contextClick(area).perform();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

    }

    @Test
    public void testDoubleClick() throws InterruptedException{

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
        driver.switchTo().frame("iframeResult");
        // Double-click this paragraph to trigger a function.
        WebElement pElm = driver.findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.doubleClick(pElm).perform();
        // assert new p element with Hello World text displayed
        WebElement resultElm = driver.findElement(By.xpath("//p[.='Hello World']")) ;
        assertTrue(resultElm.isDisplayed() );
        Thread.sleep(2000);
    }

}
