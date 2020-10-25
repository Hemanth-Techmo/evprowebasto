package cpms.websocket.test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.excel.lib.util.Xls_Reader;

public class WebSocketConcurrentTest {

int rowNumber;
int connectId;
String env;
	public void chargePointConnect(int rowNum, int connectorId, String environment) throws Exception {
		rowNumber=rowNum;
		connectId=connectorId;
		env=environment;
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
		//String randomNum = RandomStringUtils.randomNumeric(5);
        String randomString = RandomStringUtils.randomAlphabetic(6);
        
        Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportExcelPath"));
        String sheetName1 = "Import Inventory";
        String sheetName2= "OCPP Tags";
		//int rowCount = reader.getRowCount(sheetName);
	    String chargePointId = reader.getCellData(sheetName1, "Charge Point", rowNum);
		String vendor=reader.getCellData(sheetName1, "Organization ID", rowNum);
		String model=reader.getCellData(sheetName1, "Model Name", rowNum);
		String firmwareVersion=reader.getCellData(sheetName1, "Firmware Version", rowNum);
		String cpSerialNum=reader.getCellData(sheetName1, "MES Serial Number", rowNum);
		String idTag=reader.getCellData(sheetName2, "Tag ID", rowNum);
		Thread.sleep(2000);
		if(environment.equalsIgnoreCase("dev"))
		{
		webSocket.serverURLTextField().sendKeys("ws://devcs.evprowebasto.com/cs/"+chargePointId+"");
		}
		else
		{
		webSocket.serverURLTextField().sendKeys("ws://betacs.evprowebasto.com/cs/"+chargePointId+"");
		}
		webSocket.serverProtocolTextField().click();
		webSocket.serverProtocolTextField().sendKeys("ocpp1.6");
		Thread.sleep(2000);
		webSocket.connectBtn().click();
		boolean connectStatus = webSocket.connectionStatus().isDisplayed();
		Assert.assertTrue(connectStatus);
		webSocket.sendMessageTextField().click();
        // Timestamp timeStamp=new Timestamp(System.currentTimeMillis());		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		f.setTimeZone(TimeZone.getTimeZone("UTC"));
		String t1=f.format(new Date());
		String[] t2=t1.split("\\s+");
		String time=t2[1].trim();
		String Date=t2[0].trim();
		String utcTimeZone=Date+"T"+time+"Z";		
		
		//Boot Notification
		webSocket.sendMessageTextField().sendKeys("[\r\n" + 
				"  2,\r\n" + 
				"  \"3cd2-de80-4675-"+randomString+"\" ,\r\n" + 
				"  \"BootNotification\",\r\n" + 
				"  {\r\n" + 
				"    \"chargePointVendor\": \""+vendor+"\",\r\n" + 
				"    \"chargePointModel\": \""+model+"\",\r\n" + 
				"    \"firmwareVersion\": \""+firmwareVersion+"\",\r\n" + 
				"    \"chargePointSerialNumber\": \""+cpSerialNum+"\",\r\n" + 
				"    \"meterSerialNumber\": \"1600\"\r\n" + 
				"  }\r\n" + 
				"]");
		System.out.println(chargePointId+" Boot Notification Request::"+"[\r\n" + 
				"  2,\r\n" + 
				"  \"3cd2-de80-4675-"+randomString+"\" ,\r\n" + 
				"  \"BootNotification\",\r\n" + 
				"  {\r\n" + 
				"    \"chargePointVendor\": \""+vendor+"\",\r\n" + 
				"    \"chargePointModel\": \""+model+"\",\r\n" + 
				"    \"firmwareVersion\": \""+firmwareVersion+"\",\r\n" + 
				"    \"chargePointSerialNumber\": \""+cpSerialNum+"\",\r\n" + 
				"    \"meterSerialNumber\": \"1600\"\r\n" + 
				"  }\r\n" + 
				"]");
		
		webSocket.sendButton().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String bootNotificationResponse = driver.findElement(By.xpath("//*[@id='messages']/pre[3]")).getText();
		System.out.println("*****"+chargePointId+" Boot Notification Response*****");
		System.out.println(bootNotificationResponse);
		Thread.sleep(6000);
		webSocket.sendMessageTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//*[@id='clearMessagesButton']")).click();
	
		//Start Transaction
		webSocket.sendMessageTextField().sendKeys("[\r\n" + 
				"  2,\r\n" + 
				"  \"f086-6584-8wevs-"+randomString+"\",\r\n" + 
				"  \"StartTransaction\",\r\n" + 
				"  {\r\n" + 
				"    \"connectorId\": "+connectorId+",\r\n" + 
				"    \"idTag\": \""+idTag+"\",\r\n" + 
				"    \"timestamp\": \""+utcTimeZone+"\",\r\n" + 
				"    \"meterStart\": 0\r\n" + 
				"  }\r\n" + 
				"]");
		System.out.println(chargePointId+" Start Transaction Request::"+"[\r\n" + 
				"  2,\r\n" + 
				"  \"f086-6584-8wevs-"+randomString+"\",\r\n" + 
				"  \"StartTransaction\",\r\n" + 
				"  {\r\n" + 
				"    \"connectorId\": "+connectorId+",\r\n" + 
				"    \"idTag\": \""+idTag+"\",\r\n" + 
				"    \"timestamp\": \""+utcTimeZone+"\",\r\n" + 
				"    \"meterStart\": 0\r\n" + 
				"  }\r\n" + 
				"]");
		webSocket.sendButton().click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String startTransactionResponse = driver.findElement(By.xpath("//*[@id='messages']/pre[2]")).getText();
		System.out.println("*****"+chargePointId+" Start Transaction Response*****");
		System.out.println(startTransactionResponse);
		String[] responseSplit = startTransactionResponse.split(",");
        String responseTrim = responseSplit[2].trim();
        String[] transactIdTrim=responseTrim.split(":");
        String transactId=transactIdTrim[1].trim();
        System.out.println(transactId);
        if(transactId.equalsIgnoreCase("{\"status\""))
        {
        	System.out.println("TransactionId not generated for "+chargePointId+" due to ConcurrentTx or Invalid error");
        	driver.quit();
        }
        else
        {
        for(int meterStartValue=20;meterStartValue<=60;meterStartValue+=20)
        {
            String randomString1 = RandomStringUtils.randomAlphabetic(6);
        	webSocket.sendMessageTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    		driver.findElement(By.xpath("//*[@id='clearMessagesButton']")).click();
    		//Meter Value
    		webSocket.sendMessageTextField().sendKeys("[\r\n" + 
    				"2,\r\n" + 
    				"\"f0586-6584-8wevs-"+randomString1+"\",\r\n" + 
    				"\"MeterValues\",\r\n" + 
    				"{\r\n" + 
    				"\"connectorId\":"+connectorId+",\r\n" + 
    				"\"transactionId\":"+transactId+",\r\n" + 
    				"\"meterValue\":\r\n" + 
    				"[\r\n" + 
    				"{\r\n" + 
    				"\"timestamp\":\""+utcTimeZone+"\",\r\n" + 
    				"\"sampledValue\":\r\n" + 
    				"[\r\n" + 
    				"{\r\n" + 
    				"\"value\":\""+meterStartValue+"\",\"context\":\"Sample.Periodic\",\r\n" + 
    				"\"format\":\"Raw\",\r\n" + 
    				"\"measurand\":\"Energy.Active.Import.Register\",\r\n" + 
    				"\"location\":\"Outlet\",\r\n" + 
    				"\"unit\":\"Wh\"\r\n" + 
    				"}]}]}]");
    		System.out.println(chargePointId+" Meter Value Request::"+"[\r\n" + 
				"  2,\r\n" + 
				"  \"f086-6584-8wevs-"+randomString+"\",\r\n" + 
				"  \"StartTransaction\",\r\n" + 
				"  {\r\n" + 
				"    \"connectorId\": "+connectorId+",\r\n" + 
				"    \"idTag\": \""+idTag+"\",\r\n" + 
				"    \"timestamp\": \""+utcTimeZone+"\",\r\n" + 
				"    \"meterStart\": 0\r\n" + 
				"  }\r\n" + 
				"]");
    		webSocket.sendButton().click();
    		JavascriptExecutor js1 = (JavascriptExecutor) driver;
    		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    		Thread.sleep(2000);
    		String meterValueResponse = driver.findElement(By.xpath("//*[@id='messages']/pre[2]")).getText();
    		System.out.println("*****"+chargePointId+" Meter value response for value "+meterStartValue+"*****");
    		System.out.println(meterValueResponse);
        }
        
		webSocket.sendMessageTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//*[@id='clearMessagesButton']")).click();
		//Status Notification
		webSocket.sendMessageTextField().sendKeys("[\r\n" + 
				"2,\r\n" + 
				"\"f4086-6584-8wevs-"+randomString+"\",\r\n" + 
				"\"StatusNotification\",\r\n" + 
				"{\r\n" + 
				"\"connectorId\":"+connectorId+",\r\n" + 
				"\"errorCode\":\"ConnectorLockFailure\",\r\n" + 
				"\"status\":\"Charging\",\r\n" + 
				"\"vendorId\":\"webasto.com\",\r\n" + 
				"\"timestamp\": \""+utcTimeZone+"\",\r\n" + 
				"\"vendorErrorCode\": \"VendorError\"\r\n" + 
				"}\r\n" + 
				"]");
		System.out.println(chargePointId+"Status Notification Request::"+"[\r\n" + 
				"2,\r\n" + 
				"\"f4086-6584-8wevs-"+randomString+"\",\r\n" + 
				"\"StatusNotification\",\r\n" + 
				"{\r\n" + 
				"\"connectorId\":"+connectorId+",\r\n" + 
				"\"errorCode\":\"ConnectorLockFailure\",\r\n" + 
				"\"status\":\"Charging\",\r\n" + 
				"\"vendorId\":\"webasto.com\",\r\n" + 
				"\"timestamp\": \""+utcTimeZone+"\",\r\n" + 
				"\"vendorErrorCode\": \"VendorError\"\r\n" + 
				"}\r\n" + 
				"]");
		webSocket.sendButton().click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		String statusNotificationResponse = driver.findElement(By.xpath("//*[@id='messages']/pre[2]")).getText();
		System.out.println("*****"+chargePointId+" Status Notification Response*****");
		System.out.println(statusNotificationResponse);
		
			webSocket.sendMessageTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			driver.findElement(By.xpath("//*[@id='clearMessagesButton']")).click();
			//Stop Transaction
			webSocket.sendMessageTextField().sendKeys("[\r\n" + 
					"  2,\r\n" + 
					"  \"f4086-6584-8wevs-"+randomString+"\",\r\n" + 
					"  \"StopTransaction\",\r\n" + 
					"  {\r\n" + 
					"    \"idTag\": \""+idTag+"\",\r\n" + 
					"    \"meterStop\":180,\r\n" + 
					"    \"timestamp\": \""+utcTimeZone+"\",\r\n" + 
					"    \"transactionId\": "+transactId+",\r\n" + 
					"    \"reason\": \"Local\"\r\n" + 
					"  }\r\n" + 
					"]");
			
			System.out.println(chargePointId+" Stop Transaction Request::"+"[\r\n" + 
					"  2,\r\n" + 
					"  \"f4086-6584-8wevs-"+randomString+"\",\r\n" + 
					"  \"StopTransaction\",\r\n" + 
					"  {\r\n" + 
					"    \"idTag\": \""+idTag+"\",\r\n" + 
					"    \"meterStop\":180,\r\n" + 
					"    \"timestamp\": \""+utcTimeZone+"\",\r\n" + 
					"    \"transactionId\": "+transactId+",\r\n" + 
					"    \"reason\": \"Local\"\r\n" + 
					"  }\r\n" + 
					"]");
			webSocket.sendButton().click();
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			String stopTransacResponse = driver.findElement(By.xpath("//*[@id='messages']/pre[2]")).getText();
			System.out.println("*****"+chargePointId+" Stop Transaction*****");
			System.out.println(stopTransacResponse);
			driver.quit();
        }
	}
}
