package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserUtil;
import utility.Driver;

public class WLoginPage {
    public WCommonArea commonArea;

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernamebox;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordbox;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_login_button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_status\"]")
    public WebElement errorMsgElement;



    //once this constructor is called it will initialize the value of elements above
    public WLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);//чтобы испоьзовать локейторы в этом класс используем это метод
        commonArea=new WCommonArea();
    }


    public void goTo(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");
    }



    public boolean isAt(){
        return Driver.getDriver().getTitle().equals("Web Orders Login");
        //check we are at the login page or not
    }

    public void login(){// no constructor
        usernamebox.sendKeys("Tester");
        passwordbox.sendKeys("test");
        loginButton.click();
    }

    public void login(String username, String password){
        usernamebox.sendKeys(username);
        passwordbox.sendKeys(password);
        loginButton.click();

    }

    public boolean isLoginErrorPresent(){
        //return errorMsgElement.isDisplayed();
        return BrowserUtil.checkVisibilityOfElement(errorMsgElement, 3);

    }


}
