package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.seguros.ParticipantesProtecaoOdonto;
import constantes.seguros.Protecao;
import constantes.seguros.TipoSecaoProtecao;
import pagina.mobile.jornadas.seguros.ProtecaoCreditoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ProtecaoCreditoFunc extends FuncionalidadeBase {

    /**
     * Validar card a ser contratado pelo botão "Contratar" do card
     *
     * @throws Exception
     */
    public void validarCardProtecaoFromBtnContratar() throws Exception {
        new ProtecaoCreditoTela(getDriver())
                .navegarCardProtecao()
                .validarLayoutCardProtecao()
                .tocarBotaoContratar();
    }
    /**
     * Validar card a ser contratado tela Detalhes/Confirmacao de Dados
     *
     * @throws Exception
     */
    public void validarCardTelaConfirmacaoDeDados(TipoSecaoProtecao tipoSecaoProtecao, Protecao botao, ParticipantesProtecaoOdonto participantes) throws Exception {
        new ProtecaoCreditoTela(getDriver())
                .validarTelaConfirmacaoDeDados(participantes)
                .validarSecaoInformacoesSeguro(tipoSecaoProtecao, botao)
                .trocarDataPagamentoTelaCalendario()
                .acessarTermosCondicoes()
                .validarTelaTermosCondicoes()
                .tocarCheckBoxLiAceitoTermosCondicoes()
                .tocarBotaoContratarTelaConfirmacaoDeDados();
    }

    /**
     * Validar tela confirmação de contratação
     *
     * @throws Exception
     */
    public void validarTelaConfirmacaoContratacao(TipoSecaoProtecao tipoSecaoProtecao) throws Exception {
        new ProtecaoCreditoTela(getDriver())
                .validarLayoutTelaConfirmacaoContratacao()
                .tocarBotaoConcluir(tipoSecaoProtecao);
    }

    /**
     * Validar card contratado - cartao debito e credito
     *
     * @throws Exception
     */
    public void validarCardContratado(TipoSecaoProtecao tipoSecaoProtecao,Protecao protecao) throws Exception {
        new ProtecaoCreditoTela(getDriver())
                .validarLayoutCardContratado()
                .tocarBotaoDetalhesCardContratado()
                .validarTelaDetalhesCardContratado()
                .validarAcioneSeguroTelaDetalhesCardContratado()
                .tocarBotaoInformacoesSeguroOuPlano()
                .validarSecaoInformacoesSeguro(tipoSecaoProtecao, protecao)
                .tocarBotaoVoltar();
    }

    /**
     * Fluxo de cancelamento de proteção
     *
     * @throws Exception
     */
    public void cancelarProtecao(TipoSecaoProtecao tipoSecaoProtecao) throws Exception {
        new ProtecaoCreditoTela(getDriver())
                .tocarBotaoCancelarProtecao()
                .validarLayoutTelaCancelarProtecao()
                .selecionarMotivoCancelamento()
                .tocarBotaoConfirmarTelaCancelamentoProtecao()
                .validarLayoutTelaCancelamentoComSucesso()
                .tocarBotaoConcluir(tipoSecaoProtecao);
    }

    /**
     * Navegar até o card "Odonto/Debito/Credito"
     *
     * @throws Exception
     */
    public void navegarCardProtecao() throws Exception {
        new ProtecaoCreditoTela(getDriver())
                .navegarCardProtecao();
    }

}
