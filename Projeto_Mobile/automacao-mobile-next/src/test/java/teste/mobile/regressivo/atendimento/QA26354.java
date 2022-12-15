package teste.mobile.regressivo.atendimento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.ajuda.TelaAjudaFunc;
import funcionalidade.mobile.atendimento.AtendimentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pagina.mobile.jornadas.atendimento.AjudaNextTela;

@Jornada(Jornadas.ATENDIMENTO)
public class QA26354 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private AtendimentoFunc bubble = new AtendimentoFunc();
    private MenuFunc menu = new MenuFunc();
    private TelaAjudaFunc ajuda = new TelaAjudaFunc();

    @Test(description = "REG.CALL.03.01.03 - Validar atendimento de chat quando o cliente não possui histórico - Primeiro acesso")
    @Description("Pré Requisitos:  Possuir massa de primeiro acesso")

    @Severity(SeverityLevel.NORMAL)
    public void QA26354() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarAjuda();

        ajuda.validarMensagemSemHistoricoChat();





    }
}
