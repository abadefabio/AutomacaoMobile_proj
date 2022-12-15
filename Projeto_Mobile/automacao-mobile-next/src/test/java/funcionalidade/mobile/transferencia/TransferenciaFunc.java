package funcionalidade.mobile.transferencia;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import br.com.next.automacao.core.exception.NextException;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.ValorTransferencia;
import org.json.simple.JSONObject;
import pagina.mobile.jornadas.transferencia.InstrucoesTela;
import pagina.mobile.jornadas.transferencia.ListaInstituicoesTela;
import pagina.mobile.jornadas.transferencia.TecladoNextTela;
import pagina.mobile.jornadas.transferencia.TransferenciaTela;
import pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeuContatoContasTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela;
import pagina.mobile.jornadas.transferencia.para.outra.NovoContatoTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TransferenciaFunc extends FuncionalidadeBase {

    /**
     * Atualizar o objeto de dados do teste
     */
    public JSONObject atualizarValorTransferencia(JSONObject dados, ValorTransferencia valor) throws Exception {
        dados.put("valor", valor.toString());
        return dados;
    }

    /**
     * Fluxo para aceitar Teclado Next
     *
     * @throws Exception
     */
    public void tecladoNext() throws Exception {
        new TecladoNextTela(getDriver())
                .aceitarTecladoNext();
    }

    /**
     * Fluxo para aceitar Teclado Next
     *
     * @throws Exception
     */
    public void aceitarTecladoNext() throws Exception {
        new TecladoNextTela(getDriver())
                .aceitarTecladoNext();
    }

    /**
     * Fluxo para selecionar transferência para mim ou outra pessoa, incluindo fluxo de aceitar teclado Next
     *
     * @param transferirPara
     * @throws Exception
     */
    public void selecionarTransferirPara(TransferirPara transferirPara) throws Exception {
        new TecladoNextTela(getDriver())
                .aceitarTecladoNext();
        switch (transferirPara) {
            case MIM:
                new TransferenciaTela(getDriver())
                        .tocarBotaoParaMim();
                break;
            case OUTRA_PESSOA:
                new TransferenciaTela(getDriver())
                        .tocarBotaoOutraPessoa();
                break;
        }
    }

    /**
     * Fluxo para selecionar transferência para mim ou outra pessoa, incluindo fluxo de aceitar teclado Next
     *
     * @param transferirPara
     * @throws Exception
     */
    public void selecionarTransferirPara(String transferirPara) throws Exception {
        TransferirPara opcao = transferirPara.equals(TransferirPara.MIM.toString()) ? TransferirPara.MIM : TransferirPara.OUTRA_PESSOA;
        selecionarTransferirPara(opcao);
    }

    /**
     * Fluxo pra tocar no botão "fechar"
     *
     * @throws Exception
     */
    public void fecharTransferir() throws Exception {
        new TransferenciaTela(getDriver())
                .tocarFecharTransferir();
    }

    /**
     * Fluxo para encontrar conta na tela Minhas Contas
     *
     * @throws Exception
     */
    public void encontrarConta() throws Exception {
        new MinhasContasTela(getDriver())
                .encontrarConta();
    }

    /**
     * Fluxo para validar Ícone Informação
     *
     * @throws Exception
     */
    public void validarIconeInformacao() throws Exception {
        new TransferenciaTela(getDriver())
                .tocarIconeInformacao();
        new InstrucoesTela(getDriver())
                .validarExbicaoTituloTela()
                .validarExbicaoSaldoContaCorrente()
                .validarExbicaoSaldoPoupanca()
                .validarExibicaoAbaTED()
                .validarExbicaoAbaDOC()
                .validarExbicaoAbaNEXT()
                .tocarBotaoFechar();
    }

    /**
     * Fluxo pra tocar no botão "Nova Transferencia" Outra pessoa
     *
     * @throws Exception
     */
    public void iniciarNovaTransferencia() throws Exception {
        new TransferirTela(getDriver())
                .tocarBotaoNovaTransferencia();
    }

    /**
     * Fluxo pra tocar no botão "Nova Transferencia" Outra pessoa
     *
     * @throws Exception
     */
    public void novaTransferencia( ) throws Exception {
        new TransferirTela( getDriver() )
                .tocarBotaoNovaTransferencia();
        new TransferenciaTela( getDriver() )
                .tocarBotaoOutraPessoa();
    }

    /**
     * Pesquisar o contato criado via API para fazer a exclusão do mesmo
     *
     * @throws Exception
     */
    public void buscarContatoParaExcluir(String nome, String sobreNome) throws Exception{
        String nomeSobreNomeContato = nome + " "+ sobreNome;
        new MeusContatosTela(getDriver())
                .preencherBarraPesquisa(nomeSobreNomeContato)
                .pressionarIconeContato()
                .tocarExcluirContato();

    }

    /**
     * Clica no botão 'x' para voltar
     *
     * @throws Exception
     */
    public void voltarParaOMenu() throws NextException {
        new TransferenciaTela(getDriver())
                .tocarIconeVoltarParaMenu();
    }


    public void adicionarNovaConta(ContaPagamento dadosBancarios) throws Exception {
        new MeusContatosTela(getDriver())
                .tocarAdicionarConta();
        new TransferenciaTela(getDriver())
                .tocarBotaoInstituicaoDePagamento()
                .tocarBotaoBancoOuInstituicao();
        new ListaInstituicoesTela(getDriver())
                .pesquisarInstituicaoPagamento(dadosBancarios.recuperarBanco());

        new NovoContatoTela(getDriver())
                .informarAgencia(dadosBancarios.recuperarAgencia())
                .informarConta(dadosBancarios.recuperarConta())
                .tocarContinuar()
                .tocarBotaoHeaderFecharSomenteIos();

        new MeuContatoContasTela(getDriver())
                .tocarContaPagamentoAgenciaContatoSoAndroid(dadosBancarios.recuperarAgencia(), dadosBancarios.recuperarConta());

    }



    }
