package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.portabilidade.PortabilidadeDados;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[1]")
    private MobileElement botaoVoltarInformacao;

    //Texto do menu Informa��o
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/tv_info_content")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'O que � o banco da Conta Sal�rio?')]")
    private MobileElement textoInfo;

    public InformacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar bot�o 'Voltar'
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Data Final\"")
    public InformacoesTela tocarBotaoVoltarInformacao() throws Exception {
        aguardarCarregamentoElemento( botaoVoltarInformacao );
        tocarElemento( botaoVoltarInformacao, "N�o foi poss�vel clicar bot�o 'Voltar'" );
        salvarEvidencia( "Clicar bot�o 'Voltar'" );
        return this;
    }

    /**
     * Validar texto Informa��o
     *
     * @return
     * @throws Exception
     */
    @Step("Validar texto menu \"Informa��o\"")
    public InformacoesTela validarMenuInformacao() throws Exception {
        aguardarCarregamentoElemento(textoInfo);
        if(android) {
            compararElementoTexto(textoInfo, PortabilidadeDados.CONTA_SALARIO, MetodoComparacao.CONTEM);
        }else{
            compararElementoTexto(textoInfo, PortabilidadeDados.CONTA_SALARIO_IOS, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Tela Informa��o Validada");
        return this;
    }
}
