package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.configuracoes.perfil.meusDados.EnderecoResidencialFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento.PerfilTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.MeusDadosTela;


@Jornada(Jornadas.ADESAO)
public class QA25139 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    EnderecoResidencialFunc enderecoResidencialFunc = new EnderecoResidencialFunc();

    @Test(description = "REG.ADS.01.07.04 - Alterar Dados Cadastrais - Alterar endereço de trabalho - Com sucesso")
    @Description("Descrição" +
            "Alterar Dados Cadastrais - Alterar endereço de trabalho - Com sucessoPré-Requisitos: " +
            "Ter cliente com adesão e com informações de endereço de trabalho.")

    @Severity(SeverityLevel.NORMAL)
    public void QA25139() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPerfil();

        enderecoResidencialFunc.editarEnderecoResidencial(recuperarMassa(JSON.CEP), recuperarMassa(JSON.ENDERECO_NUMERO));
    }
}
