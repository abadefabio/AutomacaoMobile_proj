package pagina.mobile.comum.next;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;
import static br.com.next.automacao.core.tools.Utilitarios.proximoFeriado;

public class CalendarioTela extends PaginaBase {

    /* Vari�veis usadas para armazenar data para futuras valida��es se necess�rio */
    private static final ThreadLocal<String> dia = new ThreadLocal<>();
    private static final ThreadLocal<String> mes = new ThreadLocal<>();
    private static final ThreadLocal<String> nomeMes = new ThreadLocal<>();
    private static final ThreadLocal<String> ano = new ThreadLocal<>();

    private final ArrayList<String> mesesExtenso= new ArrayList<>(Arrays.asList("janeiro", "fevereiro", "mar�o", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"));

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tollbar_check")
    @AndroidFindBy(xpath = "//android.widget.Button")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirmar']")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id = \"br.com.bradesco.next:id/title_month_current\"]/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"m�s\")]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement labelAno;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id = \"br.com.bradesco.next:id/title_month_current\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"m�s\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement labelMes;


    public CalendarioTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Armazena valor informado no objeto thread-safe dia
     */
    public static void salvarDia(String d) {
        CalendarioTela.dia.set(d);
    }

    /**
     * Retorna string com o valor do dia armazenado no objeto thread-safe dia
     *
     * @return dia
     */
    public static String retornaDia() {
        return dia.get();
    }

    /**
     * Armazena valor informado no objeto thread-safe dia
     */
    public static void salvarMes(String m) {
        mes.set(m);
    }

    /**
     * Retorna string com o valor do mes armazenado no objeto thread-safe mes
     *
     * @return mes
     */
    public static String retornaMes() {
        return mes.get();
    }

    /**
     * Armazena valor informado no objeto thread-safe nome do m�s
     */
    public static void salvarNomeMes(String nm) {
        nomeMes.set(nm);
    }

    /**
     * Retorna string com o valor do mes armazenado no objeto thread-safe nome m�s
     *
     * @return nomeMes
     */
    public static String retornaNomeMes() {
        return nomeMes.get();
    }

    /**
     * Armazena valor informado no objeto thread-safe ano
     */
    public static void salvarAno(String a) {
        ano.set(a);
    }

    /**
     * Retorna string com o valor do dia armazenado no objeto thread-safe ano
     *
     * @return ano
     */
    public static String retornaAno() {
        return ano.get();
    }

    /**
     * Verifica a presen�a do calend�rio na tela
     *
     * @return
     */
    public boolean verificarPresencaDoCalendario() {
        return verificarPresencaElemento(labelMes);
    }

    /**
     * Tocar Bot�o Confirmar
     *
     * @throws Exception
     */
    @Step("Tocar Bot�o Confirmar")
    public CalendarioTela tocarBotaoConfirmar() throws Exception {
        if (verificarPresencaElemento(botaoConfirmar)) {
            salvarEvidencia("Tocar Bot�o Confirmar");
            tocarElemento(botaoConfirmar, "Nao foi possivel tocar botao 'Confirmar'");
        }
        return this;
    }

    /**
     * Selecionar Data
     *
     * @param feriado: true - data de feriado, false - data de dia �til
     * @param predef   : data pr�-definida
     */
    @Step("Selecionar data informada")
    public CalendarioTela selecionarData(Boolean feriado, String predef) throws Exception {
        String data = retornarData(feriado, predef);
        armazenarData(data);

        esperarCarregando();
        encontrarAnoCalendario(ano.get());
        encontrarMesCalendario(nomeMes.get());
        selecionarData(dia.get(), mes.get(), nomeMes.get(), ano.get());
        return this;
    }

    /**
     * Retorna data do pr�ximo feriado ou da string predef se n�o for null
     * Se a string predef for null, retorna o terceiro pr�ximo dia �til
     *
     * @return String
     */
    private String retornarData(Boolean feriado, String predef) {
        String data;
        if (feriado) {
            data = proximoFeriado();
        } else {
            if (predef == null) {
                data = proximoDiaUtil(3);
            } else {
                data = predef;
            }
        }
        return data;
    }

    /**
     * Separar data de entrada em dia, m�s e ano
     */
    private void armazenarData(String data) {
        dia.set(data.substring(0, 2));
        mes.set(data.substring(3, 5));
        ano.set(data.substring(6));
        nomeMes.set(retornaNomeMes(mes.get()));
    }

    /**
     * Retorna o m�s por extenso baseado no �ndice do m�s
     *
     * @return String
     */
    public String retornaNomeMes(String indiceMes) {
        try {
            int num = Integer.parseInt(indiceMes);
            return mesesExtenso.get(num - 1);
        } catch (Exception e) {
            throw new AssertionError(String.format("Valor de m�s informado � inv�lido: %s", indiceMes));
        }
    }

    /**
     * Selecionar Data
     */
    @Step("Selecionar a Data")
    private void selecionarData(String dia, String indiceMes, String nomeMes, String ano) throws Exception {
        String textoData = " data: \"" + dia + " de " + nomeMes + " de " + ano + "\"";
        if (ios) {
            if (Integer.parseInt(dia) <= 7 && LocalDate.now().getDayOfMonth() >= 28) {
                rolaTelaBaixo();
            }
            List<MobileElement> selecaoDatas = retornarLista(By.xpath("//XCUIElementTypeCell[contains(@name,\"" + dia + " de " + nomeMes + " de " + ano + "\")]"), "Erro ao encontra a " + textoData);
            MobileElement selecaoData = null;
            for (MobileElement me : selecaoDatas) { // tratamento para selecionar a data/elemento correto devido a presen�a de elementos duplicados.
                selecaoData = me;
            }
            salvarEvidencia("Selecionando a " + textoData);
            tocarElemento(selecaoData, "N�o foi poss�vel selecionar a " + textoData);
            salvarEvidencia("Selecionou a " + textoData);
        } else {
            By elementoData = new By.ByXPath("//android.view.View[contains(@content-desc,\"" + ano + "-" + indiceMes + "-" + dia + "\")]");
            if (!verificarPresencaElemento(elementoData)) {
                rolarTela(0.7D, 0.9D);
            }
            MobileElement diaCalendario = retornarElemento(elementoData, "Erro ao localizar a data: \"" + dia + " de " + nomeMes + " de " + ano + "\"");
            salvarEvidencia("Selecionando a " + textoData);
            tocarElemento(diaCalendario, "N�o foi poss�vel selecionar a " + textoData);
            salvarEvidencia("Selecionar a " + textoData);
        }
    }

    /**
     * Rolar calend�rio at� encontrar ano
     *
     * @return
     */
    @Step("Rolar Tela at� encontra ano")
    private void encontrarAnoCalendario(String ano) {
        int anoStart;
        if(!labelAno.getText().contains(",")) {
            anoStart = Integer.parseInt(labelAno.getText().replace("ano ",""));
        }else {
            String dataExtensa = labelAno.getAttribute("name");
            int posicaoVirgula = dataExtensa.indexOf(",");
            anoStart = Integer.parseInt(dataExtensa.substring(posicaoVirgula-4, posicaoVirgula));
        }
        int anoMeta = Integer.parseInt(ano);
        Boolean rolarParaBaixo = anoStart == anoMeta ? null : anoStart < anoMeta;
        int tentativas = 36;
        if (rolarParaBaixo != null) {
            do {
                if (rolarParaBaixo) {
                    rolaTelaBaixo();
                } else {
                    rolaTelaCima();
                }
                aguardarCarregamentoElemento(labelAno);
                tentativas -= 1;
            } while (!labelAno.getText().contains(ano) && tentativas != 0);
            salvarEvidencia("Rolar Tela at� encontra ano");
        }
    }

    /**
     * Rolar calend�rio at� encontrar m�s do ano presente na tela
     *
     * @return
     */
    @Step("Rolar tela at� encontrar m�s calend�rio")
    private void encontrarMesCalendario(String nomeMes) {
        nomeMes = nomeMes.toLowerCase();
        String mesStart = obterMesDaTela();
        Boolean rolarParaBaixo = retornaIndiceMes(mesStart) == retornaIndiceMes(nomeMes) ? null : retornaIndiceMes(mesStart) < retornaIndiceMes(nomeMes);
        int tentativas = 14;
        if (rolarParaBaixo != null) {
            do {
                if (rolarParaBaixo) {
                    rolarTela(0.7, 0.3);
                } else {
                    rolarTela(0.3, 0.7);
                }
                tentativas -= 1;
            } while (retornaIndiceMes(obterMesDaTela()) != retornaIndiceMes(nomeMes) && tentativas != 0) ;
            salvarEvidencia("Rolar tela at� encontrar m�s calend�rio");
        }
    }

    /**
     * Retorna o m�s presente na tela em caixa baixa
     */
    private String obterMesDaTela() {
        if(!labelMes.getText().contains(",")) {
            return labelMes.getText().toLowerCase().replace("m�s ","");
        }else {
            String dataExtensa = labelAno.getAttribute("name");
            int posicaoFinalMes = dataExtensa.indexOf(" de 20");
            return (dataExtensa.substring(6,posicaoFinalMes));
        }
    }

    /**
     * Retorna o �ndice do m�s baseado no nome do m�s por extenso
     */
    public int retornaIndiceMes(String nomeMes) {
        nomeMes = nomeMes.toLowerCase();
        int result = mesesExtenso.indexOf(nomeMes);
        if (result != -1) {
            return result;
        } else {
            throw new AssertionError(String.format("M�s informado � inv�lido: %s", nomeMes));
        }
    }
}
