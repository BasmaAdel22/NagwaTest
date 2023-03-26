package TestBase;

import Pages.HomePage;
import Pages.LessonPage;
import Pages.LessonWorksheetPage;
import Pages.SearchResultPage;
import Property.ReadFromPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class TestSet {
    private WebDriver driver;

    protected HomePage homepage;
    protected SearchResultPage searchresultpage;
    protected LessonPage lessonpage;
    protected LessonWorksheetPage lessonWorksheetPage;

    public String url;
    public String language;
    public String lessonName;


    @BeforeTest
    public void SetUp() throws IOException {

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options=new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        homepage=new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(ReadFromPropertyFile.get("url"));
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }

}
