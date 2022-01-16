package utility;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WebOrderUtility_New {
    //navigate to weborder app cant
    //extend testbase in utility
    public static void openWebOrderApp() {//IMPORTANT

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");//Driver.getDriver replace driver. driver Param to use same driver

    }

    public static void login() {
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    //login by proving any username
    //@param driverparam
    //@param username
    //@param password
    public static void login(String username, String password) {
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();

    }

    public static boolean isAtAllOrderPage() {
        //create boolean variable
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);

        try {
            //try assert same URL//wait.until(ExpectedConditions.urlToBe("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx"));
            //now try assert element name "List of All Orders"
            wait.until(visibilityOfElementLocated(By.xpath("//h2[normalize-space(.)='List of All Orders']")));
            result = true;
            System.out.println("At the right page");
        } catch (TimeoutException e) {
            System.out.println("Not at Order page");
        }

        return result;
    }


    //check for login error message after invalid login
    //return true if it shows up in 1 sec false if not
    public static boolean loginErrorMessageVisible(){
        String errorMsgXpath = "//span[.='Invalid Login or Password.']";
        boolean ErrElmFound = BrowserUtil.checkVisibilityOfElement(By.xpath(errorMsgXpath),1);
        return ErrElmFound;
    }

    public static void logout() {

        Driver.getDriver().findElement(By.id("ctl00_logout")).click();
    }

    public static boolean verifyUserName(String username) {
        WebElement loginInfoArea = Driver.getDriver().findElement(By.cssSelector("div.login_info"));
        System.out.println("loginInfoArea.getText()).contais(\"Tester\") = " + loginInfoArea.getText());
        return loginInfoArea.getText().contains(username);
    }

    public static String getUserNameFromWelcomeMessage() {
        WebElement loginInfoArea = Driver.getDriver().findElement(By.cssSelector("div.login_info"));
        String welcomeMessage = loginInfoArea.getText();//Welcome Tester logout


        return welcomeMessage.replace("Welcome, ", "").replace("! | Logout", "");

    }

    public static void selectSidebarTab(String tabName) {

        List<String> allTabs = Arrays.asList("View all orders", "View all products", "Order");
        if (allTabs.contains(tabName)) {
            Driver.getDriver().findElement(By.linkText(tabName)).click();
        } else {
            Driver.getDriver().findElement(By.linkText("View all orders")).click();

        }


    }

    public static boolean checkAll() {
        Driver.getDriver().findElement(By.linkText("Check All")).click();

        //input[id$='OrderSelector'][type='checkbox]
        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.cssSelector("input[id$='OrderSelector']"));
        boolean result = true;

        //as long as one of them are ot checked, return false immediately
        for (WebElement eachCheckBox : allCheckboxes) {
            if (!eachCheckBox.isSelected()) {
                result = false;
            }
        }
        return result;

    }

    public static boolean uncheckAll() {
        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.cssSelector("input[id$='OrderSelector']"));
        boolean result = true;

        //as long as one of them are checked, return false immediately
        for (WebElement eachCheckBox : allCheckboxes) {
            if (eachCheckBox.isSelected()) {
                result = false;
            }
        }
        return result;

    }

    public static List<String> getAllProducts(){

        WebElement productButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[2]/a"));
        productButton.click();
        //selectSidebarTab("View All")----to click the side bar buttons



        List<String> allProductNames = new ArrayList<>();//empty now
        //table[@class='ProductsTable'//tr/td[1]  --this return all first row cells
        List<WebElement> allFirstRowCells = Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//tr/td[1]"));//contains web elements from 1 row

        for(WebElement eachCell:allFirstRowCells){
            allProductNames.add(eachCell.getText());

        }
        return allProductNames;
    }

    //param productName return price according to name
    public static int getUnitPriceFromForm (String productName){

        //int price = 0;
        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);

        productSelectObj.selectByVisibleText(productName);
        WebElement priceBox = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));

        return Integer.parseInt(priceBox.getAttribute("value"));

    }


//this is with 1 parameter product name only
    /*ublic static int getTotalFromForm (String productName){
        selectSidebarTab("Order");
        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);
        productSelectObj.selectByVisibleText(productName);

        WebElement quantity = Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
        quantity.sendKeys("600");
        WebElement calculate=Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/input[2]"));
        calculate.click();

        WebElement total=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        return Integer.parseInt(total.getAttribute("value"));

    }

    public static int getCalculatedTotal (String productName, int quantity) {
        selectSidebarTab("Order");
        WebElement productDropDown = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productSelectObj = new Select(productDropDown);
        productSelectObj.selectByVisibleText(productName);

        WebElement quantityplace = Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
        quantityplace.sendKeys(quantity);
    }*/
    private static Faker faker=new Faker();
    public static void enterAddressInfo(){

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().cityName());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().stateAbbr());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.numerify("#####"));

    }

    public static void PaymentInfo(){
        //input[@type='radio' and @value='American Express']

        //String cardRadioButtonXpath="input[value="""+cardType+""]"";

        WebElement radioBtn = Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]"));
        radioBtn.click();
        //WebElement radioBtn = Driver.getDriver().findElement(By.xpath(cardRadioButtonXpath));
        //radioBtn.click();

        WebElement cardInputBoxElm=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        cardInputBoxElm.sendKeys(faker.number().digits(16));

        WebElement expiration=Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expiration.sendKeys("09/24");

    }

    public static boolean submitAndVerify(){
        WebElement quantity = Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
        quantity.sendKeys("100");
        WebElement process = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));

        process.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);
        String successMessage="//strong[normalize-space(.)='New order has been successfully added.']";

        boolean successMessageId = false;
        try {
            wait.until(visibilityOfElementLocated(By.xpath(successMessage)));
            successMessageId=true;
        }catch(TimeoutException e) {
            System.out.println("no success message" + e.getMessage());
        }
        return successMessageId;

    }


}
