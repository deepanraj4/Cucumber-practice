package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	public static WebDriver driver;

	public static void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			System.setProperty("webdriver.Chrome.driver","C:\\Users\\Deepanraj\\eclipse-workspace\\FrameworkAdactin\\driver\\chromedriver.exe");
			
			driver = new ChromeDriver();

			break;

		default:
			System.out.println("InValid Browser Type");
			break;
		}
	}

	public static void getUrl(String url) {
		driver.get(url);

	}

	public static void windMax() {
		driver.manage().window().maximize();

	}

	public static void capture(String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		File targetFile = new File("C:\\Users\\Deepanraj\\eclipse-workspace\\FrameworkFirstproject\\target\\screenshot\\" + name
						+ ".png");

		FileUtils.copyFile(sourceFile, targetFile);
	}
	
	public static void selectMethod(WebElement obj,String text) {
		
		 Select s = new Select(obj);
		 s.selectByVisibleText(text);
		 
	}

	public static void textSendBasedOnJS(String txtInput, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + txtInput + "')", element);
	}

	public static String excelRead(int rownum, int cellnum) throws IOException {

		// To locate the Where Excel is
		File file = new File("C:\\Users\\Deepanraj\\Desktop\\Framework\\input.xlsx");

		// To get File as Input from Given Location
		FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

		// To Define The Workbook
		Workbook book = new XSSFWorkbook(stream); // throws IOException

		// To get Sheet from Workbook
		Sheet sheet = book.getSheet("Sheet1");

		// To get Row from Sheet
		Row row = sheet.getRow(rownum);

		// To get Cell from Row
		Cell cell = row.getCell(cellnum);

		// To find Cell Type

		CellType cellType = cell.getCellType();
		String value = null;
		switch (cellType) {

		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				BigDecimal valueOf = BigDecimal.valueOf(l);
				value = valueOf.toString();

			}
			break;

		default:

			break;
		}
		return value;

	}



}
