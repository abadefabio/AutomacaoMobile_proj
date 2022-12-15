package teste.mobile.regressivo.transferencia.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00738 extends TesteBase {

    @Test(description = "REG.TRF.15.08.03 - Compartilhar a 2ª via do comprovante PDF de - Outra Pessoa - [Next - CP] para [Bradesco - CC]")
    @Description("Descrição (Objetivo):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo INTERNO de conta corrente Next para conta corrente Bradesco.\n" +
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
            "-REG.TRF.05.22 - Validar TRANSFERÊNCIA - Outra Pessoa - Conta Corrente para Conta Corrente - Next AG.3728 para Next AG.3728\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo INTERNO de conta corrente Next para conta poupança Bradesco.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00738(){

    }
}
