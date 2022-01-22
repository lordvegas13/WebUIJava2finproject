import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage{

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement catalogItem;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage catalogItem(){
        catalogItem.click();
        return this;
    }
}
