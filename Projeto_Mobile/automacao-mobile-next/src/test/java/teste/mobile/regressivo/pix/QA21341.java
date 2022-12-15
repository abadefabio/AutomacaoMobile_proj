package teste.mobile.regressivo.pix;

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
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA21341 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PixCopiaColaFunc pixCopiaCola = new PixCopiaColaFunc();

    @Test(description = "PB.1070.US.70836.014 - Validar pagamento de QR Code Imediato com valor - Chave CPF - Conta corrente")
    @Description("Eu enquanto Cliente NEXT quero pagar um QR Code dinâmico imediatoObjetivo:\n" +
            "Validar pagamento de QR Code Imediato com valor - Chave CPF - Conta corrente\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "\n" +
            "Pré requisitos:\n" +
            "\n" +
            "Usuário deve estar logado no menu principal do NEXT;\n" +
            "Possuir uma massa de QR Code Imediato com valor gerado a partir de uma chave CPF;\n" +
            "Ter informado Nome do pagador e Regra ao pagar (Informações Adicionais) no QR Code gerado.\n" +
            "\n" +
            "Referência:\n" +
            "Código Jira: NEXT2-70836 - UserStory: US 01 – Gerar QR Code Dinâmico Imediato - modelo cobrança instantânea")

    @Severity(SeverityLevel.NORMAL)
    public void QA21341() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        pixCopiaCola.pagarQRCodeCobrancaCopiaColaInformacoesAdicionais(
                recuperarMassa("codigoPagamentoPix"),
                TipoConta.CONTA_CORRENTE.toString(),
                recuperarJSSONMassa("validarDados"),
                ConfirmeOsDados.CAMPOS_PIX_IMEDIATO);
    }
}
