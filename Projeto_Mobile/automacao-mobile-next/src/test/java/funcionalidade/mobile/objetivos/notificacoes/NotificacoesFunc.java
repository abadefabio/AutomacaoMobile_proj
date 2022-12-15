package funcionalidade.mobile.objetivos.notificacoes;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.atendimento.ChatTela;
import pagina.mobile.jornadas.objetivos.AtualizacaoCadastralTela;
import pagina.mobile.jornadas.objetivos.notificacoes.NotificacoesTela;

public class NotificacoesFunc extends FuncionalidadeBase {

    /**
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarDadosCadastraisContinuandoNoChat(String mensagem) throws Exception {
        new NotificacoesTela(getDriver())
                .validarTelaNotificacao()
                .tocarBotaoVerMais();
        AtualizacaoCadastralTela atualizacaoCadastralTela = new AtualizacaoCadastralTela(getDriver());
        if(!atualizacaoCadastralTela
                .verificarTituloAtualizacaoCadastral()
                .tocarBotaoAtualizarMeusDados()
                .isApresentouTela()){
            new PopUpTela(getDriver())
                     .validarMensagem(mensagem)
                     .tocarBotaoPopUpContinuarNoChat();
        }
        new ChatTela(getDriver())
                .validarTelaChat();
    }
}
