package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchTest {

    WebDriver driver;

    @BeforeAll
    public static void initBrowserDriver(){
        System.out.println("@BeforeAll setting up chrome driver");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupWebDriver(){
        System.out.println("@BeforeEach to open browser and navigate");
        driver = new ChromeDriver();//IMPORTANT
        driver.manage().window().maximize();
        driver.get("https://search.yahoo.com/");
    }

    @Test
    public void testYahooSearchHomePage(){

        //String expectedResult = "Yahoo Search - Web Search";
        //assertEquals(expectedResult, "Yahoo Search - Web Search");
        String pageTitle=driver.getTitle();
        assertEquals("Yahoo Search - Web Search", pageTitle);
    }

    @Test
    public void testYahooSearchResultPage(){
        //search for selenium and hit enter
        WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"yschsp\"]"));
        searchBox.sendKeys("Selenium" + Keys.ENTER);//ENTER method in order not to us click()
        //assert title starts with selenium
        String actualTitle= driver.getTitle();
        assertTrue(actualTitle.startsWith("Selenium"));//IMPORTANT
    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
