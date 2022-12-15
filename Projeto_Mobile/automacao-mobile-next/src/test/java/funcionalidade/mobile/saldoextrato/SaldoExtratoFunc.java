package funcionalidade.mobile.saldoextrato;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.recarga.FormaPagamento;
import br.com.next.automacao.core.exception.NextException;
import constantes.pix.Mensagens;
import constantes.saldoextrato.Aba;
import constantes.saldoextrato.CategoriaTransacao;
import constantes.saldoextrato.TipoTransacao;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.pix.PixAgendadoTela;
import pagina.mobile.jornadas.saldoextrato.EditarTransaçãoTela;
import pagina.mobile.jornadas.saldoextrato.SaldoExtratoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SaldoExtratoFunc extends FuncionalidadeBase {


    /**
     * Validar transação de transferência agendada
     *
     * @throws Exception
     */
    public void validarUltimaTransferenciaAgendada() throws Exception {
        new SaldoExtratoTela(getDriver())
                .tocarUltimaTransferenciaAgendada()
                .validarTipoTransferenciaDataValor()
                .validarBotaoEditarVisivel()
                .validarBotaoDeletarVisivel();
    }

    /**
     * Acessar Todas as Movimentações
     *
     * @throws Exception
     */
    public void acessarTodasMovimentacoes() throws Exception {
        new SaldoExtratoTela(getDriver())
                .tocarBotaoTodasMovimentacoes();
    }

    /**
     * Validar Recarga
     *
     * @throws Exception
     */
    public void validarRecarga(FormaPagamento formaPagamento) throws Exception {
        switch (formaPagamento) {
            case CONTA_CORRENTE:
                new SaldoExtratoTela(getDriver())
                        .tocarBotaoContaCorrente()
                        .validarRecarga(formaPagamento);
                break;
            case CONTA_POUPANÇA:
                new SaldoExtratoTela(getDriver())
                        .tocarBotaoPoupanca()
                        .validarRecarga(formaPagamento);
                break;
        }
    }

    /**
     * Tocar Ícone Transações Futuras
     *
     * @throws Exception
     */
    public void tocarIconeTransacoesFuturas() throws Exception {
        new SaldoExtratoTela(getDriver())
                .tocarIconeTransacoesFuturas();
    }

    /**
     * Validar transação efetuada
     *
     * @throws Exception
     */
    public void validarTransacao(Aba aba, ThreadLocal valorArmazenado, CategoriaTransacao categoria, TipoTransacao tipo, String data) throws Exception {
        switch (aba) {
            case SAIDA:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaSaida();
                break;
            case TODAS:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaTodas();
                break;
        }
        new SaldoExtratoTela(getDriver())
                .expandirTransacaoPeloValor((String) valorArmazenado.get())
                .validarDadosTransacao((String) valorArmazenado.get(), categoria, tipo, data);
    }

    /**
     * Validar transação efetuada
     *
     * @throws Exception
     */
    public void validarTransacao(Aba aba, String valor, CategoriaTransacao categoria, TipoTransacao tipo, String data) throws Exception {
        switch (aba) {
            case SAIDA:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaSaida();
                break;
            case TODAS:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaTodas();
                break;
            case ENTRADA:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaEntrada();
                break;
            case FUTUROS:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaFuturos();
                break;
        }
        new SaldoExtratoTela(getDriver())
                .expandirTransacaoPeloValor(valor)
                .validarDadosTransacao(valor, categoria, tipo, data);
    }
    /**
     * Validar transação efetuada
     *
     * @throws Exception
     */
    public void validarTransacao(Aba aba, String valor, CategoriaTransacao categoria) throws Exception {
        switch (aba) {
            case FUTUROS:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaFuturos();
                break;
        }
        new SaldoExtratoTela(getDriver())
                .expandirTransacaoPeloValor(valor)
                .validarDadosTransacao(valor, categoria);
    }

    /**
     * Selecionar filtros de periodos em Poupança
     *
     * @throws Exception
     */
    public void navegarEntreOsFiltrosDaTransacaoPoupanca() throws Exception {
        new SaldoExtratoTela(getDriver())
                .validarTelaSaldoExtrato()
                .tocarBotaoPoupanca()
                .validarExibicaoConteudoExtrato()
                .tocarFiltroSeteDias()
                .validarExibicaoConteudoExtrato()
                .tocarFiltroQuinzeDias()
                .validarExibicaoConteudoExtrato()
                .tocarFiltroTrintaDias()
                .validarExibicaoConteudoExtrato();
    }

    /**
     * Navegar Entre Os Filtros Da Transação em Poupança
     *
     * @throws Exception
     */
    public void navegarEntreOsFiltrosEditarTransacaoPoupanca() throws Exception {
        new SaldoExtratoTela(getDriver())
                .validarTelaSaldoExtrato()
                .tocarBotaoExibirFiltros()
                .tocarAbaSaida()
                .validarExibicaoConteudoExtrato()
                .tocarBotaoExibirFiltros()
                .tocarBotaoPoupanca()
                .tocarBotaoExibirFiltros()
                .validarExibicaoConteudoExtrato()
                .tocarAbaEntrada()
                .tocarBotaoExibirFiltros()
                .validarExibicaoConteudoExtrato()
                .tocarSetaExpandirDetalhes()
                .tocarBotaoEditar();
        new EditarTransaçãoTela(getDriver())
                .validarTelaEditar()
                .tocarContinuar()
                .tocarConcluir()
                .validarMensagemAlteraçãoRealizadaComSucesso()
                .tocarBotaoOk();
        new SaldoExtratoTela(getDriver())
                .validarTelaSaldoExtrato();
    }

    /**
     * Navegar Entre Os Filtros Da Transação
     *
     * @throws NextException
     */
    public void navegarEntreOsFiltrosDaTransacao() throws Exception {
        new SaldoExtratoTela(getDriver())
                .validarTelaSaldoExtrato()
                .validarExibicaoConteudoExtrato()
                .tocarSetaExpandirDetalhesExibirFiltros()
                .tocarBotaoExibirFiltros()
                .tocarAbaEntrada()
                .validarExibicaoConteudoExtrato()
                .tocarAbaSaida()
                .validarExibicaoConteudoExtrato()
                .tocarAbaFuturos()
                .validarExibicaoConteudoExtrato();
    }

    /**
     * Valida Transação Efetuada
     *
     * @param valorExtrato
     * @throws Exception
     */
    public void validarTransacaoEfetuada(String valorExtrato) throws Exception {
        new SaldoExtratoTela(getDriver())
                .expandirTransacaoPeloValor(valorExtrato);
    }

    /**
     * Validar transação efetuada Na Aba Todas (Padrão)
     *
     * @throws Exception
     */
    public void validarTransacaoNaAbaTodas(String tituloExtrato, String valorExtrato) throws Exception {
        new SaldoExtratoTela(getDriver())
                .validarTelaSaldoExtrato()
                .validarExtrato(tituloExtrato, valorExtrato);
    }

    /**
     * Validar exclusão de agendamento
     *
     * @param formaPagamento    Forma de pagamento a ser selecionado (Conta Corrente ou Conta Poupança)
     * @param tipoTransacao     Tipo de transação a ser selecionado (PIX ou Aplicação)
     * @param valor             Valor da transação do agendamento
     * @throws Exception
     */
    public void excluirAgendamento(FormaPagamento formaPagamento, TipoTransacao tipoTransacao, String valor) throws Exception {
        switch (formaPagamento) {
            case CONTA_CORRENTE:
                new SaldoExtratoTela(getDriver())
                        .tocarBotaoContaCorrente();
                break;
        }
        switch (tipoTransacao){
            case PIX:
                new SaldoExtratoTela(getDriver())
                        .tocarAbaFuturos();
                new CarregamentoTela(getDriver())
                        .aguardarCarregamentoTela();
                new SaldoExtratoTela(getDriver())
                        .expandirTransacaoPeloValor(valor)
                        .tocarBotaoDeletarAgendamento();
                new PixAgendadoTela(getDriver())
                        .tocarBotaoSimExcluirAgendamento();
                new ValidaMensagensTela(getDriver())
                        .validarTodasAsMensagens(Mensagens.AGENDAMENTO_EXCLUIDO);
                new PixAgendadoTela(getDriver())
                        .tocarBotaoOk();
                break;
        }
    }
}
