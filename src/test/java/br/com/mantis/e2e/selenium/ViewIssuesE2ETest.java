package br.com.mantis.e2e.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.mantis.e2e.pages.MyViewPage;
import br.com.mantis.e2e.pages.ViewIssuesPage;

public class ViewIssuesE2ETest extends E2ETestBase {

	private MyViewPage myViewPage;

	private ViewIssuesPage viewIssuesPage;

	@Test
	public void filtrandoReportsIssues() {
		
		this.myViewPage = new MyViewPage(getDriver());
		this.viewIssuesPage = myViewPage.visitandoPaginaViewIssuesPage();
		this.viewIssuesPage.searchReportIssues("This is Test Features");
		assertTrue(this.viewIssuesPage.estaNaPaginaDeViewIssuesPage());
		assertTrue(this.viewIssuesPage.existe("This is Test Features"));	
	}
}
