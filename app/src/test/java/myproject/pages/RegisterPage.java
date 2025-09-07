package myproject.pages;

import io.cucumber.java.en.And;
import myproject.abs.abs_basics_funtions;
import myproject.objs.RegisterData;
import myproject.steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends abs_basics_funtions {
    RegisterData registerData;


    @FindBy(id = "customer.firstName")
    WebElement First_name;

    @FindBy(id = "customer.lastName")
    WebElement Last_name;

    @FindBy(id = "customer.address.street")
    WebElement Address;

    @FindBy(id="customer.address.city")
    WebElement City;

    @FindBy(id="customer.address.state")
    WebElement State;

    @FindBy(id="customer.address.zipCode")
    WebElement ZipCode;

    @FindBy(id="customer.phoneNumber")
    WebElement Phone;

    @FindBy(id="customer.ssn")
    WebElement SSN;

    @FindBy(id="customer.username")
    WebElement Username;

    @FindBy(id="customer.password")
    WebElement Password;

    @FindBy(id="repeatedPassword")
    WebElement PasswordConfirm;

    @FindBy(xpath = "//input[@type='submit' and @class='button' and @value='Register']")
    WebElement Submit_button;


    String url="http://localhost:8080/parabank/register.htm";//"https://parabank.parasoft.com/parabank/register.htm";

    WebDriver driver;

    public RegisterPage(TestContext testContext){
        super("register_page");
        this.driver=testContext.getDriver();
        this.registerData= new RegisterData();

        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }


    public void GetUrl(){
        this.driver.get(url);
    }


    public void Register() throws Exception {
        super.waitForClickableElement(this.driver,First_name,20);
        super.waitForClickableElement(this.driver,Last_name,20);
        super.waitForClickableElement(this.driver,Address,20);
        super.waitForClickableElement(this.driver,City,20);
        super.waitForClickableElement(this.driver,State,20);
        super.waitForClickableElement(this.driver,ZipCode,20);
        super.waitForClickableElement(this.driver,Phone,20);
        super.waitForClickableElement(this.driver,SSN,20);
        super.waitForClickableElement(this.driver,Username,20);
        super.waitForClickableElement(this.driver,Password,20);
        super.waitForClickableElement(this.driver,PasswordConfirm,20);



        this.First_name.sendKeys(registerData.getFirst_Name());
        this.Last_name.sendKeys(registerData.getLast_Name());
        this.Address.sendKeys(registerData.getAddress());
        this.City.sendKeys(registerData.getCity());
        this.State.sendKeys(registerData.getState());
        this.ZipCode.sendKeys(registerData.getZip_Code());
        this.Phone.sendKeys(registerData.getPhone());
        this.SSN.sendKeys(registerData.getSSN());
        this.Username.sendKeys(registerData.getUsername());
        this.Password.sendKeys(registerData.getPassword());
        this.PasswordConfirm.sendKeys(registerData.getPassword());
        super.TakesScreenshot(this.driver);

    }

    public void enviarFormulario(){
        this.Submit_button.click();
    }
    public void verificarExitoso() throws Exception {
        String textToVerify="Your account was created successfully";


        super.waitForTextToBePresentInElementLocated(this.driver,20,textToVerify);

        Assertions.assertTrue(this.driver.getPageSource().contains(textToVerify),"VERIFICACION FALLIDA 😡");
    }
}
