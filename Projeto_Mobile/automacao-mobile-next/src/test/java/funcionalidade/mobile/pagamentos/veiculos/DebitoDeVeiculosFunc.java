package funcionalidade.mobile.pagamentos.veiculos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.veiculos.TipoDebito;
import constantes.pagamentos.veiculos.TipoPagamento;
import org.json.simple.JSONObject;
import pagina.mobile.jornadas.pagamentos.PagamentosTela;
import pagina.mobile.jornadas.pagamentos.comprovante.ComprovanteTela;
import pagina.mobile.jornadas.pagamentos.veiculos.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

public class DebitoDeVeiculosFunc extends FuncionalidadeBase {

    /**
     * Método executa fluxo de selecionar o tipo de pagamento por renavam desejado, preenchendo o campo revavam
     * Nesse método a data de pagamento é sempre a atrual (Se IPVA)
     * @param dadosVeiculo - objeto contendo as informações do veículo (renavam, estado, etc..)
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @throws Exception
     */
    public void escolherTipoPagamentoPreenchendoRenavam(JSONObject dadosVeiculo, TipoPagamento tipoPagamento, ThreadLocal valor) throws Exception {
        escolherTipoPagamentoPreenchendoRenavam((String)dadosVeiculo.get("estado"), (String)dadosVeiculo.get("renavam"),tipoPagamento,proximoDiaUtil(0), valor);
    }

    /**
     * Método executa fluxo de selecionar o tipo de pagamento por renavam desejado, preenchendo o campo revavam
     * Nesse método a data de pagamento é sempre a atrual (Se IPVA)
     * @param estado - estado do pagamento
     * @param renavam - renavam a ser consultado
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @throws Exception
     */
    public void escolherTipoPagamentoPreenchendoRenavam(String estado, String renavam, TipoPagamento tipoPagamento) throws Exception {
        escolherTipoPagamentoPreenchendoRenavam(estado, renavam,tipoPagamento,proximoDiaUtil(0), null);
    }

    /**
     * Método executa fluxo de selecionar o tipo de pagamento por renavam desejado, preenchendo o campo revavam
     * Nesse método a data de pagamento é sempre a atrual (Se IPVA)
     *
     * @param estado - estado do pagamento
     * @param renavam - renavam a ser consultado
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @param valor - objeto do teste que armazenará o valor da transação para validação futura
     * @throws Exception
     */
    public void escolherTipoPagamentoPreenchendoRenavam(String estado, String renavam, TipoPagamento tipoPagamento, ThreadLocal valor) throws Exception {
        escolherTipoPagamentoPreenchendoRenavam(estado, renavam,tipoPagamento,proximoDiaUtil(0), valor);
    }

    /**
     * Método executa fluxo de selecionar o tipo de pagamento por renavam desejado, preenchendo o campo revavam
     * Nesse método a data de pagamento é sempre a atrual (Se IPVA)
     *
     * @param estado - estado do pagamento
     * @param renavam - renavam a ser consultado
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @param data - data em que o pagamento será efetuado
     * @param valor - objeto do teste que armazenará o valor da transação para validação futura
     * @throws Exception
     */
    public void escolherTipoPagamentoPreenchendoRenavam(String estado, String renavam, TipoPagamento tipoPagamento,String data, ThreadLocal valor) throws Exception {
        new DebitoDeVeiculosTela(getDriver())
                .tocarComboBoxEstado();
        new SelecioneEstadoTela(getDriver())
                .tocarCampoEstado(estado)
                .tocarBotaoApply();
        new DebitoDeVeiculosTela(getDriver())
                .tocarComboBoxTipoDebito();
        new EscolhaTipoDebitoTela(getDriver())
                .tocarCampoTipoDebito(TipoDebito.DEBITOS_VIA_RENAVAM)
                .tocarBotaoApply();
        new DebitoDeVeiculosTela(getDriver())
                .preencherCampoRenavam(renavam)
                .tocarComboBoxTipoPagamento();
        new SelecioneTipoPagamentoTela(getDriver())
                .tocarCampoTipoPagamento(tipoPagamento)
                .tocarBotaoApply();
        switch(tipoPagamento){
            case MULTAS:
                new DebitoDeVeiculosTela(getDriver())
                        .tocarCheckBoxMulta()
                        .recuperarValorTotal(valor)
                        .tocarBotaoContinuar();
                new ConfirmacaoTela(getDriver())
                        .validarExibicaoTextoPagamento();
                break;
            case LICENCIAMENTO:
            case LICENCIAMENTO_REPETIDO:
                new DebitoDeVeiculosTela(getDriver())
                        .tocarBotaoContinuar();
                new AvisoImportanteTela(getDriver())
                        .validarMensagemAvisoImportante()
                        .tocarbotaoOKEntendi();
                new DebitoDeVeiculosTela(getDriver())
                        .tocarBotaoContinuar();
            case IPVA_ATUAL:
                if(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(data)){
                    new DebitoDeVeiculosTela(getDriver())
                            .tocarCheckBoxHojeOuProximoDiaUtil()
                            .tocarBotaoContinuar();
                }else{
                    new DebitoDeVeiculosTela(getDriver())
                            .tocarCheckBoxAgendar();
                    //ToDo: implementar fluxo agendamento
                }
                new ConfirmacaoTela(getDriver())
                        .validarExibicaoTextoPagamento();
            case TRANSFERENCIA:
                new DebitoDeVeiculosTela(getDriver())
                        .tocarBotaoContinuar();
                new ConfirmacaoTela(getDriver())
                        .validarExibicaoTextoPagamento()
                        .tocarBotaoConfirmar();
                break;
        }
    }

    /**
     * Método valida consistencia das informações na tela Confirmação e efetua o pagamento de débito de renavam já utilizado no NEXT
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @param valor - Valor do pagamento
     * @param renavam - número do renavam
     * @param tipoConta - Conta-Corrente ou Poupança
     * @throws Exception
     */
    public void efetuarPagamentoRevavamJaUtilizado(TipoPagamento tipoPagamento, String valor, String renavam, String tipoConta) throws Exception {
        efetuarPagamento(tipoPagamento, valor, renavam, TipoConta.recuperar(tipoConta));
    }

    /**
     * Método valida consistencia das informações na tela Confirmação e efetua o pagamento de débito de renavam já utilizado no NEXT
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @param valor - Valor do pagamento
     * @param renavam - número do renavam
     * @param tipoConta - Conta-Corrente ou Poupança
     * @throws Exception
     */
    public void efetuarPagamentoRevavamJaUtilizado(TipoPagamento tipoPagamento, String valor, String renavam, TipoConta tipoConta) throws Exception {
        efetuarPagamento(tipoPagamento, valor, renavam, tipoConta);
    }

    public void efetuarPagamento(TipoPagamento tipoPagamento, TipoConta tipoConta, JSONObject dadosVeiculo, String valor) throws Exception {
        efetuarPagamento(tipoPagamento, valor,(String)dadosVeiculo.get("renavam"), tipoConta);
    }

    /**
     * Método valida consistencia das informações na tela Confirmação e efetua o pagamento de débito de renavam
     * @param tipoPagamento - Tipo de pagamento a ser efetuado
     * @param valor - Valor do pagamento
     * @param renavam - número do renavam
     * @param tipoConta - Conta-Corrente ou Poupança
     * @throws Exception
     */
    private void efetuarPagamento(TipoPagamento tipoPagamento, String valor, String renavam, TipoConta tipoConta) throws Exception {
        ConfirmacaoTela confirmacaoTela = new ConfirmacaoTela(getDriver());
        Map<String, String> dicionarioPagamento = new HashMap<>();
        dicionarioPagamento.put("data do débito", proximoDiaUtil(0));
        dicionarioPagamento.put("tipo do pagamento", tipoPagamento.toString());
        confirmacaoTela
                .validarValorPagamento(valor)
                .validarCamposDadosDePagamento(dicionarioPagamento)
                .validarRenavamDoVeiculo(renavam)
                .validarValorTotal(valor);
        switch(tipoConta){
            case CONTA_POUPANCA:
                confirmacaoTela
                        .tocarTipoContaPagamento("poupança");
                break;
            default:
                break;
        }
        confirmacaoTela
                .tocarBotaoConfirmar();
        if (tipoPagamento != TipoPagamento.TRANSACAO_REPETIDA &&
                new AvisoTransacaoBemParecidaTela(getDriver())
                        .mensagemTransacaoRepetidaPresente()) {
            new AvisoTransacaoBemParecidaTela(getDriver())
                    .tocarBotaoContinuar();
        }
        switch(tipoPagamento){
            case MULTAS:
                new ComprovanteTela(getDriver())
                        .validarPresencaComprovanteTela();
                break;
            case LICENCIAMENTO:
                new PagamentosTela(getDriver())
                        .validarPresencaTelaPagamentos();
                break;
            case LICENCIAMENTO_REPETIDO:
            case IPVA_ATUAL:
                new AvisoPagamentoEmProcessamentoTela(getDriver())
                        .validarExibicaoTextoPagamentoEstaEmProcessamento()
                        .tocarNoBotaoOk();
                new PagamentosTela(getDriver())
                        .validarTelaPagamentos();
                break;
            case TRANSACAO_REPETIDA:
                new AvisoTransacaoBemParecidaTela(getDriver())
                        .validarTextoAgenteReparouQueVoceFezUmaTransacaoBemParecidaAEstaTemCertezaDeQueQuerContinuar()
                        .tocarBotaoContinuar();
                new AvisoPagamentoEmProcessamentoTela(getDriver())
                        .validarExibicaoTextoPagamentoEstaEmProcessamento()
                        .tocarNoBotaoOk();
        }
    }
}
