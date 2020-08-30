package br.com.mantis.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyViewPage {

	private WebDriver driver;

	private static String PAGE_URL = "https://mantis-prova.base2.com.br/my_view_page.php";

	public MyViewPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get(PAGE_URL);
	}

	public boolean estaNaPaginaDeMyView() {
		Boolean currentUrl = this.driver.getCurrentUrl().endsWith("/my_view_page.php");
		return currentUrl;
	}

	public void selectProject() {
		driver.findElement(By.name("project_id")).click();
		WebElement dropdown = driver.findElement(By.name("project_id"));
		dropdown.findElement(By.xpath("//option[. = 'Marlon Pestana´s Project']")).click();
		driver.findElement(By.name("project_id")).click();
	}

	public void logout() {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public ReportIssuePage visitandoPaginaReportIssue() {
		selectProject();
		driver.findElement(By.linkText("Report Issue")).click();
		return new ReportIssuePage(driver);
	}
	
	public ViewIssuesPage visitandoPaginaViewIssuesPage() {
		selectProject();
		driver.findElement(By.linkText("View Issues")).click();
		return new ViewIssuesPage(driver);
	}
}
