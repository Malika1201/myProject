package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserUtil;
import utility.Driver;

import java.util.List;

public class WAllOrdersPage {
    public WCommonArea commonArea;

    @FindBy(xpath = "//h2[normalize-space(.) = 'List of All Orders']")
    private WebElement header;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private WebElement checkAllBtn;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    private WebElement uncheckAllBtn;

    @FindBy(css="input[id$='OrdersSelector']")
    private List<WebElement> allCheckboxes;

    public WAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        commonArea=new WCommonArea();
    }
    //check header visible true if yes, false if not

    public boolean headerElementPresent(){
        return BrowserUtil.checkVisibilityOfElement(header, 1);

    }


    public boolean checkAll_and_verify(){
        checkAllBtn.click();

        for (WebElement eachCheckbox:allCheckboxes) {
            if (!eachCheckbox.isSelected()){
                return false;
            }

        }
        return true;


    }


    public boolean uncheckAll_and_verify(){
        uncheckAllBtn.click();

        for (WebElement eachCheckbox:allCheckboxes) {
            if (eachCheckbox.isSelected()){
                return false;
            }

        }
        return true;


    }


}
