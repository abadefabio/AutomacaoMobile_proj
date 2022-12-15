package pagina.web.frontend.anotacoes;


import base.pagina.web.PaginaBaseWebUpload;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AnotacaoCadastroTela extends PaginaBaseWebUpload {

    public AnotacaoCadastroTela(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//button[text()='Incluir Anotação']")
    private WebElement btnIncluirAnotacao;

    @FindBy(xpath = "//div[text()='Nova anotação']")
    private WebElement textNovaAnotacao;

    @FindBy(xpath = "//input[@id='subject']")
    private WebElement inputTituloAnotacao;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement textareaDescricaoAnotacao;

    @FindAll({
            @FindBy(xpath = "//label['_ngcontent-dsm-c27' and @class='btn-attachment']/../checkbox//input"),
            @FindBy(xpath = "//div['_ngcontent-dsm-c27' and @class='nxt-line']//div[@class='mat-checkbox-frame']")
    })
    private WebElement checkboxImportanteModal;

    @FindAll({
            @FindBy(xpath = "(//checkbox[@label='Importante'])[1]"),
            @FindBy(xpath = "(//span[@class='mat-checkbox-label' and contains(text(),'Importante')])[1]")
    })
    private WebElement checkboxImportante;

    @FindBy(xpath = "//th[@id='message' and contains(text(),'Após confirmada essa alteração não poderá ser desfeita. Você deseja continuar?')]")
    private WebElement msgModalCheckImportanteOut;

    @FindBy(xpath = "//button[contains(text(),'Confirmar')]")
    private WebElement btnConfirmCheckImportOut;

    @FindBy(xpath = "//th[@id='message' and contains(text(),'A marcação de importante da anotação foi removida com sucesso!')]")
    private WebElement msgModalSuccessImportanteOut;

    @FindBy(xpath = "//button[contains(text(),'Fechar')]")
    private WebElement btnFecharModalSucessImportant;

    @FindBy(xpath = "(//div[@class='timeline-container ng-star-inserted'])/div[1]//div[@class='column right']")
    private WebElement getTextImportanteTimeline;

    @FindBy(xpath = "(//div[@class='timeline-container ng-star-inserted'])/div[1]//div[@class='point-complete']")
    private WebElement getElemento;

    @FindBy(xpath = "//div[@class='footer-form']//button[text()='Limpar']")
    private WebElement btnLimpar;

    @FindBy(xpath = "//buttonline//button[text()='Retornar']")
    private WebElement btnRetornar;

    @FindBy(xpath = "//button[text()='Sim']")
    private WebElement btnSim;

    @FindBy(xpath = "//button[text()='Não']")
    private WebElement btnNao;

    @FindBy(xpath = "//th['ng-star-inserted']")
    private WebElement alertaModalRetornar;

    @FindBy(xpath = "//button[contains(text(),'Salvar')]")
    private WebElement btnSalvarAnotacao;

    @FindBy(xpath = "//th[contains(text(),'A anotação foi registrada com sucesso!')]")
    private WebElement msgSalvarAnotacao;

    @FindBy(xpath = "//button[text()='Fechar']")
    private WebElement btnFecharModal;

    @FindBy(xpath = "(//span[@class='subject'])[1]")
    private WebElement titleAnotacaoTimeline;

    @FindBy(xpath = "(//p['_ngcontent-eqt-c15'])[1]")
    private WebElement descricaoAnotacaoTimeline;

    @FindBy(xpath = "(//span[starts-with(text(),'Nome:')])[1]")
    private WebElement nomeAnotacaoTimeline;

    @FindBy(xpath = "(//span[starts-with(text(),'Funcional:')])[1]")
    private WebElement funcionalAnotacaoTimeline;

    @FindBy(xpath = "//input[@id=\"attachFile\"]")
    private WebElement inputAnexo;


    /**
     * Clicar no botão Incluir Anotacao no Gestao de Ocorrencias
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Clicar em Incluir Anotacao")
    public AnotacaoCadastroTela clicarIncluirAnotacao() throws Exception {
        clicarElemento(btnIncluirAnotacao, "Não foi possível clicar em Incluir Anotacao");
        salvarEvidencia("Clicar em Incluir Anotacao");
        return this;
    }

    /**
     * Preencher o input titulo anotacao
     *
     * @param titulo_anotacao
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Preencher o titulo da anotacao")
    public AnotacaoCadastroTela preencherTituloAnotacao(String titulo_anotacao) throws Exception {
        digitarTexto(inputTituloAnotacao, titulo_anotacao, "Não foi possível digitar no campo titulo anotacao " + inputTituloAnotacao);
        salvarEvidencia("Preenchimento do titulo da anotacao");
        return this;
    }

    /**
     * Preencher o textarea descricao
     *
     * @param descricao
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Preencher a Descricao da Anotacao")
    public AnotacaoCadastroTela preencherDescricaoAnotacao(String descricao) throws Exception {
        digitarTexto(textareaDescricaoAnotacao, descricao, "Não foi possível digitar no textarea descricao " + descricao);
        salvarEvidencia("Preencher campo Descricao");
        return this;
    }

    /**
     * Preencher o textarea descricao
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Marcar Anotacao como Importante")
    public AnotacaoCadastroTela marcarAnotacaoImportante() throws Exception {
        clicarElemento(checkboxImportanteModal, "Não foi possível marcar a opção Importante");
        salvarEvidencia("Clicar no Checkbox Importante");
        return this;
    }

    /**
     * Clicar no botão Retornar no modal de Inclusao da Anotacao
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Clicar em Retornar")
    public AnotacaoCadastroTela clicarRetornar() throws Exception {
        aguardarCarregamentoElemento(btnRetornar);
        clicarElemento(btnRetornar, "Não foi possível clicar no botão Retornar");
        salvarEvidencia("Clicar Retornar");
        return this;
    }

    /**
     * Validar a mensagem dentro do modal do botao Retornar
     *
     * @param alerta_retornar
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar mensagem dentro do botao Retornar")
    public AnotacaoCadastroTela validarMensagemModalBotaoRetornar(String alerta_retornar) throws Exception {
        validarAtributoTexto(alertaModalRetornar, alerta_retornar, "Não foi possível validar a mensagem no modal Retornar");
        salvarEvidencia("Mensagem do modal dentro do botão Retornar validada com sucesso!");
        return this;
    }

    /**
     * Clicar em SIM no modal do botão Retornar do Anotacoes no Gestao de Ocorrencias
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Clicar em SIM no modal do botão Retornar")
    public AnotacaoCadastroTela clicarSimModalBotaoRetornar() throws Exception {
        clicarElemento(btnSim, "Não foi possível clicar no botão Sim");
        salvarEvidencia("Clicar Sim");
        return this;
    }

    /**
     * Validar o fechamento do modal do botão Retornar
     * O usuario e devolvido para a tela de timeline do Anotacoes
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar fechamento do modal Retornar")
    public AnotacaoCadastroTela validarFechamentoModalRetornar() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(btnIncluirAnotacao), MetodoComparacaoBooleano.FALSO,"Modal ainda não foi fechado.");
        salvarEvidencia("Tela principal do Anotacoes");
        return this;
    }

    /**
     * Clicar no botão Salvar no modal de Inclusao da Anotacao
     *
     * @param msgAnotacao
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Clicar em Salvar")
    public AnotacaoCadastroTela clicarSalvar(String msgAnotacao) throws Exception {
        clicarElemento(btnSalvarAnotacao, "Não foi possível clicar no botão Salvar");
        validarAtributoTexto(msgSalvarAnotacao, msgAnotacao, "Não foi possível validar a mensagem no modal de Salvar da Anotacao");
        salvarEvidencia("Salvar a Anotacao");
        return this;
    }

    /**
     * Clicar em fechar o modal do botao Salvar
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Fechar modal do botao Salvar")
    public AnotacaoCadastroTela clicarFecharModalSalvar() throws Exception {
        clicarElemento(btnFecharModal, "Não foi possível clicar no botão Fechar");
        salvarEvidencia("Clicar Fechar modal");
        return this;
    }

    /**
     * Validar que o titulo da anotacao na timeline
     *
     * @param tituloAnotacao
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar o titulo da anotacao na timeline")
    public AnotacaoCadastroTela validarTituloAnotacaoTimeline(String tituloAnotacao) throws Exception {
        rolarParaBaixoAteElemento(titleAnotacaoTimeline);
        validarAtributoTexto(titleAnotacaoTimeline, tituloAnotacao, "Não foi possível validar o titulo da anotacao na timeline");
        salvarEvidencia("Validar titulo da anotacao");
        return this;
    }

    /**
     * Validar a descricao da anotacao na timeline
     *
     * @param descricao
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar a descricao da anotacao na timeline")
    public AnotacaoCadastroTela validarDescricaoAnotacaoTimeline(String descricao) throws Exception {
        validarAtributoTexto(descricaoAnotacaoTimeline, descricao, "Não foi possível validar a descricao da anotacao na timeline");
        salvarEvidencia("Validar a descricao da anotacao");
        return this;
    }

    /**
     * Validar o nome do usuario que criou a anotacao
     *
     * @param nome
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar o login da anotacao criada na timeline")
    public AnotacaoCadastroTela validarNomeAnotacaoTimeline(String nome) throws Exception {
        validarAtributoTexto(nomeAnotacaoTimeline, nome, "Não foi possível validar o nome do criador da anotacao na timeline");
        salvarEvidencia("Validar o nome do usuario na anotacao criada");
        return this;
    }

    /**
     * Validar a funcional do usuario que criou a anotacao
     *
     * @param funcional
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar funcional da anotacao criada na timeline")
    public AnotacaoCadastroTela validarFuncionalAnotacaoTimeline(String funcional) throws Exception {
        compararElementoTexto(funcionalAnotacaoTimeline, funcional, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar a funcional do usuario na anotacao criada");
        return this;
    }

    /**
     * Validar que a anotacao foi criada com a marcacao de importante
     *
     * @param txtImportante
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar marcacao de importante na anotacao")
    public AnotacaoCadastroTela validarMarcacaoImportanteAnotacao(String txtImportante) throws Exception {
        validarAtributoTexto(checkboxImportante, txtImportante, "Falha ao validar marcacao de Importante na Anotacao");
        salvarEvidencia("Validar que a Anotacao foi criada com a marcacao de Importante");
        return this;
    }

    /**
     * Na timeline remover o checkbox marcado como Importante
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Remover a marcacao de importante")
    public AnotacaoCadastroTela removerMarcacaoImportante() throws Exception {
        clicarElemento(checkboxImportante, "Falhou a remocao da marcacao de Importante da anotacao");
        salvarEvidencia("Clicar para remover a marcacao de importante");
        return this;
    }

    /**
     * Validar o texto no modal de remocao da marcacao de Importante
     *
     * @param txtModalImportante
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar texto no modal de Importante")
    public AnotacaoCadastroTela validarTextoModalImportante(String txtModalImportante) throws Exception {
        validarAtributoTexto(msgModalCheckImportanteOut, txtModalImportante, "Falhou a validacao do texto no modal Importante");
        salvarEvidencia("Validar o texto do modal de remocao da Anotacao Importante");
        return this;
    }

    /**
     * Clicar em Confirmar para remover a flag de importante
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Clicar em Confirmar para remover a flag de Importante")
    public AnotacaoCadastroTela clicarConfirmarRemoverImportante() throws Exception {
        clicarElemento(btnConfirmCheckImportOut, "Não foi possível clicar em Confirmar");
        salvarEvidencia("Clicar em Confirmar para remover a flag de Importante");
        return this;
    }

    /**
     * Validar texto no modal de sucesso da remocao de importante
     * Texto: A marcação de importante da anotação foi removida com sucesso!
     *
     * @param msgSucessoImportanteRemocao
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar texto de sucesso no modal de remocao importante")
    public AnotacaoCadastroTela validarModalSucessoRemocaoImportante(String msgSucessoImportanteRemocao) throws Exception {
        validarAtributoTexto(msgModalSuccessImportanteOut, msgSucessoImportanteRemocao, "Não foi possível validar a mensagem de sucesso");
        salvarEvidencia("Validar mensagem no modal de sucesso");
        return this;
    }

    /**
     * Clicar em Fechar no modal de sucesso de remocao da flag Importante
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Clicar em Fechar no modal de sucesso da Flag Importante")
    public AnotacaoCadastroTela clicarFecharModalSucessoFlagImportante() throws Exception {
        clicarElemento(btnFecharModalSucessImportant, "Não foi possível clicar em Fechar");
        salvarEvidencia("Clicar em Fechar no modal de sucesso");
        return this;
    }


    /**
     * Validar que o checkbox marcado como Importante foi removido corretamente
     *
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Validar remocao da marcacao de Importante")
    public AnotacaoCadastroTela validarRemocaoMarcacaoImportante() throws Exception {
        retornaElemento(getElemento);
        salvarEvidencia("Validar que a anotacao nao esta com a flag de importante");
        return this;
    }

    /**
     * Preencher o input de anexo
     *
     * @param caminhoAnexo
     * @throws Exception
     * @return AnotacaoCadastroTela
     */
    @Step("Preencher o titulo da anotacao")
    public AnotacaoCadastroTela preencherAnexo(String caminhoAnexo) throws Exception {
        inputAnexo.sendKeys(caminhoAnexo);
        salvarEvidencia("Anexando arquivo " + caminhoAnexo);
        return this;
    }
}
