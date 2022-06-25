package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCartPageIgor {
    WebDriver driver;

    public ConfirmCartPageIgor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "cross")
    WebElement closeButton;

    public void clickCloseButton(){
        driver.switchTo().parentFrame();                      //defaultContent();
        closeButton.click();
    }
}