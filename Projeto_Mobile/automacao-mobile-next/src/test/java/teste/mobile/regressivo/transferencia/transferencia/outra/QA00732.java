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

    @Test(description = "REG.TRF.15.05.06 - Validar TRANSFERÊNCIA - Outra Pessoa - Instituição de Pagamento - Poupança - Bradescard - P")
    @Description("Descrição (Objetivo):\n" +
            "Validar transferência - Outra Pessoa - Instituição de Pagamento - Poupança - Bradescard\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados..\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados instituição de Pagto Outra Pessoa Bradesco.\n" +
            "Obter saldo;\n" +
            "Obter grana de Emergência.\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Transferência - Outra Pessoa - Instituição de Pagamento - Conta Corrente - Bradescard.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00732(){

    }
}
