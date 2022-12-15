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
     * Método que seleciona o botão 'Transferência' no meu inicial do Pix
     * @throws Exception
     */
    public void selecionarTransferir() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoTransferir();
    }

    /**
     * Método que seleciona o botão 'Extratos E Comprovantes' no meu inicial do Pix
     * @throws Exception
     */
    public void selecionarExtratosEComprovantes() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoExtratosEComprovantes();
    }

    /**
     * Método que seleciona o botão 'Contato pix' no menu inicial do Pix
     * @throws Exception
     */
    public void selecionarContatoPix() throws Exception {
        new PixTela(getDriver())
                .tocarBotaoContatoPix();
    }
}
