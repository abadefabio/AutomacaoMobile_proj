package funcionalidade.mobile.ajuda;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.atendimento.TipoArquivoEnum;
import pagina.mobile.jornadas.ajuda.AjudaTela;
import pagina.mobile.jornadas.atendimento.HistoricoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class TelaAjudaFunc extends FuncionalidadeBase {


    /** Visualizar arquivos enviados via chat (Imagem,PDF e Video)
     * @throws Exception
     */
    public void visualizarArquivosChat(String texto) throws Exception {

        new AjudaTela(getDriver())
                .tocarBotaoHistorico()
                .VerificarPresencaTextoPuxeParaVerMaisMensagens()
                .encontrarImagem()
                .tocarBotaoDownload()
                .tocarImagem()
                .tocarCampoForaArquivoVisualizado()
                .encontrarProximoArquivo(TipoArquivoEnum.VIDEO.toString())
                .tocarBotaoDownload()
                .tocarVideo()
                .tocarBotaoVoltar()
                .encontrarProximoArquivo(TipoArquivoEnum.PDF.toString())
                .tocarBotaoDownload()
                .tocarPDF()
                .validarMensagemAppAberturaPDF(texto);

    }

    /** Validar mensagem cliente sem histórico de chat
     * @return
     * @throws Exception
     */
    public void validarMensagemSemHistoricoChat() throws Exception {

        new AjudaTela(getDriver())
                .tocarBotaoHistorico();
        new HistoricoTela(getDriver())
                .validarPresencaHistoricoTela()
                .validarTextoSemHistoricoChat()
                .tocarBotaoVoltar();
    }
}
