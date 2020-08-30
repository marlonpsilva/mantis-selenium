package br.com.mantis.e2e.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import br.com.mantis.e2e.pages.BrowserFactory;
import br.com.mantis.e2e.pages.LoginPage;
import br.com.mantis.e2e.pages.MyViewPage;

class LoginE2ETest {

	private MyViewPage myViewPage;
	
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

	@Test
	void loginComUsuarioValido() {

		LoginPage loginPage = new LoginPage(getDriver());

		this.myViewPage = loginPage.realizaLoginCom("marlon.pestana", "qxJXKu7Xe79M3jE");

		assertTrue(myViewPage.estaNaPaginaDeMyView());
		
		this.myViewPage.logout();
	}

	@Test
	void loginComUsuarioInValido() {
		
		LoginPage loginPage = new LoginPage(getDriver());

		loginPage.realizaLoginCom("marlon.pestana", "pass");

		assertTrue(loginPage.estaNaPaginaDeLoginComErro("marlon.pestana"));
	}
}
