package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ConfiguracoesCartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ConfiguracoesCartaoFunc extends FuncionalidadeBase {

    /**
     * Método para acessar configuracoes
     *
     */
    public void acessarConfiguracoesCartao() throws Exception{
        new CartaoTela(getDriver())
            .validarTelaCartao()
            .tocarConfiguracoesCartao();
        }

    /**
     *Validar não ter opção 'Solicitar 2º via'
     *
     */
    public void validarNaoTerOpcaoSolicitarSegundaVia() throws Exception{
        new ConfiguracoesCartaoTela(getDriver())
                .validarTelaConfiguracoesCartao()
                .validarSolicitarSegundaVia();
    }
}
