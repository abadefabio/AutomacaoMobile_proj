package teste.mobile.regressivo.configuracoes.perfil.limites;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.configuracoes.perfil.Mensagens;
import constantes.configuracoes.perfil.Teimosinha;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesPerfilFunc;
import funcionalidade.mobile.configuracoes.perfil.configuracoes.pagamento.ConfiguracoesPagamentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.LIMITES)
public class QA03360 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ConfiguracoesPerfilFunc perfil = new ConfiguracoesPerfilFunc();
    ConfiguracoesPagamentoFunc configuracaopagamento = new ConfiguracoesPagamentoFunc();


    @Test(description = "REG.LIM.07.07.17 - Validar alteração de op-tins para NÃO usar teimosinha, quando teimosinha vier selecionada")
    @Description("Validar alteração de op-tins para NÃO usar teimosinha, quando teimosinha vier selecionada")

    @Severity(SeverityLevel.NORMAL)
    public void QA03360() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        perfil.tocarPerfilConfiguracoesPagamento();

        configuracaopagamento.alterarConfiguracaoPagamento(Mensagens.MENSAGEM_CONFIGURACAO_PAGAMENTO_ATUALIZADA, Teimosinha.REPETIR_TENTATIVAS_DEBITO_AUTOMATICO_SELECIONADO, recuperarMassa("saldoDevedorProcurado"));

    }

}
