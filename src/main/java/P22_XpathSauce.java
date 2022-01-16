import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P22_XpathSauce {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com");

        WebElement username = driver.findElement(By.xpath("//div/form/div[1]/input"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//div/form/div[2]/input"));
        password.sendKeys("secret_sauce");
        WebElement loginBtn= driver.findElement(By.xpath("//div/form/input"));
        loginBtn.click();
        WebElement addBackpack=driver.findElement(By.xpath("//div/div[1]/div[2]/div[2]/button"));
        addBackpack.click();
        WebElement cart=driver.findElement(By.xpath("//div[1]/div[3]/a"));
        cart.click();
        WebElement checkout=driver.findElement(By.xpath("//div/div[2]/button[2]"));
        checkout.click();

        WebElement fname=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input"));
        fname.sendKeys("malika");
        WebElement lname=driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input"));
        lname.sendKeys("kassymova");
        WebElement zip=driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        zip.sendKeys("60630");

        WebElement cont=driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        cont.click();
        WebElement finish =driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]/button[2]"));
        finish.click();










    }
}
