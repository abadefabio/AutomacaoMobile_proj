package constantes.pagamentos;

public enum TipoConta {

    CONTA_CORRENTE,
    CONTA_POUPANCA;

    public static TipoConta recuperar(String conta) throws Exception {
        switch(conta.toLowerCase()){
            case "conta-corrente":
            case "corrente":
            case "conta corrente":
            case "conta_corrente":
                return CONTA_CORRENTE;
            case "conta-poupan�a":
            case "poupan�a":
            case "conta_poupan�a":
            case "conta poupan�a":
                return CONTA_POUPANCA;
            default:
                throw new Exception("O tipo de conta: \"" + conta + "\" n�o � reconhecido");
        }
    }

}
