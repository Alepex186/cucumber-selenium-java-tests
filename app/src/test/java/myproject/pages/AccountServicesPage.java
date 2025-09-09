package myproject.pages;

import myproject.steps.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import myproject.abs.abs_basics_funtions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AccountServicesPage extends abs_basics_funtions{

    @FindBy(xpath = "//a[@href='openaccount.htm']")
    WebElement openNewAccount;

    @FindBy(xpath = "//a[@href='overview.htm']")
    WebElement accountsOverview;

    @FindBy(xpath = "//a[@href='transfer.htm']")
    WebElement transferFunds;

    @FindBy(xpath = "//a[@href='billpay.htm']")
    WebElement billPay;

    @FindBy(xpath = "//a[@href='findtrans.htm']")
    WebElement findTransactions;

    @FindBy(xpath = "//a[@href='updateprofile.htm']")
    WebElement updateContactInfo;

    @FindBy(xpath = "//a[@href='requestloan.htm']")
    WebElement requestLoan;

    @FindBy(xpath = "//a[@href='logout.htm']")
    WebElement logOut;

    WebDriver driver;


    public AccountServicesPage(TestContext testContext){
        super("AccountServicesPage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public void ClickOpenNewAccount(){
        super.waitForClickableElement(this.driver,openNewAccount,20);
        openNewAccount.click();
    }
    public void ClickAccountsOverview(){
        super.waitForClickableElement(this.driver,accountsOverview,20);
        accountsOverview.click();
    }
    public void ClickTransferFunds(){
        super.waitForClickableElement(this.driver,transferFunds,20);
        transferFunds.click();
    }
    public void ClickBillPay(){
        super.waitForClickableElement(this.driver,billPay,20);
        billPay.click();
    }
    public void ClickFindTransactions(){
        super.waitForClickableElement(this.driver,findTransactions,20);
        findTransactions.click();
    }
    public void ClickUpdateContactInfo(){
        super.waitForClickableElement(this.driver,updateContactInfo,20);
        updateContactInfo.click();
    }
    public void ClickRequestLoan(){
        super.waitForClickableElement(this.driver,requestLoan,20);
        requestLoan.click();
    }
    public void ClickLogOut(){
        super.waitForClickableElement(this.driver,logOut,20);
        logOut.click();
    }
}
