package br.com.mantis.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public WebDriver createWebDriver() {
		
		String webdriver = System.getProperty("browser", "chrome"); //VM Argument: -Dbrowser=firefox
		switch (webdriver) {
			case "chrome":
				return initChromeDriver();
			default:
				return initFirefoxDriver();
		}
	}

	private  WebDriver initChromeDriver() {
		return new ChromeDriver();
	}

	private  WebDriver initFirefoxDriver() {
		return new FirefoxDriver();
	}
}
