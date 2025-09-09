package myproject.pages.AccountServices_Elements;

import myproject.abs.abs_basics_funtions;
import myproject.steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class BillPayPage extends abs_basics_funtions {
    private final int TIMEOUT = super.TIMEOUT;



    @FindBy(xpath = "//input[@name='payee.name']")
    WebElement payeeName;

    @FindBy(xpath = "//input[@name='payee.address.street']")
    WebElement address;

    @FindBy(xpath = "//input[@name='payee.address.city']")
    WebElement city;

    @FindBy(xpath = "//input[@name='payee.address.state']")
    WebElement state;

    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@name='payee.phoneNumber']")
    WebElement phone;

    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    WebElement accountNumber;

    @FindBy(xpath = "//input[@name='verifyAccount']")
    WebElement accountNumberVerify;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement amount;

    @FindBy(xpath = "//select[@name='fromAccountId']")
    WebElement fromAccountNumber;

    @FindBy(xpath = "//input[@type='button' and @value='Send Payment']")
    WebElement sendPaymentButton;

    @FindBy(xpath = "//div[@id='billpayResult']//h1")
    WebElement billPayResultTitle;


    String messageToVerify="Bill Payment Complete";

    String fromAccountNumberString;





    WebDriver driver;

    public BillPayPage(TestContext testContext){
        super("BillPayPage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,20),this);
    }


    public void fillOutForm(String money){
        super.waitForClickableElement(this.driver,this.payeeName,TIMEOUT);
        super.waitForClickableElement(this.driver,this.address,TIMEOUT);
        super.waitForClickableElement(this.driver,this.city,TIMEOUT);
        super.waitForClickableElement(this.driver,this.state,TIMEOUT);
        super.waitForClickableElement(this.driver,this.zipCode,TIMEOUT);
        super.waitForClickableElement(this.driver,this.phone,TIMEOUT);
        super.waitForClickableElement(this.driver,this.accountNumber,TIMEOUT);
        super.waitForClickableElement(this.driver,this.accountNumberVerify,TIMEOUT);
        super.waitForClickableElement(this.driver,this.amount,TIMEOUT);

        super.waitForClickableElement(this.driver,this.fromAccountNumber,TIMEOUT);
        super.waitPresenceOfNestedElementLocatedBy(this.driver,this.fromAccountNumber, By.tagName("option"),TIMEOUT);



        this.payeeName.sendKeys("test");
        this.address.sendKeys("test");
        this.city.sendKeys("test");
        this.state.sendKeys("test");
        this.zipCode.sendKeys("test");
        this.phone.sendKeys("+123456789");
        this.accountNumber.sendKeys("123456");
        this.accountNumberVerify.sendKeys("123456");
        this.amount.sendKeys(money);

        Select select=new Select(this.fromAccountNumber);
        select.selectByIndex(0);
        this.fromAccountNumberString=select.getFirstSelectedOption().getText();

    }

    public void sendFormulary() {
        super.waitForClickableElement(this.driver,this.sendPaymentButton,TIMEOUT);

        this.sendPaymentButton.click();

    }

    public void verify() {
        super.waitForVisibilityOf(this.driver,this.billPayResultTitle,TIMEOUT);


        Assertions.assertTrue(this.billPayResultTitle.getText().equals(messageToVerify),"NO SE HA COMPLETADO LA TRANSACCION");
    }


    public String getFromAccountNumberString() {
        return fromAccountNumberString;
    }
}











