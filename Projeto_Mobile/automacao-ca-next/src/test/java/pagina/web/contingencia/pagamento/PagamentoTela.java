package pagina.web.contingencia.pagamento;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.imagens.LeitorQRCode;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import static framework.WebUtils.aguardarCarregamentoDaPagina;

public class PagamentoTela extends PaginaBaseWeb {

    public PagamentoTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Pagamento_id")
    private WebElement tituloPagamento;

    @FindBy (id = "barCode")
    private WebElement campoCodigoBarras;

    @FindBy (id = "stepFormNextButton")
    private WebElement botaoAvancarPagamento;

    @FindBy (id ="receiving_label")
    private WebElement beneficiarioPagamento;

    @FindBy (id = "stepFormBackButton")
    private WebElement botaoVoltarDadosPagamento;

    @FindBy(id = "description")
    private WebElement campoDescricao;

    @FindBy(xpath= "//input[@id='Sim0']/following::div[1]")
    private WebElement radioButtonConfirmarBancoSim;

    @FindBy(xpath= "//input[@id='Conta-Corrente0']/following::div[1]")
    private WebElement radioButtonContaCorrente;

    @FindBy(id = "Conta-Poupan�a1")
    private WebElement radioButtonContaPoupanca;

    @FindBy(id = "qrCodeValue")
    private WebElement QrCode;

    @FindAll({
            @FindBy(id = "qrCodeValue"),
            @FindBy(xpath = "//img[contains(@alt,'Code')]"),
            @FindBy(id = "qrCode")
    })
    private WebElement qrCodeImg;


    /**
     * Validar se o t�tulo "Pagamento" aparece na p�gina de pagamento da conting�ncia web.
     * @throws Exception
     */
    @Step("Validar o titulo da p�gina de pagamento")
    public PagamentoTela validarTituloPagamento() throws Exception {
        aguardarCarregamentoElemento(tituloPagamento);
        salvarEvidencia("Validada pagina de Pagamento");
        validarAtributoTexto(tituloPagamento,"Pagamento", "N�o foi poss�vel validar a tela Pagamento");
        return this;
    }

    /**
     * Validar se o campo para digitar o c�digo de barras aparece na p�gina de pagamento da conting�ncia web.
     * @throws Exception
     */
    @Step("Validar o campo c�digo de barras")
    public PagamentoTela validarCampoCodigoBarras() throws Exception {
        aguardarCarregamentoElemento(campoCodigoBarras);
        salvarEvidencia("Validado campo c�digo de barras");
        validarAtributoTexto(campoCodigoBarras,"Campo c�digo de barras", "N�o foi poss�vel validar o campo Codigo de Barras");
        return this;
    }

    /**
     * Receber um c�digo de barras por parametro, trocar um caracter espec�fico, inserir no campo c�digo de barras presente na p�gina pagamento e avan�ar
     * @param codigoBarras
     * @return
     * @throws Exception
     */
    @Step("Digitar um c�digo de barras invalido")
    public PagamentoTela digitarCodigoBarrasInvalido(String codigoBarras, int index) throws Exception {
        StringBuilder meuCodigoBarras = new StringBuilder(codigoBarras);
        if(index != 0) {
            meuCodigoBarras.setCharAt(index, '5');
        }
        aguardarCarregamentoElemento(campoCodigoBarras);
        OperadorEvidencia.logarPasso(campoCodigoBarras.getText());
        salvarEvidencia("Inserido c�digo de barras");
        digitarTexto(campoCodigoBarras,meuCodigoBarras.toString(), "N�o foi poss�vel inserir o c�digo de barras");
        OperadorEvidencia.logarPasso(campoCodigoBarras.getText());
        clicarBotaoAvancarPagamento();
        return this;
    }

    /**
     * Inserir c�digo de barras informado via json no campo de c�digo de barras.
     * @param codigoBarras
     * @throws Exception
     */
    @Step("Escrever c�digo de barras")
    public void digitarCodigoBarras(String codigoBarras) throws Exception{
        aguardarCarregamentoDaPagina(driver);
        clicarElemento(campoCodigoBarras, "N�o foi poss�vel clicar no campo de c�digo de barras");
        digitarTexto(campoCodigoBarras, codigoBarras, "N�o foi poss�vel inserir o c�digo de barras");
        salvarEvidencia("Inserido c�digo de barras");
        clicarBotaoAvancarPagamento();
    }

    /**
     * Limpar a string presente no campo c�digo de barras da tela pagamento.
     * @return
     * @throws Exception
     */
    @Step("limpar o texto do campo c�digo de barras")
    public PagamentoTela limparCodigoBarras() throws Exception {
        aguardarCarregamentoElemento(campoCodigoBarras);
        salvarEvidencia("Apagado texto do campo c�digo de barras");
        apagarCampoTexto(campoCodigoBarras,100);
        return this;
    }

    /**
     * M�todo para clicar no bot�o de avan�ar para a tela de Pagamento.
     * @return
     * @throws Exception
     */
    @Step("Bot�o [Avan�ar] Pagamento")
    public PagamentoTela clicarBotaoAvancarPagamento() throws Exception {
        aguardarCarregamentoElemento(botaoAvancarPagamento);
        salvarEvidencia("Clicado no bot�o avan�ar");
        clicarElemento(botaoAvancarPagamento, "N�o foi poss�vel clicar no bot�o [Avan�ar] na tela Pagamento");
        return this;
    }

    /**
     * Validar se o texto 'Benefici�rio' da tela Dados do Pagamento est� presente.
     * @return
     * @throws Exception
     */
    @Step("Validar o texto 'Benefici�rio'")
    public PagamentoTela validarBeneficiarioPagamento() throws Exception {
        aguardarCarregamentoElemento(beneficiarioPagamento);
        salvarEvidencia("Validar p�gina de Dados Pagamento");
        validarAtributoTexto(beneficiarioPagamento,"Benefici�rio","N�o foi poss�vel validar o subtitulo benefici�rio");
        return this;
    }

    /**
     * Informar um texto ao campo de Descri��o na tela Dados do Pagamento.
     * @throws Exception
     */
    @Step("Informar texto ao campo descri��o")
    public PagamentoTela informarDescricaoDadosPagamento() throws Exception {
        aguardarCarregamentoElemento(campoDescricao);
        digitarTexto(campoDescricao, "Teste Pagamento", "N�o foi poss�vel inserir o texto no campo descri��o");
        salvarEvidencia("Informar texto no campo descri��o");
        return this;
    }

    /**
     *Selecionar o bot�o de r�dio Conta Corrente para conta d�bito na tela de dados do pagamento.
     * @return
     * @throws Exception
     */
    @Step("Selecionar Conta Corrente")
    public PagamentoTela selecionarContaCorrente() throws Exception {
        aguardarCarregamentoElemento(radioButtonContaCorrente);
        clicarElemento(radioButtonContaCorrente,"N�o foi poss�vel selecionar o bot�o de r�dio 'Conta Corrente'");
        salvarEvidencia("Selecionada op��o Conta Corrente");
        return this;
    }

    /**
     *Selecionar o bot�o de r�dio Confirmar Banco 'SIM'
     * @return
     * @throws Exception
     */
    @Step("Selecionar Confirmar Banco SIM")
    public PagamentoTela selecionarConfirmarBanco() throws Exception {
        aguardarCarregamentoElemento(radioButtonConfirmarBancoSim);
        salvarEvidencia("Selecionada op��o Confirmar Banco SIM");
        clicarElemento(radioButtonConfirmarBancoSim,"N�o foi poss�vel selecionar o bot�o de r�dio 'Confirmar Banco 'SIM''");
        return this;
    }

    /**
     *Selecionar o bot�o de r�dio Conta Poupan�a para conta d�bito na tela de dados do pagamento.
     * @return
     * @throws Exception
     */
    @Step("Selecionar Conta Poupan�a")
    public PagamentoTela selecionarContaPoupanca() throws Exception {
        aguardarCarregamentoElemento(radioButtonContaPoupanca);
        salvarEvidencia("Selecionada op��o Conta Poupan�a");
        clicarElemento(radioButtonContaPoupanca,"N�o foi poss�vel selecionar o bot�o de r�dio 'Conta Poupan�a'");
        return this;
    }

    /**
     * M�todo para clicar no bot�o de voltar para a tela de Pagamento.
     * @return
     * @throws Exception
     */
    @Step("Bot�o [Voltar] Pagamento")
    public PagamentoTela clicarBotaoVoltarDadosPagamento() throws Exception{
        aguardarCarregamentoElemento(botaoVoltarDadosPagamento);
        salvarEvidencia("clicar no bot�o [voltar]");
        clicarElemento(botaoVoltarDadosPagamento, "N�o foi poss�vel clicar no bot�o [Voltar] na tela Dados do Pagamento");
        return this;
    }

    /**
     * M�todo alternativo para apagar o campo texto presente na base tela.
     * @param elemento
     * @param qtdeCaracteresTexto
     * @throws Exception
     */
    @Step("Apagar Campo Texto")
    public void apagarCampoTexto(WebElement elemento, int qtdeCaracteresTexto) throws Exception {
        String apagaTexto = null;

        for(int i = 0; i < qtdeCaracteresTexto; ++i) {
            apagaTexto = apagaTexto + Keys.BACK_SPACE;
        }
        this.digitarTexto(elemento, apagaTexto, "N�o foi poss�vel limpar o texto no campo do c�digo de barras");
    }

    /**
     * M�todo para obter a TID, baseado no m�todo de ler QRCode.
     * @throws Exception
     */
    @Step("Ler TID do QR Code")
    public String lerTID() throws Exception {
        aguardarCarregamentoElemento(qrCodeImg);
        String resposta = LeitorQRCode.lerQRCode(getImagemBase64Header(qrCodeImg));
        String TID;
        TID = StringUtils.substringAfter(resposta, "{\"tid\":\"");
        TID = StringUtils.substringBefore(TID, "\"}");

        return TID;
    }

    /**
     * Validar a presen�a do QR Code rec�m-criado (n�o expirado)
     * @throws Exception
     */
    @Step("Renovar QR Code")
    public PagamentoTela validarQrCodePresente() throws Exception {
        aguardarCarregamentoDaPagina(driver);
        rolarParaBaixoAteElemento(qrCodeImg);
        validarCondicaoBooleana( verificarPresencaElemento(qrCodeImg),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar que o QR Code est� presente na tela.");
        salvarEvidencia("Valida��o de QR Code presente na tela");
        return this;
    }
}
