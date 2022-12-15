package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.SugestoesOuReclamacoesPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA05415 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SugestoesOuReclamacoesPixFunc sugestoesOuReclamacoes = new SugestoesOuReclamacoesPixFunc();

    @Test(description = "PB.1070.US.93014.002 - Validar quando acionar link do Canal de atendimento Banco Central")
    @Description("Objetivos: \n" +
            "Validar quando acionar link do Canal de atendimento Banco Central.\n" +
            "Pré-Requisitos:\n" +
            "1.Usuário deve estar logado no menu principal do NEXT")

    @Severity(SeverityLevel.NORMAL)
    public void QA05415() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        sugestoesOuReclamacoes.validarTextoBancoCentralNaTelaCentralAtendimento();

    }
}
