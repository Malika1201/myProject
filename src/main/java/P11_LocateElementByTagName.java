import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P11_LocateElementByTagName {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        WebElement firstLink=driver.findElement(By.tagName("a"));
        System.out.println("firstLink.getText() = " + firstLink.getText());//text of 1 element

        //identify and save all the elements with<a>tag
        //findelements method will return list<webelement>
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        //iterate through each element of lists and get text of each element

        for (WebElement eachLink :allLinks) {

            System.out.println("Link text is"+eachLink.getText());

        }

        firstLink.click();
        Thread.sleep(5000);
        driver.quit();




        driver.quit();



    }
}
