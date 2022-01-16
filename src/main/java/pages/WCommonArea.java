package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class WCommonArea {

    //add constructor, add elements, add locators for elem, methods
    @FindBy(id="ctl00_logout")
    private WebElement logoutLink;

    @FindBy(xpath="/html/body/form/table/tbody/tr/td[2]/div[1]")
    private WebElement welcomeMsgElm;

    @FindBy(xpath = "//*[@id=\"ctl00_menu\"]/li[1]/a")
    private WebElement sideBarViewAllOrdersLink;

    @FindBy(xpath = "/html/body/form/table/tbody/tr/td[1]/ul/li[2]/a")
    private WebElement sideBarViewAllProductsLink;

    @FindBy(xpath = "/html/body/form/table/tbody/tr/td[1]/ul/li[3]/a")
    private WebElement  sideBarOrderLink;

    public WCommonArea(){
    PageFactory.initElements(Driver.getDriver(),this);
    }

    //logout
    public void logout(){
        logoutLink.click();
    }

    public boolean verifyUsername(String name){
        return welcomeMsgElm.getText().contains(name+"5");
    }

    public void clickViewAllOrdersLink(){
        sideBarViewAllOrdersLink.click();
    }

    public void clickViewAllProductsLink(){
        sideBarViewAllProductsLink.click();
    }


}
