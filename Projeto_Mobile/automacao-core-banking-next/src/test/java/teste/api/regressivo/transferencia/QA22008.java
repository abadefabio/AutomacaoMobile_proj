package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import constantes.CodigosRetorno;
import funcionalidade.transferencia.FundosFunc;
import funcionalidade.transferencia.ListarContatoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.massa.conta.ConsultaConta.consultaConta;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA22008 extends TesteBase {
    FundosFunc fundosFunc = new FundosFunc();

    @Test(description = "Validar cliente tem fundos suficientes para uma transferência")
    @Description("VALIDAR MENSAGEM DE RETORNO")
    @Severity(SeverityLevel.NORMAL)


    public void QA22008() throws Exception {
        consultaConta(TipoConta.CONTA_NEXT_CPF, recuperarMassa(JSON.CPF));

        fundosFunc.listarFundosSaldoSuficiente(recuperarMassa(JSON.CPF));

        fundosFunc.validarFundosSaldoSuficiente(CodigosRetorno.OK.getCodigo());



    }


}
