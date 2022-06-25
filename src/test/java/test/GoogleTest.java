package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleTest {
    WebDriver driver;

    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setUpReport(){

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/GoogleReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Nabila.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Nabila");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting Google download pictures report");
        htmlReporter.config().setReportName("Google Search and Download Pictures Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeTest
    public void launchBrowser(){
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://google.com");
    }
    @Test(priority = 1)
    public void search_product() throws IOException {

        test = extent.createTest("search_product", "Test Passed");
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.inputTestIntoSearchField("cucumber");
        googleSearchPage.clickSearchButton();

        googleSearchResultPage = new GoogleSearchResultPage(driver);
        String expected = "Cucumber";
        String actual = googleSearchResultPage.getTitleText();
        Assert.assertEquals(actual,expected);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));
    }
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
}

    /*@Test(priority = 1)
    public void openBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }*/
