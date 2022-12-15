package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00731 extends TesteBase {

    @Test(description = "REG.TRF.15.05.05 - Validar TRANSFERÊNCIA - Outra Pessoa - DOC - Conta Corrente para Conta Corrente - Com valor acima do limite de R$ 4.999,99 - Outros Bancos - PF")
    @Description("Descrição (Objetivo):\n" +
            "Validar transferência - Outra Pessoa - DOC - Valor SUPERIOR ao permitido - Conta Corrente para Conta Corrente - Outros Bancos - PF\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados..\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Obter saldo;\n" +
            "Obter grana de Emergência.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Transferência - Outra Pessoa - DOC - Valor SUPERIOR ao permitido - Conta Corrente para Conta Corrente - Outros Bancos - PF.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00731(){

    }
}
