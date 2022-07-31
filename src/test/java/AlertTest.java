import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends TestBase {

    @Test
    //  public void shouldFillFormWithSuccess(){
    //      driver.get("https://seleniumui.moderntester.pl/alerts.php");
    //    WebElement promptButton= driver.findElement(By.id("prompt-alert"));
    //   promptButton.click();
    //  driver.switchTo().alert().sendKeys("Harry Potter");
    //  driver.switchTo().alert().accept();
    //  WebElement promptLabel = driver.findElement(By.id("prompt-label"));
    // String actual =promptLabel.getText();
    //  Assert.assertEquals(actual,"Hello Harry Potter! How are you today?");

    public void shouldWaitForAlert() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");

        WebElement delayedBtn = driver.findElement(By.id("delayed-alert"));
        delayedBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

    }

}
