package br.com.next.automacao.core.tools.geradores;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;

public class BaseMassaFunc {

    protected boolean offline = false;

    /**
     * M�todo para definir que a massa est� sendo gerada para armazenamento offline
     * Define apenas como true uma �nica vez.
     */
    public void setOffline() {
        offline = true;
    }

    /**
     * M�todo que retorna se a massa est� para ser gerada offline ou online durante a execu��o do teste
     * @return
     */
    public boolean isOffline() {
        return offline;
    }

    /**
     * M�todo que lan�a uma exce��o, mas somente se estiver rodando offline
     * de modo a n�o gerar um arquivo json que seria uma c�pia do json do projeto.
     * O uso ideal � quando o MassaQA n�o utiliza o portal de modo algum,
     * servindo apenas realizar uma subsele��o no json, por ambiente ou plataforma.
     * @param e
     */
    public void lancarErroSeOffline(Exception e) {
        if(offline)
            throw (RuntimeException) e;
    }

    /**
     * Utilizar este m�todo para substituir pausas com Thread.sleep(),
     * apenas quando esta for a �nica ou �ltima pausa na gera��o de massas.
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
