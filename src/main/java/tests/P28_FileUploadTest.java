package tests;

import TestUtil.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class P28_FileUploadTest extends TestBase {
    @Test
    public void testFileUpload(){

        driver.get("http://practice.cybertekschool.com/upload");
        String filePath="C:\\Users\\PC\\Desktop\\cute-hamsters-54__880.jpg";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        System.out.println("end");
    }

}
