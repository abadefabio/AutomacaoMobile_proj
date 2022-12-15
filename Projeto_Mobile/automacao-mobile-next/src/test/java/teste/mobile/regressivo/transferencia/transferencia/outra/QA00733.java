package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00733 extends TesteBase {

    @Test(description = "REG.TRF.15.05.07 - Validar TRANSFER�NCIA - Outra Pessoa - Conta Corrente - Institui��o de Pagamento com valor acima de R$ 50.000,00 - Outros Bancos")
    @Description("Descri��o (Objetivo):\n" +
            "\n" +
            "Validar a impossibilidade de efetuar transfer�ncia para Institui��o de Pagamento acima de 50 mil.\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa.\n" +
            "Possuir saldo em conta.\n" +
            "Depend�ncias:\n" +
            "\n" +
            "N/A.\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "\n" +
            "Validar a impossibilidade de efetuar transfer�ncia para Institui��o de Pagamento acima de 50 mil.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00733(){

    }
}
