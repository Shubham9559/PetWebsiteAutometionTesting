package PetstoreRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By userName = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	By repeatpass = By.xpath("//input[@name='repeatedPassword']");
	
	By fname = By.xpath("//input[@name='account.firstName']");
	By lname = By.xpath("//input[@name='account.lastName']");
	By email = By.xpath("//input[@name='account.email']");
	By phone = By.xpath("//input[@name='account.phone']");
	By add1 = By.xpath("//input[@name='account.address1']");
	By add2 = By.xpath("//input[@name='account.address2']");
	By city = By.xpath("//input[@name='account.city']");
	By state = By.xpath("//input[@name='account.state']");
	By zip = By.xpath("//input[@name='account.zip']");
	By country = By.xpath("//input[@name='account.country']");

	By save=By.xpath("//input[@name='newAccount']");
	//By signIn=By.xpath("//div[@id='MenuContent']"); 
	By home=By.xpath("//a[normalize-space()='Sign In']");
	
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	public WebElement repeatpass()
	{
		return driver.findElement(repeatpass);
	}
	public WebElement fname()
	{
		return driver.findElement(fname);
	}
	public WebElement lname()
	{
		return driver.findElement(lname);
	}
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	public WebElement add1()
	{
		return driver.findElement(add1);
	}
	public WebElement add2()
	{
		return driver.findElement(add2);
	}
	public WebElement city()
	{
		return driver.findElement(city);
	}
	public WebElement state()
	{
		return driver.findElement(state);
	}
	public WebElement zip()
	{
		return driver.findElement(zip);
	}
	public WebElement country()
	{
		return driver.findElement(country);
	}
	public WebElement save()
	{
		return driver.findElement(save);
	}
	public WebElement home()
	{
		return driver.findElement(home);
	}
	
}
