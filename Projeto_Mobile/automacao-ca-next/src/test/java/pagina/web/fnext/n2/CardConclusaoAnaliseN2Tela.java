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

    @FindBy(xpath = "//*[text()=\" CONTAMINAÇÃO POR FRAUDE - RESPONSÁVEL \"]")
    private WebElement checkboxContaminacaoResponsavelJoyII;

    @FindBy(xpath = "//*[text()= \" ADULTERAÇÃO DE DADOS DO PRÓPRIO DOCUMENTO DE IDENTIFICAÇÃO - RESPONSÁVEL \"]")
    private WebElement checkboxAdulteracaoDeDadosDocumentoJoyII;

    @FindBy(xpath = "//*[text() = \" SOBREPOSIÇÃO DE FOTO DO PRÓPRIO DOCUMENTO DE IDENTIFICAÇÃO - RESPONSÁVEL \"]")
    private WebElement checkboxSobreposicaoFotoDocumentoJoyII;

    @FindBy(xpath = "//*[text() = \" ADULTERAÇÃO DE DADOS DO PRÓPRIO DOC. DE IDENTIFICAÇÃO \"]")
    private WebElement checkboxAdulteracaoDeDadosDocumentoNext;

    @FindBy(xpath = "//*[@formcontrolname=\"descriptionAnalysis\"]")
    private WebElement campoDescricaoDaAnaliseDeN2;

    @FindBy(xpath = "//label[text()='Observações N2:']/following::textarea")
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
     * Método para selecionar combo teste
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combo Resultado Etapa em N2")
    public CardConclusaoAnaliseN2Tela selecionarComboResultadoEtapa(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboResultadoEtapa);
        selecionarTextoComboboxFnext(comboResultadoEtapa, combo,"Não foi possível selecionar opção");
        salvarEvidencia("Selecionando combo Resultado da Etapa");
        return this;
    }

    /**
     * Método para selecionar Motivo
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar combo Motivo em N2")
    public CardConclusaoAnaliseN2Tela selecionarComboMotivo(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboMotivo);
        selecionarTextoComboboxFnext(comboMotivo, combo,"Não foi possível selecionar opção no combo Motivo");
        salvarEvidencia("Selecionando combo Motivo");
        return this;
    }

    /**
     * Método para Clicar Sub Motivo da Conclusão
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar subMotivo da Conclusão de análise")
    public CardConclusaoAnaliseN2Tela clicarSubMotivo(String opcao) throws Exception{
        rolarParaBaixoAteElemento(subMotivos);
        clicarElemento(checkboxContaminacaoPorFraude, "Não foi possível clicar no sub motivo");
        salvarEvidencia("Selecionando sub motivo de Recusa N2");
        return this;
    }

    /**
     * Método para Clicar Sub Motivo da Conclusão CPF Pertence a Outra Pessoa
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar subMotivo da Conclusão de análise")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoCpfPertenceOutraPessoa() throws Exception{
        rolarParaBaixoAteElemento(subMotivos);
        clicarElemento(checkboxCpfPertenceOutraPessoa, "Não foi possível clicar no submotivo");
        salvarEvidencia("Selecionando sub motivo de Recusa N2");
        return this;
    }

    /**
     * Método para Clicar submotivo Contaminação Por Fraude - Responsável de uma adesão Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo da Conclusão da Análise")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoContiminacaoResponsavelJoyII() throws Exception {
        rolarAteElemento(checkboxContaminacaoResponsavelJoyII, "Checkbox de Contaminação Por Fraude - Responsável não encontrado");
        clicarElemento(checkboxContaminacaoResponsavelJoyII, "Não foi possível clicar na checkbox de Contaminação Por Fraude - Responsável");
        salvarEvidencia("Checkbox Contaminação Por Fraude - Responsável selecionada");
        return this;
    }

    /**
     * Método para Clicar submotivo Adulteração de Dados do Próprio Documento de Identificação - Responsável, de uma adesão Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no submotivo Adulteração de Dados do Próprio Documento de Identificação - Responsável")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoAdulteracaoDeDadosDocumentoJoyII() throws Exception{
        rolarAteElemento(checkboxAdulteracaoDeDadosDocumentoJoyII,"Checkbox de Adulteração de Dados do Próprio Documento de Identificação - Responsável não encontrado");
        clicarElemento(checkboxAdulteracaoDeDadosDocumentoJoyII,"Não foi possível clicar na checkbox de Adulteração de Dados do Próprio Documento de Identificação - Responsável");
        salvarEvidencia("Checkbox de Adulteração de Dados do Próprio Documento de Identificação - Responsável");
        return this;
    }

    /**
     * Método para Clicar submotivo Sobreposição de Foto do Próprio Documento de Identificação - Responsável, de uma adesão Joy II
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo Sobreposição de Foto do Próprio Documento de Identificação - Responsável")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoSobreposicaoFotoDocumentoJoyII() throws Exception{
        rolarAteElemento(checkboxSobreposicaoFotoDocumentoJoyII, "Checkbox de Sobreposição de Foto do Próprio Documento de Identificação - Responsável não encontrado");
        clicarElemento(checkboxSobreposicaoFotoDocumentoJoyII,"Não foi possível clicar na checkbox de Sobreposição de Foto do Próprio Documento de Identificação - Responsável");
        salvarEvidencia("Checkbox de Sobreposição de Foto do Próprio Documento de Identificação - Responsável");
        return this;
    }

    /**
     * Método para Clicar submotivo Adulteração de Dados do Próprio Doc. de Identificação, de uma adesão Next
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo Adulteração de Dados do Próprio Doc. de Identificação")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoAdulteracaoDeDadosDocumentoNext() throws Exception {
        rolarAteElemento(checkboxAdulteracaoDeDadosDocumentoNext, "Checkbox de Adulteração de Dados do Próprio Doc. de Identificação não encontrado");
        clicarElemento(checkboxAdulteracaoDeDadosDocumentoNext,"Não foi possível clicar no checkbox de Adulteração de Dados do Próprio Doc. de Identificação");
        salvarEvidencia("Checkbox de Adulteração de Dados do Próprio Doc. de Identificação selecionado");
        return this;
    }

    /**
     * Método para Digitar no Campo Descrição da Analise de N2
     *
     * @param descricaoAnaliseN2
     * @return
     * @throws Exception
     */
    @Step("Digitar Campo Descrição da Analise de N2")
    public CardConclusaoAnaliseN2Tela digitarCampoDescricaoAnaliseN2(String descricaoAnaliseN2) throws Exception{
        rolarParaBaixoAteElemento(campoDescricaoDaAnaliseDeN2);
        digitarTexto(campoDescricaoDaAnaliseDeN2,descricaoAnaliseN2,"O campo Descrição da Análise de N2 não foi encontrado");
        salvarEvidencia("Digitar Campo Descrição da Analise de N2");
        return this;
    }

    /**
     * Método para Digitar no Campo Descrição da Analise de N2 e Validar Limite de Caracteres
     *
     * @param descricaoAnaliseN2
     * @return
     * @throws Exception
     */
    @Step("Digitar Campo Descrição da Analise de N2 e Validar Limite de Caracteres")
    public CardConclusaoAnaliseN2Tela digitarCampoDescricaoAnaliseN2ValidarLimiteCaracteres(String descricaoAnaliseN2) throws Exception{
        rolarParaBaixoAteElemento(campoDescricaoDaAnaliseDeN2);
        digitarTexto(campoDescricaoDaAnaliseDeN2,descricaoAnaliseN2,"O campo Descrição da Análise de N2 não foi encontrado");
        aguardarCarregamentoElemento(mensagemCaractereExcedidaDescricaoDaAnaliseN2);
        salvarEvidencia("Digitar Campo Descrição da Analise de N2");
        return this;
    }


    /**
     * Método para Digitar no Campo Observações de N2
     *
     * @param observacoesdeN2
     * @return
     * @throws Exception
     */
    @Step("Digitar Campo Observações de N2 e Validar Limite de Caracteres")
    public CardConclusaoAnaliseN2Tela digitarCampoObservacoesdeN2ValidarLimiteCaracteres(String observacoesdeN2) throws Exception{
        digitarTexto(campoObservacoesN2,observacoesdeN2,"O campo Observações de N2 não foi encontrado");
        aguardarCarregamentoElemento(mensagemCaractereExcedidaObservacoesN2);
        salvarEvidencia("Digitar Campo Observações de N2");
        return this;
    }

    /**
     * Método para Clicar submotivo Responsável Sem Doc GCCN e Contexto de Risco de uma adesão Joy Multibanco
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar submotivo Responsável Sem Doc GCCN e Contexto de Risco")
    public CardConclusaoAnaliseN2Tela clicarSubMotivoResposavelSemDocGccnEContextoRisco() throws Exception{
        rolarParaBaixoAteElemento(subMotivos);
        clicarElemento(checkboxResposavelSemDocGccnEContextoRisco, "Não foi possível clicar no submotivo");
        salvarEvidencia("Selecionando sub motivo de Recusa N2");
        return this;
    }

    /**
     * Método para Clicar no botão Voltar"
     *
     * @retur
     * @throws Exception
     */
    @Step("Clicar no botao Voltar")
    public CardConclusaoAnaliseN2Tela clicarBotaoVoltar() throws Exception{
        rolarAteElemento(botaoVoltar,"Botão Voltar não encontrado!");
        aguardarElementoClicavel(botaoVoltar);
        clicarElemento(botaoVoltar, "Não foi possível clicar no botão Voltar");
        salvarEvidencia("Clicar no Botão Voltar");
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
        validarCondicaoBooleana(verificarPresencaElemento(campoLivenessPositivo), MetodoComparacaoBooleano.VERDADEIRO, "Campo Liveness com match Positivo não encontrado");
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
        validarCondicaoBooleana(verificarPresencaElemento(campoBureauDeFacePositivo), MetodoComparacaoBooleano.VERDADEIRO,"Campo Bureau de Face com match Positivo não encontrado");
        salvarEvidencia("Campo Bureau de Face com match Positivo na tela de Consulta da Proposta N2");
        return this;
    }

}

