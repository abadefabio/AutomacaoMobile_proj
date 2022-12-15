package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.seguros.Protecao;
import constantes.seguros.ParticipantesProtecaoOdonto;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSecaoProtecao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.ProtecaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA00204 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ProtecaoFunc protecao = new ProtecaoFunc();

    @Test(description = "REG.PRO.01.03 - Validar erro na contratação de OdontoPrev na opção \"Pra Mim\"")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar no Menu Next a área de Proteção\n" +
            "E validar erro na contratação de OdontoPrev\n" +
            "E sair da tela de erro clicando no ícone \"X\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA00204() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSeguros();

        protecao.selecionarCardSegurosOdonto();

        protecao.validarCardTelaConfirmacaoDeDadosOdonto(TipoProtecao.ODONTO, TipoSecaoProtecao.INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS, Protecao.SEGUNDO_BOTAO_CONTRATAR_FROM_DETALHES, ParticipantesProtecaoOdonto.PRA_MIM);

        protecao.validarLayoutTelaErro();
        protecao.tocarBotaoX();

        protecao.validarTelaProtecao(TipoProtecao.ODONTO);
    }
}
