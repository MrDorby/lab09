package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller = new SimpleController();

    public SimpleGUI(){
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(900, 600);

        final JPanel panel = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();

        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.NORTH);

        final JButton print = new JButton("Print");
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.print(textField.getText());
                controller.setNextString(textField.getText());
            }
        });

        final JButton showHistory = new JButton("Show History");
        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> list = controller.getHistoryList();
                for (String string : list) {
                    textArea.append(string + ", ");    
                }
                textArea.append(".\n");
            }
        });

        final JPanel panelButton = new JPanel();
        panelButton.add(print);
        panelButton.add(showHistory);

        panel.add(panelButton, BorderLayout.SOUTH);
        this.frame.getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI();
        gui.frame.setVisible(true);
    }

}
