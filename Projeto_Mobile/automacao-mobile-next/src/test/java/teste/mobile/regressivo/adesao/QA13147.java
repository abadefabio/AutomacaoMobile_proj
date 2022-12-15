package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesDaConta.ConfiguracoesDaContaFunc;
import funcionalidade.mobile.configuracoes.perfil.meusDados.EnderecoResidencialFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.ADESAO)
public class QA13147 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ConfiguracoesDaContaFunc configuracoesDaContaFunc = new ConfiguracoesDaContaFunc();

    @Test(description = "PBI-115740.006 - Validar que o cliente se encontra na tela 'Conferir Dados Pessoais' ao conferir as informa��es dos dados pessoais e clicar em 'Quero Encerrar Conta'")
    @Description("Descri��o: Validar que o cliente se encontra na tela 'Conferir Dados Pessoais'' ao conferir as informa��es dos dados pessoais e clicar em 'Quero Encerrar Conta' Pr� Requisito:" +
                        "1- Ter acesso ao app Next" +
                        "2- Possuir CPF v�lido e est� na tela de 'Confirma��o de encerramento'")

    @Severity(SeverityLevel.NORMAL)
    public void QA13147() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPerfil();

        configuracoesDaContaFunc.encerrarContaNext();
    }
}
