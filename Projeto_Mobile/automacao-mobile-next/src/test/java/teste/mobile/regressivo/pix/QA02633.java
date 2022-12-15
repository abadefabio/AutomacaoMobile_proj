package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.ExtratosEComprovantesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA02633 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ExtratosEComprovantesFunc extratosEComprovantesFunc = new ExtratosEComprovantesFunc();

    @Test(description = "REG.PIX.21.13.05 - Validar Detalhes - Transação Recebida E Transação Enviada - Menu PIX")
    @Description("CLIENTE NEXT pode realizar uma consulta de Extrato de CONTA-CORRENTE (07 dias) para visualizar a identidicação no lançamento PIX e os detalhes das transações PIX de operação enviada na tela \"TODAS\".\n" +
            "\n" +
            "Pré-Condições:\n" +
            "\n" +
            "- Cliente deve estar logado na tela principal do Next\n" +
            "NÃO deve ser o primeiro acesso do cliente\n" +
            "Extrato de conta corrente deve possuir ao menos duas transações Pix - Uma Operação enviada e Uma operação Recebida nos últimos 07 dias")

    @Severity(SeverityLevel.NORMAL)
    public void QA02633() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPix();
        extratosEComprovantesFunc.validarDetalhesTransacaoRecebidaEEnviadaPix();
    }
}
