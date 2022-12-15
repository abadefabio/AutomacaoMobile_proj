package pagina.web.fnext.comum;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.web.fnext.TitulosTela;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EtapasDaPropostaTela extends PaginaBaseWeb {

    @FindBy(xpath = "//*[@id=\"listStage\"]/div/div[1]/text()")
    private WebElement tituloEtapasDaProposta;

    @FindBy(xpath = "//em[@mattooltip='Editar']")
    private WebElement botaoEditar;

    @FindBy(xpath = "(//em[@mattooltip='Consultar'])[2]")
    private WebElement botaoConsultarN1;

    @FindBy(xpath = "(//em[@mattooltip='Consultar'])[1]")
    private WebElement botaoConsultarN2;

    @FindBy(xpath = "//*[@mattooltip=\"Reverter Status\"]")
    private WebElement botaoReverterStatus;

    @FindBy(xpath = "//div[@class=\"cdk-overlay-container\"]//*[@id=\"justif\"]")
    private WebElement campoJustificativa;

    @FindBy(xpath = "//button[text()=\"Reverter \"]")
    private WebElement botaoReverter;

    @FindBy(xpath = "//div[@class=\"label-stages text-left\" and text()=\"FINALIZADO\"]")
    private WebElement statusFinalizado;

    @FindBy(xpath = "//td[contains(text(),'TELA DE NEG�CIO ')]")
    private WebElement etapaTelaNegocio;

    @FindBy(xpath = "//td[text()=\"AN�LISE DE CONTA AUTOM�TICA \"]/..//*[text()=\"FINALIZADO\"]")
    private WebElement etapaGerenteAnaliseContaAutomaticaFinalizada;

    @FindBy(xpath = "//td[text()=\"AN�LISE DE CONTA AUTOM�TICA \"]/..//*[text()=\"DERIVADO MANUAL\"]")
    private WebElement etapaGerenteAnaliseContaAutomaticaComoDerivaManual;

    @FindBy(xpath = "//td[text()=\"TELA AN�LISE N1 \"]/../td/strong[text()=\"EM ANDAMENTO\"]")
    private WebElement etapaAnaliseN1EmAndamento;

    @FindBy(xpath = "//td[text()=\"AN�LISE DE CONTA AUTOM�TICA \"]/..//*[text()=\"ABERTURA DE CONTA - N�O\"]")
    private WebElement etapaGerenteAnaliseContaAutomaticaComoAberturaContaNao;

    @FindBy(xpath = "//td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"ATUALIZA��O MOTOR DE SEGURAN�A\"]")
    private WebElement etapaAtualizacaoMotorDeSegurancaComoConcluido;

    @FindBy(xpath = "//td[text()=\"ABERTURA DE CONTA - SIM\"]/../td/strong[text()=\"GERENTE\"]")
    private WebElement etapaGerenteComoAberturaContaSim;

    @FindBy(xpath = "//td[text()=\"ADES�O N�O REALIZADA\"]/../td/strong[text()=\"RESULTADO ADES�O\"]")
    private WebElement resultadoEtapaAdesaoNaoRealizada;

    @FindBy(xpath = "//td[text()=\"PREENCHER PROPOSTA \"]/../td[text()=\"PROPOSTA PREENCHIDA\"]/../td/strong[text()=\"RECEP��O DA PROPOSTA\"]")
    private WebElement etapaPreencherProposta;

    @FindBy(xpath = "//td[text()=\"ADICIONAR FILA GENESYS N1 \"]/../td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"AN�LISE N1\"]")
    private WebElement etapaAdicionarFilaN1;

    @FindBy(xpath = "//td[text()=\"TELA AN�LISE N1 \"]/../td[text()=\"APROVADO\"]/../td/strong[text()=\"AN�LISE N1\"]")
    private WebElement etapaTelaAnaliseN1;

    @FindBy(xpath = "//td[text()=\"CONCLUIR FILA GENESYS N1 \"]/../td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"AN�LISE N1\"]")
    private WebElement etapaConcluirFilaN1;

    @FindBy(xpath = "//td[text()=\"PROCESSAR DOCUMENTO GCCN \"]/../td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"PROCESSAMENTO GCCN\"]")
    private WebElement etapaProcessarDocumentoGCCN;

    @FindBy(xpath = "//td[text()=\"ENVIAR MOTOR SEGURAN�A \"]/../td[text()=\"APROVADO MOTOR\"]/../td/strong[text()=\"MOTOR DE SEGURAN�A\"]")
    private WebElement etapaEnviarMotorSeguranca;

    @FindBy(xpath = "//td[text()=\"ENVIAR ALTERA��O CADASTRAL \"]/../td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"ATUALIZA��O CADASTRAL\"]")
    private WebElement etapaEnviarAlteracaoCadastral;

    @FindBy(xpath = "//td[text()=\"CARIMBO AG�NCIA \"]/../td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"GERENTE\"]")
    private WebElement etapaCarimboAgencia;

    @FindBy(xpath = "//td[text()=\"AN�LISE DE CONTA AUTOM�TICA \"]/../td[text()=\"ABERTURA DE CONTA - SIM\"]/../td/strong[text()=\"GERENTE\"]")
    private WebElement etapaAnaliseContaAutomatica;

    @FindBy(xpath = "//td[text()=\"ENVIAR RESULTADO \"]/../td[text()=\"CONCLU�DO\"]/../td/strong[text()=\"ATUALIZA��O MOTOR DE SEGURAN�A\"]")
    private WebElement etapaEnviarResultado;

    public EtapasDaPropostaTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Validar T�tulo tela Etapas da Proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Validar T�tulo da Tela Etapas da Proposta")
    public EtapasDaPropostaTela validarTituloEtapasDaProposta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TitulosTela.ETAPAS_DA_POSPOSTA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar t�tulo da Etapas da Proposta");
        salvarEvidencia("Validar t�tulo do card Etapas da Proposta");
        return this;
    }

    /**
     * Clicar no bot�o Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o Editar")
    public EtapasDaPropostaTela clicarBotaoEditar() throws Exception{
        salvarEvidencia("Clicar no bot�o editar");
        clicarElemento(botaoEditar,"N�o foi poss�vel clicar no bot�o Editar");
        return this;
    }

    /**
     * Clicar no bot�o Consultar de N1
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o Consultar de N1")
    public EtapasDaPropostaTela clicarBotaoConsultarN1() throws Exception{
        salvarEvidencia("Clicar no bot�o Consultar de N1");
        clicarElemento(botaoConsultarN1,"N�o foi poss�vel clicar no bot�o Consultar de N1");
        return this;
    }

    /**
     * Clicar no bot�o Consultar de N2
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o Consultar de N2")
    public EtapasDaPropostaTela clicarBotaoConsultarN2() throws Exception{
        salvarEvidencia("Clicar no bot�o Consultar de N2");
        clicarElemento(botaoConsultarN2,"N�o foi poss�vel clicar no bot�o Consultar de N2");
        return this;
    }


    /**
     * Clicar no bot�o Reverter Status
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o Reverter Status")
    public EtapasDaPropostaTela clicarBotaoReverterStatus() throws Exception{
        salvarEvidencia("Clicar bot�o Reverter Status");
        clicarElemento(botaoReverterStatus,"N�o foi poss�vel clicar no bot�o Reverter Status nas etapas da proposta");
        return this;
    }

    /**
     * Digitar no campo Justificativa da Revers�o de Status
     *
     * @throws Exception
     */
    @Step("Digitar no campo Justificativa da Revers�o de Status")
    public EtapasDaPropostaTela digitarCampoJustificativa() throws Exception{
        aguardarCarregamentoElemento(campoJustificativa);
        digitarTexto(campoJustificativa, "Testando o campo Justificativa","N�o foi poss�vel digitar no campo Justificativa da Revers�o de Status");
        salvarEvidencia("Digitando no campo Justificativa da Revers�o de Status");
        return this;
    }

    /**
     * Clicar no bot�o Reverter
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o Reverter do Popup de Revers�o de Status")
    public EtapasDaPropostaTela clicarBotaoReverter() throws Exception{
        salvarEvidencia("clicar bot�o Reverter");
        clicarElemento(botaoReverter,"N�o foi poss�vel clicar no bot�o Reverter do Popup de Revers�o de Status");
        return this;
    }

    /**
     * Aguardar carregamento bot�o Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar carregamento bot�o Editar")
    public boolean verificarCarregamentoBotaoEditar() throws Exception{
        salvarEvidencia("Aguardar carregamento bot�o editar");
        return aguardarExistenciaElemento(botaoEditar,3,500);
    }

    /**
     * Aguardar carregamento bot�o ConsultarN1
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar carregamento bot�o ConsultarN1")
    public boolean verificarCarregamentoBotaoConsultarN1() throws Exception{
        salvarEvidencia("Aguardar carregamento bot�o consultar");
        return aguardarExistenciaElemento(botaoConsultarN1,3,500);
    }

    /**
     * Aguardar carregamento bot�o ConsultarN2
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar carregamento bot�o ConsultarN2")
    public boolean verificarCarregamentoBotaoConsultarN2() throws Exception{
        salvarEvidencia("Aguardar carregamento bot�o consultar");
        return aguardarExistenciaElemento(botaoConsultarN2,3,500);
    }


    /**
     * Validar Status da proposta como Finalizado
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Status da proposta como Finalizado")
    public EtapasDaPropostaTela validarStatusFinalizado() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(statusFinalizado),MetodoComparacaoBooleano.VERDADEIRO,"Valida��o da proposta n�o encontrado");
        salvarEvidencia("Validando que a proposta foi Finalizada");
        return this;
    }

    /**
     * Validar Status da proposta como Em Andamento
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar Etapa da proposta Tela de Neg�cio")
    public boolean verificarEtapaTelaNegocio() throws Exception {
        salvarEvidencia("Aguardar Etapa Gerente");
        return aguardarExistenciaElemento(etapaTelaNegocio,3,500);
    }

    /**
     * Aguardar finaliza��o da proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar finaliza��o da proposta")
    public boolean verificarStatusFinalizado() throws Exception{
        salvarEvidencia("Aguardar finaliza��o da proposta");
        return aguardarExistenciaElemento(statusFinalizado,3,500);
    }

    /**
     * Aguardar finaliza��o da etapa An�lise de Conta Autom�tica
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar finaliza��o da etapa An�lise de Conta Autom�tica")
    public boolean verificarAnaliseContaAutomaticaFinalizada() throws Exception{
        salvarEvidencia("Aguardar finaliza��o da proposta");
        return aguardarExistenciaElemento(etapaGerenteAnaliseContaAutomaticaFinalizada,3,500);
    }

    /**
     * Validar Etapa An�lise de Conta Autom�tica como Deriva Manual
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa An�lise de Conta Autom�tica como Deriva Manual")
    public EtapasDaPropostaTela validarAnaliseContaAutomaticaComoDerivaManual() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaGerenteAnaliseContaAutomaticaComoDerivaManual),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa An�lise de Conta Autom�tica como Deriva Manual N�o encontrado");
        salvarEvidencia("Validar Etapa An�lise de Conta Autom�tica como Deriva Manual");
        return this;
    }

    /**
     * Validar que a prospota est� em an�lise N1
     *
     * @return
     * @throws Exception
     */
    @Step("Validar que a proposta est� na An�lise N1")
    public EtapasDaPropostaTela verificarAnaliseN1EmAndamento() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaAnaliseN1EmAndamento),MetodoComparacaoBooleano.VERDADEIRO,"Validar que a proposta est� na An�lise N1 n�o encontrado");
        salvarEvidencia("Validar que a proposta est� na An�lise N1");
        return this;
    }

    /**
     * Validar Etapa An�lise de Conta Autom�tica como Abertura de Conta N�o
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa An�lise de Conta Autom�tica como Abertura de Conta N�o")
    public EtapasDaPropostaTela validarAnaliseContaAutomaticaComoAberturaContaNao() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaGerenteAnaliseContaAutomaticaComoAberturaContaNao),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa An�lise de Conta Autom�tica como Abertura n�o encontrado");
        salvarEvidencia("Validar Etapa An�lise de Conta Autom�tica como Abertura de Conta N�o");
        return this;
    }

    /**
     * Validar Etapa Atualiza��o Motor de Serguran�a como CONCLU�DO
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Atualiza��o Motor de Serguran�a como CONCLU�DO")
    public EtapasDaPropostaTela validarAtualizacaoMotorDeSegurancaConcluido() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(etapaAtualizacaoMotorDeSegurancaComoConcluido),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa Atualiza��o Motor de Serguran�a n�o encontrado");
        salvarEvidencia("Validar Etapa Atualiza��o Motor de Serguran�a como CONCLU�DO");
        return this;
    }

    /**
     * Validar Etapa Gerente como Abertura de Conta Sim
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Gerente como Abertura de Conta Sim")
    public EtapasDaPropostaTela validarEtapaGerenteComoAberturaContaSim() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(etapaGerenteComoAberturaContaSim),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa Gerente como Abertura de Conta Sim n�o encontrada");
        salvarEvidencia("Validar Etapa Gerente como Abertura de Conta Sim");
        return this;
    }

    /**
     * Validar Etapa Resultado Ades�o com Resultado da Etapa Ades�o N�o Realizada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Resultado Ades�o com Resultado da Etapa Ades�o N�o Realizada")
    public EtapasDaPropostaTela validarResultadoDaEtapaAdesaoNaoRealizada() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(resultadoEtapaAdesaoNaoRealizada),MetodoComparacaoBooleano.VERDADEIRO,"Resultado da Etapa de ades�o n�o encontrado");
        salvarEvidencia("Validar Etapa Resultado Ades�o com Resultado da Etapa Ades�o N�o Realizada");
        return this;
    }

    /**
     * Validar Fluxo das Etapas atrav�s do Card Etapas da Proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Fluxo das Etapas atrav�s do Card Etapas da Proposta")
    public EtapasDaPropostaTela validarFluxoEtapasPropostaAnaliseN1() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaPreencherProposta),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da proposta n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaAdicionarFilaN1),MetodoComparacaoBooleano.VERDADEIRO,"Etapa Adicionar Fila N1 n�o esta Presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaTelaAnaliseN1),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da tela Analise N1 n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaConcluirFilaN1),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Conclus�o da Fila N1 n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaProcessarDocumentoGCCN),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Processamento de documentos GCCN n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaEnviarMotorSeguranca),MetodoComparacaoBooleano.VERDADEIRO,"Etapa do envio do Motor Seguran�a n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaEnviarAlteracaoCadastral),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Envio de Altera��o Cadastral n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaCarimboAgencia),MetodoComparacaoBooleano.VERDADEIRO,"O carinbo da agencia n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaAnaliseContaAutomatica),MetodoComparacaoBooleano.VERDADEIRO,"Etapa de Analise Conta Automatica n�o esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaEnviarResultado),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Envio de Resultado n�o esta presente");
        salvarEvidencia("Validar Fluxo das Etapas atrav�s do Card Etapas da Proposta");
        return this;
    }
}

