package funcionalidade.web.contingencia.login.mobile;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import org.apache.commons.lang3.StringUtils;
import pagina.mobile.login.*;
import pagina.mobile.menu.MenuTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static br.com.next.automacao.core.tools.servicos.UtilitarioResetCpf.resetCpf;

public class LoginFunc extends FuncionalidadeBase {

    /**
     * Retorna para tela inicial se ao iniciar o teste, o app não esteja nela
     * @throws Exception
     */
    public void voltarTelaInicial() throws Exception {
        LoginUsuarioLogadoTela usuarioLogadoTela = new LoginUsuarioLogadoTela(getDriver());
        if(usuarioLogadoTela.verificarTelaLoginJaLogado()){
            usuarioLogadoTela.logarNovoCPF();
            new LoginTela(getDriver())
                    .tocarBotaoVoltar();
        }
    }

    /**
     * Efetuar login para usuario ja existente
     */
    public void efetuarLoginUsuarioExistente(String cpf, String senha) throws Exception {
        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(ReadProperties.getAmbiente());
        LoginTela login = new LoginTela(getDriver());
        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente()
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira()
                .tocarJaTenhoConta();
        login.validarExibicaoTelaLogin()
                .informarCPF(cpf)
                .informarSenha(senha)
                .tocarEntrar();
        if (login.isResetCpfRequerido()) {
            OperadorEvidencia.logarPasso("Iniciando reset de CPF...");
            login.validarResetCpf(
                    resetCpf(cpf)
            );
            new NovoCelularTela(getDriver())
                    .fecharTelaNovoCelular();
            login.tocarEntrar();
        }
        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Método para efetuar login de usuário de primeiro acesso
     *
     * @throws Exception
     */
    public void efetuarLoginUsuarioPrimeiroAcesso(String cpf, String senha) throws Exception {
        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(ReadProperties.getAmbiente());
        LoginTela login = new LoginTela(getDriver());
        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente()
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira()
                .tocarJaTenhoConta();
        login.informarCPF(cpf)
                .informarSenha(senha)
                .tocarEntrar();
        new PrimeiroAcessoTela(getDriver())
                .validarMensagemPrimeiroAcesso(LoginApp.MENSAGEM_BOAS_VINDAS_PRIMEIRO_ACESSO)
                .tocarBotaoPular();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Reefetuar login de usuário previamente logado
     */
    public void reefetuarLoginUsuario(String senha) throws Exception {
        new LoginTela(getDriver())
                .informarSenha(senha)
                .tocarEntrar();
    }

    /**
     * Clica no botão Sair
     *
     * @throws Exception
     */
    public void tocarSair() throws Exception {
        new LoginTela(getDriver())
                .tocarSair();
    }

    /**
     * Recarregar App Next
     */
    public void recarregarAppNext() throws Exception {
        new LoginTela(getDriver())
                .recarregarAppNext();
    }

    /**
     * Acessar tela 'Esqueci Minha Senha'
     */
    public void acessarTelaEsqueciMinhaSenha(String mensagemTelaRecuperaSenha) throws Exception {
        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(StringUtils.substringBefore(esteira, "-"));
        LoginTela login = new LoginTela(getDriver());
        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente()
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira()
                .tocarJaTenhoConta();
        login.validarExibicaoTelaLogin();
        new LoginTela(getDriver())
                .tocarBotaoEsqueceuSuaSenha();
    }

    /**
     * Efetuar Login no APP com a nova Senha
     */
    public void acessarAppComNovaSenha(String cpf, String novaSenha) throws Exception {
        LoginTela login = new LoginTela(getDriver());
        new LoginTela(getDriver())
                .informarCPF(cpf)
                .informarSenha(novaSenha)
                .tocarEntrar();

        if (login.isResetCpfRequerido()) {
            OperadorEvidencia.logarPasso("Iniciando reset de CPF...");
            login.validarResetCpf(
                    resetCpf(cpf)
            );
            new NovoCelularTela(getDriver())
                    .fecharTelaNovoCelular();
            login.tocarEntrar();
        }
    }
}

