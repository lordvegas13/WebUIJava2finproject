import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorPage extends AbstractPage {
    //определение локатора поля ввода логина
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement loginField;

    //определение локатора поля ввода пароля
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    //определение локатора кнопки входа в аккаунт
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement submit;

    public AuthorPage(WebDriver driver) {
        super(driver);
    }

    // "метод для ввода логина"
    public AuthorPage inputLogin(String login) {
        this.loginField.sendKeys(login);
        return this;
    }

    // " метод для ввода пароля"
    public AuthorPage inputPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
    }

    // "метод для осуществления нажатия кнопки входа в аккаунт"
    public AuthorPage clickSubmit() {
        submit.click();
        return this;
    }

}

