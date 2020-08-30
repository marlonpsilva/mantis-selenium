package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuesPage {
	
	private WebDriver driver;

	private static String PAGE_URL = "https://mantis-prova.base2.com.br/view_all_bug_page.php";
	
	public ViewIssuesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(PAGE_URL);
	}

	public boolean existe(String summary) {
		WebElement tableBugList = driver.findElement(By.id("buglist"));
		return tableBugList.getText().contains(summary);
	}
	
	public boolean estaNaPaginaDeViewIssuesPage() {
		esperaCarregarPaginaViewIssuesPage();
		return this.driver.getCurrentUrl().endsWith("/view_all_bug_page.php");
	}
	
	public void esperaCarregarPaginaViewIssuesPage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleContains("View Issues - MantisBT"));
	}
	
	public void searchReportIssues(String summary) {
		driver.findElement(By.name("search")).sendKeys(summary);
		driver.findElement(By.name("filter")).submit();
		driver.findElement(By.name("search")).clear();
	}
	
	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
	}
}
