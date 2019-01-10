package steps;

import org.junit.Assert;

import com.jagacy.Key;
import com.jagacy.util.JagacyException;

import Session.Session;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import telas.MenuPrin;
import telas.TelaInicial;

public class Steps {
	
	private Session session;
	private TelaInicial telaInicial;
    private Scenario scenario;
    MenuPrin menuPrin;
	
	
    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
    }
	
	
	@Dado("^estou na tela inicial da LDC$")
	public void estouNaTelaInicialDaLDC() throws Throwable {
        session = new Session("test");
        session.open();
        telaInicial = new TelaInicial(session);
        scenario.embed(session.getScreenshot(), "image/png");
	}

	@Quando("^eu informar \"([^\"]*)\" no campo correspondente a linha (\\d+) e coluna (\\d+)$")
	public void euInformarNoCampoCorrespondenteALinhaEColuna(String login, int linha, int col) throws Throwable {
		telaInicial.setLogin(login, linha, col);
        scenario.embed(session.getScreenshot(), "image/png");
	}

	@Quando("^informar \"([^\"]*)\" no campo senha$")
	public void informarNoCampoSenha(String senha) throws Throwable {
		telaInicial.setSenha(senha);
        scenario.embed(session.getScreenshot(), "image/png");
        telaInicial.sendKey(Key.ENTER);
	}

	@Então("^deve logar no sistema exibindo o label \"([^\"]*)\" na linha (\\d+) coluna (\\d+)$")
	public void deveLogarNoSistemaExibindoOLabelNaLinhaColuna(String m, int linha, int col) throws Throwable {
		menuPrin = new MenuPrin();
		menuPrin.resEsp(session, m, linha, col);
		String res = menuPrin.valor(linha, col, m.length());
		scenario.embed(session.getScreenshot(), "image/png");
		
		Assert.assertEquals(m, res);
	}
	
	@After()
	public void fecha() throws JagacyException {
		session.close();
	}
	
}
