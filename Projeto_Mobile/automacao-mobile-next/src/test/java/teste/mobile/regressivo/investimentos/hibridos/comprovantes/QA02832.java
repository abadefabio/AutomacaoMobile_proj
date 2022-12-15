package teste.mobile.regressivo.investimentos.hibridos.comprovantes;

import org.testng.annotations.Test;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.Produto;
import constantes.investimentos.ValidarInformacoesComprovante;
import constantes.investimentos.Valor;
import constantes.web.JSONWebMail;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ComprovantePoupancaFunc;
import funcionalidade.mobile.investimentos.resgate.ResgateFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.web.email.EmailWebFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA02832 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    EmailWebFunc emailWeb = new EmailWebFunc();
    private final ThreadLocal<String> saldoPoupanca = new ThreadLocal<>();

    @Test(description = "[v1] Validar o envio de comprovante por e-mail de um resgate realizado em Poupança")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO poder realizar o resgate de uma aplicação em Poupança\n"
            + "PARA que eu possa compartilhar o comprovante por e-mail \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next\n"
            + "3- Possuir um investimento com aplicação em Poupança que possa ser resgatado;\n"
            + "4- Possuir acesso ao email para validação do recibo;")
    @Severity(SeverityLevel.NORMAL)
    public void QA02832() throws Exception {

        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_DUZENTOS_E_CINQUENTA.toString());

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuFunc.selecionarPoupanca();

        resgate.realizarResgateParcialMenuPoupanca(valor, saldoPoupanca);

        comprovante.validarComprovante(
                true,
                valor,
                ValidarInformacoesComprovante.RESGATE,
                Produto.NEXT_POUPANCA,
                MobileUtils.retornaSubtracaoValoresMonetarios(saldoPoupanca.get(), valor)
        );

        emailWeb.recuperarComprovanteResgatePoupanca(
                recuperarMassa(JSONWebMail.DOMINIO_USUARIO_EMAIL.getValue()),
                recuperarMassa(JSONWebMail.SENHA_EMAIL.getValue()));
    }
}
