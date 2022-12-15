package teste.mobile.regressivo.recarga;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.recarga.RecargaJSON;
import constantes.recarga.SalvarContato;
import constantes.recarga.TipoConta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.recarga.EscolhaValorFunc;
import funcionalidade.mobile.recarga.RecargaCelularFunc;
import funcionalidade.mobile.recarga.ResumoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.RECARGA)
public class QA03174 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private RecargaCelularFunc recargaCelular = new RecargaCelularFunc();
    private EscolhaValorFunc escolhaValor = new EscolhaValorFunc();
    private ResumoFunc resumo = new ResumoFunc();

    @Test(description = "REG.REC.13.02.11 - Validar recarga com Saldo da Conta Corrente Insuficiente")
    @Description("Objetivos: \n" +
            " .")


    @Severity(SeverityLevel.NORMAL)
    public void QA03174() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarRecarga();

        recargaCelular.preencherDadosRecarga(recuperarMassa(JSON.TELEFONE), recuperarMassa(JSON.OPERADORA));

        escolhaValor.selecionarValorRecarga(recuperarMassa(RecargaJSON.VALOR_RECARGA.getValue()));

        resumo.realizarRecargaComSaldoInsuficiente(SalvarContato.SALVAR, recuperarMassa(JSON.NOME), TipoConta.CONTA_CORRENTE);

    }
}
