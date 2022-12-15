package br.com.next.automacao.core.tools.planilha;

import br.com.next.automacao.core.tools.dados.ResumoTestes;

public interface RelatorioTestes extends Relatorio{

    RelatorioScript escreverResumoConjuntoTestes(ResumoTestes resumo);

    RelatorioScript escreverResumoConjuntosTestes(Object[] resumos);
}
