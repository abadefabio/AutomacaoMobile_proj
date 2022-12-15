package funcionalidade.mobile.atendimento;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.atendimento.TipoAcesso;
import pagina.mobile.jornadas.atendimento.AjudaNextTela;
import pagina.mobile.jornadas.atendimento.ChatTela;
import pagina.mobile.jornadas.atendimento.SelecaoDeContaTela;
import pagina.mobile.jornadas.menu.MenuTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AtendimentoFunc extends FuncionalidadeBase {

    /**
     * Acessar o Chat no Menu Ajuda
     */
    public void acessarChatNoMenuAjuda(TipoAcesso tipoAcesso, String dependente) throws Exception {
        switch (tipoAcesso) {
            case SEM_DEPENDENTE:
                new MenuTela(getDriver())
                        .tocarBotaoAjuda();
                new AjudaNextTela(getDriver())
                        .tocarBotaoIniciarChat();
                new ChatTela(getDriver())
                        .validarTelaChat();
                break;
            case COM_DEPENDENTE:
                new MenuTela(getDriver())
                        .tocarBotaoAjuda();
                new SelecaoDeContaTela(getDriver())
                        .tocarNoBotaoNomeDependente(dependente);
                new AjudaNextTela(getDriver())
                        .tocarBotaoIniciarChat();
                new ChatTela(getDriver())
                        .validarTelaChat();
                break;
        }

    }

    /**
     * Validar que ao arrastar o Bubble para o "X" no centro da tela na parte inferior o icone sera fechado
     */
    public void arrastarBubbleChatEFechar() throws Exception {
        new ChatTela(getDriver())
                .tocarBotaoVoltarAoMenu();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
        new MenuTela(getDriver())
                .moverIconeBubbleParaFechar()
                .validarAusenciaDoBubbleChatNaTelaDeMenu();
    }

    /**
     * Validar presença dos 16 temas na tela ajuda
     */
    public void validarPresencaTemasTelaAjuda() throws Exception {
        new AjudaNextTela(getDriver())
                .validarPresencaAjudaNextTela()
                .validarPresencaBotaoCartoes()
                .validarPresencaBotaoConta()
                .validarPresencaBotaoEmprestimos()
                .validarPresencaBotaoIndiqueAmigos()
                .validarPresencaBotaoInvestimentos()
                .validarPresencaBotaoMimos()
                .validarPresencaBotaoNextJoy()
                .validarPresencaBotaoNextShop()
                .validarPresencaBotaoOpenFinance()
                .validarPresencaBotaoPix()
                .validarPresencaBotaoSeguranca()
                .validarPresencaBotaoSeguros()
                .validarPresencaBotaoSobreNos()
                .validarPresencaBotaoTransacoes()
                .validarPresencaBotaoTrazerSalario()
                .validarPresencaBotaoVaquinha()
                .tocarBotaoMenu();

    }
}
