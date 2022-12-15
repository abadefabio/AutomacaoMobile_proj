package constantes.frontend.anotacoes;

public enum AlertaModalRetornar {

    /**
     * Texto do alerta quando clicar em retornar do modal
     */
    ALERTA_MODAL_RETORNAR("As informa��es inseridas ser�o perdidas, deseja continuar?");

    /**
     * Valor a ser preenchido pelo enumerador
     */
    private String value;

    /**
     * Construtor da classe AlertaModalRetornar
     *
     * @param value Intancia a vari�vel value com o valor do enumerador
     */
    AlertaModalRetornar(String value){
        this.value = value;
    }

    /**
     * M�todo respons�vel por retornar o texto de um enumerador
     *
     * @return Retorna o valor do enumerador
     */
    @Override
    public String toString() {
        return this.value;
    }
}
