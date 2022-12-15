package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00730 extends TesteBase {

    @Test(description = "REG.TRF.15.05.04 - Validar TRANSFERÊNCIA - Outra Pessoa - Conta Corrente para Poupança - Next para Next - Sem saldo e com Grana de emergência")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Outra Pessoa - Conta Corrente para Poupança - Next para Next - utilizando Grana de Emergência.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados..\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa Next.\n" +
            "Obter saldo;\n" +
            "Obter grana de Emergência.\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Outra Pessoa - Conta Corrente para Poupança - Next para Next - utilizando Grana de Emergência.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00730(){

    }
}
