import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.function.BooleanSupplier;

public class PageTest extends AbstractTest {
    @Test
    @Epic("Механизм авторизации")
    @DisplayName("Авторизация")
    void testAuthorization() {
        authorPage.inputLogin("standard_user").inputPassword("secret_sauce").clickSubmit();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        AbstractTest.driver.manage().deleteAllCookies();
    }

    @Test
    @Epic("Механизм сортировки")
    @DisplayName("Сортировка")
    void testSorting(){
        authorPage.inputLogin("standard_user").inputPassword("secret_sauce").clickSubmit();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        sortingPage.sortingPage();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        AbstractTest.driver.manage().deleteAllCookies();
    }

    @Test
    @Epic("Механизм создания заказа")
    @DisplayName("Заказ")
    void testOrder(){
        authorPage.inputLogin("standard_user").inputPassword("secret_sauce").clickSubmit();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        orderPage.addToCart().pressBasket().pressCheckout().inputFirstName("Початок").inputLastName("Кукурузы").inputZip("8642-8642").pressContinue().pressFinish().pressBack();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        AbstractTest.driver.manage().deleteAllCookies();
    }
    @Test
    @Epic("Механизм открытия страницы товара каталога")
    @DisplayName("Товар")
    void testProduct(){
        authorPage.inputLogin("standard_user").inputPassword("secret_sauce").clickSubmit();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        productPage.catalogItem();
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory-item.html?id=4");
        AbstractTest.driver.manage().deleteAllCookies();
    }

}
