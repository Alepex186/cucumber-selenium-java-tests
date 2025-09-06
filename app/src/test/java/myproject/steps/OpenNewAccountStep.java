package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.OpenNewAccountPage;
import org.openqa.selenium.WebDriver;

public class OpenNewAccountStep {

    TestContext testContext=Hooks.getThreadLocalContext().get();


    OpenNewAccountPage openNewAccountPage=testContext.getOpenNewAccountPage();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();


    public OpenNewAccountStep(){

    }

    @When("Hago click en el boton {string}")
    public void newAccountClick(String valor){
        this.accountServicesPage.ClickOpenNewAccount();
        //this.accountManagementPage.OpenNewAccountClick();
    }

    @And("Selecciono el valor {string} del menu de tipo de cuenta")
    public void seleccionarValor(String index) throws InterruptedException {
        this.openNewAccountPage.SelectValueSelect(Integer.parseInt(index));
    }

    @And("Selecciono el valor {string} del menu del ID de la cuenta")
    public void seleccionarAccountId(String index){
        this.openNewAccountPage.SelectValue_fromAccountId(Integer.parseInt(index));
    }

    @And("Hago click en el boton para enviar el formulario de {string}")
    public void enviarFormulario(String string) throws InterruptedException {
        this.openNewAccountPage.sendFormularyOpenNewAccount();
    }


    @Then("deberia aparecer el mensaje {string}")
     public void verificar(String string) throws Exception {
        this.openNewAccountPage.verifyCreatedAccount();
    }


}
