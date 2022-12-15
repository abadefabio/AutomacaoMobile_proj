package funcionalidade.mobile.notificacoes;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import pagina.mobile.jornadas.notificacoes.NotificacoesTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class NotificacoesFunc  extends FuncionalidadeBase {

    /**
     * Validar No Card a Mensagem De Notificacao
     * @param mensagem
     * @throws Exception
     */
    public void validarNoCardMensagemDeNotificacao(String mensagem) throws Exception {
        new NotificacoesTela(getDriver())
                .validarPresencaNotificacoesTela()
                .validarTextoDoCard(mensagem);
    }

    /**
     * Acessar Funcionalidade Via Botao: 'Ver Mais'
     * OBS: A Funcionalidade pode variar dependendo do contexto do teste.
     * @throws NextException
     */
    public void acessarFuncionalidadeViaBotaoVerMais() throws NextException {
        new NotificacoesTela(getDriver())
                .tocarBotaoVerMais();
    }

}
