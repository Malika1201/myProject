package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserUtil;
import utility.Driver;

import java.util.ArrayList;
import java.util.List;

public class WAllProductsPage {
    public WCommonArea commonArea;

    public WAllProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        commonArea=new WCommonArea();
    }

    @FindBy(xpath="//h2[normalize-space(.)='List of Products']")
    private WebElement header;

    @FindBy(xpath="//table[@class='ProductsTable']//tr/td[1]")
    private List<WebElement> allFirstRowCells;

    public List<String> getAllProductNames(){
        List<String> allProductList =new ArrayList<>();
        for(WebElement eachCell:allFirstRowCells){
            allProductList.add(eachCell.getText());
        }
        return allProductList;
    }




    public boolean isAt(){



        return BrowserUtil.checkVisibilityOfElement(header,1);

    }




}
