package funcionalidade.mobile.investimentos.notificacoes;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.investimentos.Mensagem;
import constantes.investimentos.TituloTela;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.atendimento.ChatTela;
import pagina.mobile.jornadas.investimentos.TermosECondicoesTela;
import pagina.mobile.jornadas.investimentos.aplicacao.AplicacaoForaPerfilTela;
import pagina.mobile.jornadas.investimentos.notificacoes.NotificacoesTela;
import pagina.mobile.jornadas.menu.MenuTela;
import pagina.mobile.comum.next.PopUpTela;

public class NotificacoesFunc extends FuncionalidadeBase {

    /**
     * Acessar e validar Notificação de perfil vencido
     *
     * @throws Exception
     */
    public void acessarValidarNotificacaoPerfilVencido() throws Exception {
        new NotificacoesTela(getDriver())
                .validarExibicaoTelaNotificacoes()
                .validarNotificacaoInvestimentosPerfilVencido()
                .tocarBotaoVerMais();
    }

    /**
     * Validar notificacao de investimento agendado com desenquadramento de perfil
     * Produto fundos ou renda fixa
     *
     * @throws  Exception
     */
    public void validarNotificacaoInvestimentoAgendadoDesenquadramentoPerfil() throws Exception{
        new NotificacoesTela(getDriver())
                .validarExibicaoTelaNotificacoes()
                .validarTextoInvestimentoAgendadoForaDoPerfil()
                .tocarBotaoVerMaisInvestimentoForaDoPerfil();
        new PopUpTela(getDriver())
                .validarMensagem(TituloTela.APLICACAO_FORA_DO_PERFIL.toString());
        new AplicacaoForaPerfilTela(getDriver())
                .tocarBotaoContinuar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TituloTela.TERMOS_DE_CONTRATO.toString());
        new TermosECondicoesTela(getDriver())
                .tocarCheckboxLiAceitoTermosCondicao()
                .tocarBotaoAceitar();
        new PopUpTela(getDriver())
                .validarMensagem(Mensagem.TUDO_CERTO_SUA_APLICACAO_FOI_FEITA)
                .tocarBotaoOk();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }

    /**
     * Acessar e validar Notificação atualizacao cadastral
     *
     * @throws Exception
     */
    public void acessarValidarNotificacaoAtualizacaoCadastral() throws Exception {
        new NotificacoesTela(getDriver())
                .validarExibicaoTelaNotificacoes()
                .validarTextoInvestimentoAtualizacaoCadastral()
                .tocarBotaoVerMais()
                .validarNotificacaoAtualizacaoCadastral()
                .tocarBotaoAtualizarMeusDados();
        if (getDriver() instanceof AndroidDriver){
            new ChatTela(getDriver())
                    .tocarIniciarChat();
        }
        new ChatTela(getDriver())
                .tocarBotaoVerHistoricoSeExistir()
                .validarTelaChat();
    }
}
