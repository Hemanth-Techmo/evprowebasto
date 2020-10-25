package cpms.webasto.test;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.miscellaneous.CalendarWidget;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.GetDiagnosticsPage;
import cpms.webasto.repository.SelectChargePointModel;
import cpms.webasto.repository.SignInPage;

public class GetDiagnosticsPageTest extends TestBase {
	SignInPage signIn;
	DashboardPage dashboard;
	GetDiagnosticsPage getDiagnostics;
	CalendarWidget calWidget;
	SelectChargePointModel selectChargePoint;

	public GetDiagnosticsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void launchBrowser() throws Exception {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"),
				prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		getDiagnostics = new GetDiagnosticsPage();
		selectChargePoint=new SelectChargePointModel();
		calWidget=new CalendarWidget();
	}

	@Test(priority=2)
	@Parameters({"chargePointID"})
	public void getDianostics(String chargePointID) throws InterruptedException {
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
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
