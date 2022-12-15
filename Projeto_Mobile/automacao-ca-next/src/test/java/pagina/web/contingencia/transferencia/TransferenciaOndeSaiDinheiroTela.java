package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferenciaOndeSaiDinheiroTela extends TransferenciaTela {

    public TransferenciaOndeSaiDinheiroTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Conta-Corrente0-label")
    private WebElement radioButtonTipoContaCorrente;

    @FindBy(id = "Poupan�a1-label")
    private WebElement radioButtonTipoContaPoupanca;

    /**
     * Met�do para selecionar de onde sai o dinheiro 'Conta Corrente'
     * @throws Exception
     * @return
     */
    @Step("Selecionar radioButton 'De onde vai sair o dinheiro - conta corrente'")
    public TransferenciaOndeSaiDinheiroTela selecionarTipoContaCorrente() throws Exception {
        rolarParaBaixoAteElemento(radioButtonTipoContaCorrente);
        aguardarCarregamentoElemento(radioButtonTipoContaCorrente);
        salvarEvidencia("Selecionado de onde vai sair o dinheiro: Conta-Corrente " );
        clicarElemento(radioButtonTipoContaCorrente, "N�o foi poss�vel selecionar o radiobutton do tipo da conta que vai sair o dinheiro " );
        return this;
    }

    /**
     * Met�do para selecionar de onde sai o dinheiro ' Conta Poupan�a'
     * @throws Exception
     * @return
     */
    @Step("Selecionar radio Button 'De onde vai sair o dinheiro - conta poupan�a'")
    public TransferenciaOndeSaiDinheiroTela selecionarTipoContaPoupanca() throws Exception {
        rolarParaBaixoAteElemento(radioButtonTipoContaPoupanca);
        aguardarCarregamentoElemento(radioButtonTipoContaPoupanca);
        salvarEvidencia("Selecionado de onde vai sair o dinheiro: Conta Poupan�a " );
        clicarElemento(radioButtonTipoContaPoupanca, "N�o foi poss�vel selecionar o radiobutton do tipo da conta que vai sair o dinheiro " );
        return this;
    }
}
