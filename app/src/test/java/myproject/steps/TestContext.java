package myproject.steps;

import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.AccountsOverviewPage;
import myproject.pages.AccountServices_Elements.OpenNewAccountPage;
import myproject.pages.AccountServices_Elements.TransferFundsPage;
import myproject.pages.LoginPage;
import myproject.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private final ThreadLocal<AccountsOverviewPage> accountsOverviewPage=new ThreadLocal<>();
    private final ThreadLocal<AccountServicesPage> accountServicesPage=new ThreadLocal<>();
    private final ThreadLocal<OpenNewAccountPage> openNewAccountPage=new ThreadLocal<>();
    private final ThreadLocal<TransferFundsPage> transferFundsPage=new ThreadLocal<>();
    private final ThreadLocal<LoginPage> loginPage=new ThreadLocal<>();
    private  final ThreadLocal<RegisterPage> registerPage=new ThreadLocal<>();



    private WebDriver driver;


    public TestContext(){
        this.driver=Hooks.getDriver();

        this.accountsOverviewPage.set(new AccountsOverviewPage(this));
        this.accountServicesPage.set(new AccountServicesPage(this));
        this.openNewAccountPage.set(new OpenNewAccountPage(this));
        this.transferFundsPage.set(new TransferFundsPage(this));
        this.loginPage.set(new LoginPage(this));
        this.registerPage.set(new RegisterPage(this));
    }


    public AccountsOverviewPage getAccountsOverviewPage() {
        return accountsOverviewPage.get();
    }

    public AccountServicesPage getAccountServicesPage() {
        return accountServicesPage.get();
    }

    public OpenNewAccountPage getOpenNewAccountPage() {
        return openNewAccountPage.get();
    }

    public TransferFundsPage getTransferFundsPage() {
        return transferFundsPage.get();
    }

    public LoginPage getLoginPage() {
        return loginPage.get();
    }

    public RegisterPage getRegisterPage() {
        return registerPage.get();
    }

    public WebDriver getDriver() {
        return driver;
    }



}
