package br.com.next.automacao.core.drivers.web.fabrica;

import br.com.next.automacao.core.drivers.NextFabricaDrivers;
import br.com.next.automacao.core.drivers.web.managers.*;
import br.com.next.automacao.core.exception.SecaoNextException;
import br.com.next.automacao.core.exception.NextException;

import java.net.MalformedURLException;

/**
 * O Next Fabrica Web Driver é responsável por orquestrar a criação de múltiplos drivers:
 * chrome, ie, edge, firefox, safari
 *
 * @author Matheus Lima Barbosa de Tulio
 * @version 5.2.1
 * @since 2021-05
 */
public interface NextFabricaWebDriver extends NextFabricaDrivers {

    /**
     * @param navegadorWeb
     * @param url
     * @return NextWebDriver
     * @throws MalformedURLException
     * @throws NextException
     */
    static NextWebDriver retornaDriverWeb(String navegadorWeb, String url) throws Exception {
        switch (navegadorWeb.toLowerCase()) {
            case "chrome":
                return new NextChromeDriver().criarDriver(url);
            case "firefox":
                return new NextFirefoxDriver().criarDriver(url);
            case "ie":
                return new NextIeDriver().criarDriver(url);
            case "edge":
                return new NextEdgeDriver().criarDriver(url);
            case "safari":
                return new NextSafariDriver().criarDriver(url);
            default:
                String mensagemErro = "Não foi possível iniciar o navegador \"" + navegadorWeb + "\"\n" +
                        "Tente um dos seguintes navegadores: \"chrome\", \"firefox\", \"ie\", \"edge\", \"safari\"";
                throw new SecaoNextException(mensagemErro);
        }
    }
}
