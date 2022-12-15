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

    @Test(description = "REG.TRF.01.27 - Validar novo contato com informações de conta antiga autorizada")
    @Description("Objetivos: \n" +
            " Validar que ao criar um novo contato que já foi autorizado uma vez, o mesmo não carrega as informações da transação anterior.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir saldo em conta.\n" +
            " \n" +
            "Pós-Condições:\n" +
            " Não carregar informações da transição anterior.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00335(){

    }
}
