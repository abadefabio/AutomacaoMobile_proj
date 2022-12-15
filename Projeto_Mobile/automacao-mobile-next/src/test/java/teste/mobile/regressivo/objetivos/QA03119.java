package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import constantes.objetivos.TipoObjetivo;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ExcluirObjetivoFunc;
import funcionalidade.mobile.objetivos.NovoObjetivoFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

@Jornada(Jornadas.OBJETIVOS)
public class QA03119 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    NovoObjetivoFunc novoObjetivo = new NovoObjetivoFunc();


    @Test(description = "REG.OBJ.09.01.07 - Validar caracteres especiais na primeira criação de objetivo sem perfil investidor com produto next SIMPLES - CRIAR OBJETIVO")
    @Description("Validar criação de objetivos com desenquadramento de perfil - Continuar criaçãoPré-Requisitos:\n" +
            "\n" +
            "CPF e senha Válidos\n")

    @Severity(SeverityLevel.NORMAL)
    public void QA03119() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        novoObjetivo.selecionarTipoObjetivo(TipoObjetivo.TIPO_OBJETIVO_CASA);

        novoObjetivo.preencherNomeObjetivoCaracterEspecial(MensagensObjetivos.MENSAGEM_DE_NOME_OBJETIVO,recuperarMassa("nomeCaracteresEspeciais"),MensagensObjetivos.ALERTA_CARACTER_INVALIDO);

        String valor = String.valueOf(numeroAleatorio(10000,50000));

        novoObjetivo.efetuarCadastroNovoObjetivo(recuperarMassa("nomeObjetivo"),MensagensObjetivos.MENSAGEM_QUANTO_PRECISA,valor,TipoObjetivo.TIPO_OBJETIVO_CASA.toString());

    }

    @AfterMethod
    public void deletarObjetivo() throws Exception {
        new ExcluirObjetivoFunc()
                .excluirObjetivoNaTelaDetalhes();
    }
}
