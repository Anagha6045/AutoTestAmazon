package AutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands 
{
public WebDriver driver;
public WebDriver browserIntialization(String browserName) throws Exception
{
	if (browserName.equalsIgnoreCase("Chrome"))
			{
		driver = new ChromeDriver();
		
			}
	else if(browserName.equalsIgnoreCase("Edge"))
	{
		driver = new EdgeDriver();
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		driver = new FirefoxDriver();
	}
	else
	{
		throw new Exception("Invalid Name Exception");
	}
	return driver;
}

}
