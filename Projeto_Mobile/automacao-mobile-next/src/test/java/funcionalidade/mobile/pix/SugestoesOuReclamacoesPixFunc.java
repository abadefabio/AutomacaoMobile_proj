package funcionalidade.mobile.pix;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import constantes.pix.CentralRelacionamento;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.mais.opcoes.MaisOpcoesTela;

public class SugestoesOuReclamacoesPixFunc {

    /**
     * Validar texto do Banco Central na tela Canal de Atendimento
     *
     * @throws Exception
     */
    public void validarTextoBancoCentralNaTelaCentralAtendimento() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarSugestoesOuReclamacoesPix();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(CentralRelacionamento.TEXTO_BANCO_CENTRAL);
    }
}
