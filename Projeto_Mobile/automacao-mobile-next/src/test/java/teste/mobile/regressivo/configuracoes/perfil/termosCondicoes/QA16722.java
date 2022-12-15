package teste.mobile.regressivo.configuracoes.perfil.termosCondicoes;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesPerfilFunc;
import funcionalidade.mobile.configuracoes.perfil.termosCondicoes.TermosCondicoesFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PERFIL_CONFIGURACOES)
public class QA16722 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ConfiguracoesPerfilFunc configuracoesPerfil = new ConfiguracoesPerfilFunc();
    TermosCondicoesFunc termosCondicoes = new TermosCondicoesFunc();

    @Test(description = "[Transações Cotidianas] PBI - 86992 Validar consulta do termo em termos e condições")
    @Description("Descrição (Objetivo):\n" +
            "\n" +
            "Consultar termo de contratação débito automático\n" +
            ".\n" +
            "Dados do teste (Massa necessária):\n" +
            "Ter um debito automático contratado\n" +
            "Pré requisitos:\n" +
            "\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Ter um debito automático contratado;\n" +
            "Dependências:\n" +
            "\n" +
            "N/A.")
    @Severity(SeverityLevel.NORMAL)
    public void QA16722() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        configuracoesPerfil.tocarPerfilTermosCondicoes();

        termosCondicoes.validarTermoAdesao();
    }
}
