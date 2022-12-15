package teste.mobile.regressivo.open.finance;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.open.finance.OpenFinanceFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.OPEN_FINANCE)
public class QA07383 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    OpenFinanceFunc tutorial = new OpenFinanceFunc();



    @Test(description = "PBI.73293.75968.004- Solicitar TODOS OS DADOS de outra instituicão.")
    @Description("Eu como gestor Next\n" +
            "Desejo uma tratativa para clientes referente a receptação de dados de uma ou mais instituições.1. Acesso à Internet;\n" +
            "2. Ter o APP NEXT instalado no celular;\n" +
            "3. Ter conta no NEXT;\n" +
            "4. Ter conta em outra instituição;\n" +
            "5. Não ter consentimentos recebidos e enviados nesta conta;\n" +
            "6. Ter Cartão de crédito;\n" +
            "7.Ter Operações de crédito;")

    @Severity(SeverityLevel.NORMAL)
    public void QA07383() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarOpenFinance();

        tutorial.validarTelaPrimeiroAcessoJornadaOpenFinance();

        tutorial.escolherInstituicao();

        tutorial.escolherDados();

        login.reefetuarLoginUsuario(recuperarMassa(JSON.SENHA));

        login.verificarTelaLoginJaLogado();

        tutorial.confirmarCompartilhamentoDados(recuperarMassa(JSON.CPF));


    }
}
