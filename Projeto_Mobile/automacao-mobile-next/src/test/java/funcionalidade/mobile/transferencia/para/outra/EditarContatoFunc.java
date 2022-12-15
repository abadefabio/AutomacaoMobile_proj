package funcionalidade.mobile.transferencia.para.outra;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.transferencia.ContaPagamento;
import constantes.transferencia.MensagensEsperadas;
import pagina.mobile.jornadas.transferencia.ListaInstituicoesTela;
import pagina.mobile.jornadas.transferencia.para.outra.EditarContatoTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela;
import pagina.mobile.comum.next.PopUpTela;

public class EditarContatoFunc  extends FuncionalidadeBase {

    /**
     * Fluxo de Edição de Cadastro de Instituição de Pagamento
     *
     * @param conta - - Enum: constantes.transferencia.ContaPagamento
     * @throws Exception -
     */
    public void editarCadastroContato(ContaPagamento conta) throws Exception{
        switch(conta.recuperarTipoInstituicao()){
            case BANCO:
                new EditarContatoTela(getDriver())
                        .validarTelaEditarContato()
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
                new EditarContatoTela(getDriver())
                        .preencherCampoAgencia(conta.recuperarAgencia());
                break;
            case INSTITUICAO_DE_PAGAMENTO:
                new EditarContatoTela(getDriver())
                        .tocarRadioButtonInstituicaoPagamento()
                        .tocarSelecioneBanco();
                new ListaInstituicoesTela(getDriver())
                        .pesquisarInstituicaoPagamento(conta.recuperarBanco());
        }
        new EditarContatoTela(getDriver())
                .preencherCampoConta(conta.recuperarConta());
        this.salvarContatoValidarMensagem();
    }

    /**
     * Fluxo salvar e validar a mensagem de Sucesso na tela 'Editar Cadastro'
     * Salvar > Mensagem: 'Contato atualizado com sucesso' > OK
     *
     * @throws Exception -
     */
    private void salvarContatoValidarMensagem() throws Exception {

        new EditarContatoTela(getDriver())
                .tocarSalvar();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EDICAO.toString())
                .tocarBotaoOk();
        new MeusContatosTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Fluxo valida a mensagem: Quer mesmo deletar essa conta?
     * @throws Exception
     */
    private void confirmaMensagemExclusaoContato() throws Exception {
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_EXCLUSAO_CONTA.toString())
                .tocarBotaoSim();
    }
}
