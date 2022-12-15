package teste.web.regressivo.termoseCondicoes;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.ReadProperties;
import funcionalidade.web.sistemadegestao.login.SistemaDeGestaoLoginFunc;
import funcionalidade.web.sistemadegestao.mimos.menu.SistemaDeGestaoMenuMimosFunc;
import funcionalidade.web.sistemadegestao.termoCondicoes.TermosECondicoesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.VISAO_GERAL)
public class QA07128 extends TesteBase {

    private SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    private SistemaDeGestaoMenuMimosFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuMimosFunc();
    private TermosECondicoesFunc termosECondicoes = new TermosECondicoesFunc();

    @Test(description = "REG.SIS.14.03.04 - Validar informações do detalhes do termo selecionado no Sistema de Gestão")
    @Description("Validar fluxo para consulta e visualização de termos")

    @Severity(SeverityLevel.NORMAL)
    public void QA07128() throws Exception{

        loginSistemaDeGestao.realizarLogin(ReadProperties.getGestaoUser(),ReadProperties.getGestaoPass(), ReadProperties.getAmbiente());

        menuMimosSistemaDeGestao.clicarLinkTermosECondicoes();

        termosECondicoes.clicarLinkParceiros(recuperarMassa("tipoDocumento"),recuperarMassa("tituloPagina"),recuperarMassa("campoTermo"),recuperarMassa("campoTextoPrivew") );


    }
}
