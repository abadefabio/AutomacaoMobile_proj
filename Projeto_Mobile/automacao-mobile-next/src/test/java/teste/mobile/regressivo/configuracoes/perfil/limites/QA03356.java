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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.LIMITES)
public class QA03356 extends TesteBase {

    LoginFunc login = new LoginFunc();
    ConfiguracoesPerfilFunc perfil = new ConfiguracoesPerfilFunc();
    ConfiguracoesPagamentoFunc configuracaopagamento = new ConfiguracoesPagamentoFunc();


    @Test(description = "REG.LIM.07.07.13 - Validar alteração de op-tins para usar teimosinha e grana de emergência, quando apenas teimosinha vier selecionada")
    @Description("Validar alteração de op-tins para usar teimosinha e grana de emergencia. Tocar no Aplicativo next no dispositivo.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03356() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        perfil.tocarPerfilConfiguracoesPagamento();

        configuracaopagamento.alterarConfiguracaoPagamentoUsarGranaEmergencia(Mensagens.MENSAGEM_CONFIGURACAO_PAGAMENTO_ATUALIZADA, Teimosinha.REPETIR_TENTATIVAS_DEBITO_AUTOMATICO_SELECIONAR, Teimosinha.GRANA_DE_EMERGENCIA, recuperarMassa("saldoDevedorProcurado"));

    }

}
