package teste.mobile.regressivo.investimentos.hibridos.comprovantes;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.comprovantes.TituloTela;
import funcionalidade.mobile.comprovantes.ComprovantesExtratosFunc;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.comprovantes.ComprovantesInvestimentosFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA02840 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ComprovantesExtratosFunc comprovantesExtratos = new ComprovantesExtratosFunc();
    ComprovantesInvestimentosFunc comprovantesInvestimentos = new ComprovantesInvestimentosFunc();
    ComprovantesFunc comprovantes = new ComprovantesFunc();

    @Test(description = "[v1] Validar a consulta do extrato e compartilhamento por email pelo menu Comprovantes")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO poder consultar o extrato de movimentações nas minha aplicações\n"
            + "PARA que eu possa compartilhar o comprovante por e-mail \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next\n"
            + "3- Possuir movimentação de investimentos em aplicações CDB ou Fundos;\n"
            + "4- Possuir acesso ao email para validação do recibo;")
    @Severity(SeverityLevel.NORMAL)
    public void QA02840() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarComprovantes();

        comprovantesExtratos.menuInvestimentos();

        comprovantesInvestimentos.visualizarDetalhes(TituloTela.INVESTIMENTO_NEXT_CDB);

        comprovantesInvestimentos.enviarPorEmail();

        comprovantes.validarRecebimentoComprovanteNoEmail(recuperarMassa("dominioUsuarioEmail"), recuperarMassa("senhaEmail"));
    }
}
