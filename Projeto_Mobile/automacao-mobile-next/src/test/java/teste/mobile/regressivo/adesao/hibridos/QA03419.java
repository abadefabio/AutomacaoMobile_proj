package teste.mobile.regressivo.adesao.hibridos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.web.JSONWebMail;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ADESAO)
public class QA03419 extends TesteBase {

    private LoginFunc login = new LoginFunc();

    @Test(description = "REG.ADS.01.04.01 - Realizar troca de device via email, usuário que não tenha mais acesso ao device que já fora cadastrado.")
    @Description("Descrição (Objetivo):\n" +
            "Efetuar a troca de device com sucesso;\n" +
            "Pré-Requisitos:\n" +
            "Adesão next aprovada e utilizada e, outro device;\n" +
            "Acesso a caixa de e-mail de teste;\n" +
            "Baixar o risco para o cpf não cair no Chat (Solicitar ao LC)")
    @Severity(SeverityLevel.NORMAL)

    public void QA03419() throws Exception {

        login.efetuarLoginComTrocaDeDevice(
                recuperarMassa(JSON.CPF),
                recuperarMassa(JSON.SENHA),
                recuperarMassa(JSONWebMail.DOMINIO_USUARIO_EMAIL.getValue()),
                recuperarMassa(JSONWebMail.SENHA_EMAIL.getValue()));
    }
}
