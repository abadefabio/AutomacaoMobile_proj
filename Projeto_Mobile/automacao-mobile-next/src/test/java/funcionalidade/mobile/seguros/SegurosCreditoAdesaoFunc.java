package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.seguros.MotivoCancelamento;
import constantes.seguros.SegurosCreditoTelefones;
import constantes.seguros.TipoSeguroContratado;
import pagina.mobile.jornadas.seguros.CancelamentoTela;
import pagina.mobile.jornadas.seguros.SegurosHomeTela;
import pagina.mobile.jornadas.seguros.credito.adesao.CancelamentoCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.CondicoesGeraisCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.InformacoesParceiroCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.ListaCondicoesGeraisCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.MeusDocumentosCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.ProdutoCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.ProdutoVigenteCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.SucessoCancelamentoCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.SucessoContratacaoCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.TelefonesUteisCreditoTela;
import pagina.mobile.jornadas.seguros.credito.adesao.VisaoGeralCreditoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegurosCreditoAdesaoFunc extends FuncionalidadeBase {

    /**
     * Método para validar Condicoes Gerais
     * Validar layout da tela Proteção
     * contratados=false (nao possui card contratado)
     *
     * @throws Exception
     */

    /*
    Método para validar Condicoes Gerais
     */
    public void validarCondicoesGerais() throws Exception {
        new ProdutoCreditoTela(getDriver())
                .tocarBotaoInfoCondicoesGerais();
        new ListaCondicoesGeraisCreditoTela(getDriver())
                .visualizarCondicoesGerais();
        new CondicoesGeraisCreditoTela(getDriver())
                .tocarBotaoVoltarTelaTermoCondicoes();
        new ListaCondicoesGeraisCreditoTela(getDriver())
                .tocarBtnFecharTelaListaCondicoesGerais();
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCredito();
    }
    /**
     * Método para validar Informacoes Parceiro
     * @throws Exception
     */
    public void validarInformacoesParceiro() throws Exception {
        new ProdutoCreditoTela(getDriver())
                .tocarBotaoSaibaMaisInfoParceiro();
        new InformacoesParceiroCreditoTela(getDriver())
                .tocarBtnVoltarTelaInfoParceiro();
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCredito();
    }
    /*
    Método para contratar Produto Credito
     */
    public void contratarProdutoCredito() throws Exception {
        new ProdutoCreditoTela(getDriver())
                .tocarCheckboxAceiteCondicoesGerais()
                .tocarBotaoContratar();
        new SucessoContratacaoCreditoTela(getDriver())
                .validaTelaSucessoContratacao();
    }
    /**
     * Método para tocarno botão Ver Detalhes Plano Credito
     * @throws Exception
     */
    public void tocarBtnVerDetalhesPlanoCredito() throws Exception {
        new SucessoContratacaoCreditoTela(getDriver())
                .tocarBtnVerDetalhesPlanoCredito();
        new ProdutoVigenteCreditoTela(getDriver())
                .tocarBtnVoltarTelaProdutoVigente();
        new pagina.mobile.jornadas.seguros.SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }

    /**
     * Método para validar VISÃO GERAL - CRÉDITO
     * @param tipoSeguroContratado
     * @throws Exception
     */

    public void validarVisaoGeral(TipoSeguroContratado tipoSeguroContratado) throws Exception{
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(tipoSeguroContratado);
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCreditoMeusSeguros()
                .tocarBotaoVisaoGeral();
        new VisaoGeralCreditoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoMeusDocumentos();
        new MeusDocumentosCreditoTela(getDriver())
                .validaTelaMeusDocumentos()
                .tocarBotaoTermosDeCondicoes();
        new CondicoesGeraisCreditoTela(getDriver())
                .validaTelaCondicoesGerais()
                .tocarBotaoVoltarTelaTermoCondicoes();
        new MeusDocumentosCreditoTela(getDriver())
                .validaTelaMeusDocumentos()
                .tocarBotaoVoltar();
        new VisaoGeralCreditoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoPrecisoDeAjuda();
        new TelefonesUteisCreditoTela(getDriver())
                .validaTelaTelefonesUteisCredito(SegurosCreditoTelefones.TEXTO_TELEFONES_1,SegurosCreditoTelefones.TEXTO_TELEFONES_2,SegurosCreditoTelefones.TEXTO_TELEFONES_3,SegurosCreditoTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new VisaoGeralCreditoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoVoltarVisaoGeral();
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCreditoMeusSeguros();
    }

    /**
     * Método para validar TELEFONES ÚTEIS - CRÉDITO
     * @param tipoSeguroContratado
     * @throws Exception
     */

    public void validarTelefonesUteis(TipoSeguroContratado tipoSeguroContratado) throws Exception{
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(tipoSeguroContratado);
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCreditoMeusSeguros()
                .tocarBotaoTelefonesUteis();
        new TelefonesUteisCreditoTela(getDriver())
                .validaTelaTelefonesUteisCredito(SegurosCreditoTelefones.TEXTO_TELEFONES_1,SegurosCreditoTelefones.TEXTO_TELEFONES_2,SegurosCreditoTelefones.TEXTO_TELEFONES_3,SegurosCreditoTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCreditoMeusSeguros();
    }

    /**
     * Método para validar ACIONAMENTO DA SEGURADORA - CRÉDITO
     * @param tipoSeguroContratado
     * @throws Exception
     */

    public void validarAcionamentoSeguradora(TipoSeguroContratado tipoSeguroContratado) throws Exception{
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(tipoSeguroContratado);
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCreditoMeusSeguros()
                .tocarBotaoAcionarSeguradora();
        new TelefonesUteisCreditoTela(getDriver())
                .validaTelaTelefonesUteisCredito(SegurosCreditoTelefones.TEXTO_TELEFONES_1,SegurosCreditoTelefones.TEXTO_TELEFONES_2,SegurosCreditoTelefones.TEXTO_TELEFONES_3,SegurosCreditoTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCreditoMeusSeguros();
    }

    public void cancelarSeguroCredito() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(TipoSeguroContratado.SEGURO_CREDITO);
        new ProdutoCreditoTela(getDriver())
                .validaTelaProdutoCredito()
                .tocarBotaoVisaoGeral();
        new VisaoGeralCreditoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoCancelarSeguro();
        new CancelamentoCreditoTela(getDriver())
                .validaTelaCancelamentoCredito()
                .tocarBotaoContinuarParaCancelar();
        new CancelamentoTela(getDriver())
                .tocarBotaoMotivoDoCancelamento(MotivoCancelamento.NAO_PRECISO_MAIS)
                .tocarBotaoCorfirmar();
        new SucessoCancelamentoCreditoTela(getDriver())
                .validaTelaSucessoCancelamento()
                .tocarBotaoOk();
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }


}
