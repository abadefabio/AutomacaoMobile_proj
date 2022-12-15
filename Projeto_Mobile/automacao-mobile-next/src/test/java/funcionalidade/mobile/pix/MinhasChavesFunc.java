package funcionalidade.mobile.pix;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.comum.so.ModalCompartilhamentoTela;
import pagina.mobile.jornadas.pix.PixTela;
import pagina.mobile.jornadas.pix.minhas.chaves.MinhasChavesTela;

public class MinhasChavesFunc extends FuncionalidadeBase {

    /**
     * Validar compartilhamento de uma chave
     *
     * @param descricaoChave
     * @throws Exception
     */
    public void validarCompartilhamentoDeChave(String descricaoChave) throws Exception {
        new PixTela(getDriver())
                .tocarAbaReceber()
                .tocarBotaoMinhasChaves();
        new MinhasChavesTela(getDriver())
                .tocarBotaoCompartilharChave(descricaoChave);
        new ModalCompartilhamentoTela(getDriver())
                .validarModalCompartilhamento()
                .fecharModalCompartilhamento();
    }

    /**
     * Validar exclusão de chave
     *
     * @param descricaoChave
     * @throws Exception
     */
    public void validarExclusaoDeChave(String descricaoChave, boolean chaveAtiva) throws Exception {
        new PixTela(getDriver())
                .tocarAbaReceber()
                .tocarBotaoMinhasChaves();
        new MinhasChavesTela(getDriver())
                .tocarBotaoExcluirChave(descricaoChave, chaveAtiva)
                .tocarBotaoSimRemover()
                .validarChaveRemovida()
                .tocarBotaoOK()
                .validarExclusaoChaveAleatoria(descricaoChave);
    }
}
