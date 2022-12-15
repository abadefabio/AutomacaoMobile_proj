package constantes.frontend;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.tools.ReadProperties;

public interface GestaoOcorrenciasUrl {

    /**
     * URL informada no xml da execução
     */
    String URL_XML = TesteBase.getCasoTeste().getParametrosTeste().get("url");

    /**
     * URL a ser usada para acessar o Sistema de Gestão de Ocorrências
     * A URL selecionada é a que estiver no XML da execução, exceto se tiver sido informado "about:blank"
     * Se a URL_XML estiver sido informada "about:blank", então será utilizada uma URL diferente para cada ambiente (ti/tu)
     */
    String URL = !URL_XML.equalsIgnoreCase("about:blank") ? URL_XML :
            (ReadProperties.getAmbiente().equalsIgnoreCase("ti") ?
                    "https://telasnegocio.stf.ti.aznxt.local/tratamentoocorrencias/login" :
                    "https://telasnegocio.stf.tu.aznxt.local/tratamentoocorrencias/login");
}
