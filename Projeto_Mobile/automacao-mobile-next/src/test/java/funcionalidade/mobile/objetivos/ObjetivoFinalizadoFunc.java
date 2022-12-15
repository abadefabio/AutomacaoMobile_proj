package funcionalidade.mobile.objetivos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.comprovantes.ComprovantesExtratoTela;
import pagina.mobile.jornadas.comprovantes.objetivos.ComprovanteObjetivosTela;
import pagina.mobile.jornadas.comprovantes.objetivos.ObjetivosFinalizadosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ObjetivoFinalizadoFunc extends FuncionalidadeBase {


    /** Enviar  para o email o comprovante validando texto de sucesso da tela
     * @throws Exception
     */
    public void enviarEmailComprovanteObjetivoFinalizado() throws Exception {
        new ComprovanteObjetivosTela(getDriver())
                .tocarBotaoObjetivosFinalizados();
        new ObjetivosFinalizadosTela(getDriver())
                .tocarBotaoSelecionarObjetivo()
                .tocarbotaoObjetivoSelecao()
                .tocarbotaoConfirmar()
                .selecionarPeriodo()
                .tocarbotaoConfirmar()
                .tocarBotaoVisualizar()
                .tocarBotaoEnviar()
                .validarEnvioEmailComprovante();
    }

        /** Objetivo em andamento - Validar o recebimento do extrato da
         ultima aplicação
         * @throws Exception
         */
        public void validarObetivosEmAndamento() throws Exception {
            new ComprovanteObjetivosTela(getDriver())
                    .tocarPrimeiraOpcaoObjetivosEmAndamentoLista();

            new ObjetivosFinalizadosTela(getDriver())
                    .selecionarPeriodo()
                    .tocarbotaoConfirmar()
                    .tocarBotaoVisualizar()
                    .tocarBotaoEnviar();

            new ComprovanteObjetivosTela(getDriver())
                    .tocarBotaoOk()
                    .validarComprovantesEExtrato();
        }
}
