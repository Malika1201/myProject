package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserUtil;
import utility.Driver;

public class WOrderPage {
    public WCommonArea commonArea;

    @FindBy(xpath = "//h2[normalize-space(.)='Order']")
    private WebElement header;

    public WOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        commonArea=new WCommonArea();
    }

    public boolean isAt(){
        return BrowserUtil.checkVisibilityOfElement(header,1);
    }



}
