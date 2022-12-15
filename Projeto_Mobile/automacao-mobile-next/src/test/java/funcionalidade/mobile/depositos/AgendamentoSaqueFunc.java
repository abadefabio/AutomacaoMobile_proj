package funcionalidade.mobile.depositos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.depositos.saques.DepositosSaques;
import constantes.depositos.saques.TipoSaque;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.CalendarioTela;
import pagina.mobile.jornadas.depositos.BeneficiarioSaqueTela;
import pagina.mobile.jornadas.depositos.CepTela;
import pagina.mobile.jornadas.depositos.CodigoAgenciaTela;
import pagina.mobile.jornadas.depositos.ComprovanteTela;
import pagina.mobile.jornadas.depositos.ConferenciaTela;
import pagina.mobile.jornadas.depositos.DataSaqueTela;
import pagina.mobile.jornadas.depositos.InformacaoSaqueTela;
import pagina.mobile.jornadas.depositos.ValorSaqueTela;
import pagina.mobile.comum.next.PopUpTela;

public class AgendamentoSaqueFunc extends FuncionalidadeBase {
    /**
     * Fecha Comprovante
     *
     * @throws Exception
     */
    public void fechaComprovante() throws Exception {
        new ComprovanteTela(getDriver())
                .tocarBotaoFechar();
    }

    /**
     * Preenche o valor do saque com os valores mínimo e máximo validando mensagem de erro
     *
     * @throws Exception
     */
    public void preencherValorSaqueMinMaxEValidarMensagens() throws Exception {
        new ValorSaqueTela(getDriver())
                .escreverValorSaque(DepositosSaques.VALOR_MINIMO.toString())
                .validarMensagemValorMinSaq()
                .escreverValorSaque(DepositosSaques.VALOR_MAXIMO.toString())
                .validarMensagemValorMaxSaq();
    }

    /**
     * Preenche o valor do saque com o valor determinado e continua para próximo passo
     *
     * @throws Exception
     */
    public void preencherValorSaque() throws Exception {
        new ValorSaqueTela(getDriver())
                .escreverValorSaque(DepositosSaques.VALOR.toString())
                .verificarBotaoContinuarTelaValorHabilitado();
    }

    /**
     * Abre a tela de informações sobre agendamento de saque e fecha a mesma tela
     * e continua para próximo passo se android, porque no iOS o continuar
     * já acontece sem precisar clicar no botão continuar
     *
     * @throws Exception
     */
    public void verificarInformacoesEContinuarSeAndroid() throws Exception {
        new ValorSaqueTela(getDriver())
                .tocarBotaoInformacao();
        new InformacaoSaqueTela(getDriver())
                .validarMensagemInformacao()
                .tocarBotaoVoltar();
        if (getDriver() instanceof AndroidDriver) {
            new ValorSaqueTela(getDriver())
                    .tocarBotaoContinuarAgendamento();
        }
    }

    /**
     * Preenche a data com a data do proximo dia util para saque e continua para próximo passo
     *
     * @throws Exception
     */
    public void preencherDataDoDia() throws Exception {
        new DataSaqueTela(getDriver())
                .tocarBotaoData();
        if(getDriver() instanceof AndroidDriver) {
            new CalendarioTela(getDriver())
                    .selecionarData(false, proximoDiaUtil(1));
        }
        new CalendarioTela(getDriver())
                .tocarBotaoConfirmar();
        new DataSaqueTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Informa o tipo de beneficiário do saque e continua para próximo passo
     *
     * @throws Exception
     */
    public void informarBeneficiario(TipoSaque tipo, String cpfcnpjBeneficiario) throws Exception {
        switch (tipo) {
            case PROPRIO:
                new BeneficiarioSaqueTela(getDriver())
                        .selecionarOpcaoProprio();
                break;
            default:
                new BeneficiarioSaqueTela(getDriver())
                        .tocarOutroBeneficiario()
                        .tocarCampoBeneficiario()
                        .preencherCampoCpfCnpjBeneficiario(cpfcnpjBeneficiario)
                        .tocarBotaoApply();

        }
        new BeneficiarioSaqueTela(getDriver())
                .tocarBotaoContinuar();
    }

    /**
     * Informa o CEP da agência para agendamento do saque e continua para próximo passo
     *
     * @throws Exception
     */
    public void informarCep() throws Exception {
        new CepTela(getDriver())
                .tocarBotaoCep()
                .escreverCep();
        if (getDriver() instanceof AndroidDriver) {
            new CepTela(getDriver())
                    .tocarBotaoConfirmarCantoSuperior();
        }
    }

    /**
     * Informa a agência para agendamento do saque e continua para próximo passo
     *
     * @throws Exception
     */
    public void informarAgencia() throws Exception {
        new CodigoAgenciaTela(getDriver())
                .selecionarAgencia()
                .tocarBotaoCodigoAgencia()
                .inserirCodigoAgencia(DepositosSaques.AGENCIA.toString())
                .tocarBotaoApply()
                .tocarBotaoContinuarAgendamento();
    }

    /**
     * Editar data para dia util/feriado
     *
     * @throws Exception
     */
    public void editarData(boolean diaUtil) throws Exception {
        new ConferenciaTela(getDriver())
                .tocarBotaoEditarData();
        new DataSaqueTela(getDriver())
                .tocarBotaoDataEdicao();
        new CalendarioTela(getDriver())
                .selecionarData(!diaUtil, null)
                .tocarBotaoConfirmar();
        new DataSaqueTela(getDriver())
                .tocarBotaoContinuarAgendamento();
    }

    /**
     * Tocar no botão tudo certo e esperar mensagem esperada
     *
     * @throws Exception
     */
    public void confirmarAgendamento(DepositosSaques mensagemEsperada) throws Exception {
        new ConferenciaTela(getDriver())
                .tocarBotaoTudoCerto();
        new PopUpTela(getDriver())
                .validarMensagem(mensagemEsperada.toString())
                .tocarBotaoOk();
    }
}
