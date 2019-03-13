import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SenderAndReceiverScreen extends Constants {
    protected WebDriver driver;
    //--------Filling all data of sender and receiver--------------
    public static void selectData(AndroidDriver<MobileElement> driver) throws InterruptedException {
        driver.findElement(Constants.RECEIVER).clear();
        driver.findElement(Constants.RECEIVER).sendKeys("irina");
        driver.findElement(Constants.BLESS).clear();
        driver.findElement(Constants.BLESS).sendKeys("MAZAL TOV");
        driver.hideKeyboard();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(Constants.SCROLL).click();
        driver.findElement(Constants.SENDER).clear();
        driver.findElement(Constants.SENDER).sendKeys("max");
        driver.hideKeyboard();
        driver.findElement(Constants.CONTINUEBTN).click();
        Thread.sleep(5000);

    }
}

