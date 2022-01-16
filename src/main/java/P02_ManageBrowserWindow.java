import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_ManageBrowserWindow {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        //fullscreen
        //driver.manage().window().fullscreen();
        //set position of the window
        driver.manage().window().setPosition(new Point(500,200));
        //set size of window
        driver.manage().window().setSize(new Dimension(200,300));
    }
}
