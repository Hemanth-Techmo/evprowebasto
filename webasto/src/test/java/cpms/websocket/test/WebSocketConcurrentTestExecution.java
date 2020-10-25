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
	
	@Test
	public void chargePointConnect2() throws Exception
	{
		WebSocketConcurrentTest swt=new WebSocketConcurrentTest();
		//Note: Row Number should always starts from 2
        swt.chargePointConnect(3,1,"dev");
	}
//	@Test
//	public void chargePointConnect3() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("Bajaj","baj_evn_1308","v0.0.1",18590,"Bajaj004","Bajaj004",1);
//	}
//	
//	
//	@Test
//	public void chargePointConnect4() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("Bajaj","hyb_evn_1308","v0.0.1",19594,"HyBaj001","HyBaj001",1);
//	}
//	
//	@Test
//	public void chargePointConnect5() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("HyderabadBajaj","hyb_evn_1308","v0.0.1",19595,"HyBaj002","HyBaj002",1);
//	}
//	
//	@Test
//	public void chargePointConnect6() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("HyderabadBajaj","hyb_evn_1308","v0.0.1",19596,"HyBaj003","HyBaj003",1);
//	}
//	
//	@Test
//	public void chargePointConnect7() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("HyderabadBajaj","hyb_evn_1308","v0.0.1",19597,"HyBaj004","HyBaj004",1);
//	}
//	
//	@Test
//	public void chargePointConnect8() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("maruthi","mar_evn_1308","v0.0.1",18591,"Maruthi001","Maruthi001",1);
//	}
//	
//	@Test
//	public void chargePointConnect9() throws Exception
//	{
//		SampleWebSocketTestDev swt=new SampleWebSocketTestDev();
//        swt.chargePointConnect1("maruthi","mar_evn_1308","v0.0.1",18592,"Maruthi002","Maruthi002",1);
//	}
}