package funcionalidade.mobile.configuracoes.perfil;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.configuracoes.perfil.TituloTela;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.configuracoes.perfil.APP.ConfiguracoesDoAppTela;
import pagina.mobile.jornadas.configuracoes.perfil.APP.TrocarSenhaAppTela;
import pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes.TermosCondicoesTela;
import pagina.mobile.jornadas.configuracoes.perfil.ConfiguracoesPerfilTela;
import pagina.mobile.jornadas.configuracoes.perfil.GaleriaTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.ConfiguracoesPagamentosTela;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.PerfilTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.MeusDadosTela;
import pagina.mobile.jornadas.login.NovoCelularTela;
import pagina.mobile.jornadas.login.TirarFotoTela;
import pagina.mobile.jornadas.menu.MenuTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ConfiguracoesPerfilFunc extends FuncionalidadeBase {

    /**
     * Método para tocar na engrenagem e em configurações de pagamento'
     *
     * @throws Exception
     */
    public void tocarPerfilConfiguracoesPagamento() throws Exception {
        new ConfiguracoesPerfilTela(getDriver())
                .tocarPerfilEngrenagem();
        new PerfilTela(getDriver())
                .validarTelaPerfil()
                .tocarConfiguracoesPagamento();
        new ConfiguracoesPagamentosTela(getDriver())
                .validarTelaConfiguracoesPagamento();
    }

    /**
     * Método para tocar na engrenagem e em 'Meus Dados'
     *
     *
     * @throws Exception
     */
    public void tocarMeusDados() throws Exception {
        tocarPerfilConfiguracoes();

        new PerfilTela(getDriver())
                .tocarMeusDados();
        new MeusDadosTela(getDriver())
                .validarTelaMeusDados();
    }

    private void tocarPerfilConfiguracoes() throws Exception {
        new ConfiguracoesPerfilTela(getDriver())
                .tocarPerfilEngrenagem();
        new PerfilTela(getDriver())
                .validarTelaPerfil();
    }

    /**
     * Tocar na foto do perfil para iniciar troca de foto
     *
     * @throws Exception
     */
    public void iniciarTrocaFoto() throws Exception {
        new MenuTela(getDriver())
                .tocarFotoCliente();
        new PerfilTela(getDriver())
                .validarTelaPerfil()
                .tocarIconeCamera();
    }

    /**
     * Tirar foto pela câmera e confirmar foto
     *
     * @throws Exception
     */
    public void tirarFoto() throws Exception {
        new PerfilTela(getDriver())
                .tocarBotaoTirarFoto();
        if (new NovoCelularTela(getDriver()).isAcessoCamera()){
            new NovoCelularTela(getDriver())
                    .tocarAcessoCameraPermitirOk();
        }
        new TirarFotoTela(getDriver())
                .tocarBotaoTirarFoto()
                .tocarBotaoCurtiContinuar();
        new PerfilTela(getDriver())
                .validarTelaPerfil();
    }

    /**
     * Tirar foto pela galeria e confirmar foto
     *
     * @throws Exception
     */
    public void escolherFotoGaleria() throws Exception {
        new PerfilTela(getDriver())
                .tocarBotaoEscolherNaGaleria()
                .tocarBotaoPermitir();
        new GaleriaTela(getDriver())
                .tocarPrimeiraImagemDaGaleria();
        new TirarFotoTela(getDriver())
                .tocarBotaoCurtiContinuar();
        new PerfilTela(getDriver())
                .validarTelaPerfil();
    }

    /**
     * Tocar voltar para o menu
     *
     * @throws Exception
     */
    public void finalizarTrocaFoto() throws Exception {
        new PerfilTela(getDriver())
                .tocarBotaoVoltarAoMenu();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenu();
    }

    /**
     * Método para tocar na engrenagem e em termos e condições'
     *
     * @throws Exception
     */
    public void tocarPerfilTermosCondicoes() throws Exception {
        new ConfiguracoesPerfilTela(getDriver())
                .tocarPerfilEngrenagem();
        new PerfilTela(getDriver())
                .validarTelaPerfil()
                .tocarTermosCondicoes();
        new TermosCondicoesTela(getDriver())
                .validarTelaTermosCondicoes();
    }

    /**
     * Método para tocar na engrenagem e em configurações do APP'
     * fr
     * @throws Exception
     */
    public void tocarPerfilConfiguracoesAPP() throws Exception {
        new ConfiguracoesPerfilTela(getDriver())
                .tocarPerfilEngrenagem();
        new PerfilTela(getDriver())
                .verificarPresencaPopupCartaoNaoEmidito()
                .validarTelaPerfil()
                .tocarConfiguracoesAPP();
        new ConfiguracoesDoAppTela(getDriver())
                .validarTelaConfiguracoesApp();
    }

    /**
     * Método para trocar senha do App'
     * fr
     * @throws Exception
     * @param senha
     * @param novaSenha
     * @param confirmarSenha
     */
    public void trocarSenhaDoApp(String senha, String novaSenha, String confirmarSenha) throws Exception {
        new ConfiguracoesDoAppTela(getDriver())
                .tocarBotaoTrocarSenha();
        new TrocarSenhaAppTela(getDriver())
                .validarTelaTrocarSenhaApp()
                .preencherSenha(senha)
                .tocarBotaoContinuar()
                .preencherNovaSenha(novaSenha)
                .preencherConfirmarNovaSenha(confirmarSenha)
                .tocarBotaoConfirmar();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(TituloTela.SENHA_ALTERADA.toString());
        new PopUpTela(getDriver())
                .tocarBotaoOk();

    }
}
