package constantes.nextJoy;

public interface ConfigMultibanco {

    /*
    Somente CPFs com atÈ este n?mero de dependentes poder„o ser
    selecionados para a ades„o do dependente.
     */
    int MAX_DEPENDENTES_CPF_MULTIBANK = 4;

    /*
    Intervalo entre as tentativas de efetuar uma consulta no banco
    para a verificaÁ„o do status de onboarding do dependente.
     */
    int TEMPO_ENTRE_TENTATIVAS_VERIFICACAO_ONBOARDING_SEGS = 3;
}
