package teste.mobile.regressivo.atendimento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.atendimento.TipoAcesso;
import funcionalidade.mobile.atendimento.AtendimentoFunc;
import funcionalidade.mobile.atendimento.ChatFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA04273 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menuFunc = new MenuFunc();
    private AtendimentoFunc atendimentoFunc = new AtendimentoFunc();
    private ChatFunc chatFunc = new ChatFunc();

    @Test(description = "REG.CALL.03.04.01 - Validar a apresenta��o de no maximo seis bot�es na tela inicial do CHAT")
    @Description("Pr� Requisito de Massa:" +
            "Ter conta next ativa status 5;\n" +
            "Ter dependente ativo.\n" +
            "Objetivo: Garantir que a Bia a intelig�ncia artificial do next, exiba no primeiro contato com o cliente apenas 6 op��es de atendimento.")

    @Severity(SeverityLevel.NORMAL)

    public void QA04273() throws Exception{

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarAjuda();

        chatFunc.acessarChatViaMenuAjuda();

        chatFunc.validarChatNenhumaOpcao(recuperarMassa("primeira resposta"), recuperarMassa("segunda resposta"), recuperarMassa("terceira resposta"));
    }

}
