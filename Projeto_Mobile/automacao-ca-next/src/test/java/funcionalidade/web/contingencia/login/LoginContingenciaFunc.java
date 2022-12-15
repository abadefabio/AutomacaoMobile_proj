package funcionalidade.web.contingencia.login;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.driver.web.NavegadorEmFoco;
import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.GeradorGlobal;
import constantes.data.migration.DataMigrationJobs;
import constantes.login.contingencia.mobile.LoginAppMensagens;
import constantes.login.contingencia.mobile.LoginContigencia;
import constantes.login.contingencia.mobile.LoginContingenciaPopupMensagens;
import funcionalidade.web.contingencia.login.mobile.LoginFunc;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import pagina.api.data.migration.DataMigrationServico;
import pagina.mobile.contingencia.MobileAtalhosTela;
import pagina.mobile.contingencia.MobileContingenciaPopupFalhaTela;
import pagina.mobile.contingencia.MobileContingenciaPopupSucessoTela;
import pagina.mobile.contingencia.MobileContingenciaTela;
import pagina.mobile.login.JaTenhoContaTela;
import pagina.mobile.login.LoginTela;
import pagina.mobile.login.LoginUsuarioLogadoTela;
import pagina.mobile.login.NovoCelularTela;
import pagina.mobile.menu.MenuTela;
import pagina.mobile.perfil.MobilePerfilPopupTela;
import pagina.mobile.perfil.MobilePerfilTela;
import pagina.web.contingencia.login.ContingenciaInicialTela;
import pagina.web.contingencia.login.LoginContingenciaTela;
import pagina.web.contingencia.login.NextMeTela;
import pagina.web.contingencia.pagamento.PagamentoTela;
import pagina.web.contingencia.views.alertas.AlertaSessaoExpiradaTela;
import pagina.web.contingencia.views.alertas.AlertaSessaoFinalizadaSairTela;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;
import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;
import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static br.com.next.automacao.core.tools.servicos.UtilitarioResetCpf.resetCpf;
import static constantes.login.ambiente.ContingenciaUrl.URL;
import static constantes.login.contingencia.mobile.LoginContingenciaPopupMensagens.SUCESSO_ATIVACAO;


public class LoginContingenciaFunc extends LoginFunc {

    /**
     * Efetuar login no app a partir da tela de login
     * de um cliente já existente.
     * Note que é um override de método original do projeto Mobile,
     * portanto as alterações realizadas lá poderiam servir
     * para manter a estabilidade deste código.
     *
     * @param cpf
     * @param senha
     * @throws Exception
     * @Override efetuarLoginUsuarioExistente
     */
    @Override
    @Step("Efetuar login usuário existente a partir da tela de login")
    public void efetuarLoginUsuarioExistente(String cpf, String senha) throws Exception {
         /*
        Este método está contindo no método de superlogin.
        Alterações aqui podem impactar.
         */
        LoginTela login = new LoginTela(getDriver());
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
     * Verifica status do parametro resetApp e decide se o reset do app será efetuado ou não
     */
    public boolean efetuarLoginInicio() {

        if (OperadorDriver.isAppBrowserRessetado())
            return true;

        if (getCasoTeste().getParametrosTeste().get("resetApp").equals("true")) { //Adicionar condição caso seja null
            return true;
        } else {
            if (getDriver() instanceof AndroidDriver) {
                return !new MobileContingenciaTela(getDriver()).validarPresencaSessionKey();
            } else {
                return !new MobileContingenciaTela(getDriver()).validarPresencaTituloEgContigencia();
            }
        }
    }

    /**
     * Efetuar o login completo na Contingência app desde a inicialização do dispositivo mobile.
     *
     * @param cpf
     * @param senha
     * @throws Exception
     */
    @Step("Logar-se por completo da Contingência Mobile e App desde o início da execução")
    public void efetuarSuperLoginUsuarioExistente(String cpf, String senha) throws Exception {
        /*
        Note que este método contém métodos da própria classe.
        Alterações em um destes métodos poderiam quebrar esta funcionalidade.
         */

        OperadorEvidencia.logarPasso("O aplicativo e a aplicação web foi resetado?" + OperadorDriver.isAppBrowserRessetado());
        if (efetuarLoginInicio()) {
            selecionarAmbienteIrTelaLogin();
            efetuarLoginUsuarioExistente(cpf, senha);
            sairAppDesdeMenuInicial();
            DataMigrationServico.JobsParalelos jobsParalelos = new DataMigrationServico()
                    .iniciarDataMigration(DataMigrationJobs.TIMEOUT_FINALIZACAO, DataMigrationJobs.PARAMETROS_JOBS);
            acionarTelaLeituraQrCodeMobileDesdeTelaLogin();
            OperadorEvidencia.logarPasso("Iniciando execução job DATAMIGRATIONCONTACTJOB");
            jobsParalelos.join();
            new DataMigrationServico()
                    .aguardarJobFinalizar(DataMigrationJobs.TIMEOUT_FINALIZACAO, jobsParalelos.obterExecutionIdSecurityJob());
            efetuarLoginContingenciaHibrido(cpf, senha);
            new MobileContingenciaPopupSucessoTela(getDriver())
                    .validarMensagemSucesso(SUCESSO_ATIVACAO.toString())
                    .tocarBotaoOK();
            new MobileContingenciaTela(getDriver())
                    .esconderTeclado();
        }
    }

    /**
     * Ir para a Contingência no app e validar mensagem de alerta de app indisponível
     *
     * @param mensagem
     * @throws Exception
     */
    @Step("Acionar leitura de QR Code no app efetuando validação indisponibilidade app")
    public void acionarTelaLeituraQrCodeMobileDesdeTelaLogin(LoginAppMensagens mensagem) throws Exception {
        new LoginUsuarioLogadoTela(getDriver())
                .tocarBotaoAtalhos();
        new MobileAtalhosTela(getDriver())
                .tocarBotaoNextWebContingencia();
        new MobileContingenciaTela(getDriver())
                .validarAppTemporariamenteIndisponivel(mensagem.toString())
                .manterPressionadoBotaoLerQrCode();
    }

    /**
     * Ir para a Contingência no app sem validar mensagem
     *
     * @throws Exception
     */
    @Step("Acionar leitura de QR Code no app")
    public void acionarTelaLeituraQrCodeMobileDesdeTelaLogin() throws Exception {
         /*
        Este método está contindo no método de superlogin.
        Alterações aqui podem impactar.
         */
        new LoginUsuarioLogadoTela(getDriver())
                .tocarBotaoAtalhos();
        new MobileAtalhosTela(getDriver())
                .tocarBotaoNextWebContingencia();
        new MobileContingenciaTela(getDriver())
                .manterPressionadoBotaoLerQrCode();
    }

    /**
     * Tocar a foto do cliente
     *
     * @throws Exception
     */
    @Step("Sair do aplicativo")
    public void sairAppDesdeMenuInicial() throws Exception {
         /*
        Este método está contindo no método de superlogin.
        Alterações aqui podem impactar.
         */
        if (getDriver() instanceof IOSDriver) {
            new MenuTela(getDriver())
                    .tocarBotaoVerPerfil();
        } else {
            new MenuTela(getDriver())
                    .tocarFotoCliente();
        }
        new MobilePerfilTela(getDriver())
                .tocarBotaoSairApp();
        new MobilePerfilPopupTela(getDriver())
                .tocarBotaoSim();
    }

    public void selecionarAmbienteIrTelaLogin() throws Exception {
        /*
        Este método está contindo no método de superlogin.
        Alterações aqui podem impactar.
         */
        String esteira = getEsteira();
        String ambiente = normalizaString(ReadProperties.getAmbiente());
        LoginFunc funcionalidadeLogin = new LoginFunc();
        funcionalidadeLogin.voltarTelaInicial();
        new JaTenhoContaTela(getDriver())
                .validarExibicaoBotaoJaTenhoContaTela()
                .abrirSelecaoAmbiente()
                .validarExibicaoSelecaoAmbiente()
                .selecionarAmbiente(ambiente)
                .escolherEsteira(esteira)
                .confirmarEsteira()
                .tocarJaTenhoConta();
    }

    public void validarOpcaoNextWebAusenteQuandoClienteNaoRegistradoVoltarTelaLogin() throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            new LoginUsuarioLogadoTela(getDriver())
                    .tocarBotaoAtalhosClienteNaoRegistrado();
            new MobileAtalhosTela(getDriver())
                    .validarBotaoNextWebContingenciaAusente(
                            LoginContigencia.ITENS_ESPERADOS_ATALHOS,
                            LoginContigencia.ITEM_NEXT_WEB);
            new MobileAtalhosTela(getDriver())
                    .tocarBotaoVoltar();
        }
    }

    /**
     * Selecionar Atalhos
     *
     * @throws Exception
     */
    public void selecionarAtalhos() throws Exception {
        new LoginUsuarioLogadoTela(getDriver())
                .tocarBotaoAtalhos();
    }

    /**
     * Validar que oa opção 'next Web' não está disponível
     *
     * @throws Exception
     */
    @Step("Selecionar 'next Web' Contingência")
    public void voltarTelaLogin() throws Exception {
        new MobileAtalhosTela(getDriver())
                .tocarBotaoVoltar();
    }

    /**
     * Selecionar 'next Web' Contingência
     *
     * @throws Exception
     */
    @Step("Selecionar 'next Web' Contingência")
    public void selecionarContingencia() throws Exception {
        new MobileAtalhosTela(getDriver())
                .tocarBotaoNextWebContingencia();
    }

    /**
     * Exemplo
     *
     * @param cpf
     * @param senha
     * @throws Exception
     */
    public void efetuarLoginContingenciaHibrido(String cpf, String senha) throws Exception {
         /*
        Este método está contindo no método de superlogin.
        Alterações aqui podem impactar.
         */
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        String sessionKey = null;
        int count = 0;
        while (sessionKey == null && count <= 1) {
            new LoginContingenciaTela(getWebDriver())
                    .verificarTelaLoginWebBotaoContinuar()
                    .informarCpf(cpf)
                    .clicarBotaoContinuar()
                    .validarQrCodePresente();
            sessionKey = new LoginContingenciaTela(getWebDriver()).lerQRCode();
            count++;
        }
        mobileContingenciaTela
                .informarSessionKey(sessionKey)
                .tocarBotaoLogin()
                .informarSenhaLogin(senha)
                .tocarBotaoContinuar();
    }

    /**
     * Exemplo
     *
     * @throws Exception
     */
    public void abrirLeituraQrCode() throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        mobileContingenciaTela
                .manterPressionadoBotaoLerQrCode();
    }

    /**
     * Parte da tela em que se informa o QR Code no app
     * e da tela do QR Code no navegador.
     * Dali, o QR Code é lido e informado no app,
     * e o login procede até clicar em 'Continuar'
     *
     * @param senha
     * @throws Exception
     */
    public void efetuarLoginContingenciaSessionKeySenha(String senha) throws Exception {
        String sessionKey = new LoginContingenciaTela(getWebDriver())
                .lerQRCode();
        new MobileContingenciaTela(getDriver())
                .informarSessionKey(sessionKey)
                .tocarBotaoLogin()
                .informarSenhaLogin(senha)
                .tocarBotaoContinuar();
    }

    /**
     * Validar tempo máximo de expiração do QR Code
     * O tempo máximo deve conter um período de graça (concessão)
     * devido a atrasos de automação. Recomenda-se incluir
     * 5 segundos ao período de tempo máximo permitido.
     * A utilização desta funcionalidade requer que o documento CPF/CNPJ
     * tenha sido informado na página imediatamente antes desta medição/validação.
     *
     * @param cpf
     * @param tempoMaximo
     * @throws Exception
     */
    public void validarTempoMaximoExpiracaoQrCode(String cpf, int tempoMaximo) throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        mobileContingenciaTela
                .manterPressionadoBotaoLerQrCode();
        new LoginContingenciaTela(getWebDriver())
                .informarCpf(cpf)
                .clicarBotaoContinuar();
        new LoginContingenciaTela(getWebDriver())
                .validarTempoExpiracaoQRCodeRecente(tempoMaximo);
    }

    /**
     * Testar campo CPF com entradas incorretas
     *
     * @param cpf
     * @param mensagem
     * @throws Exception
     */
    public void validarCpfIncorretoLoginWeb(GeradorGlobal cpf, String mensagem) throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .verificarTelaLoginWebBotaoContinuar()
                .informarCpfIncorreto(cpf.toString())
                .validarConteudoCpfQuandoEntradaEmBranco(cpf.toString())
                .validarConteudoCpfQuandoEntradaAlfabetica(cpf.toString())
                .validarMensagemErroValidacaoCpf(mensagem);
    }

    /**
     * Testar campo CPF com CPF qualquer válido
     *
     * @param cpf
     * @throws Exception
     */
    public void testarCpfValidoLoginWeb(GeradorGlobal cpf) throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .informarCpfIncorreto(cpf.toString())
                .validarQrCodePresente();
    }

    /**
     * Aguardar expiração do QR Code e mensagem para gerar novo QR Code
     *
     * @param cpf
     * @param tempoMaxExpiracaoQrCode
     * @throws Exception
     */
    public void gerarQrCodeAguardarExpiracaoValidar(GeradorGlobal cpf, int tempoMaxExpiracaoQrCode) throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .verificarTelaLoginWebBotaoContinuar()
                .informarCpf(cpf.toString())
                .clicarBotaoContinuar()
                .validarQrCodePresente()
                .aguardarExpiracaoQrCode(tempoMaxExpiracaoQrCode);
    }

    /**
     * Aguardar expiração do QR Code e mensagem para gerar novo QR Code na Transferencia
     *
     * @param tempoMaxExpiracaoQrCode
     * @throws Exception
     */
    public void gerarQrCodeAguardarExpiracaoValidarTrasferencia(int tempoMaxExpiracaoQrCode) throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .validarQrCodePresente()
                .aguardarExpiracaoQrCode(tempoMaxExpiracaoQrCode);
    }

    /**
     * Renovar o QR Code expirado na página
     * antes de tentar um novo login
     *
     * @throws Exception
     */
    public void renovarQrCodeExpirado() throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .clicarQrCodeExpirado();
    }

    /**
     * Validar mensagem de falha na autenticação após leitura de QR Code e senha
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemFalha(LoginContingenciaPopupMensagens mensagem) throws Exception {
        new MobileContingenciaPopupFalhaTela(getDriver())
                .validarMensagemFalha(mensagem.toString())
                .tocarBotaoOK();
    }

    /**
     * Validar mensagem de sucesso na autenticação após leitura de QR Code e senha
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemSucessoLoginMobile(LoginContingenciaPopupMensagens mensagem) throws Exception {
        new MobileContingenciaPopupSucessoTela(getDriver())
                .validarMensagemSucesso(mensagem.toString())
                .tocarBotaoOK();
    }

    /**
     * Validar mensagem de sucesso na autenticação após leitura de QR Code e senha
     *
     * @throws Exception
     */
    public void validarSucessoLoginWeb() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .validarTelaInicialContingenciaWeb();
    }

    /**
     * Finalizar a Contingência
     *
     * @throws Exception
     */
    public void finalizarContingencia() throws Exception {
        new ContingenciaInicialTela(getWebDriver())
                .sairContingencia();
        new AlertaSessaoFinalizadaSairTela(getWebDriver())
                .selecionarOpcaoSair();
    }


    /**
     * Validar a página atual corresponde com o regex do Next.Me
     *
     * @param paginaNextme
     * @param conteudo
     * @throws Exception
     */
    public void validarPaginaNextMe(GeradorGlobal paginaNextme, GeradorGlobal conteudo) throws Exception {
        new NextMeTela(getWebDriver())
                .validarPagina(paginaNextme.toString(), conteudo.toString());
    }

    /**
     * Navegar para página de login da Contingência Web
     *
     * @param url
     * @throws Exception
     */
    public void navegarParaLoginContingenciaWeb(String url) throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .navegar(url);
    }

    /**
     * Navegar para página de login da Contingência Web
     * @throws Exception
     */
    public void verificarTelaLoginWebBotaoContinuar() throws Exception {
        new LoginContingenciaTela(getWebDriver())
                .verificarTelaLoginWebBotaoContinuar();
    }

    /**
     * Efetuar login da Contingência Web
     *
     * @param cpfCliente
     * @param senha
     * @throws Exception
     */
    public void efetuarLoginContingenciaWeb(String cpfCliente, String senha) throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        String sessionKey = new LoginContingenciaTela(getWebDriver())
                .informarCpf(cpfCliente)
                .clicarBotaoContinuar()
                .validarQrCodePresente()
                .lerQRCode();
        mobileContingenciaTela
            .apagarTextoCampoSessionKey()
            .informarSessionKey(sessionKey)
            .tocarBotaoLogin()
            .informarSenhaLogin(senha)
            .tocarBotaoContinuar();
        new MobileContingenciaPopupSucessoTela(getDriver())
                .tocarBotaoOK();
    }

    /**
     * Validar sessaão Expirada
     *
     * @throws Exception
     */
    public void validarSessaoExpirada() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuPagamento();
        new AlertaSessaoExpiradaTela(getWebDriver())
                .validarMensagemAlertaSessaoExpirada();
    }

    /**
     * Abrir contigencia em outro navegador
     *
     * @throws Exception
     */
    public void abrirContigenciaEmOutroNavegador() throws Exception {
        new FuncionalidadeBase()
                .definirProximoNavegador(NavegadorEmFoco.SECUNDARIO, URL);
    }

    /**
     * Voltar para primeiro navegador
     *
     * @throws Exception
     */
    public void voltarParaPrimeiroNavegador() throws Exception {
        new FuncionalidadeBase()
                .definirProximoNavegador(NavegadorEmFoco.PRINCIPAL);
    }

    /**
     * Voltar para o segundo navegador
     *
     * @throws Exception
     */
    public void voltarParaSegundoNavegador() throws Exception {
        new FuncionalidadeBase()
                .definirProximoNavegador(NavegadorEmFoco.SECUNDARIO);
    }

    /**
     * Validar se a sessão permanece ativa após clicar no menu pagamento na contingência web.
     *
     * @throws Exception
     */
    @Step("Validar sessão ativa")
    public void validarSessaoAtiva() throws Exception {
        new ContingenciaBaseTela(getWebDriver())
                .clicarMenuPagamento();
        new PagamentoTela(getWebDriver())
                .validarTituloPagamento();
    }

    /**
     * Abrir uma nova aba no navegador web e acessar o site de login da contingencia web.
     */
    @Step("abrir Nova Aba Navegador Web")
    public void abrirNovaAbaNavegadorWeb() throws Exception {
        new FuncionalidadeBase()
                .abrirUrlEmNovaAba(URL);
        new LoginContingenciaTela(getWebDriver())
                .salvarEvidenciaNovaGuiaAberta();
    }

    /**
     * Alternar entre abas do navegador web.
     *
     * @param indice
     */
    @Step("Alternar entre abas")
    public void alternarEntreAbas(int indice) {
        new FuncionalidadeBase()
                .alterarFocoAgente(indice);
        new LoginContingenciaTela(getWebDriver())
                .salvarEvidenciaAlternarAbas();
    }

    /**
     * Efetua o login completo Mobile e Web e clica no pop-up OK após o login.
     *
     * @param cpf
     * @param senha
     * @throws Exception
     */
    @Step("Efetuar Login Contingencia Mobile Web Senha Correta")
    public void efetuarLoginContingenciaMobileWebSenhaCorreta(String cpf, String senha) throws Exception {
        MobileContingenciaTela mobileContingenciaTela = new MobileContingenciaTela(getDriver());
        String sessionKey = new LoginContingenciaTela(getWebDriver())
                .informarCpf(cpf)
                .clicarBotaoContinuar()
                .validarQrCodePresente()
                .lerQRCode();
        mobileContingenciaTela
                .apagarTextoCampoSessionKey()
                .informarSessionKey(sessionKey)
                .tocarBotaoLogin()
                .informarSenhaLogin(senha)
                .tocarBotaoContinuar();
        new MobileContingenciaPopupSucessoTela(getDriver())
                .tocarBotaoOK();
    }
}
