package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utils.ElementUtils;

public class HomePage {
	private WebDriver driver;
	private ElementUtils elementutil;

	public HomePage(WebDriver driver) { // Circulate the same driver
		this.driver = driver; // maintain the single driver
		elementutil = new ElementUtils(driver);
	}

	private WebElement getHeaderElement(String headerValue) {
		String headerXpathValue = "//a[contains(text(),'" + headerValue + "')]";
		return elementutil.getElement("xpath", headerXpathValue);
	}

	public boolean isHeaderExists(String headerValue) {
		String header = getHeaderElement(headerValue).getText();
		System.out.println(header);
		return getHeaderElement(headerValue).isDisplayed();

	}
	
	private WebElement getContactElement(String contactValue) {
		String contactXpathValue = "//a[contains(text(),'" + contactValue + "')]";
		return elementutil.getElement("xpath", contactXpathValue);
	}

	public boolean isContactExists(String contactValue) {
		String contact = getContactElement(contactValue).getText();
		System.out.println(contact);
		return getContactElement(contactValue).isDisplayed();

	}

}
