package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.MensagensObjetivos;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.NovoObjetivoFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.objetivos.TipoObjetivo.TIPO_OBJETIVO_PRODUTO;
import static constantes.transferencia.ValorTransferencia.VALOR_ALEATORIO_ATE_5000;

@Jornada(Jornadas.OBJETIVOS)
public class QA03122 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();

    ComprovantesFunc comprovante = new ComprovantesFunc();
    DescobrindoPerfilFunc perfil = new DescobrindoPerfilFunc();
    NovoObjetivoFunc novoObjetivo = new NovoObjetivoFunc();

    @Test(description = "REG.OBJ.09.01.10 - Validar primeira criação de objetivo  sem perfil investidor com produto next MULTI-ÍNDICES - TELA COM EXCLAMAÇÃO - CONTINUAR CRIAÇÃO")
    @Description("1 - Realizar o primeiro acesso a jornada de objetivos:\n" +
            "SEM POSSUIR PERFIL DE INVESTIDOR , SEM POSSUIR OBJETIVOS CRIADO\n" +
            "2 - Criar um objetivo com o produto next MULTI-ÍNDICES\n" +
            "3 - Na tela verde com desenho da EXCLAMAÇÃO selecionar a opção CONTINUAR CRIAÇÃO")

    @Severity(SeverityLevel.NORMAL)
    public void QA03122() throws Exception {

        login.efetuarLoginUsuarioPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuFunc.selecionarObjetivos();

        objetivosFunc.acessarDetalhes();

        novoObjetivo.selecionarTipoObjetivo(TIPO_OBJETIVO_PRODUTO);

        novoObjetivo.criarObjetivoMultiIndices(recuperarMassa("nomeObjetivo"), MensagensObjetivos.MENSAGEM_QUANTO_PRECISA,VALOR_ALEATORIO_ATE_5000.toString(), TIPO_OBJETIVO_PRODUTO.toString());
    }
}
