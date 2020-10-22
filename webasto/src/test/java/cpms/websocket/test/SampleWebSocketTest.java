package cpms.websocket.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.excel.lib.util.Xls_Reader;

public class SampleWebSocketTest {
	int rowNumber;
	String excelSheetName;

	public void chargePointConnect(int rowNum, String sheetName) throws Exception {
		rowNumber = rowNum;
		excelSheetName = sheetName;
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\DELL\\git\\evprowebasto\\webasto\\src\\main\\java\\cpms\\webasto\\properties\\properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\DELL\\Downloads\\Selenium\\Browser WebSocket Client.crx"));
		WebDriver driver = new ChromeDriver(options);
		driver.get("chrome-extension://mdmlhchldhfnfnkfmljgeinlffmdgkjo/index.html");
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SampleWebSocketPage webSocket = new SampleWebSocketPage(driver);
		webSocket.serverURLTextField().click();
		Xls_Reader reader = new Xls_Reader(prop.getProperty("webSocketExcel"));
		// int rowCount = reader.getRowCount(sheetName);
//		String randomNum = RandomStringUtils.randomNumeric(5);
        String randomString = RandomStringUtils.randomAlphabetic(5);

		String chargePointID = reader.getCellData(sheetName, "Charge Point ID", rowNum);
		webSocket.serverURLTextField().sendKeys("ws://devcs.evprowebasto.com/cs/" + chargePointID);
		webSocket.serverProtocolTextField().click();
		webSocket.serverProtocolTextField().sendKeys("ocpp1.6");
		Thread.sleep(2000);
		webSocket.connectBtn().click();
		boolean connectStatus = webSocket.connectionStatus().isDisplayed();
		Assert.assertTrue(connectStatus);
		String request = reader.getCellData(sheetName, "Request", rowNum);
		Thread.sleep(10000);
		webSocket.sendMessageTextField().click();
		webSocket.sendMessageTextField().sendKeys(request);
		webSocket.sendButton().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		String response = null;
		response = driver.findElement(By.xpath("//*[@id='messages']")).getText();
		System.out.println(response);
		String[] responseSplit = response.split(",");
		String responseTrim = responseSplit[0].trim();
		char status = responseTrim.charAt(1);
		System.out.println(status);
	//	Assert.assertEquals(3, status);
		driver.quit();
	}
}
