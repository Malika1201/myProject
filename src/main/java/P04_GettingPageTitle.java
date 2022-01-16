import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_GettingPageTitle {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://cybertekschool.com");//result depend son what address you give

        String pageTitle = driver.getTitle();

        if(pageTitle.equals("Cydeo")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        System.out.println(pageTitle);
        driver.close();


    }
}
