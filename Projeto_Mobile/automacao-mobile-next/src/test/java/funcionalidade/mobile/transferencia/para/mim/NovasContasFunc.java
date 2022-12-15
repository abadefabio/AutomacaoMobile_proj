package funcionalidade.mobile.transferencia.para.mim;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.jornadas.transferencia.ListaInstituicoesTela;
import pagina.mobile.jornadas.transferencia.TransferenciaTela;
import pagina.mobile.jornadas.transferencia.para.mim.NovaContaTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela;
import pagina.mobile.comum.next.PopUpTela;

public class NovasContasFunc extends FuncionalidadeBase {

    /**
     * Preencher os campos da tela Cadastro nova conta de instituição de pagamento
     *
     * @param instituicao - Enum com o nome da instituição a ser selecionada
     * @throws Exception
     */
    public void preencherCamposCadastroNovaContaIstituicaoPagamento(Enum instituicao) throws Exception {
        new NovaContaTela(getDriver())
                .selecionarRadioInstituicaoDePagamento()
                .tocarCaixaSelecaoInstituicao();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(instituicao.toString());
        new NovaContaTela(getDriver())
                .validarInstituicaoPagamentoSelecionado(instituicao)
                .informarContaPagamento();
    }

    /**
     * Tocar no SwitchTED e validar se o switch permanece ativo
     *
     * @throws Exception
     */
    public void validarSituacaoSwitchContaAutorizadaTed() throws Exception {
        new NovaContaTela(getDriver())
                .validarTedObrigatorio();
    }

    /**
     * Tocar no Salvar e validar a alteração feita no contato
     *
     * @throws Exception
     */
    public void salvarAlteracaoSwitchValidarContato(Enum mensagem) throws Exception {
        new NovaContaTela(getDriver())
                .tocarBotaoSalvar();
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
        new MeusContatosTela(getDriver())
                .tocarBotaoFechar();
        new TransferenciaTela( getDriver() )
                .tocarBotaoOutraPessoa();
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa()
                .validarPresencaContato(true);
    }
}
