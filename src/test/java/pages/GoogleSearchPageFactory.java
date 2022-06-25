package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPageFactory {
   WebDriver driver;

   @FindBy(name="q")
   WebElement searchField;

   @FindBy(name="btnk")
   WebElement searchButton;

    public GoogleSearchPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputTestIntoSearch(){
        searchField.sendKeys();
    }
}
