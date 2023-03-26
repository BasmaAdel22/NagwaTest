package TestSenarios;

import Pages.HomePage;
import Pages.LessonPage;
import Pages.SearchResultPage;
import Property.ReadFromPropertyFile;
import TestBase.TestSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestCases extends TestSet {

    private WebDriver driver;

    @Test (priority = 1)
    public void chooseLanguage() throws Exception {
        homepage.dropLanguage(ReadFromPropertyFile.get("language"));
    }

    @Test (priority = 2)
    public void searchLesson() throws Exception {
        homepage.SearchIcon();
        homepage.SearchInput(ReadFromPropertyFile.get("lessonName"));
        searchresultpage =homepage.ClickSearchBtn();
    }
    @Test (priority = 3)
    public void chooseSecondLesson(){
        lessonpage= searchresultpage.ChooseLesson();
        lessonWorksheetPage = lessonpage.LessonWorksheet();

    }

    @Test (priority = 4)
    public void clickLessonWorksheet(){
        lessonWorksheetPage.clickLessonWorkSheet();
    }

}
