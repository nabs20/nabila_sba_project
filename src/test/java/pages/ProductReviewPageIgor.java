package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReviewPageIgor {

    WebDriver driver;

    //@FindBy(xpath = "//img[@class='replace-2x img-responsive']")
    //List<WebElement> webElementList;

    @FindBy(xpath = "//iframe[@class='fancybox-iframe']")
    WebElement iframe;

    @FindBy(xpath = "//p[@id='add_to_cart']/button")
    WebElement addToCartButton;

    //$x("//a[@title='View my shopping cart']")
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement viewCart;


    public ProductReviewPageIgor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickAddCartButton()
    {
        driver.switchTo().frame(iframe);
        addToCartButton.click();
    }

    public void clickOnViewCart()
    {
        viewCart.click();
    }
}

    /*public void getListOfIconsForProductPreview()
    {
        System.out.println(webElementList.size());
        webElementList.get(0).click();

        for(WebElement webElement : webElementList)
        {
            System.out.println(webElement.getTagName());
        }
    }*/