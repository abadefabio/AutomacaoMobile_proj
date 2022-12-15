package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.configuracoes.perfil.Mensagens;
import constantes.configuracoes.perfil.Teimosinha;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesPerfilFunc;
import funcionalidade.mobile.configuracoes.perfil.configuracoes.pagamento.ConfiguracoesPagamentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ADESAO)
public class QA03544 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ConfiguracoesPerfilFunc perfil = new ConfiguracoesPerfilFunc();



    @Test(description = "REG.ADS.01.08.11 - Alterar senha do app atraves do menu configurações")
    @Description("Validar alteração de senhaPré-Condições: Cliente ativo.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03544() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        perfil.tocarPerfilConfiguracoesAPP();

        perfil.trocarSenhaDoApp(recuperarMassa(JSON.SENHA),recuperarMassa("novaSenha"), recuperarMassa("confirmarSenha"));

    }
}
