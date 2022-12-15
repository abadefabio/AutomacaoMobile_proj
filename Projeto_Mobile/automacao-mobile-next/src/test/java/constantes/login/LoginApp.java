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
    String[] LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL = new String[] {"R$", "Notifica", "SALDO", "Ver mais", "PIX", "pix"};
    String PALAVRA_TELA_RESETCPF_VAMOSLA = "Vamos lá";
    String[] LISTA_PALAVRAS_ICONE_ATALHOS = new String[] {"ATALHOS", "Atalhos"};
    String MENSAGEM_BOAS_VINDAS_PRIMEIRO_ACESSO = "Yeah! Agora você também faz parte do next";
    String[] LISTA_PALAVRAS_TELA_BOAS_VINDAS = new String[]{"Pular", "PULAR"};
    String[] LISTA_PALAVRAS_ICONES_TELA_LOGIN_JA_LOGADO = new String[]{"TOKEN", "Token", "PIX", "Pix"};
    String[] TEXTOS_BOTOES_TELA_INICIAL = new String[]{"JÁ TENHO CONTA", "CRIAR CONTA"};
    String TUDO_CERTO = "Tudo certo!";
    String NEXT_DESEJA_TER_ACESSO_A_CAMERA = "Deseja Ter Acesso à Câmera";
    String PERMITIR_QUE_NEXT_TIRE_FOTOS_E_GRAVE_VIDEOS = "Permitir que Next tire fotos e grave vídeos?";

    String MENSAGEM_USUARIO_OU_SENHA_INVALIDA = "CPF ou senha incorretos";
}
