package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.AccountsOverviewPage;
import myproject.pages.AccountServices_Elements.TransferFundsPage;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;

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
    public void El_usuario_esta_en_el_apartado_de_Accounts_Overview_y_visualiza_el_dinero_de_las_cuentas_a_transferir(){

        this.testContext.getAccountServicesPage().ClickAccountsOverview();

        Element tbody = this.accountsOverviewPage.getTableData();
        this.accountsOverviewPage.setElementos1(tbody);
        this.accountServicesPage.ClickAccountsOverview();
    }

    @When("El usuario navega a Transfer Funds")
    public void El_usuario_navega_a_Transfer_Funds(){
        this.testContext.getAccountServicesPage().ClickTransferFunds();
    }

    @And("Ingresa un monto a enviar de {string} dolares")
    public void Ingresa_un_monto_a_enviar_de_string_dolares(String amount){
        this.transferFundsPage.sendKeysAmount_element(amount);
    }

    @And("Selecciona la cuenta de origen")
    public void Selecciona_la_cuenta_de_origen(){
        this.fromAccountId= this.transferFundsPage.Select_fromAccountId_element(0);
        System.out.println("$$$$$$$$$$$ fromAccountId :" +fromAccountId);

    }

    @And("Selecciona la cuenta de destino")
    public void Selecciona_la_cuenta_de_destino(){
        this.toAccountId= transferFundsPage.Select_toAccountId(1);
        System.out.println("$$$$$$$$$$$ toAccountId :" +toAccountId);

    }

    @And("El usuario envia el formulario")
    public void El_usuario_envia_el_formulario(){
        this.transferFundsPage.clickSendFormularyButton();
    }

    @Then("Deberia visualizarse el texto Transfer Complete!")
    public void Deberia_visualizarse_el_texto_Transfer_Complete(){
        this.transferFundsPage.Deberia_visualizarse_el_texto_Transfer_Complete();
    }

    @And("El saldo de la cuenta de {string} cambia en {string} dolares")
    public void El_saldo_de_la_cuenta_de_origen_disminuye_dolares(String account,String amount) throws Exception {
        this.accountsOverviewPage.verifyTablesAmount(account,this.fromAccountId,Double.parseDouble(amount));
    }




}
