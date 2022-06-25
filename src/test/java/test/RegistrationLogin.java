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
import pages.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationLogin {
    WebDriver driver;
    ShopAsGuest log;
    Registration signIng;
    LoginPage signInP;
    HomePage home;

    ScreenShot screenShot;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setUpReport()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/RegistrationLogin.html");
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
    public void openBrowser() throws IOException {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://automationpractice.com/index.php");



    }

    @Test()
    public void selectProd() throws InterruptedException, IOException {
        test = extent.createTest("selectProd", "Test fail");
        log = new ShopAsGuest(driver);
        log.selectProduct();
        Thread.sleep(4000);
        log.selectCart();
        log.procCheckout();
        Thread.sleep(4000);
        log.payment();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));


    }

    @Test(enabled = false)
    public void signUpRegistration() throws InterruptedException, IOException {
        test = extent.createTest("signUpRegistration", "Test Passed");
        signIng = new Registration(driver);
        signIng.goToSignIn();
        signIng.createEmailAdr("nabila@mail3.com");
        signIng.createAccount();
        signIng.enterFirstName("nab");
        signIng.enterLastName("azz");
        signIng.enterPassword("1234563");
        signIng.firstNameAdr("nab");
        signIng.addressReg("2000 E street");
        signIng.selectCity("Denver");
        signIng.selectState();
        signIng.addZipCode("20000");
        signIng.selectCountry();
        signIng.addPhoneNum("2020303030");
        signIng.aliasAddresse("addresse");
        signIng.registerAccount();
        Thread.sleep(4000);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));
    }

    @Test(enabled = false)
    public void signInPage() throws IOException {
        test = extent.createTest("signInPage", "Test Passed");
        signIng = new Registration(driver);
        signIng.goToSignIn();
        signInP = new LoginPage(driver);
        signInP.signInEmail("nabila@mail3.com");
        signInP.sendPasswordSignIn("1234563");
        signInP.signInFunc();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));

    }
    @Test(enabled = false)
    public void openHomePage() throws IOException {
        test = extent.createTest("openHomePage", "Test Passed");
        home = new HomePage(driver);
        home.goToHomePage();
        String actualUrl = home.getCurUrl();
        String expectedUrl = "http://automationpractice.com/index.php";
        Assert.assertEquals(actualUrl,expectedUrl);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));

    }
    @AfterSuite
    public void tearDown() {
        extent.flush();
    }
}
