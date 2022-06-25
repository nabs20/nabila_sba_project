package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {
  WebDriver driver;

  @FindBy(xpath = "//div/h2/span[text()='Cucumber']")
  WebElement actualTitle;

  public GoogleSearchResultPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  public String getTitleText() {

    return actualTitle.getText();
  }
}