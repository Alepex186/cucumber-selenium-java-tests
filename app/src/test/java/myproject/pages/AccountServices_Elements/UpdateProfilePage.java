package myproject.pages.AccountServices_Elements;

import myproject.abs.abs_basics_funtions;
import myproject.steps.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.swing.text.Element;

public class UpdateProfilePage extends abs_basics_funtions {

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    WebElement address;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    WebElement phone;

    @FindBy(xpath = "//input[@type='button']")
    WebElement updateProfileButton;


    Element snapshot1;
    Element snapshot2;

    WebDriver driver;






    public UpdateProfilePage(TestContext testContext){
        super("UpdateProfilePage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,20),this);
    }


    public void TakePageSnapshot1(){
        this.snapshot1=null;
    }




}
