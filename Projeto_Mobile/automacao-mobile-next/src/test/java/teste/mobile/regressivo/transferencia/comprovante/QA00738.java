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

    @Test(description = "REG.TRF.15.08.03 - Compartilhar a 2� via do comprovante PDF de - Outra Pessoa - [Next - CP] para [Bradesco - CC]")
    @Description("Descri��o (Objetivo):\n" +
            "Compartilhar comprovante transfer�ncia Outras Pessoas tipo INTERNO de conta corrente Next para conta corrente Bradesco.\n" +
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
            "-REG.TRF.05.22 - Validar TRANSFER�NCIA - Outra Pessoa - Conta Corrente para Conta Corrente - Next AG.3728 para Next AG.3728\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Compartilhar comprovante transfer�ncia Outras Pessoas tipo INTERNO de conta corrente Next para conta poupan�a Bradesco.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00738(){

    }
}
