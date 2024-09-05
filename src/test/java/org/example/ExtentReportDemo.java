package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;
    @BeforeTest
    public void config()
    {
       // ExtentReports , ExtentSparkReporter
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sanjay");

    }

    @Test
    public void initialDemo()
    {
        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver","C://Users//EK744JY//OneDrive - EY//Documents//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());

        driver.close();
        test.fail("Results do not match");
        extent.flush();

        //test.addScreenCaptureFromBase64String();


    }
}
