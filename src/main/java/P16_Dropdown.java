import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P16_Dropdown {
    public static void main(String[] args) {

        //UNDER SELECT TAG

        //EACH ITEM UNDER OPTION VALUE

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        //identify select elecmet
        WebElement dropdownElm = driver.findElement(By.id("dropdown"));
        //wrap this element inside Select object from selenium library
        Select selectObj = new Select(dropdownElm);
        //use ready methods
        selectObj.selectByIndex(2);//select 3rd item
        selectObj.selectByValue("1");//select item with value attribute 1
        selectObj.selectByVisibleText("Option 2");

        driver.quit();

    }
}
