import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P08_FindByLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://www.google.com");
        WebElement about = driver.findElement(By.linkText("About"));
        about.click();
        WebElement menu = driver.findElement(By.className("glue-header__drawer-toggle-btn"));
        menu.click();
        WebElement products = driver.findElement(By.linkText("Products"));
        products.click();

        Thread.sleep(5000);

        driver.quit();
    }
}
