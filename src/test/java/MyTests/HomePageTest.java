package MyTests;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Factory.DriverFactory;
import Pages.HomePage;
import configReader.ConfigPropReader;

public class HomePageTest {
	DriverFactory df;
	ConfigPropReader cp;
	Properties prop;
	WebDriver driver;
	HomePage homePage;

	@BeforeTest
	public void setup() throws IOException {
		cp = new ConfigPropReader();
		prop = cp.initLangProp("english");	//Can use Maven to remove this hardcoded value
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		homePage = new HomePage(driver);
	}

	@Test
	public void headerTest() {
		Assert.assertTrue(homePage.isHeaderExists(prop.getProperty("header")));

	}

	@Test
	public void contactFooterTest() {
		Assert.assertTrue(homePage.isContactExists(prop.getProperty("contact")));

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
