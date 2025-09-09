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


    @Given("Ingreso a la pagina de registro")
    public void ingresarAUrl(){
        registerPage.GetUrl();
    }

    @When("Cuando completo el formulario con datos valido generados")
    public void completarFormulario() throws Exception {
        registerPage.Register();
    }

    @And("Y hago click en el boton para enviar el formulario")
    public void enviarFormulario(){
        registerPage.enviarFormulario();
    }


    @Then("deberia ver la pagina principal del usuario")
    public void verificarExitoso() throws Exception {
        registerPage.verificarExitoso();
    }


}
