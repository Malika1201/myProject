package TestUtil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utility.Driver;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeAll
    public static void init() {
        System.out.println("@BeforeAll run once before all tests");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("@AfterAll run once after all tests");
    }

    @BeforeEach
    public void setUpBrowser() {

        //driver = WebDriverFactory.get("chrome");
        driver = Driver.getDriver(); //this is after we created singleton
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

  @AfterEach
    public void cleanUp() {
        //driver.quit();
        //no more quit, we need cleanup
        System.out.println("inside after each");
        Driver.closeBrowser();
    }
}


