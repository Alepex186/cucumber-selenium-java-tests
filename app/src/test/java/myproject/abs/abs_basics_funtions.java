package myproject.abs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;

public abstract class abs_basics_funtions{
    String current_page_name;
    File folder_screenshot=new File("screenshot");


    public abs_basics_funtions(String current_page_name){
        this.current_page_name=current_page_name;
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
