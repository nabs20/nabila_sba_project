package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCheckOut {

    WebDriver driver;

    @FindBy(id="total_product_price_1_1_0")
    WebElement productTotal;

    public ProductCheckOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getProductText(){
        return productTotal.getText();
    }
}
