package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00734 extends TesteBase {

    @Test(description = "REG.TRF.15.05.08 - Validar TRANSFER�NCIA - Outra Pessoa - Duas Transfer�ncias de mesmo valor para Contatos diferentes")
    @Description("Descri��o (Objetivo):\n" +
            "Validar transfer�ncia - Outra Pessoa - duas transfer�ncias de mesmo valor para contatos diferentes.\n" +
            "\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa.\n" +
            "Possuir saldo em conta.\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Validar transfer�ncia - Outra Pessoa - duas transfer�ncias de mesmo valor para contatos diferentes,com sucesso.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00734(){

    }
}
