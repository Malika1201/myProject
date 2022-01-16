import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P20_Xpath {
    public static void main(String[] args) {
        //*--any element
        //@+specify attribute name
        //text()-not attribute it's function--- text()='Test Automation Practice'
        //a[contains(text(),'broken images')] -contains
        //a[starts-with(text(),'broken')] - starts with
        //a[ends-with(text(),'images')] - ends with
        //@name='color' and @id='blue'
        //input[@type='radio' and @checked]
        //input[@type='radio' and@disabled]

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://search.yahoo.com/");

        WebElement searchbox=driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[1]/div[2]/div[1]/form/div[1]/input"));
        searchbox.sendKeys("hello");

        WebElement searchbutton=driver.findElement(By.xpath("//div[1]/form/button/span"));
        searchbutton.click();




    }

}
