package teste.api.regressivo.adesao.multibank;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.adesao.multibank.Config;
import dados.database.ContaMultibankBancoDados;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;



@Jornada(Jornadas.ADESAO)
public class QA16066 extends TesteBase {

    ContaMultibankBancoDados multibank = new ContaMultibankBancoDados();

    @Test(description = "Ades�o Joy Multibanco - Auditoria")
    @Description("Obter um CPF disponibilizado pelo Bradesco com at� 4 dependentes e realizar uma ades�o Joy com status 1 (em an�lise)\n" +
            "A massa seleciona um CPF Bradesco dispon�vel, em qualquer status, e realiza uma ades�o Joy Multibank, que dever� estar no status 1.")
    @Severity(SeverityLevel.NORMAL)

    public void QA16066() throws Exception {

        String cpfDependente = (String) recuperarMassa("cpfDependente");
        String cpfResponsavel = (String) recuperarMassa("cpf");

        multibank.esperarOnBoardingStatus(
                cpfDependente,
                Config.STATUS_ONBOARDING_ESPERADO,
                Config.TIMEOUT_PADRAO_ESPERA_ONBOARDING
        );

        multibank.validarOnBoardingStatus(
                cpfDependente,
                cpfResponsavel,
                Config.STATUS_ONBOARDING_ESPERADO
        );


    }
}
