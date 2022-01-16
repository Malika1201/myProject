import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P19_ByCSSSelector {
    public static void main(String[] args) {

        //https://www.w3schools.com/CSSref/trysel.asp
        //CTRL+F to start type input
        //div>input[name='firstname'] if directly under div


        //div.page-header>h2---> .page its a class with a dot
        //instaed of input[id] can write #id

        //select[name='department'] or select.selectpicker (if there are 2 classes inside select and you choose 1 of them after dot)
        //button[type='submit']
        //can have 2 with []---> button[type='submit'][id='wooden_spoon']
        //if it changes we can only search by starts with or ends with
        //button[id$='spoon'] ends
        //button[id^='spoon'] starts
        //button[id*='spoon'] contains

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://search.yahoo.com");

        WebElement searchbox = driver.findElement(By.cssSelector("#yschsp"));
        searchbox.sendKeys("Selenium");

        WebElement searchbtn = driver.findElement(By.cssSelector("span[role='button']"));//or span[title='search']// #sf > button > span//different ways//span.ico-syc.mag-glass[title='Search']

        searchbtn.click();










    }
}
