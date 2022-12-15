package funcionalidade.mobile.pix;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import javax.swing.text.MaskFormatter;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.pix.Mensagens;
import constantes.pix.TipoChave;
import constantes.pix.TipoConta;
import io.appium.java_client.android.AndroidDriver;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.pix.IncluirChavePixTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.minhas.chaves.MinhasChavesTela;

public class IncluirChavePixFunc extends FuncionalidadeBase {

    /**
     * Realizar aceite do termo de adesao pix
     *
     * @throws Exception
     */
    public void realizarTutorial() throws Exception {
      new IncluirChavePixTela(getDriver())
              .realizarTutorialPix();
   }

    /**
     * Fluxo para realizar o tipo de chave para cadastro onboarding
     *
     * @param tipoChave Tipo de chave a ser selecionada
     * @throws Exception
     */
    public void selecionarTipoDeChave(TipoChave tipoChave) throws Exception {
        new IncluirChavePixTela(getDriver())
                .selecionarChave(tipoChave.toString())
                .tocarBotaoIncluirEstaChave();
    }

    /**
     * Fluxo para realizar o tipo de chave para cadastro onboarding
     *
     * @param tipoConta Tipo de conta a ser selecionada (Corrente ou Poupança)
     * @throws Exception
     */
    public void selecionarTipoDeConta(TipoConta tipoConta) throws Exception {
        new IncluirChavePixTela(getDriver())
                .selecionarTipoConta(tipoConta.toString())
                .tocarBotaoContinuar();
    }

    /**
     * Validar chave incluída com sucesso
     *
     * @throws Exception
     */
    public void validarChaveIncluidaComSucesso() throws Exception {
        new IncluirChavePixTela(getDriver())
                .validarChaveIncluidaComSucesso()
                .clicarBotaoVoltarAoPix();
    }

    /**
     * Validar tela opções menu pix
     *
     * @throws Exception
     */
    public void validarTelaOpcoesMenuPix() throws Exception{
        new IncluirChavePixTela(getDriver())
                .validarTelaOpcoesMenuPix();
    }

    /**
     * Iniciar portabilidade de chave pix
     *
     * @param chave
     * @param origemPagamento
     * @param cpf
     * @throws Exception
     */
    public void iniciarPortabilidadeChave(String chave, String origemPagamento, String cpf) throws Exception {
        MaskFormatter mask = new MaskFormatter("###.###.###-##");
        mask.setValueContainsLiteralCharacters(false);

        new PixTela(getDriver())
                .tocarAbaReceber()
                .tocarBotaoMinhasChaves();
        new MinhasChavesTela(getDriver())
                .tocarBotaoIncluirChave();
        new pagina.mobile.jornadas.pix.minhas.chaves.IncluirChavePixTela(getDriver())
                .selecionarChavePix(chave)
                .tocarBotaoEscolherEstaChave()
                .tocarBotaoOrigemPagamento(origemPagamento)
                .tocarBotaoContinuar();
        if (getDriver() instanceof AndroidDriver) {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(Mensagens.CHAVE_VINCULADA_A_OUTRA_CONTA_ANDROID);
        } else {
            new ValidaMensagensTela(getDriver())
                    .validarTodasAsMensagens(Mensagens.CHAVE_VINCULADA_A_OUTRA_CONTA_IOS);
        }
        new MinhasChavesTela(getDriver())
                .tocarBotaoTrazerParaONext();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(mask.valueToString(cpf))
                .validarTodasAsMensagens(origemPagamento);
        new MinhasChavesTela(getDriver())
                .tocarBotaoIniciarPortabilidade();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Mensagens.SOLICITACAO_PORTABILIDADE_INICIADA);
        if (getDriver() instanceof AndroidDriver) {
            new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(mask.valueToString(cpf));
        }
        new MinhasChavesTela(getDriver())
                .tocarBotaoOK()
                .tocarAbaPendentes();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(mask.valueToString(cpf))
                .validarTodasAsMensagens(Mensagens.CHAVE_CPF_EM_PROCESSAMENTO);
    }
}
