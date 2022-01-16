import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P09_FindByPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://www.etsy.com");
        WebElement link = driver.findElement(By.partialLinkText("Hooray"));
        link.click();
        //WebElement menu = driver.findElement(By.className("glue-header__drawer-toggle-btn"));
        //menu.click();
        //WebElement products = driver.findElement(By.linkText("Products"));
        //products.click();

        Thread.sleep(5000);

        driver.quit();
    }
}
