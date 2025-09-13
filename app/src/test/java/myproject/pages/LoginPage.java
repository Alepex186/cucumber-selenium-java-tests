package myproject.pages;


import myproject.abs.abs_basics_funtions;

import myproject.steps.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends abs_basics_funtions {
    //private static final Log log = LogFactory.getLog(LoginPage.class);

    //SELECTORS
    @FindBy(xpath = "//input[@type='text' and @class='input' and @name='username']")
    WebElement username_element;


    @FindBy(xpath = "//input[@type='password' and @class='input' and @name='password']")
    WebElement password_element;


    @FindBy(xpath = "//input[@type='submit']")
    WebElement login_button;


    //elemento del Scenario "Verificamos credenciales correctas"
    @FindBy(xpath = "//a[@href='billpay.htm']")
    WebElement referencia_verificar;


    @FindBy(xpath = "//p[@class='error']")
    WebElement referencia_verificar_fallido;

    String url="http://localhost:8080/parabank/index.htm";//"https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";

    WebDriver driver;


    @FindBy(xpath = "//div[@id='leftPanel']//h2")
    WebElement leftPanelCustomerLoginMessageElement;

    String leftPanelCustomerLoginMessage="Customer Login";




    public LoginPage(TestContext testContext) {
        super("login_page");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }


    public void GetUrl() throws Exception {
        this.driver.get(url);
    }


    public void sendKeysUsername_element(String username) {
        super.waitForClickableElement(this.driver,username_element,20);
        this.username_element.sendKeys(username);
    }

    public void sendKeysPassword_element(String password) {
        super.waitForClickableElement(this.driver,password_element,20);
        this.password_element.sendKeys(password);
    }

    public void clickLogin_button() {
        super.waitForClickableElement(this.driver,login_button,20);
        this.login_button.click();
    }

    public void verificarExitoso(String mensaje) throws Exception {
        Assertions.assertTrue(this.referencia_verificar.isDisplayed(),"VERIFICACION FALLIDA");
    }
    public void verificarFallido(String mensaje){
        Assertions.assertTrue(this.referencia_verificar_fallido.isDisplayed(),"VERIFICACION FALLIDA");
    }

    public void verifyIsOnThisPage() {
        super.waitForVisibilityOf(this.driver,this.leftPanelCustomerLoginMessageElement,TIMEOUT);
        Assertions.assertEquals(this.leftPanelCustomerLoginMessageElement.getText(),this.leftPanelCustomerLoginMessage);
    }
}
