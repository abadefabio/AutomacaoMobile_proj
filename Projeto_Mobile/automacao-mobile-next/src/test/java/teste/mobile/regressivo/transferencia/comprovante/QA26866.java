package teste.mobile.regressivo.transferencia.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.comprovantes.ConsultaServico;
import constantes.comprovantes.ConsultaTransacao;
import funcionalidade.mobile.comprovantes.ComprovantesExtratosFunc;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.TRANSFERENCIA)
public class QA26866 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ComprovantesFunc comprovantesFunc = new ComprovantesFunc();
    private ComprovantesExtratosFunc comprovantesExtratosFunc = new ComprovantesExtratosFunc();

    @Test(description = "REG.TRF.15.08.04 - Compartilhar a 2ª via do comprovante da transferência bancária - Outra Pessoa - [Next - CP] para [Next - CP]")
    @Description("Descrição (Objetivo):\n" +
            "Compartilhar a 2ª via do comprovante da transferência bancária - Outra Pessoa - [Next - CP] para [Next - CP]" +
            "Pré requisitos:\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato cadastrado para realizar transferência;\n")


    @Severity(SeverityLevel.NORMAL)
    public void QA26866() throws Exception {


        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.validarTelaMenu();

        menu.selecionarComprovantes();

        comprovantesExtratosFunc.menuComprovantes();

        comprovantesFunc.consultaComprovante(ConsultaServico.TRANSFERENCIAS, ConsultaTransacao.TRANSFERENCIA_BANCARIA, recuperarMassa("dataInicialComprovante"), recuperarMassa("dataFinalComprovante"));

        comprovantesFunc.compartilharComprovanteTransferencia();
    }
}
