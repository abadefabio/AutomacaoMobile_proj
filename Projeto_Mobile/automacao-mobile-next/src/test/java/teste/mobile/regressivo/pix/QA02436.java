package teste.mobile.regressivo.pix;

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

@Jornada(Jornadas.PIX)
public class QA02436 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ConfiguracoesPerfilFunc configuracoesPerfil = new ConfiguracoesPerfilFunc();
    TermosCondicoesFunc termosCondicoes = new TermosCondicoesFunc();


    @Test(description = "REG.PIX.21.07.01 - Validar a opção PIX na tela TERMOS E CONDIÇÕES para cliente que possua chave cadastrada no Pix")
    @Description("Objetivos: \n" +
            "Eu enquanto CLIENTE NEXT com chave cadastrada no Pix, quero poder visualizar o TERMO DE CONSENTIMENTO.\n" +
            "Pré-Requisitos:\n" +
            "1. Cliente deve estar logado na tela principal do Next\n" +
            "2. NÃO deve ser o primeiro acesso do cliente" +
            "3. Cliente deve possuir chave cadastrada no Pix")

    @Severity(SeverityLevel.NORMAL)
    public void QA02436() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        configuracoesPerfil.tocarPerfilTermosCondicoes();

        termosCondicoes.validarTermosCondicoesNextPix();
    }

}
