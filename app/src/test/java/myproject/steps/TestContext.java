package myproject.steps;

import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.*;
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
    private  final ThreadLocal<BillPayPage> billPayPage=new ThreadLocal<>();
    private final ThreadLocal<FindTransactionsPage> findTransactionsPage=new ThreadLocal<>();


    private WebDriver driver;


    public TestContext(){
        this.driver=Hooks.getDriver();

        this.accountsOverviewPage.set(new AccountsOverviewPage(this));
        this.accountServicesPage.set(new AccountServicesPage(this));
        this.openNewAccountPage.set(new OpenNewAccountPage(this));
        this.transferFundsPage.set(new TransferFundsPage(this));
        this.loginPage.set(new LoginPage(this));
        this.registerPage.set(new RegisterPage(this));
        this.billPayPage.set(new BillPayPage(this));
        this.findTransactionsPage.set(new FindTransactionsPage(this));
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

    public BillPayPage getBillPayPage() {
        return billPayPage.get();
    }

    public FindTransactionsPage getFindTransactionsPage() {
        return findTransactionsPage.get();
    }

    public WebDriver getDriver() {
        return driver;
    }



}
