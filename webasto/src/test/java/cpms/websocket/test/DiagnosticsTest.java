package cpms.websocket.test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.WebSocketPage;

public class DiagnosticsTest extends TestBase {
	WebSocketPage webSocket;

	public DiagnosticsTest() throws IOException {
		super();
	}

	@Test(priority=1)
	@Parameters({"chargePointID"})
	public void connectChargePoint(String chargePointID) throws Exception {
		initializeWebSocketDriver();
		webSocket = new WebSocketPage();
		webSocket.serverURLTextField().click();
      //  String chargePointID="JMSRE141";
		webSocket.serverURLTextField().sendKeys("ws://devcs.evprowebasto.com/cs/" + chargePointID);
		webSocket.serverProtocolTextField().click();
		webSocket.serverProtocolTextField().sendKeys("ocpp1.6");
		Thread.sleep(2000);
		webSocket.connectBtn().click();
		boolean connectStatus = webSocket.connectionStatus().isDisplayed();
		Assert.assertTrue(connectStatus);
	}
	
	@Test(priority=3)
	public void getResponse()
	{
		String response=driver.findElement(By.xpath("//*[@id='messages']/pre[1]")).getText();
		System.out.println(response);
	}
	
	

}
