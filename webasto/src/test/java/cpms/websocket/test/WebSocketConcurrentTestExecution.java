package cpms.websocket.test;

import org.testng.annotations.Test;

public class WebSocketConcurrentTestExecution 
{	
	@Test
	public void chargePointConnect1() throws Exception
	{
		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
		//Note: Row Number should always starts from 2
        swt.chargePointConnect(2,1,"dev");
	}
	
//	@Test
//	public void chargePointConnect2() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(3,2,"ford");
//	}
//
//	@Test
//	public void chargePointConnect3() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(4,2,"ford");
//	}
//	
//	@Test
//	public void chargePointConnect4() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(5,2,"ford");
//	}
//	
//	@Test
//	public void chargePointConnect5() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(6,2,"ford");
//	}
//	
//	@Test
//	public void chargePointConnect6() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(7,2,"ford");
//	}
//	
//	@Test
//	public void chargePointConnect7() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(8,2,"ford");
//	}
//	
//	@Test
//	public void chargePointConnect8() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(9,2,"ford");
//	}
//	
//	@Test
//	public void chargePointConnect9() throws Exception
//	{
//		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
//		//Note: Row Number should always starts from 2
//        swt.chargePointConnect(10,2,"ford");
//	}
}