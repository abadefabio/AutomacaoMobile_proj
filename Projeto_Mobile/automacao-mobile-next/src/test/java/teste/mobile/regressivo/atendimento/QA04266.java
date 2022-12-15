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

@Jornada(Jornadas.ATENDIMENTO)
public class QA04266 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private AtendimentoFunc bubble = new AtendimentoFunc();
    private MenuFunc menu = new MenuFunc();
    private TelaAjudaFunc ajuda = new TelaAjudaFunc();

    @Test(description = "REG.CALL.03.01.01 - Validar histórico do cliente quando os arquivos recebidos e enviados não estão em cache")
    @Description("Pré Requisitos: " +
            "Ter conta ativa no next status 5.\n" +
            "Não ter dependentes cadastrados;\n" +
            "Ter histórico de chat com envio de PDF, JPEG e MP4 " +
            "Objetivo: Garantir que as mídias do histórico do chat estão sendo abertas sem cache no device.\n" +
            "\n" +
            "Restrição:\n" +
            "\n" +
            "Não fazer o envio dos arquivos na mesma execução.")
    @Severity(SeverityLevel.NORMAL)
    public void QA04266() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarAjuda();

        ajuda.visualizarArquivosChat(recuperarMassa("texto"));


    }
}
