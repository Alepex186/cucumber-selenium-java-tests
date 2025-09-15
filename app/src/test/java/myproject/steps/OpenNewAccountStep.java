package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.OpenNewAccountPage;

public class OpenNewAccountStep {

    TestContext testContext=Hooks.getThreadLocalContext().get();


    OpenNewAccountPage openNewAccountPage=testContext.getOpenNewAccountPage();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();


    public OpenNewAccountStep(){

    }

    @When("El usuario hace clic en el botón Open New Account")
    public void usuarioClickOpenNewAccount() {
        this.accountServicesPage.ClickOpenNewAccount();
        //this.accountManagementPage.OpenNewAccountClick();
    }

    @And("El usuario selecciona un tipo de cuenta")
    public void usuarioSeleccionaTipoCuenta() throws InterruptedException {
        this.openNewAccountPage.SelectValueSelect(Integer.parseInt("1"));
    }

    @And("El usuario selecciona la cuenta para descontar el deposito")
    public void usuarioSeleccionaCuentaOrigen() {
        this.openNewAccountPage.SelectValue_fromAccountId(Integer.parseInt("0"));
    }

    @And("El usuario hace clic en el botón para enviar el formulario de Open New Account")
    public void usuarioEnviaFormularioOpenNewAccount() throws InterruptedException {
        this.openNewAccountPage.sendFormularyOpenNewAccount();
    }


    @Then("El usuario debería visualizar el mensaje Congratulations, your account is now open")
    public void usuarioVeMensajeCuentaCreada() throws Exception {
        this.openNewAccountPage.verifyCreatedAccount();
    }
}
