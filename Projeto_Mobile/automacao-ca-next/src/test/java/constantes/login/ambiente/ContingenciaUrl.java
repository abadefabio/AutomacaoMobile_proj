package constantes.login.ambiente;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.tools.ReadProperties;

public interface ContingenciaUrl {
    String URL_XML = TesteBase.getCasoTeste().getParametrosTeste().get("url");

    String URL = !URL_XML.equalsIgnoreCase("about:blank") ? URL_XML :
            (ReadProperties.getAmbiente().equalsIgnoreCase("ti") ?
                    "https://contingency.ti.aznxt.local/login/" :
                    "https://contingency.tu.aznxt.local/login/");
}
