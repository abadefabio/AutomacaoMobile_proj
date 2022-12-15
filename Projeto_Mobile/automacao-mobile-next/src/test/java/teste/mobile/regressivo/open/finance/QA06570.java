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
public class QA06570 extends TesteBase  {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    OpenFinanceFunc openFinance = new OpenFinanceFunc();

    @Test(description = "PBI.73295.75985.007.Encerrar consentimento enviado e voltar para a tela Open Finance via botão IR PARA OPEN FINANCE")
    @Description("Eu como gestor Next\n" +
            "Desejo disponibilizar um canal\n" +
            "Para o usuário gerenciar os consentimentos recebidos e enviados no Open Finance." +
            "1. Acesso à Internet;\n" +
            "2. Ter o APP NEXT instalado no celular;\n" +
            "3. Ter conta no NEXT;\n" +
            "4. Ter um ou mais consentimentos enviados e ativos nesta conta.")

    @Severity(SeverityLevel.NORMAL)
    public void QA06570() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarOpenFinance();

        openFinance.encerrarConsentimentoEnviado();
    }
}

