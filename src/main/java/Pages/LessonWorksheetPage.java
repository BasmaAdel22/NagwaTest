package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LessonWorksheetPage {

    private WebDriver driver;

    public void clickLessonWorkSheet(){
        List<WebElement> elements = driver.findElements(By.className("instance"));
        int numberOfQuestions = elements.size();
        System.out.println("Total Number of Questions : " + numberOfQuestions);
    }

    public LessonWorksheetPage(WebDriver driver){
        this.driver=driver;
    }
}
