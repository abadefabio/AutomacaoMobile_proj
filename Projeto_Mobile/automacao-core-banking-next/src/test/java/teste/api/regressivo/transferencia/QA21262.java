package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.transferencia.ListarContatoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.CodigosRetorno.OK;
import static constantes.TiposDeConta.CONTA_CORRENTE;


@Jornada(Jornadas.TRANSFERENCIA)
public class QA21262 extends TesteBase {

    private ListarContatoFunc listarContatoFunc = new ListarContatoFunc();

    @Test(description = "Lista de contatos a quem uma transferência foi feita com sucesso (incluindo os recentes)")
    @Description("VALIDAR MENSAGEM DE RETORNO")

    @Severity(SeverityLevel.NORMAL)

    public void QA21262() throws Exception {
        listarContatoFunc.listarContatosDeTransferenciasFeitas(recuperarMassa(JSON.CPF))
                .validarListaContatosTransferenciasComResultado(
                        OK.getCodigo(),
                        CONTA_CORRENTE,
                        recuperarMassa("telefoneContato"),
                        recuperarMassa("emailContato"),
                        recuperarMassa("cpfCnpjContato"),
                        recuperarMassa("agenciaContato"),
                        recuperarMassa("contaContato"),
                        recuperarMassa("codigoBancoContato"))
                .validarListaContatosTransferenciasRecentesComResultado(
                        OK.getCodigo(),
                        CONTA_CORRENTE,
                        recuperarMassa("telefoneContato"),
                        recuperarMassa("emailContato"),
                        recuperarMassa("cpfCnpjContato"),
                        recuperarMassa("agenciaContato"),
                        recuperarMassa("contaContato"),
                        recuperarMassa("codigoBancoContato"));
    }
}
