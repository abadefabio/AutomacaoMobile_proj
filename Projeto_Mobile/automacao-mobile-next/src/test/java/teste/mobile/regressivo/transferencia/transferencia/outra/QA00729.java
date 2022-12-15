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

    @Test(description = "REG.TRF.15.05.03 - Validar TRANSFER�NCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emerg�ncia - Outros Bancos - PJ")
    @Description("Descri��o (Objetivo):\n" +
            "Validar TRANSFER�NCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emerg�ncia - Outros Bancos - PJ.\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PJ)\n" +
            "N�o possuir saldo;\n" +
            "Obter grana de emerg�ncia.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "TRANSFER�NCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emerg�ncia - Outros Bancos - PJ.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00729(){

    }
}
