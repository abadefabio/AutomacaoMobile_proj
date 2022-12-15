package teste.mobile.regressivo.pix;

import javax.swing.text.MaskFormatter;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.ChavesPix;
import constantes.pix.TipoConta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.ExcluirChavePixFunc;
import funcionalidade.mobile.pix.IncluirChavePixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA02437 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    IncluirChavePixFunc incluirChavePix = new IncluirChavePixFunc();
    ExcluirChavePixFunc excluirChavePix = new ExcluirChavePixFunc();

    @Test(description = "REG.PIX.21.05.01 - Iniciar Portabilidade Chave CPF - Sucesso - Status Em processamento")
    @Description("Description\n"
            + "Possuir o aplicativo do Next instalado no celular;\n"
            + "Ter uma conta next;\n"
            + "Cliente estar logado no APP.\n"
            + "Ter chave do tipo \"CPF\" para solicitar portabilidade.\n"
            + "Pré-Requisito:\n"
            + "\n"
            + "Possuir o aplicativo do Next instalado no celular;\n"
            + "Ter uma conta next;\n"
            + "Cliente estar logado no APP.\n"
            + "Ter chave do tipo \"CPF\" para solicitar portabilidade.")

    @Severity(SeverityLevel.NORMAL)
    public void QA02437() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPix();
        incluirChavePix.iniciarPortabilidadeChave(
                ChavesPix.CPF.toString(),
                TipoConta.CONTA_CORRENTE.toString(),
                recuperarMassa(JSON.CPF));
    }

    @AfterMethod
    public void excluirChavePix(ITestResult result) throws Exception {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");
        mask.setValueContainsLiteralCharacters(false);

        if(result.isSuccess()) {
            excluirChavePix.excluirChavePix(mask.valueToString(recuperarMassa(JSON.CPF)), false);
        }
    }
}
