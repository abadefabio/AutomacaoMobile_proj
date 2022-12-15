package constantes.login;

/*
Utilizar esta interface apenas para constantes do login comum entre o projeto Mobile
e Contingência.

Para variáveis exclusivas da Contingência, utilizar outras interfaces.
 */


public interface LoginApp {
    String PALAVRA_TELA_LOGIN_CPF = "CPF";
    String PALAVRA_TELA_LOGIN_BOTAOENTRAR = "Entrar";
    String PALAVRA_TELA_INICIAL_REAIS = "R$";
    String[] LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL = new String[] {"R$", "Notifica", "SALDO"};
    String PALAVRA_TELA_RESETCPF_VAMOSLA = "Vamos lá";
    String[] LISTA_PALAVRAS_ICONE_ATALHOS = new String[] {"ATALHOS", "Atalhos"};
    String MENSAGEM_BOAS_VINDAS_PRIMEIRO_ACESSO = "Yeah! Agora você também faz parte do next";
    String[] LISTA_PALAVRAS_ICONES_TELA_LOGIN_JA_LOGADO = new String[]{"ATALHOS", "Atalhos","TOKEN", "Token", "PIX", "Pix"};
}
