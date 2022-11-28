package petWebsite.petWebsite;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import PetstoreRepository.HomePage;
import PetstoreRepository.LoginPage;
import PetstoreRepository.RegisterPage;
import PetstoreRepository.FishCart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetstoreMain {

	static ExtentTest test;
	static ExtentReports report;

	@BeforeTest
	public static void startTest() {
		report = new ExtentReports(
				"C:\\Users\\SShukla\\Downloads\\assignment\\com.petwebsite\\target" + "\\ExtentReportResults.html");
		test = report.startTest("Pets");
	}

	@Test
	@Parameters({ "browser" })

	public void login(String browser) throws InterruptedException, IOException {
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();

		WebDriver driver = selectBrowser(browser);

		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://petstore.octoperf.com/actions/Account.action");
		Thread.sleep(3000);

		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.Register().click();
		
		//test.log(LogStatus.PASS, "Registration link clicked");
		WebElement elem=driver.findElement(By.xpath("//h3[normalize-space()='User Information']"));
		String s=elem.getText();
		if(s.equals("User Information")) {
			test.log(LogStatus.PASS, "Registration link clicked");
		}else {
			test.log(LogStatus.FAIL, "Registration link not clicked");
		}
		
		assertTrue(s.equals("User Information"),"Registration link not clicked");

		Properties prop = new Properties();// get the property
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SShukla\\Downloads\\assignment\\com.petwebsite\\data.properties");
		prop.load(fis);
		RegisterPage rp = new RegisterPage(driver);
		// rl.userName().clear();
		rp.userName().sendKeys(prop.getProperty("username"));
		rp.password().sendKeys(prop.getProperty("password"));
		rp.repeatpass().sendKeys(prop.getProperty("password"));
		rp.fname().sendKeys(prop.getProperty("fname"));
		rp.lname().sendKeys(prop.getProperty("lname"));
		rp.email().sendKeys(prop.getProperty("email"));
		rp.phone().sendKeys(prop.getProperty("phone"));
		rp.add1().sendKeys(prop.getProperty("add1"));
		rp.add2().sendKeys(prop.getProperty("add2"));
		rp.city().sendKeys(prop.getProperty("city"));
		rp.state().sendKeys(prop.getProperty("state"));
		rp.zip().sendKeys(prop.getProperty("zip"));
		rp.country().sendKeys(prop.getProperty("country"));
		System.out.println("Registered");

		takeScreenShot("PIC1", driver);

		Thread.sleep(3000);
		
		rp.save().click();
		rp.home().click();
		
		WebElement ele1 = driver.findElement(By.xpath("//p[normalize-space()='Please enter your username and password.']"));
		String s1 = ele1.getText();
		if(s1.equals("Please enter your username and password.")) {
			test.log(LogStatus.PASS, "Registration done");
		}else {
			test.log(LogStatus.FAIL, "Registration not Done");
		}
        
		assertTrue(s1.equals("Please enter your username and password."),"Registration not Done");
		
		Thread.sleep(3000);

		Properties prop1 = new Properties();// get the property
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\SShukla\\Downloads\\assignment\\com.petwebsite\\data.properties");
		prop1.load(fis1);
		LoginPage rl = new LoginPage(driver);
		rl.userName().clear();
		rl.userName().sendKeys(prop1.getProperty("username"));
		rl.password().clear();
		rl.password().sendKeys(prop1.getProperty("password"));
		rl.loginbutton().click();
		
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='WelcomeContent']"));
		String s2 = ele2.getText();
		if(s2.contains("Welcome")) {
			test.log(LogStatus.PASS, "Login Successfull");
		}else {
			test.log(LogStatus.FAIL, "Login Fail");
		}
		
		assertTrue(s2.contains("Welcome"),"Login Fail");

		takeScreenShot("PIC2", driver);

		Properties prop2 = new Properties();// get the property
		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\SShukla\\Downloads\\assignment\\com.petwebsite\\data.properties");
		prop2.load(fis2);
		FishCart fc = new FishCart(driver);
		fc.Fish().click();
		fc.ProdId().click();
		fc.Addcart().click();
		fc.Checkout().click();
		fc.Contnue().click();
		fc.Confirm().click();
		Thread.sleep(3000);
		
		WebElement ele3 = driver.findElement(By.xpath("//th[normalize-space()='Billing Address']"));
		String s3 = ele3.getText();
		if(s3.equals("Billing Address")) {
			test.log(LogStatus.PASS, "Added to Cart and Bill generated successfully");
		}else {
			test.log(LogStatus.PASS, "Added to cart Fail");
		}
		

		takeScreenShot("PIC3", driver);
	}

	public static void takeScreenShot(String fileName, WebDriver driver) {

		org.openqa.selenium.Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

		// getting the browser name
		String browserName = ((org.openqa.selenium.Capabilities) cap).getBrowserName();

		// removing all the space
		fileName = fileName.trim().replaceAll(" ", "");

		// attaching the screenshot taken time as well as browser name
		fileName = fileName + "_" + browserName + "_" + System.currentTimeMillis();

		System.out.println(fileName);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(SrcFile, new File("C://Scr//" + fileName + ".png"));
			System.out.println("Screenshot taken");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public static void takeScreenShot(String name, WebDriver driver) throws IOException {
		TakesScreenshot scr = (TakesScreenshot)driver;
		File FileSrc = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(FileSrc, new File("C:\\Scr"+System.currentTimeMillis()+name+".png"));
	} */

	public WebDriver selectBrowser(String browser) {
		WebDriver driver = null;

		if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		return driver;
	}

	@AfterTest
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}
