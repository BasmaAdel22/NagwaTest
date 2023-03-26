package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By getSecondLesson= By.xpath("(//div[contains(@class,'right')])[2]/a");

    public LessonPage ChooseLesson(){
        wait.until(ExpectedConditions.presenceOfElementLocated(getSecondLesson));
        driver.findElement(getSecondLesson).click();
        return new LessonPage(driver);
    }


    public SearchResultPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

}
