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

    @FindBy(xpath = "//td[contains(text(),'TELA DE NEGÓCIO ')]")
    private WebElement etapaTelaNegocio;

    @FindBy(xpath = "//td[text()=\"ANÁLISE DE CONTA AUTOMÁTICA \"]/..//*[text()=\"FINALIZADO\"]")
    private WebElement etapaGerenteAnaliseContaAutomaticaFinalizada;

    @FindBy(xpath = "//td[text()=\"ANÁLISE DE CONTA AUTOMÁTICA \"]/..//*[text()=\"DERIVADO MANUAL\"]")
    private WebElement etapaGerenteAnaliseContaAutomaticaComoDerivaManual;

    @FindBy(xpath = "//td[text()=\"TELA ANÁLISE N1 \"]/../td/strong[text()=\"EM ANDAMENTO\"]")
    private WebElement etapaAnaliseN1EmAndamento;

    @FindBy(xpath = "//td[text()=\"ANÁLISE DE CONTA AUTOMÁTICA \"]/..//*[text()=\"ABERTURA DE CONTA - NÃO\"]")
    private WebElement etapaGerenteAnaliseContaAutomaticaComoAberturaContaNao;

    @FindBy(xpath = "//td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"ATUALIZAÇÃO MOTOR DE SEGURANÇA\"]")
    private WebElement etapaAtualizacaoMotorDeSegurancaComoConcluido;

    @FindBy(xpath = "//td[text()=\"ABERTURA DE CONTA - SIM\"]/../td/strong[text()=\"GERENTE\"]")
    private WebElement etapaGerenteComoAberturaContaSim;

    @FindBy(xpath = "//td[text()=\"ADESÃO NÃO REALIZADA\"]/../td/strong[text()=\"RESULTADO ADESÃO\"]")
    private WebElement resultadoEtapaAdesaoNaoRealizada;

    @FindBy(xpath = "//td[text()=\"PREENCHER PROPOSTA \"]/../td[text()=\"PROPOSTA PREENCHIDA\"]/../td/strong[text()=\"RECEPÇÃO DA PROPOSTA\"]")
    private WebElement etapaPreencherProposta;

    @FindBy(xpath = "//td[text()=\"ADICIONAR FILA GENESYS N1 \"]/../td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"ANÁLISE N1\"]")
    private WebElement etapaAdicionarFilaN1;

    @FindBy(xpath = "//td[text()=\"TELA ANÁLISE N1 \"]/../td[text()=\"APROVADO\"]/../td/strong[text()=\"ANÁLISE N1\"]")
    private WebElement etapaTelaAnaliseN1;

    @FindBy(xpath = "//td[text()=\"CONCLUIR FILA GENESYS N1 \"]/../td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"ANÁLISE N1\"]")
    private WebElement etapaConcluirFilaN1;

    @FindBy(xpath = "//td[text()=\"PROCESSAR DOCUMENTO GCCN \"]/../td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"PROCESSAMENTO GCCN\"]")
    private WebElement etapaProcessarDocumentoGCCN;

    @FindBy(xpath = "//td[text()=\"ENVIAR MOTOR SEGURANÇA \"]/../td[text()=\"APROVADO MOTOR\"]/../td/strong[text()=\"MOTOR DE SEGURANÇA\"]")
    private WebElement etapaEnviarMotorSeguranca;

    @FindBy(xpath = "//td[text()=\"ENVIAR ALTERAÇÃO CADASTRAL \"]/../td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"ATUALIZAÇÃO CADASTRAL\"]")
    private WebElement etapaEnviarAlteracaoCadastral;

    @FindBy(xpath = "//td[text()=\"CARIMBO AGÊNCIA \"]/../td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"GERENTE\"]")
    private WebElement etapaCarimboAgencia;

    @FindBy(xpath = "//td[text()=\"ANÁLISE DE CONTA AUTOMÁTICA \"]/../td[text()=\"ABERTURA DE CONTA - SIM\"]/../td/strong[text()=\"GERENTE\"]")
    private WebElement etapaAnaliseContaAutomatica;

    @FindBy(xpath = "//td[text()=\"ENVIAR RESULTADO \"]/../td[text()=\"CONCLUÍDO\"]/../td/strong[text()=\"ATUALIZAÇÃO MOTOR DE SEGURANÇA\"]")
    private WebElement etapaEnviarResultado;

    public EtapasDaPropostaTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Validar Título tela Etapas da Proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Título da Tela Etapas da Proposta")
    public EtapasDaPropostaTela validarTituloEtapasDaProposta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TitulosTela.ETAPAS_DA_POSPOSTA), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar título da Etapas da Proposta");
        salvarEvidencia("Validar título do card Etapas da Proposta");
        return this;
    }

    /**
     * Clicar no botão Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão Editar")
    public EtapasDaPropostaTela clicarBotaoEditar() throws Exception{
        salvarEvidencia("Clicar no botão editar");
        clicarElemento(botaoEditar,"Não foi possível clicar no botão Editar");
        return this;
    }

    /**
     * Clicar no botão Consultar de N1
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão Consultar de N1")
    public EtapasDaPropostaTela clicarBotaoConsultarN1() throws Exception{
        salvarEvidencia("Clicar no botão Consultar de N1");
        clicarElemento(botaoConsultarN1,"Não foi possível clicar no botão Consultar de N1");
        return this;
    }

    /**
     * Clicar no botão Consultar de N2
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão Consultar de N2")
    public EtapasDaPropostaTela clicarBotaoConsultarN2() throws Exception{
        salvarEvidencia("Clicar no botão Consultar de N2");
        clicarElemento(botaoConsultarN2,"Não foi possível clicar no botão Consultar de N2");
        return this;
    }


    /**
     * Clicar no botão Reverter Status
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão Reverter Status")
    public EtapasDaPropostaTela clicarBotaoReverterStatus() throws Exception{
        salvarEvidencia("Clicar botão Reverter Status");
        clicarElemento(botaoReverterStatus,"Não foi possível clicar no botão Reverter Status nas etapas da proposta");
        return this;
    }

    /**
     * Digitar no campo Justificativa da Reversão de Status
     *
     * @throws Exception
     */
    @Step("Digitar no campo Justificativa da Reversão de Status")
    public EtapasDaPropostaTela digitarCampoJustificativa() throws Exception{
        aguardarCarregamentoElemento(campoJustificativa);
        digitarTexto(campoJustificativa, "Testando o campo Justificativa","Não foi possível digitar no campo Justificativa da Reversão de Status");
        salvarEvidencia("Digitando no campo Justificativa da Reversão de Status");
        return this;
    }

    /**
     * Clicar no botão Reverter
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão Reverter do Popup de Reversão de Status")
    public EtapasDaPropostaTela clicarBotaoReverter() throws Exception{
        salvarEvidencia("clicar botão Reverter");
        clicarElemento(botaoReverter,"Não foi possível clicar no botão Reverter do Popup de Reversão de Status");
        return this;
    }

    /**
     * Aguardar carregamento botão Editar
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar carregamento botão Editar")
    public boolean verificarCarregamentoBotaoEditar() throws Exception{
        salvarEvidencia("Aguardar carregamento botão editar");
        return aguardarExistenciaElemento(botaoEditar,3,500);
    }

    /**
     * Aguardar carregamento botão ConsultarN1
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar carregamento botão ConsultarN1")
    public boolean verificarCarregamentoBotaoConsultarN1() throws Exception{
        salvarEvidencia("Aguardar carregamento botão consultar");
        return aguardarExistenciaElemento(botaoConsultarN1,3,500);
    }

    /**
     * Aguardar carregamento botão ConsultarN2
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar carregamento botão ConsultarN2")
    public boolean verificarCarregamentoBotaoConsultarN2() throws Exception{
        salvarEvidencia("Aguardar carregamento botão consultar");
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
        validarCondicaoBooleana(aguardarExistenciaElemento(statusFinalizado),MetodoComparacaoBooleano.VERDADEIRO,"Validação da proposta não encontrado");
        salvarEvidencia("Validando que a proposta foi Finalizada");
        return this;
    }

    /**
     * Validar Status da proposta como Em Andamento
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar Etapa da proposta Tela de Negócio")
    public boolean verificarEtapaTelaNegocio() throws Exception {
        salvarEvidencia("Aguardar Etapa Gerente");
        return aguardarExistenciaElemento(etapaTelaNegocio,3,500);
    }

    /**
     * Aguardar finalização da proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar finalização da proposta")
    public boolean verificarStatusFinalizado() throws Exception{
        salvarEvidencia("Aguardar finalização da proposta");
        return aguardarExistenciaElemento(statusFinalizado,3,500);
    }

    /**
     * Aguardar finalização da etapa Análise de Conta Automática
     *
     * @return
     * @throws Exception
     */
    @Step("Aguardar finalização da etapa Análise de Conta Automática")
    public boolean verificarAnaliseContaAutomaticaFinalizada() throws Exception{
        salvarEvidencia("Aguardar finalização da proposta");
        return aguardarExistenciaElemento(etapaGerenteAnaliseContaAutomaticaFinalizada,3,500);
    }

    /**
     * Validar Etapa Análise de Conta Automática como Deriva Manual
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Análise de Conta Automática como Deriva Manual")
    public EtapasDaPropostaTela validarAnaliseContaAutomaticaComoDerivaManual() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaGerenteAnaliseContaAutomaticaComoDerivaManual),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa Análise de Conta Automática como Deriva Manual Não encontrado");
        salvarEvidencia("Validar Etapa Análise de Conta Automática como Deriva Manual");
        return this;
    }

    /**
     * Validar que a prospota está em análise N1
     *
     * @return
     * @throws Exception
     */
    @Step("Validar que a proposta está na Análise N1")
    public EtapasDaPropostaTela verificarAnaliseN1EmAndamento() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaAnaliseN1EmAndamento),MetodoComparacaoBooleano.VERDADEIRO,"Validar que a proposta está na Análise N1 não encontrado");
        salvarEvidencia("Validar que a proposta está na Análise N1");
        return this;
    }

    /**
     * Validar Etapa Análise de Conta Automática como Abertura de Conta Não
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Análise de Conta Automática como Abertura de Conta Não")
    public EtapasDaPropostaTela validarAnaliseContaAutomaticaComoAberturaContaNao() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaGerenteAnaliseContaAutomaticaComoAberturaContaNao),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa Análise de Conta Automática como Abertura não encontrado");
        salvarEvidencia("Validar Etapa Análise de Conta Automática como Abertura de Conta Não");
        return this;
    }

    /**
     * Validar Etapa Atualização Motor de Sergurança como CONCLUÍDO
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Atualização Motor de Sergurança como CONCLUÍDO")
    public EtapasDaPropostaTela validarAtualizacaoMotorDeSegurancaConcluido() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(etapaAtualizacaoMotorDeSegurancaComoConcluido),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa Atualização Motor de Sergurança não encontrado");
        salvarEvidencia("Validar Etapa Atualização Motor de Sergurança como CONCLUÍDO");
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
        validarCondicaoBooleana(aguardarCarregamentoElemento(etapaGerenteComoAberturaContaSim),MetodoComparacaoBooleano.VERDADEIRO,"Validar Etapa Gerente como Abertura de Conta Sim não encontrada");
        salvarEvidencia("Validar Etapa Gerente como Abertura de Conta Sim");
        return this;
    }

    /**
     * Validar Etapa Resultado Adesão com Resultado da Etapa Adesão Não Realizada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Etapa Resultado Adesão com Resultado da Etapa Adesão Não Realizada")
    public EtapasDaPropostaTela validarResultadoDaEtapaAdesaoNaoRealizada() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(resultadoEtapaAdesaoNaoRealizada),MetodoComparacaoBooleano.VERDADEIRO,"Resultado da Etapa de adesão não encontrado");
        salvarEvidencia("Validar Etapa Resultado Adesão com Resultado da Etapa Adesão Não Realizada");
        return this;
    }

    /**
     * Validar Fluxo das Etapas através do Card Etapas da Proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Fluxo das Etapas através do Card Etapas da Proposta")
    public EtapasDaPropostaTela validarFluxoEtapasPropostaAnaliseN1() throws Exception {
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaPreencherProposta),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da proposta não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaAdicionarFilaN1),MetodoComparacaoBooleano.VERDADEIRO,"Etapa Adicionar Fila N1 não esta Presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaTelaAnaliseN1),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da tela Analise N1 não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaConcluirFilaN1),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Conclusão da Fila N1 não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaProcessarDocumentoGCCN),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Processamento de documentos GCCN não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaEnviarMotorSeguranca),MetodoComparacaoBooleano.VERDADEIRO,"Etapa do envio do Motor Segurança não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaEnviarAlteracaoCadastral),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Envio de Alteração Cadastral não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaCarimboAgencia),MetodoComparacaoBooleano.VERDADEIRO,"O carinbo da agencia não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaAnaliseContaAutomatica),MetodoComparacaoBooleano.VERDADEIRO,"Etapa de Analise Conta Automatica não esta presente");
        validarCondicaoBooleana(aguardarExistenciaElemento(etapaEnviarResultado),MetodoComparacaoBooleano.VERDADEIRO,"Etapa da Envio de Resultado não esta presente");
        salvarEvidencia("Validar Fluxo das Etapas através do Card Etapas da Proposta");
        return this;
    }
}

