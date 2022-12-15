package teste.mobile.regressivo.pix;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.pix.MinhasChaves;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.MinhasChavesFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.PIX)
public class QA11853 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MinhasChavesFunc minhasChaves = new MinhasChavesFunc();

    @Test(description = "PB.1070.US.75881.004 - Validar compartilhamento de Chave aleatória vinculada a Conta Poupança")
    @Description("Eu enquanto Cliente NEXT quero incluir uma chave aleatória sem apelido na tela do APP NEXT para compartilhar a chave gerada possibilitando o recebimento de transferências com o uso dessa chave aleatória.Objetivo:\n"
            + "Validar compartilhamento de Chave aleatória vinculada a Conta Poupança\n"
            + "\n"
            + "Dados do teste (Massa necessária):\n"
            + "\n"
            + "Nenhum requisito\n"
            + "Pré requisitos:\n"
            + "\n"
            + "Usuário deve estar logado no menu Next;\n"
            + "Possuir massa de dados que já tenha chave aleatória cadastrada e vinculada a conta-poupança.\n"
            + "Referência:\n"
            + "Código Jira: NEXT2-75881 - UserStory: US 01 - Alterar exibição da chave aleatória em Minhas Chaves")

    @Severity(SeverityLevel.NORMAL)
    public void QA11853() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        minhasChaves.validarCompartilhamentoDeChave(MinhasChaves.CHAVE_ALEATORIA_CONTA_POUPANCA.toString());
    }
}
