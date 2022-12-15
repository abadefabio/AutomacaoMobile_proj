package teste.mobile.regressivo.recarga;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.recarga.RecargaJSON;
import constantes.recarga.SalvarContato;
import constantes.recarga.TipoConta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.recarga.EscolhaValorFunc;
import funcionalidade.mobile.recarga.RecargaCelularFunc;
import funcionalidade.mobile.recarga.ResumoFunc;
import funcionalidade.mobile.recarga.confirmacao.ComprovanteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import br.com.next.automacao.core.constantes.massa.JSON;

@Jornada(Jornadas.RECARGA)
public class QA03164 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private RecargaCelularFunc recargaCelular = new RecargaCelularFunc();
    private EscolhaValorFunc escolhaValor = new EscolhaValorFunc();
    private ResumoFunc resumo = new ResumoFunc();
    private ComprovanteFunc comprovante = new ComprovanteFunc();

    @Test(description = "REG.REC.13.02.01 - Primeira Recarga de Celular - salvar o contato - COMPARTILHAR COMPROVANTE")
    @Description("Objetivos: \n" +
            "Validar Primeira Recarga de Celular com opção de salvar o contato Pré requisitos:\n" +
            "1-Possui o App do Next instalado no celular\n" +
            "2-Estar logado na aplicação\n" +
            "3-Possuir Numero telefone válido\n" +
            "4-Sem nenhuma recarga realizada\n" +
            "5-Conta Corrente com Saldo")

    @Severity(SeverityLevel.NORMAL)
    public void QA03164() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarRecarga();

        recargaCelular.exibirRecargasSalvasSemContatosSalvos();

        recargaCelular.preencherDadosRecarga(recuperarMassa(JSON.TELEFONE),recuperarMassa(JSON.OPERADORA));

        escolhaValor.selecionarValorRecarga(recuperarMassa(RecargaJSON.VALOR_RECARGA.getValue()));

        resumo.realizarRecarga(SalvarContato.SALVAR, recuperarMassa(JSON.NOME), TipoConta.CONTA_CORRENTE);

        recargaCelular.validarRecarga();

        menu.validarTelaMenu();

        menu.selecionarRecarga();

        recargaCelular.validarEdicaoTelefoneInvalido(recuperarMassa("telefoneIncorreto"));

    }

}
