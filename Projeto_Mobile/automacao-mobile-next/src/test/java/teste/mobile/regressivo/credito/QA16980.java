package teste.mobile.regressivo.credito;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.credito.CreditoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.CREDITO)
public class QA16980 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();

    CreditoFunc credito = new CreditoFunc();


    @Test(description = "PBI-141423.03.09 – Cliente que contratou Grana de Emergência")
    @Description("EEu enquanto NEXT quero apresentar a funcionalidade de configuração de limite para os clientes Next que possuem limite do Crédito Flex”\n"+
    "Pré Requisito de Massa:" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA16980() throws Exception {
        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));
        menu.selecionarEmprestimos();
        credito.habilitarGranaEmergencia();
    }
}
