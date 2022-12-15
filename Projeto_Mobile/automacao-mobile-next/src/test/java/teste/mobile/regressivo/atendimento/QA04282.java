package teste.mobile.regressivo.atendimento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.atendimento.TipoAcesso;
import constantes.atendimento.TitulosTelasRedirecionadas;
import funcionalidade.mobile.atendimento.AtendimentoFunc;
import funcionalidade.mobile.atendimento.ChatFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA04282 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private AtendimentoFunc atendimentoFunc = new AtendimentoFunc();
    private ChatFunc chatFunc = new ChatFunc();
    @Test(description = "REG.CALL.03.03.07 - Validar no chat redirecionamento do deeplink Notificações para a tela incial da funcionalidade.\t")
    @Description("Pré Requisito de Massa:\n" +
                    "Ter conta next ativa status 4 ou 5;\n" +
                     "não ter dependente ativo/inativo\n" +
                    " Objetivo: Garantir que a no chat da Bia a funcionalidade deeplink está direcionando o cliente para tela correta..")
    @Severity(SeverityLevel.NORMAL)

    public void QA04282() throws Exception{

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        atendimentoFunc.acessarChatNoMenuAjuda(TipoAcesso.SEM_DEPENDENTE,"");

        chatFunc.validarRedirecionamentoDeepLink(TitulosTelasRedirecionadas.NOTIFICACOES,recuperarMassa("deepLink"), recuperarMassa("textoDeepLink"));

    }

}
