package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.ChavesPix;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.ExcluirChavePixFunc;
import funcionalidade.mobile.pix.MinhasChavesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA02426 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MinhasChavesFunc minhasChaves = new MinhasChavesFunc();
    ExcluirChavePixFunc excluirChavePix = new ExcluirChavePixFunc();

    @Test(description = "REG.PIX.21.03.06 - Compartilhar e Excluir Chave - Email")
    @Description("Pré-Condições:\n" +
            "\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter uma conta next;\n" +
            "Cliente estar logado no APP.\n" +
            "Ter chave Email cadastrada.\n" +
            "Ter mais de uma chave Pix cadastrada")
    @Severity(SeverityLevel.NORMAL)
    public void QA02426() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        minhasChaves.validarCompartilhamentoDeChave(ChavesPix.CHAVE_EMAIL_CONTA_CORRENTE.toString());

        excluirChavePix.excluirChavePix(ChavesPix.CHAVE_EMAIL_CONTA_CORRENTE.toString(), true);

        excluirChavePix.validarExclusaoDeChave(ChavesPix.CHAVE_EMAIL_CONTA_CORRENTE.toString());
    }
}
