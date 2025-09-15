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



    @And("El usuario ha seleccionado una cuenta")
    public void usuarioSeleccionaCuenta() {
        findTransactionsPage.selectAnAccount();
    }


    @And("El usuario se encuentra en el apartado Find Transactions")
    public void usuarioEnFindTransactions() {
        accountServicesPage.ClickFindTransactions();
    }

    @When("El usuario ingresa la fecha a buscar en Find by Date")
    public void usuarioIngresaFechaFindByDate() {
        findTransactionsPage.findByDate("12-12-"+ (LocalDate.now().getYear()-1));
    }

    @And("El usuario hace clic en el botón FIND TRANSACTIONS del apartado Find by Date")
    public void usuarioClickFindTransactionsByDate() {
        findTransactionsPage.findByDateSendFormulary();
    }

    @Then("El usuario debería visualizar una tabla en Find Transactions con esa fecha")
    public void usuarioVeTablaFecha() {
        findTransactionsPage.verifyTable();
    }


    @When("El usuario ingresa las fechas a buscar en Find by Date Range")
    public void usuarioIngresaFechasFindByDateRange() {
        findTransactionsPage.findByDateRange("01-01-2000","01-01-2030");
    }

    @And("El usuario hace clic en el botón FIND TRANSACTIONS del apartado Find by Date Range")
    public void usuarioClickFindTransactionsByDateRange() {
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

