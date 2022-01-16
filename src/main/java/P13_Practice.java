import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P13_Practice {

    public static void main(String[] args) throws InterruptedException{

        //setup chromedriver and open browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //navigate to website
        driver.get("https://saucedemo.com");

        //print out the page title
        String pageTitle=driver.getTitle();
        System.out.println(pageTitle);
        //login steps
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginBtn= driver.findElement(By.name("login-button"));
        loginBtn.click();

        //get name and price of products assume we dont know the name of 1st item
        WebElement firstProduct = driver.findElement(By.className("inventory_item"));
        System.out.println("firstProduct.getText() = " + firstProduct.getText());
        //assume we know name
        //WebElement firstProductLink = driver.findElement(By.linkText("Sauce Labs Backpack"))
        //and we can use getAttribute to show us which attribute it is cause we only know the text but not the attribute

        //assume we dont know the name
        //WebElement firstProductLink1=driver.findElement(By.className("inventory_item_name"));
        //WebElement firstProductLink2=driver.findElement(By.id("item_4_title_link"));


        //get all elements with list
        //List <WebElement> allItems = driver.findElements(By.id("inventory_container"));
        //System.out.println("allItems.getText() = " + allItems.getText());

        List<WebElement> allProductTitle=driver.findElements(By.className("inventory_item_name"));
        System.out.println("allProductTitle.getSize() Product count = " + allProductTitle.size());

        for (WebElement each:allProductTitle) {
            System.out.println("each.getText() = " + each.getText());
        }

        //go to cart
        WebElement cart= driver.findElement(By.className("shopping_cart_link"));

        cart.click();
        Thread.sleep(4000);

        WebElement contin=driver.findElement(By.name("continue-shopping"));

        contin.click();







    }
}
