package pagina.web.email;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.web.TituloTela;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EmailWebTela extends PaginaBaseWeb {

    // Clicar: checkBox
    @CacheLookup
    @FindBy(id = "chkBsc")
    private WebElement checkBOX;

    // Campo: Dominio e Usuário do email
    @CacheLookup
    @FindBy(id = "username")
    private WebElement campoDominioEUsuarioEmail;

    // Campo: Senha do Email
    @CacheLookup
    @FindBy(id = "password")
    private WebElement campoSenhaEmail;

    // Botão: Entrar do Email
    @CacheLookup
    @FindBy(xpath = "//div[@role='button']")
    private WebElement botaoEntrar;

    // Texto: Outlook ao acessar o email
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(), 'Outlook')]")
    private WebElement outlookWebApp;

    // Buscar Caixa de Entrada
    @CacheLookup
    @FindBy(id = "spnFldrNm")
    private WebElement acessarCaixadeEntrada;

    // Buscar Email dentro da Caixa de Entrada
    @CacheLookup
    @FindBy(id = "divSenderList")
    private WebElement buscarEmail;

    // Buscar Assunto do Email dentro da Caixa de Entrada
    @CacheLookup
    @FindBy(xpath = "//*[contains(text(), 'Código pra mudança de senha')]")
    private WebElement buscarAssuntoEmail;

    //Buscar Assunto do Email dentro da Caixa de Entrada
    @FindBy(xpath = "//a[contains(text(), 'Código pra mudança de aparelho')]")
    private WebElement buscarAssuntoCodigoMudancaDeAparelho;

    // Buscar Assunto do Email dentro da Caixa de Entrada
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(), 'Seu recibo')]")
    private WebElement buscarAssuntoSeuRecibo;

    // Clicar no anexo do email selecionado
    @CacheLookup
    @FindBy(xpath = "//a[contains(@aria-label,\"Investment_Statement.pdf\")]")
    private WebElement anexoComprovante;

    @CacheLookup
    @FindBy(xpath = "//td[contains(text(), 'código')]/../..//table/tbody/tr/td")
    private WebElement copiarCodigo;

    // buscar assunto de email seu recibo
    @CacheLookup
    @FindBy(xpath = "//a[text()='Seu recibo']")
    private WebElement textoBuscaEmailSeuRecibo;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"txtSch\" and @value='Digite aqui para pesquisar']")
    private WebElement comboBusca;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"schBtn\" and @title='Pesquisar']")
    private WebElement botaoPesquisar;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"lnkAtmt\" and @title='Investment_Statement.pdf']")
    private WebElement arquivoSeuRecibo;

    // buscar assunto de email Recibo de transferência
    @CacheLookup
    @FindBy(xpath = "//*[contains(text(),'Recibo de transferência')]")
    private WebElement textoBuscaEmailReciboDeTransferencia;

    public EmailWebTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar no CheckBox "Usar o Outlook Web App Light"
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no combobox \"Usar o Outlook Web App Light\"")
    public EmailWebTela clicarCheckBox() throws Exception {
        clicarElemento(checkBOX, "Não foi possivel clicar no checkBox \"Usar o Outlook Web App Light\"");
        salvarEvidencia("Clicar no checkBox \"Usar o Outlook Web App Light\"");
        return this;
    }

    /**
     * Preencher o campo "Domínio\nome de usuário" na tela de login do email
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo \"Domínio\\nome de usuário\" na tela de login do email")
    public EmailWebTela preencherCampoDominioeUsuarioEmail(String dominioUsuarioEmail) throws Exception {
        aguardarCarregamentoElemento(campoDominioEUsuarioEmail);
        digitarTexto(campoDominioEUsuarioEmail, dominioUsuarioEmail, "Não foi possivel preencher o campo \"Domínio\\nome de usuário\" na tela de login do email");
        salvarEvidencia("Preencher o campo \"Domínio\\nome de usuário\" na tela de login do email");
        return this;
    }

    /**
     * Preencher o campo "Senha" do email
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo \"Senha\" na tela de login do email")
    public EmailWebTela preencherCampoSenhaEmail(String senhaEmail) throws Exception {
        aguardarCarregamentoElemento(campoSenhaEmail);
        digitarTexto(campoSenhaEmail, senhaEmail, "Não foi possivel preencher o campo \"Senha\" na tela de login do email");
        salvarEvidencia("Preencher o campo \"Senha\" na tela de login do email");
        return this;
    }

    /**
     * Tocar no botão "Entrar" para logar no email
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão \"Entrar\" para logar no email")
    public EmailWebTela tocarBotaoEntrar() throws Exception {
        aguardarCarregamentoElemento(botaoEntrar);
        clicarElemento(botaoEntrar, "Não foi possivel tocar no botão \"Entrar\" para logar no email");
        aguardarOcultacaoElemento(botaoEntrar);
        salvarEvidencia("Tocar no botão \"Entrar\" para logar no email");
        return this;
    }

    /**
     * Buscar Email com assunto "Código para mudança de senha"
     *
     * @return
     * @throws Exception
     */
    @Step("Buscar Email com assunto \"Código para mudança de senha\"")
    public EmailWebTela buscarEmailComCodigoDeSeguranca() throws Exception {
        clicarElemento(buscarAssuntoEmail, "Não foi possivel buscar Email com assunto \"Código para mudança de senha\"");
        salvarEvidencia("Buscar Email com assunto \"Código para mudança de senha\"");
        return this;
    }

    /**
     * Buscar Email com assunto "Código pra mudança de aparelho"
     *
     * @return
     * @throws Exception
     */
    @Step("Buscar Email com assunto \"Código pra mudança de aparelho\"")
    public EmailWebTela buscarEmailComCodigoPraMudancaDeAparelho() throws Exception {
        if(aguardarCarregamentoElemento(buscarAssuntoCodigoMudancaDeAparelho)){
            driver.navigate().refresh();
            aguardarCarregamentoElemento(buscarAssuntoCodigoMudancaDeAparelho);
        }
        clicarElemento(buscarAssuntoCodigoMudancaDeAparelho, "Não foi possivel buscar Email com assunto \"Código pra mudança de aparelho\"");
        salvarEvidencia("Buscar Email com assunto \"Código pra mudança de aparelho\"");
        return this;
    }

    /**
     * Buscar Email com assunto "Seu recibo"
     *
     * @return
     * @throws Exception
     */
    @Step("Buscar Email com assunto \"Seu recibo\"")
    public EmailWebTela buscarEmailComAssuntoSeuRecibo() throws Exception {
        clicarElemento(buscarAssuntoSeuRecibo, "Não foi possivel buscar Email com assunto \"Seu recibo\"");
        salvarEvidencia("Buscar Email com assunto \"Seu recibo\"");
        return this;
    }

    /**
     * Selecionar Anexo do Comprovante
     *
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Selecionar Anexo do Comprovante")
    public EmailWebTela selecionarAnexo() throws Exception {
        clicarElemento(anexoComprovante, "Não foi possivel selecionar o anexo");
        salvarEvidencia("Anexo selecionado com sucesso!");
        return this;
    }

    /**
     * Recuperar Código de Segurança
     *
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Recuperar Código de Segurança")
    public EmailWebTela recuperaCodigoSeguranca(ThreadLocal<String> codigo) throws Exception {
        if (codigo != null)
        codigo.set(retornarTexto(copiarCodigo, "Não foi possivel Recuperar Código de Segurança"));
        salvarEvidencia("Recuperar Código de Segurança");
        return this;
    }

    /**
     * Validar titulo da pagina inicial do email
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Validar titulo da pagina inicial do email")
    public EmailWebTela validarTituloPaginaInicialEmail()throws Exception{
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.OUTLOOK_WEB.toString()),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar o titulo da pagina inicial do email");
        salvarEvidencia("Validado titulo da pagina inicial do email");
        return this;
    }

    /**
     * Filtrar busca de email
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Filtrar busca de email")
    public EmailWebTela filtrarBuscaDeEmail(String valor) throws Exception{
        digitarTexto(comboBusca,valor,"Nao foi possivel filtrar a busca de email");
        salvarEvidencia("Filtrado busca de email com: "+valor);
        return this;
    }

    /**
     * Tocar no botao pesquisar
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Tocar no botao pesquisar")
    public EmailWebTela tocarBotaoPesquisar()throws Exception{
        salvarEvidencia("Tocar no botao pesquisar");
        clicarElemento(botaoPesquisar,"Erro ao tocar no botao pesquisar");
        return this;
    }

    /**
     * Tocar no arquivo seu recibo
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Tocar no arquivo seu recibo")
    public EmailWebTela tocarArquivoSeuRecibo()throws Exception{
        salvarEvidencia("Tocar no arquivo seu recibo");
        clicarElemento(arquivoSeuRecibo,"Erro ao tocar no arquivo seu recibo");
        return this;
    }

    /**
     * Buscar Email com assunto "Recibo de transferência "
     *
     * @return
     * @throws Exception
     */
    @Step("Buscar Email com assunto \"Recibo de transferência \"")
    public EmailWebTela buscarEmailComAssuntoReciboDeTransferencia() throws Exception {

        clicarElemento(textoBuscaEmailReciboDeTransferencia, "Não foi possivel buscar Email com assunto \"Recibo de transferência \"");
        salvarEvidencia("Buscar Email com assunto \"Recibo de transferência \"");
        return this;
    }
}
