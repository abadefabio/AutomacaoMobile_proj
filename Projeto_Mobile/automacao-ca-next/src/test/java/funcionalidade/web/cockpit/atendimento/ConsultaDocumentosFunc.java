package funcionalidade.web.cockpit.atendimento;


import pagina.web.cockpit.atendimento.dadosCadastrais.ContaNextTela;
import pagina.web.cockpit.atendimento.dadosCadastrais.ContatoTela;
import pagina.web.cockpit.atendimento.dadosCadastrais.DadosCadastraisTela;
import pagina.web.cockpit.atendimento.dadosCadastrais.DocumentosTela;
import pagina.web.cockpit.atendimento.resumo.ResumoAdesaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class ConsultaDocumentosFunc {

    /**
     * Validar campos da aba Dados Cadastrais
     *
     * @throws Exception
     */
    public void validarCamposAbaDadadosCadastrais() throws Exception {
        new DadosCadastraisTela(getWebDriver())
                .clicarMenuDadosCadastrais()
                .validarElementoFotoUsuarioEstaVisivel()
                .validarCampoNomeEstaPreenchido()
                .validarCampoApelidoEstaPreenchido()
                .validarCampoIdadeEstaPreenchido()
                .validarCampoDataNascimentoEstaPreenchido()
                .validarValorCampoGeneroEstaPreenchido()
                .validarValorCampoEstadoCivilEstaPreenchido()
                .validarValorCampoMaeEstaPreenchido()
                .validarValorCampoPaiEstaPreenchido()
                .validarValorCampoCpfEstaPreenchido()
                .validarValorCampoTipoEstaPreenchido()
                .validarValorCampoNumeroEstaPreenchido()
                .validarValorCampoOrgaoEmissorEstaPreenchido()
                .validarValorCampoUfEstaPreenchido()
                .validarValorCampoDataEmissaoEstaPreenchido()
                .ValidarCampoOutrasNacionalidadesEstaPresente();
    }

    /**
     * Validar campos da aba Contato
     *
     * @throws Exception
     */
    public void validarCamposAbaContato() throws Exception {
        new ContatoTela(getWebDriver())
                .clicarAbaContato()
                .validarValorCampoCelularEstaPreenchido()
                .validarValorCampoResidencialEstaPreenchido()
                .validarValorCampoEmailEstaPreenchido()
                .validarValorCampoTipoEstaPreenchido()
                .validarValorCampoCepEstaPreenchido()
                .validarValorCampoLogradouroEstaPreenchido()
                .validarValorCampoNumeroEstaPreenchido()
                .validarValorCampoComplementoEstaPreenchido()
                .validarValorCampoBairroEstaPreenchido()
                .validarValorCampoCidadeEstaPreenchido()
                .validarValorCampoUfEstaPreenchido();
    }

    /**
     * Validar campos da aba Conta Next
     *
     * @throws Exception
     */
    public void validarCamposAbaContaNext() throws Exception {
        new ContaNextTela(getWebDriver())
                .clicarAbaContaNext()
                .validarValorCampoAgenciaEstaPreenchido()
                .validarValorCampoNumeroContaEstaPreenchido()
                .validarValorCampoDataAdesaoEstaPreenchido()
                .validarValorCampoTipoEstaPreenchido()
                .validarValorCampoModalidadeContaEstaPreenchido()
                .validarValorCampoSegmentoEstaPreenchido()
                .validarValorCampoParentescoEstaPreenchido()
                .validarValorCampoNumeroCartaoEstaPreenchido();
    }

    /**
     * Validar campos da aba Documentos
     *
     * @throws Exception
     */
    public void validarCamposAbaDocumentos() throws Exception {
        new DocumentosTela(getWebDriver())
                .clicarAbaDocumentos()
                .ValidarCampoCalendarioInicioEstaPresente()
                .ValidarCampoCalendarioFinalEstaPresente()
                .ValidarCampoAnoAtualEstaPresente()
                .ValidarCampoMesAtualEstaPresente();
    }

    /**
     * Validar Adesao
     *
     * @param cpf
     * @throws Exception
     */
    public void validarAdesao(String cpf) throws Exception {
        new ResumoAdesaoTela(getWebDriver())
        .validarCpfAdesao(cpf);
    }
}

