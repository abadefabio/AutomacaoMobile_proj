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
     * Validar que a página do Next.Me está carregada na tela
     * utilizando como base a url no formato regex, por exemplo:
     * Para validar a página 'https://www.next.me/inicio', pode-se usar o seguinte regex:
     * 'http*next.me*' como entrada para a validação
     * @param url
     * @throws Exception
     */
    public NextMeTela validarPagina(String url, String conteudo) throws Exception {
        aguardarCarregamentoElemento(retornarElemento(By.xpath("//html"), "Página não carregada."));
        aguardarPaginaConterTodosTextos(conteudo);
        validarCondicaoBooleana(getWebDriver().getCurrentUrl().matches(url),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar que se está na página do next.me");
        salvarEvidencia("Validação da presença da página next.me");
        return this;
    }

}
