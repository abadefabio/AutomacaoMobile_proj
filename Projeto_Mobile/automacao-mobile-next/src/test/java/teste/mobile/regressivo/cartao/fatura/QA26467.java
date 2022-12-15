package teste.mobile.regressivo.cartao.fatura;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cartao.CartaoVirtualVerComoFunciona;
import funcionalidade.mobile.cartao.fatura.PagamentosDigitaisFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA26467 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    PagamentosDigitaisFunc pagamentosDigitaisFunc = new PagamentosDigitaisFunc();

    @Test(description = "PBI 142281 - Ajuste na mensagem da tela da como usar – Ver como funciona")
    @Description("Eu enquanto cliente quero poder verificar com é o funcionamento do cartão virtual.")
    @Severity(SeverityLevel.NORMAL)

    public void QA26467() throws Exception {

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuFunc.selecionarCartao();

        pagamentosDigitaisFunc.validarTextoCartaoVirtual(
                CartaoVirtualVerComoFunciona.CADA_CARTAO_GERADO.toString(),
                CartaoVirtualVerComoFunciona.EXPIRAM_DEPOIS_72HORAS.toString(),
                CartaoVirtualVerComoFunciona.CVV_MUDA_TODA_VEZ.toString(),
                CartaoVirtualVerComoFunciona.SERVICOS_PARA_ASSINATURA.toString());
    }
}
