package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipcartProductListingPage 
{
WebDriver driver;
@FindBy(partialLinkText = "Acer One Intel Core i3 11th Gen 1115G4 - (8 GB/512 GB SSD/Windows 11 Home) AO 14 Z 8-415 Thin and Ligh...")
WebElement product;



public FlipcartProductListingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
}



public WebElement productSelected()
{
	return product;
}
}
