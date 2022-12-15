package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesPerfilFunc;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ADESAO)
public class QA03440 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private ConfiguracoesPerfilFunc perfil = new ConfiguracoesPerfilFunc();

    @Test(description = "REG.ADS.01.07.06 - Trocar foto de perfil - Tirar uma foto")
    @Description("Descrição: Trocar foto de perfil - Tirar uma fotoPré-Requisitos:\n" +
                 "Pré-Requisitos: Ter cliente com adesão")
    @Severity(SeverityLevel.NORMAL)

    public void QA3440() throws Exception {

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        perfil.iniciarTrocaFoto();

        perfil.tirarFoto();

        perfil.finalizarTrocaFoto();

    }
}
