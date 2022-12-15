package teste.mobile.regressivo.cartao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.cartao.fatura.PedirCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA03602 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    PedirCartaoFunc pedirCartaoFunc = new PedirCartaoFunc();

    @Test(description = "REG.CAR.04.01 � Contratar cart�o de cr�dito - Validar tela Oferta de Cart�es")
    @Description("Pr�-requisito\n" +
            "\n" +
            "Cliente precisa ter cart�o de debito e que esteja dispon�vel para possuir o cr�dito")
    @Severity(SeverityLevel.NORMAL)

    public void QA03602() throws Exception{

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarCartao();

        pedirCartaoFunc.validarTelaOfertaDeCartao();

    }
}
