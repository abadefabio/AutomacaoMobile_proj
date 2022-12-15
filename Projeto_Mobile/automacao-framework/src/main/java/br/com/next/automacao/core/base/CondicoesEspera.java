package br.com.next.automacao.core.base;

import br.com.next.automacao.core.constantes.Normaliza;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaStringNumero;

/**
 * Classe criada para encapsular e expandir o uso da interface ExpectedCondition para o uso de
 * Explicity Wait nos projetos de automação do NEXT
 *
 * @author Matheus Lima Barbosa de Tulio
 * @Since 11-2021
 * @version 4.0.2
 */
public class CondicoesEspera {

    /**
     * Método para esperar a existência de um elemento em tela
     * @param elemento
     * @return Elemento encontrado na tela
     */
    public static <T> ExpectedCondition<WebElement> esperaElementoExistente(T elemento){
        return elemento instanceof WebElement ? driver -> {
            try{
                String elementoExibido;
                elementoExibido = String.valueOf (((WebElement)elemento).isDisplayed());
                if(elementoExibido != null){
                    return (WebElement) elemento;
                }
            }catch(Exception ignore){ }
            return null;
        } : ExpectedConditions.presenceOfElementLocated((By) elemento);
    }

    /**
     * Método aguarda elemento existir e estar visível em tela
     * @param localizador
     * @return elemento encontrado
     */
    public static <T> ExpectedCondition<WebElement> esperarElementoVisivel(T localizador){
        return driver -> {
            WebElement elemento = localizador instanceof WebElement ?
                    (WebElement) localizador :
                    driver.findElement((By) localizador);
            if (elemento.isDisplayed()) {
                return elemento;
            } else {
                Dimension dimension = driver.manage().window().getSize();
                int altura = dimension.height;
                int largura = dimension.width;
                int centroX = elemento.getLocation().x;
                int centroY = elemento.getLocation().y;
                if (centroX > 0 && centroY > 0 && centroX < largura && centroY < altura) {
                    return elemento;
                }
                return null;
            }
        };
    }

    /**
     * Método aguarda elemento estar habilitado para clique em tela
     * @param localizador
     * @return elemento encontrado
     */
    public static <T> ExpectedCondition<WebElement> esperarElementoClicavel(T localizador){
        return localizador instanceof WebElement ? ExpectedConditions.elementToBeClickable((WebElement) localizador) :
                ExpectedConditions.elementToBeClickable((By) localizador);
    }

    /**
     * Método aguarda a condição de visibilidade do elemento ser falsa
     * @param localizador
     * @return true se elemento não está mais visível, false se o elemento ainda está visível
     */
    public static <T> ExpectedCondition<Boolean> esperarElementoOcultar(T localizador){
        return ExpectedConditions.not(esperarElementoVisivel(localizador));
    }

    /**
     * Mátodo aguarda o driver retornar objeto string com a fonte da página
     * @param driver
     * @return string com o fonte da página
     */
    public static ExpectedCondition<String> esperarFontePagina(WebDriver driver){
        return input -> {
            try{
                return driver.getPageSource();
            }catch (Exception ignore){
            }
            return null;
        };
    }

    /**
     * Método aguarda até a fonte da página não apresentar mais um texto específico
     * @param driver
     * @return true - texto não encontrado mais na página, false - texto ainda encontrado na página
     */
    public static ExpectedCondition<Boolean> esperarPaginaOcultar(WebDriver driver, Normaliza normaliza, String texto){
        return input -> {
            try{
                String pagina = driver.getPageSource();
                switch (normaliza) {
                    case String:
                        pagina = normalizaString(pagina);
                        break;
                    case Numeros:
                        pagina = normalizaStringNumero(pagina);
                }
                if (normaliza.equals(Normaliza.String))
                    return !normalizaString(pagina).contains(normalizaString(texto));
                if (normaliza.equals(Normaliza.Numeros))
                    return !normalizaStringNumero(pagina).contains(normalizaStringNumero(texto));
                return !(driver.getPageSource()).toLowerCase().contains(texto.toLowerCase());
            }catch (Exception ignore){
            }
            return false;
        };
    }

    /**
     * Método aguarda o fonte da página conter qualquer um dos textos informados
     * @param driver
     * @param textos
     * @return
     */
    public static ExpectedCondition<String> esperarPaginaConterQualquerTexto(WebDriver driver, Normaliza normaliza, String... textos){
        return input -> {
            String elementoEncontrado = null;
            try{
                String pagina = driver.getPageSource().toLowerCase();
                switch (normaliza) {
                    case String:
                        pagina = normalizaString(pagina);
                        break;
                    case Numeros:
                        pagina = normalizaStringNumero(pagina);
                }
                for(String texto : textos){
                    if (normaliza.equals(Normaliza.String)) texto = normalizaString(texto);
                    if (normaliza.equals(Normaliza.Numeros)) texto = normalizaStringNumero(texto);
                    if(pagina.toLowerCase().contains(texto.toLowerCase())) {
                        elementoEncontrado = texto;
                        break;
                    }
                }
            }catch (Exception ignore){
            }
            return elementoEncontrado;
        };
    }

    /**
     * Método aguarda o fonte da página conter todos um dos textos informados
     * @param driver
     * @param textos
     * @return
     */
    public static ExpectedCondition<Boolean> esperarPaginaConterTodosTextos(WebDriver driver, Normaliza normaliza, String... textos){
        return input -> {
            List listaTextosEncontrados = new ArrayList();
            try{
                String pagina = driver.getPageSource().toUpperCase();
                switch (normaliza) {
                    case String:
                        pagina = normalizaString(pagina);
                        break;
                    case Numeros:
                        pagina = normalizaStringNumero(pagina);
                }
                for(String texto : textos){
                    if (normaliza.equals(Normaliza.String)) texto = normalizaString(texto);
                    if (normaliza.equals(Normaliza.Numeros)) texto = normalizaStringNumero(texto);
                    if(pagina.contains(texto.toUpperCase())) {
                         listaTextosEncontrados.add(texto.toUpperCase());
                    }
                }
            }catch (Exception ignore){
            }
            return listaTextosEncontrados.size() == textos.length;
        };
    }

}
