package pagina.mobile.comum.next;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class CarregamentoTela extends PaginaBase {

    public CarregamentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Aguarda o carregamento da tela (ícone carregando)
     *
     * @return CarregamentoTela
     */
    @Step("Aguardar carregamento da tela")
    public CarregamentoTela aguardarCarregamentoTela() {
        esperarCarregando();
        return this;
    }
}
