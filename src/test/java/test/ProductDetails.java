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

public class ProductDetails {

    WebDriver driver;
    HomePage productD;

    Registration signIng;

    LoginPage signInP;

    ShopAddToCart shop;

    ScreenShot screenShot;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setUpReport()
    {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ProductDetails.html");
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


    @Test(priority = 1)
    public void openBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://automationpractice.com/index.php");

    }

    @Test(priority = 2)
    public void searchProduct() throws IOException {
        test = extent.createTest("searchProduct", "Test Passed");
        signIng = new Registration(driver);
        signIng.goToSignIn();
        signInP = new LoginPage(driver);
        signInP.signInEmail("nabila@mail2.com");
        signInP.sendPasswordSignIn("123456");
        signInP.signInFunc();
        productD = new HomePage(driver);
        productD.goToSearch("Printed Chiffon Dress");
        productD.loopSearch();
        productD.goToProductDetail();
        Assert.assertEquals("Printed Chiffon Dress - My Store", driver.getTitle());
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));

    }

    @Test(priority = 3)
    public void addSizeColor() throws IOException {
        test = extent.createTest("addSizeColor", "Test Passed");
        shop = new ShopAddToCart(driver);
        shop.selectSize();
        shop.chooseColor();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));


    }

    @Test(priority= 4)
    public void chooseQuantity() throws IOException {
        test = extent.createTest("chooseQuantity", "Test Passed");
        shop = new ShopAddToCart(driver);
        shop.addQuantityToCart();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));



    }
    @Test(priority = 5)
    public void addToCartShop() throws IOException {
        test = extent.createTest("addToCartShop", "Test Passed");
        shop = new ShopAddToCart(driver);
        shop.lastAddToCart();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));

    }
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
}
