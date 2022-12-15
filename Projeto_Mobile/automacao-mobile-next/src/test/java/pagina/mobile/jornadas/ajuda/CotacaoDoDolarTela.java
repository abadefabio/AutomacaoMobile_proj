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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COTA��O DO D�LAR\"]")
    private MobileElement tituloTelaCotacaoDoDolar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/npb_period_select")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Clique para selecionar um per�odo\"]")
    private MobileElement campoPeriodo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_amount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/*[contains(@name,'Cota��o')]")
    private MobileElement textoResultadoCotacaoDoDolar;

    public CotacaoDoDolarTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para verificar t�tulo da tela
     * @return CotacaoDoDolarTela
     */
    @Step("M�todo para validar t�tulo da tela Cota��o do D�lar")
    public CotacaoDoDolarTela validarTituloTelaCotacaoDoDolar() {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaCotacaoDoDolar), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'COTA��O DO D�LAR' n�o est� presente na tela!");
        salvarEvidencia("Validar t�tulo da tela 'COTA��O DO D�LAR'");
        return this;
    }

    /**
     * M�todo para tocar no campo Per�odo
     * @return CotacaoDoDolarTela
     * @throws NextException
     */
    @Step("M�todo para tocar no campo Per�odo")
    public CotacaoDoDolarTela tocarCampoPer�odo() throws NextException {
        aguardarCarregamentoElemento(campoPeriodo);
        tocarElemento(campoPeriodo, "Campo Per�odo n�o encontrado");
        salvarEvidencia("Tocar no bot�o 'Per�odo'");
        return this;
    }

    /**
     * M�todo para verificar resultado da cota��o do d�lar
     * @return CotacaoDoDolarTela
     */
    @Step("M�todo para validar resultado de consulta da Cota��o do D�lar")
    public CotacaoDoDolarTela validarResultadoConsultaCotacaoDoDolar() {
        aguardarExistenciaElemento(textoResultadoCotacaoDoDolar);
        salvarEvidencia("Validar resultado da consulta de cota��o do d�lar");
        return this;
    }
}
