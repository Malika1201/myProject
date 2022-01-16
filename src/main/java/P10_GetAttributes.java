import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P10_GetAttributes {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("http://www.google.com");

            WebElement searchbox = driver.findElement(By.name("q"));
            searchbox.sendKeys("Selenium");
            //get tag name of the element>input
            System.out.println("searchbox.getTagName()="+searchbox.getTagName());

            //get value of attribute
            System.out.println("searchbox.getAttribute(\"value\") = " + searchbox.getAttribute("value"));
            Thread.sleep(5000);
            WebElement searchBtn =driver.findElement(By.name("btnK"));

            System.out.println("searchBtn.getTagName()="+searchBtn.getTagName());
            System.out.println("searchBtn.getAttribute(\"class\") = " + searchBtn.getAttribute("class"));

            searchBtn.click();

            //identify the element that holds search result number
            WebElement searchResult=driver.findElement(By.id("result-stats"));
           //get the text of that element
            String resultText = searchResult.getText();
            System.out.println("resultText = " + resultText);




        }
}
