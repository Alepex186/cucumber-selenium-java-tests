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

    @Given("El usuario se encuentra en el apartado Request Loan")
    public void usuarioEnRequestLoan() {
        this.accountServicesPage.ClickRequestLoan();
    }

    @When("El usuario ingresa un monto demasiado alto en Loan Amount")
    public void usuarioIngresaMontoAlto() {
        this.requestLoanPage.enterLoanAmount(Integer.toString(EXCESSIVE_LOAN_AMOUNT ));
    }

    @When("El usuario ingresa un monto pequeño en Loan Amount")
    public void usuarioIngresaMontoPequenio() {
        this.requestLoanPage.enterLoanAmount(Integer.toString(MINIMAL_LOAN_AMOUNT));
    }


    @And("El usuario ingresa un pago inicial válido")
    public void usuarioIngresaPagoValido() {
        this.requestLoanPage.enterDownPaymentAmount(Integer.toString(MINIMAL_DOWN_PAYMENT));
    }

    @And("El usuario ingresa un pago inicial demasiado alto")
    public void usuarioIngresaPagoAlto() {
        this.requestLoanPage.enterDownPaymentAmount(Integer.toString(EXCESSIVE_DOWN_PAYMENT ));
    }

    @And("El usuario selecciona una cuenta para descontar el Down Payment")
    public void usuarioSeleccionaCuentaDownPayment() {
        this.requestLoanPage.selectFromAccount();
    }

    @And("El usuario solicita el préstamo")
    public void usuarioSolicitaPrestamo() {
        this.requestLoanPage.sendFormulary();
    }

    @Then("El usuario debería visualizar el mensaje Fondos insuficientes para el pago inicial")
    public void usuarioVeMensajePagoInsuficiente() {
        this.requestLoanPage.verify(MESSAGE_DOWNPAYMENT);
    }

    @Then("El usuario debería visualizar el mensaje Fondos insuficientes para el préstamo")
    public void usuarioVeMensajePrestamoInsuficiente() {
        this.requestLoanPage.verify(MESSAGE_DENIED);
    }

    @Then("El usuario debería visualizar el mensaje Préstamo aprobado")
    public void usuarioVeMensajePrestamoAprobado() {
        this.requestLoanPage.verify(MESSAGE_APPROVED);
    }
}
