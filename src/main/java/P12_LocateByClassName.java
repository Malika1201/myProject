import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P12_LocateByClassName {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");

        //identify the span element with class name 'h1y'
        WebElement element= driver.findElement(By.className("h1y"));

        System.out.println("element.getText()="+element.getText());

        //Identify first item in unordered list using classname

        WebElement firstElm = driver.findElement(By.className("list-group-item"));
        System.out.println("firstElm.getText() = " + firstElm.getText());//it will show only the first one

        List<WebElement> allItems = driver.findElements(By.className("list-group-item"));

        for (WebElement each : allItems) {
            System.out.println("each.getText()= " + each.getText());

        }








    }
}
