package br.com.next.automacao.core.tools.planilha;

import br.com.next.automacao.core.tools.dados.ResumoSuite;

public interface RelatorioSuite extends Relatorio {


    RelatorioTestes escreverResultadosSuite(ResumoSuite resumo);

}
