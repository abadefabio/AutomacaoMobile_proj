package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.seguros.MotivoCancelamento;
import constantes.seguros.TipoSeguroContratado;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.seguros.CancelamentoTela;
import pagina.mobile.jornadas.seguros.SegurosHomeTela;
import pagina.mobile.jornadas.seguros.dental.adesao.CancelamentoDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.CondicoesGeraisDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.DetalhesProdutoDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.InformacoesParceiroDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.ListaCondicoesGeraisDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.MeusDocumentosDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.PrecisoDeAjudaDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.ProdutoDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.SucessoCancelamentoDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.SucessoContratacaoDentalTela;
import pagina.mobile.jornadas.seguros.dental.adesao.VisaoGeralDentalTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static constantes.seguros.TextosTelasSeguros.TEXTOS_TELA_CONDICOES_GERAIS_SEGUROS_DENTAL;
import static constantes.seguros.TextosTelasSeguros.TEXTOS_TELA_HOME;
import static constantes.seguros.TextosTelasSeguros.TEXTOS_TELA_MEUS_DOCUMENTOS_SEGUROS_DENTAL;
import static constantes.seguros.TextosTelasSeguros.TEXTOS_TELA_PRECISO_AJUDA_SEGUROS_DENTAL;
import static constantes.seguros.TextosTelasSeguros.TEXTOS_TELA_SEGUROS_DENTAL;
import static constantes.seguros.TextosTelasSeguros.TEXTOS_VISAO_GERAL_SEGUROS_DENTAL;

public class SegurosDentalAdesaoFunc extends FuncionalidadeBase {

    /**
     * Validar layout da tela Proteção
     * contratados=false (nao possui card contratado)
     *
     * @throws Exception
     */

    /**
     * Método para validar Detalhes Produto
     * @throws Exception
     * */
    public void validarDetalhesProduto() throws Exception {
        new ProdutoDentalTela(getDriver())
                .tocarBtnSaibaMaisDetalhesPlano();
        new DetalhesProdutoDentalTela(getDriver())
                .tocarBtnVoltarTelaDetalhesPlano();
        new ProdutoDentalTela(getDriver())
                .validaTelaSeguros();
    }

    /**
     * Método para validar Condicoes Gerais
     * @throws Exception
     * */
    public void validarCondicoesGerais() throws Exception {
        new ProdutoDentalTela(getDriver())
                .tocarBtnInfoCondicoesGerais();
        new ListaCondicoesGeraisDentalTela(getDriver())
                .visualizarCondicoesGerais();
        new CondicoesGeraisDentalTela(getDriver())
                .tocarBotaoVoltarTelaCondicoesGerais();
        new ListaCondicoesGeraisDentalTela(getDriver())
                .tocarBtnFecharTelaListaCondicoesGerais();
        new ProdutoDentalTela(getDriver())
                .validaTelaSeguros();
    }

    /**
     * Método para validar Informacoes Parceiro
     * @throws Exception
     * */
    public void validarInformacoesParceiro() throws Exception {
        new ProdutoDentalTela(getDriver())
                .tocarBtnSaibaMaisInfoParceiro();
        new InformacoesParceiroDentalTela(getDriver())
                .tocarBtnVoltarTelaInfoParceiro();
        new ProdutoDentalTela(getDriver())
                .validaTelaSeguros();
    }

    /**
     * Método para contratar Produto Dental
     * @throws Exception
     * */
    public void contratarProdutoDental() throws Exception {
        new ProdutoDentalTela(getDriver())
                .tocarCheckboxAceiteCondicoesGerais()
                .tocarBtnContratar();
        new SucessoContratacaoDentalTela(getDriver())
                .validaTelaSucessoContratacaoDental();
    }

    /**
     * Método para tocar no botão Concluir Contratacao Dental
     * @throws Exception
     * */
    public void tocarBtnConcluirContratacaoDental() throws Exception {
        new SucessoContratacaoDentalTela(getDriver())
                .tocarBtnConcluirContratacaoDental();
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }

    /**
     * Método para validar Visao Geral Dental
     * @throws Exception
     */
    public void validarVisaoGeralDental() throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarAbaMeusSeguros();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_TELA_HOME);
        new SegurosHomeTela(getDriver())
                .tocarBotaoVerDetalhesDoPlano();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_TELA_SEGUROS_DENTAL);
        new ProdutoDentalTela(getDriver())
                .tocarBotaoVisaoGeral();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_VISAO_GERAL_SEGUROS_DENTAL);
        new VisaoGeralDentalTela(getDriver())
                .tocarBotaoMeusDocumentos();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_TELA_MEUS_DOCUMENTOS_SEGUROS_DENTAL);
        new MeusDocumentosDentalTela(getDriver())
                .tocarBotaoContrato();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_TELA_CONDICOES_GERAIS_SEGUROS_DENTAL);
        new CondicoesGeraisDentalTela(getDriver())
                .tocarBotaoVoltarTelaCondicoesGerais();
        new MeusDocumentosDentalTela(getDriver())
                .tocarBotaoVoltar();
        new VisaoGeralDentalTela(getDriver())
                .tocarBotaoPrecisoDeAjuda();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_TELA_PRECISO_AJUDA_SEGUROS_DENTAL);
        new PrecisoDeAjudaDentalTela(getDriver())
                .tocarBotaoVoltar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_VISAO_GERAL_SEGUROS_DENTAL);
        new VisaoGeralDentalTela(getDriver())
                .tocarBotaoVoltar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TEXTOS_TELA_SEGUROS_DENTAL);
    }

    /**
     * Método para cancelar Seguro
     * @throws Exception
     */
    public void cancelarSeguro() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(TipoSeguroContratado.SEGURO_DENTAL);
        new ProdutoDentalTela(getDriver())
                .validaTelaProdutoDental()
                .tocarBotaoVisaoGeral();
        new VisaoGeralDentalTela(getDriver())
                .validaTelaVisaoGeral()
                .tocarBotaoCancelarSeguro();
        new CancelamentoDentalTela(getDriver())
                .validaTelaCancelamentoDental()
                .tocarBotaoContinuarParaCancelar();
        new CancelamentoTela(getDriver())
                .validaTelaCancelamento()
                .tocarBotaoMotivoDoCancelamento(MotivoCancelamento.NAO_PRECISO_MAIS)
                .tocarBotaoCorfirmar();
        new SucessoCancelamentoDentalTela(getDriver())
                .validaTelaSucessoCancelamento();
    }
}
