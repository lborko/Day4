import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumAutomationScript {
    @Test
    public void login() throws InterruptedException {
        //przygotowanie
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start.maximized");
//        inicjalizacja drivera
        WebDriver driver = new ChromeDriver(options);
        //otwieranie konkretnej strony
        driver.get("https://seleniumui.moderntester.pl/form.php");
        //zamykanie drivera

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Lidia");

        WebElement lastName = driver.findElement(By.xpath("//*[@id='inputLastName3']"));
        lastName.sendKeys("Bo");

        WebElement mail = driver.findElement(By.cssSelector("#inputEmail3"));

        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("test@test.com");

        List<WebElement> elements = driver.findElements(By.xpath("//input[@name='gridRadiosSex']"));

     for (WebElement element : elements) {
            element.click();
          //  Thread.sleep(1000);
        }

     //Age
        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.sendKeys("18");



        //year of experience
        WebElement yearOfExperience = driver.findElement(By.xpath("//input[@id='gridRadios1']"));
        yearOfExperience.click();

        //profession
        WebElement profession = driver.findElement(By.xpath("//input[@id='gridCheckAutomationTester']"));
        profession.click();

        //continents
        WebElement WebElementcontinents = driver.findElement(By.xpath("//select[@id='selectContinents']"));
        Select continents = new Select (WebElementcontinents);
        continents.selectByValue("europe");
//        Thread.sleep(5000);
        continents.selectByIndex(4);
//        Thread.sleep(5000);

        WebElement comands =driver.findElement(By.xpath("//select[@id='selectSeleniumCommands']"));
        Select comadsSelect =new Select(comands);
        for (int i=0; i<=4; i++){
            comadsSelect.selectByIndex(i);
        }

//        Thread.sleep(5000);

        WebElement browser = driver.findElement(By.xpath("//input[@id='chooseFile']"));
        browser.sendKeys("C:\\Calculator.txt");

//        Thread.sleep(5000);

        WebElement field = driver.findElement(By.xpath("//textarea[@id='additionalInformations']"));
        field.sendKeys("test");
//        Thread.sleep(1000);

        WebElement testFile = driver.findElement(By.xpath("//a[normalize-space()='Test File to Download']"));
        testFile.click();
//        Thread.sleep(1000);

        WebElement sendSign = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        sendSign.click();
//Co można zrobić, aby poczekać na komunikat potwierdzenia i dopiero dalej?
//        Thread.sleep(1000);









//        WebElement sex = driver.findElement(By.xpath("//*[@id='gridRadiosFemale']"));
//        sex.click();


        Thread.sleep(5000);
        firstName.clear();

//Form send with success

        String expextMessage="Form send with success";
        WebElement confirmationMessage =  driver.findElement(By.xpath("//div[@id='validator-message']"));
        String acctual=confirmationMessage.getText();
        System.out.println("formularz zosta wyslany  " + acctual);
        assertEquals(expextMessage,acctual);

        driver.quit();
    }
}
