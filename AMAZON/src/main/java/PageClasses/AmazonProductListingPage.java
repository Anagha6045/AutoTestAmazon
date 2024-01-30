package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AmazonProductListingPage 
{
WebDriver driver;
By product=By.xpath("//span[text()='iPhone 15 Pro Max (256 GB) - Blue Titanium']");







public AmazonProductListingPage(WebDriver driver) 
{
	// TODO Auto-generated constructor stub
	this.driver=driver;
}







public void clickOnProduct()
{
driver.findElement(product).click();

}
public void scrollTillProduct()
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", "");
}
}
