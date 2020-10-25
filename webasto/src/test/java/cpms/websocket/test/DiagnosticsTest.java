package cpms.websocket.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.miscellaneous.GenericClass;
import cpms.webasto.repository.WebSocketPage;

public class DiagnosticsTest extends TestBase {
	WebSocketPage webSocket;
	GenericClass extractFile;
	public DiagnosticsTest() throws IOException {
		super();
	}

	@Test(priority=1)
	public void performDiagnostics() throws Exception {
		initializeWebSocketDriver();
		webSocket = new WebSocketPage();
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
		System.out.println("The parent window is "+driver.getTitle());
		 String randomString = RandomStringUtils.randomAlphabetic(6);
		 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.setTimeZone(TimeZone.getTimeZone("UTC"));
			String t1=f.format(new Date());
			String[] t2=t1.split("\\s+");
			String time=t2[1].trim();
			String Date=t2[0].trim();
			String startTime=Date+"T"+time+"Z";
		webSocket.sendMessageTextField().sendKeys("[\r\n" + 
				"  2,\r\n" + 
				"  \"f086-6584-8wevs-"+randomString+"\",\r\n" + 
				"  \"GetDiagnostics\",\r\n" + 
				"  {\r\n" + 
				"    \"retries\": 3,\r\n" + 
				"    \"location\": \"http://devcpms.evprowebasto.com/cpms/api/diagnostics/SN/"+chargePointID+"\",\r\n" + 
				"    \"startTime\": \""+startTime+"\",\r\n" + 
				"    \"stopTime\": \"2020-10-31T08:00:00Z\",\r\n" + 
				"    \"retryInterval\": 2\r\n" + 
				"  }\r\n" + 
				"]");
		webSocket.sendButton().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		String[] request=driver.findElement(By.xpath("//*[@id='messages']/pre[1]")).getText().split("\"");
		String udid=request[1].trim();
		System.out.println(udid);
		webSocket.sendMessageTextField().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//*[@id='clearMessagesButton']")).click();
		SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		f1.setTimeZone(TimeZone.getTimeZone("UTC"));
		String utcTimeStamp=f1.format(new Date());
		
		//Verify the Diagnostics File
		String fileName=extractFile.extractFileName();
		System.out.println("Old file name is: "+fileName);
		
		String dynamicFileName=""+utcTimeStamp+"_Webasto_"+chargePointID+"_Diagnostics.tar.gz";

		File oldfile = new File("C:\\Users\\DELL\\Downloads\\"+fileName+"");
	    File newfile = new File("C:\\Users\\DELL\\Downloads\\"+dynamicFileName+"");
	      if(oldfile.renameTo(newfile)) {
	         System.out.println("File Renamed Successfully");
	      } else {
	         System.out.println("File Rename Failed");
	      } 
	webSocket.sendMessageTextField().sendKeys("[ 3,\""+udid+"\",{\"fileName\":\""+dynamicFileName+"\"}]");
	webSocket.sendButton().click();
	String response=driver.findElement(By.xpath("//*[@id='messages']/pre[1]")).getText();
	System.out.println(response);
	driver.quit();
	}
}
