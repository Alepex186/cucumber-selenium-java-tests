package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.FindTransactionsPage;

import java.time.LocalDate;

public class FindTransactionsStep {
    TestContext testContext=Hooks.getThreadLocalContext().get();
    AccountServicesPage accountServicesPage=testContext.getAccountServicesPage();
    FindTransactionsPage findTransactionsPage=testContext.getFindTransactionsPage();


    @Given("El usuario esta en el apartado de Find Transactions")
    public void elUsuarioEstaEnElApartadoDeFindTransactions(){
        accountServicesPage.ClickFindTransactions();
    }

    @When("El usuario ingresa la fecha a buscar en Find by Date")
    public void elUsuarioIngresaLaFechaABuscarEnFindByDate(){
        findTransactionsPage.findByDate("12-12-"+ (LocalDate.now().getYear()-1));
    }

    @And("El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Date")
    public void elUsuarioHaceClickEnFINDSTRANSACTIONSDelApartadoFindByDate(){
        findTransactionsPage.findByDateSendFormulary();
    }

    @Then("Deberia aparecer una tabla con las transacciones de esa fecha")
    public void deberiaAparecerUnaTablaConLasTransaccionesDeEsaFecha(){
        findTransactionsPage.verifyTable();
    }


    @When("El usuario ingresa las fechas a buscar en Find by Date Range")
    public void elUsuarioIngresaLasFechasABuscarEnFindByDateRange(){
        findTransactionsPage.findByDateRange("01-01-2000","01-01-2030");
    }

    @And("El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Date Range")
    public void elUsuarioHaceClickEnFINDSTRANSACTIONSDelApartadoFindByDateRange(){
        findTransactionsPage.findByDateRangeSendFormulary();
    }

    @When("El usuario ingresa el monto a buscar en Find by Amount")
    public void elUsuarioIngresaElMontoABuscarEnFindByAmount(){
        findTransactionsPage.findByAmount("100");

    }

    @And("El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Amount")
    public void elUsuarioHaceClickEnFINDSTRANSACTIONSDelApartadoFindByAmount(){
        findTransactionsPage.findByAmountSendFormulary();
    }
}

