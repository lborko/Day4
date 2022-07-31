import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FormFluentPopTest extends TestBase {
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        File file = new File("src/main/resources/file.txt");
        pages.FormPage formPage = new pages.FormPage(driver);

        formPage.setFirstName("Lidia")
                .setLastName("Bo")
                .selectMaleGender()
                .setAge("18")
                .setEmail("test@test.pl")
                .selectYearsOfExperience(3)
                .selectManualTesterProfession()
                .selectContinent("europe")
                .selectSeleniumCommand("switch-commands")
                .uploadFile(file)
                .SendFormButton();
        Assert.assertEquals(formPage.getValidatorMessage(), "Form send with success");
    }
}
