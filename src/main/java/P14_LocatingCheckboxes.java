import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P14_LocatingCheckboxes {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement chbox1= driver.findElement(By.id("box1"));
        System.out.println("before click chbox1.isSelected()?= " + chbox1.isSelected());
        System.out.println("before click chbox1.getAttribute(\\\"checked\\\") = " + chbox1.getAttribute("checked"));//null
        chbox1.click();
        System.out.println("after click chbox1.isSelected()?= " + chbox1.isSelected());

        WebElement chbox2= driver.findElement(By.id("box2"));
        System.out.println("before click chbox2.getAttribute(\\\"checked\\\") = " + chbox2.getAttribute("checked"));//checked --true
        //System.out.println("before click chbox2.isSelected()?= " + chbox2.isSelected());
        chbox2.click();
        System.out.println("after click chbox2.isSelected()?= " + chbox2.isSelected());

        if(!chbox1.isSelected()){
            chbox1.click();
        }else{
            System.out.println("checkbox1 already selected");
        }

    //boolean that return its selected or not yet
    }
}
