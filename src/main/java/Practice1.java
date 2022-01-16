import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");

        //first name
        WebElement firstName=driver.findElement(By.cssSelector("form#registrationForm input[data-bv-field=\"firstname\"]"));//or "input[name='firstname']"
        firstName.sendKeys("malika");

        //last name
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("kassymova");


        //username
        WebElement username=driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("malikun");
        //email
        WebElement email=driver.findElement(By.cssSelector("div>input[type='text'][name='email']"));
        email.sendKeys("malika.kassymova@yahoo.com");

        //gender
        WebElement gender=driver.findElement(By.cssSelector("input[name='gender'][value='female']"));
        gender.click();


        //dob
        WebElement dob=driver.findElement(By.cssSelector("input[type='text'][name='birthday']"));
        dob.sendKeys("01/12/1995");

        //password
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("Malika555");

        //phone number
        WebElement phone = driver.findElement(By.cssSelector("input[type='tel']"));
        phone.sendKeys("312-905-3322");

        //department
        WebElement department=driver.findElement(By.cssSelector("select.selectpicker[name='department']"));
        department.click();

        Thread.sleep(2000);
        WebElement depName=driver.findElement(By.cssSelector("option[value='MO']"));
        depName.click();

        //job title
        WebElement job= driver.findElement(By.name("job_title"));
        Select selectObj = new Select(job);
        selectObj.selectByIndex(1);

        //language
        WebElement language=driver.findElement(By.cssSelector("input[type='checkbox'][value='java']"));
        language.click();

        //signup
        WebElement signup = driver.findElement(By.cssSelector("button[type='submit']"));
        signup.click();





        //input[name='firstname']

    }
}
