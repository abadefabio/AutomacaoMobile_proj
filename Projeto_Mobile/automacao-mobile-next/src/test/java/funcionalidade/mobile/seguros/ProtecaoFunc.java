package funcionalidade.mobile.seguros;


import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.seguros.Protecao;
import constantes.seguros.ParticipantesProtecaoOdonto;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSecaoProtecao;
import pagina.mobile.jornadas.seguros.ProtecaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ProtecaoFunc extends FuncionalidadeBase {

    /**
     * Validar layout da tela Prote��o
     * contratados=false (nao possui card contratado)
     * @throws Exception
     */
    public void validarLayoutTelaProtecao(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutCardProtecao(tipoProtecao);

    }

    /**
     * Validar tela Prote��o
     * @throws Exception
     */
    public void validarTelaProtecao(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutCardProtecao(tipoProtecao);
    }

    /**
     * Toca no Menu Next (superior/esquerdo)
     *
     * @throws Exception
     */
    public void tocarMenuNext() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarMenuNext();
    }

    /**
     * selecionar Card Protecao Cartao Debito
     *
     * @throws Exception
     */
    public void selecionarCardProtecaoCartaoDebito() throws Exception {
        new ProtecaoTela(getDriver())
                .selecionarCardProtecaoCartaoDebito();
    }

    /**
     * selecionar Card Protecao Odonto
     *
     * @throws Exception
     */
    public void selecionarCardSegurosOdonto() throws Exception {
        new ProtecaoTela(getDriver())
                .selecionarCardSegurosOdonto();
    }

    /**
     * selecionar termo e condi��es Protecao Cartao Debito
     *
     * @throws Exception
     */
    public void selecionarTermoCondicoesCartaoDebito() throws Exception {
        new ProtecaoTela(getDriver())
                .aceitarTermosCondicoesCartaoDebito();
    }

    /**
     * clicar bot�o Contratar Protecao Cartao Debito
     *
     * @throws Exception
     */
    public void btnContratarProtecaoCartaoDebito() throws Exception {
        new ProtecaoTela(getDriver())
                .btnContratarProtecaoCartaoDebito();
    }

    /**
     * VALIDAR ContrataCAO Protecao Cartao Debito
     *
     * @throws Exception
     */
    public void validarProtecaoCartaoDebito() throws Exception {
        new ProtecaoTela(getDriver())
                .validarContratacaoProtecaoCartaoDebito();
    }

    /**
     * clicar Botao Concluir Contratacao Protecao Cartao Debito
     *
     * @throws Exception
     */
    public void clicarBotaoConcluirContratacaoProtecaoCartaoDebito() throws Exception {
        new ProtecaoTela(getDriver())
                .btnConcluirProtecaoCartaoDebito();
    }

    /**
     * Navegar at� o card "Odonto/Debito/Credito"
     *
     * @throws Exception
     */
    public void navegarCardProtecao(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .navegarCardProtecao(tipoProtecao);
    }

    /**
     * Validar Layout do card Seguro Cart�o (D�bito/Cr�dito)
     *
     * @throws Exception
     */
    public void tocarBotaoDetalhes() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoDetalhes();
    }

    /**
     * Validar Layout da tela Detalhe - Seguro Cart�o (D�bito/Cr�dito)
     *
     * @throws Exception
     */
    public void validarlayoutTelaDetalhes(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao, Protecao botao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarlayoutTelaDetalhes(tipoProtecao)
                .validarSecaoInformacoesSeguro(tipoSecaoProtecao, tipoProtecao, botao);
    }

    /**
     * Tocar no bot�o Contratar - tela seguro/detalhe
     *
     * @throws Exception
     */
    public void tocarBotaoContratarTelaDetalhes(Protecao botao) throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoContratarTelaDetalhes(botao);

    }

    /**
     * Validar tela Termos e Condi��es de prote��o
     *
     * @throws Exception
     */
    public void validarTelaTermosCondicoes(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarTelaTermosCondicoes(tipoProtecao);
    }

    /**
     * Tocar na check box "Li e aceito os termos e condi��es"
     *
     * @throws Exception
     */
    public void tocarCheckBoxLiAceitoTermosCondicoes(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .tocarCheckBoxLiAceitoTermosCondicoes(tipoProtecao);
    }

    /**
     * Tocar no bot�o "Contratar" da tela "Confirma��o de dados"
     *
     * @throws Exception
     */
    public void tocarBotaoContratarTelaConfirmacaoDeDados(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoContratarTelaConfirmacaoDeDados(tipoProtecao);
    }

    /**
     * Validar tela confirma��o de contrata��o
     *
     * @throws Exception
     */
    public void validarLayoutTelaConfirmacaoContratacao(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutTelaConfirmacaoContratacao(tipoProtecao);
    }

    /**
     * Tocar Bot�o "Concluir" da tela "Sucesso"
     *
     * @throws Exception
     */
    public void tocarBotaoConcluir(TipoSecaoProtecao tipoSecaoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoConcluir(tipoSecaoProtecao);
    }

    /**
     * Validar tela Controtados (Debito/Credito)
     *
     * @throws Exception
     */
    public void validarTelaDetalhesCardContratado(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarTelaDetalhesCardContratado(tipoProtecao)
                .validarAcioneSeguroTelaDetalhesCardContratado(tipoProtecao);
    }

    /**
     * Tocar bot�o "Informa��es do Seguro"
     *
     * @throws Exception
     */
    public void tocarBotaoInformacoesSeguroOuPlano(TipoSecaoProtecao tipoSecaoProtecao, TipoProtecao tipoProtecao, Protecao botao) throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoInformacoesSeguroOuPlano()
                .validarSecaoInformacoesSeguro(tipoSecaoProtecao, tipoProtecao, botao);
    }

    /**
     * Tocar bot�o 'Simular'
     *
     * @throws Exception
     */
    public void tocarBotaoSimular() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoSimular();
    }

    /**
     * Tocar bot�o 'Simular' na tela de Informa��es do Seguro
     *
     * @throws Exception
     */
    public void tocarBotaoSimularInformacoesSeguro() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoSimularInformacoesSeguro();
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @throws Exception
     */
    public void tocarBotaoContinuar() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Selecionar Participantes
     *
     * @throws Exception
     */
    public void selecionarParticipantes(ParticipantesProtecaoOdonto participantes) throws Exception {
        new ProtecaoTela(getDriver())
                .selecionarParticipantes(participantes);
    }

    /**
     * Adicionar Participantes
     *
     * @throws Exception
     */
    public void adicionarParticipante() throws Exception {
        new ProtecaoTela(getDriver())
                .adicionarParticipante();
    }

    /**
     * Remover Participantes
     *
     * @throws Exception
     */
    public void removerParticipante() throws Exception {
        new ProtecaoTela(getDriver())
                .removerParticipante();
    }

    /**
     * Validar tela "Simula��o"
     *
     * @throws Exception
     */
    public void validarTelaSimulacao() throws Exception {
        new ProtecaoTela(getDriver())
                .validarTelaSimulacao();
    }

    /**
     * Tocar bot�o voltar (sup/esq)
     *
     * @throws Exception
     */
    public void tocarBotaoVoltar() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Tocar bot�o Pr�ximo
     *
     * @throws Exception
     */
    public void tocarBotaoProximo() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoProximo();
    }

    /**
     * Validar Layout da Tela de Erro
     *
     * @throws Exception
     */
    public void validarLayoutTelaErro() throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutTelaErro();
    }

    /**
     * Tocar bot�o X
     *
     * @throws Exception
     */
    public void tocarBotaoX() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoX();
    }

    /**
     * Tocar bot�o cancelar "lixeira" Protecao (sup/dir)
     *
     * @throws Exception
     */
    public void tocarBotaoCancelarProtecao() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoCancelarProtecao();
    }

    /**
     * Validar layout Tela de Cancelar Protecao
     *
     * @throws Exception
     */
    public void validarLayoutTelaCancelarProtecao(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutTelaCancelarProtecao(tipoProtecao);
    }

    /**
     * Selecionar motivo do cancelamento
     *
     * @throws Exception
     */
    public void selecionarMotivoCancelamento() throws Exception {
        new ProtecaoTela(getDriver())
                .selecionarMotivoCancelamento();
    }

    /**
     * Tocar no bot�o "Confirmar" da tela Cancelamento Protecao
     *
     * @throws Exception
     */
    public void tocarBotaoConfirmarTelaCancelamentoProtecao() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoConfirmarTelaCancelamentoProtecao();
    }

    /**
     * Validar layout tela Cancelamento efetuado com sucesso
     *
     * @throws Exception
     */
    public void validarLayoutTelaCancelamentoComSucesso() throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutTelaCancelamentoComSucesso();
    }

    /**
     * Acessar "Termos e Condi��es"
     *
     * @throws Exception
     */
    public void acessarTermosCondicoes() throws Exception {
        new ProtecaoTela(getDriver())
                .acessarTermosCondicoes();
    }

    /**
     * Trocar campo data de pagamento para dia 01 (data default)
     *
     * @throws Exception
     */
    public void trocarDataPagamentoTelaCalendario(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .trocarDataPagamentoTelaCalendario(tipoProtecao);
    }

    /**
     * Clicar no campo detalhes - card contratado
     *
     * @throws Exception
     */
    public void tocarBotaoDetalhesCardContratado() throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoDetalhesCardContratado();
    }

    /**
     * Validar card a ser contratado tela Detalhes
     *
     * @throws Exception
     */
    public void validarCardProtecaoFromBtnDetalhes(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao, Protecao botao) throws Exception {
        new ProtecaoTela(getDriver())
                .navegarCardProtecao(tipoProtecao)
                .tocarBotaoSimular()
                .validarlayoutTelaDetalhes(tipoProtecao)
                .validarSecaoInformacoesSeguro(tipoSecaoProtecao, tipoProtecao, botao)
                .tocarBotaoContratarTelaDetalhes(botao);
    }

    /**
     * Validar card a ser contratado tela Detalhes/Confirmacao de Dados
     *
     * @throws Exception
     */
    public void validarCardTelaConfirmacaoDeDadosOdonto(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao, Protecao botao, ParticipantesProtecaoOdonto participantes) throws Exception {
        new ProtecaoTela(getDriver())
                .validarTelaConfirmacaoDeDados(tipoProtecao, participantes)
                .validarSecaoInformacoesSeguro(tipoSecaoProtecao, tipoProtecao, null)
                .tocarCheckBoxLiAceitoTermosCondicoes(tipoProtecao)
                .tocarBotaoContratarTelaConfirmacaoDeDados(tipoProtecao);
    }

    /**
     * Validar card a ser contratado tela Detalhes/Confirmacao de Dados
     *
     * @throws Exception
     */
    public void validarCardTelaConfirmacaoDeDados(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao, Protecao botao, ParticipantesProtecaoOdonto participantes) throws Exception {
        new ProtecaoTela(getDriver())
                .validarTelaConfirmacaoDeDados(tipoProtecao, participantes)
                .trocarDataPagamentoTelaCalendario(tipoProtecao)
                .acessarTermosCondicoes()
                .validarTelaTermosCondicoes(tipoProtecao)
                .tocarCheckBoxLiAceitoTermosCondicoes(tipoProtecao)
                .tocarBotaoContratarTelaConfirmacaoDeDados(tipoProtecao);
    }

    /**
     * Validar tela confirma��o de contrata��o
     *
     * @throws Exception
     */
    public void validarTelaConfirmacaoContratacao(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutTelaConfirmacaoContratacao(tipoProtecao)
                .tocarBotaoConcluir(tipoSecaoProtecao);
    }

    /**
     * Validar card contratado - cartao debito e credito
     *
     * @throws Exception
     */
    public void validarCardContratado(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .validarLayoutCardContratado(tipoProtecao)
                .tocarBotaoDetalhesCardContratado()
                .validarTelaDetalhesCardContratado(tipoProtecao)
                .validarAcioneSeguroTelaDetalhesCardContratado(tipoProtecao)
                .tocarBotaoVoltar();
    }

    /**
     * Fluxo de cancelamento de prote��o
     *
     * @throws Exception
     */
    public void cancelarProtecao(TipoProtecao tipoProtecao, TipoSecaoProtecao tipoSecaoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .tocarBotaoCancelarProtecao()
                .validarLayoutTelaCancelarProtecao(tipoProtecao)
                .selecionarMotivoCancelamento()
                .tocarBotaoConfirmarTelaCancelamentoProtecao()
                .validarLayoutTelaCancelamentoComSucesso()
                .tocarBotaoConcluir(tipoSecaoProtecao);
    }

    /**
     * Validar card a ser contratado pelo bot�o "Contratar" do card
     *
     * @throws Exception
     */
    public void validarCardProtecaoFromBtnContratar(TipoProtecao tipoProtecao) throws Exception {
        new ProtecaoTela(getDriver())
                .navegarCardProtecao(tipoProtecao)
                .validarLayoutCardProtecao(tipoProtecao)
                .tocarBotaoContratar();
    }
}
