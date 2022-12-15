package teste.mobile.regressivo.recarga;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.recarga.FormaPagamento;

import constantes.recarga.NumerosEOperadoras;
import constantes.recarga.ValorRecarga;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.recarga.RecargaCelularFunc;
import funcionalidade.mobile.recarga.RelacioneOperadoraFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.RECARGA)
public class QA00024 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    RecargaCelularFunc recarga = new RecargaCelularFunc();
    RelacioneOperadoraFunc operadora = new RelacioneOperadoraFunc();

    @Test(description = "REG.REC.00.03 Validar mensagem de exce��o de limite m�ximo de recargas da operadora")
    @Description("Objetivo\n:" +
            "Validar mensagem de exce��o, quando cliente ultrapassa o limite di�rio de recargas para operadora." +
            "Requisitos:" +
            "1) Possuir CPF que possa realizar recarga" +
            "2) Possuir n�mero de telefone e operadora v�lidos" +
            "3) J� ter ultrapassado o valor m�ximo de recargas por dia para a operadora")
    @Severity(SeverityLevel.NORMAL)
    public void QA00024() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarRecarga();

        recarga.preencherDadosRecarga(NumerosEOperadoras.AMAZONIA_DDD_91.dddENumero(), NumerosEOperadoras.AMAZONIA_DDD_91.operadora());

        operadora.realizarRecarga(FormaPagamento.CONTA_CORRENTE, ValorRecarga.SETENTA_E_SETE_REAIS);

        operadora.validarMensagemLimiteRecarga();
    }
}

