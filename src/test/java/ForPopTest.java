import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class ForPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        File file = new File("src/main/resources/file.txt");
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Lidia");
        formPage.setLastName("Bo");
        formPage.selectMaleGender();
        formPage.setAge("18");
        formPage.setEmail("test@test.pl");
        formPage.selectYearsOfExperience(3);
        formPage.selectManualTesterProfession();
        formPage.selectContinent("europe");
        formPage.selectSeleniumCommand("switch-commands");
        formPage.uploadFile(file);
        formPage.SendFormButton();
        Assert.assertEquals(formPage.getValidatorMessage(), "Form send with success");
    }
}

