package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id= "email")
    WebElement siEmail;

    @FindBy(css = "input[id ='passwd']")
    WebElement siPass;

    @FindBy(id = "SubmitLogin")
    WebElement siClick;

    public void signInEmail(String email){
        siEmail.sendKeys(email);
    }

    public void sendPasswordSignIn(String pass){
        siPass.sendKeys(pass);
    }

    public void signInFunc(){
        siClick.click();
    }

    }



