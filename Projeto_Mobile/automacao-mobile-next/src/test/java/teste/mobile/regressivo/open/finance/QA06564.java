package teste.mobile.regressivo.open.finance;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.open.finance.OpenFinanceFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OPEN_FINANCE)
public class QA06564 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    OpenFinanceFunc openFinance = new OpenFinanceFunc();

    @Test(description = "PBI.73295.75972.001.Consultar dados enviados de um consentimento ativo TODOS OS DADOS")
    @Description("Eu como gestor Next\n" +
            "Desejo disponibilizar um canal\n" +
            "Para o usuário gerenciar os consentimentos recebidos e enviados no Open Finance." +
            "1. Acesso à Internet;\n" +
            "2. Ter o APP NEXT instalado no celular;\n" +
            "3. Ter conta no NEXT;\n" +
            "4. Ter SOMENTE um ou mais consentimentos enviados nesta conta;\n" +
            "5. Massa de dados contendo dados de Cadastro, Conta, Cartão de crédito e Operações de crédito.")

    @Severity(SeverityLevel.NORMAL)
    public void QA06564() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarOpenFinance();

        openFinance.consultarDadosEnviadosConsentimentoAtivo();
    }
}
