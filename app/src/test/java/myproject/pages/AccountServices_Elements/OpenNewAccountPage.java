package myproject.pages.AccountServices_Elements;

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

    public OpenNewAccountPage(WebDriver driver){
        super("accountmanagement_page");
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }


    public void OpenNewAccountClick(){
        openNewAccountButton.click();
    }


    private void WaitElement(WebElement element) throws InterruptedException {
        for(int i=0;i<5;i++){
            if(element.isDisplayed()){
                break;
            }
            Thread.sleep(1000);
        }
    }



    public String SelectValueSelect(int index) throws InterruptedException {

        WaitElement(this.accountTypeSelect);
        Select select=new Select(this.accountTypeSelect);
        select.selectByIndex(index);
        WebElement selectedOptionId=select.getFirstSelectedOption();
        return selectedOptionId.getText();

    }
    public String SelectValue_fromAccountId(int index){
        Select select=new Select(this.fromAccountIdTypeSelect);
        System.out.println(index);
        select.selectByIndex(index);
        WebElement selectedOption=select.getFirstSelectedOption();
        return selectedOption.getText();


    }
    public void sendFormularyOpenNewAccount() throws InterruptedException {
        WaitElement(this.sendFormularyButton);
        sendFormularyButton.click();
    }

    public String verifyCreatedAccount() throws Exception {
        super.TakesScreenshot(this.driver);
        Assertions.assertTrue(this.driver.getPageSource().contains("Congratulations, your account is now open."),"NO SE HA PODIDO CREAR LA CUENTA");
        WebElement idNewAccount=this.driver.findElement(By.id("newAccountId"));
        return idNewAccount.getText();

    }





}
