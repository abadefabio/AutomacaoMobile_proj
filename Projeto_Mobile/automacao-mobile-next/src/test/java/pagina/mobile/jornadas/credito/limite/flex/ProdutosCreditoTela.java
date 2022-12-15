package pagina.mobile.jornadas.credito.limite.flex;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutosCreditoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_ok_flex_limit_config_act")
    private MobileElement btnContinuar;

    @AndroidFindBy(xpath = "//*[@text='AGORA N�O']")
    private MobileElement btnAgoraNao;

    public ProdutosCreditoTela(AppiumDriver driver) {super(driver);}

    /**
     * Tocar botao "Continuar"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public ProdutosCreditoTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnContinuar, "Nao foi possivel rolar no bot�o 'Continuar'");
        tocarElemento(btnContinuar,"Nao foi possivel tocar no bot�o 'Continuar'");
        aguardarOcultacaoElemento(btnContinuar);
        return this;
    }
    /**
     * Tocar botao "Agora Nao"
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar bot�o 'Agora Nao'")
    public ProdutosCreditoTela tocarBotaoAgoraNao() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Agora nao'");
        tocarElemento(btnAgoraNao, "Nao foi possivel tocar no bot�o 'Agora nao'");
        aguardarOcultacaoElemento(btnAgoraNao);
        return this;
    }
}
