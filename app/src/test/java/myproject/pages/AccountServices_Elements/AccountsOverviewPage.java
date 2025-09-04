package myproject.pages.AccountServices_Elements;

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
import java.time.Duration;
import java.util.List;

import org.jsoup.Jsoup;


public class AccountsOverviewPage extends abs_basics_funtions{

    @FindBy(xpath = "//table[@id='accountTable']")
    WebElement accountTable;
    WebDriver driver;
//    List<WebElement> elementos1;
//    List<WebElement> elementos2;
    Element elementos1;
    Element elementos2;


    public AccountsOverviewPage(WebDriver driver){
        super("AccountsOverviewPage");
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    public WebElement getTableData(){ //List<WebElement>
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement tbody=wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(accountTable,By.tagName("tbody")));
        //WebElement tbody=accountTable.findElement(By.tagName("tbody"));
        return tbody;
    }


    private double cleanMoney(String element){
        return Double.parseDouble(element.trim().replace("$",""));
    }

    public int searchElementID(Element element,String elemento_to_find,boolean silence) throws Exception {
        Elements trdocument=element.select("tr");


        Elements TdElements;
        for(int i=0;i<trdocument.size()-1;i++){
            TdElements= trdocument.get(i).select("td");
            for(int j=0;j<TdElements.size();j++){
                if(!silence){
                    System.out.println(TdElements.get(j).text());
                }
                if(TdElements.get(j).text().equals(elemento_to_find)){
                    return i;
                };
            }
        }
        System.out.println("elemento a encontrar:  " + elemento_to_find);
        throw new Exception("ELEMENTO NO ENCONTRADO");
    }





//        List<WebElement> TdElements;
//        for(int i=0;i<element.size()-1;i++){
//            TdElements= element.get(i).findElements(By.tagName("td"));
//            for(int j=0;j<TdElements.size();j++){
//                if(!silence){
//                    System.out.println(TdElements.get(j).getText());
//                }
//                if(TdElements.get(j).getText().equals(elemento_to_find)){
//                    return i;
//                };
//            }
//        }
//        System.out.println("elemento a encontrar:  " + elemento_to_find);
//        throw new Exception("ELEMENTO NO ENCONTRADO");
//    }


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

        int newAccountElementIndex=searchElementID(elementos2,newAccountId,true);
        System.out.println("newAccountElementIndex : " +newAccountElementIndex);
        int newAccountElementFromtransferredAccount=searchElementID(elementos2,fromtransferredAccountId,false);
        System.out.println("newAccountElementFromtransferredAccount : "+newAccountElementFromtransferredAccount);
        int LastAccountElementFromtransferredAccount=searchElementID(elementos1,fromtransferredAccountId,false);
        System.out.println("LastAccountElementFromtransferredAccount : "+LastAccountElementFromtransferredAccount);




        double ActuallyMoneyNewAccount=cleanMoney(trdocument2.get(newAccountElementIndex).select("td").get(1).text());
        //double ActuallyMoneyNewAccount=cleanMoney(elementos2.get(newAccountElementIndex).findElements(By.tagName("td")).get(1).getText());

        double ActuallyMoneyFromtransferredAccount=cleanMoney(trdocument2.get(newAccountElementFromtransferredAccount).select("td").get(1).text());
        //double ActuallyMoneyFromtransferredAccount=cleanMoney(elementos2.get(newAccountElementFromtransferredAccount).findElements(By.tagName("td")).get(1).getText());

        double BeforeMoneyFromtransferredAccount=cleanMoney(trdocument1.get(LastAccountElementFromtransferredAccount).select("td").get(1).text());
        //double BeforeMoneyFromtransferredAccount=cleanMoney(elementos1.get(LastAccountElementFromtransferredAccount).findElements(By.tagName("td")).get(1).getText());


        Assertions.assertTrue(ActuallyMoneyNewAccount+ActuallyMoneyFromtransferredAccount == BeforeMoneyFromtransferredAccount,"El dinero acreditado no es valido");

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
