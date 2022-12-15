package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00328 extends TesteBase {

    @Test(description = "REG.TRF.15.01.12 - Excluir Cadastro de Institui��o de Pagamento que tenha apenas uma conta no mesmo contato - Outra pessoa")
    @Description("Objetivos: \n" +
            "Realizar a exclus�o de um cadastro de institui��o de pagamento outra pessoa, com apenas uma conta. \n" +
            " \n" +
            "Pr�-Requisitos:\n" +
            " Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato de Institui��o de Pagamento cadastrado com apenas uma conta, para excluir o cadastro.\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            " Excluir o cadastro de Institui��o de Pagamento que tenha uma ou mais contas outra pessoa com sucesso. \n" +
            " \n" +
            "Evidencias necess�rias:\n" +
            "Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00328(){

    }
}