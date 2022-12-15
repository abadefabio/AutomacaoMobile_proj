package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.*;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegundaViaCartaoFunc extends FuncionalidadeBase {

    /**
     * Método para acessar configuracoes
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
     *Validar não ter opção 'Solicitar 2ª via'
     *
     */
    public void validarNaoTerOpcaoSolicitarSegundaVia() throws Exception{
        new ConfiguracoesCartaoTela(getDriver())
                .validarTelaConfiguracoesCartao()
                .validarSolicitarSegundaVia();
    }

    /**
     *Tocar botão "USAR ESTE ENDEREÇO"
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

