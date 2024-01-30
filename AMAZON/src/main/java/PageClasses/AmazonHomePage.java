package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage 
{
	WebDriver driver;
	By searchbox = By.id("twotabsearchtextbox");
	
	
	
	public AmazonHomePage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public WebElement searchBox()
	{
		return(driver.findElement(searchbox));
	}

}
