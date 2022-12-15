package teste.mobile.regressivo.cartao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.cartao.fatura.ReenvioDeCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA07285 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ReenvioDeCartaoFunc reenvioDeCartaoFunc = new ReenvioDeCartaoFunc();

    @Test(description = "PIB-79624.89296.001 – Melhorias Cartões - Incluir Botão – Reenvio do meu Cartão")
    @Description("Eu enquanto cliente quero poder desbloquear meu cartão que foi reemitido;" +
                 "*Ser cliente Next\n" +
                 "*Ter acesso ao APP Next\n" +
                 "*Estar logado no APP Next\n" +
                 "*Ter solicitado a 2° via do cartão")
    @Severity(SeverityLevel.NORMAL)

    public void QA07285() throws Exception{

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarCartao();

        reenvioDeCartaoFunc.validarTextoReenviodoCartao();

    }
}
