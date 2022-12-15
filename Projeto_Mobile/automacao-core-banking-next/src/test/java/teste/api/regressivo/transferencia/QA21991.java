package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import constantes.CodigosRetorno;
import constantes.TiposDeConta;
import funcionalidade.transferencia.ListarContatoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.conta.ConsultaConta.consultaConta;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21991 extends TesteBase {

    private ListarContatoFunc listarContatoFunc = new ListarContatoFunc();

    @Test(description = "Lista de contatos recentes com transferência recente com resultado")
    @Description("VALIDAR MENSAGEM DE RETORNO")

    @Severity(SeverityLevel.NORMAL)

    public void QA21991() throws Exception {
        consultaConta(TipoConta.CONTA_NEXT_CPF, recuperarMassa(JSON.CPF));
        listarContatoFunc.listarContatosDeTransferenciasFeitasRecentes(recuperarMassa(JSON.CPF));
        listarContatoFunc.validarListaContatosTransferenciasRecentesComResultado(CodigosRetorno.OK.getCodigo(), TiposDeConta.CONTA_PAGAMENTO,
                recuperarMassa("numeroTelefone"),
                recuperarMassa("email"),
                recuperarMassa("cpfCnpjContato"),
                recuperarMassa("codigoAgencia"),
                recuperarMassa("contaPagamento"),
                recuperarMassa("nomeInstituicao")
        );
    }
}
