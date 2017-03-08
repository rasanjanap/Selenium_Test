/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Crazzy King
 */
public class SeleniumTest {
    
    public static ExtentReports extent;
    public static ExtentTest logger; 

    public static void main(String[] args) {
        
        extent = new ExtentReports("C:\\Users\\Crazzy King\\workspace\\Extent\\Reports\\Reports.html", true);
        logger=extent.startTest("VerifyBlogTitle");

        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
        ExtentTest test = extent.startTest("My First Test", "Sample description");
        test.log(LogStatus.INFO, "Started");
        driver.navigate().to("http:/www.doc.lk");
        
        logger.log(LogStatus.INFO, "Application is up and running");
        
        driver.findElement(By.cssSelector("#advertModel > div.modal-dialog > div.modal-content > div.modal-header > button.close")).click();
        logger.log(LogStatus.INFO, "close ad");
        driver.findElement(By.name("doctor")).clear();
        logger.log(LogStatus.INFO, "Search doc");
        driver.findElement(By.name("doctor")).sendKeys("sunil");
        logger.log(LogStatus.INFO, "Type Sunil");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        logger.log(LogStatus.INFO, "Submit");

        
        extent.endTest(test);
        
        extent.flush();

    }

}
