package funcionalidade.mobile.configuracoes.perfil.termosCondicoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes.DebitoAutomaticoTela;
import pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes.TermosCondicoesTela;
import pagina.mobile.jornadas.login.LoginTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TermosCondicoesFunc extends FuncionalidadeBase {

    /**
     * Tocar bot�o d�bito autom�tico e validar termo de ades�o
     *
     * @throws Exception
     */
    public void validarTermoAdesao() throws Exception {
        new TermosCondicoesTela(getDriver())
                .tocarDebitoAutomatico()
                .tocarTermoAdesao();
        new DebitoAutomaticoTela(getDriver())
                .validarTituloTela()
                .validarBotaoEnviarEmail()
                .tocarBotaoVoltar();
        new TermosCondicoesTela(getDriver())
                .validarTelaTermosCondicoes();
    }

    /**
     * Tocar bot�o Pix e validar termo e condi��es Next PIX
     *
     * @throws Exception
     */
    public void validarTermosCondicoesNextPix() throws Exception {
        new TermosCondicoesTela(getDriver())
                .tocarbotaoPix()
                .tocarTermoAdesaoNextPix();
        new TermosCondicoesTela(getDriver())
                .validarTelaTermosCondicoesPix();
        new LoginTela(getDriver())
                .tocarBotaoVoltar();
    }
}
