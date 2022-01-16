import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P06_findById {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.get("http://www.yahoo.com");
        WebElement inputBox = driver.findElement(By.id("ybar-sbq"));
        inputBox.sendKeys("Yelaman");
        WebElement search = driver.findElement(By.id("ybar-search"));


        search.click();
        Thread.sleep(5000);

        //driver.quit();



    }
}
