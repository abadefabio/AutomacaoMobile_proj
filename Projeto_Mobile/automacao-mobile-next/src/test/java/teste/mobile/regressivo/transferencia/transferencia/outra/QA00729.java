package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00729 extends TesteBase {

    @Test(description = "REG.TRF.15.05.03 - Validar TRANSFERÊNCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emergência - Outros Bancos - PJ")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emergência - Outros Bancos - PJ.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PJ)\n" +
            "Não possuir saldo;\n" +
            "Obter grana de emergência.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emergência - Outros Bancos - PJ.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00729(){

    }
}
