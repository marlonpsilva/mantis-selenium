package br.com.mantis.e2e.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.mantis.e2e.pages.BrowserFactory;
import br.com.mantis.e2e.pages.LoginPage;

public class E2ETestBase {
	private static WebDriver driver;

	protected WebDriver getDriver() {
		return driver;
	}

	@BeforeAll
	public static void setUpAll() {
		driver = new BrowserFactory().createWebDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterAll
	public static void tearDownAll() {
		driver.close();
		driver.quit();
	}
	
	@BeforeEach
	public void setUp() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.realizaLoginCom("marlon.pestana", "qxJXKu7Xe79M3jE");
	}
	
	@AfterEach
	public void tearDown() {
		driver.findElement(By.linkText("Logout")).click();
	}
}
