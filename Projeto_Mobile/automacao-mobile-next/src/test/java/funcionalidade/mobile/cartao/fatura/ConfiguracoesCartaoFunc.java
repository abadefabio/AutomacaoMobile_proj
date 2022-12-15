package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ConfiguracoesCartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ConfiguracoesCartaoFunc extends FuncionalidadeBase {

    /**
     * M�todo para acessar configuracoes
     *
     */
    public void acessarConfiguracoesCartao() throws Exception{
        new CartaoTela(getDriver())
            .validarTelaCartao()
            .tocarConfiguracoesCartao();
        }

    /**
     *Validar n�o ter op��o 'Solicitar 2� via'
     *
     */
    public void validarNaoTerOpcaoSolicitarSegundaVia() throws Exception{
        new ConfiguracoesCartaoTela(getDriver())
                .validarTelaConfiguracoesCartao()
                .validarSolicitarSegundaVia();
    }
}
