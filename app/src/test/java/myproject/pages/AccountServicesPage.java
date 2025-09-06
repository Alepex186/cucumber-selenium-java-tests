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
    WebElement OpenNewAccount;

    @FindBy(xpath = "//a[@href='overview.htm']")
    WebElement AccountsOverview;

    @FindBy(xpath = "//a[@href='transfer.htm']")
    WebElement TransferFunds;

    @FindBy(xpath = "//a[@href='findtrans.htm']")
    WebElement BillPay;

    @FindBy(xpath = "//a[@href='findtrans.htm']")
    WebElement FindTransactions;

    @FindBy(xpath = "//a[@href='updateprofile.htm']")
    WebElement UpdateContactInfo;

    @FindBy(xpath = "//a[@href='requestloan.htm']")
    WebElement RequestLoan;

    @FindBy(xpath = "//a[@href='logout.htm']")
    WebElement LogOut;

    WebDriver driver;


    public AccountServicesPage(TestContext testContext){
        super("AccountServicesPage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public void ClickOpenNewAccount(){
        OpenNewAccount.click();
    }
    public void ClickAccountsOverview(){
        AccountsOverview.click();
    }
    public void ClickTransferFunds(){
        TransferFunds.click();
    }
    public void ClickBillPay(){
        BillPay.click();
    }
    public void ClickFindTransactions(){
        FindTransactions.click();
    }
    public void ClickUpdateContactInfo(){
        UpdateContactInfo.click();
    }
    public void ClickRequestLoan(){
        RequestLoan.click();
    }
    public void ClickLogOut(){
        LogOut.click();
    }
}
