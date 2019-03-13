import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jdk.internal.org.xml.sax.SAXException;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//--------The class contains the tests of pages, reports and webdriver definition --------------
public class APPS {

    private static AndroidDriver<MobileElement> driver;
    @Rule
    public TestName name = new TestName();
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    @BeforeClass
    public static void setUp() throws IOException, SAXException, ParserConfigurationException, org.xml.sax.SAXException {

        String patch = new String();
        patch = getData1("TAGE");
        //      ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C://Users//irina//Desktop//repmobile//extent1.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(patch);
        htmlReporter.setAppendExisting(true);
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Project", "Buyme mobile application");

        // add custom system info
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Tester", "Irina");
        // log results
        test.log(Status.INFO, "@Before class");

        ArrayList list = new ArrayList<String>();
        list = getData("TAGA", "TAGB", "TAGC", "TAGD");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//      capabilities.setCapability("appPackage", "il.co.mintapp.buyme");
//      capabilities.setCapability("appActivity", "il.co.mintapp.buyme.activities.common.SplashScreen");
        capabilities.setCapability((String) list.get(0), (String) list.get(1));
        capabilities.setCapability((String) list.get(2), (String) list.get(3));
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        //     capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static String getData1(String tagName) throws ParserConfigurationException, IOException, SAXException, org.xml.sax.SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(new File("C:\\Users\\irina\\Desktop\\miIrina\\mobile1.xml"));
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        doc.getElementsByTagName(tagName).item(0).getTextContent();
        return tagName;
    }

    public static ArrayList getData(String tag1, String tag2, String tag3, String tag4) throws ParserConfigurationException, IOException, SAXException, org.xml.sax.SAXException {
        ArrayList<String> temp = new ArrayList<String>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //   DocumentBuilder dBuilder = factory.newDocumentBuilder();;
        //  dBuilder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(new File("C:\\Users\\irina\\Desktop\\miIrina\\mobile.xml"));
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;

        temp.add(doc.getElementsByTagName(tag1).item(0).getTextContent());
        temp.add(doc.getElementsByTagName(tag2).item(0).getTextContent());
        temp.add(doc.getElementsByTagName(tag3).item(0).getTextContent());
        temp.add(doc.getElementsByTagName(tag4).item(0).getTextContent());
        return temp;
    }

    @Test //Registration
    public void test1 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            Registration.clickRegBTN(driver);
            pageOpened = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Registration  was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent01.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "RegistrationPage" + "The page is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent1.html")).build());
            }
        }
    }

    @Test //Verify Login Page is opened
    public void test2 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            Registration.verifyLogin(driver);
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Registration  was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent02.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "RegistrationPage" + "The page is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent2.html")).build());
            }
        }
    }

    @Test //Homescreen with gift category selection
    public void test3 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            HomeScreen.categoryGift(driver);
            pageOpened = true;
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Home screen was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent03.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Home screen" + "The page is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent3.html")).build());

            }
        }
    }

    @Test // Homescreen - Gift category screen is opened
    public void test4 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            HomeScreen.verifyScreenCategoryGift(driver);
            pageOpened = true;
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "gift category was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent04.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "gift category" + "The page is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent4.html")).build());

            }
        }
    }

    @Test //Homescreen with gift buisness selection
    public void test5 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            HomeScreen.buisnessGift(driver);
            pageOpened = true;
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "buisness category was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent05.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "buisness category" + "buisness category is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent5.html")).build());
            }
        }
    }

@Test
    public void test6 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            HomeScreen.giftBudget(driver);
            pageOpened = true;
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "gift price was not entered  " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent06.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "gift price" + "gift price was  entered");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent6.html")).build());
            }
        }
    }


    @Test //Sender and Receiver Screen -  entering data
    public void test7 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            SenderAndReceiverScreen.selectData(driver);
            pageOpened = true;
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Sender and Receiver data was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent07.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Sender and Receiver" + "Sender and Receiver screen is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent7.html")).build());

            }
        }
    }

    @Test //SendScreen -  entering data
    public void test8 () throws ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            SendScreen.selectSendData(driver);
            //       HomePage.verifyGift(driver);
            pageOpened = true;
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "SendScreen data was not found " + e.getMessage());
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent08.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "SendScreenr" + "SendScreen screen is opened successfully");
                test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//repmobile//extent8.html")).build());

            }
        }
    }

    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();
    }
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}