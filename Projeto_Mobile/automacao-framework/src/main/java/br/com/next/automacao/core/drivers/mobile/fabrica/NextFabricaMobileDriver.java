package br.com.next.automacao.core.drivers.mobile.fabrica;

import br.com.next.automacao.core.drivers.ControladoraDriver;
import br.com.next.automacao.core.drivers.NextFabricaDrivers;
import br.com.next.automacao.core.drivers.mobile.managers.NextAndroidDriver;
import br.com.next.automacao.core.drivers.mobile.managers.NextIosDriver;
import br.com.next.automacao.core.drivers.mobile.managers.NextMobileDriver;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.exception.SecaoNextException;

import java.net.MalformedURLException;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;

/**
 * O Next Fabrica Mobile Driver é responsável por orquestrar a criação de múltiplos drivers,
 * tanto para Android quanto para iOS. Aqui são setadas as capabilities via parametrização,
 * estas provenientes do arquivo XML de suíte de testes
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2019-11
 */
public interface NextFabricaMobileDriver extends NextFabricaDrivers {

    /**
     * @return NextMobileDriver
     * @throws MalformedURLException
     * @throws NextException
     */
    static NextMobileDriver retornaDriverMobile() throws Exception {
        String url = ControladoraDriver.obterUrlAppiumServerCorrigida().toString();
        String plataformaMobile = getCasoTeste().getParametrosTeste().getOrDefault("plataforma", "PLATAFORMA_INDEFINIDA");
        switch (plataformaMobile.toLowerCase()) {
            case "ios":
                return new NextIosDriver().criarDriver(url);
            case "android":
                return new NextAndroidDriver().criarDriver(url);
            default:
                throw new SecaoNextException( "Não foi possível iniciar a plataforma \"" + plataformaMobile + "\"\n" +
                        "Tente uma das seguintes plataformas: \"ios\", \"android\"." +
                        " Se você estiver tentando executar um teste WEB, o parâmetro correto no XML é \"navegador\".");
        }
    }

}
