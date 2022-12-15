package funcionalidade.mobile.objetivos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoObjetivo;
import pagina.mobile.jornadas.objetivos.DetalhesTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.objetivos.criarObjetivo.*;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilDeInvestidorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class NovoObjetivoFunc extends FuncionalidadeBase {


    /**
     * Método para selecionar Tipo Objetivo
     *
     * @throws Exception
     */
    public void selecionarTipoObjetivo(TipoObjetivo tipoObjetivo) throws Exception {
        new SeuPerfilDeInvestidorTela(getDriver())
                .tocarCriarObjetivo();
        switch (tipoObjetivo) {
            case TIPO_OBJETIVO_CASA:
                new EscolhaSeuObjetivosTela(getDriver())
                        .tocarCardCasa();
                break;
            case TIPO_OBJETIVO_CELULAR:
                new EscolhaSeuObjetivosTela(getDriver())
                        .tocarCardCelular();
                break;
            case TIPO_OBJETIVO_PRODUTO:

                new EscolhaSeuObjetivosTela(getDriver())
                        .tocarCardProduto();
                break;
            default:
                return;
        }
    }

    /**
     * Método para preencher Nome Objetivo Caracter Especial e validar alerta
     *
     * @throws Exception
     */
    public void preencherNomeObjetivoCaracterEspecial(String texto, String nome, String alerta) throws Exception {
        new NomeObjetivoTela(getDriver())
                .validarTextoTelaNome(texto)
                .preencherNomeObjetivo(nome)
                .validarAlertaNomeInvalido(alerta);
    }

    /**
     * Método para efetuar Cadastro Novo Objetivo
     * fr
     * @throws Exception
     */
    public void efetuarCadastroNovoObjetivo(String nome, String msgQuantoPrecisa, String valor, String tipo) throws Exception {
        new NomeObjetivoTela(getDriver())
                .preencherNomeObjetivo(nome)
                .tocarBotaoContinuar();
        new ValorObjetivoTela(getDriver())
                .validarTextoQuantoPrecisa(msgQuantoPrecisa)
                .preencherValorObjetivo(valor)
                .tocarBotaoContinuar();
        new OlharPrazoParcelaTela(getDriver())
                .validarCampoValor()
                .tocarBotaoContinuar();
        new ProdutosTela(getDriver())
                .validarProdutoSimples()
                .tocarSelecionarProdutoSimples();
        new ConfirmeDadosObjetivoTela(getDriver())
                .validarTipoObjetivo(tipo)
                .validarNomeObjetivo(nome)
                .validarValorObjetivo(valor)
                .tocarSetaParaVerTermos();
        new TermosECondicoesTela(getDriver())
                .tocarSetaBaixoCima()
                .tocarBotaoVoltar();
        new ConfirmeDadosObjetivoTela(getDriver())
                .tocarCheckTermosCondicoes()
                .tocarBotaoCriarObjetivo();
        new ObjetivoCriadoTela(getDriver())
                .validarObjetivoCriado(MensagensObjetivos.MENSAGEM_OBJETIVO_CRIADO)
                .validarTextoSobreParcelaMensal(MensagensObjetivos.MENSAGEM_SOBRE_PARCELA_MENSAL)
                .validarTextoDebitoParcelaDiasUteis(MensagensObjetivos.MENSAGEM_DEBITO_PARCELA_DIAS_UTEIS)
                .validarTextoTerLimiteCredito(MensagensObjetivos.MENSAGEM_TER_LIMITE)
                .validarTextoSeEntarOutraCobraca(MensagensObjetivos.MENSAGEM_SE_ENTRAR_OUTRA_COBRANCA)
                .tocarBotaoVerObjetivo();
        new DetalhesTela(getDriver())
                .validarTextoDetahes()
                .validarPresencaSwitch()
                .verificarPresencaBotaoEditar()
                .validarTextoValorParcela(MensagensObjetivos.MENSAGEM_VALOR_PARCELA)
                .validarTextoDiaAplicacao(MensagensObjetivos.MENSAGEM_DIA_APLICACAO)
                .validarTextoTotalAplicado(MensagensObjetivos.MENSAGEM_TOTAL_APLICADO)
                .validarTextoResgatado(MensagensObjetivos.MENSAGEM_RESGATADO);
    }

    /**
     * Método tocar em Criar Objetivo e selecionar Descobrir perfil
     * fr
     * @throws Exception
     */
    public void selecionarDescobrirPerfil() throws Exception {
        new ObjetivosTela(getDriver())
                .validarTelaObjetivos()
                .tocarCriarObjetivo()
                .tocarBotaoDescobrindoSeuPerfil();
    }

    /**
     * Método para Criar um Objetivo
     * fr
     * @throws Exception
     */
    public void criarObjetivoSimples(String nome, String msgQuantoPrecisa, String valor, String tipo) throws Exception {
        new NomeObjetivoTela(getDriver())
                .preencherNomeObjetivo(nome)
                .tocarBotaoContinuar();
        new ValorObjetivoTela(getDriver())
                .validarTextoQuantoPrecisa(msgQuantoPrecisa)
                .preencherValorObjetivo(valor)
                .tocarBotaoContinuar();
        new OlharPrazoParcelaTela(getDriver())
                .validarCampoValor()
                .tocarBotaoContinuar();
        new ProdutosTela(getDriver())
                .validarProduto()
                .tocarBotaoSaibaMais()
                .validarSobreOProduto()
                .tocarBotaoBaixarDocumentos()
                .tocarBotaoDemonstracaoDesempenho()
                .validarTelaDemonstracaoDesempenho()
                .validarCardDesempenho()
                .validarBotaoCompartilhar()
                .tocarBotaoFechar()
                .tocarBotaoVoltar()
                .tocarSelecionarProduto();
        new ConfirmeDadosObjetivoTela(getDriver())
                .tocarCheckTermosCondicoes()
                .tocarBotaoCriarObjetivo();
        new ObjetivoCriadoTela(getDriver())
                .validarObjetivoCriado(MensagensObjetivos.MENSAGEM_OBJETIVO_CRIADO)
                .validarTextoSobreParcelaMensal(MensagensObjetivos.MENSAGEM_SOBRE_PARCELA_MENSAL)
                .validarTextoDebitoParcelaDiasUteis(MensagensObjetivos.MENSAGEM_DEBITO_PARCELA_DIAS_UTEIS)
                .validarTextoTerLimiteCredito(MensagensObjetivos.MENSAGEM_TER_LIMITE)
                .validarTextoSeEntarOutraCobraca(MensagensObjetivos.MENSAGEM_SE_ENTRAR_OUTRA_COBRANCA)
                .tocarBotaoVerObjetivo();
        new DetalhesTela(getDriver())
                .validarTextoDetahes()
                .validarPresencaSwitch()
                .verificarPresencaBotaoEditar()
                .validarTextoValorParcela(MensagensObjetivos.MENSAGEM_VALOR_PARCELA)
                .validarTextoDiaAplicacao(MensagensObjetivos.MENSAGEM_DIA_APLICACAO)
                .validarTextoTotalAplicado(MensagensObjetivos.MENSAGEM_TOTAL_APLICADO)
                .validarTextoResgatado(MensagensObjetivos.MENSAGEM_RESGATADO);
        new ProdutosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Método para Criar um Objetivo NEXT MULTI_INDICES
     * fr
     * @throws Exception
     */
    public void criarObjetivoMultiIndices(String nome, String msgQuantoPrecisa, String valor, String tipo) throws Exception {
        new NomeObjetivoTela(getDriver())
                .preencherNomeObjetivo(nome)
                .tocarBotaoContinuar();
        new ValorObjetivoTela(getDriver())
                .validarTextoQuantoPrecisa(msgQuantoPrecisa)
                .preencherValorObjetivo(valor)
                .tocarBotaoContinuar();
        new OlharPrazoParcelaTela(getDriver())
                .validarCampoValor()
                .tocarBotaoContinuar();
        new ProdutosTela(getDriver())
                .validarProduto()
                .tocarBotaoSaibaMais()
                .validarSobreOProduto()
                .tocarBotaoBaixarDocumentos()
                .tocarBotaoDemonstracaoDesempenho()
                .validarTelaDemonstracaoDesempenho()
                .validarCardDesempenho()
                .validarBotaoCompartilhar()
                .tocarBotaoFechar()
                .tocarBotaoVoltar()
                .tocarSelecionarProduto()
                .tocarContinuarCriacao();
        new ConfirmeDadosObjetivoTela(getDriver())
                .tocarCheckTermosCondicoes()
                .tocarBotaoCriarObjetivo();
        new ObjetivoCriadoTela(getDriver())
                .validarObjetivoCriado(MensagensObjetivos.MENSAGEM_OBJETIVO_CRIADO)
                .validarTextoSobreParcelaMensal(MensagensObjetivos.MENSAGEM_SOBRE_PARCELA_MENSAL)
                .validarTextoDebitoParcelaDiasUteis(MensagensObjetivos.MENSAGEM_DEBITO_PARCELA_DIAS_UTEIS)
                .validarTextoTerLimiteCredito(MensagensObjetivos.MENSAGEM_TER_LIMITE)
                .validarTextoSeEntarOutraCobraca(MensagensObjetivos.MENSAGEM_SE_ENTRAR_OUTRA_COBRANCA)
                .tocarBotaoVerObjetivo();
        new DetalhesTela(getDriver())
                .validarTextoDetahes()
                .validarPresencaSwitch()
                .verificarPresencaBotaoEditar()
                .validarTextoValorParcela(MensagensObjetivos.MENSAGEM_VALOR_PARCELA)
                .validarTextoDiaAplicacao(MensagensObjetivos.MENSAGEM_DIA_APLICACAO)
                .validarTextoTotalAplicado(MensagensObjetivos.MENSAGEM_TOTAL_APLICADO)
                .validarTextoResgatado(MensagensObjetivos.MENSAGEM_RESGATADO);
        new ProdutosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Método para criar um NOVO Objetivo validando valores de parcelas minimo, acima da meta e comprometendo orçamento do cliente.
     *
     * @throws Exception
     */
    public void criarNovoObjetivoValidandoValoresDeParcelas(TipoObjetivo tipoObjetivo, String nomeObjetivo, String valorMinimo, String valorAcimaMeta, String valor, String valorParcela) throws Exception {
        new ObjetivosTela(getDriver())
                .verificarBotaoVerMeusObjetivosECriarEstaoPresentes()
                .tocarCriarObjetivo();
        switch (tipoObjetivo) {
            case TIPO_OBJETIVO_CASA:
                new EscolhaSeuObjetivosTela(getDriver())
                        .tocarCardCasa();
                break;
            case TIPO_OBJETIVO_CELULAR:
                new EscolhaSeuObjetivosTela(getDriver())
                        .tocarCardCelular();
            default:
                return;
        }
        new NomeObjetivoTela(getDriver())
                .preencherNomeObjetivo(nomeObjetivo)
                .tocarBotaoContinuar();
        new ValorObjetivoTela(getDriver())
                .preencherValorObjetivo(valorMinimo)
                .validarValorMinimoObjetivo()
                .preencherValorObjetivo(valor)
                .tocarBotaoContinuar();
        new ParcelaMensalTela(getDriver())
                .preencherValorParcelaMensal(valorMinimo)
                .validarValorMininoParcelaMensal()
                .preencherValorParcelaMensal(valorAcimaMeta)
                .validarValorAcimaMetaParcelaMensal()
                .preencherValorParcelaMensal(valor)
                .validarValorQueComprometeOrcamento()
                .preencherValorParcelaMensal(valorParcela)
                .tocarBotaoContinuar();
        new ProdutosTela(getDriver())
                .tocarSelecionarProdutoNextMultimercado();
        new ConfirmeDadosObjetivoTela(getDriver())
                .aguardarTelaConfirmeOsDados()
                .tocarCheckTermosCondicoes()
                .tocarBotaoCriarObjetivo();
        new ObjetivoCriadoTela(getDriver())
                .validarObjetivoCriado(MensagensObjetivos.MENSAGEM_OBJETIVO_CRIADO)
                .tocarBotaoVerObjetivo();
        new DetalhesTela(getDriver())
                .validarTextoDetahes();
    }
}
