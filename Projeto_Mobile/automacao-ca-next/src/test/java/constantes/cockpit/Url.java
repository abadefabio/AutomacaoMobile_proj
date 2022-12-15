package constantes.cockpit;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.tools.ReadProperties;

public interface Url {

    String URL_XML = TesteBase.getCasoTeste().getParametrosTeste().get("url");

    String TELA_MOLDURA = !URL_XML.equalsIgnoreCase("about:blank") ? URL_XML :
            (ReadProperties.getAmbiente().equalsIgnoreCase("ti") ?
                    "https://telasnegocio.stf.ti.aznxt.local/telasdenegocio/moldura.html" :
                    "https://telasnegocio.stf.tu.aznxt.local/telasdenegocio/moldura.html");

}
