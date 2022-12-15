package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00727 extends TesteBase {

    @Test(description = "REG.TRF.15.05.02 - Validar TRANSFER�NCIA - Outra Pessoa - Conta corrente - Sem Saldo e Limite indispon�vel - PF Outros Bancos")
    @Description("Descri��o (Objetivo):\n" +
            "Validar TRANSFER�NCIA - Outra Pessoa - Conta corrente - cliente n�o possui saldo nem grana de emerg�ncia - PF Outros Bancos.\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.s.\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PJ)\n" +
            "N�o possuir saldo e grana de emerg�ncia.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "TRANSFER�NCIA - Outra Pessoa - Conta corrente - cliente n�o possui saldo nem grana de emerg�ncia - PF Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00727(){

    }
}
