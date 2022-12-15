package constantes.adesao;

public enum PaisNascimento {

   BRASIL("BRASIL");

    private String value;

    PaisNascimento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

