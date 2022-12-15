package pagina.mobile.jornadas.pix.copia.cola;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesAdicionaisTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//*[@name = \"INFORMAÇÕES ADICIONAIS\"]")
    private MobileElement tituloInformacoesAdicionais;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_back")
    @iOSXCUITFindBy(accessibility = "VOLTAR")
    private MobileElement botaoVoltar;

    public InformacoesAdicionaisTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Validar Título da tela Informações Adicionais
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Título da tela 'Informações Adicionais'")
    public InformacoesAdicionaisTela validarTituloInformacoesAdicionais() throws Exception {
        aguardarCarregamentoElemento(tituloInformacoesAdicionais);
        salvarEvidencia("Validar Título da tela 'Informações Adicionais'");
        return this;
    }

    /**
     * Validar existência textos Nome e Regra na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar textos 'Nome' e 'Regra' na tela 'Informações Adicionais'")
    public InformacoesAdicionaisTela validarTextosNomeRegraTelaInformacoesAdicionais() throws Exception {
        aguardarPaginaConterTodosTextos("Veja aqui as informações adicionais", "Nome", "Regra");
        salvarEvidencia("Validar textos 'Nome' e 'Regra' na tela 'Informações Adicionais'");
        return this;
    }

    /**
     * Tocar botão Voltar da tela Informações Adicionais
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar' da tela 'Informações Adicionais'")
    public InformacoesAdicionaisTela tocarBotaoVoltarInformacoesAdicionais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVoltar, "Não foi possível localizar o botão 'Voltar'");
        salvarEvidencia("Tocar botão 'Voltar' da tela 'Informações Adicionais'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }
}
