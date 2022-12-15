package pagina.mobile.jornadas.ajuda;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CotacaoDoDolarTela extends PaginaBase {


    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COTAÇÃO DO DÓLAR\"]")
    private MobileElement tituloTelaCotacaoDoDolar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/npb_period_select")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Clique para selecionar um período\"]")
    private MobileElement campoPeriodo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_amount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/*[contains(@name,'Cotação')]")
    private MobileElement textoResultadoCotacaoDoDolar;

    public CotacaoDoDolarTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Método para verificar título da tela
     * @return CotacaoDoDolarTela
     */
    @Step("Método para validar título da tela Cotação do Dólar")
    public CotacaoDoDolarTela validarTituloTelaCotacaoDoDolar() {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaCotacaoDoDolar), MetodoComparacaoBooleano.VERDADEIRO, "Título 'COTAÇÃO DO DÓLAR' não está presente na tela!");
        salvarEvidencia("Validar título da tela 'COTAÇÃO DO DÓLAR'");
        return this;
    }

    /**
     * Método para tocar no campo Período
     * @return CotacaoDoDolarTela
     * @throws NextException
     */
    @Step("Método para tocar no campo Período")
    public CotacaoDoDolarTela tocarCampoPeríodo() throws NextException {
        aguardarCarregamentoElemento(campoPeriodo);
        tocarElemento(campoPeriodo, "Campo Período não encontrado");
        salvarEvidencia("Tocar no botão 'Período'");
        return this;
    }

    /**
     * Método para verificar resultado da cotação do dólar
     * @return CotacaoDoDolarTela
     */
    @Step("Método para validar resultado de consulta da Cotação do Dólar")
    public CotacaoDoDolarTela validarResultadoConsultaCotacaoDoDolar() {
        aguardarExistenciaElemento(textoResultadoCotacaoDoDolar);
        salvarEvidencia("Validar resultado da consulta de cotação do dólar");
        return this;
    }
}
