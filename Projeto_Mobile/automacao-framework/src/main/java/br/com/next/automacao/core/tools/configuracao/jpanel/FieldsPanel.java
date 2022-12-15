package br.com.next.automacao.core.tools.configuracao.jpanel;

import javax.swing.*;

/**
 * O Fileds Panel contem as perguntas e informacoes que sao colocadas
 * nos Paineis de criacao do arquivo de configuracao e de informacao sobre a validacao .
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class FieldsPanel {

    public static final String TYPE_CONFIGURATION_NEXT = "Next";
    public static final String TYPE_CONFIGURATION_CONSULTANCY = "Consultoria";
    public static final String SELECT_CREATE_FILE_CONFIGURATION = "Criar arquivo de configuracao";
    public static final String SELECT_VALIDATION_FILE_CONFIGURATION = "Validar informacoes do arquivo configuracoes.properties";

    public static JLabel labelNextConsultancy = new JLabel("Next ou Consultoria ? ");
    public static String valueNextAndConsultancy = "";

    public static JLabel labelEmailJira = new JLabel("Qual seu email do Jira ? ");
    public static JTextField textEmailJira = new JTextField(20);

    public static JLabel labelPasswordJira = new JLabel("Qual sua senha do Jira ? ");
    public static JPasswordField textPasswordJira = new JPasswordField(20);

    public static JLabel labelKeyM = new JLabel("Qual sua chave M ? ");
    public static JTextField textKeyM = new JTextField(20);

    public static JLabel labelPasswordKeyM = new JLabel("Qual sua senha da chave M ? ");
    public static JPasswordField textPasswordKeyM = new JPasswordField(20);

    public static JButton buttonSend = new JButton("Enviar dados");
    public static JButton buttonOptionSelected = new JButton("Ok");

    public static String valueCreateValidate = "";

}
