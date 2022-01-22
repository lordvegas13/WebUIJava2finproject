import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrderPage  extends AbstractPage {

    Actions actions = new Actions(getDriver());
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCart;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addToCart2;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement pressBasket;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement pressCheckout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement elementZip;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement pressContinue;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement pressFinish;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement pressBack;


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //метод добавления товара
    public OrderPage addToCart(){
        addToCart.click();
        addToCart2.click();
        return this;
    }

    //метод перехода в корзину
    public OrderPage pressBasket(){
        pressBasket.click();
        return this;
    }
    //метод подтверждения
    public OrderPage pressCheckout(){
        pressCheckout.click();
        return this;
    }
    //метод ввода имени input
    public OrderPage inputFirstName(String first){
        this.firstName.click();
        firstName.sendKeys(first);
        return this;
    }
    //метод ввода фамилии
    public OrderPage inputLastName(String last){
        lastName.click();
        lastName.sendKeys(last);
        return this;
    }
    //метод ввода индекса input  elementZip
    public OrderPage inputZip(String zip){
        elementZip.click();
        elementZip.sendKeys(zip);
        return this;
    }

    //метод продолжения
    public OrderPage pressContinue(){
        JavascriptExecutor jse = (JavascriptExecutor)driver; jse.executeScript("window.scrollBy(0,250)");
        pressContinue.click();
        return this;
    }

    //метод заканчивания заказа
    public OrderPage pressFinish(){
        pressFinish.click();
        return this;
    }

    //метод выхода домой
    public OrderPage pressBack(){
        pressBack.click();
        return this;
    }

}

