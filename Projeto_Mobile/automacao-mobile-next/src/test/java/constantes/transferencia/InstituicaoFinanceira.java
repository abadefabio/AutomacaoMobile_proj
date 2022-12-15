package constantes.transferencia;

public enum InstituicaoFinanceira {

    INTER("BANCO INTERMEDIUM S.A."),
    NU_PAGAMENTOS("NU PAGAMENTOS S.A."),
    BRADESCARD("BANCO BRADESCARD S.A"),
    SANTANDER("BANCO SANTANDER (BRASIL) S.A."),
    BRADESCO("BANCO BRADESCO S.A.");

    private String value;

    InstituicaoFinanceira(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
