package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    TestContext testContext=Hooks.getThreadLocalContext().get();
    LoginPage loginPage=testContext.getLoginPage();

    String usuario;
    String password;
    WebDriver driver;

    public LoginStep()  {

    }

    @Given("Abro la pagina de login")
    public void ingresarAUrl() throws Exception {
        loginPage.GetUrl();
    }

    @When("Ingreso el usuario correcto {string}")
    public void ingresarUsuarioCorrecto(String usuario){
        loginPage.sendKeysUsername_element(usuario);
    }

    @And("Ingreso la contrasenia correcta {string}")
    public void ingresarContraseniaCorrecta(String contrasenia){
        loginPage.sendKeysPassword_element(contrasenia);
    }

    @And("Hago click en el boton de login")
    public void enviarFormulario(){
        loginPage.clickLogin_button();
    }

    @Then("Deberia logearse y aparecer el texto {string}")
    public void verificarExitoso(String mensaje) throws Exception {
        loginPage.verificarExitoso(mensaje);
    }

    @When("Ingreso el usuario incorrecto {string}")
    public void ingresarUsuarioIncorrecto(String usuario){
        loginPage.sendKeysUsername_element(usuario);
    }

    @Then("Deberia aparecer el mensaje {string}")
    public void verificarFallido(String mensaje){
        loginPage.verificarFallido(mensaje);
    }

    @And("Ingreso una contrasenia incorrecta {string}")
    public void ingresarContraseniaIncorrecta(String contrasenia){
        loginPage.sendKeysPassword_element(contrasenia);
    }


    @Given("El usuario ha iniciado sesión en el sistema con credenciales válidas")
    public void procesoCompletoLogin() throws Exception {
        loginPage.GetUrl();
        loginPage.sendKeysUsername_element("test123456");
        loginPage.sendKeysPassword_element("123456");
        loginPage.clickLogin_button();
    }
}
