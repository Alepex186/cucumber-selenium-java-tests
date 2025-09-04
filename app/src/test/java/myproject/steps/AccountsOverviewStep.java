package myproject.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.pages.AccountServicesPage;
import myproject.pages.AccountServices_Elements.AccountsOverviewPage;
import myproject.pages.AccountServices_Elements.OpenNewAccountPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

public class AccountsOverviewStep {

    AccountsOverviewPage accountsOverviewPage;
    AccountServicesPage accountServicesPage;
    OpenNewAccountPage openNewAccountPage;
    String FromtransferredAccountId;
    String NewAccountId;
    WebDriver driver;

    public AccountsOverviewStep(){
        this.driver=Hooks.getDriver();
        this.accountsOverviewPage=new AccountsOverviewPage(this.driver);
        this.accountServicesPage=new AccountServicesPage(this.driver);
        this.openNewAccountPage=new OpenNewAccountPage(this.driver);
    }

    @Given("El usuario esta en el apartado de Accounts Overview y visualiza la lista actual de cuentas")
    public void accountOverview(){
        accountServicesPage.ClickAccountsOverview();
//        WebElement table= accountsOverviewPage.getTableData();
//        accountsOverviewPage.setElementos1(Jsoup.parse(Objects.requireNonNull(table.getAttribute("outerHTML"))));
        WebElement tbody = accountsOverviewPage.getTableData();
        String tbodyHtml = Objects.requireNonNull(tbody.getAttribute("outerHTML"));

        Document doc = Jsoup.parse("<table>" + tbodyHtml + "</table>");

        // Seleccionamos el tbody real
        Element tbodyy = doc.selectFirst("tbody");
        //System.out.println(tbodyy);
        accountsOverviewPage.setElementos1(tbodyy);

    }

    @When("El usuario navega a Open New Account y crea una nueva cuenta")
    public void openNewAccount() throws Exception {
        this.accountServicesPage.ClickOpenNewAccount();
        //Thread.sleep(10000); // 2 segundos
        this.openNewAccountPage.SelectValueSelect(0);
        this.FromtransferredAccountId= this.openNewAccountPage.SelectValue_fromAccountId(0);
        this.openNewAccountPage.sendFormularyOpenNewAccount();
        this.NewAccountId=this.openNewAccountPage.verifyCreatedAccount();
    }

    @And("El usuario regresa a la pagina de Accounts Overview")
    public void accountOverviewReturn(){
        this.accountServicesPage.ClickAccountsOverview();
//        WebElement table= accountsOverviewPage.getTableData();
//        accountsOverviewPage.setElementos2(Jsoup.parse(Objects.requireNonNull(table.getAttribute("outerHTML"))));
        WebElement tbody = accountsOverviewPage.getTableData();
        String tbodyHtml = Objects.requireNonNull(tbody.getAttribute("outerHTML"));
        //System.out.println(tbodyHtml);

        Document doc = Jsoup.parse("<table>" + tbodyHtml + "</table>");

        // Seleccionamos el tbody real
        Element tbodyy = doc.selectFirst("tbody");
        //System.out.println(tbodyy);
        accountsOverviewPage.setElementos2(tbodyy);

    }

    @Then("deberia visualizarse una nueva cuenta en la lista, con el id visualizado al crear la cuenta")
    public void verify() throws Exception {
        accountsOverviewPage.verifyTables(FromtransferredAccountId,NewAccountId);
    }

}
