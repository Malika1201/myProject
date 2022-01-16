import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P17_Dropdown_Multiple {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        //DESELECT i additional function

        //identify the dropdown
        WebElement multiDropdown = driver.findElement(By.name("Languages"));
        //wrap into Select object
        Select multiItemSelect = new Select (multiDropdown);

        //check if this element has multi select option
        System.out.println("multiItemSelect.isMultiple() = " + multiItemSelect.isMultiple());


        //check if this is a multiselect list
        multiItemSelect.selectByIndex(3);
        multiItemSelect.selectByValue("c#");
        multiItemSelect.selectByVisibleText("Java");

        //Deselect option
        multiItemSelect.deselectByIndex(3);
        multiItemSelect.deselectByValue("c#");

        driver.quit();






    }
    }
