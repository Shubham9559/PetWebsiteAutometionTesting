package PetstoreRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	By Register=By.xpath("//a[normalize-space()='Register Now!']");
	
	public WebElement Register()
	{
		return driver.findElement(Register);
	}

}
