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
    public void usuarioEnAccountsOverview() {
        accountServicesPage.ClickAccountsOverview();


        Element tbody = accountsOverviewPage.getTableData();
        accountsOverviewPage.setElementos1(tbody);

    }

    @When("El usuario navega al apartado Open New Account y crea una nueva cuenta")
    public void usuarioCreaNuevaCuenta() throws Exception {
        this.accountServicesPage.ClickOpenNewAccount();
        this.openNewAccountPage.SelectValueSelect(0);
        this.FromtransferredAccountId= this.openNewAccountPage.SelectValue_fromAccountId(0);
        this.openNewAccountPage.sendFormularyOpenNewAccount();
        this.NewAccountId=this.openNewAccountPage.verifyCreatedAccount();
    }

    @And("El usuario regresa a la página de Accounts Overview")
    public void usuarioRegresaAccountsOverview() {
        this.accountServicesPage.ClickAccountsOverview();

        Element tbody = accountsOverviewPage.getTableData();
        accountsOverviewPage.setElementos2(tbody);

    }

    @Then("El usuario debería visualizar la nueva cuenta en la lista, con el ID mostrado al momento de crearla")
    public void usuarioVerificaNuevaCuenta() throws Exception {
        accountsOverviewPage.verifyTables(this.FromtransferredAccountId,this.NewAccountId);
    }

}
