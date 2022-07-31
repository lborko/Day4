import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingBar extends TestBase {

    @Test
    public void shouldWaitForLoadingBar() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");

        // implicit wait nie powinien być nigdy w teście ale w klasie bazowej
        // tutaj jest tylko dla przykładu jego działania
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        WebElement progressBar = driver.findElement(By.xpath("//div[.='Complete!']"));

        Assert.assertEquals(progressBar.getText(), "Complete!");
    }
}
