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
 * Explicity Wait nos projetos de automa��o do NEXT
 *
 * @author Matheus Lima Barbosa de Tulio
 * @Since 11-2021
 * @version 4.0.2
 */
public class CondicoesEspera {

    /**
     * M�todo para esperar a exist�ncia de um elemento em tela
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
     * M�todo aguarda elemento existir e estar vis�vel em tela
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
     * M�todo aguarda elemento estar habilitado para clique em tela
     * @param localizador
     * @return elemento encontrado
     */
    public static <T> ExpectedCondition<WebElement> esperarElementoClicavel(T localizador){
        return localizador instanceof WebElement ? ExpectedConditions.elementToBeClickable((WebElement) localizador) :
                ExpectedConditions.elementToBeClickable((By) localizador);
    }

    /**
     * M�todo aguarda a condi��o de visibilidade do elemento ser falsa
     * @param localizador
     * @return true se elemento n�o est� mais vis�vel, false se o elemento ainda est� vis�vel
     */
    public static <T> ExpectedCondition<Boolean> esperarElementoOcultar(T localizador){
        return ExpectedConditions.not(esperarElementoVisivel(localizador));
    }

    /**
     * M�todo aguarda o driver retornar objeto string com a fonte da p�gina
     * @param driver
     * @return string com o fonte da p�gina
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
     * M�todo aguarda at� a fonte da p�gina n�o apresentar mais um texto espec�fico
     * @param driver
     * @return true - texto n�o encontrado mais na p�gina, false - texto ainda encontrado na p�gina
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
     * M�todo aguarda o fonte da p�gina conter qualquer um dos textos informados
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
     * M�todo aguarda o fonte da p�gina conter todos um dos textos informados
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
