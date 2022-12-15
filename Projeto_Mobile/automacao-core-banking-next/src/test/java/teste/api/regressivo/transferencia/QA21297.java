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
public class QA21297 extends TesteBase {

    private ListarContatoFunc listarContatoFunc = new ListarContatoFunc();

    @Test(description = " Listar contas de destinatário(PARA MIM)")
    @Description("VALIDAR MENSAGEM DE RETORNO")
    @Severity(SeverityLevel.NORMAL)
    public void QA21297() throws Exception {
        consultaConta(TipoConta.CONTA_NEXT_CPF, recuperarMassa(JSON.CPF));

        listarContatoFunc.listarContasDeDestinatários(recuperarMassa(JSON.CPF));

        listarContatoFunc.validarListaContasDestinatarioComResultado(
                CodigosRetorno.OK.getCodigo(),
                recuperarMassa(JSON.CPF),
                recuperarMassa(JSON.AGENCIA),
                recuperarMassa("conta"),
                recuperarMassa("nomeBanco")
        );
    }
}

