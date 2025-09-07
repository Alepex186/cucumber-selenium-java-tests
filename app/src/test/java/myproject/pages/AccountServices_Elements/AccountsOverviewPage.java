package myproject.pages.AccountServices_Elements;

import myproject.steps.TestContext;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import myproject.abs.abs_basics_funtions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.jsoup.Jsoup;


public class AccountsOverviewPage extends abs_basics_funtions{

    @FindBy(xpath = "//table[@id='accountTable']")
    WebElement accountTable;
    WebDriver driver;
//    List<WebElement> elementos1;
//    List<WebElement> elementos2;
    Element elementos1;
    Element elementos2;


    public AccountsOverviewPage(TestContext testContext){
        super("AccountsOverviewPage");
        this.driver=testContext.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public Element getTableData(){ //List<WebElement>

        WebElement tbody=accountTable.findElement(By.tagName("tbody"));

        super.waitForVisibilityOf(driver,tbody,10);
        super.waitPresenceOfNestedElementLocatedBy(driver,tbody,By.tagName("tr"),20);


        String tbodyHtml = Objects.requireNonNull(tbody.getAttribute("outerHTML"));
        Document doc = Jsoup.parse("<table>" + tbodyHtml + "</table>");
        Element tbodyy = doc.selectFirst("tbody");


        return tbodyy;
    }


    private double cleanMoney(String element){
        return Double.parseDouble(element.trim().replace("$",""));
    }

    public int searchElementID(Element element,String elemento_to_find) throws Exception {
        Elements trdocument=element.select("tr");

        Elements TdElements;
        for(int i=0;i<trdocument.size()-1;i++){
            TdElements= trdocument.get(i).select("td");
            for(int j=0;j<TdElements.size();j++){
                if(TdElements.get(j).text().equals(elemento_to_find)){
                    return i;
                };
            }
        }
        System.out.println("elemento a encontrar:  " + elemento_to_find);
        throw new Exception("ELEMENTO NO ENCONTRADO");
    }



    public void verifyTables(String fromtransferredAccountId, String newAccountId) throws Exception {
        if (this.elementos1==null || this.elementos2==null) {
            throw new AssertionError("NO HAZ DE DEFINIDO LOS ELEMENTOS DE LAS TABLAS");
        }

        Elements trdocument1=elementos1.select("tr");
        Elements trdocument2=elementos2.select("tr");


        System.out.println("trdocument1.size() :"+ trdocument1.size());
        System.out.println("trdocument2.size() :"+ trdocument2.size());

        Assertions.assertTrue(trdocument1.size() + 1 == trdocument2.size(),"LA TABLA NO INCREMENTÓ EN 1 FILA DESPUÉS DE LA ACCIÓN");

        System.out.println("fromtransferredAccountId : "+fromtransferredAccountId);
        System.out.println("newAccountId : "+newAccountId);

        int newAccountElementIndex=searchElementID(elementos2,newAccountId);
        System.out.println("newAccountElementIndex : " +newAccountElementIndex);
        int newAccountElementFromtransferredAccount=searchElementID(elementos2,fromtransferredAccountId);
        System.out.println("newAccountElementFromtransferredAccount : "+newAccountElementFromtransferredAccount);
        int LastAccountElementFromtransferredAccount=searchElementID(elementos1,fromtransferredAccountId);
        System.out.println("LastAccountElementFromtransferredAccount : "+LastAccountElementFromtransferredAccount);




        double ActuallyMoneyNewAccount=cleanMoney(trdocument2.get(newAccountElementIndex).select("td").get(1).text());

        double ActuallyMoneyFromtransferredAccount=cleanMoney(trdocument2.get(newAccountElementFromtransferredAccount).select("td").get(1).text());

        double BeforeMoneyFromtransferredAccount=cleanMoney(trdocument1.get(LastAccountElementFromtransferredAccount).select("td").get(1).text());


        Assertions.assertTrue(ActuallyMoneyNewAccount+ActuallyMoneyFromtransferredAccount == BeforeMoneyFromtransferredAccount,"El dinero acreditado no es valido");

    }


//    public void verifyTablesAmount(String fromtransferredAccountId, String toAccountId,double amountToVerify) throws Exception {
    public void verifyTablesAmount(String typeaccount,String AccountId,double amountToVerify) throws Exception {
        Elements trdocument1=elementos1.select("tr");
        Elements trdocument2=elementos2.select("tr");




        if(typeaccount.equals("origen")){
            System.out.println(typeaccount);
            System.out.println("fromtransferredAccountId : " + AccountId);
            int beforeFromAccount=searchElementID(elementos1,AccountId);
            int afterFromAccount=searchElementID(elementos2,AccountId);
            double beforeFromAccountMoney=cleanMoney(trdocument1.get(beforeFromAccount).select("td").get(1).text());
            double afterFromAccountMoney=cleanMoney(trdocument2.get(afterFromAccount).select("td").get(1).text());

            System.out.println("beforeFromAccountMoney: "+beforeFromAccountMoney);
            System.out.println("afterFromAccountMoney: "+afterFromAccountMoney);
            System.out.println("amountToVerify" +amountToVerify);
            System.out.println(beforeFromAccountMoney+amountToVerify);
            Assertions.assertTrue(afterFromAccountMoney==beforeFromAccountMoney+amountToVerify,"El dinero de origen  no es valido");


        }else {
            System.out.println(typeaccount);

            System.out.println("toAccount : " + AccountId);

            int beforeToAccount=searchElementID(elementos1,AccountId);
            int afterToAccount=searchElementID(elementos2,AccountId);

            double beforeToAccountMoney=cleanMoney(trdocument1.get(beforeToAccount).select("td").get(1).text());
            double afterToAccountMoney=cleanMoney(trdocument2.get(afterToAccount).select("td").get(1).text());


            System.out.println("beforeToAccountMoney: "+beforeToAccountMoney);
            System.out.println("afterToAccountMoney: "+afterToAccountMoney);
            System.out.println("amountToVerify" +amountToVerify);

            System.out.println(beforeToAccountMoney+"    "+afterToAccountMoney+"  "+amountToVerify);


            Assertions.assertTrue(beforeToAccountMoney==afterToAccountMoney+amountToVerify);

//            Assertions.assertEquals(beforeToAccountMoney, afterToAccountMoney + amountToVerify, 0.0001,
//                    "El dinero de destino no es válido");
        }


    }







    public Element getElementos1() {
        return elementos1;
    }

    public void setElementos1(Element elementos1) {
        this.elementos1 = elementos1;
    }

    public Element getElementos2() {
        return elementos2;
    }

    public void setElementos2(Element elementos2) {
        this.elementos2 = elementos2;
    }
}
