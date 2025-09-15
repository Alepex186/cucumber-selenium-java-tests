package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.AccountsOverviewPage;
import myproject.pages.AccountServices_Elements.TransferFundsPage;
import org.jsoup.nodes.Element;

public class TransferFundsStep {
    TestContext testContext=Hooks.getThreadLocalContext().get();


    TransferFundsPage transferFundsPage=testContext.getTransferFundsPage();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();
    AccountsOverviewPage accountsOverviewPage=testContext.getAccountsOverviewPage();


    String fromAccountId;
    String toAccountId;


    public TransferFundsStep(){
    }


    @Given("El usuario esta en el apartado de Accounts Overview y visualiza el dinero de las cuentas a transferir")
    public void usuarioEnAccountsOverview(){

        this.testContext.getAccountServicesPage().ClickAccountsOverview();

        Element tbody = this.accountsOverviewPage.getTableData();
        this.accountsOverviewPage.setElementos1(tbody);
        this.accountServicesPage.ClickAccountsOverview();
    }

    @When("El usuario navega al apartado Transfer Funds")
    public void usuarioNavegaTransferFunds() {
        this.testContext.getAccountServicesPage().ClickTransferFunds();
    }

    @And("El usuario ingresa un monto de {string} dólares")
    public void usuarioIngresaMonto(String amount) {
        this.transferFundsPage.sendKeysAmount_element(amount);
    }

    @And("El usuario selecciona la cuenta de origen")
    public void usuarioSeleccionaCuentaOrigen() {
        this.fromAccountId= this.transferFundsPage.Select_fromAccountId_element(0);

    }

    @And("El usuario selecciona la cuenta de destino")
    public void usuarioSeleccionaCuentaDestino() {
        this.toAccountId= transferFundsPage.Select_toAccountId(1);

    }

    @And("El usuario envía el formulario")
    public void usuarioEnviaFormulario() {
        this.transferFundsPage.clickSendFormularyButton();
    }

    @Then("El usuario debería visualizar el texto Transfer Complete!")
    public void usuarioVeTransferComplete() {
        this.transferFundsPage.Deberia_visualizarse_el_texto_Transfer_Complete();
    }

    @And("El saldo de la cuenta de {string} cambia en {string} dolares")
    public void usuarioSaldoDeCuentaCambia(String account,String amount) throws Exception {
        this.accountsOverviewPage.verifyTablesAmount(account,this.fromAccountId,Double.parseDouble(amount));
    }


}
