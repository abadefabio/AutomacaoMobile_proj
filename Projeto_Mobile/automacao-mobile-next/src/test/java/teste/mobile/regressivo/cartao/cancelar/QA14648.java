package teste.mobile.regressivo.cartao.cancelar;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.cartao.fatura.SegundaViaCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA14648 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    SegundaViaCartaoFunc segundaViaCartaoFunc = new SegundaViaCartaoFunc();


    @Test(description = "PBI 103718 - Pedir novo plástico com tecnologia NFC e melhoria da jornada de débito.")
    @Description("Eu como cliente quero visualizar a nova opção Solicitar cartão com aproximação no menu 2º VIA E CANCELAMENTO")
    @Severity(SeverityLevel.NORMAL)

    public void QA14648() throws Exception{

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarCartao();

        segundaViaCartaoFunc.solicitarSegundaViaAproximacao();

        segundaViaCartaoFunc.tocarBotaoUsarEsteEndereco();
    }
}
