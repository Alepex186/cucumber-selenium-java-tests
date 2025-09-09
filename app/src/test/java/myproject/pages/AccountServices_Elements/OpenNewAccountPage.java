package myproject.pages.AccountServices_Elements;

import myproject.steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;


public class OpenNewAccountPage extends myproject.abs.abs_basics_funtions{


    @FindBy(xpath = "//select[@id='type' and @class='input']")
    WebElement accountTypeSelect;

    @FindBy(xpath = "//select[@id='fromAccountId' and @class='input']")
    WebElement fromAccountIdTypeSelect;


    @FindBy(xpath = "//input[@type='button' and @class='button' and @value='Open New Account']")
    WebElement sendFormularyButton;


    @FindBy(xpath = "//a[@href='openaccount.htm']")
    WebElement openNewAccountButton;

    WebDriver driver;

    public OpenNewAccountPage(TestContext testContext){
        super("accountmanagement_page");
        this.driver=testContext.getDriver();

        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,20),this);
    }








    public String SelectValueSelect(int index) throws InterruptedException {

        super.waitForClickableElement(this.driver,this.accountTypeSelect,20);
        super.waitPresenceOfNestedElementLocatedBy(this.driver,this.accountTypeSelect,By.tagName("option"),20);


        Select select=new Select(this.accountTypeSelect);
        select.selectByIndex(index);
        WebElement selectedOptionId=select.getFirstSelectedOption();
        return selectedOptionId.getText();

    }
    public String SelectValue_fromAccountId(int index){

        super.waitForClickableElement(this.driver,this.fromAccountIdTypeSelect,20);
        super.waitPresenceOfNestedElementLocatedBy(this.driver,this.fromAccountIdTypeSelect,By.tagName("option"),20);

        Select select=new Select(this.fromAccountIdTypeSelect);

        select.selectByIndex(index);
        WebElement selectedOption=select.getFirstSelectedOption();
        return selectedOption.getText();


    }
    public void sendFormularyOpenNewAccount() throws InterruptedException {
        super.waitForClickableElement(this.driver,this.sendFormularyButton,20);
        sendFormularyButton.click();
    }

    public String verifyCreatedAccount() throws Exception {
        Assertions.assertTrue(this.driver.getPageSource().contains("Congratulations, your account is now open."),"NO SE HA PODIDO CREAR LA CUENTA");
        WebElement idNewAccount=this.driver.findElement(By.id("newAccountId"));
        return idNewAccount.getText();

    }

}
