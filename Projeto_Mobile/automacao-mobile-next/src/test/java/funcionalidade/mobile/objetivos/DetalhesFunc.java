package funcionalidade.mobile.objetivos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.objetivos.MensagensObjetivos;
import io.appium.java_client.ios.IOSDriver;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.jornadas.objetivos.AplicacaoNoObjetivoTela;
import pagina.mobile.jornadas.objetivos.DetalhesTela;
import pagina.mobile.jornadas.objetivos.DiaAplicacaoParcelasTela;
import pagina.mobile.jornadas.objetivos.EditarAgendamentoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;
import static br.com.next.automacao.core.tools.Utilitarios.retornaDataDiaUtil;

public class DetalhesFunc extends FuncionalidadeBase {

    /**
     * Editar no card Parcelas mensais o valor da parcela e dia da aplicação
     * @throws Exception
     */
    public void editarDiaValorCardParcelasMensais() throws Exception {

        String valorParcela = String.valueOf(numeroAleatorio(100000,200000));
        String diaAplicacao = String.valueOf(numeroAleatorio(1,31));
        new DetalhesTela(getDriver())
                .tocarBotaoDetalhes()
                .tocarBotaoEditar()
                .editarValorDaParcela(valorParcela)
                .selecionarDiaDaAplicacao();
        new DiaAplicacaoParcelasTela(getDriver())
                .validaExibicaoDiaDeAplicacaoDasParcelasTela()
                .selecionarDia(diaAplicacao);
        if(getDriver() instanceof IOSDriver)
            new DiaAplicacaoParcelasTela(getDriver()).tocarBotaoHeaderConfirmar();
        new DetalhesTela(getDriver())
                .tocarBotaoSalvar()
                .validarValorDaParcela(valorParcela)
                .validarDiaDaAplicacao(diaAplicacao);

    }
    /**
     * Editar Valor e Data da Aplicação
     * @throws Exception
     */
    public void editarValorEDataDaAplicacao() throws Exception {
        String valorDaAplicacao = String.valueOf(numeroAleatorio(100000,200000));
        String dataDoAgendamento  = retornaDataDiaUtil(1,"dd/MM/yyyy");
        new DetalhesTela(getDriver())
                .tocarBotaoDetalhes()
                .tocarlapisAportesAgendados()
                .editarValorDaAplicacao(valorDaAplicacao)
                .tocarDataDaAplicacao();
        new CalendarioTela(getDriver())
                .selecionarData(false, proximoDiaUtil())
                .tocarBotaoConfirmar();
        new DetalhesTela(getDriver())
                .tocarBotaoContinuar();
        new EditarAgendamentoTela(getDriver())
                .validarTituloEditarAgendamento()
                .tocarBotaoConfirmarEdicao();
        new AplicacaoNoObjetivoTela(getDriver())
                .validarTituloAplicacaoNoObjetivo()
                .tocarBotaoVerObjetivo();
        new DetalhesTela(getDriver())
                .validarExibicaoDetalhesTela()
                .tocarBotaoDetalhes()
                .validarAportesAgendadosDataAgendamento(dataDoAgendamento)
                .validarAportesAgendadosValorAgendado(valorDaAplicacao);
    }

    /**
     * Editar Valor da Aplicação
     * @throws Exception
     */
    public void editarValorAplicacao() throws Exception {
        String valorDaAplicacao = String.valueOf(numeroAleatorio(1,40));
        new DetalhesTela(getDriver())
                .tocarBotaoDetalhes()
                .tocarlapisAportesAgendados()
                .editarValorDaAplicacao(valorDaAplicacao);
        new DetalhesTela(getDriver())
                .validarPresencaMensagemAplicacaoMinimaCinquentaReais();
    }
}
