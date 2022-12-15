package constantes.transferencia;

public enum TipoTransferencia {
    DOC,
    TED,
    INTERNA,
    DEFAULT,    // quando aceita o tipo padrão que aparecer na tela (o próprio TED)
    INTERNO;

    private TipoTransferencia(){
    }
}
