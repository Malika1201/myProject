import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class P15_LocatingRadioButton {
        public static void main(String[] args) {


            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            driver.get("http://practice.cybertekschool.com/radio_buttons");

            WebElement blueRadioB=driver.findElement(By.id("blue"));
            //check if its selected already or not
            System.out.println("blueRadioB.isSelected() = "+ blueRadioB.isSelected());
            blueRadioB.click();
            WebElement redRadioB=driver.findElement(By.id("red"));
            //check if its selected already or not
            System.out.println("redRadioB.isSelected() before click = "+ redRadioB.isSelected());
            redRadioB.click();
            System.out.println("redRadioB.isSelected() after click= "+ redRadioB.isSelected());
            //check if blue is not selected
            System.out.println("blueRadioB.isSelected() now= "+ blueRadioB.isSelected());

            List <WebElement> allColorRadios=driver.findElements(By.name("color"));
            System.out.println("allColorRadios = " + allColorRadios);

            for (WebElement eachbtn:allColorRadios) {
                System.out.println("current radio burron is "+eachbtn.getAttribute("id"));
                System.out.println("is enabled? "+eachbtn.isEnabled());
                System.out.println("is it selected? "+eachbtn.isSelected());

            }






        }

}
