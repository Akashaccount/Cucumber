package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	 public static Actions a;
	 public static Robot r;
	 
	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	}
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String Url) {
		driver.get(Url);
	}
	public static void fillTextBox(WebElement ele, String n) {
		ele.sendKeys(n);
	}
	public static void clickButton(WebElement Btn) {
		Btn.click(); 
	}
	public static String readFromExcel(String fileName, String SheetName, int rowNo, int cellNo) throws IOException {

		//Fetch file Location
		File f = new File("E:\\MavenProject\\ExcelSheet\\"+fileName+".xlsx");
	
		//Read a file
		FileInputStream fin = new FileInputStream(f);
		
		//Fetch a WorkBook
		Workbook b = new XSSFWorkbook(fin);
		
		//Fetch a Sheet
		Sheet sh = b.getSheet(SheetName);
		
		//Fetch a Row
		Row r = sh.getRow(rowNo);
		
		//Fetch a Cell
		Cell c = r.getCell(cellNo);
		
		int type = c.getCellType();
		String data="";
		if (type==1) {
			 data = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date da = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd MMMMM,yyyy");
			 data = sim.format(da);		
				
			}	
		else {
			double d = c.getNumericCellValue();
			long l= (long)d;
			data = String.valueOf(l);
			
		}
			return data;
		
		}
		// Drop Down Select by Value
	public static void dropDownSelectByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}
		// Drop Down Select By Index
	public static void dropDownSelectByIndex(WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}
	
		// ThreaD Sleep
	public static void Sleep(int Seconds) throws InterruptedException {
		Thread.sleep(Seconds);
	}
	
		//Print
	public static void print(String print) {
		System.out.println(print);
	}
		// JavaScript
	public static String getValue(WebElement ref, String attributeName) {
		String str=ref.getAttribute(attributeName);
		return str;
	}
	
	public static void implicitWait(int time) {
	}
	
	public static void Refresh() {
			driver.navigate().refresh();
	}
	public static void doubleClick(WebElement ele) {
			a= new Actions(driver);
			a.doubleClick(ele);
	}
	
	public static void rightClick(WebElement ele) {
			a.contextClick(ele);
	}
	
	public static void dragAndDrop(WebElement src, WebElement Dest) {
			a.dragAndDrop(src, Dest);
	}
	public static void copy() throws AWTException {
		r= new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public static void paste() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public static void tab() throws AWTException {
		r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	}

