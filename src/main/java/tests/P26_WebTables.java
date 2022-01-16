package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P26_WebTables extends TestBase {
    //create @test
    //create class
    //get address

    @Test
    public void testWebTable(){
        driver.get("http://practice.cybertekschool.com/tables");
        String cell42Locator = "//table[@id='table1']/tbody/tr[4]/td[2]";
        WebElement cell42= driver.findElement(By.xpath(cell42Locator));
        System.out.println("cell42.getText() " + cell42.getText());

        String timCellLocator = "//table[@id='table1']//td[text()='Tim']";
        WebElement cellTim = driver.findElement(By.xpath(timCellLocator));
        System.out.println("cellTim.getText() = " + cellTim.getText());


        //print out cell values of row 4
        //table

        String row4CellLocator = "//table [@id='table1']/tbody/tr[4]/td";
        List<WebElement> allRow4Cells = driver.findElements(By.xpath(row4CellLocator));
        for (WebElement eachCell : allRow4Cells) {
            System.out.println("eachCell.getText()"+eachCell.getText());


        }
    }



}
