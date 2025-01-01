import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingComponentsDemo {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Components Demo");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // JLabel
        JLabel label = new JLabel("Enter your name:");
        frame.add(label);

        // JTextField
        JTextField textField = new JTextField(15);
        frame.add(textField);

        // JButton
        JButton button = new JButton("Submit");
        frame.add(button);

        // JCheckBox
        JCheckBox checkBox = new JCheckBox("Subscribe to newsletter");
        frame.add(checkBox);

        // JRadioButton
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        frame.add(maleButton);
        frame.add(femaleButton);

        // JComboBox
        String[] languages = {"Java", "Python", "C++", "JavaScript"};
        JComboBox<String> comboBox = new JComboBox<>(languages);
        frame.add(comboBox);

        // JList
        String[] hobbies = {"Reading", "Traveling", "Gaming", "Cooking"};
        JList<String> list = new JList<>(hobbies);
        list.setVisibleRowCount(3);
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);

        // JTextArea
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane textScrollPane = new JScrollPane(textArea);
        frame.add(textScrollPane);

        // Button event handling
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder result = new StringBuilder();
                result.append("Name: ").append(textField.getText()).append("\n");
                if (checkBox.isSelected()) {
                    result.append("Subscribed to newsletter\n");
                }
                if (maleButton.isSelected()) {
                    result.append("Gender: Male\n");
                } else if (femaleButton.isSelected()) {
                    result.append("Gender: Female\n");
                }
                result.append("Favorite Language: ").append(comboBox.getSelectedItem()).append("\n");
                result.append("Hobbies: ");
                for (String hobby : list.getSelectedValuesList()) {
                    result.append(hobby).append(" ");
                }
                result.append("\nAdditional Notes: ").append(textArea.getText());

                JOptionPane.showMessageDialog(frame, result.toString(), "Submitted Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Set the frame to visible
        frame.setVisible(true);
    }
}
