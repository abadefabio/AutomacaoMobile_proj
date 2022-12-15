package constantes.massa.transferencia;

public enum DadosEmail {

    EMAIL_TESTE("teste@teste.com");

    private String value;

    DadosEmail(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
