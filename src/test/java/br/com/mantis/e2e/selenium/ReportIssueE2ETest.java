package br.com.mantis.e2e.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.mantis.e2e.pages.MyViewPage;
import br.com.mantis.e2e.pages.ReportIssuePage;
import br.com.mantis.e2e.pages.ViewIssuesPage;

class ReportIssueE2ETest extends E2ETestBase {

	private MyViewPage myViewPage;
	private ReportIssuePage reportIssuePage;
	private ViewIssuesPage viewIssuesPage;

	@Test
	void criandoUmReportIssueValido() {
		
		this.myViewPage = new MyViewPage(getDriver());
		this.reportIssuePage = myViewPage.visitandoPaginaReportIssue();
		this.viewIssuesPage = reportIssuePage.preencheForm("[All Projects] Teste", "This is Test Features",
				"Features Description");
		assertTrue(this.viewIssuesPage.estaNaPaginaDeViewIssuesPage());
		assertTrue(this.viewIssuesPage.existe("This is Test Features"));
	}

	@Test
	void criandoUmReportIssueInValidoSemOsCamposObrigatorios() {
		
		this.myViewPage = new MyViewPage(getDriver());
		this.reportIssuePage = myViewPage.visitandoPaginaReportIssue();
		this.reportIssuePage.clickSubmit();
		assertTrue(this.reportIssuePage.erroReportIssueCamposObrigatorios());
	}
}
