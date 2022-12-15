package pagina.mobile.jornadas.pix.copia.cola;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesAdicionaisTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//*[@name = \"INFORMA��ES ADICIONAIS\"]")
    private MobileElement tituloInformacoesAdicionais;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_back")
    @iOSXCUITFindBy(accessibility = "VOLTAR")
    private MobileElement botaoVoltar;

    public InformacoesAdicionaisTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Validar T�tulo da tela Informa��es Adicionais
     *
     * @return
     * @throws Exception
     */
    @Step("Validar T�tulo da tela 'Informa��es Adicionais'")
    public InformacoesAdicionaisTela validarTituloInformacoesAdicionais() throws Exception {
        aguardarCarregamentoElemento(tituloInformacoesAdicionais);
        salvarEvidencia("Validar T�tulo da tela 'Informa��es Adicionais'");
        return this;
    }

    /**
     * Validar exist�ncia textos Nome e Regra na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar textos 'Nome' e 'Regra' na tela 'Informa��es Adicionais'")
    public InformacoesAdicionaisTela validarTextosNomeRegraTelaInformacoesAdicionais() throws Exception {
        aguardarPaginaConterTodosTextos("Veja aqui as informa��es adicionais", "Nome", "Regra");
        salvarEvidencia("Validar textos 'Nome' e 'Regra' na tela 'Informa��es Adicionais'");
        return this;
    }

    /**
     * Tocar bot�o Voltar da tela Informa��es Adicionais
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar' da tela 'Informa��es Adicionais'")
    public InformacoesAdicionaisTela tocarBotaoVoltarInformacoesAdicionais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVoltar, "N�o foi poss�vel localizar o bot�o 'Voltar'");
        salvarEvidencia("Tocar bot�o 'Voltar' da tela 'Informa��es Adicionais'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }
}
