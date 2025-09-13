package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.RequestLoanPage;

public class RequestLoanStep {

    TestContext testContext = Hooks.getThreadLocalContext().get();
    RequestLoanPage requestLoanPage = testContext.getRequestLoanPage();
    AccountServicesPage accountServicesPage = testContext.getAccountServicesPage();

    private final int EXCESSIVE_LOAN_AMOUNT = 30000;
    private final int MINIMAL_LOAN_AMOUNT = 50;
    private final int MINIMAL_DOWN_PAYMENT = 50;
    private final int EXCESSIVE_DOWN_PAYMENT  = 999999;

    private final String MESSAGE_DENIED = "We cannot grant a loan in that amount with your available funds.";
    private final String MESSAGE_APPROVED = "Congratulations, your loan has been approved.";
    private final String MESSAGE_DOWNPAYMENT = "You do not have sufficient funds for the given down payment.";

    @Given("el usuario se encuentra en el apartado Request Loan")
    public void elUsuarioSeEncuentraEnElApartadoRequestLoan() {
        this.accountServicesPage.ClickRequestLoan();
    }

    @When("el usuario ingresa un monto demasiado alto en Loan Amount")
    public void elUsuarioIngresaUnMontoDemasiadoAltoEnLoanAmount() {
        this.requestLoanPage.enterLoanAmount(Integer.toString(EXCESSIVE_LOAN_AMOUNT ));
    }

    @When("el usuario ingresa un monto pequeño en Loan Amount")
    public void elUsuarioIngresaUnMontoPequenioEnLoanAmount() {
        this.requestLoanPage.enterLoanAmount(Integer.toString(MINIMAL_LOAN_AMOUNT));
    }


    @And("el usuario ingresa un pago inicial válido")
    public void elUsuarioIngresaUnPagoInicialValido() {
        this.requestLoanPage.enterDownPaymentAmount(Integer.toString(MINIMAL_DOWN_PAYMENT));
    }

    @And("el usuario ingresa un pago inicial demasiado alto")
    public void elUsuarioIngresaUnPagoInicialDemasiadoAlto() {
        this.requestLoanPage.enterDownPaymentAmount(Integer.toString(EXCESSIVE_DOWN_PAYMENT ));
    }

    @And("el usuario selecciona una cuenta para descontar el Down Payment")
    public void elUsuarioSeleccionaUnaCuentaParaDescontarElDownPayment() {
        this.requestLoanPage.selectFromAccount();
    }

    @And("el usuario solicita el préstamo")
    public void elUsuarioSolicitaElPrestamo() {
        this.requestLoanPage.sendFormulary();
    }

    @Then("deberia aparecer el mensaje de fondos insuficientes para el pago inicial")
    public void deberiaAparecerElMensajeFondosInsuficientesParaPagoInicial() {
        this.requestLoanPage.verify(MESSAGE_DOWNPAYMENT);
    }

    @Then("deberia aparecer el mensaje de fondos insuficientes para el préstamo")
    public void deberiaAparecerElMensajeFondosInsuficientesParaPrestamo() {
        this.requestLoanPage.verify(MESSAGE_DENIED);
    }

    @Then("deberia aparecer el mensaje de préstamo aprobado")
    public void deberiaAparecerElMensajePrestamoAprobado() {
        this.requestLoanPage.verify(MESSAGE_APPROVED);
    }
}
