package cpms.websocket.test;

import org.testng.annotations.Test;

public class WebSocketTest 
{	
	@Test
	public void bootNotification1() throws Exception
	{
		SampleWebSocketTest swt=new SampleWebSocketTest();
        swt.chargePointConnect(2,"Boot Notification");
	}
	
	@Test
	public void bootNotification2() throws Exception
	{
		SampleWebSocketTest swt=new SampleWebSocketTest();
        swt.chargePointConnect(3,"Boot Notification");
	}
	
	@Test
	public void bootNotification3() throws Exception
	{
		SampleWebSocketTest swt=new SampleWebSocketTest();
        swt.chargePointConnect(4,"Boot Notification");
	}
	
	@Test
	public void startTransaction1() throws Exception
	{
		SampleWebSocketTest swt=new SampleWebSocketTest();
        swt.chargePointConnect(2,"Start Transaction");
	}
	
	@Test
	public void startTransaction2() throws Exception
	{
		SampleWebSocketTest swt=new SampleWebSocketTest();
        swt.chargePointConnect(3,"Start Transaction");
	}
	
	@Test
	public void startTransaction3() throws Exception
	{
		SampleWebSocketTest swt=new SampleWebSocketTest();
        swt.chargePointConnect(4,"Start Transaction");
	}

}
