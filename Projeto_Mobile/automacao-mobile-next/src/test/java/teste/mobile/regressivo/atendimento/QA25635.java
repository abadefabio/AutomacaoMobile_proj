package teste.mobile.regressivo.atendimento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.atendimento.AtendimentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.ATENDIMENTO)
public class QA25635 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menuFunc = new MenuFunc();
    private AtendimentoFunc atendimentoFunc = new AtendimentoFunc();

    @Test(description = "PBI.35866.71056.037 - Validar a exibição das 16 perguntas do FAQ.")
    @Description("Pré Requisito de Massa:\n" +
                 "Ter conta next ativa status 4 ou 5")
    @Severity(SeverityLevel.NORMAL)

    public void QA25635() throws Exception{

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarAjuda();

        atendimentoFunc.validarPresencaTemasTelaAjuda();

        menuFunc.validarTelaMenu();


    }

}
