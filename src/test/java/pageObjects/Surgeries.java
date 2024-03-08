package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Surgeries extends BasePage {

	public Surgeries(WebDriver driver) {
		super(driver);
	}
	static String file=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata.xlsx";
	List<String> surgeryList=new ArrayList<>();
	//click Surgeries
	@FindBy(xpath="(//div[@class='product-tab__title'])[5]")
	WebElement surgery;
	//scroll
	@FindBy(xpath="//h1[@data-qa-id='surgical-solution-sub-header']")
	WebElement navigate; 
	//surgeriesList
	@FindBy(xpath="//div[@class='flex flex-wrap gap-y-44px pb-40px SurgicalSolutions-module_surgeriesList__1gl-I']/div")
	List<WebElement> popularSurgery;

	JavascriptExecutor js= (JavascriptExecutor) driver;

	//Action Methods
	public void clickSurgery() {
		surgery.click();
	}
	public void validateSurgeryPage(){
		String surgeriesPage = driver.getTitle();
		System.out.println("Title of the diagnostic page is: " + surgeriesPage);
		String title1 = "Practo Care Surgeries | End to end care from top surgeons in your city";
		Assert.assertEquals(surgeriesPage, title1, "User navigated to correct page");
		System.out.println("User navigated to correct page");
	}
	public void scrollDown() {
		js.executeScript("arguments[0].scrollIntoView();", navigate);
	}
	public List<String> listOfSurgeries() {
		for (WebElement ele :popularSurgery ) {
			String data = ele.getText();
			surgeryList.add(data);
		}
		for(int i=0;i<surgeryList.size();i++) {
			System.out.println((i+1)+". "+surgeryList.get(i));
		}
		System.out.println("**************************************************");
		return surgeryList;
	}

	public void scrollup(){
		JavascriptExecutor os=(JavascriptExecutor) driver;
		os.executeScript("window.scrollBy(0,-350)");
	}


}