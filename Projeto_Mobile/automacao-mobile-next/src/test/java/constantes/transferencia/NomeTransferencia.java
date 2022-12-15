package constantes.transferencia;

public enum NomeTransferencia {

    NOME_TRANSFERENCIA("TRANSFERENCIA"),
    NOME_ALEATORIO_TIMESTAMP("TRANSF " + System.currentTimeMillis()),
    NOME_TRANSFERENCIA_TED("Transferencia TED"),
    NOME_TRANSFERENCIA_DOC("Transferencia DOC"),
    NOME_TRANSFERENCIA_ACENTUACAO("Transferência com acento"),
    NAO_PREENCHER(null);

    private String nome;

    NomeTransferencia(String nome) {
       this.nome = nome;
    }


    public String recuperarNome() {
        return this.nome;
    }

}
