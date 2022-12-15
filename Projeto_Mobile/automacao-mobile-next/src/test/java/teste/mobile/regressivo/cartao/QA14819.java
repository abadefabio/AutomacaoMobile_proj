package teste.mobile.regressivo.cartao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.cartao.cancelamento.CancelarCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA14819  extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();

    CancelarCartaoFunc cancelarCartao = new CancelarCartaoFunc();


    @Test(description = "PBI.149565.129664.001 - Validar Cart�o Credito - Danificado Em uso e endere�o atual")
    @Description("Cancelamento por danificado usando o mesmo endere�o cliente poder� acompanhar o rastreio do cart�o de credito - Possuir o aplicativo do Next instalado no celular\n" +
            "*Ter conta NEXT\n" +
            "*Possuir o Cart�o Next\n" +
            "*Ter a fun��o Cr�dito\n" +
            "*Ter fun��o cr�dito ativo\n" +
            "*Estar logado no app no menu principal")

    @Severity(SeverityLevel.NORMAL)
    public void QA14819 () throws Exception{

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuFunc.selecionarCartao();

        cancelarCartao.cancelarCartaoDanificadoComSegundaViaEmEnderecoAtual();

    }

}
