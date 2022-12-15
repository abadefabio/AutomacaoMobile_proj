package br.com.next.automacao.core.tools.planilha;

import br.com.next.automacao.core.tools.dados.ResumoScript;

public interface RelatorioScript extends Relatorio{

    Relatorio escreverResultadosScript(ResumoScript resumo);

    Relatorio escreverResultadosScripts(Object[] resumos);

}
