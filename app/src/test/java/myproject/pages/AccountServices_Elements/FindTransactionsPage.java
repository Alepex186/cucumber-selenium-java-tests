package myproject.pages.AccountServices_Elements;

import myproject.abs.abs_basics_funtions;
import myproject.steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsPage extends abs_basics_funtions {
    private final int TIMEOUT = super.TIMEOUT;


    @FindBy(xpath = "//input[@id='transactionDate']")
    WebElement findByDateElement;

    @FindBy(xpath = "//button[@type='submit' and @id='findByDate']")
    WebElement findByDateButton;



    @FindBy(xpath = "//input[@id='fromDate']")
    WebElement fromDate;

    @FindBy(xpath = "//input[@id='toDate']")
    WebElement toDate;

    @FindBy(xpath = "//button[@type='submit' and @id='findByDateRange']")
    WebElement findByDateRangeButton;




    @FindBy(xpath = "//input[@id='amount']")
    WebElement findByAmount;

    @FindBy(xpath = "//button[@type='submit' and @id='findByAmount']")
    WebElement findByAmountButton;



    String tableElementsXpath="//tbody[@id='transactionBody']/tr";

    @FindBy(xpath = "//tbody[@id='transactionBody']/tr")
    List<WebElement> tableElements;




    @FindBy(xpath = "//select[@id='accountId']")
    WebElement selectAnAccount;



    WebDriver driver;

    public FindTransactionsPage(TestContext testContext){
        super("FindTransactionsPage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,20),this);
    }


    public void findByDate(String date){
        super.waitForClickableElement(this.driver,findByDateElement,TIMEOUT);
        findByDateElement.sendKeys(date);

    }

    public void findByDateSendFormulary(){
        super.waitForClickableElement(this.driver,this.findByDateButton,TIMEOUT);
        this.findByDateButton.click();
    }

    public void verifyTable(){

        try {
            super.waitForVisibilityOf(this.driver,tableElements.get(0),TIMEOUT);

        }catch (Exception e){
            boolean hasRegistrations = !driver.findElements(By.xpath(tableElementsXpath)).isEmpty();
            Assertions.assertTrue(hasRegistrations, "La tabla no contiene registros");
        }

    }

    public void findByDateRange(String date1, String date2) {

        super.waitForClickableElement(this.driver,this.fromDate,TIMEOUT);
        super.waitForClickableElement(this.driver,this.toDate,TIMEOUT);


        this.fromDate.sendKeys(date1);
        this.toDate.sendKeys(date2);
    }

    public void findByDateRangeSendFormulary(){
        super.waitForClickableElement(this.driver,this.findByDateRangeButton,TIMEOUT);
        this.findByDateRangeButton.click();
    }

    public void findByAmount(String amount) {
        super.waitForClickableElement(this.driver,this.findByAmount,TIMEOUT);
        this.findByAmount.sendKeys(amount);

    }

    public void findByAmountSendFormulary(){
        super.waitForClickableElement(this.driver,this.findByAmountButton,TIMEOUT);
        this.findByAmountButton.click();
    }

    public void selectAnAccount() {
        super.waitForClickableElement(this.driver,this.selectAnAccount,TIMEOUT);
        super.waitPresenceOfNestedElementLocatedBy(this.driver,this.selectAnAccount,By.tagName("option"),TIMEOUT);
        Select select=new Select(this.selectAnAccount);
        select.selectByValue("12345");

    }
}
