package br.com.next.automacao.core.tools.configuracao.jpanel;

import br.com.next.automacao.core.tools.configuracao.createfile.CreatePropertiesPanel;
import br.com.next.automacao.core.tools.configuracao.validator.ValidateConfigurations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * O Panel Select Information faz criação dos paineis de
 * informação sobre a validação dos dados inseridos.
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class PanelSelectInformation extends JFrame {

    private final ConfigurationPanel configurationJpanel = new ConfigurationPanel();

    public PanelSelectInformation() {
        super("O que voce deseja fazer?");
        this.createPanelSelectInformation();
    }

    private void createPanelSelectInformation() {

//         create a new panel with GridBagLayout manager
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 30, 10, 30);

        var panel = this.configurationJpanel.createBorder("Selecione uma informacao");

        this.configurationSelectInformation(constraints);

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void configurationSelectInformation(GridBagConstraints constraints) {

        var optionRadioButtonInformationCreate = this.configurationJpanel.createRadioButton(constraints, FieldsPanel.SELECT_CREATE_FILE_CONFIGURATION, true);
        var optionRadioButtonInformationValidate = this.configurationJpanel.createRadioButton(constraints, FieldsPanel.SELECT_VALIDATION_FILE_CONFIGURATION, false);

        ButtonGroup group = new ButtonGroup();
        group.add(optionRadioButtonInformationCreate);
        group.add(optionRadioButtonInformationValidate);

        RadioActionListener listener = new RadioActionListener();

        //Register a listener for the radio buttons.
        optionRadioButtonInformationCreate.addActionListener(listener);
        optionRadioButtonInformationValidate.addActionListener(listener);


        //Group the radio buttons.
        this.configurationJpanel.createButton(constraints, 6, 6, FieldsPanel.buttonOptionSelected);
    }

    public class RadioActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FieldsPanel.valueCreateValidate = e.getActionCommand().toUpperCase();
            try {
                if (FieldsPanel.valueCreateValidate.contains("CRIAR")) {
                    PanelSelectInformation.this.dispose();
                    CreatePropertiesPanel.execute();

                } else {
                    ValidateConfigurations.execute();
                    PanelSelectInformation.this.dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Mensagem de erro: \n" +
                        ex.getMessage(), "ERRO NA REQUISICAO ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void execute(String[] args) {
        // aparência
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelSelectInformation().setVisible(true);
            }
        });

    }
}
