package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Utilities.readandwritedata;
import pageObjects.Surgeries;
import testBase.BaseClass;

public class TC02_Surgeries extends BaseClass {
	String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
	String sheetName="ListofSurgeries";
	@Test(priority=1,groups= {"regression"})
	public void T001_goToSurgery() throws IOException {
		sur=new Surgeries(driver);
		sur.clickSurgery();
	}
	@Test(priority=2,groups= {"sanity"})
	public void T002_validate() {
		sur.validateSurgeryPage();
	}
	@Test(priority=3,groups= {"sanity"})
	public void T003_ScrollDown() {
		sur.scrollDown();
	}
	@Test(priority=4,groups= {"regression"})
	public void T004_SurgeryList() throws IOException {
		//sur.listOfSurgeries1();
		List<String> surgeryList=sur.listOfSurgeries();
		readandwritedata.writeSurgery(surgeryList, excelFilePath,sheetName);
	}
	@Test(priority=5,groups= {"sanity"})
	public void T005_ScrollUp() {
		
		sur.scrollup();
	}

}
