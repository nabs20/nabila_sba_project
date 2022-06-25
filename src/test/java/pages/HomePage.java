package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css = "a[title='Home']")
    WebElement homeP;

    @FindBy(xpath ="//input[@id='search_query_top']")
    WebElement searchP;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement findSr;

    @FindBy(linkText = "Printed Chiffon Dress")
    WebElement productChoice;




    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage(){
        homeP.click();
    }

    public void goToSearch(String product){
        searchP.sendKeys(product);
    }

    public void loopSearch(){
        findSr.click();
    }
    public void goToProductDetail(){
        productChoice.click();
    }

    public String getCurUrl(){
        String homePageUrl = driver.getCurrentUrl();
        return homePageUrl;
    }

}
