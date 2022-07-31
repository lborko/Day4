import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasketTest extends TestBase {


    @Test
    public void shouldAddProductToBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product");

        WebElement addToBasketBtn = driver.findElement(By.className("add-to-cart"));
        addToBasketBtn.click();

        WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn-primary")));
        proceedBtn.click();

        driver.findElement(By.cssSelector(".remove-from-cart")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));

        WebElement emptyCartLbl = driver.findElement(By.cssSelector(".no-items"));
        Assert.assertEquals(emptyCartLbl.getText(), "There are no more items in your cart");

    }




    /*
Otwórz stronę http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product
Kliknij w przycisk Add to cart
Poczekaj aż przycisk Proceed to checkout będzie klikalny (clickable = visible & enabled)
Kliknij przycisk Proceed to checkout
W tym momencie zostanie otworzona strona koszyka. Kliknij w niej na ikonkę kosza na śmieci aby usunąć produkt znajdujący się w korzyku.
Poczekaj, aż ze strony znikną wszystkie elementy, które mają selektor taki jak selektor kosza na śmieci
Sprawdź asercją czy został wyświetlony tekst
    here are no more items in your cart
     */
}
