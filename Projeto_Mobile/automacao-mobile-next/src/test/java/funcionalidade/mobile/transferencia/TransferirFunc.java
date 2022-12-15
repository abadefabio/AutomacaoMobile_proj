package funcionalidade.mobile.transferencia;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.gerarNomeAleatorio;

import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.MensagemValidacaoCamposTranferir;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.NomeTransferencia;
import constantes.transferencia.TipoDeConta;
import constantes.transferencia.TipoTransferencia;
import constantes.transferencia.TransferenciaMotivo;
import constantes.transferencia.ValorTransferencia;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.transferencia.confereDados.ConfereDadosTela;
import pagina.mobile.jornadas.transferencia.para.outra.MeuContatoContasTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferenciaAgendamentoTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferenciaComprovanteTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirConferirDadosTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirDataTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirMotivoTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirNomeTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirSelecionarMotivoTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTipoContaDestinoTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTipoContaTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirTipoTransferenciaTela;
import pagina.mobile.jornadas.transferencia.transferir.TransferirValorTela;
import pagina.mobile.comum.next.PopUpTela;

public class TransferirFunc extends FuncionalidadeBase {

    /**
     * Selecionar Conta-Corrente ou Poupança
     *
     * @param tipoDeConta
     * @throws Exception
     */
    public void selecionarTipoDeContaOrigem(TipoDeConta tipoDeConta) throws Exception {
        switch (tipoDeConta){
            case CONTA_CORRENTE:
                new TransferirTipoContaTela(getDriver())
                        .tocarRadioButtonContaCorrente()
                        .tocarBotaoContinuar();
                break;
            case CONTA_POUPANCA:
                new TransferirTipoContaTela(getDriver())
                        .tocarRadioButtonPoupanca()
                        .tocarBotaoContinuar();
                break;
        }
    }

    /**
     * Selecionar Conta-Corrente ou Poupança
     *
     * @param tipoDeConta
     * @throws Exception
     */
    public void verificarTipoDeContaOrigemEstaSelecionado(TipoDeConta tipoDeConta) throws Exception {
        switch (tipoDeConta){
            case CONTA_CORRENTE:
                new TransferirTipoContaTela(getDriver())
                        .verificarRadioButtonContaCorrenteSelecionado()
                        .tocarBotaoContinuar();
                break;
            case CONTA_POUPANCA:
                new TransferirTipoContaTela(getDriver())
                        .verificarRadioButtonContaPoupancaSelecionado()
                        .tocarBotaoContinuar();
                break;
        }
    }

    /**
     * Fluxo de informar Nome e Valor Transferência e motivo da transferencia e clicar em transferir
     *
     * @throws Exception
     */
    public void PreencherValorEMotivoTransferencia(String agencia) throws Exception {
        new TransferirTipoContaTela(getDriver())
                .tocarBotaoContinuar();
        new TransferirDataTela(getDriver())
                .validarTextoTelaDescricao()
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia()
                .tocarBotaoContinuar();
        preencherNomeTransferenciaEContinuar("");
        new TransferirTipoContaTela(getDriver())
                .tipoDeContaDescricao()
                .tocarBotaoContinuar();
        new TransferirTipoTransferenciaTela(getDriver())
                .tocarRadioButtonTED()
                .verificarTipoTransferencia()
                .tocarBotaoContinuar();
        new TransferirMotivoTela(getDriver())
                .tocarMotivo()
                .selecionarMotivo()
                .confirmarMotivo()
                .verificarPresencaBotaoContinuarClicar();
        new ConfereDadosTela(getDriver())
                .validarNomeContato()
                .validarAgenciaInformada(agencia)
                .tocarBotaoTransferir();
        new PopUpTela(getDriver())
                .tocarBotaoOk();
    }

    /**
     * Selecionar Conta-Corrente ou Poupança
     *
     * @param tipoDeConta
     * @throws Exception
     */
    public void selecionarTipoDeContaDestino(TipoDeConta tipoDeConta) throws Exception {
        switch (tipoDeConta){
            case CONTA_CORRENTE:
                new TransferirTipoContaDestinoTela(getDriver())
                        .tocarRadioButtonContaCorrente()
                        .tocarBotaoContinuar();
                break;
            case CONTA_POUPANCA:
                new TransferirTipoContaDestinoTela(getDriver())
                        .tocarRadioButtonPoupanca()
                        .tocarBotaoContinuar();
                break;
        }
    }

    /**
     * Selecionar meio de transferência para outros bancos
     * @param tipoTransferencia
     * @throws Exception
     */
    public void selecionarTipoTransferencia(TipoTransferencia tipoTransferencia) throws Exception {
        switch (tipoTransferencia) {
            case DOC:
                new TransferirTipoTransferenciaTela(getDriver())
                        .tocarRadioDoc()
                        .tocarBotaoContinuar();
                break;
            case TED:
                new TransferirTipoTransferenciaTela(getDriver())
                        .tocarRadioTed()
                        .tocarBotaoContinuar();
                break;
            case INTERNA:
                break;
        }
    }

    /**
     * Selecionar tipo de transferÃªncia para DOC quando o mesmo estiver invÃ¡lido
     *
     * @throws Exception
     */
    public void selecionarTipoTransferenciaDocInvalido() throws Exception {
        String imgAntes =  new TransferirTipoTransferenciaTela(getDriver())
                .recuperarHashElementoDOCImg();
        new TransferirTipoTransferenciaTela(getDriver())
                        .tocarRadioDoc();
        String imgDepois =  new TransferirTipoTransferenciaTela(getDriver())
                .recuperarHashElementoDOCImg();
        new TransferirTipoTransferenciaTela(getDriver())
                .validarDocNaoChecked(imgAntes,imgDepois);
    }

    /**
     * Selecionar meio de transferência para outros bancos
     *
     * @throws Exception
     */
    public void selecionarMotivoTransferencia(TransferenciaMotivo motivo) throws Exception {
        new TransferirMotivoTela(getDriver())
                .tocarBotaoEscolherMotivo();
        new TransferirSelecionarMotivoTela(getDriver())
                .tocarOpcaoMotivo(motivo.toString())
                .tocarBotaoConfirmar();
        new TransferirMotivoTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Selecionar meio de transferência para outros bancos
     *
     * @throws Exception
     */
    public void selecionarMotivoTransferencia(String motivo) throws Exception {
        new TransferirMotivoTela(getDriver())
                .tocarBotaoEscolherMotivo();
        new TransferirSelecionarMotivoTela(getDriver())
                .tocarOpcaoMotivo(motivo)
                .tocarBotaoConfirmar();
        new TransferirMotivoTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Iniciar o fluxo de agendamento e transferência
     *
     * @param data
     * @param conta
     * @throws Exception
     */
    public void iniciarAgendamentoTransferencia(String data, ContaPagamento conta) throws Exception {
        new TransferirDataTela(getDriver())
                .tocarBotaoData();
        new CalendarioTela(getDriver())
                .selecionarData(false, data)
                .tocarBotaoConfirmar();
        new TransferirDataTela(getDriver())
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(conta.recuperarValorTransferencia().recuperarValor());
        if (!new TransferirNomeTela(getDriver()).verificarCampoNomeTransferenciaPresente()) {
            new TransferirValorTela(getDriver())
                    .tocarBotaoContinuar();
        }
        preencherNomeTransferenciaEContinuar(conta.recuperarNomeTransferencia().recuperarNome());
        return;
    }

    private void preencherNomeTransferenciaEContinuar(String nome) throws Exception {
        if (nome != null && !nome.isEmpty()) {
            new TransferirNomeTela(getDriver())
                    .preencherNomeTransferencia(nome);
        }
        new TransferirNomeTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Iniciar o fluxo de agendamento e transferência validando o usa da grana de emergência
     *
     * @param data
     * @param conta
     * @throws Exception
     */
    public void iniciarAgendamentoTransferenciaComGranaDeEmergencia(String data, ContaPagamento conta) throws Exception {
        new TransferirDataTela(getDriver())
                .tocarBotaoData();
        new CalendarioTela(getDriver())
                .selecionarData(false, data)
                .tocarBotaoConfirmar();
        new TransferirDataTela(getDriver())
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(conta.recuperarValorTransferencia().recuperarValor(),
                        () -> {
                            new TransferirValorTela(getDriver())
                                        .validarLabelDeUsoGranaDeEmergencia();
                            return null;
                        });
        if (!new TransferirNomeTela(getDriver()).verificarCampoNomeTransferenciaPresente()) {
            new TransferirValorTela(getDriver())
                    .tocarBotaoContinuar();
        }
        preencherNomeTransferenciaEContinuar(conta.recuperarNomeTransferencia().recuperarNome());
    }

    /**
     * Efetuar transferência aceitando a data (pulando o passo de seleção de data)
     * Iniciar o fluxo de agendamento e transferência
     *
     * @throws Exception
     */
    public void iniciarAgendamentoTransferencia() throws Exception {
        new TransferirDataTela(getDriver())
                .tocarBotaoData();
        new CalendarioTela(getDriver())
                .selecionarData(false, DataAgendamento.PROXIMO_DIA_UTIL.toString())
                .tocarBotaoConfirmar();
        new TransferirValorTela(getDriver())
                .tocarBotaoContinuar()
                .preencherValorTransferencia();
        if (!new TransferirNomeTela(getDriver()).verificarCampoNomeTransferenciaPresente()) {
            new TransferirValorTela(getDriver())
                    .tocarBotaoContinuar();
        }
        preencherNomeTransferenciaEContinuar(gerarNomeAleatorio());
        new TransferirTipoContaDestinoTela(getDriver())
                .tocarRadioButtonContaCorrente()
                .tocarBotaoContinuar();
        new TransferirTipoTransferenciaTela(getDriver())
                .tocarRadioButtonTED()
                .tocarBotaoContinuar();
    }
    /**
     * Efetuar transferência aceitando a data (pulando o passo de seleção de data)
     *
     * @param conta
     * @throws Exception
     */
    public void iniciarTransferencia(ContaPagamento conta) throws Exception {
        new TransferirDataTela(getDriver())
                .armazenarValorBotaoData()
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(conta.recuperarValorTransferencia().recuperarValor())
                .tocarBotaoContinuar();
        preencherNomeTransferenciaEContinuar(conta.recuperarNomeTransferencia().recuperarNome());
    }

    /**
     * Validar comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarTransferir(String nome, String sobreNome,String cpf,String banco, String agencia, String conta,String tipoConta, String tipoTransferencia, String finalidade) throws Exception {
        new TransferirConferirDadosTela(getDriver())
                .ValidarCamposCortinaConfirmacaoAgendamento(nome,sobreNome,cpf,banco,agencia,conta,tipoConta,tipoTransferencia,finalidade)
                .tocarBotaoTransferir();
    }

    /**
     * Validar comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarTransferir(ContaPagamento contaPagamento) throws Exception {
        if (getDriver() instanceof IOSDriver) {
            new TransferirConferirDadosTela(getDriver())
            .rolaTelaBaixoCimaParaMontarDicionario();
        }
        new TransferirConferirDadosTela(getDriver())
                .validarCamposCortinaConfirmacaoAgendamento(contaPagamento)
                .tocarBotaoTransferir();
    }

    /**
     * Validar comprovante de agendamento
     * FR
     * @throws Exception
     */
    public void validarTransferir(JSONObject contaPagamento) throws Exception {
        new TransferirConferirDadosTela(getDriver())
                .validarCamposCortinaConfirmacaoAgendamento(contaPagamento)
                .tocarBotaoTransferir();
    }

    /**
     * Validar comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarTransferir(ContaPagamento contaPagamento, TransferenciaMotivo motivo) throws Exception {
        new TransferirConferirDadosTela(getDriver())
                .validarCamposCortinaConfirmacaoAgendamento(contaPagamento, motivo)
                .tocarBotaoTransferir();
    }

    /**
     * Validar comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarMensagemSucesso(MensagensEsperadas agendamento) throws Exception {
        new PopUpTela(getDriver())
                .validarMensagem(agendamento.toString())
                .tocarBotaoOk();
    }

    /**
     * Validar comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarComprovanteAgendamentoTransferencia() throws Exception {
        new TransferenciaAgendamentoTela(getDriver())
                .tocarBotaoVisualizar();
        new TransferenciaComprovanteTela(getDriver())
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .tocarBotaoPermitirCompartilhamento();
        new TransferenciaComprovanteTela(getDriver())
                .voltarAoComprovante()
                .tocarBotaoVoltarFechar();
        new TransferenciaAgendamentoTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Exibir faixa dropdown com resumo da conta
     *
     * @throws Exception
     */
    public void exibirFaixaDropdown() throws Exception {
        new TransferirTela(getDriver())
                .exibirFaixaDropDown();
    }

    /**
     * Ocultar faixa dropdown com resumo da conta
     *
     * @throws Exception
     */
    public void ocultarFaixaDropdown() throws Exception {
        new TransferirTela(getDriver())
                .ocultarFaixaDropdown();
    }

    /**
     * Selecionar data do agendamento da transferÃªncia
     *
     * @param data
     * @throws Exception
     */
    public void agendarTransferenciaPoupanca(DataAgendamento data) throws Exception {
        new TransferirDataTela(getDriver())
                .tocarBotaoData();
        new CalendarioTela(getDriver())
                .selecionarData(false, data.toString())
                .tocarBotaoConfirmar();
        new TransferirValorTela(getDriver())
                .tocarBotaoContinuar()
                .preencherValorTransferencia(ValorTransferencia.VALOR_ALEATORIO_100_A_500.recuperarValor());
        if (!new TransferirNomeTela(getDriver()).verificarCampoNomeTransferenciaPresente()) {
            new TransferirValorTela(getDriver())
                    .tocarBotaoProximo();
        }
        preencherNomeTransferenciaEContinuar("PARAMIMDOC");
        new TransferirTipoContaDestinoTela(getDriver())
                .tocarBotaoContinuar();
        new TransferirTipoTransferenciaTela(getDriver())
                .tocarRadioDoc()
                .tocarBotaoContinuar();
        new TransferirMotivoTela(getDriver())
                .tocarBotaoEscolherMotivo();
        new TransferirSelecionarMotivoTela(getDriver())
                .tocarOpcaoMotivo(TransferenciaMotivo.DOC_PARA_POUPANCA_COM_ESPACO_DUPLO.toString())
                .tocarBotaoConfirmar();
        new TransferirMotivoTela(getDriver())
                .tocarBotaoContinuar();
        new ConfereDadosTela(getDriver())
                .tocarBotaoTransferir();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA.toString())
                .tocarBotaoOk();
    }

    /**
     * Tocar em fechar (X) na tela Tranferir
     * @throws Exception
     */
    public void fecharTelaTransferir() throws Exception{
        new TransferirTela(getDriver())
                .tocarFechar();
    }

    public void validarCadastroConta(ContaPagamento dadosBancarios) throws Exception {
        new MeuContatoContasTela(getDriver())
                .validarAgenciaConta(dadosBancarios.recuperarAgencia(), dadosBancarios.recuperarConta());
    }

    /**
     * Validar a apresentação da Tela Tranferir
     * @throws Exception
     */
    public void validarTelaTranferir()  throws Exception{
        new TransferirTela(getDriver())
                .validarExibicaoTelaTransferir();
    }

    /**
     * Realizar agendamento de transferência de Conta Corrente para Instituição de Pagamento
     *
     * @param data
     * @throws Exception
     */
    public void agendarTransferenciaContaCorrenteParaInstituicaoPagamento(DataAgendamento data) throws Exception {
        new TransferirDataTela(getDriver())
                .tocarBotaoData();
        new CalendarioTela(getDriver())
                .selecionarData(false, data.toString())
                .tocarBotaoConfirmar();
        new TransferirValorTela(getDriver())
                .tocarBotaoContinuar()
                .preencherValorTransferencia(ValorTransferencia.VALOR_ALEATORIO_ATE_5000.recuperarValor());
        if (!new TransferirNomeTela(getDriver()).verificarCampoNomeTransferenciaPresente()) {
            new TransferirValorTela(getDriver())
                    .tocarBotaoContinuar();
        }
        preencherNomeTransferenciaEContinuar(NomeTransferencia.NOME_ALEATORIO_TIMESTAMP.recuperarNome());
        new TransferirTipoTransferenciaTela(getDriver())
                .verificarRadioButtonTedSelecionado()
                .tocarBotaoContinuar();
        new TransferirMotivoTela(getDriver())
                .tocarBotaoEscolherMotivo();
        new TransferirSelecionarMotivoTela(getDriver())
                .tocarOpcaoMotivo(TransferenciaMotivo.CREDITO_EM_CONTA_PG.toString())
                .tocarBotaoConfirmar();
        new TransferirMotivoTela(getDriver())
                .tocarBotaoContinuar();
        new ConfereDadosTela(getDriver())
                .tocarBotaoTransferir();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA.toString())
                .tocarBotaoOk();
    }

    /**
     * Selecionar data do agendamento da transferência
     *
     * @param data
     * @throws Exception
     */
    public void agendarTransferenciaPoupancaParaPoupanca(DataAgendamento data, ValorTransferencia valor) throws Exception {
        new TransferirDataTela(getDriver())
                .tocarBotaoData();
        new CalendarioTela(getDriver())
                .selecionarData(false, data.toString())
                .tocarBotaoConfirmar();
        new TransferirValorTela(getDriver())
                .tocarBotaoContinuar()
                .preencherValorTransferencia(valor.recuperarValor())
                .tocarBotaoProximo();
        preencherNomeTransferenciaEContinuar("");
        new TransferirTipoContaDestinoTela(getDriver())
                .tocarRadioButtonPoupanca()
                .tocarBotaoContinuar();
        new ConfereDadosTela(getDriver())
                .tocarBotaoTransferir();
        new PopUpTela(getDriver())
                .validarMensagem(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA.toString())
                .tocarBotaoOk();
    }

    /**
     * Validar a transferência para conta sem saldo
     *
     * @param conta
     * @param valorTransferencia
     * @throws Exception
     */
    public void validarTranferenciaSemSaldo(ContaPagamento conta, ValorTransferencia valorTransferencia) throws Exception {
        new TransferirDataTela(getDriver())
                .armazenarValorBotaoData()
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(valorTransferencia.recuperarValor())
                .tocarBotaoContinuar()
                .validarLabelSemSaldoParaTranferencia();
    }

    /**
     * Validar comprovante de agendamento
     *
     * @throws Exception
     */
    public void validarTelaComprovanteAgendamentoTransferencia() throws Exception {
        new TransferenciaAgendamentoTela(getDriver())
                .validarComprovanteLogo()
                .validarTituloTelaComprovanteAgendamento();
    }

    /**
     * Valida a transferÃªncia com valor acima do limite
     *
     * @param conta
     * @throws Exception
     */
    public void validarTransferenciaValorAcimaLimite(ContaPagamento conta) throws Exception {
        new TransferirDataTela(getDriver())
                .armazenarValorBotaoData()
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(conta.recuperarValorTransferencia().recuperarValor())
                .validarLabelValidacaoCampoValor(MensagemValidacaoCamposTranferir.MENSAGEM_VALOR_ACIMA_LIMITE)
                .apagarValorCampoValor()
                .preencherValorTransferencia(ValorTransferencia.VALOR_ALEATORIO_100_A_500.recuperarValor())
                .tocarBotaoContinuar();
        preencherNomeTransferenciaEContinuar(conta.recuperarNomeTransferencia().recuperarNome());
    }

    /**
     * Selecionar Conta-Corrente ou Poupança através de String no Param
     *
     * @param tipoDeConta
     * @throws Exception
     */
    public void selecionarTipoDeContaOrigemString(String tipoDeConta) throws Exception {

            if (TipoDeConta.CONTA_CORRENTE.toString().equals(tipoDeConta)) {
                new TransferirTipoContaTela(getDriver())
                        .tocarRadioButtonContaCorrente()
                        .tocarBotaoContinuar();
            }else {
                new TransferirTipoContaTela(getDriver())
                        .tocarRadioButtonPoupanca()
                        .tocarBotaoContinuar();
            }
    }

    /**
     * Efetuar transferência aceitando a data (pulando o passo de seleção de data) com Params String
     *
     * @param valor,nome
     * @throws Exception
     */
    public void iniciarTransferenciaString(String valor,String nome) throws Exception {
        new TransferirDataTela(getDriver())
                .armazenarValorBotaoData()
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(valor);
        if (!new TransferirNomeTela(getDriver()).verificarCampoNomeTransferenciaPresente()) {
            new TransferirValorTela(getDriver())
                    .tocarBotaoContinuar();
        }
        preencherNomeTransferenciaEContinuar(nome);
    }

    /**
     * Selecionar o tipo de conta destino da transferencia passado via param
     *
     * @param tipoDeConta
     * @throws Exception
     */
    public void selecionarTipoDeContaDestinoString(String tipoDeConta) throws Exception {

        if (TipoDeConta.CONTA_CORRENTE.toString().equals(tipoDeConta)) {
            new TransferirTipoContaDestinoTela(getDriver())
                    .tocarRadioButtonContaCorrente()
                    .tocarBotaoContinuar();
        }else {
            new TransferirTipoContaDestinoTela(getDriver())
                    .tocarRadioButtonPoupanca()
                    .tocarBotaoContinuar();
        }
    }

    public void deletarBanco(ContaPagamento dadosBancarios) throws Exception {

        new MeuContatoContasTela(getDriver())
                .tocarBotaoAcaoExtra()
                .validarAgenciaConta(dadosBancarios.recuperarAgencia(), dadosBancarios.recuperarConta())
                .tocarLixeiraContaPagamentoAgenciaContato(dadosBancarios.recuperarAgencia(), dadosBancarios.recuperarConta())
                .tocarBotaoSim();

    }

    /**
     * Efetuar transferência tipo Instituicao de pagamento conta poupança
     * fr
     * @param conta
     * @throws Exception
     */
    public void iniciarTransferenciaInstituicaoPagamento(ContaPagamento conta) throws Exception {
        new TransferirDataTela(getDriver())
                .armazenarValorBotaoData()
                .tocarBotaoContinuar();
        new TransferirValorTela(getDriver())
                .preencherValorTransferencia(conta.recuperarValorTransferencia().recuperarValor());
        if (getDriver() instanceof AndroidDriver) {
            new TransferirValorTela(getDriver())
                .tocarBotaoContinuar();
        }
        preencherNomeTransferenciaEContinuar(conta.recuperarNomeTransferencia().recuperarNome());
    }

    /**
     * Obter valor da transferência
     *
     * @throws Exception
     */
    public void obterValorDaTransferencia(ThreadLocal valorTransferência) throws Exception {
        new TransferirConferirDadosTela(getDriver())
                .obterValorDaTransferencia(valorTransferência);
    }
}
