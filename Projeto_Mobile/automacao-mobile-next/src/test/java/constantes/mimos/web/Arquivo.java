package constantes.mimos.web;

public enum Arquivo {

    IMAGEM_URANUS_2("C:\\Users\\Public\\Documents\\next_ProjMobile\\src\\test\\resources\\config\\png-Uranus2.png"),
    CSV_VOUCHER_18("C:\\Users\\Public\\Documents\\next_ProjMobile\\src\\test\\resources\\Tab_Voucher - 18.csv");

    private String value;

    Arquivo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
