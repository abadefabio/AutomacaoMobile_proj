package br.com.next.automacao.core.tools.geradores;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;

public class BaseMassaFunc {

    protected boolean offline = false;

    /**
     * Método para definir que a massa está sendo gerada para armazenamento offline
     * Define apenas como true uma única vez.
     */
    public void setOffline() {
        offline = true;
    }

    /**
     * Método que retorna se a massa está para ser gerada offline ou online durante a execução do teste
     * @return
     */
    public boolean isOffline() {
        return offline;
    }

    /**
     * Método que lança uma exceção, mas somente se estiver rodando offline
     * de modo a não gerar um arquivo json que seria uma cópia do json do projeto.
     * O uso ideal é quando o MassaQA não utiliza o portal de modo algum,
     * servindo apenas realizar uma subseleção no json, por ambiente ou plataforma.
     * @param e
     */
    public void lancarErroSeOffline(Exception e) {
        if(offline)
            throw (RuntimeException) e;
    }

    /**
     * Utilizar este método para substituir pausas com Thread.sleep(),
     * apenas quando esta for a única ou última pausa na geração de massas.
     * @param tempo
     */
    public void pausarSeOnlineSomente(long tempo) {
        if (!offline)
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
