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
        rolarAteElemento(confereCpf, "Campo Confere CPF do dependente não encontrado");
        clicarElemento(confereCpf, "Erro para clicar Confere no campo CPF do dependente");
        salvarEvidencia("Selecionado Confere no campo CPF do dependente");
        return this;
    }

    /**
     * Clicar Confere campo CPF Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo CPF do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereCpfResponsavel() throws Exception {
        rolarAteElemento(confereCpfResponsavel,"Confere no Campo CPF do responsável não encontrado");
        clicarElemento(confereCpfResponsavel, "Erro ao clicar Confere no campo CPF responsável");
        salvarEvidencia("Selecionado Confere para o CPF do responsável");
        return this;
    }

    /**
     * Clicar Não Confere campo CPF do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo CPF do dependente")
    public CardDadosCadastraisJoyIITela clicarNaoConfereCpf() throws Exception {
        rolarAteElemento(naoConfereCpf, "Não Confere no campo CPF do dependente não encontrado");
        clicarElemento(naoConfereCpf, "Erro para clicar Não Confere no campo CPF do dependente");
        salvarEvidencia("Selecionado Não Confere no campo CPF do dependente");
        return this;
    }

    /**
     * Clicar Não Confere campo CPF do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo CPF do responsável")
    public CardDadosCadastraisJoyIITela clicarNaoConfereCpfResponsavel() throws Exception {
        rolarAteElemento(naoConfereCpfResponsavel, "Não Confere no campo CPF do responsável não encontrado");
        clicarElemento(naoConfereCpfResponsavel, "Erro para clicar Não Confere no campo CPF do responsável");
        salvarEvidencia("Selecionado Não Confere no campo CPF do responsável");
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
        rolarAteElemento(confereNomeCompleto, "Confere no campo Nome Completo do dependente não encontrado");
        aguardarElementoClicavel(confereNomeCompleto);
        clicarElemento(confereNomeCompleto, "Erro para clicar Confere no campo Nome Completo do dependente");
        return this;
    }

    /**
     * Clicar Confere campo Nome Completo do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere para o Nome Completo do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereNomeCompletoResponsavel() throws Exception {
        rolarAteElemento(confereNomeResponsavel, "Confere no campo Nome Completo do responsável não encontrado");
        clicarElemento(confereNomeResponsavel, "Erro ao cliar Confere para o nome do Responsável");
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
        rolarAteElemento(confereDataNascimento, "Confere no campo Data de Nascimento do dependente não encontrado");
        clicarElemento(confereDataNascimento, "Erro para clicar Confere no campo Data de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para Data de Nascimento do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Data de Nascimento do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereDataNascimentResponsavel() throws Exception {
        rolarAteElemento(confereDataNascimentResponsavel, "Confere no campo Data de Nascimento do responsável não encontrado");
        clicarElemento(confereDataNascimentResponsavel, "Erro para clicar Confere para Data de Nascimento do responsável");
        return this;
    }

    /**
     * Clicar Confere campo País de Nascimento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo País de Nascimento do dependente")
    public CardDadosCadastraisJoyIITela clicarConferePaisNascimento() throws Exception {
        rolarAteElemento(conferePaisNascimento, "Confere no campo País de Nascimento do dependente não encontrado");
        clicarElemento(conferePaisNascimento, "Erro para clicar Confere no campo País de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para País de Nascimento do responsável
     *
     * @return
     * @throwns
     */
    @Step("Clicar Confere no campo País do Nascimento do responsável")
    public CardDadosCadastraisJoyIITela clicarConferePaisNascimentoResponsavel() throws Exception {
        rolarAteElemento(conferePaisNascimentoResponsavel, "Confere no campo País de Nascimento do responsável não encontrado");
        clicarElemento(conferePaisNascimentoResponsavel, "Erro para clicar Confere para País de Nascimento do responsável");
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
        rolarAteElemento(confereUfNascimento, "Confere no campo UF de Nascimento do dependente não encontrado");
        clicarElemento(confereUfNascimento, "Erro para clicar Confere no campo UF de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para UF de Nascimento do responsável
     * @return
     * @throws Exception
     */
    @Step("Clica Confere para UF de Nascimento do Responsável")
    public CardDadosCadastraisJoyIITela clicarConfereUfNascimentoResponsavel() throws Exception{
        rolarAteElemento(confereUfNascimentoResponsavel, "Confere no campo UF de Nascimento do responsável não encontrado");
        clicarElemento(confereUfNascimentoResponsavel, "Erro para clicar Confere no campo UF de Nascimento do responsável");
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
        rolarAteElemento(confereCidadeNascimento, "Confere no campo Cidade de Nascimento do dependente não encontrado");
        clicarElemento(confereCidadeNascimento, "Erro para clicar Confere no campo Cidade de Nascimento do dependente");
        return this;
    }

    /**
     * Clicar Confere para Cidade de Nascimento do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Cidade de Nascimento do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereCidadeNascimentoResponsavel() throws Exception {
        rolarAteElemento(confereCidadeNascimentoResponsavel, "Confere no campo Cidade de Nascimento do responsável não encontrado");
        clicarElemento(confereCidadeNascimentoResponsavel, "Erro para clicar Confere para Cidade de Nascimento do responsável");
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
        rolarAteElemento(confereSexo, "Confere no campo Sexo do dependente não encontrado");
        clicarElemento(confereSexo, "Erro para clicar Confere no campo Sexo do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo Sexo do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para o Campo Sexo do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereSexoResponsavel() throws Exception {
        rolarAteElemento(confereSexoResponsavel, "Confere no campo Sexo do responsável não encontrado");
        clicarElemento(confereSexoResponsavel, "Erro ao clicar Confere no campo Sexo do responsável");
        return this;
    }

    /**
     * Clicar Confere campo Vínculo Responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Vínculo Responsável")
    public CardDadosCadastraisJoyIITela clicarConfereVinculoResponsavel() throws Exception {
        rolarAteElemento(confereVinculoResponsavel, "Confere no campo Vínculo Responsável não encontrado");
        clicarElemento(confereVinculoResponsavel, "Erro para clicar Confere no campo Vínculo Responsável");
        return this;
    }

    /**
     * Clicar Confere campo Nome da Mãe do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Nome da Mãe do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereNomeMae() throws Exception {
        rolarAteElemento(confereNomeMae, "Confere no campo Nome da Mãe do dependente não encontrado");
        clicarElemento(confereNomeMae, "Erro para clicar Confere no campo Nome da Mãe do dependente");
        salvarEvidencia("Selecionar confere Nome Mãe do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo Nome da Mãe do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Nome da Mãe do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereNomeMaeResponsavel() throws Exception {
        rolarAteElemento(confereNomeMaeResponsavel, "Confere no campo Nome da Mãe do responsável não encontrado");
        clicarElemento(confereNomeMaeResponsavel, "Erro ao clicar Confere para Nome da Mãe do responsável");
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
        rolarAteElemento(confereNomePai, "Confere no campo Nome do Pai do dependente não encontrado");
        clicarElemento(confereNomePai, "Erro para clicar Confere no campo Nome do Pai do dependente");
        return this;
    }

    /**
     * Clicar não Confere campo Nome do Pai do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Não Confere no campo Nome do Pai do dependente")
    public CardDadosCadastraisJoyIITela clicarNaoConfereNomePai() throws Exception {
        rolarAteElemento(naoConfereNomePai, "Não Confere no campo Nome do Pai do dependente não encontrado");
        clicarElemento(naoConfereNomePai, "Erro para clicar Não Confere no campo Nome do Pai do dependente");
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
        rolarAteElemento(paiDesconhecido, "Checkbox 'Desconhecido' Nome do Pai do dependente não encontrado");
        clicarElemento(paiDesconhecido, "Erro para clicar na checkbox Desconhecido no campo Nome do Pai do dependente");
        return this;
    }

    /**
     * Clicar Desconhecido no Nome do Pai do responsável quando não existe check de avaliação
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Desconhecido para o Nome do Pai do responsável")
    public CardDadosCadastraisJoyIITela clicarPaiDesconhecidoResponsavel() throws Exception {
        rolarAteElemento(paiDesconhecidoResponsavel, "Checkbox 'Deconhecido' para o Nome do Pai do responsável não encontrado");
        clicarElemento(paiDesconhecidoResponsavel, "Erro ao clicar na checkbox Desconhecido para Nome do Pai do responsável ");
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
        rolarAteElemento(paiDesconhecidoComCheck, "Campo 'Desconhecido' Nome do Pai do dependente não encontrado");
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
        rolarAteElemento(confereTipoDoc, "Confere no campo Tipo de Documento do dependente não encontrado");
        clicarElemento(confereTipoDoc, "Erro para clicar Confere no campo Tipo de Documento do dependente");
        return this;
    }

    /**
     * Clicar Confere no Tipo de Documento do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no Tipo de Documento do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereTipoDocumentoResponsavel() throws Exception {
        rolarAteElemento(confereTipoDocResponsavel, "Confere no campo Tipo de Documento do responável não encontrado");
        clicarElemento(confereTipoDocResponsavel, "Erro para clicar Confere para o Tipo de Documento do responsável");
        return this;
    }

    /**
     * Clicar Confere campo Número do Documento do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Número do Documento do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereNumeroDocumento() throws Exception {
        rolarAteElemento(confereNumeroDoc, "Confere no campo Número do Documento do dependente não encontrado");
        clicarElemento(confereNumeroDoc, "Erro para clicar Confere no campo Número do Documento do dependente");
        return this;
    }

    /**
     * Clicar Confere para o Número de Documento do responsável
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere para Número de Documento do responsável")
    public CardDadosCadastraisJoyIITela clicarConfereNumeroDocumentoResponsavel() throws Exception {
        rolarAteElemento(confereNumeroDocResponsavel, "Confere no campo Número do Documento do responsável não encontrado");
        clicarElemento(confereNumeroDocResponsavel, "Erro para clicar Confere no campo Número do Documento do responsável");
        return this;
    }

    /**
     * Clicar Confere no campo Data de Emissão do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Data de Emissão do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereDataEmissao() throws Exception {
        rolarAteElemento(campoDataEmissao, "Confere no campo Data de Emissão do dependente não encontrado");
        clicarElemento(campoDataEmissao,"Não possível clicar no campo confere Data Emissao do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo Órgão Emissor do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo Órgão Emissor")
    public CardDadosCadastraisJoyIITela clicarConfereOrgaoEmissor() throws Exception {
        rolarAteElemento(campoOrgaoEmissor, "Confere no campo Órgão Emissor do dependente não encontrado");
        clicarElemento(campoOrgaoEmissor,"Não foi possível clicar no campo confere Órgão Emissor do dependente");
        return this;
    }

    /**
     * Clicar Confere no campo UF Órgão Emissor do dependente
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo UF Órgão Emissor do dependente")
    public CardDadosCadastraisJoyIITela clicarConfereUfOrgaoEmissor() throws Exception {
        rolarAteElemento(campoUfOrgaoEmissor, "Campo UF Órgão Emissor do dependente não encontrado");
        clicarElemento(campoUfOrgaoEmissor,"Não foi possível clicar no campo confere UF Órgão Emissor do dependente");

        return this;
    }

    /**
     * Preencher o campo Data de Emissão do dependente
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo Data de Emissão do dependente")
    public CardDadosCadastraisJoyIITela preencherDataEmissao(String data) throws Exception {
        rolarAteElemento(campoDigitarDataEmissao, "Campo de texto da Data de Emissão do documento do dependente não encontrado");
        digitarTexto(campoDigitarDataEmissao, data,"Não foi possivel encontrar o campo para digitação da Data de Emissão do Documento do dependente");
        salvarEvidencia("Campo de Data de Emissão do dependente do documento preenchida: " + data);
        return this;
    }

    /**
     * Preencher o campo Data de Emissão do responsável
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo Data Emissão do responsável")
    public CardDadosCadastraisJoyIITela preencherDataEmissaoResponsavel(String data) throws Exception {
        rolarAteElemento(campoDataEmissaoResponsavel, "Campo de texto da Data de Emissão do documento do responsável não encontrado");
        digitarTexto(campoDataEmissaoResponsavel, data, "Não foi possivel digitar no campo Data de Emissão do responsável");
        return this;
    }

    /**
     * Selecionar combo do Órgão Emissor do documento de identificação do dependente
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar opção no campo Órgão Emissor do dependente")
    public CardDadosCadastraisJoyIITela selecionarComboOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboOrgaoEmissor);
        selecionarTextoComboboxFnext(comboOrgaoEmissor, combo,"Não foi possível selecionar opção de Órgão Emissor do dependente");
        return this;
    }

    /**
     * Selecionar combo do Órgão Emissor do documento do responsável
     *
     * @param combo
     * @return
     * @throws
     */
    @Step("Selecionar combo do Órgão Emissor do documento do responsável")
    public CardDadosCadastraisJoyIITela selecionarComboOrgaoEmissorResponsavel(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboOrgaoEmissorResponsavel);
        selecionarTextoComboboxFnext(comboOrgaoEmissorResponsavel, combo, "Não foi possivel selecionar opção de Órgão Emissor do documento do responsável");
        return this;
    }

    /**
     * Selecionar combo do UF do Órgão Emissor do documento de identificação do dependente
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar opção no campo UF do Órgão Emissor")
    public CardDadosCadastraisJoyIITela selecionarComboUfOrgaoEmissor(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboUfOrgaoEmissor);
        selecionarTextoComboboxFnext(comboUfOrgaoEmissor, combo, "Erro selecionar opção no combo do UF Órgão Emissor do documento do dependente");
        salvarEvidencia("Selecionada opção no combo do UF Órgão Emissor do documento de identificação do dependente");
        return this;
    }

    /**
     * Selecionar combo do UF do Órgão Emissor do documento do responsável
     *
     * @param combo
     * @return
     * @throws Exception
     */
    @Step("Selecionar combo do UF do Órgão Emissor do documento do responsável")
    public CardDadosCadastraisJoyIITela selecionarComboUfOrgaoEmissorResponsavel(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboUfOrgaoEmissorResponsavel);
        selecionarTextoComboboxFnext(comboUfOrgaoEmissorResponsavel, combo, "Erro selecionar opção no combo do UF Órgão Emissor do documento do responsavel");
        salvarEvidencia("Selecionada opções relativas ao documento de identificação do responsável");
        return this;
    }
}
