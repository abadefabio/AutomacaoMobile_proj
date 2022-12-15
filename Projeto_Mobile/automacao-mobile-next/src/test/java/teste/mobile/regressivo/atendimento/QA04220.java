package teste.mobile.regressivo.atendimento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.atendimento.TipoAcesso;
import funcionalidade.mobile.atendimento.AtendimentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA04220 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private AtendimentoFunc bubble = new AtendimentoFunc();

    @Test(description = "REG.CALL.03.05.03 - Validar que ao segurar o bubble e arrastar para o X, o bubble desapareça")
    @Description("Pré condição: Ter conta next ativa status 4/5 Não possuir dependentes ativos/inativos " +
                 "Objetivo: Garantir a apresentação e encerramento do bubble.")
    @Severity(SeverityLevel.NORMAL)

    public void QA04220() throws Exception{

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        bubble.acessarChatNoMenuAjuda(TipoAcesso.SEM_DEPENDENTE,"");

        bubble.arrastarBubbleChatEFechar();

    }

}
