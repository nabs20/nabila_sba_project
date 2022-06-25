package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopAsGuest {

    WebDriver driver;

    @FindBy(xpath = "//img[@class='replace-2x img-responsive']")
    WebElement product;
    //List<WebElement> product;

    @FindBy(xpath = "//div/p/button/span[text()= 'Add to cart']") ////button[@class='exclusive']
    WebElement cart;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    WebElement checkout;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    WebElement pay;

    public ShopAsGuest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void selectProduct(){

        product.click();
    }
    public void selectCart(){

        cart.click();
    }
    public void procCheckout(){

        checkout.click();
    }
    public void payment(){

        pay.click();
    }

    /*public void getListOfIconsForProductsPreview(){
        product.click();
    }*/
}

