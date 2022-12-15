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

    @Test(description = "REG.TRF.15.08.04 - Compartilhar a 2� via do comprovante da transfer�ncia banc�ria - Outra Pessoa - [Next - CP] para [Next - CP]")
    @Description("Descri��o (Objetivo):\n" +
            "Compartilhar comprovante transfer�ncia Outras Pessoas tipo INTERNO de conta corrente Next para conta poupan�a NEXT.\n" +
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
            "-REG.TRF.05.10 - Validar transfer�ncia - Outra Pessoa - Conta Corrente para Poupan�a - Next para Next - utilizando Grana de Emerg�ncia\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Compartilhar comprovante transfer�ncia Outras Pessoas tipo INTERNO de conta corrente Next para conta poupan�a NEXT.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00739(){

    }
}
