package myproject.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myproject.pages.AccountServicesPage;
import myproject.pages.LoginPage;

public class LogOutStep {
    TestContext testContext=Hooks.getThreadLocalContext().get();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();
    LoginPage loginPage= testContext.getLoginPage();



    @Given("el usuario hace click en el boton Log Out")
    public void elUsuarioHaceClickEnElBotonLogOut(){
        accountServicesPage.ClickLogOut();
    }

    @Then("deberia regresar a la pagina de login")
    public void deberiaRegresarALaPaginaDeLogin(){
        loginPage.verifyIsOnThisPage();
    }

}
