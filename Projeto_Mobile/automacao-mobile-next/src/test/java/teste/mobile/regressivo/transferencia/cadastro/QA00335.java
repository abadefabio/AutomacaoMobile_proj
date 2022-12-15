package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00335 extends TesteBase {

    @Test(description = "REG.TRF.01.27 - Validar novo contato com informa��es de conta antiga autorizada")
    @Description("Objetivos: \n" +
            " Validar que ao criar um novo contato que j� foi autorizado uma vez, o mesmo n�o carrega as informa��es da transa��o anterior.\n" +
            " \n" +
            "Pr�-Requisitos:\n" +
            " Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir saldo em conta.\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            " N�o carregar informa��es da transi��o anterior.\n" +
            " \n" +
            "Evidencias necess�rias:\n" +
            "Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00335(){

    }
}
