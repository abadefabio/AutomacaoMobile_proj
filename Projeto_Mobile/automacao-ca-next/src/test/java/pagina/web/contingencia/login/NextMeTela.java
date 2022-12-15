package pagina.web.contingencia.login;


import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class NextMeTela extends ContingenciaBaseTela {

    public NextMeTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Validar que a p�gina do Next.Me est� carregada na tela
     * utilizando como base a url no formato regex, por exemplo:
     * Para validar a p�gina 'https://www.next.me/inicio', pode-se usar o seguinte regex:
     * 'http*next.me*' como entrada para a valida��o
     * @param url
     * @throws Exception
     */
    public NextMeTela validarPagina(String url, String conteudo) throws Exception {
        aguardarCarregamentoElemento(retornarElemento(By.xpath("//html"), "P�gina n�o carregada."));
        aguardarPaginaConterTodosTextos(conteudo);
        validarCondicaoBooleana(getWebDriver().getCurrentUrl().matches(url),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar que se est� na p�gina do next.me");
        salvarEvidencia("Valida��o da presen�a da p�gina next.me");
        return this;
    }

}
