package pagina.mobile.jornadas.configuracoes.perfil;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;

import static java.time.Duration.ofSeconds;

public class ConfiguracoesPerfilTela extends PaginaBase {

    //botao Perfil - Engrenagem
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_menu_profile_arrow")
    @iOSXCUITFindBy(accessibility = "icon-gear")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"icon-gear\"`]")
    private MobileElement botaoPerfilEngrenagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/fl_next_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_payment_settings")
    @iOSXCUITFindBy(accessibility = "CONFIGURA��ES DE PAGAMENTO")
    private MobileElement botaoConfiguracoesDePagamento;

    public ConfiguracoesPerfilTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o Perfil - Engrenagem
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Perfil Engrenagem\"")
    public ConfiguracoesPerfilTela tocarPerfilEngrenagem() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Perfil - Engrenagem'");
        if (ios) {
            tocarCoordenadaElemento(botaoPerfilEngrenagem);
        } else
            tocarElemento(botaoPerfilEngrenagem, "N�o foi poss�vel Tocar no bot�o Perfil Engrenagem");
        return this;
    }

    /** tocar botao via coordenada encontrada no id passado via param
     * @param elemento
     * @return
     * @throws Exception
     */
    protected void tocarCoordenadaElemento(MobileElement elemento) throws Exception {
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }

    /**
     * Tocar bot�o Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public ConfiguracoesPerfilTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar bot�o voltar");
        return this;
    }

    /**
     * Tocar bot�o "Configura��es de pagamento"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Configura��es de Pagamento\"")
    public ConfiguracoesPerfilTela tocarConfiguracoesDePagamento() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesDePagamento,"N�o foi poss�vel tocar no bot�o 'Configura��es de Pagamento'");
        salvarEvidencia("Tocar bot�o 'Configura��es de Pagamento'");
        tocarElemento(botaoConfiguracoesDePagamento,"N�o foi poss�vel tocar no bot�o Configura��es de Pagamento");
        return this;
    }

}


