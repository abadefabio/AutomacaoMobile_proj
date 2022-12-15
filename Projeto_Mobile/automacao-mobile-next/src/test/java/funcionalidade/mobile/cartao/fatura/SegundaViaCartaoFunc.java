package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegundaViaCartaoFunc extends FuncionalidadeBase {

    /**
     * M�todo para acessar configuracoes
     *
     */
    public void solicitarSegundaViaAproximacao() throws Exception{
        new CartaoTela(getDriver())
                .validarTelaCartao()
                .tocarBotaoSegundaViaCancelamento();
        new SegundaViaCancelamentoTela(getDriver())
                .validarTelaSegundaViaECancelamento()
                .tocarSolicitarCartaoComAproximacao();
        new SolicitarCartaoComAproximacaoTela(getDriver())
                .validarTelaSolicitarCartaoComAproximacao();
        new SolicitarCartaoComAproximacaoTela(getDriver())
                .tocarBotaoContinuar();
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

    /**
     *Tocar bot�o "USAR ESTE ENDERE�O"
     *
     */
    public void tocarBotaoUsarEsteEndereco() throws Exception {
        new ConfirmarEnderecoSegundaViaTela(getDriver())
                .validarTelaConfirmarEnderecoDeSegundaVia()
                .tocarUsarEsteEndereco();
        new SegundaViaDeCartaoTela(getDriver())
                .validarTelaSegundaViaDeCartao()
                .tocarOk();
        new CartaoTela(getDriver())
                .validarTelaCartao();
    }
}

