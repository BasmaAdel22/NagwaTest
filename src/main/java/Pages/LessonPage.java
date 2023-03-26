package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By lessonWorksheet = By.xpath("/html/body/div/div[1]/div/div/aside/div/ul/li[4]/div/a");

    public LessonWorksheetPage LessonWorksheet(){
        wait.until(ExpectedConditions.presenceOfElementLocated(lessonWorksheet));
        driver.findElement(lessonWorksheet).click();
        return new LessonWorksheetPage(driver);
    }


    public LessonPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

}
