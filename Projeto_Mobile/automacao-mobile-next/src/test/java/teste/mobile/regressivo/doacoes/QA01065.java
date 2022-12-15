package teste.mobile.regressivo.doacoes;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.doacoes.DoacoesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA01065 extends TesteBase{

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    DoacoesFunc doacoes = new DoacoesFunc();

    @Test(description = "PBI-76923.77035.004 - Validando acesso a opção Doações exibindo tela de apoio a uma instituição")
    @Description("Pré condição:\n" +
            "\n" +
            "Eu enquanto cliente quero visualizar a opção “Doações” para eu poder acessar o programa do Visa Causa e começar a participar com doações sem pagar nada por isso")

    @Severity(SeverityLevel.NORMAL)
    public void QA01065() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarDoacoes();

        doacoes.validarTelaApoioDoacoes();
    }
}
