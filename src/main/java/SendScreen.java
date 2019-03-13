import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

public class SendScreen extends Constants {
    protected WebDriver driver;

    //--------Select type of send and send--------------
    public static void selectSendData(AndroidDriver<MobileElement> driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            MobileElement element = driver.findElement(Constants.CHECKBOX).findElement(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
            element.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
//                MobileElement element1 = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
//                        +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/description\"))"));
                MobileElement element1 = driver.findElement(Constants.MAIL);
                element1.click();
                element1.sendKeys("55@gg.com");
                driver.hideKeyboard();
                driver.findElement(Constants.CONTINUEBTN1).click();
            }
           catch (Exception e) {
                System.out.println("Exception occurred");
           }
    }
}

//            List<MobileElement>  oCheckBox = driver.findElements(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
//            int iSize = oCheckBox.size();
//            for(int i=0; i < iSize ; i++ ){
//                boolean sValue = oCheckBox.get(i).equals("במייל");
//            if (sValue== true)
//             oCheckBox.get(i).click();
//             else
//                 continue;
//                }
//            }
//            Thread.sleep(5000);
//            driver.findElement(Constants.SUBMITFORM).sendKeys(Keys.ENTER);
