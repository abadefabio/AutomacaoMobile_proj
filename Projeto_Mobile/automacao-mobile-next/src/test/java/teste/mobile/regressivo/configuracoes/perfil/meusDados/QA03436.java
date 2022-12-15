package teste.mobile.regressivo.configuracoes.perfil.meusDados;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesPerfilFunc;
import funcionalidade.mobile.configuracoes.perfil.meusDados.EditarDadosFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ADESAO)
public class QA03436 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ConfiguracoesPerfilFunc configuracoesPerfil = new ConfiguracoesPerfilFunc();
    EditarDadosFunc editarDados = new EditarDadosFunc();

    @Test(description = "REG.ADS.01.07.02 - Alterar Dados Cadastrais - Alterar apelido")
    @Description("Pré-Requisitos: Ter cliente com adesão e com apelido")
    @Severity(SeverityLevel.NORMAL)
    public void QA03436() throws Exception {

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        configuracoesPerfil.tocarMeusDados();

        editarDados.editarApelido();
    }
}
