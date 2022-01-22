import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;

public class AbstractTest {
    static WebDriver driver;
    public static AuthorPage authorPage;
    public static ProductPage productPage;
    public static OrderPage orderPage;
    public static SortingPage sortingPage;

    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(50));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        authorPage = new AuthorPage(getDriver());
        productPage = new ProductPage(getDriver());
        orderPage = new OrderPage(getDriver());
        sortingPage = new SortingPage(getDriver());


        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.saucedemo.com"), "Страница не доступна");
    }

    @AfterEach
    void exit2(){
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size()>0){
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }Assertions.assertTrue(true);
        driver.quit();
    }

    @AfterAll
    static void exit() {
        driver.quit();
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}