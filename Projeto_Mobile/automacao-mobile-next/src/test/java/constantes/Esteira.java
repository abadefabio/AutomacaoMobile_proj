package constantes;

public enum Esteira {

    SIT("SIT"),
    TI_B("ti-lado-b");

    private String value;

    Esteira(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
