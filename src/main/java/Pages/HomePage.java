package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By languageDropDown = By.xpath("/html/body/header/div[1]/div/div[2]/ul/li[1]");

    private By searchIcon = By.xpath("/html/body/header/div[1]/div/div[3]/button");

    private By searchInput = By.id("txt_search_query");

    private By clickSearchIcon = By.id("btn_global_search");

    public void dropLanguage(String language) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(languageDropDown));

        driver.findElement(languageDropDown).click();

        List<WebElement> filteredLanguagesList = driver.findElement(languageDropDown)
                .findElements(By.tagName("li")).stream().filter(
                        new Predicate<WebElement>() {
                            @Override
                            public boolean test(WebElement webElement) {
                                return webElement.getText().contains(language);
                            }
                        }
                ).collect(Collectors.toList());

        if (filteredLanguagesList.isEmpty())
            throw new Exception("language not found");

        filteredLanguagesList.stream().findFirst().get().click();
    }

    public void SearchIcon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(searchIcon));
        driver.findElement(searchIcon).click();
    }

    public void SearchInput(String lessonName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));
        driver.findElement(searchInput).sendKeys(lessonName);
    }

    public SearchResultPage ClickSearchBtn() {
        wait.until(ExpectedConditions.presenceOfElementLocated(clickSearchIcon));
        driver.findElement(clickSearchIcon).click();
        return new SearchResultPage(driver);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


}
