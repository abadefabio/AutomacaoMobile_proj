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

    @FindBy(id = "Conta-Poupança1")
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
     * Validar se o título "Pagamento" aparece na página de pagamento da contingência web.
     * @throws Exception
     */
    @Step("Validar o titulo da página de pagamento")
    public PagamentoTela validarTituloPagamento() throws Exception {
        aguardarCarregamentoElemento(tituloPagamento);
        salvarEvidencia("Validada pagina de Pagamento");
        validarAtributoTexto(tituloPagamento,"Pagamento", "Não foi possível validar a tela Pagamento");
        return this;
    }

    /**
     * Validar se o campo para digitar o código de barras aparece na página de pagamento da contingência web.
     * @throws Exception
     */
    @Step("Validar o campo código de barras")
    public PagamentoTela validarCampoCodigoBarras() throws Exception {
        aguardarCarregamentoElemento(campoCodigoBarras);
        salvarEvidencia("Validado campo código de barras");
        validarAtributoTexto(campoCodigoBarras,"Campo código de barras", "Não foi possível validar o campo Codigo de Barras");
        return this;
    }

    /**
     * Receber um código de barras por parametro, trocar um caracter específico, inserir no campo código de barras presente na página pagamento e avançar
     * @param codigoBarras
     * @return
     * @throws Exception
     */
    @Step("Digitar um código de barras invalido")
    public PagamentoTela digitarCodigoBarrasInvalido(String codigoBarras, int index) throws Exception {
        StringBuilder meuCodigoBarras = new StringBuilder(codigoBarras);
        if(index != 0) {
            meuCodigoBarras.setCharAt(index, '5');
        }
        aguardarCarregamentoElemento(campoCodigoBarras);
        OperadorEvidencia.logarPasso(campoCodigoBarras.getText());
        salvarEvidencia("Inserido código de barras");
        digitarTexto(campoCodigoBarras,meuCodigoBarras.toString(), "Não foi possível inserir o código de barras");
        OperadorEvidencia.logarPasso(campoCodigoBarras.getText());
        clicarBotaoAvancarPagamento();
        return this;
    }

    /**
     * Inserir código de barras informado via json no campo de código de barras.
     * @param codigoBarras
     * @throws Exception
     */
    @Step("Escrever código de barras")
    public void digitarCodigoBarras(String codigoBarras) throws Exception{
        aguardarCarregamentoDaPagina(driver);
        clicarElemento(campoCodigoBarras, "Não foi possível clicar no campo de código de barras");
        digitarTexto(campoCodigoBarras, codigoBarras, "Não foi possível inserir o código de barras");
        salvarEvidencia("Inserido código de barras");
        clicarBotaoAvancarPagamento();
    }

    /**
     * Limpar a string presente no campo código de barras da tela pagamento.
     * @return
     * @throws Exception
     */
    @Step("limpar o texto do campo código de barras")
    public PagamentoTela limparCodigoBarras() throws Exception {
        aguardarCarregamentoElemento(campoCodigoBarras);
        salvarEvidencia("Apagado texto do campo código de barras");
        apagarCampoTexto(campoCodigoBarras,100);
        return this;
    }

    /**
     * Método para clicar no botão de avançar para a tela de Pagamento.
     * @return
     * @throws Exception
     */
    @Step("Botão [Avançar] Pagamento")
    public PagamentoTela clicarBotaoAvancarPagamento() throws Exception {
        aguardarCarregamentoElemento(botaoAvancarPagamento);
        salvarEvidencia("Clicado no botão avançar");
        clicarElemento(botaoAvancarPagamento, "Não foi possível clicar no botão [Avançar] na tela Pagamento");
        return this;
    }

    /**
     * Validar se o texto 'Beneficiário' da tela Dados do Pagamento está presente.
     * @return
     * @throws Exception
     */
    @Step("Validar o texto 'Beneficiário'")
    public PagamentoTela validarBeneficiarioPagamento() throws Exception {
        aguardarCarregamentoElemento(beneficiarioPagamento);
        salvarEvidencia("Validar página de Dados Pagamento");
        validarAtributoTexto(beneficiarioPagamento,"Beneficiário","Não foi possível validar o subtitulo beneficiário");
        return this;
    }

    /**
     * Informar um texto ao campo de Descrição na tela Dados do Pagamento.
     * @throws Exception
     */
    @Step("Informar texto ao campo descrição")
    public PagamentoTela informarDescricaoDadosPagamento() throws Exception {
        aguardarCarregamentoElemento(campoDescricao);
        digitarTexto(campoDescricao, "Teste Pagamento", "Não foi possível inserir o texto no campo descrição");
        salvarEvidencia("Informar texto no campo descrição");
        return this;
    }

    /**
     *Selecionar o botão de rádio Conta Corrente para conta débito na tela de dados do pagamento.
     * @return
     * @throws Exception
     */
    @Step("Selecionar Conta Corrente")
    public PagamentoTela selecionarContaCorrente() throws Exception {
        aguardarCarregamentoElemento(radioButtonContaCorrente);
        clicarElemento(radioButtonContaCorrente,"Não foi possível selecionar o botão de rádio 'Conta Corrente'");
        salvarEvidencia("Selecionada opção Conta Corrente");
        return this;
    }

    /**
     *Selecionar o botão de rádio Confirmar Banco 'SIM'
     * @return
     * @throws Exception
     */
    @Step("Selecionar Confirmar Banco SIM")
    public PagamentoTela selecionarConfirmarBanco() throws Exception {
        aguardarCarregamentoElemento(radioButtonConfirmarBancoSim);
        salvarEvidencia("Selecionada opção Confirmar Banco SIM");
        clicarElemento(radioButtonConfirmarBancoSim,"Não foi possível selecionar o botão de rádio 'Confirmar Banco 'SIM''");
        return this;
    }

    /**
     *Selecionar o botão de rádio Conta Poupança para conta débito na tela de dados do pagamento.
     * @return
     * @throws Exception
     */
    @Step("Selecionar Conta Poupança")
    public PagamentoTela selecionarContaPoupanca() throws Exception {
        aguardarCarregamentoElemento(radioButtonContaPoupanca);
        salvarEvidencia("Selecionada opção Conta Poupança");
        clicarElemento(radioButtonContaPoupanca,"Não foi possível selecionar o botão de rádio 'Conta Poupança'");
        return this;
    }

    /**
     * Método para clicar no botão de voltar para a tela de Pagamento.
     * @return
     * @throws Exception
     */
    @Step("Botão [Voltar] Pagamento")
    public PagamentoTela clicarBotaoVoltarDadosPagamento() throws Exception{
        aguardarCarregamentoElemento(botaoVoltarDadosPagamento);
        salvarEvidencia("clicar no botão [voltar]");
        clicarElemento(botaoVoltarDadosPagamento, "Não foi possível clicar no botão [Voltar] na tela Dados do Pagamento");
        return this;
    }

    /**
     * Método alternativo para apagar o campo texto presente na base tela.
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
        this.digitarTexto(elemento, apagaTexto, "Não foi possível limpar o texto no campo do código de barras");
    }

    /**
     * Método para obter a TID, baseado no método de ler QRCode.
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
     * Validar a presença do QR Code recém-criado (não expirado)
     * @throws Exception
     */
    @Step("Renovar QR Code")
    public PagamentoTela validarQrCodePresente() throws Exception {
        aguardarCarregamentoDaPagina(driver);
        rolarParaBaixoAteElemento(qrCodeImg);
        validarCondicaoBooleana( verificarPresencaElemento(qrCodeImg),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar que o QR Code está presente na tela.");
        salvarEvidencia("Validação de QR Code presente na tela");
        return this;
    }
}
