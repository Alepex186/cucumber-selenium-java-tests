package myproject.pages.AccountServices_Elements;

import myproject.steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends myproject.abs.abs_basics_funtions{
    WebDriver driver;
    AccountsOverviewPage accountsOverviewPage;


    @FindBy(xpath = "//input[@id='amount' and @type='text']")
    WebElement amount;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    WebElement fromAccountId;

    @FindBy(xpath = "//select[@id='toAccountId']")
    WebElement toAccountId;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement sendFormularyButton;


    @FindBy(xpath = "//div[@id='showResult']/h1[@class='title']")
    WebElement TransferCompleteMessage;

    public TransferFundsPage(TestContext testContext) {
        super("TransferFundsPage");
        this.driver = testContext.getDriver();
        this.accountsOverviewPage=testContext.getAccountsOverviewPage();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,20),this);
    }

    public void sendKeysAmount_element(String value){
        amount.sendKeys(value);
    }

    public String Select_fromAccountId_element(int index){


        super.waitForElement(this.driver,fromAccountId,5);

        Select select = new Select(fromAccountId);
        select.selectByIndex(index);

        return select.getFirstSelectedOption().getText();
    }

    public String Select_toAccountId(int index){
        Select select = new Select(toAccountId);
        select.selectByIndex(index);

        return select.getFirstSelectedOption().getText();
    }

    public void clickSendFormularyButton(){
        sendFormularyButton.click();
    }

    public void Deberia_visualizarse_el_texto_Transfer_Complete(){


        super.waitForElement(this.driver,TransferCompleteMessage,20);
        System.out.println(TransferCompleteMessage.getText());
        Assertions.assertTrue(TransferCompleteMessage.getText().equals("Transfer Complete!"));
    }
}
