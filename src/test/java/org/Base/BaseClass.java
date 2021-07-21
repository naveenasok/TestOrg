package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	
		public static WebDriver driver;
		public static Actions a;
		public static Alert aler;
		public static Select s;
		

		public static void Launchbrow() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		public static void loadurl(String url) {
			driver.get(url);
		}
		public static void maxBrow() {
			driver.manage().window().maximize();
		}
		public static void Toinput(WebElement ele,String value) {
			ele.sendKeys(value);
		}
		public static void btlogin(WebElement ele) {
			ele.click();
		}

		public static void mouse(WebElement target) {
			a=new Actions(driver);
			a.moveToElement(target).perform();
		}
		public static void drag(WebElement src,WebElement des) {
			a.dragAndDrop(src, des).perform();
		}
		public static void pagetext(WebElement ele) {
			String txt=ele.getText();
			System.out.println(txt);
		}
		public static String toGetUrl() {
			String url = driver.getCurrentUrl();
			return url;
		}

		public static void tgname(WebElement ele) {
			String tag=ele.getTagName();
			System.out.println(tag);
		}	
		public static void stylevalue(WebElement ele,String value) {
			String css=ele.getCssValue(value);
			System.out.println(css);
		}
		public static void pop() {
			aler=driver.switchTo().alert();
			aler.getText();
			aler.accept();
		}
		public static void pops() {
			aler=driver.switchTo().alert();
			aler.getText();
			aler.dismiss();
		}
		public static void toSelectByIndex(WebElement element,int index) {
			 s = new Select(element);
			s.selectByIndex(index);

		}
		public static void toSelectByValue(WebElement element,String value) {
			 s = new Select(element);
			s.selectByValue(value);

		}
		public static void toSelectByVisibleText(WebElement element,String value) {
			 s = new Select(element);
			s.selectByValue(value);

		}

		
		public static void nav(String url) {
			driver.navigate().to(url);
		}
		public static void forward() {
			driver.navigate().back();
		}
		public static void refr() {
			driver.navigate().refresh();
		}
		public static void radio(String value) {
			WebElement ele=driver.findElement(By.id(value));
			System.out.println(ele);
			ele.click();
		}
		public static void enterbut() {
			a.sendKeys(Keys.ENTER).perform();
		}
		public static void largespace() {
			a.sendKeys(Keys.TAB).perform();
		}
		public static void arrup() {
			a.sendKeys(Keys.ARROW_UP).perform();
		}
		public static void arrdown() {
			a.sendKeys(Keys.ARROW_DOWN).perform();
		}
		public static void arrleft() {
			a.sendKeys(Keys.ARROW_LEFT).perform();
		}
		public static void arrright() {
			a.sendKeys(Keys.ARROW_RIGHT).perform();
		}
		public static void twice() {
		
			a.doubleClick().perform();		
		}
		public static void con(String value) {
			
			a.contextClick().perform();
		}

		public static void cls() {
			driver.close();
		}
		public static void fullclose() {
			driver.quit();
		}
		public static void Tslow(int value) throws InterruptedException {
			Thread.sleep(value);
		}
		public static void Impslow(int value) {
			driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
		}
		public static void pgload(int value) {
			driver.manage().timeouts().pageLoadTimeout(value, TimeUnit.SECONDS);
		}
		public static void Radselected(WebElement ele) {
			ele.isEnabled();
		}
		public static void check(WebElement ele) {
			ele.isSelected();
		}
		public static void dis(WebElement ele) {
			ele.isDisplayed();
		}
		public static String excelread(int row, int cell) throws IOException  {
			File f= new File("D:\\Automation Testing\\SELENIUM\\Program\\MavenTestng\\Testexcel\\TestNG Sheet.xlsx");
			FileInputStream fin= new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fin);
			Sheet s=w.getSheet("sheet1");
			Row r=s.getRow(row);
			Cell c=r.getCell(cell);
			int celltype=c.getCellType();
			String value;
			if(celltype==1) {
				value=c.getStringCellValue();
			}
			else if(DateUtil.isCellDateFormatted(c)) {
				//Date dat = c.getDateCellValue();
				//SimpleDateFormat datsimple=new SimpleDateFormat("dd/mm/yyyy");
				value = c.getStringCellValue();
			}
			else {
				double dd = c.getNumericCellValue();
				long  l=(long)dd;
				value = String.valueOf(l);	
			}
			return value;
			
		
			
				
			
				
			
			
			
			
				
			
		
			
			
			
			
			
			
			
			
			
		}


}
