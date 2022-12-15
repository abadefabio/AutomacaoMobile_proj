package constantes.adesao;

public enum LocalNascimento {

   ACRELANDIA("AC-ACRELANDIA");

    private String value;

    LocalNascimento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

