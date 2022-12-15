package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pix.ConfirmeOsDados;
import constantes.pix.TipoConta;
import constantes.transferencia.DataAgendamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.PixCopiaColaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA04680 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PixCopiaColaFunc pixCopiaCola = new PixCopiaColaFunc();

    @Test(description = "PB.1070.US.77710.012 - Agendar pagamento de QR Code cobrança após o vencimento com juros e multa - Conta Poupança")
    @Description("Descrição:\n"
            + "Eu enquanto cliente NEXT\n" +
            "quero realizar um agendamento de pagamento por QR Code Cobrança no APP NEXTObjetivo:\n" +
            "Agendar pagamento de QR Code cobrança após o vencimento com juros e multa - Conta Poupança")

    @Severity(SeverityLevel.NORMAL)
    public void QA04680() throws Exception {
        JSONObject validarDados = recuperarJSSONMassa("validarDados");

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        pixCopiaCola.agendarQRCodeCobrancaCopiaCola(recuperarMassa("codigoPagamentoPix"), TipoConta.CONTA_POUPANCA.toString(), validarDados, ConfirmeOsDados.CAMPOS_JUROS_MULTA, DataAgendamento.PROXIMO_DIA_UTIL.toString());
    }
}
