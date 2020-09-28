package cpms.webasto.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cpms.webasto.base.TestBase;
import cpms.webasto.repository.DashboardPage;
import cpms.webasto.repository.SignInPage;

public class DashboardPageTest extends TestBase {
	SignInPage signIn;
	DashboardPage dashboard;

	public DashboardPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void launchBrowser() throws IOException, InterruptedException {
		// Initialize Driver
		initializeDriver();
		signIn = new SignInPage();
		dashboard = signIn.logIn(prop.getProperty("email_Webasto_SuperAdmin_Devops"), prop.getProperty("password_Webasto_SuperAdmin_Devops"));
		String dashboardTxt = dashboard.dashboardText().getText();
		String text = "Dashboard";
		Assert.assertEquals(dashboardTxt, text);
	}

	@Test(priority=1)
	public void chargePointOverview() throws IOException, InterruptedException {
		String count = dashboard.chargePoints().getText();
		dashboard.chargePoints().click();
		List<WebElement> chargeID = dashboard.chargePointID();
		List<String> chargeNames = new ArrayList<String>();
		for (WebElement names : chargeID) {
			chargeNames.add(names.getText());
		}
		String nextButtonClassName = driver
				.findElement(By.xpath("//*[@id='root']//div[4]//li/a[contains(@class,'undefined')]"))
				.getAttribute("class");
		while (nextButtonClassName.contains("undefined")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			// Thread.sleep(6000);
			try {
				WebElement nextBtn = driver.findElement(By.xpath("//*[@id='root']//div[4]//a[contains(text(),'⟩')]"));
				nextBtn.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}

			chargeID = dashboard.chargePointID();

			for (WebElement names : chargeID) {
				chargeNames.add(names.getText());
			}

		}

		int chargePointsCount = Integer.parseInt(count);
		int totalNames = chargeNames.size();
		Assert.assertEquals(chargePointsCount, totalNames);
	}

	@Test(priority=2)
	public void activeChargePointOverview() throws InterruptedException {
		String count = dashboard.activeChargePoints().getText();
		dashboard.activeChargePoints().click();
		List<WebElement> activeID = dashboard.chargePointID();
		List<String> chargeNames = new ArrayList<String>();
		for (WebElement names : activeID) {
			chargeNames.add(names.getText());

		}
		String nextButtonClassName = driver
				.findElement(By.xpath("//*[@id='root']//div[4]//li/a[contains(@class,'undefined')]"))
				.getAttribute("class");
		while (nextButtonClassName.contains("undefined")) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

				WebElement nextBtn = driver.findElement(By.xpath("//*[@id='root']//div[4]//a[contains(text(),'⟩')]"));
				nextBtn.click();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}

			activeID = dashboard.chargePointID();
			for (WebElement names : activeID) {
				chargeNames.add(names.getText());
			}

		}
		int activeChargeCount = Integer.parseInt(count);
		int totalNames = chargeNames.size();
		Assert.assertEquals(activeChargeCount, totalNames);
	}

	@Test(priority=3)
	public void unknownChargePointOverview() throws Exception {
		String count = dashboard.unknownChargePoints().getText();
		dashboard.unknownChargePoints().click();
		List<WebElement> unknownID = dashboard.unknownChargePoint();
		List<String> chargeNames = new ArrayList<String>();
		for (WebElement names : unknownID) {
			chargeNames.add(names.getText());
		}
		try {
			String nextButtonClassName = driver.findElement(By.xpath("//*[@id='root']//div[3]//li/a"))
					.getAttribute("class");
			while(nextButtonClassName.contains("undefined")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				try {
					WebElement nextBtn = driver
							.findElement(By.xpath("//*[@id='root']//div[3]//a[contains(text(),'⟩')]"));
					Thread.sleep(3000);
					nextBtn.click();
					Thread.sleep(3000);
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					break;
				}
				unknownID = dashboard.unknownChargePoint();
				for (WebElement names : unknownID) {
					chargeNames.add(names.getText());
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
		int unknownChargeCount = Integer.parseInt(count);
		int totalNames = chargeNames.size();
		Assert.assertEquals(unknownChargeCount, totalNames);
	}

	@Test(priority=4)
	public void ocppTags() throws InterruptedException {
		String count = dashboard.ocppTags().getText();
		int ocppCount = Integer.parseInt(count);
		dashboard.ocppTags().click();
		List<WebElement> ocppID = dashboard.chargePointID();
		List<String> chargeNames = new ArrayList<String>();
		for (WebElement names : ocppID) {
			chargeNames.add(names.getText());
		}

		try {
			String nextButtonClassName = driver.findElement(By.xpath("//*[@id='root']//div[4]//li/a"))
					.getAttribute("class");
			while(nextButtonClassName.contains("undefined")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				try {
					WebElement nextBtn = driver
							.findElement(By.xpath("//*[@id='root']//div[4]//a[contains(text(),'⟩')]"));
					nextBtn.click();
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					break;
				}
				ocppID = dashboard.chargePointID();

				for (WebElement names : ocppID) {
					chargeNames.add(names.getText());
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}

		int totalNames = chargeNames.size();
		Assert.assertEquals(ocppCount, totalNames);
	}

	@Test(priority=5)
	public void transactions() throws InterruptedException {
		String count = dashboard.transactions().getText();
		int transCount = Integer.parseInt(count);
		try {
			dashboard.transactions().click();
			List<WebElement> transID = dashboard.transactionID();
			List<String> transNames = new ArrayList<String>();
			for (WebElement names : transID) {
				transNames.add(names.getText());
			}
			int totalNames = transNames.size();
			Assert.assertEquals(transCount, totalNames);
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
