package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class DiaAplicacaoParcelasTela extends PaginaBase {

    @AndroidFindBy(accessibility = "DIA DE APLICA��O DAS PARCELAS")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"DIA DE APLICA��O DAS PARCELAS\"`]")
    private MobileElement tituloDiaDeAplicacaoDasParcelas;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoHeaderConfirmar;

    public DiaAplicacaoParcelasTela(AppiumDriver driver) {
        super(driver);
    }

    public DiaAplicacaoParcelasTela validaExibicaoDiaDeAplicacaoDasParcelasTela(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloDiaDeAplicacaoDasParcelas), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela de Detalhes");
        salvarEvidencia("Validar exibi��o da tela de 'Dia De Aplica��o Das Parcelas'");
        return this;
    }

    /**
     *  Seleciona o dia da aplica��o
     *
     * @param dia
     * @return
     * @throws Exception
     */
    @Step("Seleciona o dia da aplica��o")
    public DiaAplicacaoParcelasTela selecionarDia(String dia) throws Exception {
        OperadorEvidencia.logarPasso("Localizando: [Todo dia " + dia +"]");
        if(android){
            boolean estaNoInicio;
            int loop = 0;
            do {
                MobileElement primeiroDia = retornarElemento(By.xpath("//*[@resource-id='br.com.bradesco.next:id/ctv_day']"), "Erro ao retornar primeiro dia da lista");
                estaNoInicio = verificaValorElementoPorAtributo(primeiroDia,"text", "Todo dia 1",true);
                if(!estaNoInicio)
                    rolarTela(0.6D,0.9D);
                else
                    break;
                loop++;
                if (loop > 12) break;
            }
            while (true);

            MobileElement selecaoDia = null;
            boolean encontrado = false;
            loop = 0;
            do { // elementos com id's iguais fazendo a identifica��o pelo atributo 'text'
                List<MobileElement> selecaoDias = retornarLista(By.id("br.com.bradesco.next:id/ctv_day"), "Erro ao retornar a lista de sele��o Dia Aplica��o");
                for (MobileElement iSelecaoDia : selecaoDias) {
                    encontrado = verificaValorElementoPorAtributo(iSelecaoDia,"text", dia,false);
                    if (encontrado) {
                        selecaoDia = iSelecaoDia;
                        break;
                    }
                }
                if(!encontrado) rolarTela(0.9D,0.6D);
                loop++;
                if(loop > 12) break;
            }
            while (!encontrado);
            salvarEvidencia("selecionando o dia: " + dia);
            tocarElemento(selecaoDia,"Erro ao selecionar dia");

        }
        else {

            MobileElement selecaoDia = retornarElemento(By.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel"), "Erro ao retornar a sele��o Dia Aplica��o");
            int maximoDia = 0;
            while (!verificaValorElementoPorAtributo(selecaoDia,"value", dia,false)) {
                maximoDia++;
                if (maximoDia > 31) break;
                arrastarElementoProporcional(selecaoDia,50,40);
            }
            salvarEvidencia("selecionando o dia: " + dia);
            tocarElemento(selecaoDia,"Erro ao tocar no 'Dia da aplica��o'");

        }
        salvarEvidencia("Selecionou o dia: " + dia);
        return this;

    }

    /**
     * Tocar no bot�o (header) Confirmar (presente apenas em iOS)
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o (header) Confirmar")
    public DiaAplicacaoParcelasTela tocarBotaoHeaderConfirmar() throws NextException {
        if(ios) { // ByPass - presente apenas em ios
            tocarElemento(botaoHeaderConfirmar, "Erro ao tocar no bot�o 'Confirmar'");
            salvarEvidencia("Tocou no bot�o 'Confirmar'");
        }
        return this;
    }


    /**
     * Verifica existencia de um atributo no elemento
     * Ex: verificaValorElementoPorAtributo(labelTitulo, "text", "Next")
     * @param mobileElement
     * @param atributo
     * @param valor
     * @return
     */
    protected boolean verificaValorElementoPorAtributo(MobileElement mobileElement, String atributo, String valor, boolean verificarSeIgual){
        if(verificarSeIgual) {
            return mobileElement.getAttribute(atributo)
                    .replaceAll("[^0-9,A-Z,a-z]","").toUpperCase()
                    .equals(valor.replaceAll("[^0-9,A-Z,a-z]","").toUpperCase());
        }
        else
            return mobileElement.getAttribute(atributo).contains(valor);
    }

}
