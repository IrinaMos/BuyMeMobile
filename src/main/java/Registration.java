import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class Registration extends Constants {
    protected WebDriver driver;
    //-------SignUP function---------------------------------------------------
    public static void clickRegBTN(WebDriver driver) {
        driver.findElement(Constants.REGBTN).click();
        driver.findElement(Constants.TYPEREG).click();
        driver.findElement(Constants.ACCOUNT).click();


    }
    //-----------VerifyLoadPage after registration----------------------
    public static void verifyLogin(AndroidDriver<MobileElement> driver) {
        System.out.println(driver.findElement(Constants.LOGGEDIN).getText());
        assertEquals(Constants.regpage, driver.findElement(Constants.LOGGEDIN).getText());
    }
}
