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

    @Test(description = "REG.TRF.15.05.08 - Validar TRANSFERÊNCIA - Outra Pessoa - Duas Transferências de mesmo valor para Contatos diferentes")
    @Description("Descrição (Objetivo):\n" +
            "Validar transferência - Outra Pessoa - duas transferências de mesmo valor para contatos diferentes.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa.\n" +
            "Possuir saldo em conta.\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Validar transferência - Outra Pessoa - duas transferências de mesmo valor para contatos diferentes,com sucesso.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00734(){

    }
}
