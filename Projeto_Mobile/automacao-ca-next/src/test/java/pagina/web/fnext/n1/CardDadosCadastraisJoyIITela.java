package pagina.web.fnext.n1;

import base.pagina.web.fnext.PaginaBaseWebFNext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardDadosCadastraisJoyIITela extends PaginaBaseWebFNext {

    @FindBy(id = "checkCpf")
    private WebElement confereCpf;

    @FindBy(id = "checkCpfResponsible")
    private WebElement confereCpfResponsavel;

    @FindBy(id = "notcheckCpf")
    private WebElement naoConfereCpf;

    @FindBy(id = "notcheckCpfResponsible")
    private WebElement naoConfereCpfResponsavel;

    @FindBy(id = "checkName")
    private WebElement confereNomeCompleto;

    @FindBy(id = "checkNameResponsible")
    private WebElement confereNomeResponsavel;

    @FindBy(id = "checkBirthDate")
    private WebElement confereDataNascimento;

    @FindBy(id = "checkBirthDateResponsible")
    private WebElement confereDataNascimentResponsavel;

    @FindBy(id = "checkParents")
    private WebElement conferePaisNascimento;

    @FindBy(id = "checkParentsResponsible")
    private WebElement conferePaisNascimentoResponsavel;

    @FindBy(id = "checkState")
    private WebElement confereUfNascimento;

    @FindBy(id = "checkStateResponsible")
    private WebElement confereUfNascimentoResponsavel;

    @FindBy(id = "checkCity")
    private WebElement confereCidadeNascimento;

    @FindBy(id = "checkCityResponsible")
    private WebElement confereCidadeNascimentoResponsavel;

    @FindBy(id = "checkGender")
    private WebElement confereSexo;

    @FindBy(id = "checkGenderResponsible")
    private WebElement confereSexoResponsavel;

    @FindBy(id = "checkRelationshipDegree")
    private WebElement confereVinculoResponsavel;

    @FindBy(id = "checkMother")
    private WebElement confereNomeMae;

    @FindBy(id = "checkMothererrorPatternMotherResponsible")
    private WebElement confereNomeMaeResponsavel;

    @FindBy(id = "checkFather")
    private WebElement confereNomePai;

    @FindBy(id = "notCheckFather")
    private WebElement naoConfereNomePai;

    @FindBy(id = "checkTpDoc")
    private WebElement confereTipoDoc;

    @FindBy(id = "checkTpDocResponsible")
    private WebElement confereTipoDocResponsavel;

    @FindBy(id = "checkNumDoc")
    private WebElement confereNumeroDoc;

    @FindBy(id = "checkNumDocResponsible")
    private WebElement confereNumeroDocResponsavel;

    @FindBy(id = "checkIssueDt")
    private WebElement campoDataEmissao;

    @FindBy(id = "valueIssueDt")
    private WebElement campoDigitarDataEmissao;

    @FindBy(id = "valueIssueDtResponsible")
    private WebElement campoDataEmissaoResponsavel;

    @FindBy(id = "checkAgency")
    private WebElement campoOrgaoEmissor;

    @FindBy(id = "valueAgency")
    private WebElement comboOrgaoEmissor;

    @FindBy(id = "valueAgencyResponsible")
    private WebElement comboOrgaoEmissorResponsavel;

    @FindBy(id = "checkUfAgency")
    private WebElement campoUfOrgaoEmissor;

    @FindBy(id = "valueUfAgency")
    private WebElement comboUfOrgaoEmissor;

    @FindBy(id = "valueUfAgencyResponsible")
    private WebElement comboUfOrgaoEmissorResponsavel;

    @FindBy(id = "missingFatherNameReasonId-input")
    private WebElement paiDesconhecido;

    @FindBy(id = "missingFatherNameReasonIdResponsible")
    private WebElement paiDesconhecidoResponsavel;

    @FindBy(id = "checkMissingFatherNameReasonId")
    private WebElement paiDesconhecidoComCheck;

    public CardDadosCadastraisJoyIITela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Confere campo CPF do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo CPF do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereCpf() throws Exception {
        rolarAteElemento(confereCpf, "Campo Confere CPF do dependente n�o encontrado");
        clicarElemento(confereCpf, "Erro para clicar Confere no campo CPF do dependente");
        salvarEvidencia("Selecionado Confere no campo CPF do dependente");
        return this;
    }

    /**
     * Clicar Confere campo CPF Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo CPF do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereCpfResponsavel() throws Exception {
        rolarAteElemento(confereCpfResponsavel,"Confere no Campo CPF do respons�vel n�o encontrado");
        clicarElemento(confereCpfResponsavel, "Erro ao clicar Confere no campo CPF respons�vel");
        salvarEvidencia("Selecionado Confere para o CPF do respons�vel");
        return this;
    }

    /**
     * Clicar N�o Confere campo CPF do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo CPF do dependente")
    public CardDadosCadastraisJoyIITela clicarNaoConfereCpf() throws Exception {
        rolarAteElemento(naoConfereCpf, "N�o Confere no campo CPF do dependente n�o encontrado");
        clicarElemento(naoConfereCpf, "Erro para clicar N�o Confere no campo CPF do dependente");
        salvarEvidencia("Selecionado N�o Confere no campo CPF do dependente");
        return this;
    }

    /**
     * Clicar N�o Confere campo CPF do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo CPF do respons�vel")
    public CardDadosCadastraisJoyIITela clicarNaoConfereCpfResponsavel() throws Exception {
        rolarAteElemento(naoConfereCpfResponsavel, "N�o Confere no campo CPF do respons�vel n�o encontrado");
        clicarElemento(naoConfereCpfResponsavel, "Erro para clicar N�o Confere no campo CPF do respons�vel");
        salvarEvidencia("Selecionado N�o Confere no campo CPF do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Nome completo do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Nome Completo do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereNomeCompleto() throws Exception {
        rolarAteElemento(confereNomeCompleto, "Confere no campo Nome Completo do dependente n�o encontrado");
        aguardarElementoClicavel(confereNomeCompleto);
        clicarElemento(confereNomeCompleto, "Erro para clicar Confere no campo Nome Completo do dependente");
        return this;
    }

    /**
     * Clicar Confere campo Nome Completo do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere para o Nome Completo do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereNomeCompletoResponsavel() throws Exception {
        rolarAteElemento(confereNomeResponsavel, "Confere no campo Nome Completo do respons�vel n�o encontrado");
        clicarElemento(confereNomeResponsavel, "Erro ao cliar Confere para o nome do Respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Data de Nascimento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Data de Nascimento do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereDataNascimento() throws Exception {
        rolarAteElemento(confereDataNascimento, "Confere no campo Data de Nascimento do dependente n�o encontrado");
        clicarElemento(confereDataNascimento, "Erro para clicar Confere no campo Data de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para Data de Nascimento do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Data de Nascimento do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereDataNascimentResponsavel() throws Exception {
        rolarAteElemento(confereDataNascimentResponsavel, "Confere no campo Data de Nascimento do respons�vel n�o encontrado");
        clicarElemento(confereDataNascimentResponsavel, "Erro para clicar Confere para Data de Nascimento do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Pa�s de Nascimento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Pa�s de Nascimento do dependente")
    public CardDadosCadastraisJoyIITela clicarConferePaisNascimento() throws Exception {
        rolarAteElemento(conferePaisNascimento, "Confere no campo Pa�s de Nascimento do dependente n�o encontrado");
        clicarElemento(conferePaisNascimento, "Erro para clicar Confere no campo Pa�s de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para Pa�s de Nascimento do respons�vel
     *
     * @return
     * @throwns
     */
    @Step("Clicar Confere no campo Pa�s do Nascimento do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConferePaisNascimentoResponsavel() throws Exception {
        rolarAteElemento(conferePaisNascimentoResponsavel, "Confere no campo Pa�s de Nascimento do respons�vel n�o encontrado");
        clicarElemento(conferePaisNascimentoResponsavel, "Erro para clicar Confere para Pa�s de Nascimento do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo UF de Nascimento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo UF do Nascimento do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereUfNascimento() throws Exception {
        rolarAteElemento(confereUfNascimento, "Confere no campo UF de Nascimento do dependente n�o encontrado");
        clicarElemento(confereUfNascimento, "Erro para clicar Confere no campo UF de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para UF de Nascimento do respons�vel
     * @return
     * @throws Exception
     */
    @Step("Clica Confere para UF de Nascimento do Respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereUfNascimentoResponsavel() throws Exception{
        rolarAteElemento(confereUfNascimentoResponsavel, "Confere no campo UF de Nascimento do respons�vel n�o encontrado");
        clicarElemento(confereUfNascimentoResponsavel, "Erro para clicar Confere no campo UF de Nascimento do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Cidade de Nascimento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Cidade de Nascimento do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereCidadeNascimento() throws Exception {
        rolarAteElemento(confereCidadeNascimento, "Confere no campo Cidade de Nascimento do dependente n�o encontrado");
        clicarElemento(confereCidadeNascimento, "Erro para clicar Confere no campo Cidade de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para Cidade de Nascimento do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Cidade de Nascimento do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereCidadeNascimentoResponsavel() throws Exception {
        rolarAteElemento(confereCidadeNascimentoResponsavel, "Confere no campo Cidade de Nascimento do respons�vel n�o encontrado");
        clicarElemento(confereCidadeNascimentoResponsavel, "Erro para clicar Confere para Cidade de Nascimento do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Sexo do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Sexo do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereSexo() throws Exception {
        rolarAteElemento(confereSexo, "Confere no campo Sexo do dependente n�o encontrado");
        clicarElemento(confereSexo, "Erro para clicar Confere no campo Sexo do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo Sexo do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para o Campo Sexo do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereSexoResponsavel() throws Exception {
        rolarAteElemento(confereSexoResponsavel, "Confere no campo Sexo do respons�vel n�o encontrado");
        clicarElemento(confereSexoResponsavel, "Erro ao clicar Confere no campo Sexo do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo V�nculo Respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo V�nculo Respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereVinculoResponsavel() throws Exception {
        rolarAteElemento(confereVinculoResponsavel, "Confere no campo V�nculo Respons�vel n�o encontrado");
        clicarElemento(confereVinculoResponsavel, "Erro para clicar Confere no campo V�nculo Respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Nome da M�e do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Nome da M�e do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereNomeMae() throws Exception {
        rolarAteElemento(confereNomeMae, "Confere no campo Nome da M�e do dependente n�o encontrado");
        clicarElemento(confereNomeMae, "Erro para clicar Confere no campo Nome da M�e do dependente");
        salvarEvidencia("Selecionar confere Nome M�e do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo Nome da M�e do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Nome da M�e do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereNomeMaeResponsavel() throws Exception {
        rolarAteElemento(confereNomeMaeResponsavel, "Confere no campo Nome da M�e do respons�vel n�o encontrado");
        clicarElemento(confereNomeMaeResponsavel, "Erro ao clicar Confere para Nome da M�e do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo Nome do Pai do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Nome do Pai do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereNomePai() throws Exception {
        rolarAteElemento(confereNomePai, "Confere no campo Nome do Pai do dependente n�o encontrado");
        clicarElemento(confereNomePai, "Erro para clicar Confere no campo Nome do Pai do dependente");
        return this;
    }

    /**
     * Clicar n�o Confere campo Nome do Pai do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar N�o Confere no campo Nome do Pai do dependente")
    public CardDadosCadastraisJoyIITela clicarNaoConfereNomePai() throws Exception {
        rolarAteElemento(naoConfereNomePai, "N�o Confere no campo Nome do Pai do dependente n�o encontrado");
        clicarElemento(naoConfereNomePai, "Erro para clicar N�o Confere no campo Nome do Pai do dependente");
        return this;
    }

    /**
     * Clicar Desconhecido campo Nome do Pai do dependente quando NAO existe checks para avaliacao
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Desconhecido no campo Nome do Pai do dependente")
    public CardDadosCadastraisJoyIITela clicarPaiDesconhecido() throws Exception {
        rolarAteElemento(paiDesconhecido, "Checkbox 'Desconhecido' Nome do Pai do dependente n�o encontrado");
        clicarElemento(paiDesconhecido, "Erro para clicar na checkbox Desconhecido no campo Nome do Pai do dependente");
        return this;
    }

    /**
     * Clicar Desconhecido no Nome do Pai do respons�vel quando n�o existe check de avalia��o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Desconhecido para o Nome do Pai do respons�vel")
    public CardDadosCadastraisJoyIITela clicarPaiDesconhecidoResponsavel() throws Exception {
        rolarAteElemento(paiDesconhecidoResponsavel, "Checkbox 'Deconhecido' para o Nome do Pai do respons�vel n�o encontrado");
        clicarElemento(paiDesconhecidoResponsavel, "Erro ao clicar na checkbox Desconhecido para Nome do Pai do respons�vel ");
        return this;
    }

    /**
     * Clicar Desconhecido campo Nome do Pai do dependente quando existe checks para avaliacao
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Desconhecido no campo Nome do Pai do dependente")
    public CardDadosCadastraisJoyIITela clicarPaiDesconhecidoComcheck() throws Exception {
        rolarAteElemento(paiDesconhecidoComCheck, "Campo 'Desconhecido' Nome do Pai do dependente n�o encontrado");
        clicarElemento(paiDesconhecidoComCheck, "Erro para clicar Desconhecido no campo Nome do Pai do dependente");
        return this;
    }

    /**
     * Clicar Confere campo Tipo do Documento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Tipo de Documento do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereTipoDocumento() throws Exception {
        rolarAteElemento(confereTipoDoc, "Confere no campo Tipo de Documento do dependente n�o encontrado");
        clicarElemento(confereTipoDoc, "Erro para clicar Confere no campo Tipo de Documento do dependente");
        return this;
    }

    /**
     * Clicar Confere no Tipo de Documento do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no Tipo de Documento do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereTipoDocumentoResponsavel() throws Exception {
        rolarAteElemento(confereTipoDocResponsavel, "Confere no campo Tipo de Documento do respon�vel n�o encontrado");
        clicarElemento(confereTipoDocResponsavel, "Erro para clicar Confere para o Tipo de Documento do respons�vel");
        return this;
    }

    /**
     * Clicar Confere campo N�mero do Documento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo N�mero do Documento do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereNumeroDocumento() throws Exception {
        rolarAteElemento(confereNumeroDoc, "Confere no campo N�mero do Documento do dependente n�o encontrado");
        clicarElemento(confereNumeroDoc, "Erro para clicar Confere no campo N�mero do Documento do dependente");
        return this;
    }

    /**
     * Clicar Confere para o N�mero de Documento do respons�vel
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para N�mero de Documento do respons�vel")
    public CardDadosCadastraisJoyIITela clicarConfereNumeroDocumentoResponsavel() throws Exception {
        rolarAteElemento(confereNumeroDocResponsavel, "Confere no campo N�mero do Documento do respons�vel n�o encontrado");
        clicarElemento(confereNumeroDocResponsavel, "Erro para clicar Confere no campo N�mero do Documento do respons�vel");
        return this;
    }

    /**
     * Clicar Confere no campo Data de Emiss�o do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Data de Emiss�o do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereDataEmissao() throws Exception {
        rolarAteElemento(campoDataEmissao, "Confere no campo Data de Emiss�o do dependente n�o encontrado");
        clicarElemento(campoDataEmissao,"N�o poss�vel clicar no campo confere Data Emissao do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo �rg�o Emissor do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo �rg�o Emissor")
    public CardDadosCadastraisJoyIITela clicarConfereOrgaoEmissor() throws Exception {
        rolarAteElemento(campoOrgaoEmissor, "Confere no campo �rg�o Emissor do dependente n�o encontrado");
        clicarElemento(campoOrgaoEmissor,"N�o foi poss�vel clicar no campo confere �rg�o Emissor do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo UF �rg�o Emissor do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo UF �rg�o Emissor do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereUfOrgaoEmissor() throws Exception {
        rolarAteElemento(campoUfOrgaoEmissor, "Campo UF �rg�o Emissor do dependente n�o encontrado");
        clicarElemento(campoUfOrgaoEmissor,"N�o foi poss�vel clicar no campo confere UF �rg�o Emissor do dependente");

        return this;
    }

    /**
     * Preencher o campo Data de Emiss�o do dependente
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo Data de Emiss�o do dependente")
    public CardDadosCadastraisJoyIITela preencherDataEmissao(String data) throws Exception {
        rolarAteElemento(campoDigitarDataEmissao, "Campo de texto da Data de Emiss�o do documento do dependente n�o encontrado");
        digitarTexto(campoDigitarDataEmissao, data,"N�o foi possivel encontrar o campo para digita��o da Data de Emiss�o do Documento do dependente");
        salvarEvidencia("Campo de Data de Emiss�o do dependente do documento preenchida: " + data);
        return this;
    }

    /**
     * Preencher o campo Data de Emiss�o do respons�vel
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo Data Emiss�o do respons�vel")
    public CardDadosCadastraisJoyIITela preencherDataEmissaoResponsavel(String data) throws Exception {
        rolarAteElemento(campoDataEmissaoResponsavel, "Campo de texto da Data de Emiss�o do documento do respons�vel n�o encontrado");
        digitarTexto(campoDataEmissaoResponsavel, data, "N�o foi possivel digitar no campo Data de Emiss�o do respons�vel");
        return this;
    }

    /**
     * Selecionar combo do �rg�o Emissor do documento de identifica��o do dependente
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar op��o no campo �rg�o Emissor do dependente")
    public CardDadosCadastraisJoyIITela selecionarComboOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboOrgaoEmissor);
        selecionarTextoComboboxFnext(comboOrgaoEmissor, combo,"N�o foi poss�vel selecionar op��o de �rg�o Emissor do dependente");
        return this;
    }

    /**
     * Selecionar combo do �rg�o Emissor do documento do respons�vel
     *
     * @param combo
     * @return
     * @throws
     */
    @Step("Selecionar combo do �rg�o Emissor do documento do respons�vel")
    public CardDadosCadastraisJoyIITela selecionarComboOrgaoEmissorResponsavel(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboOrgaoEmissorResponsavel);
        selecionarTextoComboboxFnext(comboOrgaoEmissorResponsavel, combo, "N�o foi possivel selecionar op��o de �rg�o Emissor do documento do respons�vel");
        return this;
    }

    /**
     * Selecionar combo do UF do �rg�o Emissor do documento de identifica��o do dependente
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar op��o no campo UF do �rg�o Emissor")
    public CardDadosCadastraisJoyIITela selecionarComboUfOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboUfOrgaoEmissor);
        selecionarTextoComboboxFnext(comboUfOrgaoEmissor, combo, "Erro selecionar op��o no combo do UF �rg�o Emissor do documento do dependente");
        salvarEvidencia("Selecionada op��o no combo do UF �rg�o Emissor do documento de identifica��o do dependente");
        return this;
    }

    /**
     * Selecionar combo do UF do �rg�o Emissor do documento do respons�vel
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar combo do UF do �rg�o Emissor do documento do respons�vel")
    public CardDadosCadastraisJoyIITela selecionarComboUfOrgaoEmissorResponsavel(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboUfOrgaoEmissorResponsavel);
        selecionarTextoComboboxFnext(comboUfOrgaoEmissorResponsavel, combo, "Erro selecionar op��o no combo do UF �rg�o Emissor do documento do responsavel");
        salvarEvidencia("Selecionada op��es relativas ao documento de identifica��o do respons�vel");
        return this;
    }
}
