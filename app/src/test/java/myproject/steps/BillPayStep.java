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


    @And("El usuario se encuentra en el apartado Bill Pay")
    public void usuarioEnBillPay() {
        accountServicesPage.ClickBillPay();
    }

    @When("El usuario completa el formulario e ingresa la cantidad de {string} dólares")
    public void usuarioRellenaFormulario(String money) {
        billPayPage.fillOutForm(money);
    }

    @And("El usuario hace clic en el botón SEND PAYMENT")
    public void usuarioClickSendPayment() {
        billPayPage.sendFormulary();
    }

    @Then("El usuario debería visualizar el mensaje Bill Payment Complete")
    public void usuarioVisualizaPaymentCompleteMessage(){
        billPayPage.verify();
    }

    @And("El usuario debería visualizar que el saldo disminuyó en {string} dólares")
    public void usuarioVerificaSaldoDisminuido(String money) throws Exception {
        accountsOverviewPage.verifyTableSameAccount(billPayPage.getFromAccountNumberString(),Integer.parseInt(money));
    }



}
