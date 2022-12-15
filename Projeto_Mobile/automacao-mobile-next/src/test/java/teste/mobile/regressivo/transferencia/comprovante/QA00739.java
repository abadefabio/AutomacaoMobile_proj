package teste.mobile.regressivo.transferencia.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00739 extends TesteBase {

    @Test(description = "REG.TRF.15.08.04 - Compartilhar a 2ª via do comprovante da transferência bancária - Outra Pessoa - [Next - CP] para [Next - CP]")
    @Description("Descrição (Objetivo):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo INTERNO de conta corrente Next para conta poupança NEXT.\n" +
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
            "-REG.TRF.05.10 - Validar transferência - Outra Pessoa - Conta Corrente para Poupança - Next para Next - utilizando Grana de Emergência\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Compartilhar comprovante transferência Outras Pessoas tipo INTERNO de conta corrente Next para conta poupança NEXT.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00739(){

    }
}
