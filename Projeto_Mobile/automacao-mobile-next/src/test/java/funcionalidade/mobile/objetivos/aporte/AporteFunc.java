package funcionalidade.mobile.objetivos.aporte;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.jornadas.objetivos.ObjetivosTela;
import pagina.mobile.jornadas.objetivos.aporte.AplicacaoNoObjetivoTela;
import pagina.mobile.jornadas.objetivos.aporte.AporteTela;
import pagina.mobile.jornadas.objetivos.comprovante.ComprovanteTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AporteFunc extends FuncionalidadeBase {

    public void aplicarAporteNoObjetivo(String valor)throws Exception{
        new AporteTela(getDriver())
                .validarPresencaTituloDaTela()
                .tocarBotaoOkEntendi();
        new AplicacaoNoObjetivoTela(getDriver())
                .preencherValorDoObjetivo(valor)
                .tocarNoBotaoContinuarAposPreencherValorDaAplicacao()
                .validarValorAplicadoNoObjetivo(valor)
                .tocarBotaoConfimarValorAplicadoNoObjetivo()
                .tocarBotaoVerComprovanteDaAplicacaoNoObjetivo();
        new ComprovanteTela(getDriver())
                .validarPresencaTituloComprovante()
                .tocarBotaoVoltarComprovante();
        new AplicacaoNoObjetivoTela(getDriver())
                .validarTituloDaTelaAplicacaoNoObjetivo()
                .validarValorAplicadoAposCliqueBotaoVoltarTelaComprovante(valor);

    }

    /**
     * Verificar se esta na tela inicial e voltar para o menu se for o caso
     * @throws NextException
     */
    public void verificarVoltarTelaMenuInicial() throws Exception{
        new AplicacaoNoObjetivoTela(getDriver())
                .verificarEtocarBotaoFechar();
        new ObjetivosTela(getDriver())
                .tocarBotaoVoltar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }



}
