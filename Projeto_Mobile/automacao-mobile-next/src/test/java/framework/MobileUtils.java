package framework;

import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.testng.util.Strings;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaStringNumero;
import static br.com.next.automacao.core.tools.Utilitarios.reformatarValorMonetario;

public class MobileUtils {

    /**
     * Localizar texto passando texto parcial
     * @param texto
     * @return
     */
    public static String localizarTexto(String texto) throws NextException {

        try {
            String xpath = (getDriver() instanceof IOSDriver ? "//XCUIElementTypeStaticText" : "//android.widget.TextView");
            List<MobileElement> elementosTextos = getDriver().findElements(By.xpath(xpath));
            String textoLocalizado = "";
            for (MobileElement me : elementosTextos) {
                if (getDriver() instanceof IOSDriver) {
                    textoLocalizado = me.getAttribute("name");
                    if(Strings.isNullOrEmpty(textoLocalizado)) textoLocalizado = me.getAttribute("value");
                    if (normalizaString(textoLocalizado).contains(normalizaString(texto)))
                        return textoLocalizado;
                } else {
                    textoLocalizado = me.getText();
                    if(Strings.isNullOrEmpty(textoLocalizado)) textoLocalizado = me.getAttribute("text");
                    if (normalizaString(textoLocalizado).contains(normalizaString(texto)))
                        return textoLocalizado;
                }
            }
        }
        catch(Exception e){
            throw new NextException("Erro ao localizar o texto: " + texto, e);
        }
        return "";

    }

    /**
     * Arrastar Elemento Por Pixel
     * @param mobileElement
     * @param duracao
     * @param deslocamento
     * @param direcao
     */
    public static void arrastarElementoPorPixel(MobileElement mobileElement, long duracao,  int deslocamento, Direcao direcao) throws NextException {

        try {
            Rectangle retangulo = mobileElement.getRect();
            PointOption posicaoFim = null;
            int coordenadaX = retangulo.x + retangulo.width / 2;
            int coordenadaY = retangulo.y + retangulo.height / 2;
            PointOption posicaoInicio = PointOption.point(coordenadaX, coordenadaY);
            if (direcao.equals(Direcao.ACIMA))
                posicaoFim = PointOption.point(coordenadaX, coordenadaY - deslocamento);
            else if (direcao.equals(Direcao.ABAIXO))
                posicaoFim = PointOption.point(coordenadaX, coordenadaY + deslocamento);
            else if (direcao.equals(Direcao.DIREITA))
                posicaoFim = PointOption.point(coordenadaX - deslocamento, coordenadaY);
            else if (direcao.equals(Direcao.ESQUERDA))
                posicaoFim = PointOption.point(coordenadaX + deslocamento, coordenadaY);
            TouchAction perform = new TouchAction(getDriver())
                    .press(posicaoInicio)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duracao)))
                    .moveTo(posicaoFim)
                    .release()
                    .perform();
        } catch (NoSuchElementException nse) {
            throw new NextException(nse.getMessage(), nse);
        } catch (Exception e) {
            throw new NextException("Erro ao arrastar o elemento.", e);
        }

    }

    /**
     * Este método ira retornar uma data de dia não util.
     *
     * @return String
     */
    public static String retornaDataDiaNaoUtil(int diaAdicao, String formato) {
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(diaAdicao);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(5L));
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.TUESDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(4L));
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.WEDNESDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(3L));
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.THURSDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(2L));
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.FRIDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(1L));

        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * Este método ira retornar o próximo dia util a partir de uma data de dia não util.
     *
     * @return String
     */
    public static String retornaDataDiaUtilAPartirDeUmaDataDiaNaoUtil(int diasAdicao, String formato, String data) {
        LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ofPattern(formato)).plusDays(diasAdicao);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
        return localDate.getDayOfWeek().equals(DayOfWeek.SUNDAY) ? dateTimeFormatter.format(localDate.plusDays(1L)) : dateTimeFormatter.format(localDate);
    }

    /**
     * Retorna a data atual formatada
     *
     * @param formato Formato em que a data será exibida
     * @return Data atual formatada
     */
    public static String retornaDataAtualFormatada(String formato) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * Retorna uma data formatada
     *
     * @param data         Data a ser formatada
     * @param formatoAtual Formato atual da data
     * @param novoFormato  Formato novo da data
     * @return Data formatada
     * @throws ParseException
     */
    public static String retornaDataFomatada(String data, String formatoAtual, String novoFormato) throws ParseException {
        Date date = new SimpleDateFormat(formatoAtual).parse(data);
        return new SimpleDateFormat(novoFormato).format(date);
    }

    /**
     * Retorna um Map (chave e valor) com informações a serem validadas em tela
     *
     * @param campos  Campos da tela a ser validadas em tela
     * @param valores Valores da tela a ser validadas em tela
     * @return Retorna um map contendo campos e valores que serão validados em tela
     */
    public static Map<String, String> preencheInformacoesParaValidacao(String[] campos, String... valores) {
        Map<String, String> informacoes = new HashMap<>();
        for(int i = 0; i < campos.length; i++) {
            informacoes.put(campos[i], valores[i]);
        }
        return informacoes;
    }

    /**
     * Retorna a somatória dos valores monetários
     *
     * @param valores Valores a serem somados
     * @return Retorna uma string com a somatória dos valores monetários
     */
    public static String retornaSomaValoresMonetarios(String... valores) {
        BigDecimal total = new BigDecimal(0);
        for (String valor : valores) {
            total = total.add(new BigDecimal(normalizaStringNumero(valor)));
        }
        return reformatarValorMonetario(total.toString());
    }

    /**
     * Retorna a subtração dos valores monetários
     *
     * @param valores Valores a serem subtraídos (do maior para o menor)
     * @return Retorna uma string com a subtração dos valores monetários
     */
    public static String retornaSubtracaoValoresMonetarios(String... valores) {
        BigDecimal total = new BigDecimal(0);
        for (String valor : valores) {
            total = total.intValue() != 0 ?
                    total.subtract(new BigDecimal(normalizaStringNumero(valor))) :
                    new BigDecimal(normalizaStringNumero(valor));
        }
        return total.intValue() != 0 ?
                reformatarValorMonetario(total.toString()) :
                new StringBuilder(reformatarValorMonetario(total.toString())).insert(0, "0").toString();
    }
}
