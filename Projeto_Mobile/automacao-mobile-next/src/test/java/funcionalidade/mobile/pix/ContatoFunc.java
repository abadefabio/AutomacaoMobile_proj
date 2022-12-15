package funcionalidade.mobile.pix;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.pix.Mensagens;
import constantes.pix.TipoConta;
import constantes.pix.ValorPix;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.contato.ContatoTela;
import pagina.mobile.jornadas.pix.contato.DetalhesContatoTela;
import pagina.mobile.jornadas.pix.copia.cola.ComprovanteTela;
import pagina.mobile.jornadas.pix.copia.cola.SucessoTela;
import pagina.mobile.jornadas.pix.transferir.ConfirmeOsDadosTela;
import pagina.mobile.jornadas.pix.transferir.InserirValorTela;
import pagina.mobile.jornadas.pix.transferir.OrigemPagamentoTela;

public class ContatoFunc extends FuncionalidadeBase {

    public void transferirContatoPix(String nomeContato, String chave, TipoConta origemPagamento)
            throws Exception {
        String valor = ValorPix.ALEATORIO_MINIMO.getValue();

        new ContatoTela(getDriver())
                .selecionarContato(nomeContato);
        new DetalhesContatoTela(getDriver())
                .selecionarChaveContato(chave)
                .tocarBotaoContinuar();
        new OrigemPagamentoTela(getDriver())
                .selecionarOrigemPagamento(origemPagamento);
        new InserirValorTela(getDriver())
                .preencherCampoValor(valor)
                .tocarBotaoAvancar();
        new ConfirmeOsDadosTela(getDriver())
                .tocarBotaoRealizarTransacao();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Mensagens.TRANSACAO_PIX_REALIZADA_COM_SUCESSO);
        new SucessoTela(getDriver())
                .tocarBotaoVerComprovante();
        new ComprovanteTela(getDriver())
                .validarPresencaTituloComprovante()
                .tocarBotaoVoltarAoPix();
        new PixTela(getDriver())
                .validarTelaPix();
    }
}
