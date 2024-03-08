package testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.Corporates;
import testBase.BaseClass;

public class TC03_WellNess extends BaseClass {
	String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
	String sheetName="Details";
	@Test(priority=1,groups= {"regression"})
	public void T001_goToCorporates() throws InterruptedException, IOException, HeadlessException, AWTException {
		
		corporate=new Corporates(driver);
		corporate.selectCorporate();
		corporate.selectHealth();
	}
	@Test(priority=2,groups= {"sanity"})
	public void T002_validateCorporate() {
		
		corporate.validateCorporatePage();
	}
	@Test(priority=3,groups= {"regression"})
	public void T003_sendDetails() throws InterruptedException, IOException {
		//corporate.enterDetails(excelFilePath,sheetName);
		corporate.enterDetailsinvalid(excelFilePath, sheetName);
		corporate.demobutton();
		corporate.enterDetailsvalid(excelFilePath, sheetName);
		corporate.demobutton();
		
	}
	@Test(priority=4,groups= {"regression"})
	public void T004_VerifyMsg() throws InterruptedException {
		corporate.textPrint();
		corporate.validateThankYou();
	}
	@Test(priority=5,groups= {"sanity"})
	public void T005_MsgScreenshot() throws HeadlessException, IOException, AWTException {
		 corporate.screenshot();
	}

}
