package teste.mobile.regressivo.cartao.fatura;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;

import funcionalidade.mobile.cartao.fatura.FaturaFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.CARTOES)
public class QA03644 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private FaturaFunc fatura = new FaturaFunc();

    @Test(description = "PBI.77073.001 - Validara presentação do botão Gerar boleto para a fatura anterior entre corte e vencimento")
    @Description("Pré condição: Possuir Cartão de credito ativo." +
                 "Objetivo: Validar apresentação do botão Gerar boleto para a fatura.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03644() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarCartao();

        fatura.gerarBoletoFaturaAnterior();
    }
}
