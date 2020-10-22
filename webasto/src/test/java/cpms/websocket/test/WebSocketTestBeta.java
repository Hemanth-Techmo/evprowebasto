package cpms.websocket.test;

import org.testng.annotations.Test;

public class WebSocketTestBeta 
{	
	@Test
	public void chargePointConnect1() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("Bajaj","FRD_evn_1111","v5.11",100160,"Newbajaj001","Newbajaj001",3);
	}
	@Test
	public void chargePointConnect2() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("Bajaj","FRD_evn_1111","v5.11",100160,"Newbajaj002","Newbajaj002",3);
	}
	
	@Test
	public void chargePointConnect3() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("Bajaj","FRD_evn_1111","v5.11",100160,"Newbajaj003","Newbajaj003",3);
	}
	
	
	@Test
	public void chargePointConnect4() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("Bajaj","FRD_evn_1111","v5.11",100160,"Newbajaj004","Newbajaj004",3);
	}
	
	@Test
	public void chargePointConnect5() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("HyderabadBajaj","hyb_evn_1308","v0.0.1",19595,"HyBaj002","Hyd0014",3);
	}
	
	@Test
	public void chargePointConnect6() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("HyderabadBajaj","hyb_evn_1308","v0.0.1",19596,"HyBaj003","Hyd0015",3);
	}
	
	@Test
	public void chargePointConnect7() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("HyderabadBajaj","hyb_evn_1308","v0.0.1",19597,"HyBaj004","Hyd0016",3);
	}
	
	@Test
	public void chargePointConnect8() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("maruthi","mar_evn_1308","v0.0.1",18591,"Maruthi001","tag001",3);
	}
	
	@Test
	public void chargePointConnect9() throws Exception
	{
		SampleWebSocketTestBeta swt=new SampleWebSocketTestBeta();
        swt.chargePointConnect1("maruthi","mar_evn_1308","v0.0.1",18592,"Maruthi002","tag002",3);
	}
}