package teste.mobile.regressivo.investimentos.aplicacao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA02820 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();

    @Test(description = "[v1] Validar apresenta��o da tela de atualiza��o cadastral durante uma aplica��o")
    @Description("Descri��o do cen�rio\n"
            + "COMO Usu�rio do NEXT\n"
            + "QUERO validar a tela de atualiza��o cadastral durante uma aplica��o\n"
            + "PARA que eu possa atualizar meus dados durante a aplica��o caso necess�rio. \n"
            + "\n"
            + "Pr�-Condi��es:\n"
            + "1- Possuir investimentos em algum produto do segmento CDB ou Fundos;\n"
            + "2- Possuir qualquer um desses perfis de investidor: ULTRACONSERVADOR, CONSERVADOR, MODERADO ou DIN�MICO;\n"
            + "3- Possuir uma massa com dados cadastrais DESATUALIZADOS (vide documenta��o de massa no confluence);")
    @Severity(SeverityLevel.NORMAL)
    public void QA02820() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarInvestimentos();

        aplicacao.validarTelaAtualizacaoCadastral(Segmento.FUNDOS, Produto.NEXT_ALOCACAO_DINAMICA);
    }
}
