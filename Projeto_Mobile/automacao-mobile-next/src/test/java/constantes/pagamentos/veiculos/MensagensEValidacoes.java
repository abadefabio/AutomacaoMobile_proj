package constantes.pagamentos.veiculos;

public enum MensagensEValidacoes {

    PREENCHA_DADOS_PAGEMENTO("Preencha os dados de pagamento abaixo"),
    TELA_PAGAMENTOS("PAGAMENTOS"),
    TIPO_DE_DEBITO("ESCOLHA O TIPO DE D�BITO"),
    AVISO_IMPORTANTE("A emiss�o do licenciamento agora � digital.");

private String value;

        MensagensEValidacoes(String value){
        this.value = value;

        }

        @Override
        public String toString(){
        return this.value;

        }
}
