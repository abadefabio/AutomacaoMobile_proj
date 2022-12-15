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

    @Test(description = "REG.TRF.15.08.01 - Compartilhar a 2ª via do comprovante PDF de [TED - Pra Mim - Inst. Pagamento] CC")
    @Description("Descrição (Objetivo):\n" +
            "Compartilhar comprovante transferência Para Mim Instituição de Pagamento tipo TED de conta corrente Next para conta Corrente Instituição filiada ao Bradesco.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "-N/A\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato cadastrado para realizar transferência;\n" +
            "Possuir saldo em conta.\n" +
            "Efetuar transferência necessaria para o teste descrito em Dependências.\n" +
            "\n" +
            "Dependências:\n" +
            "- REG.TRF.03.11 - Validar transferência - Para Mim - TED - Conta Corrente para Instituição de Pagamento - Bradescard\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Compartilhar comprovante transferência Para Mim Instituição de Pagamento tipo TED de conta corrente Next para conta Corrente Instituição filiada ao Bradesco.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00735(){

    }
}
