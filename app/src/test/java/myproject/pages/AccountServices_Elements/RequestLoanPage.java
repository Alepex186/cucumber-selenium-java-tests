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

public class RequestLoanPage extends abs_basics_funtions {

    @FindBy(xpath = "//input[@id='amount']")
    WebElement loanAmount;

    @FindBy(xpath = "//input[@id='downPayment']")
    WebElement downPayment;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    WebElement fromAccountId;

    @FindBy(xpath = "//input[@type='button' and @value='Apply Now']")
    WebElement sendFormularyButton;

    @FindBy(xpath = "//div[(@id='loanRequestApproved' or @id='loanRequestDenied') and not(contains(@style,'display:none'))]//p")
    WebElement messageToVerify;



    WebDriver driver;
    public RequestLoanPage(TestContext testContext){
        super("RequestLoanPage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,TIMEOUT),this);
    }

    public void enterLoanAmount(String amount) {
        super.waitForClickableElement(this.driver,this.loanAmount,TIMEOUT);
        this.loanAmount.sendKeys(amount);
    }

    public void enterDownPaymentAmount(String amount) {
        super.waitForClickableElement(this.driver,this.downPayment,TIMEOUT);
        this.downPayment.sendKeys(amount);
    }

    public void selectFromAccount() {
        super.waitForClickableElement(this.driver,this.fromAccountId,TIMEOUT);
        super.waitPresenceOfNestedElementLocatedBy(this.driver,this.fromAccountId, By.tagName("option"),TIMEOUT);
        Select select=new Select(this.fromAccountId);
        select.selectByValue("12345");
    }

    public void sendFormulary() {
        super.waitForClickableElement(this.driver,this.sendFormularyButton,TIMEOUT);
        this.sendFormularyButton.click();
    }

    public void verify(String message) {
        super.waitForVisibilityOf(this.driver,this.messageToVerify,TIMEOUT);
        Assertions.assertEquals(message,this.messageToVerify.getText());
    }
}
