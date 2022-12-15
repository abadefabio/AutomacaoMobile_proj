package br.com.next.automacao.core.base.mobile;

import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

/**
 * Classe interna à PaginaBase criada para organizar as ações de toque em tela
 * @author Matheus Lima Barbosa de Tulio
 * @since 11-2021
 * @version 4.0.2
 */
public class AcoesToqueTela {

    TouchAction acao = new TouchAction<>(getDriver());
    Dimension dimensaoTela;

    AcoesToqueTela(){
        dimensaoTela = getDriver().manage().window().getSize();
    }

    /**
     * Função para retornar coordenada tela a partir de coordenadas proporcionais
     */
    protected Function<Point,Point> coordenadaProporcionalTela = p ->{
        int x = p.getX() * dimensaoTela.width / 100;
        int y = p.getY() * dimensaoTela.height / 100;
        return new Point(x,y);
    };

    /**
     * Função para retornar coordenadas de movimentação da tela a partir da direção e dos
     * valores percentuais da menor posição na direção, da maior posição na direção e da
     * posição de referência na direção perpendicular a do movimento
     */
    protected Function<Map<String,Object>, Point[]> retornaCoordenadas = mapa -> {

        Direcao d = (Direcao) mapa.get("direção");
        int pivo = (Integer) mapa.get("pivo");
        int minimo = (Integer) mapa.get("minimo");
        int maximo = (Integer) mapa.get("maximo");

        switch(d){
            case ABAIXO:
                return new Point[]{
                        coordenadaProporcionalTela.apply(new Point(pivo,maximo)),
                        coordenadaProporcionalTela.apply(new Point(pivo,minimo))
                };
            case ACIMA:
                return new Point[]{
                        coordenadaProporcionalTela.apply(new Point(pivo,minimo)),
                        coordenadaProporcionalTela.apply(new Point(pivo,maximo))
                };
            case DIREITA:
                return new Point[]{
                        coordenadaProporcionalTela.apply(new Point(minimo,pivo)),
                        coordenadaProporcionalTela.apply(new Point(maximo,pivo))
                };
            case ESQUERDA:
                return new Point[]{
                        coordenadaProporcionalTela.apply(new Point(maximo, pivo)),
                        coordenadaProporcionalTela.apply(new Point(minimo, pivo))
                };
        }
        return new Point[0];
    };

    /**
     * Desliza tela device na direção horizontal
     * @param direcao - direção do movimento em tela
     * @param xProporcionalMinimo - maior posição percentual da área de ação do movimento
     * @param xProporcionalMinimo - menor posição percentual da área de ação do movimento
     * @param tempoMilis - tempo da ação em milisegundos
     */
    protected void deslizarTela(Direcao direcao, int xProporcionalMinimo, int xProporcionalMaximo, int tempoMilis){
        switch (direcao){
            case DIREITA:
            case ESQUERDA:
                break;
            default:
                throw new IllegalArgumentException("O método não admite a direção \"" + direcao + "\"");
        }
        moverTela(direcao,50,xProporcionalMinimo, xProporcionalMaximo, tempoMilis);
    }

    /**
     * Rola a tela do device na direção vertical
     * @param yProporcionalIn - Posição de início da ação em porcentagem da altura da tela
     * @param yProporcionalF - Posição de fim da ação em porcentagem da altura da tela
     */
    protected void rolarTela(int yProporcionalIn, int yProporcionalF){
        int minimo, maximo;
        Direcao direcao;
        if(yProporcionalIn > yProporcionalF) {
            direcao = Direcao.ABAIXO;
            minimo = yProporcionalF;
            maximo = yProporcionalIn;
        }else {
            direcao = Direcao.ACIMA;
            maximo = yProporcionalF;
            minimo = yProporcionalIn;
        }
        moverTela(direcao,50,minimo, maximo);
    }

    /**
     * Método utiliza classe TouchActions para mover a tela do device
     * na direção desejada
     * @param direcao - Direção do movimento: ABAIXO, ACIMA, DIREITA, ESQUERDA
     * @param proporcionalPivo - Posição percentual (20%, 30%, ...) em relação a tela
     *                         da coordenada ser mantida constante entre as posições do movimento
     * @param proporcionalMinimo - Posição percentual (20%, 30%, ...) em relação a tela
     *                          da coordenada com menor valor entre as posições do movimento
     * @param proporcionalMaximo - Posição percentual (20%, 30%, ...) em relação a tela
     *                          da coordenada com maior valor entre as posições do movimento
     */
    protected void moverTela(Direcao direcao, int proporcionalPivo, int proporcionalMinimo, int proporcionalMaximo){
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("direção", direcao);
        mapa.put("pivo", proporcionalPivo);
        mapa.put("minimo", proporcionalMinimo);
        mapa.put("maximo", proporcionalMaximo);

        Function<Point[],String>  deslizaTela = x -> {
            acao
                    .longPress(PointOption.point(x[0]))
                    .moveTo(PointOption.point(x[1]))
                    .release()
                    .perform();
            return ">>> Tela deslizada na direção " + direcao;
        };

        OperadorEvidencia.logarPasso(retornaCoordenadas.andThen(deslizaTela).apply(mapa));
    }

    /**
     * Método utiliza classe TouchActions para mover a tela do device
     * na direção desejada
     * @param direcao - Direção do movimento: ABAIXO, ACIMA, DIREITA, ESQUERDA
     * @param proporcionalPivo - Posição percentual (20%, 30%, ...) em relação a tela
     *                         da coordenada ser mantida constante entre as posições do movimento
     * @param proporcionalMinimo - Posição percentual (20%, 30%, ...) em relação a tela
     *                          da coordenada com menor valor entre as posições do movimento
     * @param proporcionalMaximo - Posição percentual (20%, 30%, ...) em relação a tela
     *                          da coordenada com maior valor entre as posições do movimento
     */
    protected void moverTela(Direcao direcao,
                           int proporcionalPivo,
                           int proporcionalMinimo,
                           int proporcionalMaximo,
                           int tempoMilis){
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("direção", direcao);
        mapa.put("pivo", proporcionalPivo);
        mapa.put("minimo", proporcionalMinimo);
        mapa.put("maximo", proporcionalMaximo);

        Function<Point[],String>  deslizaTela = x -> {
            acao
                    .longPress(LongPressOptions.longPressOptions().
                            withDuration(Duration.ofMillis(tempoMilis)).
                            withPosition(PointOption.point(x[0])))
                    .moveTo(PointOption.point(x[1]))
                    .release()
                    .perform();
            return ">>> Tela deslizada na direção " + direcao;
        };

        OperadorEvidencia.logarPasso(retornaCoordenadas.andThen(deslizaTela).apply(mapa));
    }

    /**
     * Método para mover elemento para posição proporcional desejada
     * @param elemento - elemento a ser movido
     * @param proporcionalX - coordenada x da posição de destino em porcentagem da largura tela
     * @param proporcionalY - coordenada y da posição de destino em porcentagem da altura tela
     * @param duracao
     */
    protected void moverElemento(MobileElement elemento, int proporcionalX, int proporcionalY, int duracao){
        Point ponto = coordenadaProporcionalTela.apply(new Point(proporcionalX,proporcionalY));
        moverElemento(elemento,ponto,duracao);
    }

    /**
     * Método para mover elemento para posição proporcional desejada
     * @param elemento - elemento a ser movido
     * @param ponto - posição de destino
     * @param duracao - duração da ação em milisegundos
     */
    protected void moverElemento(MobileElement elemento, Point ponto, int duracao){
        acao
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(elemento))
                        .withDuration(Duration.ofMillis(duracao)))
                .waitAction()
                .moveTo(PointOption.point(ponto))
                .release()
                .perform();
    }

    /**
     * Método para deslocar elemento em direção desejada
     * @param elemento - Elemento a ser movido
     * @param deslocamentoProporcional - deslocamento desejado para o elemento
     * @param direcao - ACIMA, ABAIXO, DIREITA, ESQUERDA
     * @param duracao - duração da interação com o elemento
     */
    protected void moverElemento(MobileElement elemento, int deslocamentoProporcional, Direcao direcao, int duracao) {
        Rectangle retangulo = elemento.getRect();
        int maximo, minimo,pivo;
        switch(direcao) {
            case DIREITA:
                pivo = 100 * retangulo.getY()/ dimensaoTela.getHeight();
                minimo = 100 * (retangulo.x + retangulo.width/2) / dimensaoTela.getWidth();
                maximo = minimo + deslocamentoProporcional;
                break;
            case ESQUERDA:
                pivo = 100 * retangulo.getY()/ dimensaoTela.getHeight();
                maximo = 100 * (retangulo.x - retangulo.width/2) / dimensaoTela.getWidth();
                minimo = maximo - deslocamentoProporcional;
                break;
            case ACIMA:
                pivo = 100 * retangulo.getX()/ dimensaoTela.getWidth();
                minimo = 100 * (retangulo.y + retangulo.height/2) / dimensaoTela.getHeight();
                maximo = minimo + deslocamentoProporcional;
                break;
            case ABAIXO:
            default:
                pivo = 100 * retangulo.getX()/ dimensaoTela.getWidth();
                maximo = 100 * (retangulo.y - retangulo.height/2) / dimensaoTela.getHeight();
                minimo = maximo - deslocamentoProporcional;
        }
        moverTela(direcao,pivo, minimo, maximo, duracao);
    }

    /**
     * Método para pressionar elemento por tempo determinado
     * @param elemento - elemento a ser pressionado
     * @param duracao - duração da ação em milisegundos
     */
    protected void pressionar(MobileElement elemento, int duracao) {
        acao
                .longPress(LongPressOptions
                        .longPressOptions()
                        .withElement(ElementOption.element(elemento))
                        .withDuration(Duration.ofMillis(duracao)))
                .release()
                .perform();
    }

    /**
     * Método para pressionar posição da tela por tempo determinado
     * @param proporcionalX - posição do toque no eixo x em procentagem da largura da tela
     * @param proporcionalY - posição do toque no eixo y em porcentagem da largura da tela
     * @param duracao - duração da ação em milisegundos
     */
    protected void pressionar(int proporcionalX, int proporcionalY, int duracao) {
        Point ponto = coordenadaProporcionalTela.apply(new Point(proporcionalX, proporcionalY));
        acao
                .longPress(LongPressOptions
                        .longPressOptions().withPosition(PointOption.point(ponto))
                        .withDuration(Duration.ofMillis(duracao)))
                .release()
                .perform();
    }

    /**
     * Método utilizado para tocar um ponto determinado da tela
     * @param ponto
     */
    protected void tocar(Point ponto) {
        acao
                .tap(PointOption.point(ponto))
                .perform();
    }

    /**
     * Método utilizado para tocar um ponto determinado da tela
     * @param proporcionalX - posição do toque no eixo x em procentagem da largura da tela
     * @param proporcionalY - posição do toque no eixo y em porcentagem da largura da tela
     */
    protected void tocar(int proporcionalX, int proporcionalY) {
        tocar(coordenadaProporcionalTela.apply(new Point(proporcionalX, proporcionalY)));
    }

    /**
     * Método utilizado para tocar coordenadas de elemento
     * @param elemento
     */
    protected void tocar(MobileElement elemento) {
        tocar(elemento.getLocation());
    }

    /**
     * Método utilizado para tocar em coordenada dentro do retangulo do elemento
     * @param elemento - elemento a ser tocado
     * @param proporcionalX - posição do toque no eixo x em procentagem da largura do retângulo do elemento
     * @param proporcionalY - posição do toque no eixo y em procentagem da altura do retângulo do elemento
     */
    protected void tocar(MobileElement elemento, int proporcionalX, int proporcionalY) {
        Rectangle retangulo = elemento.getRect();
        Point origemElemento = new Point(retangulo.x, retangulo.y);
        tocar(origemElemento.moveBy(proporcionalX * retangulo.width / 100, proporcionalY * retangulo.height / 100));
    }

}
