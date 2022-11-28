package PetstoreRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By userName = By.xpath("//input[@name='username']");
	By password = By.xpath("//input[@name='password']");
	 By loginbutton = By.xpath("//input[@name='signon']");
	//By home = By.xpath("");
	
	
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement loginbutton()
	{
		return driver.findElement(loginbutton);
		
	}
	
	
	
}
