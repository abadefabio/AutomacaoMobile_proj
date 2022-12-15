package funcionalidade.mobile.cartao.cancelamento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.atendimento.ChatTela;
import pagina.mobile.jornadas.cartao.cancelamento.AlterarMeuEnderecoTela;
import pagina.mobile.jornadas.cartao.fatura.CancelarCartaoTela;
import pagina.mobile.jornadas.cartao.fatura.CancelarPorEstarDanificadoTela;
import pagina.mobile.jornadas.cartao.fatura.CancelarPorRouboOuPerdaTela;
import pagina.mobile.jornadas.cartao.fatura.CancelarRouboPerdaTela;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ConfirmarEnderecoSegundaViaTela;
import pagina.mobile.jornadas.cartao.fatura.SegundaViaCancelamentoTela;
import pagina.mobile.jornadas.cartao.fatura.SegundaViaDeCartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CancelarCartaoFunc extends FuncionalidadeBase {

    /**
     * Método para Cancelar Cartao'
     *
     * @throws Exception
     */
    public void cancelarCartao() throws Exception {
        new CartaoTela(getDriver())
                .tocarCancelarCartao();
        new CancelarCartaoTela(getDriver())
                .tocarCancelarRouboPerda();
        new CancelarRouboPerdaTela(getDriver())
                .tocarIrParaChat();
    }

    /**
     * Método para Cancelar Cartao Credito e validar as mensagens que confirmam o cancelamento'
     *
     * @throws Exception
     */
    public void cancelarCartaoCredito() throws Exception {

        cancelarCartaoCreditoPorRouboOuPerda();

        new ConfirmarEnderecoSegundaViaTela(getDriver())
                .tocarUsarEsteEndereco();
        new SegundaViaDeCartaoTela(getDriver())
                .validarTelaSegundaViaDeCartao()
                .tocarOk();
        new CartaoTela(getDriver())
                .validarTextoSeuCartaoJaEstaSendoProduzido()
                .validarCartaoCancelado();
    }

    /**
     * Método para validar a mudança de endereço no momento do cancelamento do cartão de crédito'
     *
     * @throws Exception
     */
    public void mudarEnderecoCancelamentoCartaoCredito() throws Exception {

        cancelarCartaoCreditoPorRouboOuPerda();

        new ConfirmarEnderecoSegundaViaTela(getDriver())
                .tocarAlterarMeuEndereco();
        new AlterarMeuEnderecoTela(getDriver())
                .tocarIrParaChat();
        new ChatTela(getDriver())
                .validarTelaChat()
                .validarConversandoComBia();
    }

    private void cancelarCartaoCreditoPorRouboOuPerda() throws Exception {

        new CartaoTela(getDriver())
                .validarTelaCartao()
                .tocarBotaoSegundaViaCancelamento();
        new SegundaViaCancelamentoTela(getDriver())
                .validarTelaSegundaViaECancelamento()
                .tocarCancelarPorRouboOuPerda();
        new CancelarPorRouboOuPerdaTela(getDriver())
                .validarTelaCancelarPorRouboOuPerda()
                .tocarOkCancelar();
        new ConfirmarEnderecoSegundaViaTela(getDriver())
                .validarTelaConfirmarEnderecoDeSegundaVia();
    }


    /** Cancelar Cartao de Debito em Ir Para Chat
     *
     */
    public void cancelarCartaoDebitoIrParaChat() throws Exception {

        new CartaoTela(getDriver())
                .validarTelaCartao()
                .tocarBotaoSegundaViaCancelamento();

        new CancelarCartaoTela(getDriver())
                .validarTelaSegundaViaECancelamento()
                .tocarCancelarRouboPerda();

        new CancelarRouboPerdaTela(getDriver())
                .tocarBotaoVoltar();

        new CancelarCartaoTela(getDriver())
                .validarTelaSegundaViaECancelamento()
                .tocarCancelarRouboPerda();

        new CancelarRouboPerdaTela(getDriver())
                .tocarIrParaChat();

        new ChatTela(getDriver())
                .validarTelaChat();
    }

    /**
     * Método para validar o cancelamento de um cartao danificado, com 2 via em endereco atual
     *
     * @throws Exception
     */
    public void cancelarCartaoDanificadoComSegundaViaEmEnderecoAtual() throws Exception {
        new CartaoTela(getDriver())
                .validarTelaCartao()
                .tocarBotaoSegundaViaCancelamento();

        new CancelarCartaoTela(getDriver())
                .validarTelaSegundaViaECancelamento()
                .tocarCartaoDanificado();

        new CancelarPorEstarDanificadoTela(getDriver())
                .validarTelaCancelarPorEstarDanificado()
                .validarAvisosCancelamentoCartao()
                .tocarBotaoContinuar();

        new ConfirmarEnderecoSegundaViaTela(getDriver())
                .validarTelaConfirmarEnderecoDeSegundaVia()
                .tocarUsarEsteEndereco();
        new SegundaViaDeCartaoTela(getDriver())
                .validarTelaSegundaViaDeCartao()
                .tocarOk();
        new CartaoTela(getDriver())
                .validarTextoSeuCartaoJaEstaSendoProduzido()
                .validarCartaoDanificado();
    }
}
