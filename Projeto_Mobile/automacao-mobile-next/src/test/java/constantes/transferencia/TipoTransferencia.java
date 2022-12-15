package constantes.transferencia;

public enum TipoTransferencia {
    DOC,
    TED,
    INTERNA,
    DEFAULT,    // quando aceita o tipo padr�o que aparecer na tela (o pr�prio TED)
    INTERNO;

    private TipoTransferencia(){
    }
}
