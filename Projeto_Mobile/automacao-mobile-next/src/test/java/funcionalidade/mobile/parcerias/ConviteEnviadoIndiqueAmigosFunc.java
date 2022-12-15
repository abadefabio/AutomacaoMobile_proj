package funcionalidade.mobile.parcerias;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import constantes.parcerias.ConviteIndiqueAmigos;
import pagina.mobile.jornadas.parcerias.ConviteEnviadoIndiqueAmigosTela;
import pagina.mobile.comum.next.PopUpTela;

public class ConviteEnviadoIndiqueAmigosFunc extends FuncionalidadeBase {

    /**
     * Valida se mensagem exibida ao concluir convite de amigo é igual a mensagem enviada.
     * Além disso caso desejado convida mais amigos ou encerra o processo
     *
     * @param conviteIndiqueAmigos - Enum contendo a mensagem esperada e a decisão de indicari mais amigos ou não
     * @throws Exception
     */
    public void validarConviteEnviado(ConviteIndiqueAmigos conviteIndiqueAmigos) throws Exception {
        switch (conviteIndiqueAmigos.retornaQuantidadeAmigos()) {
            case APENAS_UM:

                switch (conviteIndiqueAmigos) {

                    case CONVITE_ENVIADO_APENAS_UM:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemConviteEnviado()
                                .tocarBotaoOK();
                        break;
                    default:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemEsperada(conviteIndiqueAmigos)
                                .tocarBotaoOK();
                }
                break;

            case MAIS_AMIGOS:
                switch (conviteIndiqueAmigos) {
                    case CONVITE_ENVIADO_MAIS_AMIGOS:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemConviteEnviado()
                                .tocarBotaoIndicarNovoAmigo();
                        break;
                    default:
                        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                                .validarMensagemEsperada(conviteIndiqueAmigos)
                                .tocarBotaoOK();
                }
        }
    }

    /**
     * Validar mensagem exibida em PopUp número máximo de indicações
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemPopUpIndicacoesUltrapassadas(Enum mensagem) throws Exception {
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
    }

    /**
     * Validar mensagem exibida em PopUp número máximo de indicações
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemProximaDataIndicacao(Enum mensagem) throws Exception {
        new PopUpTela(getDriver())
                .validarMensagem(mensagem.toString())
                .tocarBotaoOk();
    }

    /**
     * Validar mensagem exibida em PopUp
     *
     * @param mensagem
     * @throws Exception
     */
    public void validarMensagemEsperada(Enum mensagem) throws Exception {
        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                .validarMensagemEsperada(mensagem);
    }

    /**
     * Tocar Botao OK
     *
     * @throws Exception
     */
    public void tocarBotaoOK() throws Exception {
        new ConviteEnviadoIndiqueAmigosTela(getDriver())
                .tocarBotaoOK();
    }
}
