package cpms.webasto.test;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.MaintenanceInventoryPage;
import cpms.webasto.repository.WebSocketPage;

public class WebSocketPageTest extends TestBase {
	WebSocketPage webSocket;
	MaintenanceInventoryPage inventory;

	public WebSocketPageTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void launch() throws Exception {
		initializeWebSocketDriver();
		webSocket = new WebSocketPage();
	}

	@Test
	public void chargePointConnect() throws Exception {
		webSocket.serverURLTextField().click();
		Xls_Reader reader = new Xls_Reader(prop.getProperty("bulkImportDownloadedExcelPath"));
		String sheetName = "Import Inventory";
		int rowCount = reader.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String rowData = reader.getCellData(sheetName, "Charge Point", rowNum);
			webSocket.serverURLTextField().sendKeys("ws://devcs.evprowebasto.com/cs/" + rowData);
			webSocket.serverProtocolTextField().click();
			webSocket.serverProtocolTextField().sendKeys("ocpp1.6");
			Thread.sleep(2000);
			webSocket.connectBtn().click();
			boolean connectStatus = webSocket.connectionStatus().isDisplayed();
			Assert.assertTrue(connectStatus);
           //Click on Disconnect button
			if (webSocket.disconnectBtn().isDisplayed()) {
				webSocket.disconnectBtn().click();
				Thread.sleep(3000);
				webSocket.serverURLTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				webSocket.serverProtocolTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			}
		}
	}
	

	@AfterMethod
	public void tearDown() {
		driverWs.quit();
	}

}
