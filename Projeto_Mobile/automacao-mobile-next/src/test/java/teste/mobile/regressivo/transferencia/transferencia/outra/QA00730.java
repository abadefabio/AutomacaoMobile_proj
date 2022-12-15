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

    @Test(description = "REG.TRF.15.05.04 - Validar TRANSFER�NCIA - Outra Pessoa - Conta Corrente para Poupan�a - Next para Next - Sem saldo e com Grana de emerg�ncia")
    @Description("Descri��o (Objetivo):\n" +
            "Validar TRANSFER�NCIA - Outra Pessoa - Conta Corrente para Poupan�a - Next para Next - utilizando Grana de Emerg�ncia.\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados..\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa Next.\n" +
            "Obter saldo;\n" +
            "Obter grana de Emerg�ncia.\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "TRANSFER�NCIA - Outra Pessoa - Conta Corrente para Poupan�a - Next para Next - utilizando Grana de Emerg�ncia.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00730(){

    }
}
