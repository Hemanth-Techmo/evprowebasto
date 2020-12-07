package cpms.websocket.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.miscellaneous.CalendarWidget;
import cpms.webasto.miscellaneous.GenericClass;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.GetDiagnosticsPage;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.SelectChargePointModel;
import cpms.webasto.repository.SignInPage;
import cpms.webasto.repository.UploadDiagnosticsPage;
import cpms.webasto.repository.WebSocketPage;

public class Duplicate extends TestBase{
	WebDriver driver1;

	WebSocketPage webSocket;
	GenericClass extractFile;
	SignInPage signIn;
	DashboardPage dashboard;
	UploadDiagnosticsPage uploadDiagnostics;
	MaintenanceInventoryPage inventory;
	SelectChargePointModel selectChargePoint;	
	GetDiagnosticsPage getDiagnostics;
	CalendarWidget calWidget;	
	public Duplicate() throws IOException {
		super();
	}
	@Test
public void test() throws Exception
{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\DELL\\git\\evprowebasto\\webasto\\src\\main\\java\\cpms\\webasto\\properties\\properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\Selenium\\chromedriver_win32_new\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\DELL\\Downloads\\Selenium\\Browser WebSocket Client.crx"));
		WebDriver driver1 = new ChromeDriver(options);
		driver1.get("chrome-extension://mdmlhchldhfnfnkfmljgeinlffmdgkjo/index.html");
		driver1.navigate().refresh();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SampleWebSocketPage webSocket = new SampleWebSocketPage(driver1);
		webSocket.serverURLTextField().click();
		extractFile=new GenericClass();
        String chargePointID="JMSRE142";
		webSocket.serverURLTextField().sendKeys("ws://devcs.evprowebasto.com/cs/" + chargePointID);
		webSocket.serverProtocolTextField().click();
		webSocket.serverProtocolTextField().sendKeys("ocpp1.6");
		Thread.sleep(2000);
		webSocket.connectBtn().click();
		boolean connectStatus = webSocket.connectionStatus().isDisplayed();
		Assert.assertTrue(connectStatus);


		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		getDiagnostics = new GetDiagnosticsPage();
		selectChargePoint=new SelectChargePointModel();
		calWidget=new CalendarWidget();
		uploadDiagnostics=new UploadDiagnosticsPage();
		inventory = new MaintenanceInventoryPage();
		selectChargePoint=new SelectChargePointModel();
		extractFile=new GenericClass();
		inventory.maintenance().click();
		getDiagnostics.operationsSideBarBtn().click();
		getDiagnostics.getDiagnosticsBtn().click();
		selectChargePoint.selectChargePointBtn().click();
		selectChargePoint.selectCheckBox(chargePointID);
		String selectedChargePoint=selectChargePoint.selectedChargePoint().getText();
		if(selectedChargePoint.equalsIgnoreCase(chargePointID))
		{
			selectChargePoint.doneBtn().click();
		}
		Thread.sleep(2000);
		getDiagnostics.retriesTextField().sendKeys("2");
		getDiagnostics.retryIntervalTextField().sendKeys("4");
		getDiagnostics.startDateTime().click();
		calWidget.currentMonth().click();
		calWidget.todayDate().click();
		getDiagnostics.stopDateTime().click();
		calWidget.currentMonth().click();
		calWidget.nextMonthBtn().click();
		calWidget.lastDateInWidget().click();
		getDiagnostics.retriesTextField().click();
		getDiagnostics.performButton().click();
		Thread.sleep(1000);
		boolean sucessMsgFlag=getDiagnostics.requestProcessedMsg().isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.visibilityOf(getDiagnostics.requestProcessedMsg()));
		Assert.assertTrue(sucessMsgFlag);
		String sucessMsg=getDiagnostics.requestProcessedMsg().getText();
		System.out.println(sucessMsg);
		
//		Thread.sleep(4000);
//		Robot rb = new Robot();
//		rb.keyPress(KeyEvent.VK_ALT);
//		rb.keyPress(KeyEvent.VK_TAB);
//		rb.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(4000);
//		rb.keyRelease(KeyEvent.VK_ALT);
//		rb.keyRelease(KeyEvent.VK_TAB);
//		rb.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(2000);
	
		
		webSocket.sendMessageTextField().click();
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String[] request=driver1.findElement(By.xpath("//*[@id='messages']/pre[1]")).getText().split("\"");
		String udid=request[1].trim();
		System.out.println(udid);
		driver1.quit();
		driver.quit();
}
		}
