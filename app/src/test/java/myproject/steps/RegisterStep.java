package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import myproject.pages.RegisterPage;


public class RegisterStep {

    TestContext testContext=Hooks.getThreadLocalContext().get();



    RegisterPage registerPage=testContext.getRegisterPage();


    public RegisterStep() {
    }


    @Given("El usuario ingresa a la página de registro")
    public void usuarioIngresaRegistro() {
        registerPage.GetUrl();
    }

    @When("El usuario completa el formulario con datos válidos generados automáticamente")
    public void usuarioCompletaFormulario() throws Exception {
        registerPage.Register();
    }

    @And("El usuario hace clic en el botón para enviar el formulario")
    public void usuarioEnviaFormulario() {//ASD ENPECE A HACER ESTO DESDE AQUI
        registerPage.enviarFormulario();
    }


    @Then("El usuario debería ser redirigido a la página principal")
    public void usuarioVePaginaPrincipal() throws Exception {
        registerPage.verificarExitoso();  //ASD
    }


}
