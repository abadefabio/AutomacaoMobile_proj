package funcionalidade.mobile.pix;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.jornadas.pix.minhas.chaves.MinhasChavesTela;

public class ExcluirChavePixFunc extends FuncionalidadeBase {

    /**
     * Excluir chave Pix pendente
     *
     * @param chave
     * @throws Exception
     */
    public void excluirChavePixPendente(String chave, boolean chaveAtiva) throws Exception {
        new MinhasChavesTela(getDriver())
                .tocarAbaPendentes();
        excluirChavePix(chave, chaveAtiva);
    }

    /**
     * Excluir chave Pix
     *
     * @param chave
     * @throws Exception
     */
    public void excluirChavePix(String chave, boolean chaveAtiva) throws Exception {
        new MinhasChavesTela(getDriver())
                .tocarBotaoExcluirChave(chave, chaveAtiva);
        if (!chaveAtiva) {
            new MinhasChavesTela(getDriver())
                    .tocarBotaoSimCancelarPortabilidade();
        } else {
            new MinhasChavesTela(getDriver())
                    .tocarBotaoSimRemover();
        }
        new MinhasChavesTela(getDriver())
                .tocarBotaoOK();
    }

    /**
     * Validar exclusão de chave
     *
     * @param descricaoChave
     * @throws Exception
     */
    public void validarExclusaoDeChave(String descricaoChave) {
        new MinhasChavesTela(getDriver())
                .validarExclusaoChaveAleatoria(descricaoChave);
    }
}
