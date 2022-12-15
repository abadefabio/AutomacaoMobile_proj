package br.com.next.automacao.core.tools.planilha;

public interface Relatorio {

    String obterCaminhoArquivo(String nomeArquivo);

    Relatorio finalizar();

    void salvar();
}
