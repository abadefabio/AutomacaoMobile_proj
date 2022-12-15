package teste.hibrido.regressivo.contingencia.login;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.GeradorGlobal;
import constantes.login.contingencia.mobile.LoginAppMensagens;
import constantes.login.contingencia.mobile.LoginContingenciaPopupMensagens;
import constantes.login.contingencia.web.LoginWebMensagens;
import constantes.login.contingencia.web.Parametros;
import funcionalidade.web.contingencia.migration.DataMigrationFunc;
import funcionalidade.web.contingencia.login.LoginContingenciaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Jornada(Jornadas.LOGIN_CONTINGENCIA)
public class QA02403 extends TesteBase {

    LoginContingenciaFunc login = new LoginContingenciaFunc();
    DataMigrationFunc dataMigration = new DataMigrationFunc();

    @Test(description = "Validar que o sistema está exibindo a tela de login")
    @Description("(QA-229) Descrição:\n" +
            "Validar que o sistema está exibindo a tela de login\n" +
            "Pré-condições:\n" +
            "1. Estar com contingência esta ativada;\n" +
            "2. Possuir usuário e senha Next com CPF veiculado a um device.\n" +
            "3. Estar logado no app do next\n" +
            "\n" +
            " (QA-452) Descrição:\n" +
            "Validar opção \"Next Web\" na tela inicial do app\n" +
            "Pré-condições:\n" +
            "1. Estar com contingência ativada.\n" +
            "2. Ter um usuário Next vinculado ao dispositivo.\n" +
            "\n" +
            " (QA-344) Descrição:\n" +
            "Validar que o sistema está exibindo a tela de login\n" +
            "Pré-condições:\n" +
            "1. Estar com contingência esta ativada;\n" +
            "\n" +
            "(QA-475) Descrição:\n" +
            "Validar que o sistema esta exibindo o pop-up com as informações corretas e quando clicar em sim o cliente e encaminhado para pagina do next.me\n" +
            "Pré-condições:\n" +
            "1. Estar com contingência esta ativada;\n" +
            "2. Possuir usuário e senha Next com CPF veiculado a um device.\n" +
            "3. Estar logado na tela principal.")
    @Severity(SeverityLevel.NORMAL)
    @Parameters({"url"})
    public void QA2403() throws Exception {

        String cpfCliente = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);

        login.selecionarAmbienteIrTelaLogin();
        login.validarOpcaoNextWebAusenteQuandoClienteNaoRegistradoVoltarTelaLogin();
        login.efetuarLoginUsuarioExistente(cpfCliente, senha);
        login.sairAppDesdeMenuInicial();
        dataMigration.iniciarJobs();

        login.verificarTelaLoginWebBotaoContinuar();
        login.validarCpfIncorretoLoginWeb(GeradorGlobal.CPF_EM_BRANCO, LoginWebMensagens.INFORME_CPF);
        login.validarCpfIncorretoLoginWeb(GeradorGlobal.CPF_ALFABETICO_INVALIDO, LoginWebMensagens.INFORME_CPF);
        login.validarCpfIncorretoLoginWeb(GeradorGlobal.CPF_NUMERICO_INVALIDO, LoginWebMensagens.CPF_INVALIDO);

        login.acionarTelaLeituraQrCodeMobileDesdeTelaLogin(LoginAppMensagens.APP_INDISPONIVEL);

        dataMigration.aguardarJobs();
        login.verificarTelaLoginWebBotaoContinuar();
        login.efetuarLoginContingenciaHibrido(cpfCliente, senha);
        login.validarMensagemSucessoLoginMobile(LoginContingenciaPopupMensagens.SUCESSO_ATIVACAO);
        login.validarSucessoLoginWeb();

        login.finalizarContingencia();
        login.validarPaginaNextMe(GeradorGlobal.URL_REGEX_NEXTME, GeradorGlobal.NEXTME);

        login.abrirNovaAbaNavegadorWeb();
        login.verificarTelaLoginWebBotaoContinuar();
        login.gerarQrCodeAguardarExpiracaoValidar(GeradorGlobal.CPF_ALEATORIO_VALIDO, Parametros.TEMPO_MAX_AGUARDAR_QRCODE_EXPIRAR);
    }
}
