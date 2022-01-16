import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {
    public static void main(String[] args) {
        //1. setup chrome driver

        WebDriverManager.chromedriver().setup();


        //2.create chrome driver object
        WebDriver driver = new ChromeDriver();

        //3.navigate to website
        //driver.navigate().to("http://google.com");

        driver.get("http://google.com");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
