package teste.mobile.regressivo.adesao;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.adesao.Pacotes;
import constantes.adesao.termosECondicoes.TermosECondicoes;
import funcionalidade.mobile.adesao.CompleteSeuCadastroFunc;
import funcionalidade.mobile.adesao.termosecondicoes.TermosECondicoesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.notificacoes.NotificacoesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ADESAO)
public class QA03410 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private NotificacoesFunc notificacoes = new NotificacoesFunc();
    private CompleteSeuCadastroFunc completeSeuCadastro = new CompleteSeuCadastroFunc();
    private TermosECondicoesFunc termosECondicoes = new TermosECondicoesFunc();

    @Test(description = "REG.ADS.01.02.03 - Validar na adesão termo de informações essências conta next")
    @Description("Descrição:\n" +
            "Garantir que o termo adesão de informações essências e apresentado conforme esperado.Pré requisitos:\n" +
            "   Ter o next instalado\n" +
            "   Ter CPF de adesão status 0, com as etapas 1,2,3,4,5 concluídas;")

    @Severity(SeverityLevel.NORMAL)
    public void QA03410() throws Exception {

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        completeSeuCadastro.validarAdesaoTermo(recuperarMassa(JSON.SENHA),
                recuperarMassa("pacotePadronizado"),
                recuperarMassa("senhaCartao"),
                recuperarMassa("confirmarSenhaCartao"));

        termosECondicoes.selecionarEValidarTermoECondicaoEConteudoDoTermo(
                TermosECondicoes.TERMO_INFORMACOES_ESSENCIAIS_CONTA_NEXT,
                TermosECondicoes.CONDICOES_INFORMACOES_ESSENCIAIS_CONTA_NEXT);

    }

}
