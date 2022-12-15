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

    @FindBy(xpath ="//*[text()='Nome inv�lido.'] and label-danger[_ngcontent-epd-c28]")
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
        rolarAteElemento(confereCpf, "Campo CPF n�o encontrado");
        clicarElemento(confereCpf, "Erro para clicar Confere no campo CPF");
        salvarEvidencia("Selecionar campo confere CPF");
        return this;
    }

    /**
     * Clicar N�o Confere campo CPF
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar n�o confere no campo CPF")
    public CardDadosCadastraisTela clicarNaoConfereCpf() throws Exception {
        rolarAteElemento(naoConfereCpf, "Campo CPF n�o encontrado");
        clicarElemento(naoConfereCpf, "Erro para clicar N�o Confere no campo CPF");
        salvarEvidencia("Selecionar campo N�o Confere CPF");
        return this;
    }

    /**
     * Clicar N�o Confere campo CPF para Respons�vel Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar n�o confere no campo CPF")
    public CardDadosCadastraisTela clicarnaoConfereCpfResponsavel() throws Exception {
        rolarAteElemento(naoConfereCpfResponsavel, "Campo CPF n�o encontrado");
        clicarElemento(naoConfereCpfResponsavel, "Erro para clicar N�o Confere no campo CPF do Respons�vel");
        salvarEvidencia("Selecionar campo N�o Confere CPF Respons�vel");
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
        rolarAteElemento(confereNomeCompleto, "Campo Nome Completo n�o encontrado");
        aguardarElementoClicavel(confereNomeCompleto);
        clicarElemento(confereNomeCompleto, "Erro para clicar Confere no campo Nome Completo");
        return this;
    }

    /**
     * Clicar N�o Confere campo Nome completo
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Nome Completo")
    public CardDadosCadastraisTela clicarNaoConfereNomeCompleto() throws Exception {
        rolarAteElemento(naoConfereNomeCompleto, "Op��o N�o Confere do campo Nome Completo n�o encontrado");
        aguardarElementoClicavel(naoConfereNomeCompleto);
        clicarElemento(naoConfereNomeCompleto, "Erro para clicar N�o Confere no campo Nome Completo");
        salvarEvidencia("Clicar N�o Confere para o campo Nome Completo");
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
        clicarElemento(correcaoNomeCompleto, "Campo Corre��o Nome Completo n�o encontrado");
        digitarTexto(correcaoNomeCompleto, NomeCompletoCorrecao,"Campo Corre��o do Nome Completo n�o encontrado");
        clicarConfereDataNascimento();
        aguardarCarregamentoElemento(corInformeNomeCompleto);
        salvarEvidencia("Valida��o da cor e do texto Informe Nome Completo");
        apagarCampoTexto(correcaoNomeCompleto,"Campo Corre��o do campo Nome Completo n�o encontrado");
        salvarEvidencia("Corre��o do Nome Completo");
        return this;
    }

    /**
     * Corrigir Nome completo e validar a cor Vermelha na mensagem Nome inv�lido
     *
     * @param NomeCompletoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Corrigir Nome Completo")
    public CardDadosCadastraisTela validarCorNomeInvalido(String NomeCompletoCorrecao) throws Exception {
        clicarElemento(correcaoNomeCompleto,"Campo Corre��o do Nome Completo n�o encontrado");
        digitarTexto(correcaoNomeCompleto, NomeCompletoCorrecao,"Campo Corre��o do Nome Completo n�o encontrado");
        rolarAteElemento(botaoFinalizar,"Bot�o Finalizar n�o encontrado");
        clicarElemento(botaoFinalizar,"N�o foi poss�vel clicar no bot�o Finalizar");
        clicarConfereDataNascimento();
        aguardarCarregamentoElemento(corNomeInvalido);
        salvarEvidencia("Valida��o da cor e do texto Nome Inv�lido");
        apagarCampoTexto(correcaoNomeCompleto,"Campo Corre��o do campo Nome Completo n�o encontrado");
        salvarEvidencia("Corre��o do Nome Completo");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Nome Completo e corrigir o Nome Completo
     *
     * @param nomeCompletoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Nome Completo e corrigir o Nome Completo")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirNomeCompleto(String nomeCompletoCorrecao) throws Exception {
        rolarAteElemento(naoConfereNomeCompleto,"Op��o N�o Confere do campo Nome Completo n�o encontrado");
        clicarElemento(naoConfereNomeCompleto, "Erro para clicar N�o Confere no campo Nome Completo");
        digitarTexto(correcaoNomeCompleto, nomeCompletoCorrecao, "Campo Corre��o do Nome Completo n�o encontrado");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo Nome Completo e corre��o do Nome Completo");
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
        rolarAteElemento(confereDataNascimento, "Campo Data de Nascimento n�o encontrado");
        clicarElemento(confereDataNascimento, "Erro para clicar Confere no campo Data de Nascimento");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Data de Nascimento e corrigir a Data de Nascimento
     *
     * @param dataNascimentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Data de Nascimento e corrigir a Data de Nascimento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirDataNascimento(String dataNascimentoCorrecao) throws Exception {
        rolarAteElemento(naoConfereDataNascimento,"Op��o N�o Confere do campo Data de Nascimento n�o encontrado");
        clicarElemento(naoConfereDataNascimento, "Erro para clicar N�o Confere no campo Data de Nascimento");
        digitarTexto(correcaoDataNascimento, dataNascimentoCorrecao, "Campo Corre��o da Data de Nascimento n�o encontrado");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo Data de Nascimento e corre��o da Data de Nascimento");
        return this;
    }

    /**
     * Clicar Confere campo Pa�s de Nascimento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Pa�s de Nascimento")
    public CardDadosCadastraisTela clicarConferePaisNascimento() throws Exception {
        rolarAteElemento(conferePaisNascimento, "Campo Pa�s de Nascimento n�o encontrado");
        clicarElemento(conferePaisNascimento, "Erro para clicar Confere no campo Pa�s de Nascimento");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Pa�s de Nascimento e corrigir o Pa�s de Nascimento
     *
     * @param comboPaisNascimentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Pa�s de Nascimento e corrigir o Pa�s de Nascimento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirPaisNascimento(String comboPaisNascimentoCorrecao) throws Exception {
        rolarAteElemento(naoConferePaisNascimento,"Op��o N�o Confere do campo Pa�s de Nascimento n�o encontrado");
        clicarElemento(naoConferePaisNascimento, "Erro para clicar N�o Confere no campo Pa�s de Nascimento");
        selecionarTextoComboboxFnext(correcaoPaisNascimento, comboPaisNascimentoCorrecao, "Erro ao selecionar op��o no combo de Corre��o do campo Pa�s de Nascimento");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo Pa�s de Nascimento e corre��o do Pa�s de Nascimento");
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
        rolarAteElemento(confereUfNascimento, "Campo UF de Nascimento n�o encontrado");
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
        rolarAteElemento(correcaoUfNascimento,"Campo UF de Nascimento n�o encontrado");
        selecionarTextoComboboxFnext(correcaoUfNascimento, comboUfNascimentoCorrecao, "Erro ao selecionar op��o no combo de Corre��o do campo UF de Nascimento");
        salvarEvidencia("Corre��o da UF de Nascimento");
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
        rolarAteElemento(confereCidadeNascimento, "Campo Cidade de Nascimento n�o encontrado");
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
        rolarAteElemento(correcaoCidadeNascimento,"Campo Cidade de Nascimento n�o encontrado");
        selecionarTextoComboboxFnext(correcaoCidadeNascimento, comboCidadeNascimentoCorrecao, "Erro ao selecionar op��o no combo de Corre��o do campo Cidade de Nascimento");
        salvarEvidencia("Corre��o da Cidade de Nascimento");
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
        rolarAteElemento(confereSexo, "Campo Sexo n�o encontrado");
        clicarElemento(confereSexo, "Erro para clicar Confere no campo Sexo");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Sexo
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Sexo")
    public CardDadosCadastraisTela clicarNaoConfereSexo() throws Exception {
        rolarAteElemento(naoConfereSexo, "Campo Sexo n�o encontrado");
        clicarElemento(naoConfereSexo, "Erro para clicar N�o Confere no campo Sexo");
        return this;
    }

    /**
     * Clicar Confere campo V�nculo Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo V�nculo Respons�vel")
    public CardDadosCadastraisTela clicarConfereVinculoResponsavel() throws Exception {
        rolarAteElemento(confereVinculoResponsavel, "Campo V�nculo Respons�vel n�o encontrado");
        clicarElemento(confereVinculoResponsavel, "Erro para clicar Confere no campo V�nculo Respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Nome da M�e
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Nome da M�e")
    public CardDadosCadastraisTela clicarConfereNomeMae() throws Exception {
        rolarAteElemento(confereNomeMae, "Campo Nome da M�e n�o encontrado");
        clicarElemento(confereNomeMae, "Erro para clicar Confere no campo Nome da M�e");
        salvarEvidencia("Selecionar confere Nome M�e");
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
        rolarAteElemento(confereNomePai, "Campo Nome do Pai n�o encontrado");
        clicarElemento(confereNomePai, "Erro para clicar Confere no campo Nome do Pai");
        return this;
    }

    /**
     * Clicar n�o Confere campo Nome do Pai
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar n�o confere no campo Nome do Pai")
    public CardDadosCadastraisTela clicarNaoConfereNomePai() throws Exception {
        rolarAteElemento(naoConfereNomePai, "Campo Nome do Pai n�o encontrado");
        clicarElemento(naoConfereNomePai, "Erro para clicar N�o Confere no campo Nome do Pai");
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
        rolarAteElemento(paiDesconhecido, "Campo 'desconhecido' Nome do Pai n�o encontrado");
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
        rolarAteElemento(paiDesconhecidoComCheck, "Campo 'desconhecido' Nome do Pai n�o encontrado");
        clicarElemento(paiDesconhecidoComCheck, "Erro para clicar Desconhecido no campo Nome do Pai");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Nome do Pai e corrigir o Nome do Pai
     *
     * @param nomePaiCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Nome do Pai e corrigir o Nome do Pai")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirNomePai(String nomePaiCorrecao) throws Exception {
        rolarAteElemento(naoConfereNomePai,"Op��o N�o Confere do campo Nome do Pai n�o encontrado");
        clicarElemento(naoConfereNomePai, "Erro para clicar N�o Confere no campo Nome do Pai");
        digitarTexto(correcaoNomePai, nomePaiCorrecao, "Campo Corre��o do Nome do Pai n�o encontrado");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo Nome do Pai e corre��o do Nome do Pai");
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
        rolarAteElemento(confereTipoDoc, "Campo Tipo de Documento n�o encontrado");
        clicarElemento(confereTipoDoc, "Erro para clicar Confere no campo Tipo de Documento");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Tipo de Documento e corrigir o Tipo de Documento
     *
     * @param comboTipoDocumentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Tipo de Documento e corrigir o Tipo de Documento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirTipoDocumento(String comboTipoDocumentoCorrecao) throws Exception {
        rolarAteElemento(naoConfereTipoDoc,"Op��o N�o Confere do campo Tipo de Documento n�o encontrado");
        clicarElemento(naoConfereTipoDoc, "Erro para clicar N�o Confere no campo Tipo de Documento");
        selecionarTextoComboboxFnext(correcaoTipoDoc, comboTipoDocumentoCorrecao, "Erro ao selecionar op��o no combo de Corre��o do campo Tipo de Documento");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo Tipo de Documento e corre��o do Tipo de Documento");
        return this;
    }

    /**
     * Clicar Confere campo Numero do Documento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo N�mero do Documento")
    public CardDadosCadastraisTela clicarConfereNumeroDocumento() throws Exception {
        rolarAteElemento(confereNumeroDoc, "Campo N�mero do Documento n�o encontrado");
        clicarElemento(confereNumeroDoc, "Erro para clicar Confere no campo N�mero do Documento");
        return this;
    }

    /**
     * Clicar N�o Confere no campo N�mero do Documento e corrigir o N�mero do Documento
     *
     * @param numeroDocumentoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo N�mero do Documento e corrigir o N�mero do Documento")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirNumeroDocumento(String numeroDocumentoCorrecao) throws Exception {
        rolarAteElemento(naoConfereNumeroDoc,"Op��o N�o Confere do campo N�mero do Documento n�o encontrado");
        clicarElemento(naoConfereNumeroDoc, "Erro para clicar N�o Confere no campo N�mero do Documento");
        digitarTexto(correcaoNumeroDoc, numeroDocumentoCorrecao, "Campo Corre��o do N�mero do Documento n�o encontrado");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo N�mero do Documento e corre��o do N�mero do Documento");
        return this;
    }

    /**
     * Clicar Confere no campo Data de Emiss�o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar confere no campo Data de Emiss�o")
    public CardDadosCadastraisTela clicarConfereDataEmissao() throws Exception {
        rolarAteElemento(campoDataEmissao, "Campo Data de Emiss�o n�o encontrado");
        clicarElemento(campoDataEmissao,"N�o poss�vel clicar no campo confere Data Emissao");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Data de Emiss�o e corrigir a Data de Emiss�o
     *
     * @param dataEmissaoCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere campo Data de Emiss�o e corrigir a Data de Emiss�o")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirDataEmissao(String dataEmissaoCorrecao) throws Exception {
        rolarAteElemento(naoConfereDataEmissao,"Op��o N�o Confere do campo Data de Emiss�o n�o encontrado");
        clicarElemento(naoConfereDataEmissao, "Erro para clicar N�o Confere no campo Data de Emiss�o");
        digitarTexto(correcaoDataEmissao, dataEmissaoCorrecao, "Campo Corre��o da Data de Emiss�o n�o encontrado");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo Data de Emiss�o e corre��o da Data de Emiss�o");
        return this;
    }

    /**
     * Clicar Confere no campo �rg�o Emissor
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo �rg�o Emissor")
    public CardDadosCadastraisTela clicarConfereOrgaoEmissor() throws Exception {
        rolarAteElemento(campoOrgaoEmissor, "Campo �rg�o Emissor n�o encontrado");
        clicarElemento(campoOrgaoEmissor,"N�o foi poss�vel clicar no campo confere �rg�o Emissor");
        return this;
    }

    /**
     * Clicar N�o Confere no campo �rg�o Emissor e corrigir o �rg�o Emissor
     *
     * @param comboOrgaoEmissorCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo �rg�o Emissor e corrigir o �rg�o Emissor")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirOrgaoEmissor(String comboOrgaoEmissorCorrecao) throws Exception {
        rolarAteElemento(naoConfereOrgaoEmissor,"Op��o N�o Confere do campo �rg�o Emissor n�o encontrado");
        clicarElemento(naoConfereOrgaoEmissor, "Erro para clicar N�o Confere no campo �rg�o Emissor");
        selecionarTextoComboboxFnext(correcaoOrgaoEmissor, comboOrgaoEmissorCorrecao, "Erro ao selecionar op��o no combo de Corre��o do campo �rg�o Emissor");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo �rg�o Emissor e corre��o do �rg�o Emissor");
        return this;
    }

    /**
     * Clicar Confere no campo UF �rg�o Emissor
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo UF �rg�o Emissor")
    public CardDadosCadastraisTela clicarConfereUfOrgaoEmissor() throws Exception {
        rolarAteElemento(campoUfOrgaoEmissor, "Campo UF �rg�o Emissor n�o encontrado");
        clicarElemento(campoUfOrgaoEmissor,"N�o foi poss�vel clicar no campo confere UF �rg�o Emissor");

        return this;
    }

    /**
     * Clicar N�o Confere no campo UF �rg�o Emissor e corrigir a UF �rg�o Emissor
     *
     * @param comboUfOrgaoEmissorCorrecao
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo UF �rg�o Emissor e corrigir a UF �rg�o Emissor")
    public CardDadosCadastraisTela clicarNaoConfereCorrigirUfOrgaoEmissor(String comboUfOrgaoEmissorCorrecao) throws Exception {
        rolarAteElemento(naoConfereUfOrgaoEmissor,"Op��o N�o Confere do campo UF �rg�o Emissor n�o encontrado");
        clicarElemento(naoConfereUfOrgaoEmissor, "Erro para clicar N�o Confere no campo UF �rg�o Emissor");
        selecionarTextoComboboxFnext(correcaoUfOrgaoEmissor, comboUfOrgaoEmissorCorrecao, "Erro ao selecionar op��o no combo de Corre��o do campo UF �rg�o Emissor");
        salvarEvidencia("Sele��o da op��o N�o Confere para o campo UF �rg�o Emissor e corre��o da UF �rg�o Emissor");
        return this;
    }

    /**
     * Preencher o campo Data de Emiss�o
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo Data de Emiss�o")
    public CardDadosCadastraisTela preencherDataEmissao(String data) throws Exception {
        rolarAteElemento(campoDigitarDataEmissao, "Campo Data de Emiss�o n�o encontrado");
        digitarTexto(campoDigitarDataEmissao, data,"N�o foi possivel encontrar o campo para digita��o da Data de Emiss�o do Documento");
        salvarEvidencia("Campo de data de Emiss�o do documento preenchida: " + data);
        return this;
    }

    /**
     * Selecionar combo do �rg�o Emissor do documento de identifica��o
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar op��o no campo �rg�o Emissor")
    public CardDadosCadastraisTela selecionarComboOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboOrgaoEmissor);
        selecionarTextoComboboxFnext(comboOrgaoEmissor, combo,"N�o foi poss�vel selecionar op��o de �rg�o emissor");
        return this;
    }

    /**
     * Selecionar combo do UF do �rg�o Emissor do documento de identifica��o
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar op��o no campo UF do �rg�o Emissor")
    public CardDadosCadastraisTela selecionarComboUfOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboUfOrgaoEmissor);
        selecionarTextoComboboxFnext(comboUfOrgaoEmissor, combo, "Erro selecionar op��o no campo UF �rg�o Emissor");
        salvarEvidencia("Selecionada op��o no combo do UF �rg�o Emissor do documento de identifica��o");
        return this;
    }
}
