package org.stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.commonlibrary.CommonLib;
import org.cucumberRunner.RunCukesByCompositionTest;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//
public class CommonSteps extends RunCukesByCompositionTest{
	InputStream in;
	public CommonSteps() throws IOException{
		super();
		prop = new Properties();
		in = new FileInputStream("src\\test\\java\\org\\ObjectRepository\\commonOR.properties");
		prop.load(in);
		in.close();
//		driver=instantiateWebDriver("IE", "http://demo.nopcommerce.com/");
//		driver.findElement(By.linkText("Register")).click();
		System.out.println(driver);
	}
	
	
	
	@Given("^I pass all test data in sheet name \"([^\"]*)\"$")
	public void readTestdata(String sheetName) throws Throwable {
		
		readDataFromInputData(sheetName);
		System.out.println(rowCount);
	}
	
	@Then("^I want to run test for row number \"([^\"]*)\"$")
	public void getAllRows(int rCount) throws Throwable {
		System.out.println(rCount);
		rowsCount=rCount;
		System.out.println(rowsCount);
	}
	@When("^I click on Register$")
	public void i_click_on_Register() throws Throwable {
		driver.findElement(By.linkText(prop.getProperty("Link.Register"))).click();
	}

	@Then("^I verify Register Label dislayed$")
	public void i_verify_Register_Label_dislayed() throws Throwable {
		
	}

	@Then("^I click on male Radio button$")
	public void i_click_on_male_Radio_button() throws Throwable {
	}

	@Then("^I enter \"([^\"]*)\"$")
	public void i_enter(String input1) throws Throwable {
		driver.findElement(By.name(prop.getProperty("Name.FirstName"))).sendKeys(input1);
	}

	@Then("^I select \"([^\"]*)\"$")
	public void i_select(String arg1) throws Throwable {
	}

	@Then("^I will close browser for iteration$")
	public void i_will_close_browser_for_iteration() throws Throwable {
	}
	
}


