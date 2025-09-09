package myproject.pages.AccountServices_Elements;

import myproject.abs.abs_basics_funtions;
import myproject.objs.FakeUserData;
import myproject.steps.TestContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//div[@id='updateProfileResult']//h1")
    WebElement updateProfileResult;


    String messageToVerify="Profile Updated";


    List<String> snapshot1;
    List<String> snapshot2;

    WebDriver driver;


    public UpdateProfilePage(TestContext testContext){
        super("UpdateProfilePage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,20),this);
    }



    public void UpdateData(){
        WaitForAllElements();

        FakeUserData fakeUserData=new FakeUserData();
        this.firstName.clear();this.firstName.sendKeys(fakeUserData.getFirst_Name());

        this.lastName.clear();this.lastName.sendKeys(fakeUserData.getLast_Name());

        this.address.clear();this.address.sendKeys(fakeUserData.getAddress());

        this.city.clear();this.city.sendKeys(fakeUserData.getCity());

        this.zipCode.clear();this.zipCode.sendKeys(fakeUserData.getZip_Code());

        this.phone.clear();this.phone.sendKeys(fakeUserData.getPhone());
    }

    public void SendFormulary(){
        super.waitForClickableElement(this.driver,this.updateProfileButton,TIMEOUT);

        this.updateProfileButton.click();
    }



    public void WaitForAllElements(){
        super.waitForClickableElement(this.driver,this.firstName,TIMEOUT);
        super.waitForClickableElement(this.driver,this.lastName,TIMEOUT);
        super.waitForClickableElement(this.driver,this.address,TIMEOUT);
        super.waitForClickableElement(this.driver,this.city,TIMEOUT);
        super.waitForClickableElement(this.driver,this.zipCode,TIMEOUT);
        super.waitForClickableElement(this.driver,this.phone,TIMEOUT);
    }



    public List<String> TakeDataSnapshot(){

        WaitForAllElements();

        List<String> temp=new ArrayList<>();
        temp.add(this.firstName.getAttribute("value"));
        temp.add(this.lastName.getAttribute("value"));
        temp.add(this.address.getAttribute("value"));
        temp.add(this.city.getAttribute("value"));
        temp.add(this.zipCode.getAttribute("value"));
        temp.add(this.phone.getAttribute("value"));

        return temp;
    }


    public void setSnapshot2(List<String> snapshot2) {
        this.snapshot2 = snapshot2;
    }

    public void setSnapshot1(List<String> snapshot1) {
        this.snapshot1 = snapshot1;
    }

    public void verifySnapshots() {
        Assertions.assertFalse(snapshot1.equals(snapshot2),"ERROR, EL PERFIL NO SE ACTUALIZO");
    }

    public void verifyMessage() {
        super.waitForVisibilityOf(this.driver,this.updateProfileResult,TIMEOUT);

        Assertions.assertTrue(this.updateProfileResult.getText().equals(messageToVerify),"ERROR AL ACTUALIZAR EL PERFIL");
    }
}
