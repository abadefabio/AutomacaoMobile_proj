package funcionalidade.mobile.pix;

import pagina.mobile.jornadas.pix.PixTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class PixFunc {

    /**
     * Validar Tela Inicial PIX
     */
    public void validarTelaInicialPix() {
        new PixTela(getDriver())
                .validarTelaPix();
    }

    /**
     * M�todo que seleciona o bot�o 'Transfer�ncia' no meu inicial do Pix
     * @throws Exception
     */
    public void selecionarTransferir() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoTransferir();
    }

    /**
     * M�todo que seleciona o bot�o 'Extratos E Comprovantes' no meu inicial do Pix
     * @throws Exception
     */
    public void selecionarExtratosEComprovantes() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoExtratosEComprovantes();
    }

    /**
     * M�todo que seleciona o bot�o 'Contato pix' no menu inicial do Pix
     * @throws Exception
     */
    public void selecionarContatoPix() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoContatoPix();
    }
}
