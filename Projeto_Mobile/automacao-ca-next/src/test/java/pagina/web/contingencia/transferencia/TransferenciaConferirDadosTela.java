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

    @FindBy(xpath = "//strong[text() = 'BANCO OU INSTITUIÇÃO']/../../div/p")
    private WebElement labelBanco;

    @FindBy(xpath = "//strong[text() = 'AGÊNCIA']/../../div/p")
    private WebElement labelAgencia;

    @FindBy(xpath = "//strong[text() = 'CONTA']/../../div/p")
    private WebElement labelConta;

    @FindBy(xpath = "//strong[text() = 'TIPO DE CONTA (DESTINO)']/../../div/p")
    private WebElement labelTipoContaDestino;

    @FindBy(xpath = "//strong[text() = 'TIPO DE CONTA (ORIGEM)']/../../div/p")
    private WebElement labelTipoContaOrigem;


    @FindBy(xpath = "//strong[text() = 'DATA DA TRANSFERÊNCIA']/../../div/p")
    private WebElement labelDataAtual;

    @FindBy(xpath = "//strong[text() = 'VALOR']/../../div/p")
    private WebElement labelValorTransferencia;

    @FindBy(xpath = "//strong[text() = 'TIPO DE TRANSFERÊNCIA']/../../div/p")
    private WebElement labelTipoTransferencia;

    @FindBy(xpath = "//strong[text() = 'FINALIDADE']/../../div/p")
    private WebElement labelFinalidadeTransferencia;

    @FindBy(xpath = "//strong[text() = 'DESCRIÇÃO']/../../div/p")
    private WebElement labelDescricaoTransferencia;


    /**
     * Metódo para validar quem está realizando a transferência
     * @throws Exception
     * @return
     */
    @Step("Validar quem está realizando a transferência")
    public TransferenciaConferirDadosTela validarTextoQuemTransfere(String deQuem) throws Exception {
        rolarParaBaixoAteElemento(labelDe);
        aguardarCarregamentoElemento(labelDe);
        salvarEvidencia("Validado o valor do campo DE: " + deQuem );
        validarAtributoTexto(labelDe, deQuem, "Não foi possível validar o campo 'DE' com o valor: " + deQuem );
        return this;
    }

    /**
     * Metódo para validar para quem está realizando a transferência
     * @throws Exception
     * @return
     */
    @Step("Validar para quem está realizando a transferência")
    public TransferenciaConferirDadosTela validarTextoParaQuemTransferir(String paraQuem) throws Exception {
        rolarParaBaixoAteElemento(labelPara);
        aguardarCarregamentoElemento(labelPara);
        salvarEvidencia("Validado o valor do campo PARA: " + paraQuem );
        validarAtributoTexto(labelPara, paraQuem, "Não foi possível validar para quem está realizando a transferência" + paraQuem );
        return this;
    }

    /**
     * Metódo para validar o CPF de quem está realizando a transferência
     * @throws Exception
     * @return
     */
    @Step("Validar o CPF de quem está realizando a transferência")
    public TransferenciaConferirDadosTela validarTextoCpfDeQuemTransfere(String cpf) throws Exception {
        rolarParaBaixoAteElemento(labelCPF);
        aguardarCarregamentoElemento(labelCPF);
        salvarEvidencia("Validado CPF que será transferido: " + cpf );
        validarAtributoTexto(labelCPF, cpf, "Não foi possível validar o CPF de quem está sendo realizando a transferência " + cpf);
        return this;
    }

    /**
     * Metódo para validar banco ou instituição que será realizada a transferência
     * @throws Exception
     * @return
     */
    @Step("Validar o banco que será realizada a transferência")
    public TransferenciaConferirDadosTela validarBancoInsituicao(String banco) throws Exception {
        rolarParaBaixoAteElemento(labelBanco);
        aguardarCarregamentoElemento(labelBanco);
        salvarEvidencia("Validado o banco que será transferido: " + banco);
        validarAtributoTexto(labelBanco, banco,"Não foi possível validar o banco: " + banco);
        return this;
    }


    /**
     * Metódo para validar o agência de destino
     * @throws Exception
     * @return
     */
    @Step("Validar a agência de destino")
    public TransferenciaConferirDadosTela conferirAgenciaDestino(String agencia) throws Exception {
        rolarParaBaixoAteElemento(labelAgencia);
        aguardarCarregamentoElemento(labelAgencia);
        salvarEvidencia("Validada agência que será realizada a transferência: " + agencia );
        validarAtributoTexto(labelAgencia, agencia, "Não foi possível validar a agência " + agencia );
        return this;
    }


    /**
     * Metódo para validar a conta
     * @throws Exception
     * @return
     */
    @Step("Validar a conta")
    public TransferenciaConferirDadosTela conferirConta(String conta) throws Exception {
        rolarParaBaixoAteElemento(labelConta);
        aguardarCarregamentoElemento(labelConta);
        salvarEvidencia("Validado número da conta: " + conta);
        validarAtributoTexto(labelConta, conta, "Não foi possível validar a conta " + conta);
        return this;
    }


    /**
     * Metódo para validar a conta de destino
     * @throws Exception
     * @return
     */
    @Step("Validar a conta de destino")
    public TransferenciaConferirDadosTela conferirContaDestino(String contaDestino) throws Exception {
        rolarParaBaixoAteElemento(labelTipoContaDestino);
        aguardarCarregamentoElemento(labelTipoContaDestino);
        salvarEvidencia("Validada a conta destino: " + contaDestino);
        validarAtributoTexto(labelTipoContaDestino, contaDestino, "Não foi possível validar o o tipo conta destino " + contaDestino);
        return this;
    }

    /**
     * Metódo para validar o conta origem
     * @throws Exception
     * @return
     */
    @Step("Validar a conta origem")
    public TransferenciaConferirDadosTela conferirContaOrigem(String contaOrigem) throws Exception {
        rolarParaBaixoAteElemento(labelTipoContaOrigem);
        aguardarCarregamentoElemento(labelTipoContaOrigem);
        salvarEvidencia("Validada a conta origem: " + contaOrigem );
        validarAtributoTexto(labelTipoContaOrigem, contaOrigem, "Não foi possível validar a conta origem " + contaOrigem);
        return this;
    }

    /**
     * Metódo para validar a data de transferência
     * @throws Exception
     * @return
     */
    @Step("Validar a data de transferência")
    public TransferenciaConferirDadosTela conferirDataAtual() throws Exception {
        rolarParaBaixoAteElemento(labelDataAtual);
        aguardarCarregamentoElemento(labelDataAtual);
        salvarEvidencia("Validada a data da transferência: " + calcularDataRelativaHoje(0, "dd/MM/yyyy"));
        validarAtributoTexto(labelDataAtual, calcularDataRelativaHoje(0, "dd/MM/yyyy"), "Não foi possível conferir a data da transferência " + calcularDataRelativaHoje(0, "dd/MM/yyyy") );
        return this;
    }

    /**
     * Metódo para validar o valor da transferência
     * @throws Exception
     * @return
     */
    @Step("Validar o valor da transferência")
    public TransferenciaConferirDadosTela conferirValorTransferencia(String valor) throws Exception {
        rolarParaBaixoAteElemento(labelValorTransferencia);
        aguardarCarregamentoElemento(labelValorTransferencia);
        salvarEvidencia("Validado valor da transferência: " + valor);
        validarAtributoTexto(labelValorTransferencia, valor, "Não foi possível validar o valor da transferência " + valor);
        return this;
    }

    /**
     * Metódo para validar o tipo da transferência
     * @throws Exception
     * @return
     */
    @Step("Validar o tipo da transferência")
    public TransferenciaConferirDadosTela conferirTipoTransferencia(String tipo) throws Exception {
        rolarParaBaixoAteElemento(labelTipoTransferencia);
        aguardarCarregamentoElemento(labelTipoTransferencia);
        salvarEvidencia("Validado tipo transferência: " + tipo);
        validarAtributoTexto(labelTipoTransferencia, tipo, "Não foi possível validar o tipo de transferência TED " + tipo );
        return this;
    }

    /**
     * Metódo para validar a finalidade da transferência
     * @throws Exception
     * @return
     */
    @Step("Validar a finalidade da transferência")
    public TransferenciaConferirDadosTela conferirFinalidadeTransferencia(String finalidade) throws Exception {
        rolarParaBaixoAteElemento(labelFinalidadeTransferencia);
        aguardarCarregamentoElemento(labelFinalidadeTransferencia);
        salvarEvidencia("Validada finalidade da transferência: " + finalidade);
        validarAtributoTexto(labelFinalidadeTransferencia, finalidade, "Não foi possível validar a finalidade da transferência " + finalidade );
        return this;
    }

    /**
     * Metódo para validar a descrição da transferência
     * @throws Exception
     * @return
     */
    @Step("Validar a descrição da transferência")
    public TransferenciaConferirDadosTela conferirDescricaoTransferencia(String descricao) throws Exception {
        rolarParaBaixoAteElemento(labelDescricaoTransferencia);
        aguardarCarregamentoElemento(labelDescricaoTransferencia);
        salvarEvidencia("Validada descrição da transferência: " + descricao);
        validarAtributoTexto(labelDescricaoTransferencia, descricao, "Não foi possível validar a descrição da transferência " + descricao);
        return this;
    }
}
