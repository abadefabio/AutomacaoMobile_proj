package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import constantes.CodigosRetorno;
import funcionalidade.transferencia.ListarContatoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.conta.ConsultaConta.consultaConta;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21299 extends TesteBase {

    ListarContatoFunc listarContatoFunc = new ListarContatoFunc();

    @Test(description = "Lista de contatos(OUTRA PESSOA) a quem uma transferência foi feita sem resultado (incluindo os recentes)")
    @Description("VALIDAR MENSAGEM DE RETORNO")

    @Severity(SeverityLevel.NORMAL)

    public void QA21299() throws Exception {

        consultaConta(TipoConta.CONTA_NEXT_CPF, recuperarMassa(JSON.CPF));

        listarContatoFunc.listarContatosTransferenciaFeitaSemResultados(recuperarMassa(JSON.CPF));

        listarContatoFunc.validarListaContatosSemResultados(CodigosRetorno.OK.getCodigo());
    }
}
