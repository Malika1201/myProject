import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_GettingPageSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();


        driver.get("http://www.google.com");
        System.out.println("driver.getCurrentUrl() " + driver.getCurrentUrl());

        System.out.println("driver.getPageSource()" + driver.getPageSource());


    }
}
