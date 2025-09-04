package myproject.steps;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class LoginStep {
    LoginPage loginPage;
    String usuario;
    String password;
    WebDriver driver;

    public LoginStep() throws Exception {
        //Hooks.crearUsuario();

        this.driver=Hooks.getDriver();
        this.loginPage=new LoginPage(this.driver);
//        ObjectMapper objectMapper=new ObjectMapper();
//        Map<String,Object> json=objectMapper.readValue(new File("src/test/resources/LoginJson.json"),Map.class);
//        this.usuario=(String) json.get("username");
//        this.password=(String) json.get("password");
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
        loginPage.sendKeysUsername_element("test123");
        loginPage.sendKeysPassword_element("123456");
        loginPage.clickLogin_button();
    }
}
