package br.com.next.automacao.core.tools.configuracao.createfile;

import br.com.next.automacao.core.tools.configuracao.jpanel.ConfigurationPanel;
import br.com.next.automacao.core.tools.configuracao.jpanel.FieldsPanel;
import br.com.next.automacao.core.tools.configuracao.validator.ValidateConfigurations;
import org.apache.commons.codec.binary.Base64;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * O Create Properties Panel faz criação do painel com os campos a serem preenchidos
 * no arquivo configuracao.properties, validando se todos os campos estão preenchidos
 * e invocando a validação para verificar os dados
 * inseridos.
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class CreatePropertiesPanel extends JFrame {

    private final ConfigurationPanel configurationJpanel = new ConfigurationPanel();

    public CreatePropertiesPanel() {
        super("Preenchimento dos dados");
        this.createPanelConfigurationProperties();
    }

    private void createPanelConfigurationProperties() {

        // create a new panel with GridBagLayout manager
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 30, 10, 30);

        this.configurationPanelFields(constraints);
        this.dataForConfigurationProperties();

        var panel = this.configurationJpanel.createBorder("Insira as informacoes e clique enviar para gerar o seu arquivo de configuracao");

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void dataForConfigurationProperties() {

        FieldsPanel.buttonSend.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (isNotEmptyFields()) {

                    var passwordEmailJira = Base64.encodeBase64(String.valueOf(FieldsPanel.textPasswordJira.getPassword()).getBytes());
                    var passwordKeyM = Base64.encodeBase64(String.valueOf(FieldsPanel.textPasswordKeyM.getPassword()).getBytes());

                    FileProperties configureFileProperties = new FileProperties(FieldsPanel.textEmailJira.getText(), passwordEmailJira, FieldsPanel.textKeyM.getText(), passwordKeyM);
                    configureFileProperties.setValueNextConsultancy(FieldsPanel.valueNextAndConsultancy.toUpperCase());
                    try {
                        configureFileProperties.fillPropertiesWithValues();
                        ConfigurationPanel.popupInformation("Inicando validacao do arquivo criado", "", 5000);

                        //fecha o painel e inicia a validação
                        CreatePropertiesPanel.this.dispose();
                        ValidateConfigurations.execute();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Mensagem de erro: \n" + ex.getMessage(), "ERRO NA REQUISICAO ", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "É necessario que preencha todos os campos", "ATENCAO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void fieldsTypeConfiguration(GridBagConstraints constraints) {

        var optionRadioButton = this.configurationJpanel.createRadioButton(constraints, FieldsPanel.TYPE_CONFIGURATION_NEXT, true);
        var optionRadioButton2 = this.configurationJpanel.createRadioButton(constraints, FieldsPanel.TYPE_CONFIGURATION_CONSULTANCY, false);

        ButtonGroup group = new ButtonGroup();
        group.add(optionRadioButton);
        group.add(optionRadioButton2);

        RadioActionListener listener = new RadioActionListener();

        //Register a listener for the radio buttons.
        optionRadioButton.addActionListener(listener);
        optionRadioButton2.addActionListener(listener);

        this.configurationJpanel.createFieldsInformation(constraints, 0, FieldsPanel.labelNextConsultancy, null);

    }

    private static class RadioActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FieldsPanel.valueNextAndConsultancy = e.getActionCommand();
        }
    }

    private void configurationPanelFields(GridBagConstraints constraints) {

        this.fieldsTypeConfiguration(constraints);

        this.configurationJpanel.createFieldsInformation(constraints, 2, FieldsPanel.labelEmailJira, FieldsPanel.textEmailJira);
        this.configurationJpanel.createFieldsInformation(constraints, 3, FieldsPanel.labelPasswordJira, FieldsPanel.textPasswordJira);
        this.configurationJpanel.createFieldsInformation(constraints, 4, FieldsPanel.labelKeyM, FieldsPanel.textKeyM);
        this.configurationJpanel.createFieldsInformation(constraints, 5, FieldsPanel.labelPasswordKeyM, FieldsPanel.textPasswordKeyM);

        this.configurationJpanel.createButton(constraints, 6, 6, FieldsPanel.buttonSend);

    }

    private boolean isNotEmptyFields() {

        return !FieldsPanel.valueNextAndConsultancy.isEmpty() &&
                !FieldsPanel.textEmailJira.getText().isEmpty() &&
                FieldsPanel.textPasswordJira.getPassword().length > 0 &&
                !FieldsPanel.textKeyM.getText().isEmpty() &&
                FieldsPanel.textPasswordKeyM.getPassword().length > 0;

    }

    public static void execute() throws IOException {
        // aparência
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreatePropertiesPanel().setVisible(true);
            }
        });

    }


}
