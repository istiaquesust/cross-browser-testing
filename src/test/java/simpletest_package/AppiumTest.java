package simpletest_package;



import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class AppiumTest {

public RemoteWebDriver driver = null;
String username = "istiaque.ahmed.08";
String accessKey = "OKNSEzH14asEVeEogGLO1dHRWTHj8wNzl6SDS0uM9mHUchuZjq";
	
	@BeforeTest
	public void setUp() throws Exception {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("deviceName", "Galaxy A8");
	  capabilities.setCapability("build", "First Test");
	  capabilities.setCapability("name", "Sample Test");
	  capabilities.setCapability("network", true); // To enable network logs
	  capabilities.setCapability("visual", true); // To enable step by step screenshot
	  capabilities.setCapability("video", true); // To enable video recording
	  capabilities.setCapability("console", true); // To capture console logs

	  try {
	    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
	  } catch (MalformedURLException e) {
	    System.out.println("Invalid grid URL");
	  }
	}

	@Test(enabled = true)
	public void testScript() throws Exception {
	  try {
	    driver.get("https://lambdatest.github.io/sample-todo-app/");
	    driver.findElement(By.name("li1")).click();
	    driver.findElement(By.name("li2")).click();
	    driver.findElement(By.id("sampletodotext")).clear();
	    driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
	    driver.findElement(By.id("addbutton")).click();
	    driver.quit();
	  } catch (Exception e) {
	    System.out.println(e.getMessage());
	  }
	}
}