import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Constants {
    // Registration page constants
    public static String regpage = "הכל";
    public static By LOGGEDIN = By.id("il.co.mintapp.buyme:id/tab_title");
    public static By REGBTN = By.id("il.co.mintapp.buyme:id/skipButton");
    public static By TYPEREG = By.id("il.co.mintapp.buyme:id/googleButton");
    public static By ACCOUNT = By.id("com.google.android.gms:id/account_name");


    //------------------------------------------------------------------------------------
    // Home page constants
    public static String peletgift = "גיפט קארד למסעדות שף";
    public static By CATEGORY = By.id("il.co.mintapp.buyme:id/main_toolbar_title");
    public static By MONEY = By.id("il.co.mintapp.buyme:id/priceEditText");
    public static By BUYBTN = By.id("il.co.mintapp.buyme:id/purchaseButton");
    //------------------------------------------------------------------------------------
    // SendANDReceiver page constants
    public static By RECEIVER = By.id("il.co.mintapp.buyme:id/toEditText");
    public static By SENDER = By.id("il.co.mintapp.buyme:id/userFrom");
//  public static By EVENT = By.xpath("//android.widget.Button[@text='מהו סוג האירוע? נעזור לכם לכתוב ברכה']");
    public static By BLESS = By.id("il.co.mintapp.buyme:id/blessEditText");
    public static By SCROLL = By.id("il.co.mintapp.buyme:id/fabAlikeContainer");
    public static final By CONTINUEBTN = By.id("il.co.mintapp.buyme:id/goNextButton");

    //------------------------------------------------------------------------------------
    // SendScreen page constants
    public static final By CHECKBOX = By.id("il.co.mintapp.buyme:id/giftSendEmail");
//    public static final By MAIL = (MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
//                        +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/description\"))"));
    public static final By MAIL = By.xpath("//android.widget.EditText[contains(@resource-id,'description')]");
    public static By CONTINUEBTN1 = (MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                       +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))"));
//    public static By CONTINUEBTN1 = By.id("il.co.mintapp.buyme:id/goNextButton");
}





