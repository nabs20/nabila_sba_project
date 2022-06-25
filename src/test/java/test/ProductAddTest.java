package test;

import library.SelectBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ConfirmCartPageIgor;
import pages.ProductCheckOut;
import pages.ProductReviewPageIgor;
import pages.ShopAsGuest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ProductAddTest {
    WebDriver driver;
    ProductReviewPageIgor productReviewPage;
    ConfirmCartPageIgor confirmCartPage;

    ProductCheckOut productCheckOut;

    ShopAsGuest shopAsGuest;

    @BeforeTest
    public void openBrowser() throws IOException {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://automationpractice.com/index.php");
    }

    @Test
    public void click_preview_page_for_product_test() throws IOException {

        productReviewPage = new ProductReviewPageIgor(driver);
        //productReviewPage.getListOfIconsForProductPreview();
        shopAsGuest = new ShopAsGuest(driver);
        shopAsGuest.selectProduct();
        productReviewPage.clickAddCartButton();
        String expected="Product successfully added to your shopping cart";
        confirmCartPage = new ConfirmCartPageIgor(driver);
        confirmCartPage.clickCloseButton();
        productReviewPage.clickOnViewCart();
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/screanShots/image.png"));
        productCheckOut = new ProductCheckOut(driver);
        System.out.println(productCheckOut.getProductText());
        String actual = productCheckOut.getProductText();
        String temp = actual.substring(1);
        System.out.println(temp);

        double actualPrice = 0;
        actualPrice = Double.parseDouble(temp);
        Assert.assertTrue(actualPrice > 0);
        }
    }

