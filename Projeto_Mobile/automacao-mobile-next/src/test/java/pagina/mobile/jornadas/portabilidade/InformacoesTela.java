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

    //Texto do menu Informação
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/tv_info_content")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'O que é o banco da Conta Salário?')]")
    private MobileElement textoInfo;

    public InformacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar botão 'Voltar'
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Data Final\"")
    public InformacoesTela tocarBotaoVoltarInformacao() throws Exception {
        aguardarCarregamentoElemento( botaoVoltarInformacao );
        tocarElemento( botaoVoltarInformacao, "Não foi possível clicar botão 'Voltar'" );
        salvarEvidencia( "Clicar botão 'Voltar'" );
        return this;
    }

    /**
     * Validar texto Informação
     *
     * @return
     * @throws Exception
     */
    @Step("Validar texto menu \"Informação\"")
    public InformacoesTela validarMenuInformacao() throws Exception {
        aguardarCarregamentoElemento(textoInfo);
        if(android) {
            compararElementoTexto(textoInfo, PortabilidadeDados.CONTA_SALARIO, MetodoComparacao.CONTEM);
        }else{
            compararElementoTexto(textoInfo, PortabilidadeDados.CONTA_SALARIO_IOS, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Tela Informação Validada");
        return this;
    }
}
