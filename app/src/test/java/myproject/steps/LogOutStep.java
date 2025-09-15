package myproject.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import myproject.pages.AccountServicesPage;
import myproject.pages.LoginPage;

public class LogOutStep {
    TestContext testContext=Hooks.getThreadLocalContext().get();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();
    LoginPage loginPage= testContext.getLoginPage();



    @Given("El usuario hace clic en el botón Log Out")
    public void usuarioHaceClickLogOut() {
        accountServicesPage.ClickLogOut();
    }

    @Then("El usuario debería regresar a la página de login")
    public void usuarioVePaginaLogin() {
        loginPage.verifyIsOnThisPage();
    }

}
