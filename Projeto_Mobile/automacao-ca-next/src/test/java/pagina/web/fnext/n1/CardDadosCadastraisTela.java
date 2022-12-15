package pagina.web.fnext.n1;

import base.pagina.web.fnext.PaginaBaseWebFNext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CardDadosCadastraisTela extends PaginaBaseWebFNext {

    @FindBy(id = "checkCpf")
    private WebElement confereCpf;

    @FindBy(id = "notcheckCpf")
    private WebElement naoConfereCpf;

    @FindBy(id = "notcheckCpfResponsible")
    private WebElement naoConfereCpfResponsavel;

    @FindBy(id = "checkName")
    private WebElement confereNomeCompleto;

    @FindBy(id="notCheckName")
    private WebElement naoConfereNomeCompleto;

    @FindBy(xpath="//input[@formcontrolname='correctValue']")
    private WebElement correcaoNomeCompleto;

    @FindBy(xpath ="//*[text()='Informe o nome completo.'] and label-danger[_ngcontent-epd-c28]")
    private WebElement corInformeNomeCompleto;

    @FindBy(xpath ="//*[text()='Nome inválido.'] and label-danger[_ngcontent-epd-c28]")
    private WebElement corNomeInvalido;

    @FindBy(id = "checkBirthDate")
    private WebElement confereDataNascimento;

    @FindBy(id = "notCheckBirthDate")
    private WebElement naoConfereDataNascimento;

    @FindBy(id = "correctionBirthDate")
    private WebElement correcaoDataNascimento;

    @FindBy(id = "checkParents")
    private WebElement conferePaisNascimento;

    @FindBy(id = "notCheckParents")
    private WebElement naoConferePaisNascimento;

    @FindBy(id = "correctionParents")
    private WebElement correcaoPaisNascimento;

    @FindBy(id = "checkState")
    private WebElement confereUfNascimento;

    @FindBy(id = "correctionState")
    private WebElement correcaoUfNascimento;

    @FindBy(id = "checkCity")
    private WebElement confereCidadeNascimento;

    @FindBy(id = "correctionCity")
    private WebElement correcaoCidadeNascimento;

    @FindBy(id = "checkGender")
    private WebElement confereSexo;

    @FindBy(id = "notCheckGender")
    private WebElement naoConfereSexo;

    @FindBy(id = "checkRelationshipDegree")
    private WebElement confereVinculoResponsavel;

    @FindBy(id = "checkMother")
    private WebElement confereNomeMae;

    @FindBy(id = "checkFather")
    private WebElement confereNomePai;

    @FindBy(id = "notCheckFather")
    private WebElement naoConfereNomePai;

    @FindBy(id = "correctionFather")
    private WebElement correcaoNomePai;

    @FindBy(id = "checkTpDoc")
    private WebElement confereTipoDoc;

    @FindBy(id = "notCheckTpDoc")
    private WebElement naoConfereTipoDoc;

    @FindBy(id = "correctionTpDoc")
    private WebElement correcaoTipoDoc;

    @FindBy(id = "checkNumDoc")
    private WebElement confereNumeroDoc;

    @FindBy(id = "notCheckNumDoc")
    private WebElement naoConfereNumeroDoc;

    @FindBy(id ="correctionNumDoc")
    private WebElement correcaoNumeroDoc;

    @FindBy(id = "checkIssueDt")
    private WebElement campoDataEmissao;

    @FindBy(id = "notcheckIssueDt")
    private WebElement naoConfereDataEmissao;

    @FindBy(id = "correctionIssueDt")
    private WebElement correcaoDataEmissao;

    @FindBy(id = "valueIssueDt")
    private WebElement campoDigitarDataEmissao;

    @FindBy(id = "checkAgency")
    private WebElement campoOrgaoEmissor;

    @FindBy(id = "notCheckAgency")
    private WebElement naoConfereOrgaoEmissor;

    @FindBy(id = "correctionAgency")
    private WebElement correcaoOrgaoEmissor;

    @FindBy(id = "valueAgency")
    private WebElement comboOrgaoEmissor;

    @FindBy(id = "checkUfAgency")
    private WebElement campoUfOrgaoEmissor;

    @FindBy(id = "unvaluedUfAgency")
    private WebElement naoConfereUfOrgaoEmissor;

    @FindBy(id = "correctionUfAgency")
    private WebElement correcaoUfOrgaoEmissor;

    @FindBy(id = "valueUfAgency")
    private WebElement comboUfOrgaoEmissor;

    @FindBy(id = "missingFatherNameReasonId-input")
    private WebElement paiDesconhecido;

    @FindBy(id = "checkMissingFatherNameReasonId")
    private WebElement paiDesconhecidoComCheck;

    @FindBy(xpath = "//button[text()=' Finalizar ']")
    private WebElement botaoFinalizar;

    public CardDadosCadastraisTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Confere campo CPF
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo CPF")
    public CardDadosCadastraisTela clicarConfereCpf() throws Exception {
        rolarAteElemento(confereCpf, "Campo CPF não encontrado");
        clicarElemento(confereCpf, "Erro para clicar Confere no campo CPF");
        salvarEvidencia("Selecionar campo confere CPF");
        return this;
    }

    /**
     * Clicar Não Confere campo CPF
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar não confere no campo CPF")
    public CardDadosCadastraisTela clicarNaoConfereCpf() throws Exception {
        rolarAteElemento(naoConfereCpf, "Campo CPF não encontrado");
        clicarElemento(naoConfereCpf, "Erro para clicar Não Confere no campo CPF");
        salvarEvidencia("Selecionar campo Não Confere CPF");
        return this;
    }

    /**
     * Clicar Não Confere campo CPF para Responsável Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar não confere no campo CPF")
    public CardDadosCadastraisTela clicarnaoConfereCpfResponsavel() throws Exception {
        rolarAteElemento(naoConfereCpfResponsavel, "Campo CPF não encontrado");
        clicarElemento(naoConfereCpfResponsavel, "Erro para clicar Não Confere no campo CPF do Responsável");
        salvarEvidencia("Selecionar campo Não Confere CPF Responsável");
        return this;
    }

    /**
     * Clicar Confere campo Nome completo
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Nome Completo")
    public CardDadosCadastraisTela clicarConfereNomeCompleto() throws Exception {
        rolarAteElemento(confereNomeCompleto, "Campo Nome Completo não encontrado");
        aguardarElementoClicavel(confereNomeCompleto);
        clicarElemento(confereNomeCompleto, "Erro para clicar Confere no campo Nome Completo");
        return this;
    }

    /**
     * Clicar Não Confere campo Nome completo
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Nome Completo")
    public CardDadosCadastraisTela clicarNaoConfereNomeCompleto() throws Exception {
        rolarAteElemento(naoConfereNomeCompleto, "Opção Não Confere do campo Nome Completo não encontrado");
        aguardarElementoClicavel(naoConfereNomeCompleto);
        clicarElemento(naoConfereNomeCompleto, "Erro para clicar Não Confere no campo Nome Completo");
        salvarEvidencia("Clicar Não Confere para o campo Nome Completo");
        return this;
    }

    /**
     * Corrigir Nome completo
     *
     * @param NomeCompletoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Corrigir Nome Completo")
    public CardDadosCadastraisTela corrigirNomeCompleto(String NomeCompletoCorrecao) throws Exception {
        rolarParaBaixoAteElemento(correcaoNomeCompleto);
        clicarElemento(correcaoNomeCompleto, "Campo Correção Nome Completo não encontrado");
        digitarTexto(correcaoNomeCompleto, NomeCompletoCorrecao,"Campo Correção do Nome Completo não encontrado");
        clicarConfereDataNascimento();
        aguardarCarregamentoElemento(corInformeNomeCompleto);
        salvarEvidencia("Validação da cor e do texto Informe Nome Completo");
        apagarCampoTexto(correcaoNomeCompleto,"Campo Correção do campo Nome Completo não encontrado");
        salvarEvidencia("Correção do Nome Completo");
        return this;
    }

    /**
     * Corrigir Nome completo e validar a cor Vermelha na mensagem Nome inválido
     *
     * @param NomeCompletoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Corrigir Nome Completo")
    public CardDadosCadastraisTela validarCorNomeInvalido(String NomeCompletoCorrecao) throws Exception {
        clicarElemento(correcaoNomeCompleto,"Campo Correção do Nome Completo não encontrado");
        digitarTexto(correcaoNomeCompleto, NomeCompletoCorrecao,"Campo Correção do Nome Completo não encontrado");
        rolarAteElemento(botaoFinalizar,"Botão Finalizar não encontrado");
        clicarElemento(botaoFinalizar,"Não foi possível clicar no botão Finalizar");
        clicarConfereDataNascimento();
        aguardarCarregamentoElemento(corNomeInvalido);
        salvarEvidencia("Validação da cor e do texto Nome Inválido");
        apagarCampoTexto(correcaoNomeCompleto,"Campo Correção do campo Nome Completo não encontrado");
        salvarEvidencia("Correção do Nome Completo");
        return this;
    }

    /**
     * Clicar Não Confere no campo Nome Completo e corrigir o Nome Completo
     *
     * @param nomeCompletoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Nome Completo e corrigir o Nome Completo")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirNomeCompleto(String nomeCompletoCorrecao) throws Exception {
        rolarAteElemento(naoConfereNomeCompleto,"Opção Não Confere do campo Nome Completo não encontrado");
        clicarElemento(naoConfereNomeCompleto, "Erro para clicar Não Confere no campo Nome Completo");
        digitarTexto(correcaoNomeCompleto, nomeCompletoCorrecao, "Campo Correção do Nome Completo não encontrado");
        salvarEvidencia("Seleção da opção Não Confere para o campo Nome Completo e correção do Nome Completo");
        return this;
    }

     /**
     * Clicar Confere campo Data de Nascimento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Data de Nascimento")
    public CardDadosCadastraisTela clicarConfereDataNascimento() throws Exception {
        rolarAteElemento(confereDataNascimento, "Campo Data de Nascimento não encontrado");
        clicarElemento(confereDataNascimento, "Erro para clicar Confere no campo Data de Nascimento");
        return this;
    }

    /**
     * Clicar Não Confere no campo Data de Nascimento e corrigir a Data de Nascimento
     *
     * @param dataNascimentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Data de Nascimento e corrigir a Data de Nascimento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirDataNascimento(String dataNascimentoCorrecao) throws Exception {
        rolarAteElemento(naoConfereDataNascimento,"Opção Não Confere do campo Data de Nascimento não encontrado");
        clicarElemento(naoConfereDataNascimento, "Erro para clicar Não Confere no campo Data de Nascimento");
        digitarTexto(correcaoDataNascimento, dataNascimentoCorrecao, "Campo Correção da Data de Nascimento não encontrado");
        salvarEvidencia("Seleção da opção Não Confere para o campo Data de Nascimento e correção da Data de Nascimento");
        return this;
    }

    /**
     * Clicar Confere campo País de Nascimento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo País de Nascimento")
    public CardDadosCadastraisTela clicarConferePaisNascimento() throws Exception {
        rolarAteElemento(conferePaisNascimento, "Campo País de Nascimento não encontrado");
        clicarElemento(conferePaisNascimento, "Erro para clicar Confere no campo País de Nascimento");
        return this;
    }

    /**
     * Clicar Não Confere no campo País de Nascimento e corrigir o País de Nascimento
     *
     * @param comboPaisNascimentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo País de Nascimento e corrigir o País de Nascimento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirPaisNascimento(String comboPaisNascimentoCorrecao) throws Exception {
        rolarAteElemento(naoConferePaisNascimento,"Opção Não Confere do campo País de Nascimento não encontrado");
        clicarElemento(naoConferePaisNascimento, "Erro para clicar Não Confere no campo País de Nascimento");
        selecionarTextoComboboxFnext(correcaoPaisNascimento, comboPaisNascimentoCorrecao, "Erro ao selecionar opção no combo de Correção do campo País de Nascimento");
        salvarEvidencia("Seleção da opção Não Confere para o campo País de Nascimento e correção do País de Nascimento");
        return this;
    }

    /**
     * Clicar Confere campo UF de Nascimento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo UF do Nascimento")
    public CardDadosCadastraisTela clicarConfereUfNascimento() throws Exception {
        rolarAteElemento(confereUfNascimento, "Campo UF de Nascimento não encontrado");
        clicarElemento(confereUfNascimento, "Erro para clicar Confere no campo UF de Nascimento");
        return this;
    }

    /**
     * Corrigir a UF de Nascimento"
     *
     * @param comboUfNascimentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Corrigir a UF de Nascimento")
    public CardDadosCadastraisTela corrigirUfNascimento(String comboUfNascimentoCorrecao) throws Exception {
        rolarAteElemento(correcaoUfNascimento,"Campo UF de Nascimento não encontrado");
        selecionarTextoComboboxFnext(correcaoUfNascimento, comboUfNascimentoCorrecao, "Erro ao selecionar opção no combo de Correção do campo UF de Nascimento");
        salvarEvidencia("Correção da UF de Nascimento");
        return this;
    }

    /**
     * Clicar Confere campo Cidade de Nascimento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Cidade de Nascimento")
    public CardDadosCadastraisTela clicarConfereCidadeNascimento() throws Exception {
        rolarAteElemento(confereCidadeNascimento, "Campo Cidade de Nascimento não encontrado");
        clicarElemento(confereCidadeNascimento, "Erro para clicar Confere no campo Cidade de Nascimento");
        return this;
    }

    /**
     * Corrigir a Cidade de Nascimento"
     *
     * @param comboCidadeNascimentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Corrigir a Cidade de Nascimento")
    public CardDadosCadastraisTela corrigirCidadeNascimento(String comboCidadeNascimentoCorrecao) throws Exception {
        rolarAteElemento(correcaoCidadeNascimento,"Campo Cidade de Nascimento não encontrado");
        selecionarTextoComboboxFnext(correcaoCidadeNascimento, comboCidadeNascimentoCorrecao, "Erro ao selecionar opção no combo de Correção do campo Cidade de Nascimento");
        salvarEvidencia("Correção da Cidade de Nascimento");
        return this;
    }

    /**
     * Clicar Confere campo Sexo
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Sexo")
    public CardDadosCadastraisTela clicarConfereSexo() throws Exception {
        rolarAteElemento(confereSexo, "Campo Sexo não encontrado");
        clicarElemento(confereSexo, "Erro para clicar Confere no campo Sexo");
        return this;
    }

    /**
     * Clicar Não Confere no campo Sexo
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Sexo")
    public CardDadosCadastraisTela clicarNaoConfereSexo() throws Exception {
        rolarAteElemento(naoConfereSexo, "Campo Sexo não encontrado");
        clicarElemento(naoConfereSexo, "Erro para clicar Não Confere no campo Sexo");
        return this;
    }

    /**
     * Clicar Confere campo Vínculo Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Vínculo Responsável")
    public CardDadosCadastraisTela clicarConfereVinculoResponsavel() throws Exception {
        rolarAteElemento(confereVinculoResponsavel, "Campo Vínculo Responsável não encontrado");
        clicarElemento(confereVinculoResponsavel, "Erro para clicar Confere no campo Vínculo Responsável");
        return this;
    }

    /**
     * Clicar Confere campo Nome da Mãe
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Nome da Mãe")
    public CardDadosCadastraisTela clicarConfereNomeMae() throws Exception {
        rolarAteElemento(confereNomeMae, "Campo Nome da Mãe não encontrado");
        clicarElemento(confereNomeMae, "Erro para clicar Confere no campo Nome da Mãe");
        salvarEvidencia("Selecionar confere Nome Mãe");
        return this;
    }

    /**
     * Clicar Confere campo Nome do Pai
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Nome do Pai")
    public CardDadosCadastraisTela clicarConfereNomePai() throws Exception {
        rolarAteElemento(confereNomePai, "Campo Nome do Pai não encontrado");
        clicarElemento(confereNomePai, "Erro para clicar Confere no campo Nome do Pai");
        return this;
    }

    /**
     * Clicar não Confere campo Nome do Pai
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar não confere no campo Nome do Pai")
    public CardDadosCadastraisTela clicarNaoConfereNomePai() throws Exception {
        rolarAteElemento(naoConfereNomePai, "Campo Nome do Pai não encontrado");
        clicarElemento(naoConfereNomePai, "Erro para clicar Não Confere no campo Nome do Pai");
        return this;
    }

    /**
     * Clicar Desconhecido campo Nome do Pai quando NAO existe checks para avaliacao
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Desconhecido no campo Nome do Pai")
    public CardDadosCadastraisTela clicarPaiDesconhecido() throws Exception {
        rolarAteElemento(paiDesconhecido, "Campo 'desconhecido' Nome do Pai não encontrado");
        clicarElemento(paiDesconhecido, "Erro para clicar Desconhecido no campo Nome do Pai");
        return this;
    }

    /**
     * Clicar Desconhecido campo Nome do Pai quando existe checks para avaliacao
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Desconhecido no campo Nome do Pai")
    public CardDadosCadastraisTela clicarPaiDesconhecidoComcheck() throws Exception {
        rolarAteElemento(paiDesconhecidoComCheck, "Campo 'desconhecido' Nome do Pai não encontrado");
        clicarElemento(paiDesconhecidoComCheck, "Erro para clicar Desconhecido no campo Nome do Pai");
        return this;
    }

    /**
     * Clicar Não Confere no campo Nome do Pai e corrigir o Nome do Pai
     *
     * @param nomePaiCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Nome do Pai e corrigir o Nome do Pai")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirNomePai(String nomePaiCorrecao) throws Exception {
        rolarAteElemento(naoConfereNomePai,"Opção Não Confere do campo Nome do Pai não encontrado");
        clicarElemento(naoConfereNomePai, "Erro para clicar Não Confere no campo Nome do Pai");
        digitarTexto(correcaoNomePai, nomePaiCorrecao, "Campo Correção do Nome do Pai não encontrado");
        salvarEvidencia("Seleção da opção Não Confere para o campo Nome do Pai e correção do Nome do Pai");
        return this;
    }

    /**
     * Clicar Confere campo Tipo do Documento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Tipo de Documento")
    public CardDadosCadastraisTela clicarConfereTipoDocumento() throws Exception {
        rolarAteElemento(confereTipoDoc, "Campo Tipo de Documento não encontrado");
        clicarElemento(confereTipoDoc, "Erro para clicar Confere no campo Tipo de Documento");
        return this;
    }

    /**
     * Clicar Não Confere no campo Tipo de Documento e corrigir o Tipo de Documento
     *
     * @param comboTipoDocumentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Tipo de Documento e corrigir o Tipo de Documento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirTipoDocumento(String comboTipoDocumentoCorrecao) throws Exception {
        rolarAteElemento(naoConfereTipoDoc,"Opção Não Confere do campo Tipo de Documento não encontrado");
        clicarElemento(naoConfereTipoDoc, "Erro para clicar Não Confere no campo Tipo de Documento");
        selecionarTextoComboboxFnext(correcaoTipoDoc, comboTipoDocumentoCorrecao, "Erro ao selecionar opção no combo de Correção do campo Tipo de Documento");
        salvarEvidencia("Seleção da opção Não Confere para o campo Tipo de Documento e correção do Tipo de Documento");
        return this;
    }

    /**
     * Clicar Confere campo Numero do Documento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Número do Documento")
    public CardDadosCadastraisTela clicarConfereNumeroDocumento() throws Exception {
        rolarAteElemento(confereNumeroDoc, "Campo Número do Documento não encontrado");
        clicarElemento(confereNumeroDoc, "Erro para clicar Confere no campo Número do Documento");
        return this;
    }

    /**
     * Clicar Não Confere no campo Número do Documento e corrigir o Número do Documento
     *
     * @param numeroDocumentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Número do Documento e corrigir o Número do Documento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirNumeroDocumento(String numeroDocumentoCorrecao) throws Exception {
        rolarAteElemento(naoConfereNumeroDoc,"Opção Não Confere do campo Número do Documento não encontrado");
        clicarElemento(naoConfereNumeroDoc, "Erro para clicar Não Confere no campo Número do Documento");
        digitarTexto(correcaoNumeroDoc, numeroDocumentoCorrecao, "Campo Correção do Número do Documento não encontrado");
        salvarEvidencia("Seleção da opção Não Confere para o campo Número do Documento e correção do Número do Documento");
        return this;
    }

    /**
     * Clicar Confere no campo Data de Emissão
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Data de Emissão")
    public CardDadosCadastraisTela clicarConfereDataEmissao() throws Exception {
        rolarAteElemento(campoDataEmissao, "Campo Data de Emissão não encontrado");
        clicarElemento(campoDataEmissao,"Não possível clicar no campo confere Data Emissao");
        return this;
    }

    /**
     * Clicar Não Confere no campo Data de Emissão e corrigir a Data de Emissão
     *
     * @param dataEmissaoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere campo Data de Emissão e corrigir a Data de Emissão")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirDataEmissao(String dataEmissaoCorrecao) throws Exception {
        rolarAteElemento(naoConfereDataEmissao,"Opção Não Confere do campo Data de Emissão não encontrado");
        clicarElemento(naoConfereDataEmissao, "Erro para clicar Não Confere no campo Data de Emissão");
        digitarTexto(correcaoDataEmissao, dataEmissaoCorrecao, "Campo Correção da Data de Emissão não encontrado");
        salvarEvidencia("Seleção da opção Não Confere para o campo Data de Emissão e correção da Data de Emissão");
        return this;
    }

    /**
     * Clicar Confere no campo Órgão Emissor
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo Órgão Emissor")
    public CardDadosCadastraisTela clicarConfereOrgaoEmissor() throws Exception {
        rolarAteElemento(campoOrgaoEmissor, "Campo Órgão Emissor não encontrado");
        clicarElemento(campoOrgaoEmissor,"Não foi possível clicar no campo confere Órgão Emissor");
        return this;
    }

    /**
     * Clicar Não Confere no campo Órgão Emissor e corrigir o Órgão Emissor
     *
     * @param comboOrgaoEmissorCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Órgão Emissor e corrigir o Órgão Emissor")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirOrgaoEmissor(String comboOrgaoEmissorCorrecao) throws Exception {
        rolarAteElemento(naoConfereOrgaoEmissor,"Opção Não Confere do campo Órgão Emissor não encontrado");
        clicarElemento(naoConfereOrgaoEmissor, "Erro para clicar Não Confere no campo Órgão Emissor");
        selecionarTextoComboboxFnext(correcaoOrgaoEmissor, comboOrgaoEmissorCorrecao, "Erro ao selecionar opção no combo de Correção do campo Órgão Emissor");
        salvarEvidencia("Seleção da opção Não Confere para o campo Órgão Emissor e correção do Órgão Emissor");
        return this;
    }

    /**
     * Clicar Confere no campo UF Órgão Emissor
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo UF Órgão Emissor")
    public CardDadosCadastraisTela clicarConfereUfOrgaoEmissor() throws Exception {
        rolarAteElemento(campoUfOrgaoEmissor, "Campo UF Órgão Emissor não encontrado");
        clicarElemento(campoUfOrgaoEmissor,"Não foi possível clicar no campo confere UF Órgão Emissor");

        return this;
    }

    /**
     * Clicar Não Confere no campo UF Órgão Emissor e corrigir a UF Órgão Emissor
     *
     * @param comboUfOrgaoEmissorCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo UF Órgão Emissor e corrigir a UF Órgão Emissor")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirUfOrgaoEmissor(String comboUfOrgaoEmissorCorrecao) throws Exception {
        rolarAteElemento(naoConfereUfOrgaoEmissor,"Opção Não Confere do campo UF Órgão Emissor não encontrado");
        clicarElemento(naoConfereUfOrgaoEmissor, "Erro para clicar Não Confere no campo UF Órgão Emissor");
        selecionarTextoComboboxFnext(correcaoUfOrgaoEmissor, comboUfOrgaoEmissorCorrecao, "Erro ao selecionar opção no combo de Correção do campo UF Órgão Emissor");
        salvarEvidencia("Seleção da opção Não Confere para o campo UF Órgão Emissor e correção da UF Órgão Emissor");
        return this;
    }

    /**
     * Preencher o campo Data de Emissão
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo Data de Emissão")
    public CardDadosCadastraisTela preencherDataEmissao(String data) throws Exception {
        rolarAteElemento(campoDigitarDataEmissao, "Campo Data de Emissão não encontrado");
        digitarTexto(campoDigitarDataEmissao, data,"Não foi possivel encontrar o campo para digitação da Data de Emissão do Documento");
        salvarEvidencia("Campo de data de Emissão do documento preenchida: " + data);
        return this;
    }

    /**
     * Selecionar combo do Órgão Emissor do documento de identificação
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar opção no campo Órgão Emissor")
    public CardDadosCadastraisTela selecionarComboOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboOrgaoEmissor);
        selecionarTextoComboboxFnext(comboOrgaoEmissor, combo,"Não foi possível selecionar opção de órgão emissor");
        return this;
    }

    /**
     * Selecionar combo do UF do Órgão Emissor do documento de identificação
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar opção no campo UF do Órgão Emissor")
    public CardDadosCadastraisTela selecionarComboUfOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboUfOrgaoEmissor);
        selecionarTextoComboboxFnext(comboUfOrgaoEmissor, combo, "Erro selecionar opção no campo UF Órgão Emissor");
        salvarEvidencia("Selecionada opção no combo do UF Órgão Emissor do documento de identificação");
        return this;
    }
}
