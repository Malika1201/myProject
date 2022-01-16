package utility;


/*

male singleton patter
1.make constructor private-avoid having new instance accidentallu
2.private static field-so only 1 value can be assigned
3.public getter for the field--follow few instructions.
-if private static field is not assigned a value yet akak null
it is null then create a enw object and assig value
-if not null return same static field value

 */

import com.sun.javafx.geom.Edge;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver obj;//call any name

    private Driver(){ }//blocking creation

    public static WebDriver getDriver() {

        String browserName = ConfigReader.read("browser");

        if (obj == null) {
            //System.out.println("creating obj first time");
            //WebDriverManager.chromedriver().setup();
            // obj = new ChromeDriver();
            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    obj = new EdgeDriver();
                    break;
                default:
                    System.out.println("Unknown browser type" + browserName);
                    obj = null;
            }


            obj.manage().window().maximize();
            return obj;
        }
        System.out.println("obj already exists returning existing one");
        return obj;
    }


        public static void closeBrowser () {

            if (obj != null) {
                obj.quit();
                obj = null;
            }
        }
    }
