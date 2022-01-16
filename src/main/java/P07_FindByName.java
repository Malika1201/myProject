import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P07_FindByName {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://www.google.com");
        WebElement inputBox = driver.findElement(By.name("q"));
        inputBox.sendKeys("selenium");
        WebElement search = driver.findElement(By.name("btnK"));


        search.submit();
        Thread.sleep(5000);

        //driver.quit();
    }
}
