package pagina.web.fnext.n2;

import base.pagina.web.fnext.PaginaBaseWebFNext;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagina.web.fnext.n1.CardInformacoesPropostaTela;


public class CardConclusaoAnaliseN2Tela extends PaginaBaseWebFNext {

    @FindBy(xpath = "//*[@formcontrolname=\"analysisDecisionUid\"]")
    private WebElement comboResultadoEtapa;

    @FindBy(xpath = "//*[@formcontrolname=\"analysisReasonUid\"]")
    private WebElement comboMotivo;

    @FindBy(xpath = "//div[@formarrayname=\"detailAnalysisReason\"]")
    private WebElement subMotivos;

    @FindBy(id = "mat-checkbox-1")
    private WebElement checkboxContaminacaoPorFraude;

    @FindBy(id = "mat-checkbox-2")
    private WebElement checkboxCpfPertenceOutraPessoa;

    @FindBy(id = "mat-checkbox-3")
    private WebElement checkboxResposavelSemDocGccnEContextoRisco;

    @FindBy(xpath = "//*[text()=\" CONTAMINA��O POR FRAUDE - RESPONS�VEL \"]")
    private WebElement checkboxContaminacaoResponsavelJoyII;

    @FindBy(xpath = "//*[text()= \" ADULTERA��O DE DADOS DO PR�PRIO DOCUMENTO DE IDENTIFICA��O - RESPONS�VEL \"]")
    private WebElement checkboxAdulteracaoDeDadosDocumentoJoyII;

    @FindBy(xpath = "//*[text() = \" SOBREPOSI��O DE FOTO DO PR�PRIO DOCUMENTO DE IDENTIFICA��O - RESPONS�VEL \"]")
    private WebElement checkboxSobreposicaoFotoDocumentoJoyII;

    @FindBy(xpath = "//*[text() = \" ADULTERA��O DE DADOS DO PR�PRIO DOC. DE IDENTIFICA��O \"]")
    private WebElement checkboxAdulteracaoDeDadosDocumentoNext;

    @FindBy(xpath = "//*[@formcontrolname=\"descriptionAnalysis\"]")
    private WebElement campoDescricaoDaAnaliseDeN2;

    @FindBy(xpath = "//label[text()='Observa��es N2:']/following::textarea")
    private WebElement campoObservacoesN2;

    @FindBy(xpath = "//span[text()='0 caracter(es) restante(s)']")
    private WebElement mensagemCaractereExcedidaDescricaoDaAnaliseN2;

    @FindBy(xpath = "//span[text()='0 caracter(es) restante(s)'][2]")
    private WebElement mensagemCaractereExcedidaObservacoesN2;

    @FindBy(xpath = "//button[text()=' Voltar ']")
    private WebElement botaoVoltar;

    @FindBy(xpath="(//label[text()='Liveness:']/..//div[@class='fa fa-circle fa-1x color-green'])[1]")
    private WebElement campoLivenessPositivo;

    @FindBy(xpath="(//label[text()='Bureau de Face:']/..//div[@class='fa fa-circle fa-1x color-green'])[1]")
    private WebElement campoBureauDeFacePositivo;

    public CardConclusaoAnaliseN2Tela(WebDriver driver) {
        super(driver);
            }

    /**
     * M�todo para selecionar combo teste
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combo Resultado Etapa em N2")
    public CardConclusaoAnaliseN2Tela selecionarComboResultadoEtapa(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboResultadoEtapa);
        selecionarTextoComboboxFnext(comboResultadoEtapa, combo,"N�o foi poss�vel selecionar op��o");
        salvarEvidencia("Selecionando combo Resultado da Etapa");
        return this;
    }

    /**
     * M�todo para selecionar Motivo
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combo Motivo em N2")
    public CardConclusaoAnaliseN2Tela selecionarComboMotivo(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboMotivo);
        selecionarTextoComboboxFnext(comboMotivo, combo,"N�o foi poss�vel selecionar op��o no combo Motivo");
        salvarEvidencia("Selecionando combo Motivo");
        return this;
    }

    /**
     * M�todo para Clicar Sub Motivo da Conclus�o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar subMotivo da Conclus�o de an�lise")
    public CardConclusaoAnaliseN2Tela clicarSubMotivo(String opcao) throws Exception{
        rolarParaBaixoAteElemento(subMotivos);
        clicarElemento(checkboxContaminacaoPorFraude, "N�o foi poss�vel clicar no sub motivo");
        salvarEvidencia("Selecionando sub motivo de Recusa N2");
        return this;
    }

    /**
     * M�todo para Clicar Sub Motivo da Conclus�o CPF Pertence a Outra Pessoa
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar subMotivo da Conclus�o de an�lise")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoCpfPertenceOutraPessoa() throws Exception{
        rolarParaBaixoAteElemento(subMotivos);
        clicarElemento(checkboxCpfPertenceOutraPessoa, "N�o foi poss�vel clicar no submotivo");
        salvarEvidencia("Selecionando sub motivo de Recusa N2");
        return this;
    }

    /**
     * M�todo para Clicar submotivo Contamina��o Por Fraude - Respons�vel de uma ades�o Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo da Conclus�o da An�lise")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoContiminacaoResponsavelJoyII() throws Exception {
        rolarAteElemento(checkboxContaminacaoResponsavelJoyII, "Checkbox de Contamina��o Por Fraude - Respons�vel n�o encontrado");
        clicarElemento(checkboxContaminacaoResponsavelJoyII, "N�o foi poss�vel clicar na checkbox de Contamina��o Por Fraude - Respons�vel");
        salvarEvidencia("Checkbox Contamina��o Por Fraude - Respons�vel selecionada");
        return this;
    }

    /**
     * M�todo para Clicar submotivo Adultera��o de Dados do Pr�prio Documento de Identifica��o - Respons�vel, de uma ades�o Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no submotivo Adultera��o de Dados do Pr�prio Documento de Identifica��o - Respons�vel")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoAdulteracaoDeDadosDocumentoJoyII() throws Exception{
        rolarAteElemento(checkboxAdulteracaoDeDadosDocumentoJoyII,"Checkbox de Adultera��o de Dados do Pr�prio Documento de Identifica��o - Respons�vel n�o encontrado");
        clicarElemento(checkboxAdulteracaoDeDadosDocumentoJoyII,"N�o foi poss�vel clicar na checkbox de Adultera��o de Dados do Pr�prio Documento de Identifica��o - Respons�vel");
        salvarEvidencia("Checkbox de Adultera��o de Dados do Pr�prio Documento de Identifica��o - Respons�vel");
        return this;
    }

    /**
     * M�todo para Clicar submotivo Sobreposi��o de Foto do Pr�prio Documento de Identifica��o - Respons�vel, de uma ades�o Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo Sobreposi��o de Foto do Pr�prio Documento de Identifica��o - Respons�vel")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoSobreposicaoFotoDocumentoJoyII() throws Exception{
        rolarAteElemento(checkboxSobreposicaoFotoDocumentoJoyII, "Checkbox de Sobreposi��o de Foto do Pr�prio Documento de Identifica��o - Respons�vel n�o encontrado");
        clicarElemento(checkboxSobreposicaoFotoDocumentoJoyII,"N�o foi poss�vel clicar na checkbox de Sobreposi��o de Foto do Pr�prio Documento de Identifica��o - Respons�vel");
        salvarEvidencia("Checkbox de Sobreposi��o de Foto do Pr�prio Documento de Identifica��o - Respons�vel");
        return this;
    }

    /**
     * M�todo para Clicar submotivo Adultera��o de Dados do Pr�prio Doc. de Identifica��o, de uma ades�o Next
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo Adultera��o de Dados do Pr�prio Doc. de Identifica��o")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoAdulteracaoDeDadosDocumentoNext() throws Exception {
        rolarAteElemento(checkboxAdulteracaoDeDadosDocumentoNext, "Checkbox de Adultera��o de Dados do Pr�prio Doc. de Identifica��o n�o encontrado");
        clicarElemento(checkboxAdulteracaoDeDadosDocumentoNext,"N�o foi poss�vel clicar no checkbox de Adultera��o de Dados do Pr�prio Doc. de Identifica��o");
        salvarEvidencia("Checkbox de Adultera��o de Dados do Pr�prio Doc. de Identifica��o selecionado");
        return this;
    }

    /**
     * M�todo para Digitar no Campo Descri��o da Analise de N2
     *
     * @param descricaoAnaliseN2
     * @return
     * @throws Exception
     */
    @Step("Digitar Campo Descri��o da Analise de N2")
    public CardConclusaoAnaliseN2Tela digitarCampoDescricaoAnaliseN2(String descricaoAnaliseN2) throws Exception{
        rolarParaBaixoAteElemento(campoDescricaoDaAnaliseDeN2);
        digitarTexto(campoDescricaoDaAnaliseDeN2,descricaoAnaliseN2,"O campo Descri��o da An�lise de N2 n�o foi encontrado");
        salvarEvidencia("Digitar Campo Descri��o da Analise de N2");
        return this;
    }

    /**
     * M�todo para Digitar no Campo Descri��o da Analise de N2 e Validar Limite de Caracteres
     *
     * @param descricaoAnaliseN2
     * @return
     * @throws Exception
     */
    @Step("Digitar Campo Descri��o da Analise de N2 e Validar Limite de Caracteres")
    public CardConclusaoAnaliseN2Tela digitarCampoDescricaoAnaliseN2ValidarLimiteCaracteres(String descricaoAnaliseN2) throws Exception{
        rolarParaBaixoAteElemento(campoDescricaoDaAnaliseDeN2);
        digitarTexto(campoDescricaoDaAnaliseDeN2,descricaoAnaliseN2,"O campo Descri��o da An�lise de N2 n�o foi encontrado");
        aguardarCarregamentoElemento(mensagemCaractereExcedidaDescricaoDaAnaliseN2);
        salvarEvidencia("Digitar Campo Descri��o da Analise de N2");
        return this;
    }


    /**
     * M�todo para Digitar no Campo Observa��es de N2
     *
     * @param observacoesdeN2
     * @return
     * @throws Exception
     */
    @Step("Digitar Campo Observa��es de N2 e Validar Limite de Caracteres")
    public CardConclusaoAnaliseN2Tela digitarCampoObservacoesdeN2ValidarLimiteCaracteres(String observacoesdeN2) throws Exception{
        digitarTexto(campoObservacoesN2,observacoesdeN2,"O campo Observa��es de N2 n�o foi encontrado");
        aguardarCarregamentoElemento(mensagemCaractereExcedidaObservacoesN2);
        salvarEvidencia("Digitar Campo Observa��es de N2");
        return this;
    }

    /**
     * M�todo para Clicar submotivo Respons�vel Sem Doc GCCN e Contexto de Risco de uma ades�o Joy Multibanco
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo Respons�vel Sem Doc GCCN e Contexto de Risco")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoResposavelSemDocGccnEContextoRisco() throws Exception{
        rolarParaBaixoAteElemento(subMotivos);
        clicarElemento(checkboxResposavelSemDocGccnEContextoRisco, "N�o foi poss�vel clicar no submotivo");
        salvarEvidencia("Selecionando sub motivo de Recusa N2");
        return this;
    }

    /**
     * M�todo para Clicar no bot�o Voltar"
     *
     * @retur
     * @throws Exception
     */
    @Step("Clicar no botao Voltar")
    public CardConclusaoAnaliseN2Tela clicarBotaoVoltar() throws Exception{
        rolarAteElemento(botaoVoltar,"Bot�o Voltar n�o encontrado!");
        aguardarElementoClicavel(botaoVoltar);
        clicarElemento(botaoVoltar, "N�o foi poss�vel clicar no bot�o Voltar");
        salvarEvidencia("Clicar no Bot�o Voltar");
        return this;
    }

    /**
     * Validar campo Liveness Positivo na tela de Consulta da Proposta N2
     *
     * @return
     * @throws Exception
     */
    @Step("Validar campo Liveness Positivo na tela de Consulta da Proposta N2")
    public CardConclusaoAnaliseN2Tela validarCampoLivenessPositivoTelaConsultaN2() throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(campoLivenessPositivo), MetodoComparacaoBooleano.VERDADEIRO, "Campo Liveness com match Positivo n�o encontrado");
        salvarEvidencia("Campo Liveness com match Positivo na tela de Consulta da Proposta N2");
        return this;
    }

    /**
     * Validar campo Bureau de Face Positivo na tela de Consulta da Proposta N2
     *
     * @return
     */
    @Step("Validar campo Bureau de Face Positivo na tela de Consulta da Proposta N2")
    public CardConclusaoAnaliseN2Tela validarCampoBureauDeFacePositivoTelaConsultaN2() {
        validarCondicaoBooleana(verificarPresencaElemento(campoBureauDeFacePositivo), MetodoComparacaoBooleano.VERDADEIRO,"Campo Bureau de Face com match Positivo n�o encontrado");
        salvarEvidencia("Campo Bureau de Face com match Positivo na tela de Consulta da Proposta N2");
        return this;
    }

}

