package myproject.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import myproject.pages.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterStep {
    RegisterPage registerPage;
    WebDriver driver;


    public RegisterStep() {
        this.driver=Hooks.getDriver();
        this.registerPage=new RegisterPage(this.driver);
    }


    @Given("Ingreso a la pagina de registro")
    public RegisterStep ingresarAUrl(){
        registerPage.GetUrl();
        return this;
    }

    @When("Cuando completo el formulario con datos valido generados")
    public RegisterStep completarFormulario() throws Exception {
        registerPage.Register();
        return this;
    }

    @And("Y hago click en el boton para enviar el formulario")
    public RegisterStep enviarFormulario(){
        registerPage.enviarFormulario();
        return this;
    }


    @Then("deberia ver la pagina principal del usuario")
    public RegisterStep verificarExitoso() throws Exception {
        registerPage.verificarExitoso();
        return this;
    }


}
