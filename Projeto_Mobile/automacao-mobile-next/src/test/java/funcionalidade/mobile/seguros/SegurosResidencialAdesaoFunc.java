package funcionalidade.mobile.seguros;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.seguros.MotivoCancelamento;
import constantes.seguros.SegurosResidencialTelefones;
import constantes.seguros.TipoSeguroContratado;
import pagina.mobile.jornadas.seguros.CancelamentoTela;
import pagina.mobile.jornadas.seguros.SegurosHomeTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.AcionarSeguradoraResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.CancelamentoResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.CondicoesGeraisResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.DetalhesProdutoResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.EditarEnderecoResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.InformacoesParceiroResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.InformacoesResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.ListaCondicoesGeraisResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.ProdutoResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.SaldoInsuficienteResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.SimularNovamenteResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.SucessoCancelamentoResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.SucessoContratacaoResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.TelefonesUteisResidencialTela;
import pagina.mobile.jornadas.seguros.residencial.adesao.VisaoGeralResidencialTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class SegurosResidencialAdesaoFunc extends FuncionalidadeBase {


    /**
     * Método para validar Detalhes Produto
     * @throws Exception
     */
    public void validarDetalhesProduto() throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarBtnSaibaMaisDetalhesCoberturas();
        new DetalhesProdutoResidencialTela(getDriver())
                .tocarAbaValoresFranquiasCobertura()
                .visualizarFranquiaCoberturaDescolapsada()
                .tocarBtnVoltarTelaDetalhesCobertura();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar Condições Gerais
     * @throws Exception
     */
    public void validarCondicoesGerais() throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarBtnInfoCondicoesGerais();
        new ListaCondicoesGeraisResidencialTela(getDriver())
                .visualizarCondicoesGerais();
        new CondicoesGeraisResidencialTela(getDriver())
                .tocarBtnVoltarTelaCondicoesGerais();
        new ListaCondicoesGeraisResidencialTela(getDriver())
                .tocarBtnFecharTelaListaCondicoesGerais();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar Informações Parceiro
     * @throws Exception
     */
    public void validarInformacoesParceiro() throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarBtnSaibaMaisInfoParceiro();
        new InformacoesParceiroResidencialTela(getDriver())
                .tocarBtnVoltarTelaSaibaMaisInfoParceiro();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para contratar Produto Residêncial
     * @throws Exception
     */
    public void contratarProdutoResidencial() throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarCheckboxAceiteCondicoesGerais()
                .tocarBtnContratar();
        new SucessoContratacaoResidencialTela(getDriver())
                .validaTelaSucessoContratacaoResidencial();
    }

    /**
     * Método para tocar no botão Concluir da Contratação Residencial
     * @throws Exception
     */
    public void tocarBtnConcluirContratacaoResidencial() throws Exception {
        new SucessoContratacaoResidencialTela(getDriver())
                .tocarBtnConcluirContratacaoResidencial();
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }

    /**
     * Método para validar Saldo Insuficiente
     * @throws Exception
     */
    public void validarSaldoInsuficiente() throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarCheckboxAceiteCondicoesGerais()
                .tocarBtnContratar();
        new SaldoInsuficienteResidencialTela(getDriver())
                .validaTelaSaldoInsuficiente();
    }

    /**
     * Método para tocar no botão OK da tela Saldo Insuficiente
     * @throws Exception
     */
    public void tocarBtnOKSaldoInsuficiente() throws Exception {
        new SaldoInsuficienteResidencialTela(getDriver())
                .tocarBtnOKTelaSaldoInsuficiente();
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros();
    }

    /**
     * Método para validar o acesso da tela EDITAR ENDEREÇO
     * @throws Exception
     */
    public void validarTelaAlteracaoEndereco() throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarBtnLapisEdicaoEndereco();
        new EditarEnderecoResidencialTela(getDriver())
                .tocarBtnVoltarTelaEdicaoEndereco();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar a alteração do endereço
     * @throws Exception
     */
    public void validarAlteracaoEndereco(String cep, String numero, String complemento) throws Exception {
        new ProdutoResidencialTela(getDriver())
                .tocarBtnLapisEdicaoEndereco();
        new EditarEnderecoResidencialTela(getDriver())
                .preencherCampoCEP(cep)
                .preencherCampoNumero(numero)
                .preencherCampoComplemento(complemento)
                .tocarBtnContinuarEdicaoEndereco();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar as Informações do Produto
     * @throws Exception
     */
    public void validarInformacoesDoProduto() throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial()
                .tocarBotaoInfo();
        new InformacoesResidencialTela(getDriver())
                .validarTelaInfomacoesResidencial()
                .tocarBotaoExpandirCoberturas()
                .validarCoberturas()
                .tocarBotaoColapsarCoberturas()
                .tocarBotaoExpandirAssistencias()
                .validarAssistencias()
                .tocarBotaoColapsarAssistencias()
                .tocarBotaoExpandirDadosDoParceiro()
                .validarDadosDoParceiro()
                .tocarBotaoColapsarDadosDoParceiro()
                .tocarBotaoExpandirCancelamento()
                .validarCancelamento()
                .tocarBotaoColapsarCancelamento()
                .tocarBotaoFechar();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar os Telefones Úteis
     * @throws Exception
     */
    public void validarTelefonesUteisResidencial() throws Exception {
        new SegurosHomeTela(getDriver())
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial()
                .tocarBotaoTelefonesUteis();
        new TelefonesUteisResidencialTela(getDriver())
                .validarTelaTelefonesUteisResidencial(SegurosResidencialTelefones.TEXTO_TELEFONES_1,SegurosResidencialTelefones.TEXTO_TELEFONES_2,SegurosResidencialTelefones.TEXTO_TELEFONES_3,SegurosResidencialTelefones.TEXTO_TELEFONES_4)
                .tocarBotaoVoltarTelaTelefonesUteis();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar o Acionamento da Seguradora
     * @throws Exception
     */
    public void validarAcionamentoDaSeguradora() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlano();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial()
                .tocarBotaoAcionarSeguradora();
        new AcionarSeguradoraResidencialTela(getDriver())
                .validarTelaAcionarSeguradora()
                .tocarBotaoVoltarTelaAcionarSeguradora();
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial();
    }

    /**
     * Método para validar a Recontratação
     * @throws Exception
     */
    public void validarRecontratacao() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoSimularNovamente();
        new SimularNovamenteResidencialTela(getDriver())
                .validaTextoVantagensPraVoce()
                .validaTextoProtecaoCompleta()
                .validaTextoPagamento()
                .validaTextoResidenciaSegurada()
                .validaBotaoSaibaMais()
                .validaTelaSimularNovamenteResidencial();
    }

    /**
     * Método responsável por cancelar o seguro RESIDENCIAL
     * @throws Exception
     */
    public void cancelarSeguro() throws Exception {
        new SegurosHomeTela(getDriver())
                .validaTelaHomeSeguros()
                .tocarAbaMeusSeguros()
                .tocarBotaoVerDetalhesDoPlanoContratado(TipoSeguroContratado.SEGURO_RESIDENCIAL);
        new ProdutoResidencialTela(getDriver())
                .validaTelaProdutoResidencial()
                .tocarBotaoVisaoGeral();
        new VisaoGeralResidencialTela(getDriver())
                .validaTelaVisaoGeralResidencial()
                .tocarBotaoCancelarSeguro();
        new CancelamentoResidencialTela(getDriver())
                .validaTelaCancelamentoResidencial()
                .tocarBotaoContinuarParaCancelar();
        new CancelamentoTela(getDriver())
                .validaTelaCancelamento()
                .tocarBotaoMotivoDoCancelamento(MotivoCancelamento.NAO_PRECISO_MAIS)
                .tocarBotaoCorfirmar();
        new SucessoCancelamentoResidencialTela(getDriver())
                .validaTelaSucessoCancelamento();
    }
}
