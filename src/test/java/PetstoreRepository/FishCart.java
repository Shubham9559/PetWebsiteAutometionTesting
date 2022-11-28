package PetstoreRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FishCart {
WebDriver driver;
	
	public FishCart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Fish = By.xpath("//img[@src='../images/fish_icon.gif']"); 
	By ProdId=By.xpath("//a[normalize-space()='FI-SW-01']");
	By Addcart=By.xpath("//tbody/tr[2]/td[5]/a[1]");  
	By Checkout=By.xpath("//a[normalize-space()='Proceed to Checkout']");
    By Contnue=By.xpath("//input[@name='newOrder']");	
    By Confirm=By.xpath("//a[normalize-space()='Confirm']");
	
	public WebElement Fish()
	{
		return driver.findElement(Fish);
	}
	
	public WebElement ProdId()
	{
		return driver.findElement(ProdId);
	}
	
	public WebElement Addcart()
	{
		return driver.findElement(Addcart);
	}
	
	public WebElement Checkout()
	{
		return driver.findElement(Checkout);
	}
	
	public WebElement Contnue()
	{
		return driver.findElement(Contnue);
	}
	
	public WebElement Confirm()
	{
		return driver.findElement(Confirm);
	}
	
	
	
}
