package framework;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.error.NextError;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBySet;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class AcoesGerais extends PaginaBase {
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBySet({
            @iOSXCUITFindBy(xpath = "//*[translate(@label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = \"seguinte\"]"),
            @iOSXCUITFindBy(id = "OK"),
            @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') ='ok']"),
            @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]"),
            @iOSXCUITFindBy(accessibility = "Próximo"),
            @iOSXCUITFindBy(xpath = "//*[contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'ximo')]"),
            @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = \"search\"]"),
    })
    private MobileElement teclado;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Carregando\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"carregando\")]")
    private MobileElement iconeCarregando;

    public AcoesGerais(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Reprodução do mesmo método privado no framework
     */
     public boolean tecladoPresente() {
        return this.ios ? ((IOSDriver)this.driver).isKeyboardShown() : ((AndroidDriver)this.driver).isKeyboardShown();
     }

    /**
     * Corrigindo esconderTeclado(framework) apenas adicionando mais um mapeamento no elemento 'teclado'
     */
    public void esconderTeclado() {
        try {
            if (this.tecladoPresente()) {
                if (this.ios) {
                    this.teclado.click();
                } else {
                    ((AppiumDriver) this.driver).hideKeyboard();
                }
            }
        } catch (Exception var2) {
        }
    }

    /**
     * Corrigindo o método tocarCoordenadaProporcional(framework)
     */
    public void tocarCoordenadaProporcional(MobileElement elemento, int percentualX, int percentualY) throws NextException {
        try {
            MobileElement elementoMobile = this.retornaElemento(elemento);

            try {
                tocarCorrigido(elementoMobile, percentualX, percentualY); //mudança só aqui
            } catch (Exception var6) {
            }

        } catch (Exception var7) {
            throw new NextException(this, var7.getMessage(), var7);
        }
    }

    /**
     * Corrigindo tocar(framework) no cálculo do origemElemento
     */
    private void tocarCorrigido(MobileElement elemento, int proporcionalX, int proporcionalY) {
        Rectangle retangulo = elemento.getRect();
        Point origemElemento = new Point(retangulo.x, retangulo.y); //mudança só aqui
        tocar(origemElemento.moveBy(proporcionalX * retangulo.width / 100, proporcionalY * retangulo.height / 100));
    }

    /**
     * Reprodução do mesmo método privado no framework
     */
    private void tocar(Point ponto) {
        new TouchAction((AppiumDriver)this.driver)
                .tap(PointOption.point(ponto)).perform();
    }

    /**
     * Corrigindo deslizar(framework) para pivo usar a altura da metade do elemento e não o topo do elemento
     */
    public <T> void deslizar(T elemento, Direcao direcao, int proporcionalMinimo, int proporcionalMaximo) throws NextException {
        try {
            MobileElement elementoMobile = this.retornaElemento(elemento);
            int pivo = elementoMobile.getCenter().y * 100 / retornaDimensaoTela().getHeight(); //mudança só aqui

            try {
                this.moverTela(direcao, pivo, proporcionalMinimo, proporcionalMaximo);
            } catch (Exception var8) {
            }

        } catch (Exception var9) {
            throw new NextException(this, var9.getMessage(), var9);
        }
    }

    /**
     * Reprodução do mesmo método privado no framework
     */
    private void moverTela(Direcao direcao, int proporcionalPivo, int proporcionalMinimo, int proporcionalMaximo) {
        Map<String, Object> mapa = new HashMap();
        mapa.put("direção", direcao);
        mapa.put("pivo", proporcionalPivo);
        mapa.put("minimo", proporcionalMinimo);
        mapa.put("maximo", proporcionalMaximo);
        Function<Point[], String> deslizaTela = (x) -> {
            new TouchAction((AppiumDriver)this.driver)
                    .longPress(PointOption.point(x[0])).moveTo(PointOption.point(x[1])).release().perform();
            return ">>> Tela deslizada na direção " + direcao;
        };
        OperadorEvidencia.logarPasso((String)deslizaTela.apply(this.retornaCoordenadas(mapa)));
    }

    /**
     * Reprodução do mesmo método privado no framework
     */
    private Point coordenadaProporcionalTela(Point p) {
        int x = p.getX() * retornaDimensaoTela().getWidth() / 100;
        int y = p.getY() * retornaDimensaoTela().getHeight() / 100;
        return new Point(x, y);
    }

    /**
     * Reprodução do mesmo método privado no framework
     */
    private Point[] retornaCoordenadas(Map<String, Object> mapa) {
        Direcao d = (Direcao)mapa.get("direção");
        int pivo = (Integer)mapa.get("pivo");
        int minimo = (Integer)mapa.get("minimo");
        int maximo = (Integer)mapa.get("maximo");
        switch(d) {
            case DIREITA:
                return new Point[]{(Point)this.coordenadaProporcionalTela(new Point(minimo, pivo)), (Point)this.coordenadaProporcionalTela(new Point(maximo, pivo))};
            case ESQUERDA:
                return new Point[]{(Point)this.coordenadaProporcionalTela(new Point(maximo, pivo)), (Point)this.coordenadaProporcionalTela(new Point(minimo, pivo))};
            case ACIMA:
                return new Point[]{(Point)this.coordenadaProporcionalTela(new Point(pivo, minimo)), (Point)this.coordenadaProporcionalTela(new Point(pivo, maximo))};
            case ABAIXO:
                return new Point[]{(Point)this.coordenadaProporcionalTela(new Point(pivo, maximo)), (Point)this.coordenadaProporcionalTela(new Point(pivo, minimo))};
            default:
                return new Point[0];
        }
    }

    /**
     * Melhorando visualização da validação dos campos e valores do método validarCamposValor(framework).
     * Não era possível identificar qual campo falhou e qual era o esperado nem o encontrado.
     */
    public <T> void validarCamposValor(List<T> elementosCampo, List<T> elementosValor, Map<String, String> dicionarioValoresEsperados) throws Exception {
        try {
            Map<String, String> dicionario = this.retornaDicionarioCampos(elementosCampo, elementosValor);
            for (Map.Entry<String, String> linha: dicionarioValoresEsperados.entrySet()) { //formato 'for' ao invés de 'each' para lançar exceção no else
                String campo = linha.getKey();
                String valor = linha.getValue();
                if (dicionario.containsKey(Utilitarios.normalizaString(campo))) {
                    String valorReal = dicionario.get(Utilitarios.normalizaString(campo));
                    OperadorEvidencia.logarPasso(String.format("Validar campo '%s' com valor '%s'", campo, valor));
                    Assert.assertTrue(valorReal.contains(Utilitarios.normalizaString(valor)),
                            "O valor esperado para o campo \"" + campo + " \":" + valor + "\nValor obitido: \"" + valorReal + "\".");
                } else {
                    throw new Exception(String.format("Não foi possível encontrar campo esperado '%s'", campo));
                }
            }
        } catch (Exception var5) {
            throw new NextException(this, "Erro encontrado ao tentar recuperar texto do elemento", var5);
        } catch (AssertionError var6) {
            throw new NextError(this, var6.getMessage(), var6);
        }
    }

    /**
     * Reprodução do mesmo método privado no framework
     */
    private <T> Map<String, String> retornaDicionarioCampos(List<T> elementosCampo, List<T> elementosValor) throws Exception {
        Map<String, String> dicionario = new HashMap();
        if (elementosCampo.size() != elementosValor.size()) {
            throw new Exception("Quantidade campos informados não é a mesma quantidade de valores.");
        } else {
            for(int i = 0; i < elementosCampo.size(); ++i) {
                String campo = Utilitarios.normalizaString(this.retornaElemento(elementosCampo.get(i)).getText());
                String valor = Utilitarios.normalizaString(this.retornaElemento(elementosValor.get(i)).getText());
                dicionario.put(campo, valor);
            }

            return dicionario;
        }
    }
}
