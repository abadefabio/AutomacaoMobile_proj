package teste.mobile.regressivo.vaquinha;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.vaquinha.Vaquinha;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.vaquinha.MeusContatosFunc;
import funcionalidade.mobile.vaquinha.VaquinhaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

@Jornada(Jornadas.VAQUINHA)
public class QA00119 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private VaquinhaFunc vaquinha = new VaquinhaFunc();
    private MeusContatosFunc contato = new MeusContatosFunc();

    @Test(description = "REG.VAQ.17.04|REG.VAQ.17.05 - Validar convite para um participante adicionado dentro da funcionalidade \"Vaquinha\" e recusa de um convite para participação de uma \"Vaquinha\"")
    @Description("Efetuar o convite para um participante adicionando dentro da funcionalidade Vaquinha (1) e validar a recusa de um convite para participação de uma Vaquinha (2)." +
            "Pré requisitos:\n" +
            "1- Ter dois clientes NEXT (Administrador e Convidado);\n" +
            "2- Usuário administrador já ter pelo menos uma vaquinha criada;\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA00119() throws Exception {

        JSONObject dadosVaquinha = recuperarJSSONMassa("vaquinha");

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.criarVaquinha(dadosVaquinha, calcularDataRelativaHoje(30));

        vaquinha.tocarBotaoFechar();

        vaquinha.selecionarPrimeiraVaquinha();

        vaquinha.convidar(dadosVaquinha, Vaquinha.MENSAGEM_SUCESSO_CRIAR_CONTATO, Vaquinha.MENSAGEM_SUCESSO_ATUALIZAR_CONTATO);

        vaquinha.retornarAoMenu();

        login.logout();

        login.loginSemEscolhaEsteira(dadosVaquinha.get("favorecidoCpf").toString(), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.selecionarPrimeiraVaquinha();

        vaquinha.recusarVaquinha(Vaquinha.MENSAGEM_RECUSA_VAQUINHA);

        vaquinha.retornarAoMenu();

        login.logout();

        login.loginSemEscolhaEsteira(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        vaquinha.validarNotificacaoRecusaVaquinha(dadosVaquinha.get("mensagemPush").toString());

    }

    @AfterMethod
    public void excluirVaquinha(ITestResult result) throws Exception {

        if (result.isSuccess()) {

            menu.selecionarVaquinha();
            contato.excluirVaquinha();
            vaquinha.excluirCards();

        }
    }
}
