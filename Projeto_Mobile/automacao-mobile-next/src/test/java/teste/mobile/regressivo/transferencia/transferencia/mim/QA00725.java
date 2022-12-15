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

    @Test(description = "REG.TRF.15.03.06 - Validar TRANSFER�NCIA - Para mim - Conta Poupan�a Para Institui��o de Pagamento - Outros Bancos")
    @Description("Descri��o (Objetivo):\n" +
            "Validar TRANSFER�NCIA - Para mim - De Conta Poupan�a Para Institui��o de Pagamento - Outros Bancos.\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados conta pagto. - outros bancos\n" +
            "Possuir saldo em conta.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "TRANSFER�NCIA - Para mim - De Conta Poupan�a Para Institui��o de Pagamento - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00725(){

    }
}
