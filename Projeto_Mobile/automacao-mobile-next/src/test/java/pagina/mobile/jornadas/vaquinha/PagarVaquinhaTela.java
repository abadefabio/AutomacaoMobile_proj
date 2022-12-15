package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.HashMap;

public class PagarVaquinhaTela extends PaginaBase {


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id = 'br.com.bradesco.next:id/title_month_current']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"mês\")]")
    private MobileElement labelMesAgenda;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement iconConfirmarData;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/radio_schedule")
    @iOSXCUITFindBy(id = "Opção selecionável, Agendar,")
    private MobileElement radioAgendarVaquinha;


    public PagarVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar radio 'AGENDAR'
     *
     * @return PagarVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar radio 'AGENDAR'")
    public PagarVaquinhaTela tocarRadioAgendar() throws Exception {
        salvarEvidencia("Clicar no radio 'AGENDAR'");
        tocarElemento(radioAgendarVaquinha, "Não foi possível clicar no radio 'AGENDAR'");
        return this;
    }

    /**
     * Selecionar Data
     *
     * @param data
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Selecionar a Data")
    public PagarVaquinhaTela selecionarData(String data) throws Exception {
        aguardarCarregamentoElemento(labelMesAgenda);
        //Separa a data de entrada em dia, mês e ano
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        //Dicionario relacionando mes com nome em português
        HashMap<String, String> relacaoMes = new HashMap<String, String>();
        relacaoMes.put("01", "Janeiro");
        relacaoMes.put("02", "Fevereiro");
        relacaoMes.put("03", "Março");
        relacaoMes.put("04", "Abril");
        relacaoMes.put("05", "Maio");
        relacaoMes.put("06", "Junho");
        relacaoMes.put("07", "Julho");
        relacaoMes.put("08", "Agosto");
        relacaoMes.put("09", "Setembro");
        relacaoMes.put("10", "Outubro");
        relacaoMes.put("11", "Novembro");
        relacaoMes.put("12", "Dezembro");
        // substitui valor numérico de mês por nome
        String mesNome = relacaoMes.get(mes);

        if (ios) {
            // data a ser buscada ao deslizar a tela em busca do mês desejado
            By dataPadrao = By.xpath("//XCUIElementTypeCell[contains(@name,'15 de " + mesNome.toLowerCase() + " de " + ano + "')]");
            // data a ser selecionada no calendário
            By dataDesejada = By.xpath("//XCUIElementTypeCell[contains(@name,'" + dia + " de " + mesNome.toLowerCase() + " de " + ano + "')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(dataPadrao,
                    "Não foi possível encontrar o elemento " + dataDesejada + "");
            tocarElemento(dataDesejada, "Não foi possível selecionar a Data");
            OperadorEvidencia.logarPasso("Dia " + dia + " selecionado");
        } else {
            // data a ser selecionada no calendário
            By dataDesejada = By.xpath("//android.view.View[contains(@content-desc,'" + ano + "-" + mes + "-" + dia + "')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(dataDesejada, "Não foi possível encontrar o elemento " + dataDesejada + "");
            tocarElemento(dataDesejada, "Não foi possível selecionar a Data");
            OperadorEvidencia.logarPasso("Dia " + dia + " selecionado");
        }
        salvarEvidencia("Selecionar a Data");
        return this;
    }

    /**
     * Tocar em 'Confirmar Data'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar Data'")
    public PagarVaquinhaTela tocarBotaoConfirmarData() throws Exception {
        aguardarCarregamentoElemento(iconConfirmarData);
        tocarElemento(iconConfirmarData, "Não foi possível tocar em 'Confirmar Data'");
        return this;
    }

    /**
     * Tocar em 'Continuar'
     *
     * @return VaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public PagarVaquinhaTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

}
