package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

public class TransferenciaConferirDadosTela extends TransferenciaTela {

    public TransferenciaConferirDadosTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//strong[text() = 'DE']/../../div/p")
    private WebElement labelDe;

    @FindBy(xpath = "//strong[text() = 'PARA']/../../div/p")
    private WebElement labelPara;

    @FindBy(xpath = "//strong[text() = 'CPF/CNPJ']/../../div/p")
    private WebElement labelCPF;

    @FindBy(xpath = "//strong[text() = 'BANCO OU INSTITUI��O']/../../div/p")
    private WebElement labelBanco;

    @FindBy(xpath = "//strong[text() = 'AG�NCIA']/../../div/p")
    private WebElement labelAgencia;

    @FindBy(xpath = "//strong[text() = 'CONTA']/../../div/p")
    private WebElement labelConta;

    @FindBy(xpath = "//strong[text() = 'TIPO DE CONTA (DESTINO)']/../../div/p")
    private WebElement labelTipoContaDestino;

    @FindBy(xpath = "//strong[text() = 'TIPO DE CONTA (ORIGEM)']/../../div/p")
    private WebElement labelTipoContaOrigem;


    @FindBy(xpath = "//strong[text() = 'DATA DA TRANSFER�NCIA']/../../div/p")
    private WebElement labelDataAtual;

    @FindBy(xpath = "//strong[text() = 'VALOR']/../../div/p")
    private WebElement labelValorTransferencia;

    @FindBy(xpath = "//strong[text() = 'TIPO DE TRANSFER�NCIA']/../../div/p")
    private WebElement labelTipoTransferencia;

    @FindBy(xpath = "//strong[text() = 'FINALIDADE']/../../div/p")
    private WebElement labelFinalidadeTransferencia;

    @FindBy(xpath = "//strong[text() = 'DESCRI��O']/../../div/p")
    private WebElement labelDescricaoTransferencia;


    /**
     * Met�do para validar quem est� realizando a transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar quem est� realizando a transfer�ncia")
    public TransferenciaConferirDadosTela validarTextoQuemTransfere(String deQuem) throws Exception {
        rolarParaBaixoAteElemento(labelDe);
        aguardarCarregamentoElemento(labelDe);
        salvarEvidencia("Validado o valor do campo DE: " + deQuem );
        validarAtributoTexto(labelDe, deQuem, "N�o foi poss�vel validar o campo 'DE' com o valor: " + deQuem );
        return this;
    }

    /**
     * Met�do para validar para quem est� realizando a transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar para quem est� realizando a transfer�ncia")
    public TransferenciaConferirDadosTela validarTextoParaQuemTransferir(String paraQuem) throws Exception {
        rolarParaBaixoAteElemento(labelPara);
        aguardarCarregamentoElemento(labelPara);
        salvarEvidencia("Validado o valor do campo PARA: " + paraQuem );
        validarAtributoTexto(labelPara, paraQuem, "N�o foi poss�vel validar para quem est� realizando a transfer�ncia" + paraQuem );
        return this;
    }

    /**
     * Met�do para validar o CPF de quem est� realizando a transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar o CPF de quem est� realizando a transfer�ncia")
    public TransferenciaConferirDadosTela validarTextoCpfDeQuemTransfere(String cpf) throws Exception {
        rolarParaBaixoAteElemento(labelCPF);
        aguardarCarregamentoElemento(labelCPF);
        salvarEvidencia("Validado CPF que ser� transferido: " + cpf );
        validarAtributoTexto(labelCPF, cpf, "N�o foi poss�vel validar o CPF de quem est� sendo realizando a transfer�ncia " + cpf);
        return this;
    }

    /**
     * Met�do para validar banco ou institui��o que ser� realizada a transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar o banco que ser� realizada a transfer�ncia")
    public TransferenciaConferirDadosTela validarBancoInsituicao(String banco) throws Exception {
        rolarParaBaixoAteElemento(labelBanco);
        aguardarCarregamentoElemento(labelBanco);
        salvarEvidencia("Validado o banco que ser� transferido: " + banco);
        validarAtributoTexto(labelBanco, banco,"N�o foi poss�vel validar o banco: " + banco);
        return this;
    }


    /**
     * Met�do para validar o ag�ncia de destino
     * @throws Exception
     * @return
     */
    @Step("Validar a ag�ncia de destino")
    public TransferenciaConferirDadosTela conferirAgenciaDestino(String agencia) throws Exception {
        rolarParaBaixoAteElemento(labelAgencia);
        aguardarCarregamentoElemento(labelAgencia);
        salvarEvidencia("Validada ag�ncia que ser� realizada a transfer�ncia: " + agencia );
        validarAtributoTexto(labelAgencia, agencia, "N�o foi poss�vel validar a ag�ncia " + agencia );
        return this;
    }


    /**
     * Met�do para validar a conta
     * @throws Exception
     * @return
     */
    @Step("Validar a conta")
    public TransferenciaConferirDadosTela conferirConta(String conta) throws Exception {
        rolarParaBaixoAteElemento(labelConta);
        aguardarCarregamentoElemento(labelConta);
        salvarEvidencia("Validado n�mero da conta: " + conta);
        validarAtributoTexto(labelConta, conta, "N�o foi poss�vel validar a conta " + conta);
        return this;
    }


    /**
     * Met�do para validar a conta de destino
     * @throws Exception
     * @return
     */
    @Step("Validar a conta de destino")
    public TransferenciaConferirDadosTela conferirContaDestino(String contaDestino) throws Exception {
        rolarParaBaixoAteElemento(labelTipoContaDestino);
        aguardarCarregamentoElemento(labelTipoContaDestino);
        salvarEvidencia("Validada a conta destino: " + contaDestino);
        validarAtributoTexto(labelTipoContaDestino, contaDestino, "N�o foi poss�vel validar o o tipo conta destino " + contaDestino);
        return this;
    }

    /**
     * Met�do para validar o conta origem
     * @throws Exception
     * @return
     */
    @Step("Validar a conta origem")
    public TransferenciaConferirDadosTela conferirContaOrigem(String contaOrigem) throws Exception {
        rolarParaBaixoAteElemento(labelTipoContaOrigem);
        aguardarCarregamentoElemento(labelTipoContaOrigem);
        salvarEvidencia("Validada a conta origem: " + contaOrigem );
        validarAtributoTexto(labelTipoContaOrigem, contaOrigem, "N�o foi poss�vel validar a conta origem " + contaOrigem);
        return this;
    }

    /**
     * Met�do para validar a data de transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar a data de transfer�ncia")
    public TransferenciaConferirDadosTela conferirDataAtual() throws Exception {
        rolarParaBaixoAteElemento(labelDataAtual);
        aguardarCarregamentoElemento(labelDataAtual);
        salvarEvidencia("Validada a data da transfer�ncia: " + calcularDataRelativaHoje(0, "dd/MM/yyyy"));
        validarAtributoTexto(labelDataAtual, calcularDataRelativaHoje(0, "dd/MM/yyyy"), "N�o foi poss�vel conferir a data da transfer�ncia " + calcularDataRelativaHoje(0, "dd/MM/yyyy") );
        return this;
    }

    /**
     * Met�do para validar o valor da transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar o valor da transfer�ncia")
    public TransferenciaConferirDadosTela conferirValorTransferencia(String valor) throws Exception {
        rolarParaBaixoAteElemento(labelValorTransferencia);
        aguardarCarregamentoElemento(labelValorTransferencia);
        salvarEvidencia("Validado valor da transfer�ncia: " + valor);
        validarAtributoTexto(labelValorTransferencia, valor, "N�o foi poss�vel validar o valor da transfer�ncia " + valor);
        return this;
    }

    /**
     * Met�do para validar o tipo da transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar o tipo da transfer�ncia")
    public TransferenciaConferirDadosTela conferirTipoTransferencia(String tipo) throws Exception {
        rolarParaBaixoAteElemento(labelTipoTransferencia);
        aguardarCarregamentoElemento(labelTipoTransferencia);
        salvarEvidencia("Validado tipo transfer�ncia: " + tipo);
        validarAtributoTexto(labelTipoTransferencia, tipo, "N�o foi poss�vel validar o tipo de transfer�ncia TED " + tipo );
        return this;
    }

    /**
     * Met�do para validar a finalidade da transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar a finalidade da transfer�ncia")
    public TransferenciaConferirDadosTela conferirFinalidadeTransferencia(String finalidade) throws Exception {
        rolarParaBaixoAteElemento(labelFinalidadeTransferencia);
        aguardarCarregamentoElemento(labelFinalidadeTransferencia);
        salvarEvidencia("Validada finalidade da transfer�ncia: " + finalidade);
        validarAtributoTexto(labelFinalidadeTransferencia, finalidade, "N�o foi poss�vel validar a finalidade da transfer�ncia " + finalidade );
        return this;
    }

    /**
     * Met�do para validar a descri��o da transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Validar a descri��o da transfer�ncia")
    public TransferenciaConferirDadosTela conferirDescricaoTransferencia(String descricao) throws Exception {
        rolarParaBaixoAteElemento(labelDescricaoTransferencia);
        aguardarCarregamentoElemento(labelDescricaoTransferencia);
        salvarEvidencia("Validada descri��o da transfer�ncia: " + descricao);
        validarAtributoTexto(labelDescricaoTransferencia, descricao, "N�o foi poss�vel validar a descri��o da transfer�ncia " + descricao);
        return this;
    }
}
