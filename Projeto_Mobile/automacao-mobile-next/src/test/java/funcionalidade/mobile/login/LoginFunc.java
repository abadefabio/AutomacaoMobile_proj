package funcionalidade.mobile.login;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import framework.AcoesGerais;
import framework.SalvarSenhaGoogle;
import funcionalidade.web.email.EmailWebFunc;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.StringUtils;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.adesao.CriarContaTela;
import pagina.mobile.jornadas.login.GeolocalizacaoTela;
import pagina.mobile.jornadas.login.JaTenhoContaTela;
import pagina.mobile.jornadas.login.LoginTela;
import pagina.mobile.jornadas.login.LoginUsuarioLogadoTela;
import pagina.mobile.jornadas.login.NovoCelularTela;
import pagina.mobile.jornadas.login.PrimeiroAcessoTela;
import pagina.mobile.jornadas.login.TirarFotoTela;
import pagina.mobile.jornadas.menu.MenuTela;

import static br.com.next.automacao.core.base.TesteNext.recuperarMassa;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static br.com.next.automacao.core.tools.servicos.UtilitarioResetCpf.resetCpf;
import static framework.MobileUtils.retornaDataAtualFormatada;
import static java.lang.Integer.parseInt;

public class LoginFunc extends FuncionalidadeBase {

    private static ThreadLocal<String> codigo = new ThreadLocal<>();

    /**
     * Retorna para tela inicial se ao iniciar o teste, o app não esteja nela
     *
     * @throws Exception
     */
    private void voltarTelaInicial() throws Exception {
        LoginUsuarioLogadoTela usuarioLogadoTela = new LoginUsuarioLogadoTela(getDriver());
        JaTenhoContaTela jaTenhoContaTela = new JaTenhoContaTela(getDriver());
        if (usuarioLogadoTela.verificarTelaLoginJaLogado()) {
            usuarioLogadoTela.logarNovoCPF();
            new LoginTela(getDriver())
                    .tocarBotaoVoltar();
        } else {
            if (jaTenhoContaTela.verificarTelaJaTenhoConta()) {
                new LoginTela(getDriver())
                        .tocarBotaoVoltar();
            }
        }
    }

    /**
     * Preparações iniciais antes de login: esconder teclado, fechar popup senhas do google
     *
     * @throws Exception
     */
    private void preparacoesIniciaisAntesDeLogin() throws Exception {
        new AcoesGerais(getDriver()).esconderTeclado();

        if (getDriver() instanceof AndroidDriver) {
            new SalvarSenhaGoogle(getDriver())
                    .fecharPopupSenhaGoogleSeAberto();
        }
    }

    /**
     * Iniciar reset de cpf se necessário
     *
     * @throws Exception
     */
    private void iniciarResetCpfSeNecessario(String cpf) throws Exception {
        LoginTela login = new LoginTela(getDriver());

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

    /**
     * Efetuar login para usuario ja existente
     */
    public void efetuarLoginUsuarioExistente(String cpf, String senha) throws Exception {
        preparacoesIniciaisAntesDeLogin();

        efetuarLogin(cpf, senha);

        iniciarResetCpfSeNecessario(cpf);

        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Efetuar login para usuario ja existente
     */
    public void efetuarLoginCadastroIncompleto(String cpf, String senha) throws Exception {
        preparacoesIniciaisAntesDeLogin();

        efetuarLogin(cpf, senha);

        iniciarResetCpfSeNecessario(cpf);
    }

    /**
     * Efetuar login para usuario ja existente de primeiro
     */
    public void efetuarLoginUsuarioExistenteOuPrimeiroAcesso(String cpf, String senha) throws Exception {
        preparacoesIniciaisAntesDeLogin();

        efetuarLogin(cpf, senha);

        iniciarResetCpfSeNecessario(cpf);

        if (new PrimeiroAcessoTela(getDriver())
                .estaNaTelaPrimeiroAcesso()) {
            new PrimeiroAcessoTela(getDriver())
                    .tocarBotaoPular();
        }

        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Método para efetuar login e realizar a troca de device
     *
     * @param cpf
     * @param senha
     * @throws Exception
     */
    public void efetuarLoginComTrocaDeDevice(String cpf, String senha, String dominioUsuarioEmail, String senhaEmail) throws Exception {

        EmailWebFunc recuperarCodigosEmail = new EmailWebFunc();

        preparacoesIniciaisAntesDeLogin();

        efetuarLogin(cpf, senha);

        new LoginTela(getDriver())
                .isResetCpfRequerido();
        new NovoCelularTela(getDriver())
                .tocarVamosLa()
                .tocarTirarFoto();
        if (new NovoCelularTela(getDriver()).isAcessoCamera()) {
            new NovoCelularTela(getDriver())
                    .tocarAcessoCameraPermitirOk();
        }
        new TirarFotoTela(getDriver())
                .tocarBotaoTirarFoto()
                .tocarBotaoCurtiContinuar();

        recuperarCodigosEmail.recuperarCodigoParaMudancaDeAparelho(dominioUsuarioEmail, senhaEmail, codigo);

        new NovoCelularTela(getDriver())
                .escreverCodigoDeSeguranca(codigo)
                .tocarContinuar()
                .validarMensagemTudoCerto()
                .tocarEntrar();
        new LoginTela(getDriver())
                .informarCPF(cpf)
                .informarSenha(senha)
                .tocarEntrar();
        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Método responsável por realizar o login até tocar no botão entrar. Após isso, os métodos públicos devem fazer as suas próprias validações.
     *
     * @param cpf
     * @param senha
     * @throws Exception
     */
    private void efetuarLogin(String cpf, String senha) throws Exception {

        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(ReadProperties.getAmbiente());

        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente();
        if (getDriver() instanceof IOSDriver) {
            new JaTenhoContaTela(getDriver())
                    .tocarOkPopUpUsoInternet();
        }
        new JaTenhoContaTela(getDriver())
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira();
        if (getDriver() instanceof IOSDriver) {
            new GeolocalizacaoTela(getDriver())
                    .tocarPermitirUsoLocalizacao();
        }
        new JaTenhoContaTela(getDriver())
                .tocarJaTenhoConta();
        if (getDriver() instanceof IOSDriver) {
            new GeolocalizacaoTela(getDriver())
                    .confirmarGeolocalizacao();
        }
        new LoginTela(getDriver())
                .informarCPF(cpf)
                .informarSenha(senha)
                .tocarEntrar();
    }

    /**
     * Método para efetuar login de usuário de primeiro acesso
     *
     * @throws Exception
     */
    public void efetuarLoginUsuarioPrimeiroAcesso(String cpf, String senha) throws Exception {
        preparacoesIniciaisAntesDeLogin();

        efetuarLogin(cpf, senha);

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
    public void acessarTelaEsqueciMinhaSenha() throws Exception {
        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(StringUtils.substringBefore(esteira, "-"));
        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente()
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira()
                .tocarJaTenhoConta();
        new LoginTela(getDriver())
                .validarExibicaoTelaLogin()
                .tocarBotaoEsqueceuSuaSenha();
    }

    /**
     * Efetuar Login no APP com a nova Senha
     */
    public void acessarAppComNovaSenha(String cpf, String novaSenha) throws Exception {
        new LoginTela(getDriver())
                .informarCPF(cpf)
                .informarSenha(novaSenha)
                .tocarEntrar();

        iniciarResetCpfSeNecessario(cpf);

        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Realizar logout no app
     *
     * @throws Exception
     */
    public void logout() throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            new MenuTela(getDriver())
                    .tocarMenuSair();
        } else {
            new LoginTela(getDriver())
                    .tocarSair();
        }
        new PopUpTela(getDriver())
                .tocarBotaoSim();
    }

    /**
     * Realizar login no app sem escolher esteira
     *
     * @throws Exception
     */
    public void loginSemEscolhaEsteira(String cpf, String senha) throws Exception {
        LoginTela login = new LoginTela(getDriver());
        new LoginUsuarioLogadoTela(getDriver())
                .logarNovoCPF();
        login.validarExibicaoTelaLogin()
                .informarCPF(cpf)
                .informarSenha(senha)
                .tocarEntrar();
        if (!(getDriver() instanceof AndroidDriver) && login.validacaoLoginNaoEfetuado()) {
            login.validarExibicaoTelaLogin()
                    .informarCPF(cpf)
                    .informarSenha(senha)
                    .tocarEntrar();
        }

        iniciarResetCpfSeNecessario(cpf);

        new MenuTela(getDriver())
                .validarExibicaoTelaMenuAposLogin();
    }

    /**
     * Método que acessa o Pix através da tela de Login Recorrente
     *
     * @param senha Senha de acesso do cpf logada
     * @throws Exception
     */
    public void acessarPixLoginRecorrente(String senha) throws Exception {
        new LoginUsuarioLogadoTela(getDriver())
                .tocarBotaoPix();
        new LoginTela(getDriver())
                .informarSenha(senha);
        if (getDriver() instanceof AndroidDriver) {
            new LoginTela(getDriver())
                    .tocarEntrar();
        }
    }


    /**
     * Acessar tela de criar conta next joy com conta pendente aprovação
     *
     * @throws Exception
     */
    public void criarContaNextJoy() throws Exception {
        new LoginTela(getDriver())
                .validarCardNextJoy()
                .tocarBotaoCriarNextJoy();
    }

    /**
     * Tentar login no app para cadastro pedente
     *
     * @throws Exception
     */
    public void loginCadastroPendente(String cpf, String senha, boolean fezLogoutApp) throws Exception {
        preparacoesIniciaisAntesDeLogin();

        if (fezLogoutApp) {
            LoginTela login = new LoginTela(getDriver());
            new LoginUsuarioLogadoTela(getDriver())
                    .logarNovoCPF();
            login.validarExibicaoTelaLogin()
                    .informarCPF(cpf)
                    .informarSenha(senha)
                    .tocarEntrar();
            if (!(getDriver() instanceof AndroidDriver) && login.validacaoLoginNaoEfetuado()) {
                login.validarExibicaoTelaLogin()
                        .informarCPF(cpf)
                        .informarSenha(senha)
                        .tocarEntrar();
            }
        } else {
            efetuarLogin(cpf, senha);
        }
    }

    /**
     * verificar a tela de login ja Logado
     *
     * @throws Exception
     */
    public void verificarTelaLoginJaLogado() throws Exception {
        new LoginUsuarioLogadoTela(getDriver())
                .verificarTelaLogin();
    }

    /**
     * Retorna um CPF de uma lista com base no dia de vencimento da fatura do Cartão.
     * A posição '0' da lista, é o CPF com o vencimento da fatura no dia '01'.
     * A posição '1' da lista, é O CPF com o vencimento da fatura no dia '10'.
     * A posição '2' da lista, é O CPF com o vencimento da fatura no dia '15'.
     * Caso o tamanho da lista seja diferente de '3' posições, o teste falhará.
     *
     * @return retornaCpfCartaoDeCreditoPeloDiaVencDaFatura
     */
    public static String retornaCpfCartaoDeCreditoPeloDiaVencDaFatura() throws Exception {
        int diaAtual = parseInt(retornaDataAtualFormatada("dd"));
        String[] cpfList = recuperarMassa("cpf").split(",");

        if (cpfList.length != 3) {
            OperadorEvidencia.logarPasso("Falha ao recuperar o CPF do arquivo json");
            throw new Exception("A quantidade de CPFs no arquivo json não pode ser diferente de 3, " +
                    "por exemplo: '11144477722,33366699977,89189874633'");
        }
        return diaAtual > 01 && diaAtual < 15 ? cpfList[0] :
                diaAtual > 10 && diaAtual < 25 ? cpfList[1] : cpfList[2];
    }

    /**
     * Login com senha invalida
     *
     * @throws Exception
     */
    public void loginSenhaInvalida(String cpf, String senha) throws Exception {
        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(StringUtils.substringBefore(esteira, "-"));
        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente()
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira()
                .tocarJaTenhoConta();
        new LoginTela(getDriver())
                .validarExibicaoTelaLogin()
                .informarCPF(cpf)
                .informarSenha(senha)
                .tocarEntrar()
                .validarMensagemSenhaInvalida(LoginApp.MENSAGEM_USUARIO_OU_SENHA_INVALIDA);
    }

    /**
     * Método para acessar a tela Criar Conta
     *
     * @throws Exception
     */
    public void acessarTelaCriarConta() throws Exception {

        String esteira = ReadProperties.getEsteira();
        String ambiente = normalizaString(ReadProperties.getAmbiente());

        preparacoesIniciaisAntesDeLogin();
        voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente();
        if (getDriver() instanceof IOSDriver) {
            new JaTenhoContaTela(getDriver())
                    .tocarOkPopUpUsoInternet();
        }
        new JaTenhoContaTela(getDriver())
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira();
        if (getDriver() instanceof IOSDriver) {
            new GeolocalizacaoTela(getDriver())
                    .tocarPermitirUsoLocalizacao();
        }
        new JaTenhoContaTela(getDriver())
                .tocarBotaoCriarConta();
        new CriarContaTela(getDriver())
                .validarPresencaTelaCriarConta();
    }

}
