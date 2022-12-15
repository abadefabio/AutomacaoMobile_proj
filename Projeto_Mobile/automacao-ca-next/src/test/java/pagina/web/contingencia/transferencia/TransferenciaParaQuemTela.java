package pagina.web.contingencia.transferencia;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.WebUtils.aguardarCarregamentoDaPagina;

public class TransferenciaParaQuemTela extends TransferenciaTela {

    public TransferenciaParaQuemTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='Para mim0-label']/span")
    private WebElement radioButtonParaMim;

    @FindBy(xpath = " //*[@id=\"button-0\"]/span")
    private WebElement radioButtonContaDestino;

    @FindBy(xpath = " //*[@id=\"radio-0-0\"]")
    private WebElement radioButtonSelecionarContaDestino;

    @FindBy(id = "confirmContacts")
    private WebElement buttonConfirmar;


    @FindBy(xpath = "//*[@id='Outra pessoa1-label']/span")
    private WebElement radioButtonParaOutraPessoa;

    /**
     * Met�do para clicar no radio button 'Para Mim'
     * @throws Exception
     * @return
     */
    @Step("Clicar no radio Button 'Para Mim'")
    public TransferenciaParaQuemTela clicarRadionButtonParaMim() throws Exception {
        rolarParaBaixoAteElemento(radioButtonParaMim);
        aguardarCarregamentoElemento(radioButtonParaMim);
        clicarElemento(radioButtonParaMim, "N�o foi poss�vel clicar na op��o 'Para Mim'");
        salvarEvidencia("Clicado no radionbutton 'Para Mim' ");
        return this;
    }


    /**
     * Met�do para clicar no radio button 'Conta Destino'
     * @throws Exception
     * @return
     */
    @Step("Clicar no radio Button 'Conta Destino'")
    public TransferenciaParaQuemTela clicarContaDestino() throws Exception {
        rolarParaBaixoAteElemento(radioButtonContaDestino);
        aguardarElementoClicavel(By.id(String.valueOf(radioButtonContaDestino)));
        clicarElemento(radioButtonContaDestino, "N�o foi poss�vel clicar na op��o 'Conta Dest");
        salvarEvidencia("Clicado no radionbutton 'Conta Destino ");
        return this;
    }

    /**
     * Met�do para clicar no radio button ' Selecionar Conta Destino'
     * @throws Exception
     * @return
     */
    @Step("Clicar no radio Button ' Selecionar Conta Destino'")
    public TransferenciaParaQuemTela clicarSelecionarContaDestno() throws Exception {
        rolarParaBaixoAteElemento(radioButtonSelecionarContaDestino);
        aguardarElementoClicavel(By.id(String.valueOf(radioButtonSelecionarContaDestino)));
        clicarElemento(radioButtonSelecionarContaDestino, "N�o foi poss�vel clicar na op��o 'Selecionar Conta Destino");
        salvarEvidencia("Clicado no radionbutton 'Selecionar Conta Destino' ");
        return this;
    }

    /**
     * Met�do para clicar no radio button ' Confirmar'
     * @throws Exception
     * @return
     */
    @Step("Clicar no radio Button ' Clicar no bot�o Confirmar'")
    public TransferenciaParaQuemTela clicarBotaoConfirmar() throws Exception {
        rolarParaBaixoAteElemento(buttonConfirmar);
        aguardarElementoClicavel(By.id(String.valueOf(buttonConfirmar)));
        clicarElemento(buttonConfirmar, "N�o foi poss�vel clicar na op��o 'no Bot�o Confirmar");
        salvarEvidencia("Clicado no button 'Confirmar' ");
        return this;
    }

    /**
     * Met�do para clicar radio button 'Outra Pessoa'
     * @throws Exception
     * @return
     */
    @Step("Clicar no radio Button 'Outra Pessoa'")
    public TransferenciaParaQuemTela clicarRadionButtonOutraPessoa() throws Exception {
        aguardarCarregamentoDaPagina(driver);
        rolarParaBaixoAteElemento(radioButtonParaOutraPessoa);
        aguardarCarregamentoElemento(radioButtonParaOutraPessoa);
        clicarElemento(radioButtonParaOutraPessoa, "N�o foi poss�vel clicar na op��o 'Para Outra Pessoa'");
        salvarEvidencia("Clicado no radionbutton 'Outra Pessoa ");
        return this;
    }
}
