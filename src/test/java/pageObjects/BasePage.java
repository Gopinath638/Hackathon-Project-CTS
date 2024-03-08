package pageObjects;

/*1. Search Doctors (any one speciality like Dentist, Cardiologist, etc) 
for any City (like Chennai, Bangalore, Pune, etc). Apply filters 
for Patient Stories, Experience, Fees, Availability and any one Sorting; 
Fetch & display the first 5 Doctor details
2. Go to "Surgeries". Extract & store all the surgeries in a List & display them in console
output.
3. Under "For Corporate -> Health and Wellness Plan", fill the form with invalid email id &
valid details for other fields, validate if "Taking a demo" button is disabled.
Print the observation in console output. Then provide email in valid format & 
click the button and validate "Thank You" message is displayed*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
