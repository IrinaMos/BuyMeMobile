import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

    public class HomeScreen extends Constants {
        protected WebDriver driver;

        //--------Filling  data for group gift selection--------------
        public static void categoryGift(AndroidDriver<MobileElement> driver) throws InterruptedException {
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(Constants.CATEGORY));
//            TouchAction action = new TouchAction((PerformsTouchActions) driver);
//            PointOption pointtoclick = new PointOption();
//            pointtoclick.withCoordinates(0, 1224);
//            action.press(pointtoclick).perform();
            List<MobileElement> areaPoints = driver.findElements(By.className("android.widget.RelativeLayout"));
            areaPoints.get(0).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        public static void verifyScreenCategoryGift (AndroidDriver<MobileElement> driver) throws InterruptedException {
            System.out.println(driver.findElement(Constants.CATEGORY).getText());
            try{
                 assertEquals(Constants.peletgift, driver.findElement(Constants.CATEGORY).getText());
                 System.out.println("correct webpage");
            }
            catch(Throwable pageNavigationError){
                System.out.println("Didn't navigate to correct webpage");
            }
        }

        public static void buisnessGift(AndroidDriver<MobileElement> driver) {
            List<MobileElement> breakfastElements = driver.findElements(By.id("il.co.mintapp.buyme:id/businessName"));
            breakfastElements.get(1).click();
        }


        public static void giftBudget(AndroidDriver<MobileElement> driver) {
            driver.findElement(Constants.MONEY).sendKeys("100");
            driver.findElement(Constants.BUYBTN).click();
        }


    }

//
//            driver.findElement(Constants.SEARCHBTN).click();
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public static void verifyGift(WebDriver driver) {
//            driver.get(expectedUrl);
//            try{
//                Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
//                System.out.println("Navigated to correct webpage");
//            }
//            catch(Throwable pageNavigationError){
//                System.out.println("Didn't navigate to correct webpage");
//            }
//        }



