package teste.mobile.regressivo.vaquinha;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.vaquinha.Vaquinha;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.vaquinha.VaquinhaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;
import static br.com.next.automacao.core.tools.Utilitarios.gerarNomeAleatorio;

@Jornada(Jornadas.VAQUINHA)
public class QA03225 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private VaquinhaFunc vaquinha = new VaquinhaFunc();

    @Test(description = "REG.VAQ.17.04|REG.VAQ.17.05 - Validar convite para um participante adicionado dentro da funcionalidade \"Vaquinha\" e recusa de um convite para participação de uma \"Vaquinha\"")
    @Description("Efetuar o convite para um participante adicionando dentro da funcionalidade Vaquinha (1) e validar a recusa de um convite para participação de uma Vaquinha (2)." +
            "Pré requisitos:\n" +
            "1- Ter dois clientes NEXT (Administrador e Convidado);\n" +
            "2- Usuário administrador já ter pelo menos uma vaquinha criada;\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA03225 () throws Exception {

        JSONObject dadosVaquinha = recuperarJSSONMassa("vaquinha");

        dadosVaquinha.replace("nomeVaquinha", gerarNomeAleatorio());

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.criarVaquinha(dadosVaquinha, calcularDataRelativaHoje(1));

        vaquinha.convidarAposCriacaoVaquinha(dadosVaquinha, Vaquinha.MENSAGEM_SUCESSO_CRIAR_CONTATO, Vaquinha.MENSAGEM_SUCESSO_ATUALIZAR_CONTATO);

        login.recarregarAppNext();

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(dadosVaquinha.get("favorecidoCpf").toString(), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.selecionarVaquinha(dadosVaquinha.get("nomeVaquinha").toString());

        vaquinha.aceitarVaquinhaDataAgendada(calcularDataRelativaHoje(1), dadosVaquinha);

        vaquinha.enviarComprovanteVaquinhaPorEmail(calcularDataRelativaHoje(1), dadosVaquinha);




    }

}
