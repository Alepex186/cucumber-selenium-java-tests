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

    @Given("El usuario se encuentra en el apartado Update Contact Info")
    public void usuarioEnUpdateContactInfo() {
        accountServicesPage.ClickUpdateContactInfo();
        updateProfilePage.setSnapshot1(updateProfilePage.TakeDataSnapshot());
    }

    @When("El usuario completa el formulario con sus nuevos datos")
    public void usuarioCompletaFormulario() {
        updateProfilePage.UpdateData();
    }

    @And("El usuario hace click en el boton UPDATE PROFILE")
    public void elUsuarioHaceClickEnElBotonUPDATEPROFILE(){
        updateProfilePage.SendFormulary();
    }

    @Then("El usuario debería visualizar el mensaje Profile Updated")
    public void usuarioVeMensajeActualizado() {
        updateProfilePage.verifyMessage();
    }

    @And("Al regresar al apartado Update Contact Info, el usuario debería visualizar sus datos actualizados")
    public void usuarioVeDatosActualizados() {
        accountServicesPage.ClickUpdateContactInfo();
        updateProfilePage.setSnapshot2(updateProfilePage.TakeDataSnapshot());
        updateProfilePage.verifySnapshots();
    }
}
