package testCases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.List;

import org.testng.TestNGException;
import org.testng.annotations.Test;

import Utilities.readandwritedata;
import Utilities.ExcelUtils;
import testBase.BaseClass;
import pageObjects.Corporates;
import pageObjects.Doctors;
import pageObjects.Surgeries;

public class TC_FindingHospital extends BaseClass{

	//String sheetName1="Details";
	String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
	String sheetName="DoctorsDetails";
	String sheetName1="ListofSurgeries";
	String sheetName2="Details";

	@Test(priority=1)
	public void T001_homepage() throws InterruptedException, IOException {

		logger.info("*******Starting the TC001 TestCases********" );

		doctor=new Doctors(driver);

		doctor.ValidateHomepage();
		doctor.clickFindDoctors();
		doctor.City(excelFilePath,sheetName2);
		doctor.searchDoctor();
		doctor.selectingGender();
		doctor.selectingPatientStories();
		doctor.selectDoctorexp();
		doctor.selectFilter();
		doctor.selectFilterAgain();
		doctor.selectRelevance();
		//doctor.allFilters();
		List<String> Doctors = doctor.getDoctorInfo();
		readandwritedata.writeDoctors(Doctors, excelFilePath,sheetName);

	}
	@Test(priority=2)
	public void TC002_SurgeryList() throws IOException {
		sur=new Surgeries(driver);
		sur.clickSurgery();
		sur.validateSurgeryPage();
		sur.scrollDown();
		List<String> surgeryList=sur.listOfSurgeries();
		readandwritedata.writeSurgery(surgeryList, excelFilePath,sheetName1);
		sur.scrollup();
	}
	@Test(priority=3)
	public void TC003_Corporates() throws InterruptedException, IOException, HeadlessException, AWTException {

		corporate=new Corporates(driver);
		corporate.selectCorporate();
		corporate.selectHealth();
		corporate.validateCorporatePage();
		corporate.enterDetailsinvalid(excelFilePath, sheetName2);
		corporate.demobutton();
		corporate.enterDetailsvalid(excelFilePath, sheetName2);
		corporate.demobutton();
		corporate.textPrint();
		corporate.validateThankYou();
		corporate.screenshot();
	}

}
