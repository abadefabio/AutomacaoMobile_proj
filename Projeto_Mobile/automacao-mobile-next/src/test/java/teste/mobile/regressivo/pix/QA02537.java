package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.ConfirmeOsDados;
import constantes.pix.TipoConta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.PixCopiaColaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA02537 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PixCopiaColaFunc pixCopiaCola = new PixCopiaColaFunc();

    @Test(description = "REG.PIX.21.11.37 - Pagamento de QR Code Cobrança Copia e Cola com desconto e abatimento - Conta Poupança")
    @Description("Descrição:\n"
            + "Eu enquanto Aplicativo NEXT quero Pagar um QR Code/ Copia e cola Vencimento com Desconto e abatimento, antes da data de vencimento")

    @Severity(SeverityLevel.NORMAL)
    public void QA02537() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        pixCopiaCola.pagarQRCodeCobrancaCopiaCola(
                recuperarMassa("codigoPagamentoPix"),
                TipoConta.CONTA_POUPANCA.toString(),
                recuperarJSSONMassa("validarDados"),
                ConfirmeOsDados.CAMPOS_DESCONTO_ABATIMENTO);
    }
}
