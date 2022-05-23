//This is maven project

package simpletest_package; //<your package name>

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestNGTodo2 {

  public RemoteWebDriver driver = null;
  String username = "istiaque.ahmed.08";
  String accessKey = "OKNSEzH14asEVeEogGLO1dHRWTHj8wNzl6SDS0uM9mHUchuZjq";
	
	@BeforeTest
	@Parameters({"browserName", "version", "platform", "resolution", "build", "name", "network", "visual", "video", "console"})
	public void setUp(String browserName, String version, String platform, String resolution, String build, String name, String network, String visual, String video, String console) throws Exception {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("browserName", browserName);
	  capabilities.setCapability("version", version);
	  capabilities.setCapability("platform", platform);
	  capabilities.setCapability("resolution", resolution);
	  capabilities.setCapability("build", build);
	  capabilities.setCapability("name", name);
	  capabilities.setCapability("network", network); // To enable network logs
	  capabilities.setCapability("visual", visual); // To enable step by step screenshot
	  capabilities.setCapability("video", video); // To enable video recording
	  capabilities.setCapability("console", console); // To capture console logs

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