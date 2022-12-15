package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.comum.PesquisaGeralTela;
import pagina.web.fnext.n1.CardDadosCadastraisJoyIITela;
import pagina.web.fnext.n1.CardDadosCadastraisTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class DadosCadastraisFunc extends FuncionalidadeBase {

    /**
     * Método para marcar Confere Todos os Campos Dados Cadastrais
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarConfereTodosDadosCadastrais(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereNomeMae()
                .clicarPaiDesconhecido()
                .clicarConfereTipoDocumento()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }

    /**
     * Método para marcar Confere Todos os Campos Dados Cadastrais MULTIBANCO
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarConfereTodosDadosCadastraisMultibanco(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMae()
                .clicarConfereNomePai()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }



    /**
     * Método para marcar Não Confere no CPF e Confere nos demais campos, (data de emissão, órgão emissor e UF de emissão)
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarDadosCadastraisParaReprovaNext(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarNaoConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereNomeMae()
                .clicarConfereNomePai()
                .clicarConfereTipoDocumento()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }

    /**
     * Método para marcar Não Confere no CPF e Confere nos demais campos, selecionando Pai desconhecido e preenchendo campos relativos ao documento (data de emissão, órgão emissor e UF de emissão) em propostas Next Joy
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarDadosCadastraisParaReprovaNextJoy(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarNaoConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMae()
                .clicarPaiDesconhecido()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }

    /**
     * Método para marcar em todos os campos, selecionando Pai desconhecido e preenchendo campos relativos ao documento (data de emissão, órgão emissor e UF de emissão) em propostas Next Joy
     *
     * @throws Exception
     */
    public void marcarDadosCadastraisParaPaiDesconhecidoAprovaNextJoy() throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMae()
                .clicarNaoConfereNomePai()
                .clicarPaiDesconhecidoComcheck()
                .clicarConfereNumeroDocumento()
                .clicarConfereDataEmissao()
                .clicarConfereOrgaoEmissor()
                .clicarConfereUfOrgaoEmissor();
    }

    /**
     * Método para marcar Confere em todos os campos em propostas Next Joy
     *
     * @throws Exception
     */
    public void marcarDadosCadastraisParaAprovarNextJoy() throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMae()
                .clicarConfereNomePai()
                .clicarConfereNumeroDocumento()
                .clicarConfereDataEmissao()
                .clicarConfereOrgaoEmissor()
                .clicarConfereUfOrgaoEmissor();
    }

    /**
     * Método para marcar Confere em todos os campos em propostas Next Joy Multibanco
     *
     * @throws Exception
     */
    public void marcarDadosCadastraisParaAprovarNextJoyMultiBanco() throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMae()
                .clicarConfereNomePai()
                .clicarConfereNumeroDocumento()
                .clicarConfereDataEmissao()
                .clicarConfereOrgaoEmissor()
                .clicarConfereUfOrgaoEmissor();
    }



    /**
     * Método para marcar Confere em todos os campos, preenchendo campos relativos ao documento para proposta Next Joy II do dependente
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarConfereDependenteJoyIIPadrao(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception {
        new CardDadosCadastraisJoyIITela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereNomeMae()
                .clicarPaiDesconhecido()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }

    /**
     * Método para marcar Confere em todos os campos, com exceção do campo CPF preenchendo campos relativos ao documento para proposta Next Joy II do dependente
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarDadosCadastraisDependenteJoyIICpfNaoConfere(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception {
        new CardDadosCadastraisJoyIITela(getWebDriver())
                .clicarNaoConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereNomeMae()
                .clicarConfereNomePai()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }

    /**
     * Método para marcar Confere em todos os campos, preenchendo campos relativos ao documento
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarConfereResponsavelJoyIIPadrao(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception {
        new CardDadosCadastraisJoyIITela(getWebDriver())
                .clicarConfereCpfResponsavel()
                .clicarConfereNomeCompletoResponsavel()
                .clicarConfereDataNascimentResponsavel()
                .clicarConferePaisNascimentoResponsavel()
                .clicarConfereUfNascimentoResponsavel()
                .clicarConfereCidadeNascimentoResponsavel()
                .clicarConfereSexoResponsavel()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMaeResponsavel()
                .clicarPaiDesconhecidoResponsavel()
                .clicarConfereTipoDocumentoResponsavel()
                .clicarConfereNumeroDocumentoResponsavel()
                .preencherDataEmissaoResponsavel(data)
                .selecionarComboOrgaoEmissorResponsavel(orgaoEmissor)
                .selecionarComboUfOrgaoEmissorResponsavel(ufOrgaoEmissor);
    }

    /**
     * Método para marcar Confere em todos os campos com exceção do CPF Responsável, preenchendo campos relativos ao documento JOY II
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarDadosCadastraisResponsavelJoyIICpfNaoConfere(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception {
        new CardDadosCadastraisJoyIITela(getWebDriver())
                .clicarNaoConfereCpfResponsavel()
                .clicarConfereNomeCompletoResponsavel()
                .clicarConfereDataNascimentResponsavel()
                .clicarConferePaisNascimentoResponsavel()
                .clicarConfereUfNascimentoResponsavel()
                .clicarConfereCidadeNascimentoResponsavel()
                .clicarConfereSexoResponsavel()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMaeResponsavel()
                .clicarPaiDesconhecidoResponsavel()
                .clicarConfereTipoDocumentoResponsavel()
                .clicarConfereNumeroDocumentoResponsavel()
                .preencherDataEmissaoResponsavel(data)
                .selecionarComboOrgaoEmissorResponsavel(orgaoEmissor)
                .selecionarComboUfOrgaoEmissorResponsavel(ufOrgaoEmissor);
    }

    /**
     * Método para marcar em todos os campos, sem Nome do Pai e marcar desconhecido, e preencher campos ao documento (data de emissão, órgão emissor e UF de emissão) em propostas Next Joy
     *
     * @param data
     * @param orgaoEmissor
     * @param ufOrgaoEmissor
     * @throws Exception
     */
    public void marcarDadosCadastraisSemPaiEDesconhecidoNextJoy(String data, String orgaoEmissor, String ufOrgaoEmissor) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarConfereNomeCompleto()
                .clicarConfereDataNascimento()
                .clicarConferePaisNascimento()
                .clicarConfereUfNascimento()
                .clicarConfereCidadeNascimento()
                .clicarConfereSexo()
                .clicarConfereVinculoResponsavel()
                .clicarConfereNomeMae()
                .clicarPaiDesconhecido()
                .clicarConfereNumeroDocumento()
                .preencherDataEmissao(data)
                .selecionarComboOrgaoEmissor(orgaoEmissor)
                .selecionarComboUfOrgaoEmissor(ufOrgaoEmissor);
    }

    /**
     * Método para marcar Não Confere Nome Completo validação da cor Vermelha na mensagem Informar Nome Completo
     *
     * @param correcaoNomeCompleto
     * @throws Exception
     */
    public void marcarNaoConfereNomeCompleto(String correcaoNomeCompleto) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarNaoConfereNomeCompleto()
                .corrigirNomeCompleto(correcaoNomeCompleto);
    }

    /**
     * Método para marcar Não Confere Nome Completo e validação da cor Vermelha na mensagem Nome inválido
     *
     * @param correcaoNomeCompleto
     * @throws Exception
     */
    public void marcarNaoConfereNomeCompletoFinalizar(String correcaoNomeCompleto) throws Exception{
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarNaoConfereNomeCompleto()
                .validarCorNomeInvalido(correcaoNomeCompleto);
    }

    /**
     * Método para marcar Não Confere nos campos do Card Dados Cadastrais (exceto CPF e Nome da Mãe) e preencher os campos da coluna Correção
     *
     * @param nomeCompletoCorrecao
     * @param dataNascimentoCorrecao
     * @param comboPaisNascimentoCorrecao
     * @param comboUfNascimentoCorrecao
     * @param comboCidadeNascimentoCorrecao
     * @param nomePaiCorrecao
     * @param comboTipoDocumentoCorrecao
     * @param numeroDocumentoCorrecao
     * @param dataEmissaoCorrecao
     * @param comboOrgaoEmissorCorrecao
     * @param comboUfOrgaoEmissorCorrecao
     * @throws Exception
     */
    public void marcarNaoConfereCorrigirDadosCadastraisNext(String nomeCompletoCorrecao, String dataNascimentoCorrecao, String comboPaisNascimentoCorrecao, String comboUfNascimentoCorrecao, String comboCidadeNascimentoCorrecao, String nomePaiCorrecao, String comboTipoDocumentoCorrecao, String numeroDocumentoCorrecao, String dataEmissaoCorrecao, String comboOrgaoEmissorCorrecao, String comboUfOrgaoEmissorCorrecao) throws Exception {
        new CardDadosCadastraisTela(getWebDriver())
                .clicarConfereCpf()
                .clicarNaoConfereCorrigirNomeCompleto(nomeCompletoCorrecao)
                .clicarNaoConfereCorrigirDataNascimento(dataNascimentoCorrecao)
                .clicarNaoConfereCorrigirPaisNascimento(comboPaisNascimentoCorrecao)
                .corrigirUfNascimento(comboUfNascimentoCorrecao)
                .corrigirCidadeNascimento(comboCidadeNascimentoCorrecao)
                .clicarNaoConfereSexo()
                .clicarConfereNomeMae()
                .clicarNaoConfereCorrigirNomePai(nomePaiCorrecao)
                .clicarNaoConfereCorrigirTipoDocumento(comboTipoDocumentoCorrecao)
                .clicarNaoConfereCorrigirNumeroDocumento(numeroDocumentoCorrecao)
                .clicarNaoConfereCorrigirDataEmissao(dataEmissaoCorrecao)
                .clicarNaoConfereCorrigirOrgaoEmissor(comboOrgaoEmissorCorrecao)
                .clicarNaoConfereCorrigirUfOrgaoEmissor(comboUfOrgaoEmissorCorrecao);
    }
}
