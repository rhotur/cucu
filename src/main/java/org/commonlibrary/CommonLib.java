package org.commonlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.cucumberRunner.RunCukesByCompositionTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonLib {
	public WebDriver driver;
	protected WebElement webElement;
	protected XSSFWorkbook wb;
	protected XSSFSheet sheet;
	protected int rowCount;
	protected int rowsCount;
	protected Properties prop;
	public void readDataFromInputData(String sName) throws IOException{
		FileInputStream fis = new FileInputStream("src\\test\\java\\org\\data\\InputData.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet= wb.getSheet(sName);
		rowCount = sheet.getLastRowNum();
	}

}
