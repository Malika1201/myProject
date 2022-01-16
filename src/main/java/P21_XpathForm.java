import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P21_XpathForm {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        //locate elements using xpath and sign up and verify succes msg

        WebElement header = driver.findElement(By.xpath("//h2[.='Registration form' ]"));
        System.out.println("header.isDisplayed() = " + header.isDisplayed());

        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameField.sendKeys("Yelaman");

        WebElement lastnameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastnameField.sendKeys("Abiyev");

        WebElement userField = driver.findElement(By.xpath("//input[@name='username']"));
        userField.sendKeys("yelamanabi");

        WebElement emailField = driver.findElement(By.xpath("//input[@data-bv-field='email']"));
        emailField.sendKeys("yelamanai@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password' and @data-bv-field='password']"));
        passwordField.sendKeys("Agaesh555");

        WebElement phoneField = driver.findElement(By.xpath("//input[@name='phone' and @data-bv-field='phone']"));
        phoneField.sendKeys("3479053322");

        WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@type='radio' and @value='female']"));
        femaleRadioBtn.click();

        WebElement birthdayField = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthdayField.sendKeys("02/02/1999");

        WebElement depDropdown = driver.findElement(By.xpath("//select[@name='department']"));
        Select depSelectObj = new Select(depDropdown);
        depSelectObj.selectByIndex(3);

        WebElement titleDropdown = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select titleSelectObj = new Select(titleDropdown);
        titleSelectObj.selectByIndex(5);

        WebElement cplusCheckbox = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        System.out.println("cplusCheckbox.isSelected() = " + cplusCheckbox.isSelected());
        cplusCheckbox.click();

        WebElement signupBtn = driver.findElement(By.xpath("//button[@type='submit' and text()='Sign up']"));
        signupBtn.click();
    }
}
