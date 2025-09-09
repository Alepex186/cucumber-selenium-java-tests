package myproject.pages;

import myproject.abs.abs_basics_funtions;
import myproject.objs.FakeUserData;
import myproject.steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage extends abs_basics_funtions {
    FakeUserData fakeUserData;


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
        this.fakeUserData = new FakeUserData();

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



        this.First_name.sendKeys(fakeUserData.getFirst_Name());
        this.Last_name.sendKeys(fakeUserData.getLast_Name());
        this.Address.sendKeys(fakeUserData.getAddress());
        this.City.sendKeys(fakeUserData.getCity());
        this.State.sendKeys(fakeUserData.getState());
        this.ZipCode.sendKeys(fakeUserData.getZip_Code());
        this.Phone.sendKeys(fakeUserData.getPhone());
        this.SSN.sendKeys(fakeUserData.getSSN());
        this.Username.sendKeys(fakeUserData.getUsername());
        this.Password.sendKeys(fakeUserData.getPassword());
        this.PasswordConfirm.sendKeys(fakeUserData.getPassword());

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
