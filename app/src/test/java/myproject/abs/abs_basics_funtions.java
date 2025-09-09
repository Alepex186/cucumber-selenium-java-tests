package myproject.abs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;

public abstract class abs_basics_funtions{
    String current_page_name;
    File folder_screenshot=new File("screenshot");
    protected static final int TIMEOUT = 20;




    public abs_basics_funtions(String current_page_name){
        this.current_page_name=current_page_name;
    }



    protected void waitForClickableElement(WebDriver driver, WebElement element, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitForTextToBePresentInElementLocated(WebDriver driver,int duration,String text){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"),text));
    }
    protected void waitForVisibilityOf(WebDriver driver,WebElement element,int duration){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitPresenceOfNestedElementLocatedBy(WebDriver driver,WebElement element,By type,int duration){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element,type));
    }


    public boolean TakesScreenshot(WebDriver driver) throws Exception{
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File page_directory= new File(current_page_name);

        if(!page_directory.exists()){ page_directory.mkdir();}
        if(!this.folder_screenshot.exists()) { this.folder_screenshot.mkdir();}



        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        String time=LocalDateTime.now().format(formatter);


        try {
            FileUtils.copyFile(file, new File(this.folder_screenshot+"/"+current_page_name + "/" + time + ".png"));
        }
        catch (Exception e){
            throw new Exception("HA OCURRIDO UN ERROR A AL CREAR EL SCRENSHOT" + e);
        }
        return true;
    }

}
