import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortingPage extends AbstractPage {

    //определение локатора кнопки сортировки
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement az;

    //определение локатора кнопки сортировки  цены по убыванию
    @FindBy(xpath = "//select[@class='product_sort_container']//option[4]")
    private WebElement sortingAZ4;

    //определение локатора кнопки сортировки  цены по возрвстанию
    @FindBy(xpath = "//select[@class='product_sort_container']//option[3]")
    private WebElement sortingAZ3;

    //определение локатора кнопки сортировки по наименованию ZA
    @FindBy(xpath = "//select[@class='product_sort_container']//option[2]")
    private WebElement sortingAZ2;
    //определение локатора кнопки сортировки по наименованию AZ
    @FindBy(xpath = "//select[@class='product_sort_container']//option[1]")
    private WebElement sortingAZ1;

    public SortingPage(WebDriver driver) {
        super(driver);
    }

    //метод для перекючения кнопки сортировки
    public SortingPage sortingPage(){
        az.click();
        sortingAZ4.click();
        az.click();
        sortingAZ3.click();
        az.click();
        sortingAZ2.click();
        az.click();
        sortingAZ1.click();
        return this;
    }
}
