import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P18_Dropdown_NoSelect {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        //now find all elements first
        WebElement dropdown=driver.findElement(By.linkText("Dropdown link"));
        dropdown.click();
        WebElement google=driver.findElement(By.linkText("Google"));
        google.click();





    }
}
