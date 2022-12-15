package teste.mobile.regressivo.atendimento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.atendimento.TitulosTelasRedirecionadas;
import funcionalidade.mobile.atendimento.ChatFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA04289 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ChatFunc chatFunc = new ChatFunc();

    @Test(description = "REG.CALL.03.03.14 - Validar no chat redirecionamento do deeplink Transfer?ncia para a tela incial da funcionalidade.")
    @Description("Pr? Requisito de Massa:\n" +
            "\n" +
            "Ter conta next ativa status 4 ou 5;\n" +
            "n?o ter dependente ativo/inativo\n" +
            " Objetivo: Garantir que a no chat da Bia a funcionalidade deeplink est? direcionando o cliente para tela correta.")
    @Severity(SeverityLevel.NORMAL)

    public void QA04289() throws Exception{

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarAjuda();

        chatFunc.acessarChatViaMenuAjuda();

        chatFunc.validarRedirecionamentoDeepLink(TitulosTelasRedirecionadas.TRANSFERENCIA, recuperarMassa("deepLink"), recuperarMassa("textoDeepLink"));
    }

}
