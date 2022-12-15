package funcionalidade.mobile.configuracoes.perfil.termosCondicoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes.DebitoAutomaticoTela;
import pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes.TermosCondicoesTela;
import pagina.mobile.jornadas.login.LoginTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TermosCondicoesFunc extends FuncionalidadeBase {

    /**
     * Tocar botão débito automático e validar termo de adesão
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
     * Tocar botão Pix e validar termo e condições Next PIX
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
