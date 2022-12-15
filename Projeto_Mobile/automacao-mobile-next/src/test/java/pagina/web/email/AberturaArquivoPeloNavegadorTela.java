package pagina.web.email;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.drivers.OperadorDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AberturaArquivoPeloNavegadorTela extends PaginaBaseWeb {

    @CacheLookup
    @FindBy(id = "password")
    private WebElement comboSenhaArquivoBaixado;

    @CacheLookup
    @FindBy(id="passwordSubmit")
    private WebElement botaoOkSenhaArquivoBaixado;

    public AberturaArquivoPeloNavegadorTela(WebDriver driver) {
        super(driver);
    }


    /**
     * Digitar senha do arquivo baixado
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Digitar senha do arquivo baixado")
    public AberturaArquivoPeloNavegadorTela digitarSenhaArquivoBaixado(String senhaArquivo) throws Exception {
        digitarTexto(comboSenhaArquivoBaixado,senhaArquivo,
                "Erro ao digitar a senha do arquivo baixado");
        salvarEvidencia("Digitar senha do arquivo baixado");
        return this;
    }

    /**
     * Tocar botao ok para abertura do arquivo pelo navegador
     * @return EmailWebTela
     * @throws Exception
     */
    @Step("Tocar botao ok para abertura do arquivo pelo navegador")
    public AberturaArquivoPeloNavegadorTela tocarBotaoOkAberturaNavegador()throws Exception{
        salvarEvidencia("Tocar botao ok para abertura do arquivo pelo navegador");
        clicarElemento(botaoOkSenhaArquivoBaixado,"Tocar botao ok para abertura do arquivo pelo navegador");
        return this;
    }
}
