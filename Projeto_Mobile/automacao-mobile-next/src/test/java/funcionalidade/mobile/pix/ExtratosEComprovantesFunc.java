package funcionalidade.mobile.pix;

import constantes.pix.ExtratoEComprovante;
import pagina.mobile.comum.next.CarregamentoTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.extratos.e.comprovantes.ExtratosEComprovantesTela;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ExtratosEComprovantesFunc {

    /**
     * Validar Reduçãoo de Limite Empresa com Limite Utilizado
     *
     * @throws Exception
     */
    public void validarDetalhesTransacaoRecebidaEEnviadaPix() throws Exception{
        new PixTela(getDriver())
                .tocarBotaoExtratosEComprovantes();
        new ExtratosEComprovantesTela(getDriver())
                .selecionarPeriodoDoExtrato(ExtratoEComprovante.SETE_DIAS.toString());
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ExtratosEComprovantesTela(getDriver())
                .selecionarTransacaoRecebidaPix()
                .validarDetalhesDaTransacao()
                .tocarBotaoVoltarAoPix();
        new PixTela(getDriver())
                .tocarBotaoExtratosEComprovantes();
        new ExtratosEComprovantesTela(getDriver())
                .selecionarPeriodoDoExtrato(ExtratoEComprovante.SETE_DIAS.toString());
        new CarregamentoTela(getDriver())
                .aguardarCarregamentoTela();
        new ExtratosEComprovantesTela(getDriver())
                .selecionarTransacaoEnviadaPix()
                .validarDetalhesDaTransacao()
                .tocarBotaoVerComprovante()
                .validarComprovanteTransacaoEnviadaPix();
    }
}
