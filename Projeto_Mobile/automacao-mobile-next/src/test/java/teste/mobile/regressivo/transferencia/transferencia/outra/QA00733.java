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

    @Test(description = "REG.TRF.15.05.07 - Validar TRANSFERÊNCIA - Outra Pessoa - Conta Corrente - Instituição de Pagamento com valor acima de R$ 50.000,00 - Outros Bancos")
    @Description("Descrição (Objetivo):\n" +
            "\n" +
            "Validar a impossibilidade de efetuar transferência para Instituição de Pagamento acima de 50 mil.\n" +
            "Dados do teste (Massa necessária):\n" +
            "\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa.\n" +
            "Possuir saldo em conta.\n" +
            "Dependências:\n" +
            "\n" +
            "N/A.\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "\n" +
            "Validar a impossibilidade de efetuar transferência para Instituição de Pagamento acima de 50 mil.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00733(){

    }
}
