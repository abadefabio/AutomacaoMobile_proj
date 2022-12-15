package funcionalidade.mobile.objetivos.aporte;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.objetivos.TermosCondicoesTela;
import pagina.mobile.jornadas.objetivos.aporte.AplicacaoForaPerfilTela;
import pagina.mobile.jornadas.objetivos.aporte.AplicacaoNoObjetivoTela;
import pagina.mobile.jornadas.objetivos.aporte.AplicacaoTela;
import pagina.mobile.jornadas.objetivos.aporte.AporteTela;
import pagina.mobile.jornadas.objetivos.comprovante.ComprovanteTela;
import pagina.mobile.jornadas.perfil.investidor.DescobrindoSeuPerfilTela;
import pagina.mobile.jornadas.perfil.investidor.SeuPerfilTela;
import pagina.mobile.comum.so.ModalCompartilhamentoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class RealizarAporteFunc extends FuncionalidadeBase {

    /**
     * Realiza um aporte de objetivo
     *
     * @throws Exception
     */
    public void realizarAporte(String valorAporte) throws Exception{
        new AporteTela(getDriver())
                .tocarBotaoOkEntendi();
        new AplicacaoTela(getDriver())
                .informarValorAplicacao(valorAporte)
                .tocarBotaoContinuar();
    }

    /**
     * Refaz o decobrimento de perfil via aporte
     *
     * @throws Exception
     */
    public void refazerPerfilViaAporte() throws Exception{
        new AplicacaoForaPerfilTela(getDriver())
                .validarPresencaTituloAplicacaoForaPerfil()
                .tocarBotaoRefazerOPerfil();
        new DescobrindoSeuPerfilTela(getDriver())
                .verificarTituloTela();
    }

    /**
     * Continuar a aplicação do aporte perfil Arrojado
     *
     * @throws Exception
     */
    public void continuarAplicacaoAportePerfilArrojado() throws Exception{
        new SeuPerfilTela(getDriver())
                .verificarTituloTela()
                .verificarPresencaTituloPerfilArrojado()
                .tocarBotaoContinuarAplicacao();
        new AplicacaoNoObjetivoTela(getDriver())
                .validarPresencaTituloAplicacaoNoObjetivo()
                .tocarBotaoConfirmar()
                .validarPresencaTituloAplicacaoNoObjetivo();
    }

    /**
     * Valida um aporte desenquadrado do perfil
     *
     * @throws Exception
     */
    public void validarAporteDesenquadradoPerfil() throws Exception{
        new AplicacaoForaPerfilTela(getDriver())
                .validarPresencaTituloAplicacaoForaPerfil()
                .tocarBotaoContinuar();
        new AplicacaoNoObjetivoTela(getDriver())
                .validarPresencaTituloAplicacaoNoObjetivo()
                .tocarBotaoLerTermosECondicoes();
        new TermosCondicoesTela(getDriver())
                .validarPresencaTituloTermosECondicoes()
                .validarPresencaBotaoTermoDeCienciaERisco()
                .tocarBotaoTermoDeCienciaERisco()
                .tocarBotaoFechar();
        new AplicacaoNoObjetivoTela(getDriver())
                .tocarCheckBoxLiTermosECondicoes()
                .tocarBotaoConfirmar()
                .validarPresencaTituloAplicacaoNoObjetivo();
    }

    /**
     * Validar o comprovante da aplicação no objetivo
     *
     * @throws Exception
     */
    public void validarComprovanteAplicacaoNoObjetivo() throws Exception{
        new AplicacaoNoObjetivoTela(getDriver())
            .tocarBotaoVerComprovante();
        new ComprovanteTela(getDriver())
                .validarPresencaTituloComprovante()
                .tocarBotaoCompartilhar();
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento()
                .fecharModalCompartilhamento();
        new ComprovanteTela(getDriver())
                .tocarBotaoVoltarComprovante();
        new AplicacaoNoObjetivoTela(getDriver())
                .tocarBotaoFechar();
        new ObjetivosTela(getDriver())
                .validarEstarTelaObjetivos()
                .tocarBotaoVoltar();
    }
}
