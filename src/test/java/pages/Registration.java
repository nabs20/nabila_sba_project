package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {

    WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@title='Log in to your customer account']")
    WebElement signIn;

    @FindBy(id="email_create")
    WebElement email;

    @FindBy(id="SubmitCreate")
    WebElement account;

    @FindBy(id="customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(xpath = "//input[@class='form-control']")
    WebElement firstNameAddress;

    @FindBy(xpath = "//input[@id='lastname'] ")
    WebElement lastNameAddress;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "postcode")
    WebElement zipCode;

    @FindBy(id= "phone_mobile")
    WebElement mobile;

    @FindBy(id = "alias")
    WebElement addreseAlias;

    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement register;


    public void goToSignIn(){
        signIn.click();
    }

    public void createEmailAdr(String SingUpEmail){
        email.sendKeys(SingUpEmail);
    }

    public void createAccount(){
        account.click();
    }
    public void enterFirstName(String ftName){
        firstName.sendKeys(ftName);
    }
    public void enterLastName(String lsName){
        lastName.sendKeys(lsName);
    }
    public void enterPassword(String passWrd){
        password.sendKeys(passWrd);
    }
    public void firstNameAdr(String firstNmAdr){
        firstNameAddress.sendKeys(firstNmAdr);
    }
    public void lastNameAdr(String lastNmAdr){
        lastNameAddress.sendKeys(lastNmAdr);
    }
    public void addressReg(String passAdr){
        address.sendKeys(passAdr);
    }
    public void selectCity(String cities) {

        city.sendKeys(cities);
    }
    public void selectState() {

        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        se.selectByIndex(6);
    }
        public void addZipCode(String zCode){
           zipCode.sendKeys(zCode);
        }

        public void selectCountry(){
            Select si = new Select(driver.findElement(By.id("id_country")));
            si.selectByValue("21");
        }

        public void addPhoneNum(String phoneN){
          mobile.sendKeys(phoneN);
        }
        public void aliasAddresse(String alias){
          addreseAlias.sendKeys(alias);
        }
        public void registerAccount(){
          register.click();
        }
    }


