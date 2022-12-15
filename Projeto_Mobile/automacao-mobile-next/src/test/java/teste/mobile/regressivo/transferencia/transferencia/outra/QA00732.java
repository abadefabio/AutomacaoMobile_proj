package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00732 extends TesteBase {

    @Test(description = "REG.TRF.15.05.06 - Validar TRANSFER�NCIA - Outra Pessoa - Institui��o de Pagamento - Poupan�a - Bradescard - P")
    @Description("Descri��o (Objetivo):\n" +
            "Validar transfer�ncia - Outra Pessoa - Institui��o de Pagamento - Poupan�a - Bradescard\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados..\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados institui��o de Pagto Outra Pessoa Bradesco.\n" +
            "Obter saldo;\n" +
            "Obter grana de Emerg�ncia.\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Transfer�ncia - Outra Pessoa - Institui��o de Pagamento - Conta Corrente - Bradescard.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00732(){

    }
}
