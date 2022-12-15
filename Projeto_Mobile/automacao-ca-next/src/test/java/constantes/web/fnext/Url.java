package constantes.web.fnext;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.tools.ReadProperties;

public interface Url {

    String URL_XML = TesteBase.getCasoTeste().getParametrosTeste().get("url");

    String FNEXT_URL = !URL_XML.equalsIgnoreCase("about:blank") ? URL_XML :
                                        (ReadProperties.getAmbiente().equalsIgnoreCase("ti") ?
                                                "https://staff.stf.ti.aznxt.local/fnext/#/" :
                                                "https://staff.stf.tu.aznxt.local/fnext/#/");
}
