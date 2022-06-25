package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    WebDriver driver;

    By searchField = By.name("q");
    By searchButton = By.name("btnK");

    public GoogleSearchPage(WebDriver driver) {

        this.driver = driver;
    }

    public void inputTestIntoSearchField(String arg){

        driver.findElement(searchField).sendKeys(arg);
    }
    public void clickSearchButton(){

        driver.findElement(searchButton).submit();
    }
}
