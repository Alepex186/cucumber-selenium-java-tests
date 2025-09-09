package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.AccountsOverviewPage;
import myproject.pages.AccountServices_Elements.OpenNewAccountPage;
import org.jsoup.nodes.Element;


public class AccountsOverviewStep {
    TestContext testContext=Hooks.getThreadLocalContext().get();

    private final AccountsOverviewPage accountsOverviewPage=testContext.getAccountsOverviewPage();
    private final AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();
    private final OpenNewAccountPage openNewAccountPage=testContext.getOpenNewAccountPage();
    private String FromtransferredAccountId;
    private String NewAccountId;

    public AccountsOverviewStep(){
    }

    @Given("El usuario esta en el apartado de Accounts Overview y visualiza la lista actual de cuentas")
    public void accountOverview(){
        accountServicesPage.ClickAccountsOverview();


        Element tbody = accountsOverviewPage.getTableData();
        accountsOverviewPage.setElementos1(tbody);

    }

    @When("El usuario navega a Open New Account y crea una nueva cuenta")
    public void openNewAccount() throws Exception {
        this.accountServicesPage.ClickOpenNewAccount();
        this.openNewAccountPage.SelectValueSelect(0);
        this.FromtransferredAccountId= this.openNewAccountPage.SelectValue_fromAccountId(0);
        this.openNewAccountPage.sendFormularyOpenNewAccount();
        this.NewAccountId=this.openNewAccountPage.verifyCreatedAccount();
    }

    @And("El usuario regresa a la pagina de Accounts Overview")
    public void accountOverviewReturn(){
        this.accountServicesPage.ClickAccountsOverview();

        Element tbody = accountsOverviewPage.getTableData();
        accountsOverviewPage.setElementos2(tbody);

    }

    @Then("deberia visualizarse una nueva cuenta en la lista, con el id visualizado al crear la cuenta")
    public void verify() throws Exception {
        accountsOverviewPage.verifyTables(FromtransferredAccountId,NewAccountId);
    }

}
