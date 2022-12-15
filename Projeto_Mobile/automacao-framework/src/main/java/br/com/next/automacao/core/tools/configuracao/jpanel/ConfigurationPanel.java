package br.com.next.automacao.core.tools.configuracao.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * O Configuration Panel contém as definições dos inputs/botões no Jpanel com suas respectivas posições
 * e criação do popup de informação com duração definida por cada método que o chama.
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class ConfigurationPanel extends JFrame {

    JPanel panel = new JPanel(new GridBagLayout());

    public void createFieldsInformation(GridBagConstraints constraints, int positionGridY, JLabel labelValue, JTextField textValue) {

        constraints.gridx = 0;
        constraints.gridy = positionGridY;
        this.panel.add(labelValue, constraints);

        // coloca a pergunta se é Next ou Consultoria, caso venha nulo é para o panel de validação
        // que conta somente com os check de seleção
        if (textValue != null) {
            constraints.gridx = 1;
            this.panel.add(textValue, constraints);
        }

    }

    public void createButton(GridBagConstraints constraints, int positionGridY, int width, JButton labelButton) {
        constraints.gridx = 0;
        constraints.gridy = positionGridY;
        constraints.gridwidth = width;
        constraints.anchor = GridBagConstraints.CENTER;
        this.panel.add(labelButton, constraints);
    }

    public JPanel createBorder(String textBorderPanel) {
        this.panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), textBorderPanel));
        return this.panel;
    }

    public JRadioButton createRadioButton(GridBagConstraints constraints, String textOption2, boolean positionGridX) {

        if (positionGridX) {
            constraints.gridx = 1;
        } else {
            constraints.gridy = 1;
        }

        JRadioButton option = new JRadioButton(textOption2);
        option.setMnemonic(KeyEvent.VK_B);
        option.setActionCommand(textOption2);
        panel.add(option, constraints);
        return option;
    }

    public static void popupInformation(String message, String messageDuration, int duration) {

        final JOptionPane optionPane = new JOptionPane(message + "\n" + messageDuration,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null, new Object[]{}, null);
        final JDialog dialog = new JDialog();
        dialog.setTitle("Carregando");
        dialog.setModal(true);

        dialog.setContentPane(optionPane);
        dialog.setLocation(400,500);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();

        Timer timer = new Timer(duration, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);

        timer.start();

        dialog.setVisible(true);
    }

    public static void popupTextArea(String mensagem, String title) {

        JTextArea textArea = new JTextArea(20, 30);
        textArea.setText(mensagem);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);

        JOptionPane.showMessageDialog(null, new JScrollPane(textArea),
                title, JOptionPane.INFORMATION_MESSAGE);
    }

}
