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

    @Given("El usuario abre la página de login")
    public void usuarioAbrePaginaLogin() throws Exception {
        loginPage.GetUrl();
    }

    @When("El usuario ingresa el nombre de usuario correcto {string}")
    public void usuarioIngresaUsuarioCorrecto(String usuario){
        loginPage.sendKeysUsername_element(usuario);
    }

    @And("El usuario ingresa la contraseña correcta {string}")
    public void usuarioIngresaContraseniaCorrecta(String contrasenia){
        loginPage.sendKeysPassword_element(contrasenia);
    }

    @And("El usuario hace clic en el botón Login")
    public void usuarioHaceClickLogin(){
        loginPage.clickLogin_button();
    }

    @Then("Deberia logearse y aparecer el texto {string}")
    public void verificarExitoso(String mensaje) throws Exception {
        loginPage.verificarExitoso(mensaje);
    }

    @When("El usuario ingresa un nombre de usuario incorrecto {string}")
    public void usuarioIngresaUsuarioIncorrecto(String usuario){
        loginPage.sendKeysUsername_element(usuario);
    }

    @Then("El usuario debería visualizar el mensaje {string}")
    public void usuarioVerificaLoginFallido(String mensaje){
        loginPage.verificarFallido(mensaje);
    }

    @And("El usuario ingresa una contraseña incorrecta {string}")
    public void usuarioIngresaContraseniaIncorrecta(String contrasenia){
        loginPage.sendKeysPassword_element(contrasenia);
    }


    @Given("El usuario ha iniciado sesión en el sistema con credenciales válidas")
    public void procesoCompletoLogin() throws Exception {
        loginPage.GetUrl();
        loginPage.sendKeysUsername_element("john");
        loginPage.sendKeysPassword_element("demo");
        loginPage.clickLogin_button();
    }
}
