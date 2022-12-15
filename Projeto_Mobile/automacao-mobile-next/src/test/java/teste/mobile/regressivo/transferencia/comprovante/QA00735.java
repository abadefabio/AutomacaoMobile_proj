package teste.mobile.regressivo.transferencia.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00735 extends TesteBase {

    @Test(description = "REG.TRF.15.08.01 - Compartilhar a 2� via do comprovante PDF de [TED - Pra Mim - Inst. Pagamento] CC")
    @Description("Descri��o (Objetivo):\n" +
            "Compartilhar comprovante transfer�ncia Para Mim Institui��o de Pagamento tipo TED de conta corrente Next para conta Corrente Institui��o filiada ao Bradesco.\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "-N/A\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato cadastrado para realizar transfer�ncia;\n" +
            "Possuir saldo em conta.\n" +
            "Efetuar transfer�ncia necessaria para o teste descrito em Depend�ncias.\n" +
            "\n" +
            "Depend�ncias:\n" +
            "- REG.TRF.03.11 - Validar transfer�ncia - Para Mim - TED - Conta Corrente para Institui��o de Pagamento - Bradescard\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Compartilhar comprovante transfer�ncia Para Mim Institui��o de Pagamento tipo TED de conta corrente Next para conta Corrente Institui��o filiada ao Bradesco.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00735(){

    }
}
