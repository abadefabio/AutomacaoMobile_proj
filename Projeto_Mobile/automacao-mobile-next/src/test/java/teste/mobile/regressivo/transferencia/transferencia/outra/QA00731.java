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

    @Test(description = "REG.TRF.15.05.05 - Validar TRANSFER�NCIA - Outra Pessoa - DOC - Conta Corrente para Conta Corrente - Com valor acima do limite de R$ 4.999,99 - Outros Bancos - PF")
    @Description("Descri��o (Objetivo):\n" +
            "Validar transfer�ncia - Outra Pessoa - DOC - Valor SUPERIOR ao permitido - Conta Corrente para Conta Corrente - Outros Bancos - PF\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados..\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Obter saldo;\n" +
            "Obter grana de Emerg�ncia.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Transfer�ncia - Outra Pessoa - DOC - Valor SUPERIOR ao permitido - Conta Corrente para Conta Corrente - Outros Bancos - PF.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00731(){

    }
}
