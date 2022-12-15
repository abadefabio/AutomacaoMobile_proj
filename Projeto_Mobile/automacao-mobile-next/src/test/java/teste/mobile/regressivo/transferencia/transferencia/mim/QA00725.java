package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00725 extends TesteBase {

    @Test(description = "REG.TRF.15.03.06 - Validar TRANSFERÊNCIA - Para mim - Conta Poupança Para Instituição de Pagamento - Outros Bancos")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Para mim - De Conta Poupança Para Instituição de Pagamento - Outros Bancos.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados conta pagto. - outros bancos\n" +
            "Possuir saldo em conta.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Para mim - De Conta Poupança Para Instituição de Pagamento - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00725(){

    }
}
