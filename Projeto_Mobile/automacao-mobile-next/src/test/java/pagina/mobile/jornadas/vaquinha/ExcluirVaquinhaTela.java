package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.vaquinha.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ExcluirVaquinhaTela extends PaginaBase {
    public ExcluirVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_delete_vaquinha")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Excluir Vaquinha']")
    private MobileElement botaoExcluirVaquinha;

    /**
     * Validar presen�a da tela 'Excluir'
     *
     * @return ExcluirVaquinhaTela
     * @throws Exception
     */
    @Step("Validar tela 'Excluir'")
    public ExcluirVaquinhaTela validarTelaExcluir() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EXCLUIR.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Excluir' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a do t�tulo 'Excluir'");
        return this;
    }

    /**
     * Tocar bot�o 'Excluir Vaquinha'
     *
     * @return ExcluirVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Excluir Vaquinha'")
    public ExcluirVaquinhaTela tocarExcluirVaquinha() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirVaquinha);
        salvarEvidencia("Tocar no botao 'Excluir Vaquinha'");
        tocarElemento(botaoExcluirVaquinha, "N�o foi poss�vel tocar no bot�o 'Excluir Vaquinha'");
        return this;
    }
}
