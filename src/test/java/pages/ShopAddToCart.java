package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopAddToCart {

    WebDriver driver;

    @FindBy(id = "color_15")
    WebElement color;

    @FindBy(xpath = "//button[@class='exclusive']")
    WebElement cart;

    @FindBy(xpath = "//a[@class='btn btn-default button-plus product_quantity_up']")
    WebElement quantity;

    public ShopAddToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectSize() {

     Select se = new Select(driver.findElement(By.id("group_1")));
     se.selectByValue("2");
}

    public void chooseColor(){

        color.click();
    }

    public void lastAddToCart(){
        cart.click();

    }
    public void addQuantityToCart(){
        quantity.click();

    }

}
