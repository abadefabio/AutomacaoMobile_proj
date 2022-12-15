package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.seguros.MotivoCancelamento;
import constantes.seguros.SegurosDebitoTelefones;
import constantes.seguros.TipoSeguroContratado;
import pagina.mobile.jornadas.seguros.CancelamentoTela;
import pagina.mobile.jornadas.seguros.SegurosHomeTela;
import pagina.mobile.jornadas.seguros.debito.adesao.CancelamentoDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.CondicoesGeraisDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.InformacoesParceiroDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.ListaCondicoesGeraisDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.MeusDocumentosDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.ProdutoDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.ProdutoVigenteDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.ResumoDasCoberturasDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.SeguroColetivoDePessoasDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.SucessoCancelamentoDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.SucessoContratacaoDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.TelefonesUteisDebitoTela;
import pagina.mobile.jornadas.seguros.debito.adesao.VisaoGeralDebitoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegurosDebitoAdesaoFunc extends FuncionalidadeBase {


    /**
     * Método para validar Condicoes Gerais
     * @throws Exception
     */
    public void validarCondicoesGerais() throws Exception {
        new ProdutoDebitoTela(getDriver())
                .tocarBtnInfoTermosCondicoes();
        new ListaCondicoesGeraisDebitoTela(getDriver())
                .visualizarCondicoesGerais();
        new CondicoesGeraisDebitoTela(getDriver())
                .tocarBtnVoltarTelaTermoCondicoes();
        new ListaCondicoesGeraisDebitoTela(getDriver())
                .tocarBtnFecharTelaListaCondicoesGerais();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito();
    }

    /**
     * Método para validar Informacoes Parceiro
     * @throws Exception
     */
    public void validarInformacoesParceiro() throws Exception {
        new ProdutoDebitoTela(getDriver())
                .tocarBtnSaibaMaisInfoParceiro();
        new InformacoesParceiroDebitoTela(getDriver())
                .tocarBtnVoltarTelaInfoParceiro();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito();
    }

    /**
     * Método para contratar Produto Credito
     * @throws Exception
     */
    public void contratarProdutoCredito() throws Exception {
        new ProdutoDebitoTela(getDriver())
                .tocarCheckboxAceiteCondicoesGerais()
                .tocarBtnContratar();
        new SucessoContratacaoDebitoTela(getDriver())
                .validaTelaSucessoContratacao()
                .tocarBotaoConcluir();
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }

    /**
     * Método para tocar no botão Ver Detalhes Plano Credito
     * @param meusSeguros
     * @throws Exception
     */
    public void tocarBtnVerDetalhesPlanoCredito(String meusSeguros) throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarAbaMeusSeguros()
                .tocarBotaoSeguroContratado(meusSeguros);
        new ProdutoVigenteDebitoTela(getDriver())
                .tocarBtnVoltarTelaProdutoVigente();
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }

    /**
     * Método para validar Telefones Uteis Débito
     * @throws Exception
     */
    public void validarTelefonesUteisDebito() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito()
                .tocarBotaoTelefonesUteis();
        new pagina.mobile.jornadas.seguros.debito.adesao.TelefonesUteisDebitoTela(getDriver())
                .validaTelaTelefonesUteisDebito(
                        SegurosDebitoTelefones.TEXTO_TELEFONES_1,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_2,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_3,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito();
    }

    /**
     * Método para validar Visão Geral Débito
     * @throws Exception
     */
    public void validarVisaoGeralDebito() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito()
                .tocarBotaoVisaoGeral();
        new VisaoGeralDebitoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoMeusDocumentos();
        new MeusDocumentosDebitoTela(getDriver())
                .validaTelaMeusDocumentos()
                .tocarBotaoResumoDasCoberturas();
        new ResumoDasCoberturasDebitoTela(getDriver())
                .validaTelaResumoDasCoberturas()
                .tocarBotaoVoltarTelaResumoDasCoberturas();
        new MeusDocumentosDebitoTela(getDriver())
                .validaTelaMeusDocumentos()
                .tocarBotaoSeguroColetivoDePessoas();
        new SeguroColetivoDePessoasDebitoTela(getDriver())
                .validaTelaSeguroColetivoDePessoas()
                .tocarBotaoVoltarTelaSeguroColetivoDePessoas();
        new MeusDocumentosDebitoTela(getDriver())
                .validaTelaMeusDocumentos()
                .tocarBotaoVoltarTelaMeusDocumentos();
        new VisaoGeralDebitoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoPrecisoDeAjuda();
        new TelefonesUteisDebitoTela(getDriver())
                .validaTelaTelefonesUteisDebito(
                        SegurosDebitoTelefones.TEXTO_TELEFONES_1,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_2,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_3,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new VisaoGeralDebitoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoVoltarVisaoGeral();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito();
    }

    /**
     * Método para validar Acionamento da Seguradora
     * @throws Exception
     */
    public void validarAcionamentoDaSeguradoraDebito() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito()
                .tocarBotaoAcionarSeguradora();
        new TelefonesUteisDebitoTela(getDriver())
                .validaTelaTelefonesUteisDebito(
                        SegurosDebitoTelefones.TEXTO_TELEFONES_1,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_2,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_3,
                        SegurosDebitoTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito();
    }

    /**
     * Método para cancelar Seguro - DÉBITO
     * @throws Exception
     */
    public void cancelarSeguroCredito() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(TipoSeguroContratado.SEGURO_DEBITO);
        new ProdutoDebitoTela(getDriver())
                .validaTelaProdutoDebito()
                .tocarBotaoVisaoGeral();
        new VisaoGeralDebitoTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoCancelarSeguro();
        new CancelamentoDebitoTela(getDriver())
                .validaTelaCancelamentoDebito()
                .tocarBotaoContinuarParaCancelar();
        new CancelamentoTela(getDriver())
                .tocarBotaoMotivoDoCancelamento(MotivoCancelamento.NAO_PRECISO_MAIS)
                .tocarBotaoCorfirmar();
        new SucessoCancelamentoDebitoTela(getDriver())
                .validaTelaSucessoCancelamento();
    }
}
