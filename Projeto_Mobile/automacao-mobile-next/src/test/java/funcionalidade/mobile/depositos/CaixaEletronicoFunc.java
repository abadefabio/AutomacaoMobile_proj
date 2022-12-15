package funcionalidade.mobile.depositos;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.depositos.BuscaCepTela;
import pagina.mobile.jornadas.depositos.CaixaEletronicoTela;
import pagina.mobile.jornadas.depositos.CodigoAgenciaTela;
import pagina.mobile.jornadas.depositos.DepositosSaquesTela;
import pagina.mobile.jornadas.depositos.TransferirBradescoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CaixaEletronicoFunc extends FuncionalidadeBase {

    /**
     * Abre a opção de Caixa Eletrônico, clica em 'Procurar Caixa Eletronico' e confirma o Popup inicial
     *
     * @throws Exception
     */
    public void iniciarProcuraCaixaEletronico() throws Exception {
        new DepositosSaquesTela(getDriver())
                .tocarBotaoCaixaEletronico();
        new CaixaEletronicoTela(getDriver())
                .tocarBotaoProcurarCaixaEletronico();
        new CaixaEletronicoTela(getDriver())
                .tocarBotaoOk();
    }

    /**
     * Clicar em 'Ver Detalhes', clica em ir para App Brandesco validando se o app foi aberto
     *
     * @throws Exception
     */
    public void abrirAppBradescoNosDetalhes() throws Exception {
        new CaixaEletronicoTela(getDriver())
                .tocarBotaoDetalhes();
        new TransferirBradescoTela(getDriver())
                .tocarBotaoIrAppBradesco();
        new TransferirBradescoTela(getDriver())
                .validarAppBradesco();
    }

    /**
     * Método para buscar o Estado e a Cidade
     *
     * @throws Exception
     */
    public void buscarEstadoECidade() throws Exception {
        new CaixaEletronicoTela(getDriver())
                .tocarBotaoLupa();
        new BuscaCepTela(getDriver())
                .tocarBotaoEstadoECidade()
                .tocarBotaoEstado()
                .selecionarEstado()
                .tocarBotaoCidade()
                .selecionarCidade()
                .tocarBotaoConfirmar();
    }

    /**
     * Método para buscar código da agência
     *
     * @param agencia via Json
     * @throws Exception
     */

    public void buscarCodigoAgencia(String agencia) throws Exception {
        new CodigoAgenciaTela(getDriver())
                .tocarBotaoCodigoAgencia()
                .preencherCodigoAgencia(agencia)
                .tocarBotaoConfirmar();

    }
}
