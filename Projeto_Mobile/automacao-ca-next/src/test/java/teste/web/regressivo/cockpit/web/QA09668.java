package teste.web.regressivo.cockpit.web;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.web.cockpit.atendimento.ConsultaDocumentosFunc;
import funcionalidade.web.cockpit.login.LoginWebFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA09668 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    LoginWebFunc loginWebFunc = new LoginWebFunc();
    ConsultaDocumentosFunc consultaDocumentosFunc = new ConsultaDocumentosFunc();

    @Test(description = "Validar funcionalidade de consulta dos dados cadastrais - Cliente Next Representante")
    @Description("Objetivo: Validar funcionalidade de consulta de dados cadastrais dos clientes Next representante\n" +
            "\n" +
            "Pr�-requisito: Possuir um cliente Next representante ativo")
    @Severity(SeverityLevel.NORMAL)

    public void QA09668() throws Exception {

        loginFunc.obterToken(recuperarMassa(JSON.CPF));

        loginWebFunc.realizarLoginEmuladorTPA(recuperarMassa("funcionalidade"), recuperarMassa("esteira"), loginFunc.getToken());

        consultaDocumentosFunc.validarCamposAbaDadadosCadastrais();

        consultaDocumentosFunc.validarCamposAbaContato();

        consultaDocumentosFunc.validarCamposAbaContaNext();

        consultaDocumentosFunc.validarCamposAbaDocumentos();

        loginFunc.logoffToken(recuperarMassa(JSON.CPF));

    }
}
