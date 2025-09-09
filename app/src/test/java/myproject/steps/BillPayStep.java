package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.AccountsOverviewPage;
import myproject.pages.AccountServices_Elements.BillPayPage;

public class BillPayStep {

    TestContext testContext=Hooks.getThreadLocalContext().get();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();
    BillPayPage billPayPage=testContext.getBillPayPage();
    AccountsOverviewPage accountsOverviewPage=testContext.getAccountsOverviewPage();

    public BillPayStep(){

    }


    @And("El usuario esta en el apartado de Bill Pay")
    public void elUsuarioEstaEnElApartadoDeBillPay(){
        accountServicesPage.ClickBillPay();
    }

    @When("El usuario rellena el formulario e ingresa la cantidad de {string} dolares")
    public void elUsuarioRellenaElFormulario(String money){
        billPayPage.fillOutForm(money);
    }
    @And("Hace click en el boton SEND PAYMENT")
    public void haceClickEnElBotonSENDPAYMENT(){
        billPayPage.sendFormulary();
    }
    @Then("Deberia aparecer el mensaje Bill Payment Complete")
    public void deberiaAparecerElMensajeBillPaymentComplete(){
        billPayPage.verify();
    }

    @And("El saldo deberia disminuir en {string} dolares")
    public void elSaldoDeberiaDisminuirEnStringDolares(String money) throws Exception {
        accountsOverviewPage.verifyTableSameAccount(billPayPage.getFromAccountNumberString(),Integer.parseInt(money));
    }



}
