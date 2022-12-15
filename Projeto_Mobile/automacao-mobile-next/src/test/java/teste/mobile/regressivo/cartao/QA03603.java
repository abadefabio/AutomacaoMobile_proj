package teste.mobile.regressivo.cartao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.cartao.fatura.OfertaDeCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA03603 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private OfertaDeCartaoFunc ofertaDeCartaoFunc = new OfertaDeCartaoFunc();

    @Test(description = "REG.CAR.04.02 � Incluir a op��o �Pedir cart�o de cr�dito� dentro do menu cart�o de d�bito")
    @Description("Pr� condi��o: n/a" +
                 "Objetivo: n/a")
    @Severity(SeverityLevel.NORMAL)

    public void QA03603() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarCartao();

        ofertaDeCartaoFunc.validarTelaOfertaDeCartao();

    }

}
