package teste.mobile.regressivo.credito;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.credito.CreditoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CREDITO)
public class QA16981 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CreditoFunc credito = new CreditoFunc();

    @Test(description = "PBI-141423.03.10 - Cliente que contratou Empr�stimo Pessoal")
    @Description("Eu enquanto NEXT quero apresentar a funcionalidade de configura��o de limite para os clientes Next que possuem limite do Cr�dito Flex�\n" +
            "Pr� Requisito de Massa:" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA16981() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarEmprestimos();

        credito.habilitarCreditoPessoal();

    }

}
