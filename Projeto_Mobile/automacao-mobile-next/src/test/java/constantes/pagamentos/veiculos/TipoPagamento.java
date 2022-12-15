package constantes.pagamentos.veiculos;

public enum TipoPagamento {


    TRANSFERENCIA ("Transferência"),
    CRV_2VIAS ("CRV 2 Via"),
    DEBITOS_PENDENTES ("Débitos Pendentes"),
    IPVA_ATUAL ("IPVA Atual"),
    TRANSACAO_REPETIDA ("TRANSACAO_REPETIDA"),
    IPVA_ANTERIORES ("IPVA Anteriores"),
    DPVAT_ATUAL ("DPVAT Atual"),
    DPVAT_ANTERIORES ("DPVAT_Anteriores"),
    MULTAS ("Multas"),
    MULTAS_OUTROS_ESTADOS ("Multas Outros Estados"),
    LICENCIAMENTO ("Licenciamento"),
    LICENCIAMENTO_REPETIDO("Licenciamento");

    private String valor;

    TipoPagamento(String valor){
        this.valor = valor;
    }

    @Override
    public String toString(){
        return this.valor;
    }
}
