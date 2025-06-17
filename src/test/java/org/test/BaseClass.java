package org.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class BaseClass {

	
	public static WebDriver driver;
	
	public static WebDriver chromeBrowser() {
		 driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver browserLaunch(String bname) {
		if (bname.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
	}
		else if (bname.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (bname.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		} 
	return driver;
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void implicitlywait(int t) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(t));
	}
	public static void sendKeys(WebElement e, String values) {
		e.sendKeys(values);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static String getCurrenturl() {
		String currenturl=driver.getCurrentUrl();
		return currenturl;
	}
	public static String gettitle() {
		String title = driver.getTitle();
		return title;
	}
	public static void quit() {
		driver.quit();
	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static String getAttributevalue(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target);
	}
	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des);
	}
	public static void contextClick(WebElement rclick){
		Actions a=new Actions(driver);
		a.contextClick(rclick);
	}
	public static void select(WebElement e , int a) {
 		Select s=new Select(e);
		s.selectByIndex(a);
	}  
	public static void selectval(WebElement w, String value) {
		Select s=new Select(w);
		s.selectByValue(value);
	}
	public static File screenShot() { 
		TakesScreenshot sh=(TakesScreenshot)driver;
		File screenshotAs = sh.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}
	
	public static void switchWindow(int e) {
		Set<String> allid = driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(allid);	
		driver.switchTo().window(li.get(e));
	} 
	
	public static void thread(int t) throws InterruptedException {
		Thread.sleep(t);
	}
	
	public static void closePage() {
		driver.close();
	}
	public static void quitBrowser(){
	driver.quit();
	}
	
	public static void virtualKeys() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static String readExcel(String filename, String sheet,int row,int c) throws IOException {
		File f=new File("D:\\My flies\\JAVA SELENIUM\\Projects\\Day22_Selenium locator\\Maven_Intro\\src\\test\\resources\\Excel\\"+filename+".xls");
		FileInputStream st=new FileInputStream(f);
		Workbook wb= new HSSFWorkbook(st);
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell cell = r.getCell(c);
		
		int type = cell.getCellType();
		
		
		// type 1--->string
		// type 0--->number, date
		
		String value=null;
		if(type==1) {
			 value = cell.getStringCellValue();
		}
		else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
				 value = sd.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long num=(long)numericCellValue;
				 value=String.valueOf(num);
			}
		}
		return value;

	}

	
}
