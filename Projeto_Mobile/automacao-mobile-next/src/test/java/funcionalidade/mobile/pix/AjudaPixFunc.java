package funcionalidade.mobile.pix;

import pagina.mobile.jornadas.pix.mais.opcoes.AjudaPixTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.mais.opcoes.MaisOpcoesTela;


import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class AjudaPixFunc {

    /**
     * Validar apresentação das perguntas e respostas
     *
     * @throws Exception
     */
    public void validarApresentacaoPerguntasRespostas() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoMaisOpcoes();
        new MaisOpcoesTela(getDriver())
                .tocarBotaoAjudaPix();
        new AjudaPixTela(getDriver())
                .tocarBotaoOQueEPix()
                .validarPerguntaOQueEPix()
                .tocarBotaoOQueEPix()

                .tocarBotaoOQueEChavePix()
                .validarPerguntaOQueEChavePix()
                .tocarBotaoOQueEChavePix()

                .tocarBotaoComoFuncionaPix()
                .validarPerguntaComoFuncionaPix()
                .tocarBotaoComoFuncionaPix()

                .tocarQuaisBeneficiosDoPix()
                .validarPerguntaQuaisBeneficiosDoPix()
                .tocarQuaisBeneficiosDoPix()

                .tocarSouObrigadoAderirAoPix()
                .validarPerguntaSouObrigadoAderirAoPix()
                .tocarSouObrigadoAderirAoPix()

                .tocarPrecisoDaChaveParaUsarPix()
                .validarPerguntaPrecisoDaChaveParaUsarPix()
                .tocarPrecisoDaChaveParaUsarPix()

                .metodoValidacaoDePerguntas();
    }
}
