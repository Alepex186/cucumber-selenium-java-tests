package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.UpdateProfilePage;
import org.junit.jupiter.api.Tags;

public class UpdateProfileStep {

    TestContext testContext=Hooks.getThreadLocalContext().get();

    UpdateProfilePage updateProfilePage=testContext.getUpdateProfilePage();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();

    @Given("El usuario esta en el apartado de Update Contact Info")
    public void elUsuarioEstaEnElApartadoDeUpdateContactInfo(){
        accountServicesPage.ClickUpdateContactInfo();
        updateProfilePage.setSnapshot1(updateProfilePage.TakeDataSnapshot());
    }

    @When("El usuario actualiza el formulario con sus nuevos datos")
    public void elUsuarioActualizaElFormularioConSusNuevosDatos(){
        updateProfilePage.UpdateData();
    }

    @And("El usuario hace click en el boton UPDATE PROFILE")
    public void elUsuarioHaceClickEnElBotonUPDATEPROFILE(){
        updateProfilePage.SendFormulary();
    }

    @Then("Deberia aparecer el mensaje Profile Updated")
    public void deberiaAparecerElMensajeProfileUpdated(){
        updateProfilePage.verifyMessage();
    }

    @And("Al regresar a el apartado de Update Contact Info, deberia ver sus datos actualizados")
    public void alRegresarAElApartadoDeUpdateContactInfoDeberiaVerSusDatosActualizados(){
        accountServicesPage.ClickUpdateContactInfo();
        updateProfilePage.setSnapshot2(updateProfilePage.TakeDataSnapshot());
        updateProfilePage.verifySnapshots();
    }
}
